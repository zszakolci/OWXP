package com.liferay.message.boards.internal.serviceoverride;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.message.boards.kernel.model.MBCategory;
import com.liferay.message.boards.kernel.model.MBCategoryConstants;
import com.liferay.message.boards.kernel.model.MBDiscussion;
import com.liferay.message.boards.kernel.model.MBMessage;
import com.liferay.message.boards.kernel.model.MBMessageConstants;
import com.liferay.message.boards.kernel.model.MBThread;
import com.liferay.message.boards.kernel.service.MBDiscussionLocalService;
import com.liferay.message.boards.kernel.service.MBMessageLocalService;
import com.liferay.message.boards.kernel.service.MBMessageLocalServiceWrapper;
import com.liferay.message.boards.kernel.service.MBStatsUserLocalService;
import com.liferay.message.boards.kernel.service.persistence.MBCategoryPersistence;
import com.liferay.message.boards.kernel.service.persistence.MBMessagePersistence;
import com.liferay.message.boards.kernel.service.persistence.MBThreadPersistence;
import com.liferay.portal.kernel.comment.Comment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.parsers.bbcode.BBCodeTranslatorUtil;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.CompanyPersistence;
import com.liferay.portal.kernel.service.persistence.GroupPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;
import com.liferay.portal.kernel.social.SocialActivityManagerUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.SubscriptionSender;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.messageboards.MBGroupServiceSettings;
import com.liferay.portlet.messageboards.service.permission.MBPermission;
import com.liferay.portlet.messageboards.social.MBActivityKeys;
import com.liferay.portlet.messageboards.util.MBSubscriptionSender;
import com.liferay.portlet.messageboards.util.MBUtil;
import com.liferay.portlet.messageboards.util.MailingListThreadLocal;
import com.liferay.social.kernel.model.SocialActivityConstants;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tamas Molnar
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class MBMessageLocalServiceOverride
	extends MBMessageLocalServiceWrapper {

	public MBMessageLocalServiceOverride() {
		super(null);
	}

	@Override
	public MBMessage updateStatus(
			long userId, long messageId, int status,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		// Message

		MBMessage message = getMessage(messageId);

		int oldStatus = message.getStatus();

		User user = _userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		Date modifiedDate = serviceContext.getModifiedDate(now);

		message.setStatus(status);
		message.setStatusByUserId(userId);
		message.setStatusByUserName(user.getFullName());
		message.setStatusDate(modifiedDate);

		_mbMessagePersistence.update(message);

		// Thread

		MBThread thread = _mbThreadPersistence.findByPrimaryKey(
			message.getThreadId());

		updateThreadStatus(thread, message, user, oldStatus, modifiedDate);

		Indexer<MBMessage> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			MBMessage.class);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			if (oldStatus != WorkflowConstants.STATUS_APPROVED) {

				// Asset

				if (serviceContext.isAssetEntryVisible() &&
					((message.getClassNameId() == 0) ||
					 (message.getParentMessageId() != 0))) {

					Date publishDate = null;

					AssetEntry assetEntry = _assetEntryLocalService.fetchEntry(
						message.getWorkflowClassName(), message.getMessageId());

					if ((assetEntry != null) &&
						(assetEntry.getPublishDate() != null)) {

						publishDate = assetEntry.getPublishDate();
					}
					else {
						publishDate = now;

						serviceContext.setCommand(Constants.ADD);
					}

					_assetEntryLocalService.updateEntry(
						message.getWorkflowClassName(), message.getMessageId(),
						publishDate, null, true, true);
				}

				if (serviceContext.isCommandAdd()) {

					// Social

					JSONObject extraDataJSONObject =
						JSONFactoryUtil.createJSONObject();

					String title = message.getSubject();

					if (message.isDiscussion()) {
						title = HtmlUtil.stripHtml(title);
					}

					extraDataJSONObject.put("title", title);

					if (!message.isDiscussion()) {
						if (!message.isAnonymous() && !user.isDefaultUser()) {
							long receiverUserId = 0;

							MBMessage parentMessage =
								_mbMessagePersistence.fetchByPrimaryKey(
									message.getParentMessageId());

							if (parentMessage != null) {
								receiverUserId = parentMessage.getUserId();
							}

							SocialActivityManagerUtil.addActivity(
								message.getUserId(), message,
								MBActivityKeys.ADD_MESSAGE,
								extraDataJSONObject.toString(), receiverUserId);

							if ((parentMessage != null) &&
								(receiverUserId != message.getUserId())) {

								SocialActivityManagerUtil.addActivity(
									message.getUserId(), parentMessage,
									MBActivityKeys.REPLY_MESSAGE,
									extraDataJSONObject.toString(), 0);
							}
						}
					}
					else {
						String className = (String)serviceContext.getAttribute(
							"className");
						long classPK = ParamUtil.getLong(
							serviceContext, "classPK");
						long parentMessageId = message.getParentMessageId();

						if (parentMessageId !=
								MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {

							AssetEntry assetEntry =
								_assetEntryLocalService.fetchEntry(
									className, classPK);

							if (assetEntry != null) {
								extraDataJSONObject.put(
									"messageId", message.getMessageId());

								SocialActivityManagerUtil.addActivity(
									message.getUserId(), assetEntry,
									SocialActivityConstants.TYPE_ADD_COMMENT,
									extraDataJSONObject.toString(),
									assetEntry.getUserId());
							}
						}
					}
				}
			}

			// Subscriptions

			notifySubscribers(
				userId, (MBMessage)message.clone(),
				(String)workflowContext.get(WorkflowConstants.CONTEXT_URL),
				serviceContext);

			// Indexer

			indexer.reindex(message);
		}
		else if (oldStatus == WorkflowConstants.STATUS_APPROVED) {

			// Asset

			_assetEntryLocalService.updateVisible(
				message.getWorkflowClassName(), message.getMessageId(), false);

			// Indexer

			indexer.delete(message);
		}

		// Statistics

		if (!message.isDiscussion()) {
			_mbStatsUserLocalService.updateStatsUser(
				message.getGroupId(), userId,
				serviceContext.getModifiedDate(now));
		}

		return message;
	}

	protected MBSubscriptionSender getSubscriptionSender(
		long userId, MBMessage message, String messageURL, String entryTitle,
		boolean htmlFormat, String messageBody, String categoryName,
		String inReplyTo, String fromName, String fromAddress,
		String replyToAddress, String emailAddress, String fullName,
		LocalizedValuesMap subjectLocalizedValuesMap,
		LocalizedValuesMap bodyLocalizedValuesMap,
		ServiceContext serviceContext) {

		MBSubscriptionSender subscriptionSender = new MBSubscriptionSender(
			MBPermission.RESOURCE_NAME);

		subscriptionSender.setAnonymous(message.isAnonymous());
		subscriptionSender.setBulk(PropsValues.MESSAGE_BOARDS_EMAIL_BULK);
		subscriptionSender.setClassName(message.getModelClassName());
		subscriptionSender.setClassPK(message.getMessageId());
		subscriptionSender.setCompanyId(message.getCompanyId());
		subscriptionSender.setContextAttribute(
			"[$MESSAGE_BODY$]", messageBody, false);
		subscriptionSender.setContextAttributes(
			"[$CATEGORY_NAME$]", categoryName, "[$MAILING_LIST_ADDRESS$]",
			replyToAddress, "[$MESSAGE_ID$]", message.getMessageId(),
			"[$MESSAGE_SUBJECT$]", entryTitle, "[$MESSAGE_URL$]", messageURL,
			"[$MESSAGE_USER_ADDRESS$]", emailAddress, "[$MESSAGE_USER_NAME$]",
			fullName);
		subscriptionSender.setCurrentUserId(userId);
		subscriptionSender.setEntryTitle(entryTitle);
		subscriptionSender.setEntryURL(messageURL);
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setFullName(fullName);
		subscriptionSender.setHtmlFormat(htmlFormat);
		subscriptionSender.setInReplyTo(inReplyTo);

		if (bodyLocalizedValuesMap != null) {
			subscriptionSender.setLocalizedBodyMap(
				LocalizationUtil.getMap(bodyLocalizedValuesMap));
		}

		if (subjectLocalizedValuesMap != null) {
			subscriptionSender.setLocalizedSubjectMap(
				LocalizationUtil.getMap(subjectLocalizedValuesMap));
		}

		Date modifiedDate = message.getModifiedDate();

		subscriptionSender.setMailId(
			MBUtil.MESSAGE_POP_PORTLET_PREFIX, message.getCategoryId(),
			message.getMessageId(), modifiedDate.getTime());

		int notificationType =
			UserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY;

		if (serviceContext.isCommandUpdate()) {
			notificationType =
				UserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY;
		}

		subscriptionSender.setNotificationType(notificationType);

		String portletId = PortletProviderUtil.getPortletId(
			MBMessage.class.getName(), PortletProvider.Action.VIEW);

		subscriptionSender.setPortletId(portletId);

		subscriptionSender.setReplyToAddress(replyToAddress);
		subscriptionSender.setScopeGroupId(message.getGroupId());
		subscriptionSender.setServiceContext(serviceContext);
		subscriptionSender.setUniqueMailId(false);

		return subscriptionSender;
	}

	protected void notifyDiscussionSubscribers(
			long userId, MBMessage message, ServiceContext serviceContext)
		throws PortalException {

		if (!PrefsPropsUtil.getBoolean(
				message.getCompanyId(),
				PropsKeys.DISCUSSION_EMAIL_COMMENTS_ADDED_ENABLED)) {

			return;
		}

		MBDiscussion mbDiscussion =
			_mbDiscussionLocalService.getThreadDiscussion(
				message.getThreadId());

		String contentURL = (String)serviceContext.getAttribute("contentURL");

		String userAddress = StringPool.BLANK;
		String userName = (String)serviceContext.getAttribute(
			"pingbackUserName");

		if (Validator.isNull(userName)) {
			userAddress = PortalUtil.getUserEmailAddress(message.getUserId());
			userName = PortalUtil.getUserName(
				message.getUserId(), StringPool.BLANK);
		}

		String fromName = PrefsPropsUtil.getString(
			message.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PrefsPropsUtil.getString(
			message.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		String subject = PrefsPropsUtil.getContent(
			message.getCompanyId(), PropsKeys.DISCUSSION_EMAIL_SUBJECT);
		String body = PrefsPropsUtil.getContent(
			message.getCompanyId(), PropsKeys.DISCUSSION_EMAIL_BODY);

		SubscriptionSender subscriptionSender = new SubscriptionSender();

		subscriptionSender.setBody(body);
		subscriptionSender.setCompanyId(message.getCompanyId());
		subscriptionSender.setClassName(MBDiscussion.class.getName());
		subscriptionSender.setClassPK(mbDiscussion.getDiscussionId());
		subscriptionSender.setContextAttribute(
			"[$COMMENTS_BODY$]", message.getBody(true), false);
		subscriptionSender.setContextAttributes(
			"[$COMMENTS_USER_ADDRESS$]", userAddress, "[$COMMENTS_USER_NAME$]",
			userName, "[$CONTENT_URL$]", contentURL);
		subscriptionSender.setCurrentUserId(userId);
		subscriptionSender.setEntryTitle(message.getBody());
		subscriptionSender.setEntryURL(contentURL);
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);

		Date modifiedDate = message.getModifiedDate();

		subscriptionSender.setMailId(
			"mb_discussion", message.getCategoryId(), message.getMessageId(),
			modifiedDate.getTime());

		int notificationType =
			UserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY;

		if (serviceContext.isCommandUpdate()) {
			notificationType =
				UserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY;
		}

		subscriptionSender.setNotificationType(notificationType);

		String portletId = PortletProviderUtil.getPortletId(
			Comment.class.getName(), PortletProvider.Action.VIEW);

		subscriptionSender.setPortletId(portletId);

		subscriptionSender.setScopeGroupId(message.getGroupId());
		subscriptionSender.setServiceContext(serviceContext);
		subscriptionSender.setSubject(subject);
		subscriptionSender.setUniqueMailId(false);

		String className = (String)serviceContext.getAttribute("className");
		long classPK = ParamUtil.getLong(serviceContext, "classPK");

		subscriptionSender.addPersistedSubscribers(className, classPK);

		subscriptionSender.flushNotificationsAsync();
	}

	protected void notifySubscribers(
			long userId, MBMessage message, String messageURL,
			ServiceContext serviceContext)
		throws PortalException {

		if (!message.isApproved() || Validator.isNull(messageURL)) {
			return;
		}

		if (message.isDiscussion()) {
			try {
				notifyDiscussionSubscribers(userId, message, serviceContext);
			}
			catch (Exception e) {
				_log.error(e, e);
			}

			return;
		}

		MBGroupServiceSettings mbGroupServiceSettings =
			MBGroupServiceSettings.getInstance(message.getGroupId());

		if (serviceContext.isCommandAdd() &&
			mbGroupServiceSettings.isEmailMessageAddedEnabled()) {
		}
		else if (serviceContext.isCommandUpdate() &&
				 mbGroupServiceSettings.isEmailMessageUpdatedEnabled()) {
		}
		else {
			return;
		}

		Company company = _companyPersistence.findByPrimaryKey(
			message.getCompanyId());

		Group group = _groupPersistence.findByPrimaryKey(message.getGroupId());

		User user = _userPersistence.findByPrimaryKey(userId);

		String emailAddress = user.getEmailAddress();
		String fullName = user.getFullName();

		if (message.isAnonymous()) {
			emailAddress = StringPool.BLANK;
			fullName = serviceContext.translate("anonymous");
		}

		MBCategory category = message.getCategory();

		String categoryName = category.getName();

		if (category.getCategoryId() ==
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {

			categoryName = serviceContext.translate("message-boards-home");

			categoryName += " - " + group.getDescriptiveName();
		}

		List<Long> categoryIds = new ArrayList<>();

		categoryIds.add(message.getCategoryId());

		if (message.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {

			categoryIds.addAll(category.getAncestorCategoryIds());
		}

		String entryTitle = message.getSubject();

		String fromName = mbGroupServiceSettings.getEmailFromName();
		String fromAddress = mbGroupServiceSettings.getEmailFromAddress();

		String replyToAddress = StringPool.BLANK;

		if (PropsValues.POP_SERVER_NOTIFICATIONS_ENABLED) {
			replyToAddress = MBUtil.getReplyToAddress(
				message.getCategoryId(), message.getMessageId(),
				company.getMx(), fromAddress);
		}

		LocalizedValuesMap subjectLocalizedValuesMap = null;
		LocalizedValuesMap bodyLocalizedValuesMap = null;

		if (serviceContext.isCommandUpdate()) {
			subjectLocalizedValuesMap =
				mbGroupServiceSettings.getEmailMessageUpdatedSubject();
			bodyLocalizedValuesMap =
				mbGroupServiceSettings.getEmailMessageUpdatedBody();
		}
		else {
			subjectLocalizedValuesMap =
				mbGroupServiceSettings.getEmailMessageAddedSubject();
			bodyLocalizedValuesMap =
				mbGroupServiceSettings.getEmailMessageAddedBody();
		}

		boolean htmlFormat = mbGroupServiceSettings.isEmailHtmlFormat();

		String messageBody = message.getBody();

		if (htmlFormat && message.isFormatBBCode()) {
			try {
				messageBody = BBCodeTranslatorUtil.getHTML(messageBody);

				HttpServletRequest request = serviceContext.getRequest();

				if (request != null) {
					ThemeDisplay themeDisplay =
						(ThemeDisplay)request.getAttribute(
							WebKeys.THEME_DISPLAY);

					messageBody = MBUtil.replaceMessageBodyPaths(
						themeDisplay, messageBody);
				}
			}
			catch (Exception e) {
				_log.error(
					"Could not parse message " + message.getMessageId() + " " +
						e.getMessage());
			}
		}

		String inReplyTo = null;

		if (message.getParentMessageId() !=
				MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {

			MBMessage parentMessage = _mbMessageLocalService.getMessage(
				message.getParentMessageId());

			Date modifiedDate = parentMessage.getModifiedDate();

			inReplyTo = PortalUtil.getMailId(
				company.getMx(), MBUtil.MESSAGE_POP_PORTLET_PREFIX,
				message.getCategoryId(), parentMessage.getMessageId(),
				modifiedDate.getTime());
		}

		SubscriptionSender subscriptionSender = getSubscriptionSender(
			userId, message, messageURL, entryTitle, htmlFormat, messageBody,
			categoryName, inReplyTo, fromName, fromAddress, replyToAddress,
			emailAddress, fullName, subjectLocalizedValuesMap,
			bodyLocalizedValuesMap, serviceContext);

		subscriptionSender.addPersistedSubscribers(
			MBCategory.class.getName(), message.getGroupId());

		for (long categoryId : categoryIds) {
			if (categoryId != MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {
				subscriptionSender.addPersistedSubscribers(
					MBCategory.class.getName(), categoryId);
			}
		}

		subscriptionSender.addPersistedSubscribers(
			MBThread.class.getName(), message.getThreadId());

		subscriptionSender.flushNotificationsAsync();

		if (!MailingListThreadLocal.isSourceMailingList()) {
			for (long categoryId : categoryIds) {
				MBSubscriptionSender sourceMailingListSubscriptionSender =
					getSubscriptionSender(
						userId, message, messageURL, entryTitle, htmlFormat,
						messageBody, categoryName, inReplyTo, fromName,
						fromAddress, replyToAddress, emailAddress, fullName,
						subjectLocalizedValuesMap, bodyLocalizedValuesMap,
						serviceContext);

				sourceMailingListSubscriptionSender.setBulk(false);

				sourceMailingListSubscriptionSender.addMailingListSubscriber(
					message.getGroupId(), categoryId);

				sourceMailingListSubscriptionSender.flushNotificationsAsync();
			}
		}
	}

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}

	@Reference(unbind = "-")
	protected void setCompanyPersistence(
		CompanyPersistence companyPersistence) {

		_companyPersistence = companyPersistence;
	}

	@Reference(unbind = "-")
	protected void setGroupPersistence(GroupPersistence groupPersistence) {
		_groupPersistence = groupPersistence;
	}

	@Reference(unbind = "-")
	protected void setMBCategoryPersistence(
		MBCategoryPersistence mbCategoryPersistence) {

		_mbCategoryPersistence = mbCategoryPersistence;
	}

	@Reference(unbind = "-")
	protected void setMBDiscussionLocalService(
		MBDiscussionLocalService mbDiscussionLocalService) {

		_mbDiscussionLocalService = mbDiscussionLocalService;
	}

	@Reference(unbind = "-")
	protected void setMBMessageLocalService(
		MBMessageLocalService mbMessageLocalService) {

		_mbMessageLocalService = mbMessageLocalService;
	}

	@Reference(unbind = "-")
	protected void setMBMessagePersistence(
		MBMessagePersistence mbMessagePersistence) {

		_mbMessagePersistence = mbMessagePersistence;
	}

	@Reference(unbind = "-")
	protected void setMBStatsUserLocalService(
		MBStatsUserLocalService mbStatsUserLocalService) {

		_mbStatsUserLocalService = mbStatsUserLocalService;
	}

	@Reference(unbind = "-")
	protected void setMBThreadPersistence(
		MBThreadPersistence mbThreadPersistence) {

		_mbThreadPersistence = mbThreadPersistence;
	}

	@Reference(unbind = "-")
	protected void setUserPersistence(UserPersistence userPersistence) {
		_userPersistence = userPersistence;
	}

	protected void updateThreadStatus(
			MBThread thread, MBMessage message, User user, int oldStatus,
			Date modifiedDate)
		throws PortalException {

		MBCategory category = null;

		int status = message.getStatus();

		if ((thread.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
			(thread.getCategoryId() !=
				MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			category = _mbCategoryPersistence.findByPrimaryKey(
				thread.getCategoryId());
		}

		if ((thread.getRootMessageId() == message.getMessageId()) &&
			(oldStatus != status)) {

			thread.setModifiedDate(modifiedDate);
			thread.setStatus(status);
			thread.setStatusByUserId(user.getUserId());
			thread.setStatusByUserName(user.getFullName());
			thread.setStatusDate(modifiedDate);
		}

		if (status == oldStatus) {
			return;
		}

		if (status == WorkflowConstants.STATUS_APPROVED) {
			if (message.isAnonymous()) {
				thread.setLastPostByUserId(0);
			}
			else {
				thread.setLastPostByUserId(message.getUserId());
			}

			thread.setLastPostDate(modifiedDate);

			if (category != null) {
				category.setLastPostDate(modifiedDate);

				category = _mbCategoryPersistence.update(category);
			}
		}

		if ((oldStatus == WorkflowConstants.STATUS_APPROVED) ||
			(status == WorkflowConstants.STATUS_APPROVED)) {

			// Thread

			MBUtil.updateThreadMessageCount(thread.getThreadId());

			// Category

			if ((category != null) &&
				(thread.getRootMessageId() == message.getMessageId())) {

				MBUtil.updateCategoryStatistics(category.getCategoryId());
			}

			if ((category != null) &&
				!(thread.getRootMessageId() == message.getMessageId())) {

				MBUtil.updateCategoryMessageCount(category.getCategoryId());
			}
		}

		// Indexer

		Indexer<MBThread> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			MBThread.class);

		indexer.reindex(thread);

		_mbThreadPersistence.update(thread);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		MBMessageLocalServiceOverride.class);

	private AssetEntryLocalService _assetEntryLocalService;
	private CompanyPersistence _companyPersistence;
	private GroupPersistence _groupPersistence;
	private MBCategoryPersistence _mbCategoryPersistence;
	private MBDiscussionLocalService _mbDiscussionLocalService;
	private MBMessageLocalService _mbMessageLocalService;
	private MBMessagePersistence _mbMessagePersistence;
	private MBStatsUserLocalService _mbStatsUserLocalService;
	private MBThreadPersistence _mbThreadPersistence;
	private UserPersistence _userPersistence;

}
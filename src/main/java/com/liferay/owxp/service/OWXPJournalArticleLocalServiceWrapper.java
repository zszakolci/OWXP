/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.owxp.service;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.journal.configuration.JournalGroupServiceConfiguration;
import com.liferay.journal.configuration.JournalServiceConfigurationValues;
import com.liferay.journal.constants.JournalConstants;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleConstants;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.service.JournalArticleLocalServiceWrapper;
import com.liferay.journal.service.permission.JournalPermission;
import com.liferay.journal.service.persistence.JournalArticlePersistence;
import com.liferay.journal.social.JournalActivityKeys;
import com.liferay.journal.util.comparator.ArticleVersionComparator;
import com.liferay.journal.util.impl.JournalUtil;
import com.liferay.portal.kernel.diff.DiffHtmlUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.PortletRequestModel;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextUtil;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.CompanyPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.settings.GroupServiceSettingsLocator;
import com.liferay.portal.kernel.social.SocialActivityManagerUtil;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GroupSubscriptionCheckSubscriptionSender;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.SubscriptionSender;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tamas Molnar
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class OWXPJournalArticleLocalServiceWrapper
	extends JournalArticleLocalServiceWrapper {

	public OWXPJournalArticleLocalServiceWrapper() {
		super(null);
	}

	@Override
	public JournalArticle moveArticle(
			long groupId, String articleId, long newFolderId,
			ServiceContext serviceContext)
		throws PortalException {

		return super.moveArticle(
			groupId, articleId, newFolderId, serviceContext);
	}

	@Override
	public JournalArticle updateStatus(
			long userId, JournalArticle article, int status, String articleURL,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		// Article

		User user = _userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		if ((status == WorkflowConstants.STATUS_APPROVED) &&
			(article.getClassNameId() ==
				JournalArticleConstants.CLASSNAME_ID_DEFAULT) &&
			(article.getDisplayDate() != null) &&
			now.before(article.getDisplayDate())) {

			status = WorkflowConstants.STATUS_SCHEDULED;
		}

		int oldStatus = article.getStatus();

		Date modifiedDate = serviceContext.getModifiedDate(now);

		article.setModifiedDate(modifiedDate);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			Date expirationDate = article.getExpirationDate();

			if ((expirationDate != null) && expirationDate.before(now)) {
				article.setExpirationDate(null);
			}
		}

		if (status == WorkflowConstants.STATUS_EXPIRED) {
			article.setExpirationDate(now);
		}

		article.setStatus(status);
		article.setStatusByUserId(user.getUserId());
		article.setStatusByUserName(user.getFullName());
		article.setStatusDate(modifiedDate);

		_journalArticlePersistence.update(article);

		if (JournalServiceConfigurationValues.
				JOURNAL_ARTICLE_EXPIRE_ALL_VERSIONS) {

			setArticlesExpirationDate(article);
		}

		if (hasModifiedLatestApprovedVersion(
				article.getGroupId(), article.getArticleId(),
				article.getVersion())) {

			if (status == WorkflowConstants.STATUS_APPROVED) {
				updateUrlTitles(
					article.getGroupId(), article.getArticleId(),
					article.getUrlTitle());

				// Asset

				if ((oldStatus != WorkflowConstants.STATUS_APPROVED) &&
					(article.getVersion() !=
						JournalArticleConstants.VERSION_DEFAULT)) {

					AssetEntry draftAssetEntry =
						_assetEntryLocalService.fetchEntry(
							JournalArticle.class.getName(),
							article.getPrimaryKey());

					if (draftAssetEntry != null) {
						long[] assetCategoryIds =
							draftAssetEntry.getCategoryIds();
						String[] assetTagNames = draftAssetEntry.getTagNames();

						List<AssetLink> assetLinks =
							_assetLinkLocalService.getDirectLinks(
								draftAssetEntry.getEntryId(),
								AssetLinkConstants.TYPE_RELATED, false);

						long[] assetLinkEntryIds = ListUtil.toLongArray(
							assetLinks, AssetLink.ENTRY_ID2_ACCESSOR);

						AssetEntry assetEntry =
							_assetEntryLocalService.updateEntry(
								userId, article.getGroupId(),
								article.getCreateDate(),
								article.getModifiedDate(),
								JournalArticle.class.getName(),
								article.getResourcePrimKey(), article.getUuid(),
								getClassTypeId(article), assetCategoryIds,
								assetTagNames, isListable(article), false, null,
								null, null, ContentTypes.TEXT_HTML,
								article.getTitle(), article.getDescription(),
								article.getDescription(), null,
								article.getLayoutUuid(), 0, 0,
								draftAssetEntry.getPriority());

						_assetLinkLocalService.updateLinks(
							userId, assetEntry.getEntryId(), assetLinkEntryIds,
							AssetLinkConstants.TYPE_RELATED);

						_assetEntryLocalService.deleteEntry(draftAssetEntry);
					}
				}

				if (article.getClassNameId() ==
						JournalArticleConstants.CLASSNAME_ID_DEFAULT) {

					_assetEntryLocalService.updateEntry(
						JournalArticle.class.getName(),
						article.getResourcePrimKey(), article.getDisplayDate(),
						article.getExpirationDate(), isListable(article), true);
				}

				// Social

				JSONObject extraDataJSONObject =
					JSONFactoryUtil.createJSONObject();

				extraDataJSONObject.put("title", article.getTitle());

				if (serviceContext.isCommandUpdate()) {
					SocialActivityManagerUtil.addActivity(
						user.getUserId(), article,
						JournalActivityKeys.UPDATE_ARTICLE,
						extraDataJSONObject.toString(), 0);
				}
				else {
					SocialActivityManagerUtil.addUniqueActivity(
						user.getUserId(), article,
						JournalActivityKeys.ADD_ARTICLE,
						extraDataJSONObject.toString(), 0);
				}
			}
			else if (oldStatus == WorkflowConstants.STATUS_APPROVED) {
				updatePreviousApprovedArticle(article);
			}
		}

		if ((article.getClassNameId() ==
				JournalArticleConstants.CLASSNAME_ID_DEFAULT) &&
			(oldStatus != WorkflowConstants.STATUS_IN_TRASH) &&
			(status != WorkflowConstants.STATUS_IN_TRASH)) {

			// Email

			if ((oldStatus == WorkflowConstants.STATUS_PENDING) &&
				((status == WorkflowConstants.STATUS_APPROVED) ||
				 (status == WorkflowConstants.STATUS_DENIED))) {

				String msg = "granted";

				if (status == WorkflowConstants.STATUS_DENIED) {
					msg = "denied";
				}

				try {
					PortletPreferences preferences =
						ServiceContextUtil.getPortletPreferences(
							serviceContext);

					articleURL = buildArticleURL(
						articleURL, article.getGroupId(), article.getFolderId(),
						article.getArticleId());

					sendEmail(
						article, articleURL, preferences, msg, serviceContext);
				}
				catch (Exception e) {
					_log.error(
						"Unable to send email to notify the change of status " +
							" to " + msg + " for article " + article.getId() +
								": " + e.getMessage());
				}
			}

			// Subscriptions

			String action = "update";

			if (article.getVersion() == 1.0) {
				action = "add";
			}

			notifySubscribers(
				user.getUserId(), article,
				(String)workflowContext.get(WorkflowConstants.CONTEXT_URL),
				action, serviceContext);
		}

		return article;
	}

	protected String buildArticleURL(
		String articleURL, long groupId, long folderId, String articleId) {

		String portletId = PortletProviderUtil.getPortletId(
			JournalArticle.class.getName(), PortletProvider.Action.EDIT);

		String namespace = PortalUtil.getPortletNamespace(portletId);

		articleURL = HttpUtil.addParameter(
			articleURL, namespace + "groupId", groupId);
		articleURL = HttpUtil.addParameter(
			articleURL, namespace + "folderId", folderId);
		articleURL = HttpUtil.addParameter(
			articleURL, namespace + "articleId", articleId);

		return articleURL;
	}

	protected long getClassTypeId(JournalArticle article)
		throws PortalException {

		long classNameId = _classNameLocalService.getClassNameId(
			JournalArticle.class);

		DDMStructure ddmStructure = _ddmStructureLocalService.fetchStructure(
			article.getGroupId(), classNameId, article.getDDMStructureKey(),
			true);

		return ddmStructure.getStructureId();
	}

	protected JournalGroupServiceConfiguration
			getJournalGroupServiceConfiguration(long groupId)
		throws ConfigurationException {

		return _configurationProvider.getConfiguration(
			JournalGroupServiceConfiguration.class,
			new GroupServiceSettingsLocator(
				groupId, JournalConstants.SERVICE_NAME));
	}

	protected boolean hasModifiedLatestApprovedVersion(
		long groupId, String articleId, double version) {

		JournalArticle article = fetchLatestArticle(
			groupId, articleId, WorkflowConstants.STATUS_APPROVED);

		if ((article == null) || (article.getVersion() <= version)) {
			return true;
		}

		return false;
	}

	protected void notifySubscribers(
			long userId, JournalArticle article, String articleURL,
			String action, ServiceContext serviceContext)
		throws PortalException {

		if (!article.isApproved() || Validator.isNull(articleURL)) {
			return;
		}

		JournalGroupServiceConfiguration journalGroupServiceConfiguration =
			getJournalGroupServiceConfiguration(article.getGroupId());

		String articleTitle = article.getTitle(serviceContext.getLanguageId());

		articleURL = buildArticleURL(
			articleURL, article.getGroupId(), article.getFolderId(),
			article.getArticleId());

		if (action.equals("add") &&
			journalGroupServiceConfiguration.emailArticleAddedEnabled()) {
		}
		else if (action.equals("move_to") &&
				 journalGroupServiceConfiguration.
					 emailArticleMovedToFolderEnabled()) {
		}
		else if (action.equals("move_from") &&
				 journalGroupServiceConfiguration.
					 emailArticleMovedFromFolderEnabled()) {
		}
		else if (action.equals("update") &&
				 journalGroupServiceConfiguration.
					 emailArticleUpdatedEnabled()) {
		}
		else {
			return;
		}

		String fromName = journalGroupServiceConfiguration.emailFromName();
		String fromAddress =
			journalGroupServiceConfiguration.emailFromAddress();

		Map<Locale, String> localizedSubjectMap = null;
		Map<Locale, String> localizedBodyMap = null;

		if (action.equals("add")) {
			localizedSubjectMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.emailArticleAddedSubject());
			localizedBodyMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.emailArticleAddedBody());
		}
		else if (action.equals("move_to")) {
			localizedSubjectMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleMovedToFolderSubject());
			localizedBodyMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleMovedToFolderBody());
		}
		else if (action.equals("move_from")) {
			localizedSubjectMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleMovedFromFolderSubject());
			localizedBodyMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleMovedFromFolderBody());
		}
		else if (action.equals("update")) {
			localizedSubjectMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.emailArticleUpdatedSubject());
			localizedBodyMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.emailArticleUpdatedBody());
		}

		String articleContent = StringPool.BLANK;
		String articleDiffs = StringPool.BLANK;

		JournalArticle previousApprovedArticle = getPreviousApprovedArticle(
			article);

		try {
			PortletRequestModel portletRequestModel = new PortletRequestModel(
				serviceContext.getLiferayPortletRequest(),
				serviceContext.getLiferayPortletResponse());

			JournalArticleDisplay articleDisplay = getArticleDisplay(
				article, null, Constants.VIEW,
				LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault()), 1,
				portletRequestModel, serviceContext.getThemeDisplay());

			articleContent = articleDisplay.getContent();

			articleDiffs = JournalUtil.diffHtml(
				article.getGroupId(), article.getArticleId(),
				previousApprovedArticle.getVersion(), article.getVersion(),
				LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault()),
				portletRequestModel, serviceContext.getThemeDisplay());
		}
		catch (Exception e) {
		}

		SubscriptionSender subscriptionSender =
			new GroupSubscriptionCheckSubscriptionSender(
				JournalPermission.RESOURCE_NAME);

		subscriptionSender.setClassName(article.getModelClassName());
		subscriptionSender.setClassPK(article.getId());
		subscriptionSender.setCompanyId(article.getCompanyId());
		subscriptionSender.setContextAttribute(
			"[$ARTICLE_CONTENT$]", articleContent, false);
		subscriptionSender.setContextAttribute(
			"[$ARTICLE_DIFFS$]", DiffHtmlUtil.replaceStyles(articleDiffs),
			false);

		JournalFolder folder = article.getFolder();

		subscriptionSender.setContextAttributes(
			"[$ARTICLE_ID$]", article.getArticleId(), "[$ARTICLE_TITLE$]",
			articleTitle, "[$ARTICLE_URL$]", articleURL, "[$ARTICLE_VERSION$]",
			article.getVersion(), "[$FOLDER_NAME$]", folder.getName());

		subscriptionSender.setContextCreatorUserPrefix("ARTICLE");
		subscriptionSender.setCreatorUserId(article.getUserId());
		subscriptionSender.setCurrentUserId(userId);
		subscriptionSender.setEntryTitle(articleTitle);
		subscriptionSender.setEntryURL(articleURL);
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setLocalizedBodyMap(localizedBodyMap);
		subscriptionSender.setLocalizedSubjectMap(localizedSubjectMap);
		subscriptionSender.setMailId("journal_article", article.getId());

		int notificationType =
			UserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY;

		if (serviceContext.isCommandUpdate()) {
			notificationType =
				UserNotificationDefinition.NOTIFICATION_TYPE_UPDATE_ENTRY;
		}

		subscriptionSender.setNotificationType(notificationType);

		String portletId = PortletProviderUtil.getPortletId(
			JournalArticle.class.getName(), PortletProvider.Action.EDIT);

		subscriptionSender.setPortletId(portletId);

		subscriptionSender.setReplyToAddress(fromAddress);
		subscriptionSender.setScopeGroupId(article.getGroupId());
		subscriptionSender.setServiceContext(serviceContext);

		subscriptionSender.addPersistedSubscribers(
			JournalFolder.class.getName(), article.getGroupId());

		if (folder != null) {
			subscriptionSender.addPersistedSubscribers(
				JournalFolder.class.getName(), folder.getFolderId());

			for (Long ancestorFolderId : folder.getAncestorFolderIds()) {
				subscriptionSender.addPersistedSubscribers(
					JournalFolder.class.getName(), ancestorFolderId);
			}
		}

		DDMStructure ddmStructure = _ddmStructureLocalService.getStructure(
			article.getGroupId(),
			_classNameLocalService.getClassNameId(JournalArticle.class),
			article.getDDMStructureKey(), true);

		subscriptionSender.addPersistedSubscribers(
			DDMStructure.class.getName(), ddmStructure.getStructureId());

		subscriptionSender.addPersistedSubscribers(
			JournalArticle.class.getName(), article.getResourcePrimKey());

		subscriptionSender.addPersistedSubscribers(
			User.class.getName(), userId);

		subscriptionSender.flushNotificationsAsync();
	}

	protected void sendEmail(
			JournalArticle article, String articleURL,
			PortletPreferences preferences, String emailType,
			ServiceContext serviceContext)
		throws PortalException {

		JournalGroupServiceConfiguration journalGroupServiceConfiguration =
			getJournalGroupServiceConfiguration(article.getGroupId());

		if (preferences == null) {
			return;
		}
		else if (emailType.equals("denied") &&
				 journalGroupServiceConfiguration.
					 emailArticleApprovalDeniedEnabled()) {
		}
		else if (emailType.equals("granted") &&
				 journalGroupServiceConfiguration.
					 emailArticleApprovalGrantedEnabled()) {
		}
		else if (emailType.equals("requested") &&
				 journalGroupServiceConfiguration.
					 emailArticleApprovalRequestedEnabled()) {
		}
		else if (emailType.equals("review") &&
				 journalGroupServiceConfiguration.emailArticleReviewEnabled()) {
		}
		else {
			return;
		}

		Company company = _companyPersistence.findByPrimaryKey(
			article.getCompanyId());

		User user = _userPersistence.findByPrimaryKey(article.getUserId());

		String fromName = journalGroupServiceConfiguration.emailFromName();
		String fromAddress =
			journalGroupServiceConfiguration.emailFromAddress();

		String toName = user.getFullName();
		String toAddress = user.getEmailAddress();

		if (emailType.equals("requested")) {
			String tempToName = fromName;
			String tempToAddress = fromAddress;

			fromName = toName;
			fromAddress = toAddress;

			toName = tempToName;
			toAddress = tempToAddress;
		}

		Map<Locale, String> localizedSubjectMap = null;
		Map<Locale, String> localizedBodyMap = null;

		if (emailType.equals("denied")) {
			localizedSubjectMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleApprovalDeniedSubject());
			localizedBodyMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleApprovalDeniedBody());
		}
		else if (emailType.equals("granted")) {
			localizedSubjectMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleApprovalGrantedSubject());
			localizedBodyMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleApprovalGrantedBody());
		}
		else if (emailType.equals("requested")) {
			localizedSubjectMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleApprovalGrantedSubject());
			localizedBodyMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.
					emailArticleApprovalGrantedBody());
		}
		else if (emailType.equals("review")) {
			localizedSubjectMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.emailArticleReviewSubject());
			localizedBodyMap = LocalizationUtil.getMap(
				journalGroupServiceConfiguration.emailArticleReviewBody());
		}

		SubscriptionSender subscriptionSender = new SubscriptionSender();

		subscriptionSender.setCompanyId(company.getCompanyId());
		subscriptionSender.setContextAttributes(
			"[$ARTICLE_ID$]", article.getArticleId(), "[$ARTICLE_TITLE$]",
			article.getTitle(serviceContext.getLanguageId()), "[$ARTICLE_URL$]",
			articleURL, "[$ARTICLE_USER_NAME$]", article.getUserName(),
			"[$ARTICLE_VERSION$]", article.getVersion());
		subscriptionSender.setContextCreatorUserPrefix("ARTICLE");
		subscriptionSender.setCreatorUserId(article.getUserId());
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setLocalizedBodyMap(localizedBodyMap);
		subscriptionSender.setLocalizedSubjectMap(localizedSubjectMap);
		subscriptionSender.setMailId("journal_article", article.getId());

		String portletId = PortletProviderUtil.getPortletId(
			JournalArticle.class.getName(), PortletProvider.Action.EDIT);

		subscriptionSender.setPortletId(portletId);

		subscriptionSender.setScopeGroupId(article.getGroupId());
		subscriptionSender.setServiceContext(serviceContext);

		subscriptionSender.addRuntimeSubscribers(toAddress, toName);

		subscriptionSender.flushNotificationsAsync();
	}

	protected void setArticlesExpirationDate(JournalArticle article) {
		if (ExportImportThreadLocal.isImportInProcess()) {
			return;
		}

		if (!article.isApproved() || (article.getExpirationDate() == null)) {
			return;
		}

		final List<JournalArticle> articles =
			_journalArticlePersistence.findByG_A(
				article.getGroupId(), article.getArticleId());

		final Date expirationDate = article.getExpirationDate();

		TransactionCommitCallbackUtil.registerCallback(
			new Callable<Void>() {

				@Override
				public Void call() throws Exception {
					for (JournalArticle curArticle : articles) {
						curArticle.setExpirationDate(expirationDate);

						_journalArticleLocalService.updateJournalArticle(
							curArticle);
					}

					return null;
				}

			});
	}

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}

	@Reference(unbind = "-")
	protected void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {

		_assetEntryPersistence = assetEntryPersistence;
	}

	@Reference(unbind = "-")
	protected void setAssetLinkLocalService(
		AssetLinkLocalService assetLinkLocalService) {

		_assetLinkLocalService = assetLinkLocalService;
	}

	@Reference(unbind = "-")
	protected void setClassNameLocalService(
		ClassNameLocalService classNameLocalService) {

		_classNameLocalService = classNameLocalService;
	}

	@Reference(unbind = "-")
	protected void setCompanyPersistence(
		CompanyPersistence companyPersistence) {

		_companyPersistence = companyPersistence;
	}

	@Reference(unbind = "-")
	protected void setConfigurationProvider(
		ConfigurationProvider configurationProvider) {

		_configurationProvider = configurationProvider;
	}

	@Reference(unbind = "-")
	protected void setDDMStructureLocalService(
		DDMStructureLocalService ddmStructureLocalService) {

		_ddmStructureLocalService = ddmStructureLocalService;
	}

	@Reference(unbind = "-")
	protected void setJournalArticleLocalService(
		JournalArticleLocalService journalArticleLocalService) {

		_journalArticleLocalService = journalArticleLocalService;
	}

	@Reference(unbind = "-")
	protected void setJournalArticlePersistence(
		JournalArticlePersistence journalArticlePersistence) {

		_journalArticlePersistence = journalArticlePersistence;
	}

	@Reference(unbind = "-")
	protected void setUserPersistence(UserPersistence userPersistence) {
		_userPersistence = userPersistence;
	}

	protected void updatePreviousApprovedArticle(JournalArticle article)
		throws PortalException {

		JournalArticle previousApprovedArticle = getPreviousApprovedArticle(
			article);

		if (previousApprovedArticle.getVersion() == article.getVersion()) {
			_assetEntryLocalService.updateVisible(
				JournalArticle.class.getName(), article.getResourcePrimKey(),
				false);
		}
		else {
			AssetEntry assetEntry = _assetEntryLocalService.updateEntry(
				JournalArticle.class.getName(), article.getResourcePrimKey(),
				previousApprovedArticle.getDisplayDate(),
				previousApprovedArticle.getExpirationDate(),
				isListable(article), true);

			assetEntry.setModifiedDate(
				previousApprovedArticle.getModifiedDate());
			assetEntry.setTitle(previousApprovedArticle.getTitle());

			_assetEntryPersistence.update(assetEntry);
		}
	}

	protected void updateUrlTitles(
			long groupId, String articleId, String urlTitle)
		throws PortalException {

		JournalArticle firstArticle =
			_journalArticlePersistence.findByG_A_First(
				groupId, articleId, new ArticleVersionComparator(false));

		if (firstArticle.getUrlTitle().equals(urlTitle)) {
			return;
		}

		List<JournalArticle> articles = _journalArticlePersistence.findByG_A(
			groupId, articleId);

		for (JournalArticle article : articles) {
			if (!article.getUrlTitle().equals(urlTitle)) {
				article.setUrlTitle(urlTitle);

				_journalArticlePersistence.update(article);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		OWXPJournalArticleLocalServiceWrapper.class);

	private AssetEntryLocalService _assetEntryLocalService;
	private AssetEntryPersistence _assetEntryPersistence;
	private AssetLinkLocalService _assetLinkLocalService;
	private ClassNameLocalService _classNameLocalService;
	private CompanyPersistence _companyPersistence;
	private ConfigurationProvider _configurationProvider;
	private DDMStructureLocalService _ddmStructureLocalService;
	private JournalArticleLocalService _journalArticleLocalService;
	private JournalArticlePersistence _journalArticlePersistence;
	private UserPersistence _userPersistence;

}
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

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.journal.configuration.JournalGroupServiceConfiguration;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalServiceWrapper;
import com.liferay.journal.service.permission.JournalPermission;
import com.liferay.journal.util.impl.JournalUtil;
import com.liferay.portal.kernel.diff.DiffHtmlUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.PortletRequestModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GroupSubscriptionCheckSubscriptionSender;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.SubscriptionSender;
import com.liferay.portal.kernel.util.Validator;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tamas Molnar
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class OWXPJournalArticleLocalServiceWrapper
	extends JournalArticleLocalServiceWrapper {

	public OWXPJournalArticleLocalServiceWrapper() {
		super(null);
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

		DDMStructure ddmStructure = ddmStructureLocalService.getStructure(
			article.getGroupId(),
			classNameLocalService.getClassNameId(JournalArticle.class),
			article.getDDMStructureKey(), true);

		subscriptionSender.addPersistedSubscribers(
			DDMStructure.class.getName(), ddmStructure.getStructureId());

		subscriptionSender.addPersistedSubscribers(
			JournalArticle.class.getName(), article.getResourcePrimKey());

		subscriptionSender.flushNotificationsAsync();
	}

}
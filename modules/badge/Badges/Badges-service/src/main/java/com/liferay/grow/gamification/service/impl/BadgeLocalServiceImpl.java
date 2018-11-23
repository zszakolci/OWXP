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

package com.liferay.grow.gamification.service.impl;


import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.grow.gamification.badges.notification.BadgeReceivedSubscritpionSender;
import com.liferay.grow.gamification.badges.notification.constants.BadgeNotificationPortletKeys;
import com.liferay.grow.gamification.badges.notification.portlet.BadgeNotificationPortlet;
import com.liferay.grow.gamification.model.Badge;
import com.liferay.grow.gamification.model.BadgeType;
import com.liferay.grow.gamification.service.base.BadgeLocalServiceBaseImpl;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.mail.internet.InternetAddress;

/**
 * The implementation of the badge local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.grow.gamification.service.BadgeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Vilmos Papp
 * @see BadgeLocalServiceBaseImpl
 * @see com.liferay.grow.gamification.service.BadgeLocalServiceUtil
 */
public class BadgeLocalServiceImpl extends BadgeLocalServiceBaseImpl {
	@Override
	public Badge addBadge(Badge badge) {
		badge = super.addBadge(badge);

		_notifySubscribers(badge);

		return badge;
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.grow.gamification.service.BadgeLocalServiceUtil} to access the badge local service.
	 */
	public List<Badge> getBadgesOfUser(long userId) {
		return badgePersistence.findBytoUserId(userId);
	}

	private void _notifySubscribers(Badge badge) {

		// so all of this stuff should normally come from some kind of configuration.
		// As this is just an example, we're using a lot of hard coded values and portal-ext.properties values.

		User fromUser = userLocalService.fetchUser(badge.getUserId());

		String badgeType = badgeTypeLocalService.fetchBadgeType(badge.getBadgeTypeId()).getType();
		String entryTitle = badgeType + " Badge Received";

		LocalizedValuesMap subjectLocalizedValuesMap = new LocalizedValuesMap();
		LocalizedValuesMap bodyLocalizedValuesMap = new LocalizedValuesMap();

		subjectLocalizedValuesMap.put(Locale.ENGLISH, "A badge has been received");
		bodyLocalizedValuesMap.put(
			Locale.ENGLISH, "A " + badgeType + " badge has been received from " + fromUser.getFullName() +
			".");

		BadgeReceivedSubscritpionSender subscriptionSender = new BadgeReceivedSubscritpionSender();

		subscriptionSender.setBadgeType(badgeType);

		subscriptionSender.setClassPK(0);
		subscriptionSender.setClassName(BadgeNotificationPortlet.class.getName());
		subscriptionSender.setCompanyId(badge.getCompanyId());

		subscriptionSender.setCurrentUserId(badge.getToUserId());
		subscriptionSender.setEntryTitle(entryTitle);
		subscriptionSender.setFrom(fromUser.getEmailAddress(), fromUser.getFullName());
		subscriptionSender.setHtmlFormat(true);

		subscriptionSender.setMailId("badge_received", 0);

		int notificationType = 100;

		subscriptionSender.setNotificationType(notificationType);
		subscriptionSender.setCreatorUserId(badge.getUserId());
		subscriptionSender.setNotificationType(UserNotificationDefinition.NOTIFICATION_TYPE_ADD_ENTRY);
		String portletId = BadgeNotificationPortletKeys.BadgeNotification;

		subscriptionSender.setPortletId(portletId);

		subscriptionSender.setReplyToAddress(fromUser.getEmailAddress());
		subscriptionSender.setServiceContext(new ServiceContext());

		subscriptionSender.addPersistedSubscribers(BadgeNotificationPortlet.class.getName(), 0);

		subscriptionSender.flushNotificationsAsync();

		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
		payloadJSON.put(BadgeNotificationPortletKeys.BADGE_TYPE, badgeType);
		payloadJSON.put(BadgeNotificationPortletKeys.BADGE_COMMENT, badge.getDescription());

		UserNotificationEvent userNotificationEvent =
			UserNotificationEventLocalServiceUtil.createUserNotificationEvent(
				counterLocalService.increment());

		userNotificationEvent.setCompanyId(badge.getCompanyId());
		userNotificationEvent.setDeliverBy(0);
		userNotificationEvent.setDelivered(true);
		userNotificationEvent.setDeliveryType(UserNotificationDeliveryConstants.TYPE_WEBSITE);
		userNotificationEvent.setTimestamp(System.currentTimeMillis());
		userNotificationEvent.setPayload(payloadJSON.toString());
		userNotificationEvent.setType(BadgeNotificationPortletKeys.BadgeNotification);
		userNotificationEvent.setUserId(badge.getToUserId());

		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userNotificationEvent);

		InternetAddress recipient = null;
		InternetAddress sender = null;

		try {
			MailMessage mailMessage = _getMailMessage(badge);

			User user = userLocalService.getUserById(badge.getToUserId());

			sender = new InternetAddress(_BADGE_EMAIL_SENDER_ADDRESS, _BADGE_EMAIL_SENDER_PERSONAL);
			recipient = new InternetAddress(user.getEmailAddress(), user.getFullName());

			mailMessage.setFrom(sender);
			mailMessage.setHTMLFormat(true);
			mailMessage.setSubject(_BADGE_EMAIL_SUBJECT);

			mailMessage.setTo(recipient);


			MailServiceUtil.sendEmail(mailMessage);
		}
		catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}
	}

	private MailMessage _getMailMessage(Badge badge) throws PortalException {

		BadgeType badgeType = badgeTypeLocalService.getBadgeType(badge.getBadgeTypeId());
		MailMessage mailMessage = new MailMessage();

		String content = _BADGE_EMAIL_BODY;

		FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(badgeType.getFileEntryId());
		String downloadUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, "", false, true);

		content = StringUtil.replace(content, "${badgeType}", badgeType.getType());
		content = StringUtil.replace(content, "${bagdeImageLink}", downloadUrl);
		content = StringUtil.replace(content, "${colleague}", badge.getUserName());

		mailMessage.setBody(content);

		return mailMessage;
	}

	private static final String _BADGE_EMAIL_SENDER_ADDRESS = "admin@liferay,com";
	private static final String _BADGE_EMAIL_SENDER_PERSONAL = "GROW Badge Notification";
	private static final String _BADGE_EMAIL_SUBJECT = "You received a Bagde!";
	private static final String _BADGE_EMAIL_BODY = "<html><head><meta http-equiv=\"content-type\" " +
			"content=\"text/html; charset=UTF-8\"><title>You received a Badge!</title></head>" +
			"<body alink=\"#EE0000\" link=\"#0000EE\" vlink=\"#551A8B\" text=\"#000000\" "+
			"bgcolor=\"#eeeeee\"><center><table style=\"border-radius: 10px;\" bgcolor=\"#ffffff\" " +
			"width=\"90%\" cellspacing=\"2\" cellpadding=\"2\" border=\"0\"><tbody><tr align=\"center\">" +
			"<td valign=\"top\">Good news! You've just received a ${badgeType} from ${colleague}!</td>" +
			"</tr><tr align=\"center\"><td valign=\"top\"><img src=\"${bagdeImageLink}\"" +
			"alt=\"Bagde image\" height=\"300\" width=\"300\"></td></tr><tr align=\"center\">" +
			"<td valign=\"top\">Congratulations!</td></tr></tbody></table></center></body></html>";
}

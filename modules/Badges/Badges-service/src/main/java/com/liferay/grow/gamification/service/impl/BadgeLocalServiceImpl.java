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


import com.liferay.grow.gamification.badges.notification.BadgeReceivedSubscritpionSender;
import com.liferay.grow.gamification.badges.notification.constants.BadgeNotificationPortletKeys;
import com.liferay.grow.gamification.badges.notification.portlet.BadgeNotificationPortlet;
import com.liferay.grow.gamification.model.Badge;
import com.liferay.grow.gamification.service.base.BadgeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Reference;

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

		subscriptionSender.setCurrentUserId(badge.getUserId());
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

		try {
			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(badge.getToUserId(), 
					BadgeNotificationPortletKeys.BadgeNotification, 
					(new Date()).getTime(),
					0,
					payloadJSON.toString(),
					false, new ServiceContext());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}

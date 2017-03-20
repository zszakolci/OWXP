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

package com.liferay.notifications.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.notifications.web.internal.constants.NotificationsPortletKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.util.GetterUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + NotificationsPortletKeys.NOTIFICATIONS,
		"panel.app.order:Integer=400",
		"panel.category.key=" + PanelCategoryKeys.USER_MY_ACCOUNT,
		"service.ranking:Integer=100"
	},
	service = PanelApp.class
)
public class NotificationsPanelApp extends BasePanelApp {

	@Override
	public int getNotificationsCount(User user) {
		if (_userNotificationEventLocalService == null) {
			return 0;
		}

		PortalPreferences portalPreferences =
			PortletPreferencesFactoryUtil.getPortalPreferences(
				user.getUserId(), true);

		boolean useLegacyUserNotifciationEventsCount = GetterUtil.getBoolean(
			portalPreferences.getValue(
				UserNotificationEvent.class.getName(),
				"useLegacyUserNotificationEventsCount",
				Boolean.TRUE.toString()));

		int userNotifiationEventsCount = 0;

		if (useLegacyUserNotifciationEventsCount) {
			userNotifiationEventsCount =
				_userNotificationEventLocalService.
					getArchivedUserNotificationEventsCount(
						user.getUserId(),
						UserNotificationDeliveryConstants.TYPE_WEBSITE, false);
		}
		else {
			userNotifiationEventsCount = GetterUtil.getInteger(
				portalPreferences.getValue(
					UserNotificationEvent.class.getName(),
					"userNotificationEventsCount"));
		}

		return userNotifiationEventsCount;
	}

	@Override
	public String getPortletId() {
		return NotificationsPortletKeys.NOTIFICATIONS;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + NotificationsPortletKeys.NOTIFICATIONS + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

	@Override
	@Reference(unbind = "-")
	protected void setUserNotificationEventLocalService(
		UserNotificationEventLocalService userNotificationEventLocalService) {

		_userNotificationEventLocalService = userNotificationEventLocalService;
	}

	private UserNotificationEventLocalService
		_userNotificationEventLocalService;

}
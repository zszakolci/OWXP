package com.liferay.grow.gamification.badges.notification;
import com.liferay.grow.gamification.badges.notification.constants.BadgeNotificationPortletKeys;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.notifications.UserNotificationDefinition;
import com.liferay.portal.kernel.notifications.UserNotificationDeliveryType;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {"javax.portlet.name=" +BadgeNotificationPortletKeys.BadgeNotification},
		service = UserNotificationDefinition.class
)
public class BadgeNotificationDefinition  extends UserNotificationDefinition {
	public static int type = 100;
	public static String PORTLET_ID = "1";

	public BadgeNotificationDefinition() {
		super(PORTLET_ID, 0, type, "received-a-badge");
		addUserNotificationDeliveryType(
			new UserNotificationDeliveryType("email", UserNotificationDeliveryConstants.TYPE_EMAIL, false,
				true));

		addUserNotificationDeliveryType(
				new UserNotificationDeliveryType(
					"website", UserNotificationDeliveryConstants.TYPE_WEBSITE, true, true));
	}

}

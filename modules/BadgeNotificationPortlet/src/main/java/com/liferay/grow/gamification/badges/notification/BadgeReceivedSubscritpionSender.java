package com.liferay.grow.gamification.badges.notification;

import com.liferay.grow.gamification.badges.notification.constants.BadgeNotificationPortletKeys;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Subscription;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.SubscriptionSender;

@SuppressWarnings({ "serial", "deprecation" })
public class BadgeReceivedSubscritpionSender extends SubscriptionSender {

	protected void populateNotificationEventJSONObject(
			JSONObject notificationEventJSONObject) {

		super.populateNotificationEventJSONObject(notificationEventJSONObject);

		notificationEventJSONObject.put(BadgeNotificationPortletKeys.BADGE_TYPE, _badgeType);
	}

	@Override
	protected boolean hasPermission(Subscription subscription, String className, long classPK, User user) throws Exception {
		return true;
	}

	@Override
	protected boolean hasPermission(Subscription subscription, User user) throws Exception {
		return true;
	}

	@Override
	protected void sendUserNotification(User user) throws Exception {
		super.sendUserNotification(user);
		System.out.println("Send Notification to: " + user.getFullName());
	}
	@Override
	protected void sendNotification(User user) throws Exception {
//		super.sendNotification(user);
System.out.println("Send Notification to: " + user.getFullName());
		sendEmailNotification(user);
		sendUserNotification(user);
	}

	public void setBadgeType(String badgeType) {
		this._badgeType = badgeType;
	}

	private String _badgeType;
}

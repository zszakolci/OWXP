package com.liferay.grow.gamification.badges.notification;

import com.liferay.grow.gamification.badges.notification.constants.BadgeNotificationPortletKeys;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.SubscriptionSender;

@SuppressWarnings({"serial", "deprecation"})
public class BadgeReceivedSubscritpionSender extends SubscriptionSender {

	public void setBadgeDesctiption(String badgeComment) {
		_badgeComment = badgeComment;
	}

	public void setBadgeType(String badgeType) {
		_badgeType = badgeType;
	}

	protected void populateNotificationEventJSONObject(
		JSONObject notificationEventJSONObject) {

		super.populateNotificationEventJSONObject(notificationEventJSONObject);

		notificationEventJSONObject.put(
			BadgeNotificationPortletKeys.BADGE_TYPE, _badgeType);
		notificationEventJSONObject.put(
			BadgeNotificationPortletKeys.BADGE_COMMENT, _badgeComment);
	}

	private String _badgeComment;
	private String _badgeType;

}
package com.liferay.grow.gamification.badges.notification;

import com.liferay.grow.gamification.badges.notification.constants.BadgeNotificationPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationFeedEntry;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {"javax.portlet.name=" + BadgeNotificationPortletKeys.BadgeNotification},
		service = UserNotificationHandler.class
)
public class BadgeNotificationHandler extends BaseUserNotificationHandler {

	@Override
	public UserNotificationFeedEntry interpret(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws PortalException {
		try {
			UserNotificationFeedEntry userNotificationFeedEntry = doInterpret(
				userNotificationEvent, serviceContext);

			if (userNotificationFeedEntry != null) {
				userNotificationFeedEntry.setOpenDialog(isOpenDialog());
				userNotificationFeedEntry.setPortletId(getPortletId());
			}
			else {
				String body = getBody(userNotificationEvent, serviceContext);

				userNotificationFeedEntry = new UserNotificationFeedEntry(false, body, "");
			}

			return userNotificationFeedEntry;
		}
		catch (Exception e) {
			_log.error("Unable to interpret notification", e);
		}

		return null;
	}

	public BadgeNotificationHandler() {
		super.setPortletId(BadgeNotificationPortletKeys.BadgeNotification);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {
		String userName = _UKNOWN_USER;

		User user = _userLocalService.fetchUser(userNotificationEvent.getUserId());

		if (Validator.isNotNull(user)) {
			userName = user.getFullName();
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
			userNotificationEvent.getPayload());

		String badgeType = jsonObject.getString(BadgeNotificationPortletKeys.BADGE_TYPE);

		String reason = jsonObject.getString(BadgeNotificationPortletKeys.BADGE_COMMENT);

		if (Validator.isNull(reason)) {
			reason = "";
		}
		else {
			reason = " for " + reason;
		}

		String html = StringUtil.replace(
			_BODY_TEMPLATE, _BODY_REPLACEMENTS, new String[] {badgeType, userName, reason});

		return html;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(final UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private UserLocalService _userLocalService;
	private static final String _UKNOWN_USER = "Anonymous";

	private static final String _BODY_TEMPLATE = "<div class=\"title\">Badge received!</div><div class=\"body\">You just received a [$BADGE_TPYE$] from [$USER$][$REASON$].</div>";
	private static final String[] _BODY_REPLACEMENTS = new String[] {"[$BADGE_TPYE$]", "[$USER$]", "[$REASON$]"};

	private static final Log _log = LogFactoryUtil.getLog(BadgeNotificationHandler.class);

}

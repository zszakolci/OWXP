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
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {"javax.portlet.name=" + BadgeNotificationPortletKeys.BadgeNotification},
		service = BaseUserNotificationHandler.class
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
				Portlet portlet = PortletLocalServiceUtil.getPortletById(
					getPortletId());

				String body = getBody(userNotificationEvent, serviceContext);

				userNotificationFeedEntry = new UserNotificationFeedEntry(
					false, body, "");
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
		String userName = LanguageUtil.get(serviceContext.getLocale(), _UKNOWN_USER_KEY);

		User user = _userLocalService.fetchUser(userNotificationEvent.getUserId());

		if (Validator.isNotNull(user)) {
			userName = user.getFullName();
		}

		// we'll be stashing the client address in the payload of the event, so let's extract it here.
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
			userNotificationEvent.getPayload());

		String badgeType = jsonObject.getString(BadgeNotificationPortletKeys.BADGE_TYPE);

		// fetch our strings via the language bundle.
		String title = LanguageUtil.get(serviceContext.getLocale(), _TITLE_KEY);

		String body = LanguageUtil.format(serviceContext.getLocale(), _BODY_KEY, new Object[] {userName, badgeType});

		// build the html using our template.
		String html = StringUtil.replace(_BODY_TEMPLATE, _BODY_REPLACEMENTS, new String[] {badgeType, title, body});

		return html;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(final UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private UserLocalService _userLocalService;
	private static final String _TITLE_KEY = "title.badge.received";
	private static final String _BODY_KEY = "body.badge.received";
	private static final String _UKNOWN_USER_KEY = "unknown.user";

	private static final String _BODY_TEMPLATE = "<div class=\"title\">[$TITLE$]</div><div class=\"body\">[$BODY$]</div>";
	private static final String[] _BODY_REPLACEMENTS = new String[] {"[$BADGE_TPYE$]","[$TITLE$]", "[$BODY$]"};

	private static final Log _log = LogFactoryUtil.getLog(BadgeNotificationHandler.class);

}

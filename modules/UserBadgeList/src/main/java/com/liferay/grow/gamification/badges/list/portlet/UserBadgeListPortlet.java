package com.liferay.grow.gamification.badges.list.portlet;

import com.liferay.grow.gamification.badges.list.constants.UserBadgeListPortletKeys;
import com.liferay.grow.gamification.model.BadgeType;
import com.liferay.grow.gamification.service.BadgeTypeLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author vili
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.gamification",
		"javax.portlet.display-name=Badge List",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.header-portlet-css=/css/style.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"javax.portlet.name=" + UserBadgeListPortletKeys.UserBadgeList,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserBadgeListPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<User> usersTmp = _userLocalService.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		OrderByComparator userComparator = 
			(OrderByComparator) OrderByComparatorFactoryUtil.create("User", "fullName", true);

		List<User> users = new ArrayList<User>();
		for (User user: usersTmp) {
			if (user.isActive()) {
				users.add(user);
			}
		}

		Collections.sort(users, userComparator);
		OrderByComparator badgeTypeComparator = 
				(OrderByComparator) OrderByComparatorFactoryUtil.create("BadgeType", "type", true);

		List<BadgeType> badgeTypes = new ArrayList(_badgeTypeLocalService.getAvailableBadgeTypes());

		Collections.sort(badgeTypes, badgeTypeComparator);

		renderRequest.setAttribute(UserBadgeListPortletKeys.BADGE_TYPES, badgeTypes);
		renderRequest.setAttribute(UserBadgeListPortletKeys.USER_LIST, users);

		if (themeDisplay.getScopeGroup().isUser()) {
			long userId = themeDisplay.getScopeGroup().getClassPK();

			renderRequest.setAttribute(UserBadgeListPortletKeys.BADGE_USER_ID, userId);
		}

		super.render(renderRequest, renderResponse);
	}

	public void selectUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		long userId = ParamUtil.get(actionRequest, "userId", 0);

		actionRequest.setAttribute(UserBadgeListPortletKeys.BADGE_USER_ID, userId);
	}

	@Reference(unbind = "-")
	protected void setBadgeTypeLocalService(BadgeTypeLocalService badgeTypeLocalService) {
		_badgeTypeLocalService = badgeTypeLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private BadgeTypeLocalService _badgeTypeLocalService;
	private UserLocalService _userLocalService;

}
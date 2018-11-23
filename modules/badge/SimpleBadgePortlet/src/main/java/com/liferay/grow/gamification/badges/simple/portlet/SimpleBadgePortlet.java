package com.liferay.grow.gamification.badges.simple.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.grow.gamification.badges.portlet.constants.SimpleBadgePortletKeys;
import com.liferay.grow.gamification.exception.NoSuchLDateException;
import com.liferay.grow.gamification.model.Badge;
import com.liferay.grow.gamification.model.BadgeType;
import com.liferay.grow.gamification.service.BadgeLocalService;
import com.liferay.grow.gamification.service.BadgeTypeLocalService;
import com.liferay.grow.gamification.service.LDateLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
		"javax.portlet.display-name=Simple Badge",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.header-portlet-css=/css/style.css",
		"com.liferay.portlet.header-portlet-css=/css/flexselect.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/jquery.flexselect.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/liquidmetal.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"javax.portlet.name=" + SimpleBadgePortletKeys.SimpleBadge,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SimpleBadgePortlet extends MVCPortlet {

	

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
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

		renderRequest.setAttribute(SimpleBadgePortletKeys.USER_LIST, users);

		OrderByComparator badgeTypeComparator = 
				(OrderByComparator) OrderByComparatorFactoryUtil.create("BadgeType", "type", true);

		List<BadgeType> badgeTypes = new ArrayList(_badgeTypeLocalService.getAvailableBadgeTypes());

		Collections.sort(badgeTypes, badgeTypeComparator);
		renderRequest.setAttribute(SimpleBadgePortletKeys.BADGE_TYPES, badgeTypes);

		super.render(renderRequest, renderResponse);
	}

	public void addBadge(ActionRequest actionRequest, ActionResponse actionResponse) {
		long userId = Long.parseLong(actionRequest.getParameter("userId"));
		long badgeTypeId = Long.parseLong(actionRequest.getParameter("badgeTypeId"));
		long badgeId = _counterLocalService.increment(Badge.class.getName());
		String description = actionRequest.getParameter("description");

		try {
			User fromUser = (User)actionRequest.getAttribute(WebKeys.USER);
			User user = _userLocalService.getUser(userId);
			Badge badge = _badgeLocalService.createBadge(badgeId);
			badge.setUserId(fromUser.getUserId());
			badge.setAssignedDateId(_getDateId(new Date()));
			badge.setBadgeTypeId(badgeTypeId);
			badge.setCompanyId(user.getCompanyId());
			badge.setCreateDate(new Date());
			badge.setDescription(description);
			badge.setGroupId(user.getGroupId());
			badge.setToUserId(userId);
			badge.setUserName(fromUser.getFullName());
			badge.setUuid(UUID.randomUUID().toString());

			_badgeLocalService.addBadge(badge);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private long _getDateId(Date date) throws NoSuchLDateException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return _lDateLocalService.getDateId(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
	}

	@Reference(unbind = "-")
	protected void setBadgeLocalService(BadgeLocalService badgeLocalService) {
		_badgeLocalService = badgeLocalService;
	}

	@Reference(unbind = "-")
	protected void setBadgeTypeLocalService(BadgeTypeLocalService badgeTypeLocalService) {
		_badgeTypeLocalService = badgeTypeLocalService;
	}

	@Reference(unbind = "-")
	protected void setCounterLocalService(CounterLocalService counterLocalService) {
		_counterLocalService = counterLocalService;
	}

	@Reference(unbind = "-")
	protected void setLDateLocalService(LDateLocalService lDateLocalService) {
		_lDateLocalService = lDateLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private BadgeLocalService _badgeLocalService;
	private BadgeTypeLocalService _badgeTypeLocalService;
	private CounterLocalService _counterLocalService;
	private LDateLocalService _lDateLocalService;
	private UserLocalService _userLocalService;
}
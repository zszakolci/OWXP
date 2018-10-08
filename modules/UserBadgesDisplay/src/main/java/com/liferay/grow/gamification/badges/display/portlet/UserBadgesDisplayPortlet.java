package com.liferay.grow.gamification.badges.display.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.grow.gamification.badges.display.constants.UserBadgesDisplayPortletKeys;
import com.liferay.grow.gamification.badges.model.BadgeAggregator;
import com.liferay.grow.gamification.exception.NoSuchLDateException;
import com.liferay.grow.gamification.model.Badge;
import com.liferay.grow.gamification.model.BadgeType;
import com.liferay.grow.gamification.service.BadgeLocalService;
import com.liferay.grow.gamification.service.BadgeTypeLocalService;
import com.liferay.grow.gamification.service.LDateLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
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
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.header-portlet-css=/css/style.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"javax.portlet.name=" + UserBadgesDisplayPortletKeys.UserBadgesDisplay,
		"javax.portlet.display-name=User Badges Display",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserBadgesDisplayPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.getScopeGroup().isUser()) {
			long userId = themeDisplay.getScopeGroup().getClassPK();

			List<Badge> badges = _badgeLocalService.getBadgesOfUser(userId);

			List<BadgeAggregator> badgeAggregators = new ArrayList<>();

			for (Iterator<Badge> it = badges.iterator(); it.hasNext();) {
				badgeAggregators = _aggregate(it.next(), badgeAggregators, themeDisplay);
			}

			OrderByComparator badgeTypeComparator = 
					(OrderByComparator) OrderByComparatorFactoryUtil.create("BadgeType", "type", true);

			List<BadgeType> badgeTypes = new ArrayList(_badgeTypeLocalService.getAvailableBadgeTypes());

			Collections.sort(badgeTypes, badgeTypeComparator);

			renderRequest.setAttribute(UserBadgesDisplayPortletKeys.BADGE_AGGRETAGORS, badgeAggregators);
			renderRequest.setAttribute(UserBadgesDisplayPortletKeys.BADGE_TYPES, badgeTypes);
			renderRequest.setAttribute(UserBadgesDisplayPortletKeys.BADGE_USER_ID, userId);

			try {
				User user = _userLocalService.getUser(userId);

				renderRequest.setAttribute(UserBadgesDisplayPortletKeys.BADGE_USER_NAME, user.getFullName());
			}
			catch (PortalException e) {
				e.printStackTrace();
			}

		}

		super.render(renderRequest, renderResponse);
	}

	public void addBadge(ActionRequest actionRequest, ActionResponse actionResponse) {
		long userId = Long.parseLong(actionRequest.getParameter("userId"));
		long badgeTypeId = Long.parseLong(actionRequest.getParameter("badgeTypeId"));
		long badgeId = _counterLocalService.increment(Badge.class.getName());
		String description = actionRequest.getParameter("description");
		System.out.println(description);
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


	private synchronized List<BadgeAggregator> _aggregate(Badge badge, List<BadgeAggregator> badgeAggregators, ThemeDisplay themeDisplay) {

		BadgeAggregator aggregator = null;
		List<BadgeAggregator> updatedList = new ArrayList<>();

		for (BadgeAggregator badgeAggregator : badgeAggregators) {
			if (badgeAggregator.getBadgeTypeId() == badge.getBadgeTypeId()) {
				badgeAggregator.increaseCount();
				aggregator = badgeAggregator;
			}
			updatedList.add(badgeAggregator);
		}

		if (aggregator == null) {
			BadgeType badgeType = _badgeTypeLocalService.fetchBadgeType(badge.getBadgeTypeId());
			aggregator = new BadgeAggregator();
			aggregator.setName(badgeType.getType());
			aggregator.setBadgeTypeId(badgeType.getBadgeTypeId());
			aggregator.setCount(1);
			try {
				FileEntry fileEntry = _dlAppLocalService.getFileEntry(badgeType.getFileEntryId());
				String downloadUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, "", false, true);
				aggregator.setImage(downloadUrl);
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			updatedList.add(aggregator);
		}

		return updatedList;
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
	protected void setDLAppLocalService(DLAppLocalService dlAppLocalService) {
		_dlAppLocalService = dlAppLocalService;
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
	private DLAppLocalService _dlAppLocalService;
	private LDateLocalService _lDateLocalService;
	private UserLocalService _userLocalService;
}
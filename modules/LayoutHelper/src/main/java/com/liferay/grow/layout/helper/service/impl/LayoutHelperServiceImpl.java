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

package com.liferay.grow.layout.helper.service.impl;

import com.liferay.grow.layout.helper.service.LayoutHelperService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tamas Molnar
 */
@Component(immediate = true, service = LayoutHelperService.class)
public class LayoutHelperServiceImpl implements LayoutHelperService {

	@Override
	public void updateProfilePages() {
		if (_log.isInfoEnabled()) {
			_log.info("Updating Profile Pages...");
		}

		List<User> users = _userLocalService.getUsers(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (User user : users) {
			try {
				if (user.isDefaultUser()) {
					continue;
				}

				List<Layout> layouts = _layoutLocalService.getLayouts(
					user.getGroupId(), false);

				if (layouts.size() != 1) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"User: " + user.getScreenName() + " has " +
								layouts.size() + " public layout");
					}
				}

				if (layouts.isEmpty()) {
					continue;
				}

				Layout layout = layouts.get(0);

				LayoutTypePortlet layoutTypePortlet =
					(LayoutTypePortlet)layout.getLayoutType();

				// Update Theme

				layout.setThemeId(
					"frontenduserprofilegrow_WAR_growthemeuserprofile");
				layout.setColorSchemeId("01");

				UnicodeProperties properties =
					layoutTypePortlet.getTypeSettingsProperties();

				properties.put("layoutUpdateable", Boolean.TRUE.toString());
				properties.put("sitemap-changefreq", "daily");
				properties.put("sitemap-include", "1");

				// Remove OWXPSubscribePortlet

				String owxpSubscribePortletId =
					"com_liferay_owxp_subscribe_portlet_OWXPSubscribePortlet";

				List<String> portletIds = layoutTypePortlet.getPortletIds();

				for (String portletId : portletIds) {
					if (portletId.startsWith(owxpSubscribePortletId)) {
						layoutTypePortlet.removePortletId(
							user.getUserId(), portletId);

						break;
					}
				}

				_layoutLocalService.updateLayout(layout);

				// Remove the Guest role's View permission from the Profile
				// Pages

				Role guestRole = _roleLocalService.getRole(
					layout.getCompanyId(), RoleConstants.GUEST);

				_resourcePermissionLocalService.setResourcePermissions(
					layout.getCompanyId(), Layout.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(layout.getPlid()), guestRole.getRoleId(),
					new String[0]);
			}
			catch (Exception e) {
				_log.error(
					"Cannot remove View permission for " + user.getScreenName(),
					e);
			}
		}

		if (_log.isInfoEnabled()) {
			_log.info("Profile Pages have been updated");
		}

	}

	@Reference(unbind = "-")
	protected void setLayoutLocalService(
		LayoutLocalService layoutLocalService) {

		_layoutLocalService = layoutLocalService;
	}

	@Reference(unbind = "-")
	protected void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService) {

		_resourcePermissionLocalService = resourcePermissionLocalService;
	}

	@Reference(unbind = "-")
	protected void setRoleLocalService(RoleLocalService roleLocalService) {
		_roleLocalService = roleLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LayoutHelperServiceImpl.class);

	private LayoutLocalService _layoutLocalService;
	private ResourcePermissionLocalService _resourcePermissionLocalService;
	private RoleLocalService _roleLocalService;
	private UserLocalService _userLocalService;

}
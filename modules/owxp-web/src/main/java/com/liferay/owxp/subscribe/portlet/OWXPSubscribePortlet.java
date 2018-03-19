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

package com.liferay.owxp.subscribe.portlet;

import com.liferay.owxp.subscribe.constants.OWXPSubscribePortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.SubscriptionLocalService;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tamas Molnar
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.social",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=GROW subscriber",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OWXPSubscribePortletKeys.OWXP_SUBSCRIBE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OWXPSubscribePortlet extends MVCPortlet {

	public void subscribe(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException {

		long companyId = GetterUtil.getLong(
			actionRequest.getParameter("companyId"));
		long subscriberId = GetterUtil.getLong(
			actionRequest.getParameter("subscriberId"));
		long subscribeToId = GetterUtil.getLong(
			actionRequest.getParameter("subscribeToId"));

		if (_subscriptionLocalService.isSubscribed(
				companyId, subscriberId, User.class.getName(), subscribeToId)) {

			_subscriptionLocalService.deleteSubscription(
				subscriberId, User.class.getName(), subscribeToId);
		}
		else {
			_subscriptionLocalService.addSubscription(
				subscriberId, 0, User.class.getName(), subscribeToId,
				"instant");
		}
	}

	@Reference(unbind = "-")
	protected void setSubscriptionLocalService(
		SubscriptionLocalService subscriptionLocalService) {

		_subscriptionLocalService = subscriptionLocalService;
	}

	private SubscriptionLocalService _subscriptionLocalService;

}
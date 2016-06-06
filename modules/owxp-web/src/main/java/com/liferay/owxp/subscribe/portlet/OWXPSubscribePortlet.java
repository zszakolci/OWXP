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
import com.liferay.portal.kernel.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.social",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=owxp-subscribe Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OWXPSubscribePortletKeys.OWXP_SUBSCRIBE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
/**
 * @author Tamas Molnar
 */
public class OWXPSubscribePortlet extends MVCPortlet {

	public void subscribe(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException {

		long subscriber = GetterUtil.getLong(
			actionRequest.getParameter("subscriber"));
		long subscribeTo = GetterUtil.getLong(
			actionRequest.getParameter("subscribeTo"));

		SubscriptionLocalServiceUtil.addSubscription(
			subscriber, 0, User.class.getName(), subscribeTo, "instant");
	}

	public void unsubscribe(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException {

		long subscriber = GetterUtil.getLong(
			actionRequest.getParameter("subscriber"));
		long subscribeTo = GetterUtil.getLong(
			actionRequest.getParameter("subscribeTo"));

		SubscriptionLocalServiceUtil.deleteSubscription(
			subscriber, User.class.getName(), subscribeTo);
	}

}
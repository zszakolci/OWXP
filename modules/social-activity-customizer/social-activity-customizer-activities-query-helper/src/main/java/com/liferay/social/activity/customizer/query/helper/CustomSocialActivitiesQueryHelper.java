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

package com.liferay.social.activity.customizer.query.helper;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.social.activities.web.internal.util.SocialActivitiesQueryHelper;
import com.liferay.social.activity.customizer.service.CustomSocialActivitySetLocalService;
import com.liferay.social.kernel.model.SocialActivitySet;
import com.liferay.social.kernel.service.SocialActivitySetLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Istvan Sajtos
 */
@Component(immediate = true, service = CustomSocialActivitiesQueryHelper.class)
public class CustomSocialActivitiesQueryHelper
	extends SocialActivitiesQueryHelper {

	@Override
	public List<SocialActivitySet> getSocialActivitySets(
		Group group, Layout layout, Scope scope, int start, int end) {

		if ((scope == Scope.ALL) && group.isUser() && (_types != null)) {
			return _customSocialActivitySetLocalService.
				getUserViewableActivitySets(
					group.getClassPK(), _types, start, end);
		}
		else {
			return super.getSocialActivitySets(
				group, layout, scope, start, end);
		}
	}

	@Override
	public int getSocialActivitySetsCount(
		Group group, Layout layout, Scope scope) {

		if ((scope == Scope.ALL) && group.isUser() && (_types != null)) {
			return _customSocialActivitySetLocalService.
				getUserViewableActivitySetsCount(group.getClassPK(), _types);
		}
		else {
			return super.getSocialActivitySetsCount(group, layout, scope);
		}
	}

	public void setTypes(long[] types) {
		_types = types;
	}

	@Reference(unbind = "-")
	protected void setCustomSocialActivitySetLocalService(
		CustomSocialActivitySetLocalService
			customSocialActivitySetLocalService) {

		_customSocialActivitySetLocalService =
			customSocialActivitySetLocalService;
	}

	@Reference(unbind = "-")
	protected void setGroupLocalService(GroupLocalService groupLocalService) {
		super.setGroupLocalService(groupLocalService);
	}

	@Reference(unbind = "-")
	protected void setSocialActivitySetLocalService(
		SocialActivitySetLocalService socialActivitySetLocalService) {

		super.setSocialActivitySetLocalService(socialActivitySetLocalService);
	}

	private CustomSocialActivitySetLocalService
		_customSocialActivitySetLocalService;
	private long[] _types;

}
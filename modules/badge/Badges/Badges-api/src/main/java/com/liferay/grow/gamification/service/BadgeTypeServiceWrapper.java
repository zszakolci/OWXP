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

package com.liferay.grow.gamification.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BadgeTypeService}.
 *
 * @author Vilmos Papp
 * @see BadgeTypeService
 * @generated
 */
@ProviderType
public class BadgeTypeServiceWrapper implements BadgeTypeService,
	ServiceWrapper<BadgeTypeService> {
	public BadgeTypeServiceWrapper(BadgeTypeService badgeTypeService) {
		_badgeTypeService = badgeTypeService;
	}

	@Override
	public java.util.List<com.liferay.grow.gamification.model.BadgeType> getAvailableBadgeTypes() {
		return _badgeTypeService.getAvailableBadgeTypes();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _badgeTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public BadgeTypeService getWrappedService() {
		return _badgeTypeService;
	}

	@Override
	public void setWrappedService(BadgeTypeService badgeTypeService) {
		_badgeTypeService = badgeTypeService;
	}

	private BadgeTypeService _badgeTypeService;
}
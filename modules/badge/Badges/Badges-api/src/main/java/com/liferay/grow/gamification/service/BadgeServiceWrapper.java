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
 * Provides a wrapper for {@link BadgeService}.
 *
 * @author Vilmos Papp
 * @see BadgeService
 * @generated
 */
@ProviderType
public class BadgeServiceWrapper implements BadgeService,
	ServiceWrapper<BadgeService> {
	public BadgeServiceWrapper(BadgeService badgeService) {
		_badgeService = badgeService;
	}

	@Override
	public java.util.List<com.liferay.grow.gamification.model.Badge> getBadgesOfUser(
		long userId) {
		return _badgeService.getBadgesOfUser(userId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _badgeService.getOSGiServiceIdentifier();
	}

	@Override
	public BadgeService getWrappedService() {
		return _badgeService;
	}

	@Override
	public void setWrappedService(BadgeService badgeService) {
		_badgeService = badgeService;
	}

	private BadgeService _badgeService;
}
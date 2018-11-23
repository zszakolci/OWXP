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
 * Provides a wrapper for {@link LDateService}.
 *
 * @author Vilmos Papp
 * @see LDateService
 * @generated
 */
@ProviderType
public class LDateServiceWrapper implements LDateService,
	ServiceWrapper<LDateService> {
	public LDateServiceWrapper(LDateService lDateService) {
		_lDateService = lDateService;
	}

	@Override
	public long getDateId(int year, int month, int day)
		throws com.liferay.grow.gamification.exception.NoSuchLDateException {
		return _lDateService.getDateId(year, month, day);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _lDateService.getOSGiServiceIdentifier();
	}

	@Override
	public LDateService getWrappedService() {
		return _lDateService;
	}

	@Override
	public void setWrappedService(LDateService lDateService) {
		_lDateService = lDateService;
	}

	private LDateService _lDateService;
}
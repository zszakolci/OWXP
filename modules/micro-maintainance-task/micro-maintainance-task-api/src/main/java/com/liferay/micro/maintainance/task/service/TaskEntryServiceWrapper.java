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

package com.liferay.micro.maintainance.task.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TaskEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntryService
 * @generated
 */
@ProviderType
public class TaskEntryServiceWrapper implements TaskEntryService,
	ServiceWrapper<TaskEntryService> {
	public TaskEntryServiceWrapper(TaskEntryService taskEntryService) {
		_taskEntryService = taskEntryService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _taskEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public TaskEntryService getWrappedService() {
		return _taskEntryService;
	}

	@Override
	public void setWrappedService(TaskEntryService taskEntryService) {
		_taskEntryService = taskEntryService;
	}

	private TaskEntryService _taskEntryService;
}
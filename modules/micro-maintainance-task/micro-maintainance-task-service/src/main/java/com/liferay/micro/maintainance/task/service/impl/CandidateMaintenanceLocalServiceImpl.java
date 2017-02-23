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

package com.liferay.micro.maintainance.task.service.impl;

import java.util.List;

import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.service.base.CandidateMaintenanceLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the candidate maintenance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateMaintenanceLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalServiceUtil
 */
@ProviderType
public class CandidateMaintenanceLocalServiceImpl
	extends CandidateMaintenanceLocalServiceBaseImpl {

	@Override
	public List<CandidateMaintenance> getCandidateMaintenaceTasks(
			long candidateId)
		throws PortalException {

		return candidateMaintenancePersistence.findByCandidateIds(candidateId);
	}

	@Override
	public long getCandidateMaintenaceTasksCount(long candidateId)
		throws PortalException {

		return getCandidateMaintenaceTasks(candidateId).size();
	}
}
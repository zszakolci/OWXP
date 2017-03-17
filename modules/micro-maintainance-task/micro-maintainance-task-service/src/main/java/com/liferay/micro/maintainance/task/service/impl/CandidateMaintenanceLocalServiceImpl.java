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

import java.util.Date;
import java.util.List;

import com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalServiceUtil;
import com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.service.base.CandidateMaintenanceLocalServiceBaseImpl;
import com.liferay.micro.maintainance.task.service.persistence.CandidateMaintenanceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;

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

	/**
	 * Adds a CandidateMaintenance entry to the database, this way assigning a
	 * wiki page to a maintenance task. The users can vote, while this entry is
	 * in the database.
	 * 
	 * @param candidateId: the id of the candidate entry belonging to the 
	 *   flagged wiki page
	 * @param taskId: the id of the maintenance task for which the page is 
	 *   flagged 
	 * @return the CandidateMaintenance entry that was added
	 * @throws PortalException
	 */
	@Override
	public CandidateMaintenance addCandidateMaintenance(
			long candidateId, long taskId)
		throws PortalException {
		
		long canMainId = counterLocalService.increment();
		Date now = new Date();

		CandidateMaintenance candidateMaintenance = 
			candidateMaintenancePersistence.create(candidateId);

		candidateMaintenance.setCandidateId(candidateId);
		candidateMaintenance.setTaskId(taskId);
		candidateMaintenance.setCreateDate(now);

		return candidateMaintenance;
	}

	/**
	 * Deletes the candidate maintenance with the primary key from the database.
	 * Also deletes the candidate entry if there are no more votes running for
	 * it.
	 *
	 * @param candidateMaintenanceId the primary key of the candidate maintenance
	 * @return the candidate maintenance that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CandidateMaintenance deleteCandidateMaintenance(
			long candidateMaintenanceId) 
		throws PortalException {

		CandidateMaintenance currentCanMain = 
			candidateMaintenancePersistence.remove(candidateMaintenanceId);

		long candidateId = currentCanMain.getCandidateId();

		if(getCandidateMaintenaceTasksCount(candidateId) == 0) {
			CandidateEntryLocalServiceUtil.deleteCandidateEntry(candidateId);
		}

		return currentCanMain;
	}

	@Override
	public CandidateMaintenance getCandidateMaintenaceTask(
			long candidateId, long taskId)
		throws PortalException {

		try {
			return CandidateMaintenanceUtil.findByC_T(candidateId, taskId);
		} catch (NoSuchCandidateMaintenanceException e) {
			return null;
		}
	}

	/**
	 * Returns the task assignments belonging to the given candidate.
	 * 
	 * @param candidatId
	 * @return List of CandidateMaintenance entries with the given candidateId
	 */
	@Override
	public List<CandidateMaintenance> getCandidateMaintenaceTasks(
			long candidateId)
		throws PortalException {

		return candidateMaintenancePersistence.findByCandidateIds(candidateId);
	}

	/**
	 * Returns number of the task assignments belonging to the given candidate.
	 * 
	 * @param candidatId
	 * @return Number of CandidateMaintenance entries with the given candidateId
	 */
	@Override
	public long getCandidateMaintenaceTasksCount(long candidateId)
		throws PortalException {

		return getCandidateMaintenaceTasks(candidateId).size();
	}

	/**
	 * Returns the candidate assignments belonging to the given task.
	 * 
	 * @param taskId
	 * @return List of CandidateMaintenance entries with the given taskId
	 */
	@Override
	public List<CandidateMaintenance> getMaintenaceTasks(
			long taskId)
		throws PortalException {

		return candidateMaintenancePersistence.findByTaskIds(taskId);
	}

	/**
	 * Returns the number of the candidate assignments belonging to the given task.
	 * 
	 * @param taskId
	 * @return Number of CandidateMaintenance entries with the given taskId
	 */
	@Override
	public long getMaintenaceTasksCount(long taskId)
		throws PortalException {

		return getMaintenaceTasks(taskId).size();
	}

}
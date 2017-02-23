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

import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.model.TaskEntry;
import com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalServiceUtil;
import com.liferay.micro.maintainance.task.service.base.TaskEntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the task entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.task.service.TaskEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.task.service.TaskEntryLocalServiceUtil
 */
@ProviderType
public class TaskEntryLocalServiceImpl extends TaskEntryLocalServiceBaseImpl {

	@Override
	public TaskEntry addTaskEntry(String taskName) 
		throws PortalException {

		long taskId = counterLocalService.increment();
		Date now = new Date();

		TaskEntry taskEntry = taskEntryPersistence.create(taskId);

		taskEntry.setTaskName(taskName);
		taskEntry.setCreateDate(now);

		taskEntryPersistence.update(taskEntry);
	}

	/**
	 * Deletes the task entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the task entry
	 * @return the task entry that was removed
	 * @throws PortalException if a task entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TaskEntry deleteTaskEntry(long taskId) throws PortalException {
		
		List<CandidateMaintenance> canMainTasks = 
			CandidateMaintenanceLocalServiceUtil.getMaintenaceTasks(taskId);

		for (CandidateMaintenance canMaintask : canMainTasks) {
			CandidateMaintenanceLocalServiceUtil
				.deleteCandidateMaintenance(
					canMaintask.getCandidateMaintenanceId());
		}

		return taskEntryPersistence.remove(taskId);
	}
}
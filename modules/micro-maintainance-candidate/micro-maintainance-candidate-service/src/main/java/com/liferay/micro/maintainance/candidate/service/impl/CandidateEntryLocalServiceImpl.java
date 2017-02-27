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

package com.liferay.micro.maintainance.candidate.service.impl;

import java.util.Date;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.analysis.service.AnalysisEntryLocalServiceUtil;
import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.service.base.CandidateEntryLocalServiceBaseImpl;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the candidate entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalServiceUtil
 */
@ProviderType
public class CandidateEntryLocalServiceImpl
	extends CandidateEntryLocalServiceBaseImpl {

	/**
	 * Adds a candidate entry to the database
	 */
	@Override
	public CandidateEntry addCandidateEntry(
			long userId, long groupId, long wikiPageId, long taskId) 
		throws PortalException {
		
		User user = userPersistence.findByPrimaryKey(userId);
		long candidateId = counterLocalService.increment();
		Date now = new Date();

		CandidateEntry candidate = candidateEntryPersistence.create(candidateId);

		candidate.setGroupId(groupId);

		candidate.setCompanyId(user.getCompanyId());
		candidate.setUserId(userId);
		candidate.setUserName(user.getFullName());
		candidate.setCreateDate(now);
		candidate.setModifiedDate(now);

		candidate.setWikiPageId(wikiPageId);

		candidateEntryPersistence.update(candidate);

		CandidateMaintenance canMain = CandidateMaintenanceLocalServiceUtil
			.addCandidateMaintenance(candidateId, taskId);

		AnalysisEntry analysisEntry = AnalysisEntryLocalServiceUtil
			.addAnalysisEntry(userId, canMain.getCandidateMaintenanceId());

		return candidate;
	}

	/**
	 * Deletes the candidate entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the candidate entry
	 * @return the candidate entry that was removed
	 * @throws PortalException if a candidate entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CandidateEntry deleteCandidateEntry(long entryId)
		throws PortalException {

		long canMainCount = CandidateMaintenanceLocalServiceUtil
			.getCandidateMaintenaceTasksCount(entryId);

		if (canMainCount > 0) {
			throw new PortalException();
		}

		return candidateEntryPersistence.remove(entryId);
	}
}
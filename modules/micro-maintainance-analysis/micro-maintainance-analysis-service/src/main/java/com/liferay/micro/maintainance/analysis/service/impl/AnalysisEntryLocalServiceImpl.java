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

package com.liferay.micro.maintainance.analysis.service.impl;

import java.util.Date;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.analysis.service.base.AnalysisEntryLocalServiceBaseImpl;
import com.liferay.micro.maintainance.util.VotesJSONSerializer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the analysis entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.analysis.service.AnalysisEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.analysis.service.AnalysisEntryLocalServiceUtil
 */
@ProviderType
public class AnalysisEntryLocalServiceImpl
	extends AnalysisEntryLocalServiceBaseImpl {

	/**
	 * Adds an analysis entry
	 */
	@Override
	public AnalysisEntry addAnalysisEntry(long userId, long canMainId) 
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		long analysisId = counterLocalService.increment();

		AnalysisEntry analysisEntry = analysisEntryPersistence.create(
			analysisId);

		analysisEntry.setCompanyId(user.getCompanyId());
		analysisEntry.setUserId(userId);
		analysisEntry.setUserName(user.getFullName());
		analysisEntry.setCreateDate(now);
		analysisEntry.setModifiedDate(now);

		analysisEntry.setAnalysisData(VotesJSONSerializer.createVotes());
		analysisEntry.setCanMainId(canMainId);

		analysisEntryPersistence.update(analysisEntry);

		return analysisEntry;
	}
}
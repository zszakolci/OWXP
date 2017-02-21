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

package com.liferay.micro.maintainance.task.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the CandidateMaintenance service. Represents a row in the &quot;Task_CandidateMaintenance&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateMaintenanceModel
 * @see com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceImpl
 * @see com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceImpl")
@ProviderType
public interface CandidateMaintenance extends CandidateMaintenanceModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CandidateMaintenance, Long> CANDIDATE_MAINTENANCE_ID_ACCESSOR =
		new Accessor<CandidateMaintenance, Long>() {
			@Override
			public Long get(CandidateMaintenance candidateMaintenance) {
				return candidateMaintenance.getCandidateMaintenanceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CandidateMaintenance> getTypeClass() {
				return CandidateMaintenance.class;
			}
		};
}
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

package com.liferay.micro.maintainance.analysis.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AnalysisUser service. Represents a row in the &quot;Analysis_AnalysisUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisUserModel
 * @see com.liferay.micro.maintainance.analysis.model.impl.AnalysisUserImpl
 * @see com.liferay.micro.maintainance.analysis.model.impl.AnalysisUserModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.micro.maintainance.analysis.model.impl.AnalysisUserImpl")
@ProviderType
public interface AnalysisUser extends AnalysisUserModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnalysisUser, Long> ANALYSIS_USER_ID_ACCESSOR = new Accessor<AnalysisUser, Long>() {
			@Override
			public Long get(AnalysisUser analysisUser) {
				return analysisUser.getAnalysisUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnalysisUser> getTypeClass() {
				return AnalysisUser.class;
			}
		};
}
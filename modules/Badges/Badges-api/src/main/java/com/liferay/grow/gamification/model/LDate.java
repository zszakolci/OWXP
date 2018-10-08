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

package com.liferay.grow.gamification.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the LDate service. Represents a row in the &quot;gamification_LDate&quot; database table, with each column mapped to a property of this class.
 *
 * @author Vilmos Papp
 * @see LDateModel
 * @see com.liferay.grow.gamification.model.impl.LDateImpl
 * @see com.liferay.grow.gamification.model.impl.LDateModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.grow.gamification.model.impl.LDateImpl")
@ProviderType
public interface LDate extends LDateModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.grow.gamification.model.impl.LDateImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LDate, Long> DATE_ID_ACCESSOR = new Accessor<LDate, Long>() {
			@Override
			public Long get(LDate lDate) {
				return lDate.getDateId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LDate> getTypeClass() {
				return LDate.class;
			}
		};
}
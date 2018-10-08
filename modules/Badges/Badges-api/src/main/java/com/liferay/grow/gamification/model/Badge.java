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
 * The extended model interface for the Badge service. Represents a row in the &quot;gamification_Badge&quot; database table, with each column mapped to a property of this class.
 *
 * @author Vilmos Papp
 * @see BadgeModel
 * @see com.liferay.grow.gamification.model.impl.BadgeImpl
 * @see com.liferay.grow.gamification.model.impl.BadgeModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.grow.gamification.model.impl.BadgeImpl")
@ProviderType
public interface Badge extends BadgeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.grow.gamification.model.impl.BadgeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Badge, Long> BADGE_ID_ACCESSOR = new Accessor<Badge, Long>() {
			@Override
			public Long get(Badge badge) {
				return badge.getBadgeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Badge> getTypeClass() {
				return Badge.class;
			}
		};
}
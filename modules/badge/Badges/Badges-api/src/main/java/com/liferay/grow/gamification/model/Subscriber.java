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
 * The extended model interface for the Subscriber service. Represents a row in the &quot;gamification_Subscriber&quot; database table, with each column mapped to a property of this class.
 *
 * @author Vilmos Papp
 * @see SubscriberModel
 * @see com.liferay.grow.gamification.model.impl.SubscriberImpl
 * @see com.liferay.grow.gamification.model.impl.SubscriberModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.grow.gamification.model.impl.SubscriberImpl")
@ProviderType
public interface Subscriber extends SubscriberModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.grow.gamification.model.impl.SubscriberImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Subscriber, Long> SUBSCRIBER_ID_ACCESSOR = new Accessor<Subscriber, Long>() {
			@Override
			public Long get(Subscriber subscriber) {
				return subscriber.getSubscriberId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Subscriber> getTypeClass() {
				return Subscriber.class;
			}
		};
}
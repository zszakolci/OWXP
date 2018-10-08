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

package com.liferay.grow.gamification.service.impl;

import com.liferay.grow.gamification.model.BadgeType;
import com.liferay.grow.gamification.service.base.BadgeTypeLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the badge type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.grow.gamification.service.BadgeTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Vilmos Papp
 * @see BadgeTypeLocalServiceBaseImpl
 * @see com.liferay.grow.gamification.service.BadgeTypeLocalServiceUtil
 */
public class BadgeTypeLocalServiceImpl extends BadgeTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.grow.gamification.service.BadgeTypeLocalServiceUtil} to access the badge type local service.
	 */
	public List<BadgeType> getAvailableBadgeTypes() {
		List<BadgeType> allBadgeTypes = badgeTypePersistence.findAll();
		List<BadgeType> availableBadgeTypes = new ArrayList<>();
		Date now = new Date();

		for (BadgeType badgeType : allBadgeTypes) {
			if ((badgeType.getAssignableTo() == null) || now.before(badgeType.getAssignableTo())) {
				availableBadgeTypes.add(badgeType);
			}
		}
		return availableBadgeTypes;
	}
}
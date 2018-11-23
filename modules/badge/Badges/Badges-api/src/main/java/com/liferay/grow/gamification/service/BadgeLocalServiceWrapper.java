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

package com.liferay.grow.gamification.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BadgeLocalService}.
 *
 * @author Vilmos Papp
 * @see BadgeLocalService
 * @generated
 */
@ProviderType
public class BadgeLocalServiceWrapper implements BadgeLocalService,
	ServiceWrapper<BadgeLocalService> {
	public BadgeLocalServiceWrapper(BadgeLocalService badgeLocalService) {
		_badgeLocalService = badgeLocalService;
	}

	/**
	* Adds the badge to the database. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @return the badge that was added
	*/
	@Override
	public com.liferay.grow.gamification.model.Badge addBadge(
		com.liferay.grow.gamification.model.Badge badge) {
		return _badgeLocalService.addBadge(badge);
	}

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	@Override
	public com.liferay.grow.gamification.model.Badge createBadge(long badgeId) {
		return _badgeLocalService.createBadge(badgeId);
	}

	/**
	* Deletes the badge from the database. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @return the badge that was removed
	*/
	@Override
	public com.liferay.grow.gamification.model.Badge deleteBadge(
		com.liferay.grow.gamification.model.Badge badge) {
		return _badgeLocalService.deleteBadge(badge);
	}

	/**
	* Deletes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws PortalException if a badge with the primary key could not be found
	*/
	@Override
	public com.liferay.grow.gamification.model.Badge deleteBadge(long badgeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _badgeLocalService.deleteBadge(badgeId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _badgeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _badgeLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _badgeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.grow.gamification.model.impl.BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _badgeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.grow.gamification.model.impl.BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _badgeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _badgeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _badgeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.grow.gamification.model.Badge fetchBadge(long badgeId) {
		return _badgeLocalService.fetchBadge(badgeId);
	}

	/**
	* Returns the badge matching the UUID and group.
	*
	* @param uuid the badge's UUID
	* @param groupId the primary key of the group
	* @return the matching badge, or <code>null</code> if a matching badge could not be found
	*/
	@Override
	public com.liferay.grow.gamification.model.Badge fetchBadgeByUuidAndGroupId(
		String uuid, long groupId) {
		return _badgeLocalService.fetchBadgeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _badgeLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the badge with the primary key.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws PortalException if a badge with the primary key could not be found
	*/
	@Override
	public com.liferay.grow.gamification.model.Badge getBadge(long badgeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _badgeLocalService.getBadge(badgeId);
	}

	/**
	* Returns the badge matching the UUID and group.
	*
	* @param uuid the badge's UUID
	* @param groupId the primary key of the group
	* @return the matching badge
	* @throws PortalException if a matching badge could not be found
	*/
	@Override
	public com.liferay.grow.gamification.model.Badge getBadgeByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _badgeLocalService.getBadgeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.grow.gamification.model.impl.BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of badges
	*/
	@Override
	public java.util.List<com.liferay.grow.gamification.model.Badge> getBadges(
		int start, int end) {
		return _badgeLocalService.getBadges(start, end);
	}

	/**
	* Returns all the badges matching the UUID and company.
	*
	* @param uuid the UUID of the badges
	* @param companyId the primary key of the company
	* @return the matching badges, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.grow.gamification.model.Badge> getBadgesByUuidAndCompanyId(
		String uuid, long companyId) {
		return _badgeLocalService.getBadgesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of badges matching the UUID and company.
	*
	* @param uuid the UUID of the badges
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching badges, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.grow.gamification.model.Badge> getBadgesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.grow.gamification.model.Badge> orderByComparator) {
		return _badgeLocalService.getBadgesByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	*/
	@Override
	public int getBadgesCount() {
		return _badgeLocalService.getBadgesCount();
	}

	@Override
	public java.util.List<com.liferay.grow.gamification.model.Badge> getBadgesOfUser(
		long userId) {
		return _badgeLocalService.getBadgesOfUser(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _badgeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _badgeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _badgeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the badge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @return the badge that was updated
	*/
	@Override
	public com.liferay.grow.gamification.model.Badge updateBadge(
		com.liferay.grow.gamification.model.Badge badge) {
		return _badgeLocalService.updateBadge(badge);
	}

	@Override
	public BadgeLocalService getWrappedService() {
		return _badgeLocalService;
	}

	@Override
	public void setWrappedService(BadgeLocalService badgeLocalService) {
		_badgeLocalService = badgeLocalService;
	}

	private BadgeLocalService _badgeLocalService;
}
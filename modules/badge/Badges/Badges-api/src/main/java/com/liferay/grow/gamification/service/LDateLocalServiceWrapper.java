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
 * Provides a wrapper for {@link LDateLocalService}.
 *
 * @author Vilmos Papp
 * @see LDateLocalService
 * @generated
 */
@ProviderType
public class LDateLocalServiceWrapper implements LDateLocalService,
	ServiceWrapper<LDateLocalService> {
	public LDateLocalServiceWrapper(LDateLocalService lDateLocalService) {
		_lDateLocalService = lDateLocalService;
	}

	/**
	* Adds the l date to the database. Also notifies the appropriate model listeners.
	*
	* @param lDate the l date
	* @return the l date that was added
	*/
	@Override
	public com.liferay.grow.gamification.model.LDate addLDate(
		com.liferay.grow.gamification.model.LDate lDate) {
		return _lDateLocalService.addLDate(lDate);
	}

	/**
	* Creates a new l date with the primary key. Does not add the l date to the database.
	*
	* @param dateId the primary key for the new l date
	* @return the new l date
	*/
	@Override
	public com.liferay.grow.gamification.model.LDate createLDate(long dateId) {
		return _lDateLocalService.createLDate(dateId);
	}

	/**
	* Deletes the l date from the database. Also notifies the appropriate model listeners.
	*
	* @param lDate the l date
	* @return the l date that was removed
	*/
	@Override
	public com.liferay.grow.gamification.model.LDate deleteLDate(
		com.liferay.grow.gamification.model.LDate lDate) {
		return _lDateLocalService.deleteLDate(lDate);
	}

	/**
	* Deletes the l date with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dateId the primary key of the l date
	* @return the l date that was removed
	* @throws PortalException if a l date with the primary key could not be found
	*/
	@Override
	public com.liferay.grow.gamification.model.LDate deleteLDate(long dateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lDateLocalService.deleteLDate(dateId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lDateLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lDateLocalService.dynamicQuery();
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
		return _lDateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.grow.gamification.model.impl.LDateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lDateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.grow.gamification.model.impl.LDateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _lDateLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _lDateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _lDateLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.grow.gamification.model.LDate fetchLDate(long dateId) {
		return _lDateLocalService.fetchLDate(dateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _lDateLocalService.getActionableDynamicQuery();
	}

	@Override
	public long getDateId(int year, int month, int day)
		throws com.liferay.grow.gamification.exception.NoSuchLDateException {
		return _lDateLocalService.getDateId(year, month, day);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _lDateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the l date with the primary key.
	*
	* @param dateId the primary key of the l date
	* @return the l date
	* @throws PortalException if a l date with the primary key could not be found
	*/
	@Override
	public com.liferay.grow.gamification.model.LDate getLDate(long dateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lDateLocalService.getLDate(dateId);
	}

	/**
	* Returns a range of all the l dates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.grow.gamification.model.impl.LDateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l dates
	* @param end the upper bound of the range of l dates (not inclusive)
	* @return the range of l dates
	*/
	@Override
	public java.util.List<com.liferay.grow.gamification.model.LDate> getLDates(
		int start, int end) {
		return _lDateLocalService.getLDates(start, end);
	}

	/**
	* Returns the number of l dates.
	*
	* @return the number of l dates
	*/
	@Override
	public int getLDatesCount() {
		return _lDateLocalService.getLDatesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _lDateLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lDateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the l date in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lDate the l date
	* @return the l date that was updated
	*/
	@Override
	public com.liferay.grow.gamification.model.LDate updateLDate(
		com.liferay.grow.gamification.model.LDate lDate) {
		return _lDateLocalService.updateLDate(lDate);
	}

	@Override
	public LDateLocalService getWrappedService() {
		return _lDateLocalService;
	}

	@Override
	public void setWrappedService(LDateLocalService lDateLocalService) {
		_lDateLocalService = lDateLocalService;
	}

	private LDateLocalService _lDateLocalService;
}
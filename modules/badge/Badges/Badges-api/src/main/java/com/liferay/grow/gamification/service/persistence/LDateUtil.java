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

package com.liferay.grow.gamification.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.grow.gamification.model.LDate;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the l date service. This utility wraps {@link com.liferay.grow.gamification.service.persistence.impl.LDatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see LDatePersistence
 * @see com.liferay.grow.gamification.service.persistence.impl.LDatePersistenceImpl
 * @generated
 */
@ProviderType
public class LDateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(LDate lDate) {
		getPersistence().clearCache(lDate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LDate> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LDate> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LDate> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<LDate> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LDate update(LDate lDate) {
		return getPersistence().update(lDate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LDate update(LDate lDate, ServiceContext serviceContext) {
		return getPersistence().update(lDate, serviceContext);
	}

	/**
	* Returns the l date where year = &#63; and month = &#63; and day = &#63; or throws a {@link NoSuchLDateException} if it could not be found.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return the matching l date
	* @throws NoSuchLDateException if a matching l date could not be found
	*/
	public static LDate findByY_M_D(int year, int month, int day)
		throws com.liferay.grow.gamification.exception.NoSuchLDateException {
		return getPersistence().findByY_M_D(year, month, day);
	}

	/**
	* Returns the l date where year = &#63; and month = &#63; and day = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return the matching l date, or <code>null</code> if a matching l date could not be found
	*/
	public static LDate fetchByY_M_D(int year, int month, int day) {
		return getPersistence().fetchByY_M_D(year, month, day);
	}

	/**
	* Returns the l date where year = &#63; and month = &#63; and day = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching l date, or <code>null</code> if a matching l date could not be found
	*/
	public static LDate fetchByY_M_D(int year, int month, int day,
		boolean retrieveFromCache) {
		return getPersistence().fetchByY_M_D(year, month, day, retrieveFromCache);
	}

	/**
	* Removes the l date where year = &#63; and month = &#63; and day = &#63; from the database.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return the l date that was removed
	*/
	public static LDate removeByY_M_D(int year, int month, int day)
		throws com.liferay.grow.gamification.exception.NoSuchLDateException {
		return getPersistence().removeByY_M_D(year, month, day);
	}

	/**
	* Returns the number of l dates where year = &#63; and month = &#63; and day = &#63;.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return the number of matching l dates
	*/
	public static int countByY_M_D(int year, int month, int day) {
		return getPersistence().countByY_M_D(year, month, day);
	}

	/**
	* Caches the l date in the entity cache if it is enabled.
	*
	* @param lDate the l date
	*/
	public static void cacheResult(LDate lDate) {
		getPersistence().cacheResult(lDate);
	}

	/**
	* Caches the l dates in the entity cache if it is enabled.
	*
	* @param lDates the l dates
	*/
	public static void cacheResult(List<LDate> lDates) {
		getPersistence().cacheResult(lDates);
	}

	/**
	* Creates a new l date with the primary key. Does not add the l date to the database.
	*
	* @param dateId the primary key for the new l date
	* @return the new l date
	*/
	public static LDate create(long dateId) {
		return getPersistence().create(dateId);
	}

	/**
	* Removes the l date with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dateId the primary key of the l date
	* @return the l date that was removed
	* @throws NoSuchLDateException if a l date with the primary key could not be found
	*/
	public static LDate remove(long dateId)
		throws com.liferay.grow.gamification.exception.NoSuchLDateException {
		return getPersistence().remove(dateId);
	}

	public static LDate updateImpl(LDate lDate) {
		return getPersistence().updateImpl(lDate);
	}

	/**
	* Returns the l date with the primary key or throws a {@link NoSuchLDateException} if it could not be found.
	*
	* @param dateId the primary key of the l date
	* @return the l date
	* @throws NoSuchLDateException if a l date with the primary key could not be found
	*/
	public static LDate findByPrimaryKey(long dateId)
		throws com.liferay.grow.gamification.exception.NoSuchLDateException {
		return getPersistence().findByPrimaryKey(dateId);
	}

	/**
	* Returns the l date with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dateId the primary key of the l date
	* @return the l date, or <code>null</code> if a l date with the primary key could not be found
	*/
	public static LDate fetchByPrimaryKey(long dateId) {
		return getPersistence().fetchByPrimaryKey(dateId);
	}

	public static java.util.Map<java.io.Serializable, LDate> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the l dates.
	*
	* @return the l dates
	*/
	public static List<LDate> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the l dates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LDateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l dates
	* @param end the upper bound of the range of l dates (not inclusive)
	* @return the range of l dates
	*/
	public static List<LDate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the l dates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LDateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l dates
	* @param end the upper bound of the range of l dates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l dates
	*/
	public static List<LDate> findAll(int start, int end,
		OrderByComparator<LDate> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the l dates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LDateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l dates
	* @param end the upper bound of the range of l dates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of l dates
	*/
	public static List<LDate> findAll(int start, int end,
		OrderByComparator<LDate> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the l dates from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l dates.
	*
	* @return the number of l dates
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LDatePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LDatePersistence, LDatePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LDatePersistence.class);

		ServiceTracker<LDatePersistence, LDatePersistence> serviceTracker = new ServiceTracker<LDatePersistence, LDatePersistence>(bundle.getBundleContext(),
				LDatePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
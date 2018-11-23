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

import com.liferay.grow.gamification.exception.NoSuchLDateException;
import com.liferay.grow.gamification.model.LDate;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the l date service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see com.liferay.grow.gamification.service.persistence.impl.LDatePersistenceImpl
 * @see LDateUtil
 * @generated
 */
@ProviderType
public interface LDatePersistence extends BasePersistence<LDate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LDateUtil} to access the l date persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the l date where year = &#63; and month = &#63; and day = &#63; or throws a {@link NoSuchLDateException} if it could not be found.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return the matching l date
	* @throws NoSuchLDateException if a matching l date could not be found
	*/
	public LDate findByY_M_D(int year, int month, int day)
		throws NoSuchLDateException;

	/**
	* Returns the l date where year = &#63; and month = &#63; and day = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return the matching l date, or <code>null</code> if a matching l date could not be found
	*/
	public LDate fetchByY_M_D(int year, int month, int day);

	/**
	* Returns the l date where year = &#63; and month = &#63; and day = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching l date, or <code>null</code> if a matching l date could not be found
	*/
	public LDate fetchByY_M_D(int year, int month, int day,
		boolean retrieveFromCache);

	/**
	* Removes the l date where year = &#63; and month = &#63; and day = &#63; from the database.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return the l date that was removed
	*/
	public LDate removeByY_M_D(int year, int month, int day)
		throws NoSuchLDateException;

	/**
	* Returns the number of l dates where year = &#63; and month = &#63; and day = &#63;.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return the number of matching l dates
	*/
	public int countByY_M_D(int year, int month, int day);

	/**
	* Caches the l date in the entity cache if it is enabled.
	*
	* @param lDate the l date
	*/
	public void cacheResult(LDate lDate);

	/**
	* Caches the l dates in the entity cache if it is enabled.
	*
	* @param lDates the l dates
	*/
	public void cacheResult(java.util.List<LDate> lDates);

	/**
	* Creates a new l date with the primary key. Does not add the l date to the database.
	*
	* @param dateId the primary key for the new l date
	* @return the new l date
	*/
	public LDate create(long dateId);

	/**
	* Removes the l date with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dateId the primary key of the l date
	* @return the l date that was removed
	* @throws NoSuchLDateException if a l date with the primary key could not be found
	*/
	public LDate remove(long dateId) throws NoSuchLDateException;

	public LDate updateImpl(LDate lDate);

	/**
	* Returns the l date with the primary key or throws a {@link NoSuchLDateException} if it could not be found.
	*
	* @param dateId the primary key of the l date
	* @return the l date
	* @throws NoSuchLDateException if a l date with the primary key could not be found
	*/
	public LDate findByPrimaryKey(long dateId) throws NoSuchLDateException;

	/**
	* Returns the l date with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dateId the primary key of the l date
	* @return the l date, or <code>null</code> if a l date with the primary key could not be found
	*/
	public LDate fetchByPrimaryKey(long dateId);

	@Override
	public java.util.Map<java.io.Serializable, LDate> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the l dates.
	*
	* @return the l dates
	*/
	public java.util.List<LDate> findAll();

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
	public java.util.List<LDate> findAll(int start, int end);

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
	public java.util.List<LDate> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LDate> orderByComparator);

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
	public java.util.List<LDate> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LDate> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the l dates from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of l dates.
	*
	* @return the number of l dates
	*/
	public int countAll();
}
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

import com.liferay.grow.gamification.model.BadgeType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the badge type service. This utility wraps {@link com.liferay.grow.gamification.service.persistence.impl.BadgeTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see BadgeTypePersistence
 * @see com.liferay.grow.gamification.service.persistence.impl.BadgeTypePersistenceImpl
 * @generated
 */
@ProviderType
public class BadgeTypeUtil {
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
	public static void clearCache(BadgeType badgeType) {
		getPersistence().clearCache(badgeType);
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
	public static List<BadgeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BadgeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BadgeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BadgeType> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BadgeType update(BadgeType badgeType) {
		return getPersistence().update(badgeType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BadgeType update(BadgeType badgeType,
		ServiceContext serviceContext) {
		return getPersistence().update(badgeType, serviceContext);
	}

	/**
	* Returns all the badge types where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @return the matching badge types
	*/
	public static List<BadgeType> findByavailableTo(Date assignableTo) {
		return getPersistence().findByavailableTo(assignableTo);
	}

	/**
	* Returns a range of all the badge types where assignableTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assignableTo the assignable to
	* @param start the lower bound of the range of badge types
	* @param end the upper bound of the range of badge types (not inclusive)
	* @return the range of matching badge types
	*/
	public static List<BadgeType> findByavailableTo(Date assignableTo,
		int start, int end) {
		return getPersistence().findByavailableTo(assignableTo, start, end);
	}

	/**
	* Returns an ordered range of all the badge types where assignableTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assignableTo the assignable to
	* @param start the lower bound of the range of badge types
	* @param end the upper bound of the range of badge types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badge types
	*/
	public static List<BadgeType> findByavailableTo(Date assignableTo,
		int start, int end, OrderByComparator<BadgeType> orderByComparator) {
		return getPersistence()
				   .findByavailableTo(assignableTo, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the badge types where assignableTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param assignableTo the assignable to
	* @param start the lower bound of the range of badge types
	* @param end the upper bound of the range of badge types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching badge types
	*/
	public static List<BadgeType> findByavailableTo(Date assignableTo,
		int start, int end, OrderByComparator<BadgeType> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByavailableTo(assignableTo, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first badge type in the ordered set where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge type
	* @throws NoSuchBadgeTypeException if a matching badge type could not be found
	*/
	public static BadgeType findByavailableTo_First(Date assignableTo,
		OrderByComparator<BadgeType> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeTypeException {
		return getPersistence()
				   .findByavailableTo_First(assignableTo, orderByComparator);
	}

	/**
	* Returns the first badge type in the ordered set where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public static BadgeType fetchByavailableTo_First(Date assignableTo,
		OrderByComparator<BadgeType> orderByComparator) {
		return getPersistence()
				   .fetchByavailableTo_First(assignableTo, orderByComparator);
	}

	/**
	* Returns the last badge type in the ordered set where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge type
	* @throws NoSuchBadgeTypeException if a matching badge type could not be found
	*/
	public static BadgeType findByavailableTo_Last(Date assignableTo,
		OrderByComparator<BadgeType> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeTypeException {
		return getPersistence()
				   .findByavailableTo_Last(assignableTo, orderByComparator);
	}

	/**
	* Returns the last badge type in the ordered set where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public static BadgeType fetchByavailableTo_Last(Date assignableTo,
		OrderByComparator<BadgeType> orderByComparator) {
		return getPersistence()
				   .fetchByavailableTo_Last(assignableTo, orderByComparator);
	}

	/**
	* Returns the badge types before and after the current badge type in the ordered set where assignableTo = &#63;.
	*
	* @param badgeTypeId the primary key of the current badge type
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge type
	* @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	*/
	public static BadgeType[] findByavailableTo_PrevAndNext(long badgeTypeId,
		Date assignableTo, OrderByComparator<BadgeType> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeTypeException {
		return getPersistence()
				   .findByavailableTo_PrevAndNext(badgeTypeId, assignableTo,
			orderByComparator);
	}

	/**
	* Removes all the badge types where assignableTo = &#63; from the database.
	*
	* @param assignableTo the assignable to
	*/
	public static void removeByavailableTo(Date assignableTo) {
		getPersistence().removeByavailableTo(assignableTo);
	}

	/**
	* Returns the number of badge types where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @return the number of matching badge types
	*/
	public static int countByavailableTo(Date assignableTo) {
		return getPersistence().countByavailableTo(assignableTo);
	}

	/**
	* Returns the badge type where badgeTypeId = &#63; or throws a {@link NoSuchBadgeTypeException} if it could not be found.
	*
	* @param badgeTypeId the badge type ID
	* @return the matching badge type
	* @throws NoSuchBadgeTypeException if a matching badge type could not be found
	*/
	public static BadgeType findBybadgeTypeId(long badgeTypeId)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeTypeException {
		return getPersistence().findBybadgeTypeId(badgeTypeId);
	}

	/**
	* Returns the badge type where badgeTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param badgeTypeId the badge type ID
	* @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public static BadgeType fetchBybadgeTypeId(long badgeTypeId) {
		return getPersistence().fetchBybadgeTypeId(badgeTypeId);
	}

	/**
	* Returns the badge type where badgeTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param badgeTypeId the badge type ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public static BadgeType fetchBybadgeTypeId(long badgeTypeId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBybadgeTypeId(badgeTypeId, retrieveFromCache);
	}

	/**
	* Removes the badge type where badgeTypeId = &#63; from the database.
	*
	* @param badgeTypeId the badge type ID
	* @return the badge type that was removed
	*/
	public static BadgeType removeBybadgeTypeId(long badgeTypeId)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeTypeException {
		return getPersistence().removeBybadgeTypeId(badgeTypeId);
	}

	/**
	* Returns the number of badge types where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @return the number of matching badge types
	*/
	public static int countBybadgeTypeId(long badgeTypeId) {
		return getPersistence().countBybadgeTypeId(badgeTypeId);
	}

	/**
	* Returns the badge type where type = &#63; or throws a {@link NoSuchBadgeTypeException} if it could not be found.
	*
	* @param type the type
	* @return the matching badge type
	* @throws NoSuchBadgeTypeException if a matching badge type could not be found
	*/
	public static BadgeType findBytype(String type)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeTypeException {
		return getPersistence().findBytype(type);
	}

	/**
	* Returns the badge type where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param type the type
	* @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public static BadgeType fetchBytype(String type) {
		return getPersistence().fetchBytype(type);
	}

	/**
	* Returns the badge type where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param type the type
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public static BadgeType fetchBytype(String type, boolean retrieveFromCache) {
		return getPersistence().fetchBytype(type, retrieveFromCache);
	}

	/**
	* Removes the badge type where type = &#63; from the database.
	*
	* @param type the type
	* @return the badge type that was removed
	*/
	public static BadgeType removeBytype(String type)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeTypeException {
		return getPersistence().removeBytype(type);
	}

	/**
	* Returns the number of badge types where type = &#63;.
	*
	* @param type the type
	* @return the number of matching badge types
	*/
	public static int countBytype(String type) {
		return getPersistence().countBytype(type);
	}

	/**
	* Caches the badge type in the entity cache if it is enabled.
	*
	* @param badgeType the badge type
	*/
	public static void cacheResult(BadgeType badgeType) {
		getPersistence().cacheResult(badgeType);
	}

	/**
	* Caches the badge types in the entity cache if it is enabled.
	*
	* @param badgeTypes the badge types
	*/
	public static void cacheResult(List<BadgeType> badgeTypes) {
		getPersistence().cacheResult(badgeTypes);
	}

	/**
	* Creates a new badge type with the primary key. Does not add the badge type to the database.
	*
	* @param badgeTypeId the primary key for the new badge type
	* @return the new badge type
	*/
	public static BadgeType create(long badgeTypeId) {
		return getPersistence().create(badgeTypeId);
	}

	/**
	* Removes the badge type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeTypeId the primary key of the badge type
	* @return the badge type that was removed
	* @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	*/
	public static BadgeType remove(long badgeTypeId)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeTypeException {
		return getPersistence().remove(badgeTypeId);
	}

	public static BadgeType updateImpl(BadgeType badgeType) {
		return getPersistence().updateImpl(badgeType);
	}

	/**
	* Returns the badge type with the primary key or throws a {@link NoSuchBadgeTypeException} if it could not be found.
	*
	* @param badgeTypeId the primary key of the badge type
	* @return the badge type
	* @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	*/
	public static BadgeType findByPrimaryKey(long badgeTypeId)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeTypeException {
		return getPersistence().findByPrimaryKey(badgeTypeId);
	}

	/**
	* Returns the badge type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeTypeId the primary key of the badge type
	* @return the badge type, or <code>null</code> if a badge type with the primary key could not be found
	*/
	public static BadgeType fetchByPrimaryKey(long badgeTypeId) {
		return getPersistence().fetchByPrimaryKey(badgeTypeId);
	}

	public static java.util.Map<java.io.Serializable, BadgeType> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the badge types.
	*
	* @return the badge types
	*/
	public static List<BadgeType> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the badge types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badge types
	* @param end the upper bound of the range of badge types (not inclusive)
	* @return the range of badge types
	*/
	public static List<BadgeType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the badge types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badge types
	* @param end the upper bound of the range of badge types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of badge types
	*/
	public static List<BadgeType> findAll(int start, int end,
		OrderByComparator<BadgeType> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the badge types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badge types
	* @param end the upper bound of the range of badge types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of badge types
	*/
	public static List<BadgeType> findAll(int start, int end,
		OrderByComparator<BadgeType> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the badge types from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of badge types.
	*
	* @return the number of badge types
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static BadgeTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BadgeTypePersistence, BadgeTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BadgeTypePersistence.class);

		ServiceTracker<BadgeTypePersistence, BadgeTypePersistence> serviceTracker =
			new ServiceTracker<BadgeTypePersistence, BadgeTypePersistence>(bundle.getBundleContext(),
				BadgeTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
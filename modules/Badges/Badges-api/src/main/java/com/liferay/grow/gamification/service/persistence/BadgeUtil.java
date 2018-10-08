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

import com.liferay.grow.gamification.model.Badge;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the badge service. This utility wraps {@link com.liferay.grow.gamification.service.persistence.impl.BadgePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see BadgePersistence
 * @see com.liferay.grow.gamification.service.persistence.impl.BadgePersistenceImpl
 * @generated
 */
@ProviderType
public class BadgeUtil {
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
	public static void clearCache(Badge badge) {
		getPersistence().clearCache(badge);
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
	public static List<Badge> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Badge> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Badge> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Badge update(Badge badge) {
		return getPersistence().update(badge);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Badge update(Badge badge, ServiceContext serviceContext) {
		return getPersistence().update(badge, serviceContext);
	}

	/**
	* Returns all the badges where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching badges
	*/
	public static List<Badge> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the badges where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of matching badges
	*/
	public static List<Badge> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the badges where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findByUuid(String uuid, int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the badges where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findByUuid(String uuid, int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first badge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findByUuid_First(String uuid,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first badge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchByUuid_First(String uuid,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findByUuid_Last(String uuid,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchByUuid_Last(String uuid,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the badges before and after the current badge in the ordered set where uuid = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge[] findByUuid_PrevAndNext(long badgeId, String uuid,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence()
				   .findByUuid_PrevAndNext(badgeId, uuid, orderByComparator);
	}

	/**
	* Removes all the badges where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of badges where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching badges
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the badge where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchBadgeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findByUUID_G(String uuid, long groupId)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the badge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the badge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the badge where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the badge that was removed
	*/
	public static Badge removeByUUID_G(String uuid, long groupId)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of badges where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching badges
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the badges where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching badges
	*/
	public static List<Badge> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the badges where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of matching badges
	*/
	public static List<Badge> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the badges where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the badges where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first badge in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first badge in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the badges before and after the current badge in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge[] findByUuid_C_PrevAndNext(long badgeId, String uuid,
		long companyId, OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(badgeId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the badges where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of badges where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching badges
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the badges where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @return the matching badges
	*/
	public static List<Badge> findBybadgeType(long badgeTypeId) {
		return getPersistence().findBybadgeType(badgeTypeId);
	}

	/**
	* Returns a range of all the badges where badgeTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeTypeId the badge type ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of matching badges
	*/
	public static List<Badge> findBybadgeType(long badgeTypeId, int start,
		int end) {
		return getPersistence().findBybadgeType(badgeTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the badges where badgeTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeTypeId the badge type ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findBybadgeType(long badgeTypeId, int start,
		int end, OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .findBybadgeType(badgeTypeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the badges where badgeTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeTypeId the badge type ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findBybadgeType(long badgeTypeId, int start,
		int end, OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybadgeType(badgeTypeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findBybadgeType_First(long badgeTypeId,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBybadgeType_First(badgeTypeId, orderByComparator);
	}

	/**
	* Returns the first badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchBybadgeType_First(long badgeTypeId,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .fetchBybadgeType_First(badgeTypeId, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findBybadgeType_Last(long badgeTypeId,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBybadgeType_Last(badgeTypeId, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchBybadgeType_Last(long badgeTypeId,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .fetchBybadgeType_Last(badgeTypeId, orderByComparator);
	}

	/**
	* Returns the badges before and after the current badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge[] findBybadgeType_PrevAndNext(long badgeId,
		long badgeTypeId, OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBybadgeType_PrevAndNext(badgeId, badgeTypeId,
			orderByComparator);
	}

	/**
	* Removes all the badges where badgeTypeId = &#63; from the database.
	*
	* @param badgeTypeId the badge type ID
	*/
	public static void removeBybadgeType(long badgeTypeId) {
		getPersistence().removeBybadgeType(badgeTypeId);
	}

	/**
	* Returns the number of badges where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @return the number of matching badges
	*/
	public static int countBybadgeType(long badgeTypeId) {
		return getPersistence().countBybadgeType(badgeTypeId);
	}

	/**
	* Returns all the badges where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching badges
	*/
	public static List<Badge> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	* Returns a range of all the badges where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of matching badges
	*/
	public static List<Badge> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the badges where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findByuserId(long userId, int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the badges where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findByuserId(long userId, int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findByuserId_First(long userId,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchByuserId_First(long userId,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findByuserId_Last(long userId,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchByuserId_Last(long userId,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the badges before and after the current badge in the ordered set where userId = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge[] findByuserId_PrevAndNext(long badgeId, long userId,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence()
				   .findByuserId_PrevAndNext(badgeId, userId, orderByComparator);
	}

	/**
	* Removes all the badges where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of badges where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching badges
	*/
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Returns all the badges where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @return the matching badges
	*/
	public static List<Badge> findBytoUserId(long toUserId) {
		return getPersistence().findBytoUserId(toUserId);
	}

	/**
	* Returns a range of all the badges where toUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toUserId the to user ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of matching badges
	*/
	public static List<Badge> findBytoUserId(long toUserId, int start, int end) {
		return getPersistence().findBytoUserId(toUserId, start, end);
	}

	/**
	* Returns an ordered range of all the badges where toUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toUserId the to user ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findBytoUserId(long toUserId, int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .findBytoUserId(toUserId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the badges where toUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toUserId the to user ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching badges
	*/
	public static List<Badge> findBytoUserId(long toUserId, int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findBytoUserId(toUserId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first badge in the ordered set where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findBytoUserId_First(long toUserId,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().findBytoUserId_First(toUserId, orderByComparator);
	}

	/**
	* Returns the first badge in the ordered set where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchBytoUserId_First(long toUserId,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence()
				   .fetchBytoUserId_First(toUserId, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public static Badge findBytoUserId_Last(long toUserId,
		OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().findBytoUserId_Last(toUserId, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public static Badge fetchBytoUserId_Last(long toUserId,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence().fetchBytoUserId_Last(toUserId, orderByComparator);
	}

	/**
	* Returns the badges before and after the current badge in the ordered set where toUserId = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge[] findBytoUserId_PrevAndNext(long badgeId,
		long toUserId, OrderByComparator<Badge> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence()
				   .findBytoUserId_PrevAndNext(badgeId, toUserId,
			orderByComparator);
	}

	/**
	* Removes all the badges where toUserId = &#63; from the database.
	*
	* @param toUserId the to user ID
	*/
	public static void removeBytoUserId(long toUserId) {
		getPersistence().removeBytoUserId(toUserId);
	}

	/**
	* Returns the number of badges where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @return the number of matching badges
	*/
	public static int countBytoUserId(long toUserId) {
		return getPersistence().countBytoUserId(toUserId);
	}

	/**
	* Caches the badge in the entity cache if it is enabled.
	*
	* @param badge the badge
	*/
	public static void cacheResult(Badge badge) {
		getPersistence().cacheResult(badge);
	}

	/**
	* Caches the badges in the entity cache if it is enabled.
	*
	* @param badges the badges
	*/
	public static void cacheResult(List<Badge> badges) {
		getPersistence().cacheResult(badges);
	}

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	public static Badge create(long badgeId) {
		return getPersistence().create(badgeId);
	}

	/**
	* Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge remove(long badgeId)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().remove(badgeId);
	}

	public static Badge updateImpl(Badge badge) {
		return getPersistence().updateImpl(badge);
	}

	/**
	* Returns the badge with the primary key or throws a {@link NoSuchBadgeException} if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public static Badge findByPrimaryKey(long badgeId)
		throws com.liferay.grow.gamification.exception.NoSuchBadgeException {
		return getPersistence().findByPrimaryKey(badgeId);
	}

	/**
	* Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge, or <code>null</code> if a badge with the primary key could not be found
	*/
	public static Badge fetchByPrimaryKey(long badgeId) {
		return getPersistence().fetchByPrimaryKey(badgeId);
	}

	public static java.util.Map<java.io.Serializable, Badge> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the badges.
	*
	* @return the badges
	*/
	public static List<Badge> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of badges
	*/
	public static List<Badge> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of badges
	*/
	public static List<Badge> findAll(int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of badges
	*/
	public static List<Badge> findAll(int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the badges from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static BadgePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BadgePersistence, BadgePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BadgePersistence.class);

		ServiceTracker<BadgePersistence, BadgePersistence> serviceTracker = new ServiceTracker<BadgePersistence, BadgePersistence>(bundle.getBundleContext(),
				BadgePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
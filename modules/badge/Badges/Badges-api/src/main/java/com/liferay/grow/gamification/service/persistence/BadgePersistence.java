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

import com.liferay.grow.gamification.exception.NoSuchBadgeException;
import com.liferay.grow.gamification.model.Badge;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see com.liferay.grow.gamification.service.persistence.impl.BadgePersistenceImpl
 * @see BadgeUtil
 * @generated
 */
@ProviderType
public interface BadgePersistence extends BasePersistence<Badge> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BadgeUtil} to access the badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the badges where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching badges
	*/
	public java.util.List<Badge> findByUuid(String uuid);

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
	public java.util.List<Badge> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Badge> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public java.util.List<Badge> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first badge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the first badge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the last badge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the last badge in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the badges before and after the current badge in the ordered set where uuid = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public Badge[] findByUuid_PrevAndNext(long badgeId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Removes all the badges where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of badges where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching badges
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the badge where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchBadgeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findByUUID_G(String uuid, long groupId)
		throws NoSuchBadgeException;

	/**
	* Returns the badge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the badge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the badge where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the badge that was removed
	*/
	public Badge removeByUUID_G(String uuid, long groupId)
		throws NoSuchBadgeException;

	/**
	* Returns the number of badges where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching badges
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the badges where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching badges
	*/
	public java.util.List<Badge> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Badge> findByUuid_C(String uuid, long companyId,
		int start, int end);

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
	public java.util.List<Badge> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public java.util.List<Badge> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first badge in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the first badge in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the last badge in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the last badge in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public Badge[] findByUuid_C_PrevAndNext(long badgeId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Removes all the badges where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of badges where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching badges
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the badges where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @return the matching badges
	*/
	public java.util.List<Badge> findBybadgeType(long badgeTypeId);

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
	public java.util.List<Badge> findBybadgeType(long badgeTypeId, int start,
		int end);

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
	public java.util.List<Badge> findBybadgeType(long badgeTypeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public java.util.List<Badge> findBybadgeType(long badgeTypeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findBybadgeType_First(long badgeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the first badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchBybadgeType_First(long badgeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the last badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findBybadgeType_Last(long badgeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the last badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchBybadgeType_Last(long badgeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the badges before and after the current badge in the ordered set where badgeTypeId = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param badgeTypeId the badge type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public Badge[] findBybadgeType_PrevAndNext(long badgeId, long badgeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Removes all the badges where badgeTypeId = &#63; from the database.
	*
	* @param badgeTypeId the badge type ID
	*/
	public void removeBybadgeType(long badgeTypeId);

	/**
	* Returns the number of badges where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @return the number of matching badges
	*/
	public int countBybadgeType(long badgeTypeId);

	/**
	* Returns all the badges where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching badges
	*/
	public java.util.List<Badge> findByuserId(long userId);

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
	public java.util.List<Badge> findByuserId(long userId, int start, int end);

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
	public java.util.List<Badge> findByuserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public java.util.List<Badge> findByuserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the first badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the last badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the last badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the badges before and after the current badge in the ordered set where userId = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public Badge[] findByuserId_PrevAndNext(long badgeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Removes all the badges where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByuserId(long userId);

	/**
	* Returns the number of badges where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching badges
	*/
	public int countByuserId(long userId);

	/**
	* Returns all the badges where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @return the matching badges
	*/
	public java.util.List<Badge> findBytoUserId(long toUserId);

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
	public java.util.List<Badge> findBytoUserId(long toUserId, int start,
		int end);

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
	public java.util.List<Badge> findBytoUserId(long toUserId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public java.util.List<Badge> findBytoUserId(long toUserId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first badge in the ordered set where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findBytoUserId_First(long toUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the first badge in the ordered set where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchBytoUserId_First(long toUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the last badge in the ordered set where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws NoSuchBadgeException if a matching badge could not be found
	*/
	public Badge findBytoUserId_Last(long toUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Returns the last badge in the ordered set where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	*/
	public Badge fetchBytoUserId_Last(long toUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

	/**
	* Returns the badges before and after the current badge in the ordered set where toUserId = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param toUserId the to user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public Badge[] findBytoUserId_PrevAndNext(long badgeId, long toUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException;

	/**
	* Removes all the badges where toUserId = &#63; from the database.
	*
	* @param toUserId the to user ID
	*/
	public void removeBytoUserId(long toUserId);

	/**
	* Returns the number of badges where toUserId = &#63;.
	*
	* @param toUserId the to user ID
	* @return the number of matching badges
	*/
	public int countBytoUserId(long toUserId);

	/**
	* Caches the badge in the entity cache if it is enabled.
	*
	* @param badge the badge
	*/
	public void cacheResult(Badge badge);

	/**
	* Caches the badges in the entity cache if it is enabled.
	*
	* @param badges the badges
	*/
	public void cacheResult(java.util.List<Badge> badges);

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	public Badge create(long badgeId);

	/**
	* Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public Badge remove(long badgeId) throws NoSuchBadgeException;

	public Badge updateImpl(Badge badge);

	/**
	* Returns the badge with the primary key or throws a {@link NoSuchBadgeException} if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws NoSuchBadgeException if a badge with the primary key could not be found
	*/
	public Badge findByPrimaryKey(long badgeId) throws NoSuchBadgeException;

	/**
	* Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge, or <code>null</code> if a badge with the primary key could not be found
	*/
	public Badge fetchByPrimaryKey(long badgeId);

	@Override
	public java.util.Map<java.io.Serializable, Badge> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the badges.
	*
	* @return the badges
	*/
	public java.util.List<Badge> findAll();

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
	public java.util.List<Badge> findAll(int start, int end);

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
	public java.util.List<Badge> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator);

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
	public java.util.List<Badge> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the badges from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}
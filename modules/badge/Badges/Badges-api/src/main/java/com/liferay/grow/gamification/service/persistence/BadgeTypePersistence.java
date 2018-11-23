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

import com.liferay.grow.gamification.exception.NoSuchBadgeTypeException;
import com.liferay.grow.gamification.model.BadgeType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the badge type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see com.liferay.grow.gamification.service.persistence.impl.BadgeTypePersistenceImpl
 * @see BadgeTypeUtil
 * @generated
 */
@ProviderType
public interface BadgeTypePersistence extends BasePersistence<BadgeType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BadgeTypeUtil} to access the badge type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the badge types where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @return the matching badge types
	*/
	public java.util.List<BadgeType> findByavailableTo(Date assignableTo);

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
	public java.util.List<BadgeType> findByavailableTo(Date assignableTo,
		int start, int end);

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
	public java.util.List<BadgeType> findByavailableTo(Date assignableTo,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeType> orderByComparator);

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
	public java.util.List<BadgeType> findByavailableTo(Date assignableTo,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeType> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first badge type in the ordered set where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge type
	* @throws NoSuchBadgeTypeException if a matching badge type could not be found
	*/
	public BadgeType findByavailableTo_First(Date assignableTo,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeType> orderByComparator)
		throws NoSuchBadgeTypeException;

	/**
	* Returns the first badge type in the ordered set where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public BadgeType fetchByavailableTo_First(Date assignableTo,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeType> orderByComparator);

	/**
	* Returns the last badge type in the ordered set where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge type
	* @throws NoSuchBadgeTypeException if a matching badge type could not be found
	*/
	public BadgeType findByavailableTo_Last(Date assignableTo,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeType> orderByComparator)
		throws NoSuchBadgeTypeException;

	/**
	* Returns the last badge type in the ordered set where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public BadgeType fetchByavailableTo_Last(Date assignableTo,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeType> orderByComparator);

	/**
	* Returns the badge types before and after the current badge type in the ordered set where assignableTo = &#63;.
	*
	* @param badgeTypeId the primary key of the current badge type
	* @param assignableTo the assignable to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge type
	* @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	*/
	public BadgeType[] findByavailableTo_PrevAndNext(long badgeTypeId,
		Date assignableTo,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeType> orderByComparator)
		throws NoSuchBadgeTypeException;

	/**
	* Removes all the badge types where assignableTo = &#63; from the database.
	*
	* @param assignableTo the assignable to
	*/
	public void removeByavailableTo(Date assignableTo);

	/**
	* Returns the number of badge types where assignableTo = &#63;.
	*
	* @param assignableTo the assignable to
	* @return the number of matching badge types
	*/
	public int countByavailableTo(Date assignableTo);

	/**
	* Returns the badge type where badgeTypeId = &#63; or throws a {@link NoSuchBadgeTypeException} if it could not be found.
	*
	* @param badgeTypeId the badge type ID
	* @return the matching badge type
	* @throws NoSuchBadgeTypeException if a matching badge type could not be found
	*/
	public BadgeType findBybadgeTypeId(long badgeTypeId)
		throws NoSuchBadgeTypeException;

	/**
	* Returns the badge type where badgeTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param badgeTypeId the badge type ID
	* @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public BadgeType fetchBybadgeTypeId(long badgeTypeId);

	/**
	* Returns the badge type where badgeTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param badgeTypeId the badge type ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public BadgeType fetchBybadgeTypeId(long badgeTypeId,
		boolean retrieveFromCache);

	/**
	* Removes the badge type where badgeTypeId = &#63; from the database.
	*
	* @param badgeTypeId the badge type ID
	* @return the badge type that was removed
	*/
	public BadgeType removeBybadgeTypeId(long badgeTypeId)
		throws NoSuchBadgeTypeException;

	/**
	* Returns the number of badge types where badgeTypeId = &#63;.
	*
	* @param badgeTypeId the badge type ID
	* @return the number of matching badge types
	*/
	public int countBybadgeTypeId(long badgeTypeId);

	/**
	* Returns the badge type where type = &#63; or throws a {@link NoSuchBadgeTypeException} if it could not be found.
	*
	* @param type the type
	* @return the matching badge type
	* @throws NoSuchBadgeTypeException if a matching badge type could not be found
	*/
	public BadgeType findBytype(String type) throws NoSuchBadgeTypeException;

	/**
	* Returns the badge type where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param type the type
	* @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public BadgeType fetchBytype(String type);

	/**
	* Returns the badge type where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param type the type
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	*/
	public BadgeType fetchBytype(String type, boolean retrieveFromCache);

	/**
	* Removes the badge type where type = &#63; from the database.
	*
	* @param type the type
	* @return the badge type that was removed
	*/
	public BadgeType removeBytype(String type) throws NoSuchBadgeTypeException;

	/**
	* Returns the number of badge types where type = &#63;.
	*
	* @param type the type
	* @return the number of matching badge types
	*/
	public int countBytype(String type);

	/**
	* Caches the badge type in the entity cache if it is enabled.
	*
	* @param badgeType the badge type
	*/
	public void cacheResult(BadgeType badgeType);

	/**
	* Caches the badge types in the entity cache if it is enabled.
	*
	* @param badgeTypes the badge types
	*/
	public void cacheResult(java.util.List<BadgeType> badgeTypes);

	/**
	* Creates a new badge type with the primary key. Does not add the badge type to the database.
	*
	* @param badgeTypeId the primary key for the new badge type
	* @return the new badge type
	*/
	public BadgeType create(long badgeTypeId);

	/**
	* Removes the badge type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeTypeId the primary key of the badge type
	* @return the badge type that was removed
	* @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	*/
	public BadgeType remove(long badgeTypeId) throws NoSuchBadgeTypeException;

	public BadgeType updateImpl(BadgeType badgeType);

	/**
	* Returns the badge type with the primary key or throws a {@link NoSuchBadgeTypeException} if it could not be found.
	*
	* @param badgeTypeId the primary key of the badge type
	* @return the badge type
	* @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	*/
	public BadgeType findByPrimaryKey(long badgeTypeId)
		throws NoSuchBadgeTypeException;

	/**
	* Returns the badge type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeTypeId the primary key of the badge type
	* @return the badge type, or <code>null</code> if a badge type with the primary key could not be found
	*/
	public BadgeType fetchByPrimaryKey(long badgeTypeId);

	@Override
	public java.util.Map<java.io.Serializable, BadgeType> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the badge types.
	*
	* @return the badge types
	*/
	public java.util.List<BadgeType> findAll();

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
	public java.util.List<BadgeType> findAll(int start, int end);

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
	public java.util.List<BadgeType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeType> orderByComparator);

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
	public java.util.List<BadgeType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BadgeType> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the badge types from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of badge types.
	*
	* @return the number of badge types
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}
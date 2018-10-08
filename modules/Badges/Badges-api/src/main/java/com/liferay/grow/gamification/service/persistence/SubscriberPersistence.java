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

import com.liferay.grow.gamification.exception.NoSuchSubscriberException;
import com.liferay.grow.gamification.model.Subscriber;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the subscriber service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see com.liferay.grow.gamification.service.persistence.impl.SubscriberPersistenceImpl
 * @see SubscriberUtil
 * @generated
 */
@ProviderType
public interface SubscriberPersistence extends BasePersistence<Subscriber> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubscriberUtil} to access the subscriber persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the subscribers where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @return the matching subscribers
	*/
	public java.util.List<Subscriber> findBysubscriberId(long subscriberUserId);

	/**
	* Returns a range of all the subscribers where subscriberUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subscriberUserId the subscriber user ID
	* @param start the lower bound of the range of subscribers
	* @param end the upper bound of the range of subscribers (not inclusive)
	* @return the range of matching subscribers
	*/
	public java.util.List<Subscriber> findBysubscriberId(
		long subscriberUserId, int start, int end);

	/**
	* Returns an ordered range of all the subscribers where subscriberUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subscriberUserId the subscriber user ID
	* @param start the lower bound of the range of subscribers
	* @param end the upper bound of the range of subscribers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subscribers
	*/
	public java.util.List<Subscriber> findBysubscriberId(
		long subscriberUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscriber> orderByComparator);

	/**
	* Returns an ordered range of all the subscribers where subscriberUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subscriberUserId the subscriber user ID
	* @param start the lower bound of the range of subscribers
	* @param end the upper bound of the range of subscribers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching subscribers
	*/
	public java.util.List<Subscriber> findBysubscriberId(
		long subscriberUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscriber> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscriber
	* @throws NoSuchSubscriberException if a matching subscriber could not be found
	*/
	public Subscriber findBysubscriberId_First(long subscriberUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Subscriber> orderByComparator)
		throws NoSuchSubscriberException;

	/**
	* Returns the first subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscriber, or <code>null</code> if a matching subscriber could not be found
	*/
	public Subscriber fetchBysubscriberId_First(long subscriberUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Subscriber> orderByComparator);

	/**
	* Returns the last subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscriber
	* @throws NoSuchSubscriberException if a matching subscriber could not be found
	*/
	public Subscriber findBysubscriberId_Last(long subscriberUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Subscriber> orderByComparator)
		throws NoSuchSubscriberException;

	/**
	* Returns the last subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscriber, or <code>null</code> if a matching subscriber could not be found
	*/
	public Subscriber fetchBysubscriberId_Last(long subscriberUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Subscriber> orderByComparator);

	/**
	* Returns the subscribers before and after the current subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberId the primary key of the current subscriber
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subscriber
	* @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	*/
	public Subscriber[] findBysubscriberId_PrevAndNext(long subscriberId,
		long subscriberUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Subscriber> orderByComparator)
		throws NoSuchSubscriberException;

	/**
	* Removes all the subscribers where subscriberUserId = &#63; from the database.
	*
	* @param subscriberUserId the subscriber user ID
	*/
	public void removeBysubscriberId(long subscriberUserId);

	/**
	* Returns the number of subscribers where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @return the number of matching subscribers
	*/
	public int countBysubscriberId(long subscriberUserId);

	/**
	* Caches the subscriber in the entity cache if it is enabled.
	*
	* @param subscriber the subscriber
	*/
	public void cacheResult(Subscriber subscriber);

	/**
	* Caches the subscribers in the entity cache if it is enabled.
	*
	* @param subscribers the subscribers
	*/
	public void cacheResult(java.util.List<Subscriber> subscribers);

	/**
	* Creates a new subscriber with the primary key. Does not add the subscriber to the database.
	*
	* @param subscriberId the primary key for the new subscriber
	* @return the new subscriber
	*/
	public Subscriber create(long subscriberId);

	/**
	* Removes the subscriber with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subscriberId the primary key of the subscriber
	* @return the subscriber that was removed
	* @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	*/
	public Subscriber remove(long subscriberId)
		throws NoSuchSubscriberException;

	public Subscriber updateImpl(Subscriber subscriber);

	/**
	* Returns the subscriber with the primary key or throws a {@link NoSuchSubscriberException} if it could not be found.
	*
	* @param subscriberId the primary key of the subscriber
	* @return the subscriber
	* @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	*/
	public Subscriber findByPrimaryKey(long subscriberId)
		throws NoSuchSubscriberException;

	/**
	* Returns the subscriber with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subscriberId the primary key of the subscriber
	* @return the subscriber, or <code>null</code> if a subscriber with the primary key could not be found
	*/
	public Subscriber fetchByPrimaryKey(long subscriberId);

	@Override
	public java.util.Map<java.io.Serializable, Subscriber> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the subscribers.
	*
	* @return the subscribers
	*/
	public java.util.List<Subscriber> findAll();

	/**
	* Returns a range of all the subscribers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscribers
	* @param end the upper bound of the range of subscribers (not inclusive)
	* @return the range of subscribers
	*/
	public java.util.List<Subscriber> findAll(int start, int end);

	/**
	* Returns an ordered range of all the subscribers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscribers
	* @param end the upper bound of the range of subscribers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subscribers
	*/
	public java.util.List<Subscriber> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscriber> orderByComparator);

	/**
	* Returns an ordered range of all the subscribers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscribers
	* @param end the upper bound of the range of subscribers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of subscribers
	*/
	public java.util.List<Subscriber> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscriber> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the subscribers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of subscribers.
	*
	* @return the number of subscribers
	*/
	public int countAll();
}
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

import com.liferay.grow.gamification.model.Subscriber;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the subscriber service. This utility wraps {@link com.liferay.grow.gamification.service.persistence.impl.SubscriberPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see SubscriberPersistence
 * @see com.liferay.grow.gamification.service.persistence.impl.SubscriberPersistenceImpl
 * @generated
 */
@ProviderType
public class SubscriberUtil {
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
	public static void clearCache(Subscriber subscriber) {
		getPersistence().clearCache(subscriber);
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
	public static List<Subscriber> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subscriber> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subscriber> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Subscriber> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Subscriber update(Subscriber subscriber) {
		return getPersistence().update(subscriber);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Subscriber update(Subscriber subscriber,
		ServiceContext serviceContext) {
		return getPersistence().update(subscriber, serviceContext);
	}

	/**
	* Returns all the subscribers where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @return the matching subscribers
	*/
	public static List<Subscriber> findBysubscriberId(long subscriberUserId) {
		return getPersistence().findBysubscriberId(subscriberUserId);
	}

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
	public static List<Subscriber> findBysubscriberId(long subscriberUserId,
		int start, int end) {
		return getPersistence().findBysubscriberId(subscriberUserId, start, end);
	}

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
	public static List<Subscriber> findBysubscriberId(long subscriberUserId,
		int start, int end, OrderByComparator<Subscriber> orderByComparator) {
		return getPersistence()
				   .findBysubscriberId(subscriberUserId, start, end,
			orderByComparator);
	}

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
	public static List<Subscriber> findBysubscriberId(long subscriberUserId,
		int start, int end, OrderByComparator<Subscriber> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBysubscriberId(subscriberUserId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscriber
	* @throws NoSuchSubscriberException if a matching subscriber could not be found
	*/
	public static Subscriber findBysubscriberId_First(long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchSubscriberException {
		return getPersistence()
				   .findBysubscriberId_First(subscriberUserId, orderByComparator);
	}

	/**
	* Returns the first subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscriber, or <code>null</code> if a matching subscriber could not be found
	*/
	public static Subscriber fetchBysubscriberId_First(long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator) {
		return getPersistence()
				   .fetchBysubscriberId_First(subscriberUserId,
			orderByComparator);
	}

	/**
	* Returns the last subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscriber
	* @throws NoSuchSubscriberException if a matching subscriber could not be found
	*/
	public static Subscriber findBysubscriberId_Last(long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchSubscriberException {
		return getPersistence()
				   .findBysubscriberId_Last(subscriberUserId, orderByComparator);
	}

	/**
	* Returns the last subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscriber, or <code>null</code> if a matching subscriber could not be found
	*/
	public static Subscriber fetchBysubscriberId_Last(long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator) {
		return getPersistence()
				   .fetchBysubscriberId_Last(subscriberUserId, orderByComparator);
	}

	/**
	* Returns the subscribers before and after the current subscriber in the ordered set where subscriberUserId = &#63;.
	*
	* @param subscriberId the primary key of the current subscriber
	* @param subscriberUserId the subscriber user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subscriber
	* @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	*/
	public static Subscriber[] findBysubscriberId_PrevAndNext(
		long subscriberId, long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator)
		throws com.liferay.grow.gamification.exception.NoSuchSubscriberException {
		return getPersistence()
				   .findBysubscriberId_PrevAndNext(subscriberId,
			subscriberUserId, orderByComparator);
	}

	/**
	* Removes all the subscribers where subscriberUserId = &#63; from the database.
	*
	* @param subscriberUserId the subscriber user ID
	*/
	public static void removeBysubscriberId(long subscriberUserId) {
		getPersistence().removeBysubscriberId(subscriberUserId);
	}

	/**
	* Returns the number of subscribers where subscriberUserId = &#63;.
	*
	* @param subscriberUserId the subscriber user ID
	* @return the number of matching subscribers
	*/
	public static int countBysubscriberId(long subscriberUserId) {
		return getPersistence().countBysubscriberId(subscriberUserId);
	}

	/**
	* Caches the subscriber in the entity cache if it is enabled.
	*
	* @param subscriber the subscriber
	*/
	public static void cacheResult(Subscriber subscriber) {
		getPersistence().cacheResult(subscriber);
	}

	/**
	* Caches the subscribers in the entity cache if it is enabled.
	*
	* @param subscribers the subscribers
	*/
	public static void cacheResult(List<Subscriber> subscribers) {
		getPersistence().cacheResult(subscribers);
	}

	/**
	* Creates a new subscriber with the primary key. Does not add the subscriber to the database.
	*
	* @param subscriberId the primary key for the new subscriber
	* @return the new subscriber
	*/
	public static Subscriber create(long subscriberId) {
		return getPersistence().create(subscriberId);
	}

	/**
	* Removes the subscriber with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subscriberId the primary key of the subscriber
	* @return the subscriber that was removed
	* @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	*/
	public static Subscriber remove(long subscriberId)
		throws com.liferay.grow.gamification.exception.NoSuchSubscriberException {
		return getPersistence().remove(subscriberId);
	}

	public static Subscriber updateImpl(Subscriber subscriber) {
		return getPersistence().updateImpl(subscriber);
	}

	/**
	* Returns the subscriber with the primary key or throws a {@link NoSuchSubscriberException} if it could not be found.
	*
	* @param subscriberId the primary key of the subscriber
	* @return the subscriber
	* @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	*/
	public static Subscriber findByPrimaryKey(long subscriberId)
		throws com.liferay.grow.gamification.exception.NoSuchSubscriberException {
		return getPersistence().findByPrimaryKey(subscriberId);
	}

	/**
	* Returns the subscriber with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subscriberId the primary key of the subscriber
	* @return the subscriber, or <code>null</code> if a subscriber with the primary key could not be found
	*/
	public static Subscriber fetchByPrimaryKey(long subscriberId) {
		return getPersistence().fetchByPrimaryKey(subscriberId);
	}

	public static java.util.Map<java.io.Serializable, Subscriber> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the subscribers.
	*
	* @return the subscribers
	*/
	public static List<Subscriber> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Subscriber> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Subscriber> findAll(int start, int end,
		OrderByComparator<Subscriber> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Subscriber> findAll(int start, int end,
		OrderByComparator<Subscriber> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the subscribers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subscribers.
	*
	* @return the number of subscribers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubscriberPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SubscriberPersistence, SubscriberPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SubscriberPersistence.class);

		ServiceTracker<SubscriberPersistence, SubscriberPersistence> serviceTracker =
			new ServiceTracker<SubscriberPersistence, SubscriberPersistence>(bundle.getBundleContext(),
				SubscriberPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
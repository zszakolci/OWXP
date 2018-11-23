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

package com.liferay.grow.gamification.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.grow.gamification.exception.NoSuchSubscriberException;
import com.liferay.grow.gamification.model.Subscriber;
import com.liferay.grow.gamification.model.impl.SubscriberImpl;
import com.liferay.grow.gamification.model.impl.SubscriberModelImpl;
import com.liferay.grow.gamification.service.persistence.SubscriberPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the subscriber service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see SubscriberPersistence
 * @see com.liferay.grow.gamification.service.persistence.SubscriberUtil
 * @generated
 */
@ProviderType
public class SubscriberPersistenceImpl extends BasePersistenceImpl<Subscriber>
	implements SubscriberPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubscriberUtil} to access the subscriber persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubscriberImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
			SubscriberModelImpl.FINDER_CACHE_ENABLED, SubscriberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
			SubscriberModelImpl.FINDER_CACHE_ENABLED, SubscriberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
			SubscriberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBSCRIBERID =
		new FinderPath(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
			SubscriberModelImpl.FINDER_CACHE_ENABLED, SubscriberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysubscriberId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIBERID =
		new FinderPath(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
			SubscriberModelImpl.FINDER_CACHE_ENABLED, SubscriberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysubscriberId",
			new String[] { Long.class.getName() },
			SubscriberModelImpl.SUBSCRIBERUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUBSCRIBERID = new FinderPath(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
			SubscriberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysubscriberId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the subscribers where subscriberUserId = &#63;.
	 *
	 * @param subscriberUserId the subscriber user ID
	 * @return the matching subscribers
	 */
	@Override
	public List<Subscriber> findBysubscriberId(long subscriberUserId) {
		return findBysubscriberId(subscriberUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Subscriber> findBysubscriberId(long subscriberUserId,
		int start, int end) {
		return findBysubscriberId(subscriberUserId, start, end, null);
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
	@Override
	public List<Subscriber> findBysubscriberId(long subscriberUserId,
		int start, int end, OrderByComparator<Subscriber> orderByComparator) {
		return findBysubscriberId(subscriberUserId, start, end,
			orderByComparator, true);
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
	@Override
	public List<Subscriber> findBysubscriberId(long subscriberUserId,
		int start, int end, OrderByComparator<Subscriber> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIBERID;
			finderArgs = new Object[] { subscriberUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBSCRIBERID;
			finderArgs = new Object[] {
					subscriberUserId,
					
					start, end, orderByComparator
				};
		}

		List<Subscriber> list = null;

		if (retrieveFromCache) {
			list = (List<Subscriber>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Subscriber subscriber : list) {
					if ((subscriberUserId != subscriber.getSubscriberUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SUBSCRIBER_WHERE);

			query.append(_FINDER_COLUMN_SUBSCRIBERID_SUBSCRIBERUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubscriberModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(subscriberUserId);

				if (!pagination) {
					list = (List<Subscriber>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Subscriber>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first subscriber in the ordered set where subscriberUserId = &#63;.
	 *
	 * @param subscriberUserId the subscriber user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscriber
	 * @throws NoSuchSubscriberException if a matching subscriber could not be found
	 */
	@Override
	public Subscriber findBysubscriberId_First(long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator)
		throws NoSuchSubscriberException {
		Subscriber subscriber = fetchBysubscriberId_First(subscriberUserId,
				orderByComparator);

		if (subscriber != null) {
			return subscriber;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subscriberUserId=");
		msg.append(subscriberUserId);

		msg.append("}");

		throw new NoSuchSubscriberException(msg.toString());
	}

	/**
	 * Returns the first subscriber in the ordered set where subscriberUserId = &#63;.
	 *
	 * @param subscriberUserId the subscriber user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscriber, or <code>null</code> if a matching subscriber could not be found
	 */
	@Override
	public Subscriber fetchBysubscriberId_First(long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator) {
		List<Subscriber> list = findBysubscriberId(subscriberUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subscriber in the ordered set where subscriberUserId = &#63;.
	 *
	 * @param subscriberUserId the subscriber user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscriber
	 * @throws NoSuchSubscriberException if a matching subscriber could not be found
	 */
	@Override
	public Subscriber findBysubscriberId_Last(long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator)
		throws NoSuchSubscriberException {
		Subscriber subscriber = fetchBysubscriberId_Last(subscriberUserId,
				orderByComparator);

		if (subscriber != null) {
			return subscriber;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subscriberUserId=");
		msg.append(subscriberUserId);

		msg.append("}");

		throw new NoSuchSubscriberException(msg.toString());
	}

	/**
	 * Returns the last subscriber in the ordered set where subscriberUserId = &#63;.
	 *
	 * @param subscriberUserId the subscriber user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscriber, or <code>null</code> if a matching subscriber could not be found
	 */
	@Override
	public Subscriber fetchBysubscriberId_Last(long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator) {
		int count = countBysubscriberId(subscriberUserId);

		if (count == 0) {
			return null;
		}

		List<Subscriber> list = findBysubscriberId(subscriberUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Subscriber[] findBysubscriberId_PrevAndNext(long subscriberId,
		long subscriberUserId, OrderByComparator<Subscriber> orderByComparator)
		throws NoSuchSubscriberException {
		Subscriber subscriber = findByPrimaryKey(subscriberId);

		Session session = null;

		try {
			session = openSession();

			Subscriber[] array = new SubscriberImpl[3];

			array[0] = getBysubscriberId_PrevAndNext(session, subscriber,
					subscriberUserId, orderByComparator, true);

			array[1] = subscriber;

			array[2] = getBysubscriberId_PrevAndNext(session, subscriber,
					subscriberUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subscriber getBysubscriberId_PrevAndNext(Session session,
		Subscriber subscriber, long subscriberUserId,
		OrderByComparator<Subscriber> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBSCRIBER_WHERE);

		query.append(_FINDER_COLUMN_SUBSCRIBERID_SUBSCRIBERUSERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SubscriberModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(subscriberUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subscriber);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Subscriber> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subscribers where subscriberUserId = &#63; from the database.
	 *
	 * @param subscriberUserId the subscriber user ID
	 */
	@Override
	public void removeBysubscriberId(long subscriberUserId) {
		for (Subscriber subscriber : findBysubscriberId(subscriberUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(subscriber);
		}
	}

	/**
	 * Returns the number of subscribers where subscriberUserId = &#63;.
	 *
	 * @param subscriberUserId the subscriber user ID
	 * @return the number of matching subscribers
	 */
	@Override
	public int countBysubscriberId(long subscriberUserId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBSCRIBERID;

		Object[] finderArgs = new Object[] { subscriberUserId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBSCRIBER_WHERE);

			query.append(_FINDER_COLUMN_SUBSCRIBERID_SUBSCRIBERUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(subscriberUserId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SUBSCRIBERID_SUBSCRIBERUSERID_2 = "subscriber.subscriberUserId = ?";

	public SubscriberPersistenceImpl() {
		setModelClass(Subscriber.class);
	}

	/**
	 * Caches the subscriber in the entity cache if it is enabled.
	 *
	 * @param subscriber the subscriber
	 */
	@Override
	public void cacheResult(Subscriber subscriber) {
		entityCache.putResult(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
			SubscriberImpl.class, subscriber.getPrimaryKey(), subscriber);

		subscriber.resetOriginalValues();
	}

	/**
	 * Caches the subscribers in the entity cache if it is enabled.
	 *
	 * @param subscribers the subscribers
	 */
	@Override
	public void cacheResult(List<Subscriber> subscribers) {
		for (Subscriber subscriber : subscribers) {
			if (entityCache.getResult(
						SubscriberModelImpl.ENTITY_CACHE_ENABLED,
						SubscriberImpl.class, subscriber.getPrimaryKey()) == null) {
				cacheResult(subscriber);
			}
			else {
				subscriber.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subscribers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubscriberImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subscriber.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subscriber subscriber) {
		entityCache.removeResult(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
			SubscriberImpl.class, subscriber.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Subscriber> subscribers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Subscriber subscriber : subscribers) {
			entityCache.removeResult(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
				SubscriberImpl.class, subscriber.getPrimaryKey());
		}
	}

	/**
	 * Creates a new subscriber with the primary key. Does not add the subscriber to the database.
	 *
	 * @param subscriberId the primary key for the new subscriber
	 * @return the new subscriber
	 */
	@Override
	public Subscriber create(long subscriberId) {
		Subscriber subscriber = new SubscriberImpl();

		subscriber.setNew(true);
		subscriber.setPrimaryKey(subscriberId);

		subscriber.setCompanyId(companyProvider.getCompanyId());

		return subscriber;
	}

	/**
	 * Removes the subscriber with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subscriberId the primary key of the subscriber
	 * @return the subscriber that was removed
	 * @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	 */
	@Override
	public Subscriber remove(long subscriberId)
		throws NoSuchSubscriberException {
		return remove((Serializable)subscriberId);
	}

	/**
	 * Removes the subscriber with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subscriber
	 * @return the subscriber that was removed
	 * @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	 */
	@Override
	public Subscriber remove(Serializable primaryKey)
		throws NoSuchSubscriberException {
		Session session = null;

		try {
			session = openSession();

			Subscriber subscriber = (Subscriber)session.get(SubscriberImpl.class,
					primaryKey);

			if (subscriber == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubscriberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subscriber);
		}
		catch (NoSuchSubscriberException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Subscriber removeImpl(Subscriber subscriber) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subscriber)) {
				subscriber = (Subscriber)session.get(SubscriberImpl.class,
						subscriber.getPrimaryKeyObj());
			}

			if (subscriber != null) {
				session.delete(subscriber);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subscriber != null) {
			clearCache(subscriber);
		}

		return subscriber;
	}

	@Override
	public Subscriber updateImpl(Subscriber subscriber) {
		boolean isNew = subscriber.isNew();

		if (!(subscriber instanceof SubscriberModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subscriber.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(subscriber);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subscriber proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Subscriber implementation " +
				subscriber.getClass());
		}

		SubscriberModelImpl subscriberModelImpl = (SubscriberModelImpl)subscriber;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (subscriber.getCreateDate() == null)) {
			if (serviceContext == null) {
				subscriber.setCreateDate(now);
			}
			else {
				subscriber.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!subscriberModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				subscriber.setModifiedDate(now);
			}
			else {
				subscriber.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (subscriber.isNew()) {
				session.save(subscriber);

				subscriber.setNew(false);
			}
			else {
				subscriber = (Subscriber)session.merge(subscriber);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SubscriberModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					subscriberModelImpl.getSubscriberUserId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SUBSCRIBERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIBERID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((subscriberModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIBERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subscriberModelImpl.getOriginalSubscriberUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SUBSCRIBERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIBERID,
					args);

				args = new Object[] { subscriberModelImpl.getSubscriberUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SUBSCRIBERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIBERID,
					args);
			}
		}

		entityCache.putResult(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
			SubscriberImpl.class, subscriber.getPrimaryKey(), subscriber, false);

		subscriber.resetOriginalValues();

		return subscriber;
	}

	/**
	 * Returns the subscriber with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subscriber
	 * @return the subscriber
	 * @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	 */
	@Override
	public Subscriber findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubscriberException {
		Subscriber subscriber = fetchByPrimaryKey(primaryKey);

		if (subscriber == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubscriberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subscriber;
	}

	/**
	 * Returns the subscriber with the primary key or throws a {@link NoSuchSubscriberException} if it could not be found.
	 *
	 * @param subscriberId the primary key of the subscriber
	 * @return the subscriber
	 * @throws NoSuchSubscriberException if a subscriber with the primary key could not be found
	 */
	@Override
	public Subscriber findByPrimaryKey(long subscriberId)
		throws NoSuchSubscriberException {
		return findByPrimaryKey((Serializable)subscriberId);
	}

	/**
	 * Returns the subscriber with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subscriber
	 * @return the subscriber, or <code>null</code> if a subscriber with the primary key could not be found
	 */
	@Override
	public Subscriber fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
				SubscriberImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Subscriber subscriber = (Subscriber)serializable;

		if (subscriber == null) {
			Session session = null;

			try {
				session = openSession();

				subscriber = (Subscriber)session.get(SubscriberImpl.class,
						primaryKey);

				if (subscriber != null) {
					cacheResult(subscriber);
				}
				else {
					entityCache.putResult(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
						SubscriberImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
					SubscriberImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subscriber;
	}

	/**
	 * Returns the subscriber with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subscriberId the primary key of the subscriber
	 * @return the subscriber, or <code>null</code> if a subscriber with the primary key could not be found
	 */
	@Override
	public Subscriber fetchByPrimaryKey(long subscriberId) {
		return fetchByPrimaryKey((Serializable)subscriberId);
	}

	@Override
	public Map<Serializable, Subscriber> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Subscriber> map = new HashMap<Serializable, Subscriber>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Subscriber subscriber = fetchByPrimaryKey(primaryKey);

			if (subscriber != null) {
				map.put(primaryKey, subscriber);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
					SubscriberImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Subscriber)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SUBSCRIBER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Subscriber subscriber : (List<Subscriber>)q.list()) {
				map.put(subscriber.getPrimaryKeyObj(), subscriber);

				cacheResult(subscriber);

				uncachedPrimaryKeys.remove(subscriber.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SubscriberModelImpl.ENTITY_CACHE_ENABLED,
					SubscriberImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the subscribers.
	 *
	 * @return the subscribers
	 */
	@Override
	public List<Subscriber> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Subscriber> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Subscriber> findAll(int start, int end,
		OrderByComparator<Subscriber> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Subscriber> findAll(int start, int end,
		OrderByComparator<Subscriber> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Subscriber> list = null;

		if (retrieveFromCache) {
			list = (List<Subscriber>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUBSCRIBER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBSCRIBER;

				if (pagination) {
					sql = sql.concat(SubscriberModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Subscriber>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Subscriber>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the subscribers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Subscriber subscriber : findAll()) {
			remove(subscriber);
		}
	}

	/**
	 * Returns the number of subscribers.
	 *
	 * @return the number of subscribers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUBSCRIBER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubscriberModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the subscriber persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SubscriberImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SUBSCRIBER = "SELECT subscriber FROM Subscriber subscriber";
	private static final String _SQL_SELECT_SUBSCRIBER_WHERE_PKS_IN = "SELECT subscriber FROM Subscriber subscriber WHERE subscriberId IN (";
	private static final String _SQL_SELECT_SUBSCRIBER_WHERE = "SELECT subscriber FROM Subscriber subscriber WHERE ";
	private static final String _SQL_COUNT_SUBSCRIBER = "SELECT COUNT(subscriber) FROM Subscriber subscriber";
	private static final String _SQL_COUNT_SUBSCRIBER_WHERE = "SELECT COUNT(subscriber) FROM Subscriber subscriber WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subscriber.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Subscriber exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Subscriber exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SubscriberPersistenceImpl.class);
}
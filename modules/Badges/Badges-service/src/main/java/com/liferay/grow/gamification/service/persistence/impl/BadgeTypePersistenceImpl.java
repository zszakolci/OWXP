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

import com.liferay.grow.gamification.exception.NoSuchBadgeTypeException;
import com.liferay.grow.gamification.model.BadgeType;
import com.liferay.grow.gamification.model.impl.BadgeTypeImpl;
import com.liferay.grow.gamification.model.impl.BadgeTypeModelImpl;
import com.liferay.grow.gamification.service.persistence.BadgeTypePersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the badge type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see BadgeTypePersistence
 * @see com.liferay.grow.gamification.service.persistence.BadgeTypeUtil
 * @generated
 */
@ProviderType
public class BadgeTypePersistenceImpl extends BasePersistenceImpl<BadgeType>
	implements BadgeTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BadgeTypeUtil} to access the badge type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BadgeTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, BadgeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, BadgeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AVAILABLETO =
		new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, BadgeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByavailableTo",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLETO =
		new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, BadgeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByavailableTo",
			new String[] { Date.class.getName() },
			BadgeTypeModelImpl.ASSIGNABLETO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AVAILABLETO = new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByavailableTo",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the badge types where assignableTo = &#63;.
	 *
	 * @param assignableTo the assignable to
	 * @return the matching badge types
	 */
	@Override
	public List<BadgeType> findByavailableTo(Date assignableTo) {
		return findByavailableTo(assignableTo, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<BadgeType> findByavailableTo(Date assignableTo, int start,
		int end) {
		return findByavailableTo(assignableTo, start, end, null);
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
	@Override
	public List<BadgeType> findByavailableTo(Date assignableTo, int start,
		int end, OrderByComparator<BadgeType> orderByComparator) {
		return findByavailableTo(assignableTo, start, end, orderByComparator,
			true);
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
	@Override
	public List<BadgeType> findByavailableTo(Date assignableTo, int start,
		int end, OrderByComparator<BadgeType> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLETO;
			finderArgs = new Object[] { _getTime(assignableTo) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AVAILABLETO;
			finderArgs = new Object[] {
					_getTime(assignableTo),
					
					start, end, orderByComparator
				};
		}

		List<BadgeType> list = null;

		if (retrieveFromCache) {
			list = (List<BadgeType>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BadgeType badgeType : list) {
					if (!Objects.equals(assignableTo,
								badgeType.getAssignableTo())) {
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

			query.append(_SQL_SELECT_BADGETYPE_WHERE);

			boolean bindAssignableTo = false;

			if (assignableTo == null) {
				query.append(_FINDER_COLUMN_AVAILABLETO_ASSIGNABLETO_1);
			}
			else {
				bindAssignableTo = true;

				query.append(_FINDER_COLUMN_AVAILABLETO_ASSIGNABLETO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BadgeTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssignableTo) {
					qPos.add(new Timestamp(assignableTo.getTime()));
				}

				if (!pagination) {
					list = (List<BadgeType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BadgeType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first badge type in the ordered set where assignableTo = &#63;.
	 *
	 * @param assignableTo the assignable to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge type
	 * @throws NoSuchBadgeTypeException if a matching badge type could not be found
	 */
	@Override
	public BadgeType findByavailableTo_First(Date assignableTo,
		OrderByComparator<BadgeType> orderByComparator)
		throws NoSuchBadgeTypeException {
		BadgeType badgeType = fetchByavailableTo_First(assignableTo,
				orderByComparator);

		if (badgeType != null) {
			return badgeType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assignableTo=");
		msg.append(assignableTo);

		msg.append("}");

		throw new NoSuchBadgeTypeException(msg.toString());
	}

	/**
	 * Returns the first badge type in the ordered set where assignableTo = &#63;.
	 *
	 * @param assignableTo the assignable to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge type, or <code>null</code> if a matching badge type could not be found
	 */
	@Override
	public BadgeType fetchByavailableTo_First(Date assignableTo,
		OrderByComparator<BadgeType> orderByComparator) {
		List<BadgeType> list = findByavailableTo(assignableTo, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last badge type in the ordered set where assignableTo = &#63;.
	 *
	 * @param assignableTo the assignable to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge type
	 * @throws NoSuchBadgeTypeException if a matching badge type could not be found
	 */
	@Override
	public BadgeType findByavailableTo_Last(Date assignableTo,
		OrderByComparator<BadgeType> orderByComparator)
		throws NoSuchBadgeTypeException {
		BadgeType badgeType = fetchByavailableTo_Last(assignableTo,
				orderByComparator);

		if (badgeType != null) {
			return badgeType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assignableTo=");
		msg.append(assignableTo);

		msg.append("}");

		throw new NoSuchBadgeTypeException(msg.toString());
	}

	/**
	 * Returns the last badge type in the ordered set where assignableTo = &#63;.
	 *
	 * @param assignableTo the assignable to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge type, or <code>null</code> if a matching badge type could not be found
	 */
	@Override
	public BadgeType fetchByavailableTo_Last(Date assignableTo,
		OrderByComparator<BadgeType> orderByComparator) {
		int count = countByavailableTo(assignableTo);

		if (count == 0) {
			return null;
		}

		List<BadgeType> list = findByavailableTo(assignableTo, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BadgeType[] findByavailableTo_PrevAndNext(long badgeTypeId,
		Date assignableTo, OrderByComparator<BadgeType> orderByComparator)
		throws NoSuchBadgeTypeException {
		BadgeType badgeType = findByPrimaryKey(badgeTypeId);

		Session session = null;

		try {
			session = openSession();

			BadgeType[] array = new BadgeTypeImpl[3];

			array[0] = getByavailableTo_PrevAndNext(session, badgeType,
					assignableTo, orderByComparator, true);

			array[1] = badgeType;

			array[2] = getByavailableTo_PrevAndNext(session, badgeType,
					assignableTo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BadgeType getByavailableTo_PrevAndNext(Session session,
		BadgeType badgeType, Date assignableTo,
		OrderByComparator<BadgeType> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BADGETYPE_WHERE);

		boolean bindAssignableTo = false;

		if (assignableTo == null) {
			query.append(_FINDER_COLUMN_AVAILABLETO_ASSIGNABLETO_1);
		}
		else {
			bindAssignableTo = true;

			query.append(_FINDER_COLUMN_AVAILABLETO_ASSIGNABLETO_2);
		}

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
			query.append(BadgeTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAssignableTo) {
			qPos.add(new Timestamp(assignableTo.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badgeType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BadgeType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the badge types where assignableTo = &#63; from the database.
	 *
	 * @param assignableTo the assignable to
	 */
	@Override
	public void removeByavailableTo(Date assignableTo) {
		for (BadgeType badgeType : findByavailableTo(assignableTo,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(badgeType);
		}
	}

	/**
	 * Returns the number of badge types where assignableTo = &#63;.
	 *
	 * @param assignableTo the assignable to
	 * @return the number of matching badge types
	 */
	@Override
	public int countByavailableTo(Date assignableTo) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AVAILABLETO;

		Object[] finderArgs = new Object[] { _getTime(assignableTo) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGETYPE_WHERE);

			boolean bindAssignableTo = false;

			if (assignableTo == null) {
				query.append(_FINDER_COLUMN_AVAILABLETO_ASSIGNABLETO_1);
			}
			else {
				bindAssignableTo = true;

				query.append(_FINDER_COLUMN_AVAILABLETO_ASSIGNABLETO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAssignableTo) {
					qPos.add(new Timestamp(assignableTo.getTime()));
				}

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

	private static final String _FINDER_COLUMN_AVAILABLETO_ASSIGNABLETO_1 = "badgeType.assignableTo IS NULL";
	private static final String _FINDER_COLUMN_AVAILABLETO_ASSIGNABLETO_2 = "badgeType.assignableTo = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BADGETYPEID = new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, BadgeTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybadgeTypeId",
			new String[] { Long.class.getName() },
			BadgeTypeModelImpl.BADGETYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BADGETYPEID = new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybadgeTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the badge type where badgeTypeId = &#63; or throws a {@link NoSuchBadgeTypeException} if it could not be found.
	 *
	 * @param badgeTypeId the badge type ID
	 * @return the matching badge type
	 * @throws NoSuchBadgeTypeException if a matching badge type could not be found
	 */
	@Override
	public BadgeType findBybadgeTypeId(long badgeTypeId)
		throws NoSuchBadgeTypeException {
		BadgeType badgeType = fetchBybadgeTypeId(badgeTypeId);

		if (badgeType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("badgeTypeId=");
			msg.append(badgeTypeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBadgeTypeException(msg.toString());
		}

		return badgeType;
	}

	/**
	 * Returns the badge type where badgeTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param badgeTypeId the badge type ID
	 * @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	 */
	@Override
	public BadgeType fetchBybadgeTypeId(long badgeTypeId) {
		return fetchBybadgeTypeId(badgeTypeId, true);
	}

	/**
	 * Returns the badge type where badgeTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param badgeTypeId the badge type ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	 */
	@Override
	public BadgeType fetchBybadgeTypeId(long badgeTypeId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { badgeTypeId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_BADGETYPEID,
					finderArgs, this);
		}

		if (result instanceof BadgeType) {
			BadgeType badgeType = (BadgeType)result;

			if ((badgeTypeId != badgeType.getBadgeTypeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BADGETYPE_WHERE);

			query.append(_FINDER_COLUMN_BADGETYPEID_BADGETYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(badgeTypeId);

				List<BadgeType> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_BADGETYPEID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"BadgeTypePersistenceImpl.fetchBybadgeTypeId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BadgeType badgeType = list.get(0);

					result = badgeType;

					cacheResult(badgeType);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_BADGETYPEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BadgeType)result;
		}
	}

	/**
	 * Removes the badge type where badgeTypeId = &#63; from the database.
	 *
	 * @param badgeTypeId the badge type ID
	 * @return the badge type that was removed
	 */
	@Override
	public BadgeType removeBybadgeTypeId(long badgeTypeId)
		throws NoSuchBadgeTypeException {
		BadgeType badgeType = findBybadgeTypeId(badgeTypeId);

		return remove(badgeType);
	}

	/**
	 * Returns the number of badge types where badgeTypeId = &#63;.
	 *
	 * @param badgeTypeId the badge type ID
	 * @return the number of matching badge types
	 */
	@Override
	public int countBybadgeTypeId(long badgeTypeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BADGETYPEID;

		Object[] finderArgs = new Object[] { badgeTypeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGETYPE_WHERE);

			query.append(_FINDER_COLUMN_BADGETYPEID_BADGETYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(badgeTypeId);

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

	private static final String _FINDER_COLUMN_BADGETYPEID_BADGETYPEID_2 = "badgeType.badgeTypeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TYPE = new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, BadgeTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBytype",
			new String[] { String.class.getName() },
			BadgeTypeModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytype",
			new String[] { String.class.getName() });

	/**
	 * Returns the badge type where type = &#63; or throws a {@link NoSuchBadgeTypeException} if it could not be found.
	 *
	 * @param type the type
	 * @return the matching badge type
	 * @throws NoSuchBadgeTypeException if a matching badge type could not be found
	 */
	@Override
	public BadgeType findBytype(String type) throws NoSuchBadgeTypeException {
		BadgeType badgeType = fetchBytype(type);

		if (badgeType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("type=");
			msg.append(type);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBadgeTypeException(msg.toString());
		}

		return badgeType;
	}

	/**
	 * Returns the badge type where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param type the type
	 * @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	 */
	@Override
	public BadgeType fetchBytype(String type) {
		return fetchBytype(type, true);
	}

	/**
	 * Returns the badge type where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param type the type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching badge type, or <code>null</code> if a matching badge type could not be found
	 */
	@Override
	public BadgeType fetchBytype(String type, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { type };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TYPE,
					finderArgs, this);
		}

		if (result instanceof BadgeType) {
			BadgeType badgeType = (BadgeType)result;

			if (!Objects.equals(type, badgeType.getType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BADGETYPE_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals("")) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				List<BadgeType> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TYPE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"BadgeTypePersistenceImpl.fetchBytype(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BadgeType badgeType = list.get(0);

					result = badgeType;

					cacheResult(badgeType);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TYPE, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BadgeType)result;
		}
	}

	/**
	 * Removes the badge type where type = &#63; from the database.
	 *
	 * @param type the type
	 * @return the badge type that was removed
	 */
	@Override
	public BadgeType removeBytype(String type) throws NoSuchBadgeTypeException {
		BadgeType badgeType = findBytype(type);

		return remove(badgeType);
	}

	/**
	 * Returns the number of badge types where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching badge types
	 */
	@Override
	public int countBytype(String type) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGETYPE_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals("")) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

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

	private static final String _FINDER_COLUMN_TYPE_TYPE_1 = "badgeType.type IS NULL";
	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "badgeType.type = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_3 = "(badgeType.type IS NULL OR badgeType.type = '')";

	public BadgeTypePersistenceImpl() {
		setModelClass(BadgeType.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("type", "type_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the badge type in the entity cache if it is enabled.
	 *
	 * @param badgeType the badge type
	 */
	@Override
	public void cacheResult(BadgeType badgeType) {
		entityCache.putResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeImpl.class, badgeType.getPrimaryKey(), badgeType);

		finderCache.putResult(FINDER_PATH_FETCH_BY_BADGETYPEID,
			new Object[] { badgeType.getBadgeTypeId() }, badgeType);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TYPE,
			new Object[] { badgeType.getType() }, badgeType);

		badgeType.resetOriginalValues();
	}

	/**
	 * Caches the badge types in the entity cache if it is enabled.
	 *
	 * @param badgeTypes the badge types
	 */
	@Override
	public void cacheResult(List<BadgeType> badgeTypes) {
		for (BadgeType badgeType : badgeTypes) {
			if (entityCache.getResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeTypeImpl.class, badgeType.getPrimaryKey()) == null) {
				cacheResult(badgeType);
			}
			else {
				badgeType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all badge types.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BadgeTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the badge type.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BadgeType badgeType) {
		entityCache.removeResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeImpl.class, badgeType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BadgeTypeModelImpl)badgeType, true);
	}

	@Override
	public void clearCache(List<BadgeType> badgeTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BadgeType badgeType : badgeTypes) {
			entityCache.removeResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeTypeImpl.class, badgeType.getPrimaryKey());

			clearUniqueFindersCache((BadgeTypeModelImpl)badgeType, true);
		}
	}

	protected void cacheUniqueFindersCache(
		BadgeTypeModelImpl badgeTypeModelImpl) {
		Object[] args = new Object[] { badgeTypeModelImpl.getBadgeTypeId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_BADGETYPEID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_BADGETYPEID, args,
			badgeTypeModelImpl, false);

		args = new Object[] { badgeTypeModelImpl.getType() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_TYPE, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TYPE, args,
			badgeTypeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		BadgeTypeModelImpl badgeTypeModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { badgeTypeModelImpl.getBadgeTypeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BADGETYPEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BADGETYPEID, args);
		}

		if ((badgeTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BADGETYPEID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					badgeTypeModelImpl.getOriginalBadgeTypeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BADGETYPEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BADGETYPEID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { badgeTypeModelImpl.getType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TYPE, args);
		}

		if ((badgeTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TYPE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { badgeTypeModelImpl.getOriginalType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TYPE, args);
		}
	}

	/**
	 * Creates a new badge type with the primary key. Does not add the badge type to the database.
	 *
	 * @param badgeTypeId the primary key for the new badge type
	 * @return the new badge type
	 */
	@Override
	public BadgeType create(long badgeTypeId) {
		BadgeType badgeType = new BadgeTypeImpl();

		badgeType.setNew(true);
		badgeType.setPrimaryKey(badgeTypeId);

		badgeType.setCompanyId(companyProvider.getCompanyId());

		return badgeType;
	}

	/**
	 * Removes the badge type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param badgeTypeId the primary key of the badge type
	 * @return the badge type that was removed
	 * @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	 */
	@Override
	public BadgeType remove(long badgeTypeId) throws NoSuchBadgeTypeException {
		return remove((Serializable)badgeTypeId);
	}

	/**
	 * Removes the badge type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the badge type
	 * @return the badge type that was removed
	 * @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	 */
	@Override
	public BadgeType remove(Serializable primaryKey)
		throws NoSuchBadgeTypeException {
		Session session = null;

		try {
			session = openSession();

			BadgeType badgeType = (BadgeType)session.get(BadgeTypeImpl.class,
					primaryKey);

			if (badgeType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBadgeTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(badgeType);
		}
		catch (NoSuchBadgeTypeException nsee) {
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
	protected BadgeType removeImpl(BadgeType badgeType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(badgeType)) {
				badgeType = (BadgeType)session.get(BadgeTypeImpl.class,
						badgeType.getPrimaryKeyObj());
			}

			if (badgeType != null) {
				session.delete(badgeType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (badgeType != null) {
			clearCache(badgeType);
		}

		return badgeType;
	}

	@Override
	public BadgeType updateImpl(BadgeType badgeType) {
		boolean isNew = badgeType.isNew();

		if (!(badgeType instanceof BadgeTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(badgeType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(badgeType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in badgeType proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BadgeType implementation " +
				badgeType.getClass());
		}

		BadgeTypeModelImpl badgeTypeModelImpl = (BadgeTypeModelImpl)badgeType;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (badgeType.getCreateDate() == null)) {
			if (serviceContext == null) {
				badgeType.setCreateDate(now);
			}
			else {
				badgeType.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!badgeTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				badgeType.setModifiedDate(now);
			}
			else {
				badgeType.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (badgeType.isNew()) {
				session.save(badgeType);

				badgeType.setNew(false);
			}
			else {
				badgeType = (BadgeType)session.merge(badgeType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!BadgeTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { badgeTypeModelImpl.getAssignableTo() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_AVAILABLETO, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLETO,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((badgeTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLETO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						badgeTypeModelImpl.getOriginalAssignableTo()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AVAILABLETO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLETO,
					args);

				args = new Object[] { badgeTypeModelImpl.getAssignableTo() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AVAILABLETO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AVAILABLETO,
					args);
			}
		}

		entityCache.putResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeTypeImpl.class, badgeType.getPrimaryKey(), badgeType, false);

		clearUniqueFindersCache(badgeTypeModelImpl, false);
		cacheUniqueFindersCache(badgeTypeModelImpl);

		badgeType.resetOriginalValues();

		return badgeType;
	}

	/**
	 * Returns the badge type with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge type
	 * @return the badge type
	 * @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	 */
	@Override
	public BadgeType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBadgeTypeException {
		BadgeType badgeType = fetchByPrimaryKey(primaryKey);

		if (badgeType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBadgeTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return badgeType;
	}

	/**
	 * Returns the badge type with the primary key or throws a {@link NoSuchBadgeTypeException} if it could not be found.
	 *
	 * @param badgeTypeId the primary key of the badge type
	 * @return the badge type
	 * @throws NoSuchBadgeTypeException if a badge type with the primary key could not be found
	 */
	@Override
	public BadgeType findByPrimaryKey(long badgeTypeId)
		throws NoSuchBadgeTypeException {
		return findByPrimaryKey((Serializable)badgeTypeId);
	}

	/**
	 * Returns the badge type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge type
	 * @return the badge type, or <code>null</code> if a badge type with the primary key could not be found
	 */
	@Override
	public BadgeType fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeTypeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BadgeType badgeType = (BadgeType)serializable;

		if (badgeType == null) {
			Session session = null;

			try {
				session = openSession();

				badgeType = (BadgeType)session.get(BadgeTypeImpl.class,
						primaryKey);

				if (badgeType != null) {
					cacheResult(badgeType);
				}
				else {
					entityCache.putResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeTypeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return badgeType;
	}

	/**
	 * Returns the badge type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param badgeTypeId the primary key of the badge type
	 * @return the badge type, or <code>null</code> if a badge type with the primary key could not be found
	 */
	@Override
	public BadgeType fetchByPrimaryKey(long badgeTypeId) {
		return fetchByPrimaryKey((Serializable)badgeTypeId);
	}

	@Override
	public Map<Serializable, BadgeType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BadgeType> map = new HashMap<Serializable, BadgeType>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BadgeType badgeType = fetchByPrimaryKey(primaryKey);

			if (badgeType != null) {
				map.put(primaryKey, badgeType);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeTypeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BadgeType)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BADGETYPE_WHERE_PKS_IN);

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

			for (BadgeType badgeType : (List<BadgeType>)q.list()) {
				map.put(badgeType.getPrimaryKeyObj(), badgeType);

				cacheResult(badgeType);

				uncachedPrimaryKeys.remove(badgeType.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BadgeTypeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeTypeImpl.class, primaryKey, nullModel);
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
	 * Returns all the badge types.
	 *
	 * @return the badge types
	 */
	@Override
	public List<BadgeType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BadgeType> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<BadgeType> findAll(int start, int end,
		OrderByComparator<BadgeType> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<BadgeType> findAll(int start, int end,
		OrderByComparator<BadgeType> orderByComparator,
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

		List<BadgeType> list = null;

		if (retrieveFromCache) {
			list = (List<BadgeType>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BADGETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BADGETYPE;

				if (pagination) {
					sql = sql.concat(BadgeTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BadgeType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BadgeType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the badge types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BadgeType badgeType : findAll()) {
			remove(badgeType);
		}
	}

	/**
	 * Returns the number of badge types.
	 *
	 * @return the number of badge types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BADGETYPE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BadgeTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the badge type persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BadgeTypeImpl.class.getName());
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

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_BADGETYPE = "SELECT badgeType FROM BadgeType badgeType";
	private static final String _SQL_SELECT_BADGETYPE_WHERE_PKS_IN = "SELECT badgeType FROM BadgeType badgeType WHERE badgeTypeId IN (";
	private static final String _SQL_SELECT_BADGETYPE_WHERE = "SELECT badgeType FROM BadgeType badgeType WHERE ";
	private static final String _SQL_COUNT_BADGETYPE = "SELECT COUNT(badgeType) FROM BadgeType badgeType";
	private static final String _SQL_COUNT_BADGETYPE_WHERE = "SELECT COUNT(badgeType) FROM BadgeType badgeType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "badgeType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BadgeType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BadgeType exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BadgeTypePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
}
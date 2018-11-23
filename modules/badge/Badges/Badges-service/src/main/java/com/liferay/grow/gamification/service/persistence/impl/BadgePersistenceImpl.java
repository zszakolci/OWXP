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

import com.liferay.grow.gamification.exception.NoSuchBadgeException;
import com.liferay.grow.gamification.model.Badge;
import com.liferay.grow.gamification.model.impl.BadgeImpl;
import com.liferay.grow.gamification.model.impl.BadgeModelImpl;
import com.liferay.grow.gamification.service.persistence.BadgePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see BadgePersistence
 * @see com.liferay.grow.gamification.service.persistence.BadgeUtil
 * @generated
 */
@ProviderType
public class BadgePersistenceImpl extends BasePersistenceImpl<Badge>
	implements BadgePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BadgeUtil} to access the badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BadgeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			BadgeModelImpl.UUID_COLUMN_BITMASK |
			BadgeModelImpl.ASSIGNEDDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the badges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching badges
	 */
	@Override
	public List<Badge> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Badge> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Badge> findByUuid(String uuid, int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Badge> findByUuid(String uuid, int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Badge> list = null;

		if (retrieveFromCache) {
			list = (List<Badge>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Badge badge : list) {
					if (!Objects.equals(uuid, badge.getUuid())) {
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

			query.append(_SQL_SELECT_BADGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first badge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findByUuid_First(String uuid,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchByUuid_First(uuid, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the first badge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchByUuid_First(String uuid,
		OrderByComparator<Badge> orderByComparator) {
		List<Badge> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last badge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findByUuid_Last(String uuid,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchByUuid_Last(uuid, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the last badge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchByUuid_Last(String uuid,
		OrderByComparator<Badge> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Badge> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Badge[] findByUuid_PrevAndNext(long badgeId, String uuid,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = findByPrimaryKey(badgeId);

		Session session = null;

		try {
			session = openSession();

			Badge[] array = new BadgeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, badge, uuid,
					orderByComparator, true);

			array[1] = badge;

			array[2] = getByUuid_PrevAndNext(session, badge, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Badge getByUuid_PrevAndNext(Session session, Badge badge,
		String uuid, OrderByComparator<Badge> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BADGE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(BadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Badge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the badges where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Badge badge : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching badges
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "badge.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "badge.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(badge.uuid IS NULL OR badge.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			BadgeModelImpl.UUID_COLUMN_BITMASK |
			BadgeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the badge where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchBadgeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findByUUID_G(String uuid, long groupId)
		throws NoSuchBadgeException {
		Badge badge = fetchByUUID_G(uuid, groupId);

		if (badge == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBadgeException(msg.toString());
		}

		return badge;
	}

	/**
	 * Returns the badge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the badge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Badge) {
			Badge badge = (Badge)result;

			if (!Objects.equals(uuid, badge.getUuid()) ||
					(groupId != badge.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BADGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Badge> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Badge badge = list.get(0);

					result = badge;

					cacheResult(badge);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

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
			return (Badge)result;
		}
	}

	/**
	 * Removes the badge where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the badge that was removed
	 */
	@Override
	public Badge removeByUUID_G(String uuid, long groupId)
		throws NoSuchBadgeException {
		Badge badge = findByUUID_G(uuid, groupId);

		return remove(badge);
	}

	/**
	 * Returns the number of badges where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching badges
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BADGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "badge.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "badge.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(badge.uuid IS NULL OR badge.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "badge.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			BadgeModelImpl.UUID_COLUMN_BITMASK |
			BadgeModelImpl.COMPANYID_COLUMN_BITMASK |
			BadgeModelImpl.ASSIGNEDDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the badges where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching badges
	 */
	@Override
	public List<Badge> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Badge> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Badge> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Badge> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Badge> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Badge> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Badge> list = null;

		if (retrieveFromCache) {
			list = (List<Badge>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Badge badge : list) {
					if (!Objects.equals(uuid, badge.getUuid()) ||
							(companyId != badge.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BADGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first badge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the first badge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Badge> orderByComparator) {
		List<Badge> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Badge findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the last badge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Badge> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Badge> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Badge[] findByUuid_C_PrevAndNext(long badgeId, String uuid,
		long companyId, OrderByComparator<Badge> orderByComparator)
		throws NoSuchBadgeException {
		Badge badge = findByPrimaryKey(badgeId);

		Session session = null;

		try {
			session = openSession();

			Badge[] array = new BadgeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, badge, uuid, companyId,
					orderByComparator, true);

			array[1] = badge;

			array[2] = getByUuid_C_PrevAndNext(session, badge, uuid, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Badge getByUuid_C_PrevAndNext(Session session, Badge badge,
		String uuid, long companyId,
		OrderByComparator<Badge> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_BADGE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(BadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Badge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the badges where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Badge badge : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching badges
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BADGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "badge.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "badge.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(badge.uuid IS NULL OR badge.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "badge.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BADGETYPE =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybadgeType",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybadgeType",
			new String[] { Long.class.getName() },
			BadgeModelImpl.BADGETYPEID_COLUMN_BITMASK |
			BadgeModelImpl.ASSIGNEDDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BADGETYPE = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybadgeType",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the badges where badgeTypeId = &#63;.
	 *
	 * @param badgeTypeId the badge type ID
	 * @return the matching badges
	 */
	@Override
	public List<Badge> findBybadgeType(long badgeTypeId) {
		return findBybadgeType(badgeTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Badge> findBybadgeType(long badgeTypeId, int start, int end) {
		return findBybadgeType(badgeTypeId, start, end, null);
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
	@Override
	public List<Badge> findBybadgeType(long badgeTypeId, int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return findBybadgeType(badgeTypeId, start, end, orderByComparator, true);
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
	@Override
	public List<Badge> findBybadgeType(long badgeTypeId, int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE;
			finderArgs = new Object[] { badgeTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BADGETYPE;
			finderArgs = new Object[] { badgeTypeId, start, end, orderByComparator };
		}

		List<Badge> list = null;

		if (retrieveFromCache) {
			list = (List<Badge>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Badge badge : list) {
					if ((badgeTypeId != badge.getBadgeTypeId())) {
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

			query.append(_SQL_SELECT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_BADGETYPE_BADGETYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(badgeTypeId);

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first badge in the ordered set where badgeTypeId = &#63;.
	 *
	 * @param badgeTypeId the badge type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findBybadgeType_First(long badgeTypeId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchBybadgeType_First(badgeTypeId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("badgeTypeId=");
		msg.append(badgeTypeId);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the first badge in the ordered set where badgeTypeId = &#63;.
	 *
	 * @param badgeTypeId the badge type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchBybadgeType_First(long badgeTypeId,
		OrderByComparator<Badge> orderByComparator) {
		List<Badge> list = findBybadgeType(badgeTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last badge in the ordered set where badgeTypeId = &#63;.
	 *
	 * @param badgeTypeId the badge type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findBybadgeType_Last(long badgeTypeId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchBybadgeType_Last(badgeTypeId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("badgeTypeId=");
		msg.append(badgeTypeId);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the last badge in the ordered set where badgeTypeId = &#63;.
	 *
	 * @param badgeTypeId the badge type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchBybadgeType_Last(long badgeTypeId,
		OrderByComparator<Badge> orderByComparator) {
		int count = countBybadgeType(badgeTypeId);

		if (count == 0) {
			return null;
		}

		List<Badge> list = findBybadgeType(badgeTypeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Badge[] findBybadgeType_PrevAndNext(long badgeId, long badgeTypeId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = findByPrimaryKey(badgeId);

		Session session = null;

		try {
			session = openSession();

			Badge[] array = new BadgeImpl[3];

			array[0] = getBybadgeType_PrevAndNext(session, badge, badgeTypeId,
					orderByComparator, true);

			array[1] = badge;

			array[2] = getBybadgeType_PrevAndNext(session, badge, badgeTypeId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Badge getBybadgeType_PrevAndNext(Session session, Badge badge,
		long badgeTypeId, OrderByComparator<Badge> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BADGE_WHERE);

		query.append(_FINDER_COLUMN_BADGETYPE_BADGETYPEID_2);

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
			query.append(BadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(badgeTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Badge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the badges where badgeTypeId = &#63; from the database.
	 *
	 * @param badgeTypeId the badge type ID
	 */
	@Override
	public void removeBybadgeType(long badgeTypeId) {
		for (Badge badge : findBybadgeType(badgeTypeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges where badgeTypeId = &#63;.
	 *
	 * @param badgeTypeId the badge type ID
	 * @return the number of matching badges
	 */
	@Override
	public int countBybadgeType(long badgeTypeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BADGETYPE;

		Object[] finderArgs = new Object[] { badgeTypeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_BADGETYPE_BADGETYPEID_2);

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

	private static final String _FINDER_COLUMN_BADGETYPE_BADGETYPEID_2 = "badge.badgeTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			BadgeModelImpl.USERID_COLUMN_BITMASK |
			BadgeModelImpl.ASSIGNEDDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the badges where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching badges
	 */
	@Override
	public List<Badge> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Badge> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
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
	@Override
	public List<Badge> findByuserId(long userId, int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return findByuserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Badge> findByuserId(long userId, int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Badge> list = null;

		if (retrieveFromCache) {
			list = (List<Badge>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Badge badge : list) {
					if ((userId != badge.getUserId())) {
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

			query.append(_SQL_SELECT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first badge in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findByuserId_First(long userId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchByuserId_First(userId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the first badge in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchByuserId_First(long userId,
		OrderByComparator<Badge> orderByComparator) {
		List<Badge> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last badge in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findByuserId_Last(long userId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchByuserId_Last(userId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the last badge in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchByuserId_Last(long userId,
		OrderByComparator<Badge> orderByComparator) {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Badge> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Badge[] findByuserId_PrevAndNext(long badgeId, long userId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = findByPrimaryKey(badgeId);

		Session session = null;

		try {
			session = openSession();

			Badge[] array = new BadgeImpl[3];

			array[0] = getByuserId_PrevAndNext(session, badge, userId,
					orderByComparator, true);

			array[1] = badge;

			array[2] = getByuserId_PrevAndNext(session, badge, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Badge getByuserId_PrevAndNext(Session session, Badge badge,
		long userId, OrderByComparator<Badge> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BADGE_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(BadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Badge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the badges where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Badge badge : findByuserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching badges
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "badge.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TOUSERID = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytoUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOUSERID =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytoUserId",
			new String[] { Long.class.getName() },
			BadgeModelImpl.TOUSERID_COLUMN_BITMASK |
			BadgeModelImpl.ASSIGNEDDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOUSERID = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytoUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the badges where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @return the matching badges
	 */
	@Override
	public List<Badge> findBytoUserId(long toUserId) {
		return findBytoUserId(toUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Badge> findBytoUserId(long toUserId, int start, int end) {
		return findBytoUserId(toUserId, start, end, null);
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
	@Override
	public List<Badge> findBytoUserId(long toUserId, int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return findBytoUserId(toUserId, start, end, orderByComparator, true);
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
	@Override
	public List<Badge> findBytoUserId(long toUserId, int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOUSERID;
			finderArgs = new Object[] { toUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TOUSERID;
			finderArgs = new Object[] { toUserId, start, end, orderByComparator };
		}

		List<Badge> list = null;

		if (retrieveFromCache) {
			list = (List<Badge>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Badge badge : list) {
					if ((toUserId != badge.getToUserId())) {
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

			query.append(_SQL_SELECT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_TOUSERID_TOUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(toUserId);

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first badge in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findBytoUserId_First(long toUserId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchBytoUserId_First(toUserId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("toUserId=");
		msg.append(toUserId);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the first badge in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchBytoUserId_First(long toUserId,
		OrderByComparator<Badge> orderByComparator) {
		List<Badge> list = findBytoUserId(toUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last badge in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge
	 * @throws NoSuchBadgeException if a matching badge could not be found
	 */
	@Override
	public Badge findBytoUserId_Last(long toUserId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = fetchBytoUserId_Last(toUserId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("toUserId=");
		msg.append(toUserId);

		msg.append("}");

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the last badge in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge, or <code>null</code> if a matching badge could not be found
	 */
	@Override
	public Badge fetchBytoUserId_Last(long toUserId,
		OrderByComparator<Badge> orderByComparator) {
		int count = countBytoUserId(toUserId);

		if (count == 0) {
			return null;
		}

		List<Badge> list = findBytoUserId(toUserId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Badge[] findBytoUserId_PrevAndNext(long badgeId, long toUserId,
		OrderByComparator<Badge> orderByComparator) throws NoSuchBadgeException {
		Badge badge = findByPrimaryKey(badgeId);

		Session session = null;

		try {
			session = openSession();

			Badge[] array = new BadgeImpl[3];

			array[0] = getBytoUserId_PrevAndNext(session, badge, toUserId,
					orderByComparator, true);

			array[1] = badge;

			array[2] = getBytoUserId_PrevAndNext(session, badge, toUserId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Badge getBytoUserId_PrevAndNext(Session session, Badge badge,
		long toUserId, OrderByComparator<Badge> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BADGE_WHERE);

		query.append(_FINDER_COLUMN_TOUSERID_TOUSERID_2);

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
			query.append(BadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(toUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Badge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the badges where toUserId = &#63; from the database.
	 *
	 * @param toUserId the to user ID
	 */
	@Override
	public void removeBytoUserId(long toUserId) {
		for (Badge badge : findBytoUserId(toUserId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @return the number of matching badges
	 */
	@Override
	public int countBytoUserId(long toUserId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOUSERID;

		Object[] finderArgs = new Object[] { toUserId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_TOUSERID_TOUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(toUserId);

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

	private static final String _FINDER_COLUMN_TOUSERID_TOUSERID_2 = "badge.toUserId = ?";

	public BadgePersistenceImpl() {
		setModelClass(Badge.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the badge in the entity cache if it is enabled.
	 *
	 * @param badge the badge
	 */
	@Override
	public void cacheResult(Badge badge) {
		entityCache.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey(), badge);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { badge.getUuid(), badge.getGroupId() }, badge);

		badge.resetOriginalValues();
	}

	/**
	 * Caches the badges in the entity cache if it is enabled.
	 *
	 * @param badges the badges
	 */
	@Override
	public void cacheResult(List<Badge> badges) {
		for (Badge badge : badges) {
			if (entityCache.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeImpl.class, badge.getPrimaryKey()) == null) {
				cacheResult(badge);
			}
			else {
				badge.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all badges.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BadgeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the badge.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Badge badge) {
		entityCache.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BadgeModelImpl)badge, true);
	}

	@Override
	public void clearCache(List<Badge> badges) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Badge badge : badges) {
			entityCache.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeImpl.class, badge.getPrimaryKey());

			clearUniqueFindersCache((BadgeModelImpl)badge, true);
		}
	}

	protected void cacheUniqueFindersCache(BadgeModelImpl badgeModelImpl) {
		Object[] args = new Object[] {
				badgeModelImpl.getUuid(), badgeModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			badgeModelImpl, false);
	}

	protected void clearUniqueFindersCache(BadgeModelImpl badgeModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					badgeModelImpl.getUuid(), badgeModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((badgeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					badgeModelImpl.getOriginalUuid(),
					badgeModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new badge with the primary key. Does not add the badge to the database.
	 *
	 * @param badgeId the primary key for the new badge
	 * @return the new badge
	 */
	@Override
	public Badge create(long badgeId) {
		Badge badge = new BadgeImpl();

		badge.setNew(true);
		badge.setPrimaryKey(badgeId);

		String uuid = PortalUUIDUtil.generate();

		badge.setUuid(uuid);

		badge.setCompanyId(companyProvider.getCompanyId());

		return badge;
	}

	/**
	 * Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge that was removed
	 * @throws NoSuchBadgeException if a badge with the primary key could not be found
	 */
	@Override
	public Badge remove(long badgeId) throws NoSuchBadgeException {
		return remove((Serializable)badgeId);
	}

	/**
	 * Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge that was removed
	 * @throws NoSuchBadgeException if a badge with the primary key could not be found
	 */
	@Override
	public Badge remove(Serializable primaryKey) throws NoSuchBadgeException {
		Session session = null;

		try {
			session = openSession();

			Badge badge = (Badge)session.get(BadgeImpl.class, primaryKey);

			if (badge == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(badge);
		}
		catch (NoSuchBadgeException nsee) {
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
	protected Badge removeImpl(Badge badge) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(badge)) {
				badge = (Badge)session.get(BadgeImpl.class,
						badge.getPrimaryKeyObj());
			}

			if (badge != null) {
				session.delete(badge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (badge != null) {
			clearCache(badge);
		}

		return badge;
	}

	@Override
	public Badge updateImpl(Badge badge) {
		boolean isNew = badge.isNew();

		if (!(badge instanceof BadgeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(badge.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(badge);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in badge proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Badge implementation " +
				badge.getClass());
		}

		BadgeModelImpl badgeModelImpl = (BadgeModelImpl)badge;

		if (Validator.isNull(badge.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			badge.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (badge.isNew()) {
				session.save(badge);

				badge.setNew(false);
			}
			else {
				badge = (Badge)session.merge(badge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!BadgeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { badgeModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					badgeModelImpl.getUuid(), badgeModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { badgeModelImpl.getBadgeTypeId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BADGETYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE,
				args);

			args = new Object[] { badgeModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
				args);

			args = new Object[] { badgeModelImpl.getToUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TOUSERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOUSERID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((badgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { badgeModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { badgeModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((badgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						badgeModelImpl.getOriginalUuid(),
						badgeModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						badgeModelImpl.getUuid(), badgeModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((badgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						badgeModelImpl.getOriginalBadgeTypeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BADGETYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE,
					args);

				args = new Object[] { badgeModelImpl.getBadgeTypeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BADGETYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE,
					args);
			}

			if ((badgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { badgeModelImpl.getOriginalUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { badgeModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((badgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						badgeModelImpl.getOriginalToUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TOUSERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOUSERID,
					args);

				args = new Object[] { badgeModelImpl.getToUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TOUSERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOUSERID,
					args);
			}
		}

		entityCache.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey(), badge, false);

		clearUniqueFindersCache(badgeModelImpl, false);
		cacheUniqueFindersCache(badgeModelImpl);

		badge.resetOriginalValues();

		return badge;
	}

	/**
	 * Returns the badge with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge
	 * @throws NoSuchBadgeException if a badge with the primary key could not be found
	 */
	@Override
	public Badge findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBadgeException {
		Badge badge = fetchByPrimaryKey(primaryKey);

		if (badge == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return badge;
	}

	/**
	 * Returns the badge with the primary key or throws a {@link NoSuchBadgeException} if it could not be found.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge
	 * @throws NoSuchBadgeException if a badge with the primary key could not be found
	 */
	@Override
	public Badge findByPrimaryKey(long badgeId) throws NoSuchBadgeException {
		return findByPrimaryKey((Serializable)badgeId);
	}

	/**
	 * Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge, or <code>null</code> if a badge with the primary key could not be found
	 */
	@Override
	public Badge fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Badge badge = (Badge)serializable;

		if (badge == null) {
			Session session = null;

			try {
				session = openSession();

				badge = (Badge)session.get(BadgeImpl.class, primaryKey);

				if (badge != null) {
					cacheResult(badge);
				}
				else {
					entityCache.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return badge;
	}

	/**
	 * Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge, or <code>null</code> if a badge with the primary key could not be found
	 */
	@Override
	public Badge fetchByPrimaryKey(long badgeId) {
		return fetchByPrimaryKey((Serializable)badgeId);
	}

	@Override
	public Map<Serializable, Badge> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Badge> map = new HashMap<Serializable, Badge>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Badge badge = fetchByPrimaryKey(primaryKey);

			if (badge != null) {
				map.put(primaryKey, badge);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Badge)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BADGE_WHERE_PKS_IN);

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

			for (Badge badge : (List<Badge>)q.list()) {
				map.put(badge.getPrimaryKeyObj(), badge);

				cacheResult(badge);

				uncachedPrimaryKeys.remove(badge.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeImpl.class, primaryKey, nullModel);
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
	 * Returns all the badges.
	 *
	 * @return the badges
	 */
	@Override
	public List<Badge> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Badge> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Badge> findAll(int start, int end,
		OrderByComparator<Badge> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Badge> findAll(int start, int end,
		OrderByComparator<Badge> orderByComparator, boolean retrieveFromCache) {
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

		List<Badge> list = null;

		if (retrieveFromCache) {
			list = (List<Badge>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BADGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BADGE;

				if (pagination) {
					sql = sql.concat(BadgeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the badges from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Badge badge : findAll()) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges.
	 *
	 * @return the number of badges
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BADGE);

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
		return BadgeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the badge persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BadgeImpl.class.getName());
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
	private static final String _SQL_SELECT_BADGE = "SELECT badge FROM Badge badge";
	private static final String _SQL_SELECT_BADGE_WHERE_PKS_IN = "SELECT badge FROM Badge badge WHERE badgeId IN (";
	private static final String _SQL_SELECT_BADGE_WHERE = "SELECT badge FROM Badge badge WHERE ";
	private static final String _SQL_COUNT_BADGE = "SELECT COUNT(badge) FROM Badge badge";
	private static final String _SQL_COUNT_BADGE_WHERE = "SELECT COUNT(badge) FROM Badge badge WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "badge.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Badge exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Badge exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BadgePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}
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

package com.liferay.micro.maintainance.decision.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.decision.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.decision.model.DecisionEntry;
import com.liferay.micro.maintainance.decision.model.impl.DecisionEntryImpl;
import com.liferay.micro.maintainance.decision.model.impl.DecisionEntryModelImpl;
import com.liferay.micro.maintainance.decision.service.persistence.DecisionEntryPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

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
 * The persistence implementation for the decision entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntryPersistence
 * @see com.liferay.micro.maintainance.decision.service.persistence.DecisionEntryUtil
 * @generated
 */
@ProviderType
public class DecisionEntryPersistenceImpl extends BasePersistenceImpl<DecisionEntry>
	implements DecisionEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DecisionEntryUtil} to access the decision entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DecisionEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			DecisionEntryModelImpl.UUID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the decision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
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

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if (!Objects.equals(uuid, decisionEntry.getUuid())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
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
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByUuid_First(String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByUuid_First(uuid, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByUuid_First(String uuid,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByUuid_Last(String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByUuid_Last(String uuid,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the decision entries before and after the current decision entry in the ordered set where uuid = &#63;.
	 *
	 * @param decisionId the primary key of the current decision entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry[] findByUuid_PrevAndNext(long decisionId, String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, decisionEntry, uuid,
					orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByUuid_PrevAndNext(session, decisionEntry, uuid,
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

	protected DecisionEntry getByUuid_PrevAndNext(Session session,
		DecisionEntry decisionEntry, String uuid,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DecisionEntry decisionEntry : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "decisionEntry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "decisionEntry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(decisionEntry.uuid IS NULL OR decisionEntry.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			DecisionEntryModelImpl.UUID_COLUMN_BITMASK |
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the decision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
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

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if (!Objects.equals(uuid, decisionEntry.getUuid()) ||
							(companyId != decisionEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
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
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the decision entries before and after the current decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the primary key of the current decision entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry[] findByUuid_C_PrevAndNext(long decisionId,
		String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, decisionEntry, uuid,
					companyId, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByUuid_C_PrevAndNext(session, decisionEntry, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByUuid_C_PrevAndNext(Session session,
		DecisionEntry decisionEntry, String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DecisionEntry decisionEntry : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "decisionEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "decisionEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(decisionEntry.uuid IS NULL OR decisionEntry.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "decisionEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DECISIONID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDecisionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDecisionId", new String[] { Long.class.getName() },
			DecisionEntryModelImpl.DECISIONID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DECISIONID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDecisionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the decision entries where decisionId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByDecisionId(long decisionId) {
		return findByDecisionId(decisionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where decisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByDecisionId(long decisionId, int start,
		int end) {
		return findByDecisionId(decisionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByDecisionId(long decisionId, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByDecisionId(decisionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByDecisionId(long decisionId, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONID;
			finderArgs = new Object[] { decisionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DECISIONID;
			finderArgs = new Object[] { decisionId, start, end, orderByComparator };
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionId != decisionEntry.getDecisionId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_DECISIONID_DECISIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByDecisionId_First(long decisionId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByDecisionId_First(decisionId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByDecisionId_First(long decisionId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByDecisionId(decisionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByDecisionId_Last(long decisionId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByDecisionId_Last(decisionId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByDecisionId_Last(long decisionId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByDecisionId(decisionId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByDecisionId(decisionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionId = &#63; from the database.
	 *
	 * @param decisionId the decision ID
	 */
	@Override
	public void removeByDecisionId(long decisionId) {
		for (DecisionEntry decisionEntry : findByDecisionId(decisionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByDecisionId(long decisionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DECISIONID;

		Object[] finderArgs = new Object[] { decisionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_DECISIONID_DECISIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

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

	private static final String _FINDER_COLUMN_DECISIONID_DECISIONID_2 = "decisionEntry.decisionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyId", new String[] { Long.class.getName() },
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the decision entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the decision entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByCompanyId(long companyId, int start,
		int end) {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((companyId != decisionEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByCompanyId_First(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByCompanyId_First(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByCompanyId_Last(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByCompanyId_Last(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63;.
	 *
	 * @param decisionId the primary key of the current decision entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry[] findByCompanyId_PrevAndNext(long decisionId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, decisionEntry,
					companyId, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByCompanyId_PrevAndNext(session, decisionEntry,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByCompanyId_PrevAndNext(Session session,
		DecisionEntry decisionEntry, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (DecisionEntry decisionEntry : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "decisionEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			DecisionEntryModelImpl.DECISIONID_COLUMN_BITMASK |
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the decision entries where decisionId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_C(long decisionId, long companyId) {
		return findByD_C(decisionId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where decisionId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_C(long decisionId, long companyId,
		int start, int end) {
		return findByD_C(decisionId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_C(long decisionId, long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_C(decisionId, companyId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_C(long decisionId, long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C;
			finderArgs = new Object[] { decisionId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_C;
			finderArgs = new Object[] {
					decisionId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionId != decisionEntry.getDecisionId()) ||
							(companyId != decisionEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_C_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_C_First(long decisionId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_C_First(decisionId, companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_C_First(long decisionId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_C(decisionId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_C_Last(long decisionId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_C_Last(decisionId, companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_C_Last(long decisionId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_C(decisionId, companyId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_C(decisionId, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionId = &#63; and companyId = &#63; from the database.
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByD_C(long decisionId, long companyId) {
		for (DecisionEntry decisionEntry : findByD_C(decisionId, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param companyId the company ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_C(long decisionId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_C;

		Object[] finderArgs = new Object[] { decisionId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_C_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

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

	private static final String _FINDER_COLUMN_D_C_DECISIONID_2 = "decisionEntry.decisionId = ? AND ";
	private static final String _FINDER_COLUMN_D_C_COMPANYID_2 = "decisionEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_A = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_A",
			new String[] { Long.class.getName(), Long.class.getName() },
			DecisionEntryModelImpl.DECISIONID_COLUMN_BITMASK |
			DecisionEntryModelImpl.ANALYSISID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_A = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_A",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the decision entries where decisionId = &#63; and analysisId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_A(long decisionId, long analysisId) {
		return findByD_A(decisionId, analysisId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where decisionId = &#63; and analysisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_A(long decisionId, long analysisId,
		int start, int end) {
		return findByD_A(decisionId, analysisId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and analysisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_A(long decisionId, long analysisId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_A(decisionId, analysisId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and analysisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_A(long decisionId, long analysisId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A;
			finderArgs = new Object[] { decisionId, analysisId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_A;
			finderArgs = new Object[] {
					decisionId, analysisId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionId != decisionEntry.getDecisionId()) ||
							(analysisId != decisionEntry.getAnalysisId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_A_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_A_ANALYSISID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(analysisId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_A_First(long decisionId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_A_First(decisionId, analysisId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", analysisId=");
		msg.append(analysisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_A_First(long decisionId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_A(decisionId, analysisId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_A_Last(long decisionId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_A_Last(decisionId, analysisId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", analysisId=");
		msg.append(analysisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_A_Last(long decisionId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_A(decisionId, analysisId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_A(decisionId, analysisId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionId = &#63; and analysisId = &#63; from the database.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 */
	@Override
	public void removeByD_A(long decisionId, long analysisId) {
		for (DecisionEntry decisionEntry : findByD_A(decisionId, analysisId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionId = &#63; and analysisId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_A(long decisionId, long analysisId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_A;

		Object[] finderArgs = new Object[] { decisionId, analysisId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_A_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_A_ANALYSISID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(analysisId);

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

	private static final String _FINDER_COLUMN_D_A_DECISIONID_2 = "decisionEntry.decisionId = ? AND ";
	private static final String _FINDER_COLUMN_D_A_ANALYSISID_2 = "decisionEntry.analysisId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_H",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_H",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			DecisionEntryModelImpl.DECISIONID_COLUMN_BITMASK |
			DecisionEntryModelImpl.HANDLED_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_H",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the decision entries where decisionId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_H(long decisionId, boolean handled) {
		return findByD_H(decisionId, handled, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where decisionId = &#63; and handled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_H(long decisionId, boolean handled,
		int start, int end) {
		return findByD_H(decisionId, handled, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and handled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_H(long decisionId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_H(decisionId, handled, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and handled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_H(long decisionId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H;
			finderArgs = new Object[] { decisionId, handled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_H;
			finderArgs = new Object[] {
					decisionId, handled,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionId != decisionEntry.getDecisionId()) ||
							(handled != decisionEntry.getHandled())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_H_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_H_HANDLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(handled);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_H_First(long decisionId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_H_First(decisionId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_H_First(long decisionId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_H(decisionId, handled, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_H_Last(long decisionId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_H_Last(decisionId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_H_Last(long decisionId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_H(decisionId, handled);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_H(decisionId, handled, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionId = &#63; and handled = &#63; from the database.
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 */
	@Override
	public void removeByD_H(long decisionId, boolean handled) {
		for (DecisionEntry decisionEntry : findByD_H(decisionId, handled,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param handled the handled
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_H(long decisionId, boolean handled) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_H;

		Object[] finderArgs = new Object[] { decisionId, handled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_H_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_H_HANDLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(handled);

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

	private static final String _FINDER_COLUMN_D_H_DECISIONID_2 = "decisionEntry.decisionId = ? AND ";
	private static final String _FINDER_COLUMN_D_H_HANDLED_2 = "decisionEntry.handled = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_A_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_A_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_A_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			DecisionEntryModelImpl.DECISIONID_COLUMN_BITMASK |
			DecisionEntryModelImpl.ANALYSISID_COLUMN_BITMASK |
			DecisionEntryModelImpl.HANDLED_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_A_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_A_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_A_H(long decisionId, long analysisId,
		boolean handled) {
		return findByD_A_H(decisionId, analysisId, handled, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_A_H(long decisionId, long analysisId,
		boolean handled, int start, int end) {
		return findByD_A_H(decisionId, analysisId, handled, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_A_H(long decisionId, long analysisId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_A_H(decisionId, analysisId, handled, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_A_H(long decisionId, long analysisId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A_H;
			finderArgs = new Object[] { decisionId, analysisId, handled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_A_H;
			finderArgs = new Object[] {
					decisionId, analysisId, handled,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionId != decisionEntry.getDecisionId()) ||
							(analysisId != decisionEntry.getAnalysisId()) ||
							(handled != decisionEntry.getHandled())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_A_H_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_A_H_ANALYSISID_2);

			query.append(_FINDER_COLUMN_D_A_H_HANDLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(analysisId);

				qPos.add(handled);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_A_H_First(long decisionId, long analysisId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_A_H_First(decisionId,
				analysisId, handled, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", analysisId=");
		msg.append(analysisId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_A_H_First(long decisionId, long analysisId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_A_H(decisionId, analysisId, handled,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_A_H_Last(long decisionId, long analysisId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_A_H_Last(decisionId, analysisId,
				handled, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", analysisId=");
		msg.append(analysisId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_A_H_Last(long decisionId, long analysisId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_A_H(decisionId, analysisId, handled);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_A_H(decisionId, analysisId, handled,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63; from the database.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 */
	@Override
	public void removeByD_A_H(long decisionId, long analysisId, boolean handled) {
		for (DecisionEntry decisionEntry : findByD_A_H(decisionId, analysisId,
				handled, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param analysisId the analysis ID
	 * @param handled the handled
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_A_H(long decisionId, long analysisId, boolean handled) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_A_H;

		Object[] finderArgs = new Object[] { decisionId, analysisId, handled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_A_H_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_A_H_ANALYSISID_2);

			query.append(_FINDER_COLUMN_D_A_H_HANDLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(analysisId);

				qPos.add(handled);

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

	private static final String _FINDER_COLUMN_D_A_H_DECISIONID_2 = "decisionEntry.decisionId = ? AND ";
	private static final String _FINDER_COLUMN_D_A_H_ANALYSISID_2 = "decisionEntry.analysisId = ? AND ";
	private static final String _FINDER_COLUMN_D_A_H_HANDLED_2 = "decisionEntry.handled = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_U = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			DecisionEntryModelImpl.DECISIONID_COLUMN_BITMASK |
			DecisionEntryModelImpl.USERID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_U = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the decision entries where decisionId = &#63; and userId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U(long decisionId, long userId) {
		return findByD_U(decisionId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where decisionId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U(long decisionId, long userId,
		int start, int end) {
		return findByD_U(decisionId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U(long decisionId, long userId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_U(decisionId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U(long decisionId, long userId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U;
			finderArgs = new Object[] { decisionId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_U;
			finderArgs = new Object[] {
					decisionId, userId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionId != decisionEntry.getDecisionId()) ||
							(userId != decisionEntry.getUserId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_U_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_U_First(long decisionId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_U_First(decisionId, userId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_U_First(long decisionId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_U(decisionId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_U_Last(long decisionId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_U_Last(decisionId, userId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_U_Last(long decisionId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_U(decisionId, userId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_U(decisionId, userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionId = &#63; and userId = &#63; from the database.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByD_U(long decisionId, long userId) {
		for (DecisionEntry decisionEntry : findByD_U(decisionId, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionId = &#63; and userId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_U(long decisionId, long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_U;

		Object[] finderArgs = new Object[] { decisionId, userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_U_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

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

	private static final String _FINDER_COLUMN_D_U_DECISIONID_2 = "decisionEntry.decisionId = ? AND ";
	private static final String _FINDER_COLUMN_D_U_USERID_2 = "decisionEntry.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_U_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_U_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_U_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			DecisionEntryModelImpl.DECISIONID_COLUMN_BITMASK |
			DecisionEntryModelImpl.USERID_COLUMN_BITMASK |
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_U_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_U_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U_C(long decisionId, long userId,
		long companyId) {
		return findByD_U_C(decisionId, userId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U_C(long decisionId, long userId,
		long companyId, int start, int end) {
		return findByD_U_C(decisionId, userId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U_C(long decisionId, long userId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_U_C(decisionId, userId, companyId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U_C(long decisionId, long userId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C;
			finderArgs = new Object[] { decisionId, userId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_U_C;
			finderArgs = new Object[] {
					decisionId, userId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionId != decisionEntry.getDecisionId()) ||
							(userId != decisionEntry.getUserId()) ||
							(companyId != decisionEntry.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_U_C_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_U_C_USERID_2);

			query.append(_FINDER_COLUMN_D_U_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(userId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_U_C_First(long decisionId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_U_C_First(decisionId, userId,
				companyId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_U_C_First(long decisionId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_U_C(decisionId, userId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_U_C_Last(long decisionId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_U_C_Last(decisionId, userId,
				companyId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionId=");
		msg.append(decisionId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_U_C_Last(long decisionId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_U_C(decisionId, userId, companyId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_U_C(decisionId, userId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByD_U_C(long decisionId, long userId, long companyId) {
		for (DecisionEntry decisionEntry : findByD_U_C(decisionId, userId,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param decisionId the decision ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_U_C(long decisionId, long userId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_U_C;

		Object[] finderArgs = new Object[] { decisionId, userId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_U_C_DECISIONID_2);

			query.append(_FINDER_COLUMN_D_U_C_USERID_2);

			query.append(_FINDER_COLUMN_D_U_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_D_U_C_DECISIONID_2 = "decisionEntry.decisionId = ? AND ";
	private static final String _FINDER_COLUMN_D_U_C_USERID_2 = "decisionEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_D_U_C_COMPANYID_2 = "decisionEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_A = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_A",
			new String[] { Long.class.getName(), Long.class.getName() },
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.ANALYSISID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_A = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_A",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the decision entries where companyId = &#63; and analysisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByC_A(long companyId, long analysisId) {
		return findByC_A(companyId, analysisId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where companyId = &#63; and analysisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByC_A(long companyId, long analysisId,
		int start, int end) {
		return findByC_A(companyId, analysisId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where companyId = &#63; and analysisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByC_A(long companyId, long analysisId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByC_A(companyId, analysisId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the decision entries where companyId = &#63; and analysisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByC_A(long companyId, long analysisId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A;
			finderArgs = new Object[] { companyId, analysisId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_A;
			finderArgs = new Object[] {
					companyId, analysisId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((companyId != decisionEntry.getCompanyId()) ||
							(analysisId != decisionEntry.getAnalysisId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_A_ANALYSISID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(analysisId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByC_A_First(long companyId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByC_A_First(companyId, analysisId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", analysisId=");
		msg.append(analysisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByC_A_First(long companyId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByC_A(companyId, analysisId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByC_A_Last(long companyId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByC_A_Last(companyId, analysisId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", analysisId=");
		msg.append(analysisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByC_A_Last(long companyId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByC_A(companyId, analysisId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByC_A(companyId, analysisId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	 *
	 * @param decisionId the primary key of the current decision entry
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry[] findByC_A_PrevAndNext(long decisionId,
		long companyId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByC_A_PrevAndNext(session, decisionEntry, companyId,
					analysisId, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByC_A_PrevAndNext(session, decisionEntry, companyId,
					analysisId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByC_A_PrevAndNext(Session session,
		DecisionEntry decisionEntry, long companyId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_C_A_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_A_ANALYSISID_2);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(analysisId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where companyId = &#63; and analysisId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 */
	@Override
	public void removeByC_A(long companyId, long analysisId) {
		for (DecisionEntry decisionEntry : findByC_A(companyId, analysisId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where companyId = &#63; and analysisId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param analysisId the analysis ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByC_A(long companyId, long analysisId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_A;

		Object[] finderArgs = new Object[] { companyId, analysisId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_A_ANALYSISID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(analysisId);

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

	private static final String _FINDER_COLUMN_C_A_COMPANYID_2 = "decisionEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_A_ANALYSISID_2 = "decisionEntry.analysisId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_A = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByU_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByU_A",
			new String[] { Long.class.getName(), Long.class.getName() },
			DecisionEntryModelImpl.USERID_COLUMN_BITMASK |
			DecisionEntryModelImpl.ANALYSISID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_A = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_A",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the decision entries where userId = &#63; and analysisId = &#63;.
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_A(long userId, long analysisId) {
		return findByU_A(userId, analysisId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where userId = &#63; and analysisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_A(long userId, long analysisId,
		int start, int end) {
		return findByU_A(userId, analysisId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where userId = &#63; and analysisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_A(long userId, long analysisId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByU_A(userId, analysisId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where userId = &#63; and analysisId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_A(long userId, long analysisId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A;
			finderArgs = new Object[] { userId, analysisId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_A;
			finderArgs = new Object[] {
					userId, analysisId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((userId != decisionEntry.getUserId()) ||
							(analysisId != decisionEntry.getAnalysisId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_A_USERID_2);

			query.append(_FINDER_COLUMN_U_A_ANALYSISID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(analysisId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByU_A_First(long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_A_First(userId, analysisId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", analysisId=");
		msg.append(analysisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByU_A_First(long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByU_A(userId, analysisId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByU_A_Last(long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_A_Last(userId, analysisId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", analysisId=");
		msg.append(analysisId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByU_A_Last(long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByU_A(userId, analysisId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByU_A(userId, analysisId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the decision entries before and after the current decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	 *
	 * @param decisionId the primary key of the current decision entry
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry[] findByU_A_PrevAndNext(long decisionId, long userId,
		long analysisId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByU_A_PrevAndNext(session, decisionEntry, userId,
					analysisId, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByU_A_PrevAndNext(session, decisionEntry, userId,
					analysisId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByU_A_PrevAndNext(Session session,
		DecisionEntry decisionEntry, long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_U_A_USERID_2);

		query.append(_FINDER_COLUMN_U_A_ANALYSISID_2);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(analysisId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where userId = &#63; and analysisId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 */
	@Override
	public void removeByU_A(long userId, long analysisId) {
		for (DecisionEntry decisionEntry : findByU_A(userId, analysisId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where userId = &#63; and analysisId = &#63;.
	 *
	 * @param userId the user ID
	 * @param analysisId the analysis ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByU_A(long userId, long analysisId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_A;

		Object[] finderArgs = new Object[] { userId, analysisId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_A_USERID_2);

			query.append(_FINDER_COLUMN_U_A_ANALYSISID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(analysisId);

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

	private static final String _FINDER_COLUMN_U_A_USERID_2 = "decisionEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_A_ANALYSISID_2 = "decisionEntry.analysisId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByU_H",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByU_H",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			DecisionEntryModelImpl.USERID_COLUMN_BITMASK |
			DecisionEntryModelImpl.HANDLED_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_H",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the decision entries where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H(long userId, boolean handled) {
		return findByU_H(userId, handled, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the decision entries where userId = &#63; and handled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end) {
		return findByU_H(userId, handled, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByU_H(userId, handled, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H;
			finderArgs = new Object[] { userId, handled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H;
			finderArgs = new Object[] {
					userId, handled,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((userId != decisionEntry.getUserId()) ||
							(handled != decisionEntry.getHandled())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_H_USERID_2);

			query.append(_FINDER_COLUMN_U_H_HANDLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(handled);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByU_H_First(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_H_First(userId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByU_H_First(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByU_H(userId, handled, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByU_H_Last(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_H_Last(userId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByU_H_Last(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByU_H(userId, handled);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByU_H(userId, handled, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the decision entries before and after the current decision entry in the ordered set where userId = &#63; and handled = &#63;.
	 *
	 * @param decisionId the primary key of the current decision entry
	 * @param userId the user ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry[] findByU_H_PrevAndNext(long decisionId, long userId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByU_H_PrevAndNext(session, decisionEntry, userId,
					handled, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByU_H_PrevAndNext(session, decisionEntry, userId,
					handled, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByU_H_PrevAndNext(Session session,
		DecisionEntry decisionEntry, long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_U_H_USERID_2);

		query.append(_FINDER_COLUMN_U_H_HANDLED_2);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(handled);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where userId = &#63; and handled = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 */
	@Override
	public void removeByU_H(long userId, boolean handled) {
		for (DecisionEntry decisionEntry : findByU_H(userId, handled,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByU_H(long userId, boolean handled) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_H;

		Object[] finderArgs = new Object[] { userId, handled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_H_USERID_2);

			query.append(_FINDER_COLUMN_U_H_HANDLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(handled);

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

	private static final String _FINDER_COLUMN_U_H_USERID_2 = "decisionEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_H_HANDLED_2 = "decisionEntry.handled = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H_D = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByU_H_D",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByU_H_D",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			DecisionEntryModelImpl.USERID_COLUMN_BITMASK |
			DecisionEntryModelImpl.HANDLED_COLUMN_BITMASK |
			DecisionEntryModelImpl.DECISIONID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_H_D = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_H_D",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionId) {
		return findByU_H_D(userId, handled, decisionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionId, int start, int end) {
		return findByU_H_D(userId, handled, decisionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return findByU_H_D(userId, handled, decisionId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D;
			finderArgs = new Object[] { userId, handled, decisionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H_D;
			finderArgs = new Object[] {
					userId, handled, decisionId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((userId != decisionEntry.getUserId()) ||
							(handled != decisionEntry.getHandled()) ||
							(decisionId != decisionEntry.getDecisionId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_H_D_USERID_2);

			query.append(_FINDER_COLUMN_U_H_D_HANDLED_2);

			query.append(_FINDER_COLUMN_U_H_D_DECISIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(handled);

				qPos.add(decisionId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByU_H_D_First(long userId, boolean handled,
		long decisionId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_H_D_First(userId, handled,
				decisionId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(", decisionId=");
		msg.append(decisionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByU_H_D_First(long userId, boolean handled,
		long decisionId, OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByU_H_D(userId, handled, decisionId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByU_H_D_Last(long userId, boolean handled,
		long decisionId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_H_D_Last(userId, handled,
				decisionId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(", decisionId=");
		msg.append(decisionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByU_H_D_Last(long userId, boolean handled,
		long decisionId, OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByU_H_D(userId, handled, decisionId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByU_H_D(userId, handled, decisionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 */
	@Override
	public void removeByU_H_D(long userId, boolean handled, long decisionId) {
		for (DecisionEntry decisionEntry : findByU_H_D(userId, handled,
				decisionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionId the decision ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByU_H_D(long userId, boolean handled, long decisionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_H_D;

		Object[] finderArgs = new Object[] { userId, handled, decisionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_H_D_USERID_2);

			query.append(_FINDER_COLUMN_U_H_D_HANDLED_2);

			query.append(_FINDER_COLUMN_U_H_D_DECISIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(handled);

				qPos.add(decisionId);

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

	private static final String _FINDER_COLUMN_U_H_D_USERID_2 = "decisionEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_H_D_HANDLED_2 = "decisionEntry.handled = ? AND ";
	private static final String _FINDER_COLUMN_U_H_D_DECISIONID_2 = "decisionEntry.decisionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOTH = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_NotH",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOTH = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_NotH",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the decision entries where companyId = &#63; and handled &ne; &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByC_NotH(long companyId, boolean handled) {
		return findByC_NotH(companyId, handled, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries where companyId = &#63; and handled &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByC_NotH(long companyId, boolean handled,
		int start, int end) {
		return findByC_NotH(companyId, handled, start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries where companyId = &#63; and handled &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByC_NotH(long companyId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByC_NotH(companyId, handled, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the decision entries where companyId = &#63; and handled &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByC_NotH(long companyId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_NOTH;
		finderArgs = new Object[] {
				companyId, handled,
				
				start, end, orderByComparator
			};

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((companyId != decisionEntry.getCompanyId()) ||
							(handled == decisionEntry.getHandled())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_NOTH_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_NOTH_HANDLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(handled);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByC_NotH_First(long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByC_NotH_First(companyId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByC_NotH_First(long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByC_NotH(companyId, handled, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByC_NotH_Last(long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByC_NotH_Last(companyId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByC_NotH_Last(long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByC_NotH(companyId, handled);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByC_NotH(companyId, handled, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	 *
	 * @param decisionId the primary key of the current decision entry
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry[] findByC_NotH_PrevAndNext(long decisionId,
		long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByC_NotH_PrevAndNext(session, decisionEntry,
					companyId, handled, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByC_NotH_PrevAndNext(session, decisionEntry,
					companyId, handled, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByC_NotH_PrevAndNext(Session session,
		DecisionEntry decisionEntry, long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_C_NOTH_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_NOTH_HANDLED_2);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(handled);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where companyId = &#63; and handled &ne; &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 */
	@Override
	public void removeByC_NotH(long companyId, boolean handled) {
		for (DecisionEntry decisionEntry : findByC_NotH(companyId, handled,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where companyId = &#63; and handled &ne; &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByC_NotH(long companyId, boolean handled) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_NOTH;

		Object[] finderArgs = new Object[] { companyId, handled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_NOTH_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_NOTH_HANDLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(handled);

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

	private static final String _FINDER_COLUMN_C_NOTH_COMPANYID_2 = "decisionEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_NOTH_HANDLED_2 = "decisionEntry.handled != ?";

	public DecisionEntryPersistenceImpl() {
		setModelClass(DecisionEntry.class);
	}

	/**
	 * Caches the decision entry in the entity cache if it is enabled.
	 *
	 * @param decisionEntry the decision entry
	 */
	@Override
	public void cacheResult(DecisionEntry decisionEntry) {
		entityCache.putResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryImpl.class, decisionEntry.getPrimaryKey(),
			decisionEntry);

		decisionEntry.resetOriginalValues();
	}

	/**
	 * Caches the decision entries in the entity cache if it is enabled.
	 *
	 * @param decisionEntries the decision entries
	 */
	@Override
	public void cacheResult(List<DecisionEntry> decisionEntries) {
		for (DecisionEntry decisionEntry : decisionEntries) {
			if (entityCache.getResult(
						DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
						DecisionEntryImpl.class, decisionEntry.getPrimaryKey()) == null) {
				cacheResult(decisionEntry);
			}
			else {
				decisionEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all decision entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DecisionEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the decision entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DecisionEntry decisionEntry) {
		entityCache.removeResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryImpl.class, decisionEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DecisionEntry> decisionEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DecisionEntry decisionEntry : decisionEntries) {
			entityCache.removeResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
				DecisionEntryImpl.class, decisionEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new decision entry with the primary key. Does not add the decision entry to the database.
	 *
	 * @param decisionId the primary key for the new decision entry
	 * @return the new decision entry
	 */
	@Override
	public DecisionEntry create(long decisionId) {
		DecisionEntry decisionEntry = new DecisionEntryImpl();

		decisionEntry.setNew(true);
		decisionEntry.setPrimaryKey(decisionId);

		String uuid = PortalUUIDUtil.generate();

		decisionEntry.setUuid(uuid);

		decisionEntry.setCompanyId(companyProvider.getCompanyId());

		return decisionEntry;
	}

	/**
	 * Removes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param decisionId the primary key of the decision entry
	 * @return the decision entry that was removed
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry remove(long decisionId) throws NoSuchEntryException {
		return remove((Serializable)decisionId);
	}

	/**
	 * Removes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the decision entry
	 * @return the decision entry that was removed
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry remove(Serializable primaryKey)
		throws NoSuchEntryException {
		Session session = null;

		try {
			session = openSession();

			DecisionEntry decisionEntry = (DecisionEntry)session.get(DecisionEntryImpl.class,
					primaryKey);

			if (decisionEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(decisionEntry);
		}
		catch (NoSuchEntryException nsee) {
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
	protected DecisionEntry removeImpl(DecisionEntry decisionEntry) {
		decisionEntry = toUnwrappedModel(decisionEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(decisionEntry)) {
				decisionEntry = (DecisionEntry)session.get(DecisionEntryImpl.class,
						decisionEntry.getPrimaryKeyObj());
			}

			if (decisionEntry != null) {
				session.delete(decisionEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (decisionEntry != null) {
			clearCache(decisionEntry);
		}

		return decisionEntry;
	}

	@Override
	public DecisionEntry updateImpl(DecisionEntry decisionEntry) {
		decisionEntry = toUnwrappedModel(decisionEntry);

		boolean isNew = decisionEntry.isNew();

		DecisionEntryModelImpl decisionEntryModelImpl = (DecisionEntryModelImpl)decisionEntry;

		if (Validator.isNull(decisionEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			decisionEntry.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (decisionEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				decisionEntry.setCreateDate(now);
			}
			else {
				decisionEntry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!decisionEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				decisionEntry.setModifiedDate(now);
			}
			else {
				decisionEntry.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (decisionEntry.isNew()) {
				session.save(decisionEntry);

				decisionEntry.setNew(false);
			}
			else {
				decisionEntry = (DecisionEntry)session.merge(decisionEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DecisionEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { decisionEntryModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalUuid(),
						decisionEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getUuid(),
						decisionEntryModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DECISIONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONID,
					args);

				args = new Object[] { decisionEntryModelImpl.getDecisionId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DECISIONID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONID,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { decisionEntryModelImpl.getCompanyId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionId(),
						decisionEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionId(),
						decisionEntryModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionId(),
						decisionEntryModelImpl.getOriginalAnalysisId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionId(),
						decisionEntryModelImpl.getAnalysisId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionId(),
						decisionEntryModelImpl.getOriginalHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionId(),
						decisionEntryModelImpl.getHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A_H.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionId(),
						decisionEntryModelImpl.getOriginalAnalysisId(),
						decisionEntryModelImpl.getOriginalHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_A_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A_H,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionId(),
						decisionEntryModelImpl.getAnalysisId(),
						decisionEntryModelImpl.getHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_A_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_A_H,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionId(),
						decisionEntryModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionId(),
						decisionEntryModelImpl.getUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionId(),
						decisionEntryModelImpl.getOriginalUserId(),
						decisionEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_U_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionId(),
						decisionEntryModelImpl.getUserId(),
						decisionEntryModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_U_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalCompanyId(),
						decisionEntryModelImpl.getOriginalAnalysisId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getCompanyId(),
						decisionEntryModelImpl.getAnalysisId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_A,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalUserId(),
						decisionEntryModelImpl.getOriginalAnalysisId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getUserId(),
						decisionEntryModelImpl.getAnalysisId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_A,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalUserId(),
						decisionEntryModelImpl.getOriginalHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getUserId(),
						decisionEntryModelImpl.getHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalUserId(),
						decisionEntryModelImpl.getOriginalHandled(),
						decisionEntryModelImpl.getOriginalDecisionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H_D, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getUserId(),
						decisionEntryModelImpl.getHandled(),
						decisionEntryModelImpl.getDecisionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H_D, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D,
					args);
			}
		}

		entityCache.putResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryImpl.class, decisionEntry.getPrimaryKey(),
			decisionEntry, false);

		decisionEntry.resetOriginalValues();

		return decisionEntry;
	}

	protected DecisionEntry toUnwrappedModel(DecisionEntry decisionEntry) {
		if (decisionEntry instanceof DecisionEntryImpl) {
			return decisionEntry;
		}

		DecisionEntryImpl decisionEntryImpl = new DecisionEntryImpl();

		decisionEntryImpl.setNew(decisionEntry.isNew());
		decisionEntryImpl.setPrimaryKey(decisionEntry.getPrimaryKey());

		decisionEntryImpl.setUuid(decisionEntry.getUuid());
		decisionEntryImpl.setDecisionId(decisionEntry.getDecisionId());
		decisionEntryImpl.setCompanyId(decisionEntry.getCompanyId());
		decisionEntryImpl.setUserId(decisionEntry.getUserId());
		decisionEntryImpl.setUserName(decisionEntry.getUserName());
		decisionEntryImpl.setCreateDate(decisionEntry.getCreateDate());
		decisionEntryImpl.setModifiedDate(decisionEntry.getModifiedDate());
		decisionEntryImpl.setAnalysisId(decisionEntry.getAnalysisId());
		decisionEntryImpl.setOutcome(decisionEntry.getOutcome());
		decisionEntryImpl.setHandled(decisionEntry.isHandled());

		return decisionEntryImpl;
	}

	/**
	 * Returns the decision entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the decision entry
	 * @return the decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByPrimaryKey(primaryKey);

		if (decisionEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return decisionEntry;
	}

	/**
	 * Returns the decision entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	 *
	 * @param decisionId the primary key of the decision entry
	 * @return the decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry findByPrimaryKey(long decisionId)
		throws NoSuchEntryException {
		return findByPrimaryKey((Serializable)decisionId);
	}

	/**
	 * Returns the decision entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the decision entry
	 * @return the decision entry, or <code>null</code> if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
				DecisionEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DecisionEntry decisionEntry = (DecisionEntry)serializable;

		if (decisionEntry == null) {
			Session session = null;

			try {
				session = openSession();

				decisionEntry = (DecisionEntry)session.get(DecisionEntryImpl.class,
						primaryKey);

				if (decisionEntry != null) {
					cacheResult(decisionEntry);
				}
				else {
					entityCache.putResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
						DecisionEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
					DecisionEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return decisionEntry;
	}

	/**
	 * Returns the decision entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param decisionId the primary key of the decision entry
	 * @return the decision entry, or <code>null</code> if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry fetchByPrimaryKey(long decisionId) {
		return fetchByPrimaryKey((Serializable)decisionId);
	}

	@Override
	public Map<Serializable, DecisionEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DecisionEntry> map = new HashMap<Serializable, DecisionEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DecisionEntry decisionEntry = fetchByPrimaryKey(primaryKey);

			if (decisionEntry != null) {
				map.put(primaryKey, decisionEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
					DecisionEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DecisionEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (DecisionEntry decisionEntry : (List<DecisionEntry>)q.list()) {
				map.put(decisionEntry.getPrimaryKeyObj(), decisionEntry);

				cacheResult(decisionEntry);

				uncachedPrimaryKeys.remove(decisionEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
					DecisionEntryImpl.class, primaryKey, nullModel);
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
	 * Returns all the decision entries.
	 *
	 * @return the decision entries
	 */
	@Override
	public List<DecisionEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the decision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @return the range of decision entries
	 */
	@Override
	public List<DecisionEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the decision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of decision entries
	 */
	@Override
	public List<DecisionEntry> findAll(int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the decision entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of decision entries
	 * @param end the upper bound of the range of decision entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of decision entries
	 */
	@Override
	public List<DecisionEntry> findAll(int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
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

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DECISIONENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DECISIONENTRY;

				if (pagination) {
					sql = sql.concat(DecisionEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the decision entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DecisionEntry decisionEntry : findAll()) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries.
	 *
	 * @return the number of decision entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DECISIONENTRY);

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
		return DecisionEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the decision entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DecisionEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_DECISIONENTRY = "SELECT decisionEntry FROM DecisionEntry decisionEntry";
	private static final String _SQL_SELECT_DECISIONENTRY_WHERE_PKS_IN = "SELECT decisionEntry FROM DecisionEntry decisionEntry WHERE decisionId IN (";
	private static final String _SQL_SELECT_DECISIONENTRY_WHERE = "SELECT decisionEntry FROM DecisionEntry decisionEntry WHERE ";
	private static final String _SQL_COUNT_DECISIONENTRY = "SELECT COUNT(decisionEntry) FROM DecisionEntry decisionEntry";
	private static final String _SQL_COUNT_DECISIONENTRY_WHERE = "SELECT COUNT(decisionEntry) FROM DecisionEntry decisionEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "decisionEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DecisionEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DecisionEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DecisionEntryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}
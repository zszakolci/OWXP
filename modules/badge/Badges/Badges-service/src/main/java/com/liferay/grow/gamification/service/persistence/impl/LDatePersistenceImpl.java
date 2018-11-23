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

import com.liferay.grow.gamification.exception.NoSuchLDateException;
import com.liferay.grow.gamification.model.LDate;
import com.liferay.grow.gamification.model.impl.LDateImpl;
import com.liferay.grow.gamification.model.impl.LDateModelImpl;
import com.liferay.grow.gamification.service.persistence.LDatePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the l date service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see LDatePersistence
 * @see com.liferay.grow.gamification.service.persistence.LDateUtil
 * @generated
 */
@ProviderType
public class LDatePersistenceImpl extends BasePersistenceImpl<LDate>
	implements LDatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LDateUtil} to access the l date persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LDateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LDateModelImpl.ENTITY_CACHE_ENABLED,
			LDateModelImpl.FINDER_CACHE_ENABLED, LDateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LDateModelImpl.ENTITY_CACHE_ENABLED,
			LDateModelImpl.FINDER_CACHE_ENABLED, LDateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LDateModelImpl.ENTITY_CACHE_ENABLED,
			LDateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_Y_M_D = new FinderPath(LDateModelImpl.ENTITY_CACHE_ENABLED,
			LDateModelImpl.FINDER_CACHE_ENABLED, LDateImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByY_M_D",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			LDateModelImpl.YEAR_COLUMN_BITMASK |
			LDateModelImpl.MONTH_COLUMN_BITMASK |
			LDateModelImpl.DAY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_Y_M_D = new FinderPath(LDateModelImpl.ENTITY_CACHE_ENABLED,
			LDateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByY_M_D",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the l date where year = &#63; and month = &#63; and day = &#63; or throws a {@link NoSuchLDateException} if it could not be found.
	 *
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @return the matching l date
	 * @throws NoSuchLDateException if a matching l date could not be found
	 */
	@Override
	public LDate findByY_M_D(int year, int month, int day)
		throws NoSuchLDateException {
		LDate lDate = fetchByY_M_D(year, month, day);

		if (lDate == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("year=");
			msg.append(year);

			msg.append(", month=");
			msg.append(month);

			msg.append(", day=");
			msg.append(day);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLDateException(msg.toString());
		}

		return lDate;
	}

	/**
	 * Returns the l date where year = &#63; and month = &#63; and day = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @return the matching l date, or <code>null</code> if a matching l date could not be found
	 */
	@Override
	public LDate fetchByY_M_D(int year, int month, int day) {
		return fetchByY_M_D(year, month, day, true);
	}

	/**
	 * Returns the l date where year = &#63; and month = &#63; and day = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching l date, or <code>null</code> if a matching l date could not be found
	 */
	@Override
	public LDate fetchByY_M_D(int year, int month, int day,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { year, month, day };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_Y_M_D,
					finderArgs, this);
		}

		if (result instanceof LDate) {
			LDate lDate = (LDate)result;

			if ((year != lDate.getYear()) || (month != lDate.getMonth()) ||
					(day != lDate.getDay())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_LDATE_WHERE);

			query.append(_FINDER_COLUMN_Y_M_D_YEAR_2);

			query.append(_FINDER_COLUMN_Y_M_D_MONTH_2);

			query.append(_FINDER_COLUMN_Y_M_D_DAY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				qPos.add(month);

				qPos.add(day);

				List<LDate> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_Y_M_D,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LDatePersistenceImpl.fetchByY_M_D(int, int, int, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LDate lDate = list.get(0);

					result = lDate;

					cacheResult(lDate);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_Y_M_D, finderArgs);

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
			return (LDate)result;
		}
	}

	/**
	 * Removes the l date where year = &#63; and month = &#63; and day = &#63; from the database.
	 *
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @return the l date that was removed
	 */
	@Override
	public LDate removeByY_M_D(int year, int month, int day)
		throws NoSuchLDateException {
		LDate lDate = findByY_M_D(year, month, day);

		return remove(lDate);
	}

	/**
	 * Returns the number of l dates where year = &#63; and month = &#63; and day = &#63;.
	 *
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 * @return the number of matching l dates
	 */
	@Override
	public int countByY_M_D(int year, int month, int day) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_Y_M_D;

		Object[] finderArgs = new Object[] { year, month, day };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LDATE_WHERE);

			query.append(_FINDER_COLUMN_Y_M_D_YEAR_2);

			query.append(_FINDER_COLUMN_Y_M_D_MONTH_2);

			query.append(_FINDER_COLUMN_Y_M_D_DAY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				qPos.add(month);

				qPos.add(day);

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

	private static final String _FINDER_COLUMN_Y_M_D_YEAR_2 = "lDate.year = ? AND ";
	private static final String _FINDER_COLUMN_Y_M_D_MONTH_2 = "lDate.month = ? AND ";
	private static final String _FINDER_COLUMN_Y_M_D_DAY_2 = "lDate.day = ?";

	public LDatePersistenceImpl() {
		setModelClass(LDate.class);
	}

	/**
	 * Caches the l date in the entity cache if it is enabled.
	 *
	 * @param lDate the l date
	 */
	@Override
	public void cacheResult(LDate lDate) {
		entityCache.putResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
			LDateImpl.class, lDate.getPrimaryKey(), lDate);

		finderCache.putResult(FINDER_PATH_FETCH_BY_Y_M_D,
			new Object[] { lDate.getYear(), lDate.getMonth(), lDate.getDay() },
			lDate);

		lDate.resetOriginalValues();
	}

	/**
	 * Caches the l dates in the entity cache if it is enabled.
	 *
	 * @param lDates the l dates
	 */
	@Override
	public void cacheResult(List<LDate> lDates) {
		for (LDate lDate : lDates) {
			if (entityCache.getResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
						LDateImpl.class, lDate.getPrimaryKey()) == null) {
				cacheResult(lDate);
			}
			else {
				lDate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l dates.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LDateImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l date.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LDate lDate) {
		entityCache.removeResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
			LDateImpl.class, lDate.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LDateModelImpl)lDate, true);
	}

	@Override
	public void clearCache(List<LDate> lDates) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LDate lDate : lDates) {
			entityCache.removeResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
				LDateImpl.class, lDate.getPrimaryKey());

			clearUniqueFindersCache((LDateModelImpl)lDate, true);
		}
	}

	protected void cacheUniqueFindersCache(LDateModelImpl lDateModelImpl) {
		Object[] args = new Object[] {
				lDateModelImpl.getYear(), lDateModelImpl.getMonth(),
				lDateModelImpl.getDay()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_Y_M_D, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_Y_M_D, args, lDateModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(LDateModelImpl lDateModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					lDateModelImpl.getYear(), lDateModelImpl.getMonth(),
					lDateModelImpl.getDay()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_Y_M_D, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_Y_M_D, args);
		}

		if ((lDateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_Y_M_D.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					lDateModelImpl.getOriginalYear(),
					lDateModelImpl.getOriginalMonth(),
					lDateModelImpl.getOriginalDay()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_Y_M_D, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_Y_M_D, args);
		}
	}

	/**
	 * Creates a new l date with the primary key. Does not add the l date to the database.
	 *
	 * @param dateId the primary key for the new l date
	 * @return the new l date
	 */
	@Override
	public LDate create(long dateId) {
		LDate lDate = new LDateImpl();

		lDate.setNew(true);
		lDate.setPrimaryKey(dateId);

		return lDate;
	}

	/**
	 * Removes the l date with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dateId the primary key of the l date
	 * @return the l date that was removed
	 * @throws NoSuchLDateException if a l date with the primary key could not be found
	 */
	@Override
	public LDate remove(long dateId) throws NoSuchLDateException {
		return remove((Serializable)dateId);
	}

	/**
	 * Removes the l date with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l date
	 * @return the l date that was removed
	 * @throws NoSuchLDateException if a l date with the primary key could not be found
	 */
	@Override
	public LDate remove(Serializable primaryKey) throws NoSuchLDateException {
		Session session = null;

		try {
			session = openSession();

			LDate lDate = (LDate)session.get(LDateImpl.class, primaryKey);

			if (lDate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLDateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lDate);
		}
		catch (NoSuchLDateException nsee) {
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
	protected LDate removeImpl(LDate lDate) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lDate)) {
				lDate = (LDate)session.get(LDateImpl.class,
						lDate.getPrimaryKeyObj());
			}

			if (lDate != null) {
				session.delete(lDate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lDate != null) {
			clearCache(lDate);
		}

		return lDate;
	}

	@Override
	public LDate updateImpl(LDate lDate) {
		boolean isNew = lDate.isNew();

		if (!(lDate instanceof LDateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lDate.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(lDate);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lDate proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LDate implementation " +
				lDate.getClass());
		}

		LDateModelImpl lDateModelImpl = (LDateModelImpl)lDate;

		Session session = null;

		try {
			session = openSession();

			if (lDate.isNew()) {
				session.save(lDate);

				lDate.setNew(false);
			}
			else {
				lDate = (LDate)session.merge(lDate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LDateModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
			LDateImpl.class, lDate.getPrimaryKey(), lDate, false);

		clearUniqueFindersCache(lDateModelImpl, false);
		cacheUniqueFindersCache(lDateModelImpl);

		lDate.resetOriginalValues();

		return lDate;
	}

	/**
	 * Returns the l date with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l date
	 * @return the l date
	 * @throws NoSuchLDateException if a l date with the primary key could not be found
	 */
	@Override
	public LDate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLDateException {
		LDate lDate = fetchByPrimaryKey(primaryKey);

		if (lDate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLDateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lDate;
	}

	/**
	 * Returns the l date with the primary key or throws a {@link NoSuchLDateException} if it could not be found.
	 *
	 * @param dateId the primary key of the l date
	 * @return the l date
	 * @throws NoSuchLDateException if a l date with the primary key could not be found
	 */
	@Override
	public LDate findByPrimaryKey(long dateId) throws NoSuchLDateException {
		return findByPrimaryKey((Serializable)dateId);
	}

	/**
	 * Returns the l date with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l date
	 * @return the l date, or <code>null</code> if a l date with the primary key could not be found
	 */
	@Override
	public LDate fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
				LDateImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LDate lDate = (LDate)serializable;

		if (lDate == null) {
			Session session = null;

			try {
				session = openSession();

				lDate = (LDate)session.get(LDateImpl.class, primaryKey);

				if (lDate != null) {
					cacheResult(lDate);
				}
				else {
					entityCache.putResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
						LDateImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
					LDateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lDate;
	}

	/**
	 * Returns the l date with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dateId the primary key of the l date
	 * @return the l date, or <code>null</code> if a l date with the primary key could not be found
	 */
	@Override
	public LDate fetchByPrimaryKey(long dateId) {
		return fetchByPrimaryKey((Serializable)dateId);
	}

	@Override
	public Map<Serializable, LDate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LDate> map = new HashMap<Serializable, LDate>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LDate lDate = fetchByPrimaryKey(primaryKey);

			if (lDate != null) {
				map.put(primaryKey, lDate);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
					LDateImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LDate)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LDATE_WHERE_PKS_IN);

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

			for (LDate lDate : (List<LDate>)q.list()) {
				map.put(lDate.getPrimaryKeyObj(), lDate);

				cacheResult(lDate);

				uncachedPrimaryKeys.remove(lDate.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LDateModelImpl.ENTITY_CACHE_ENABLED,
					LDateImpl.class, primaryKey, nullModel);
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
	 * Returns all the l dates.
	 *
	 * @return the l dates
	 */
	@Override
	public List<LDate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LDateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l dates
	 * @param end the upper bound of the range of l dates (not inclusive)
	 * @return the range of l dates
	 */
	@Override
	public List<LDate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LDateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l dates
	 * @param end the upper bound of the range of l dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l dates
	 */
	@Override
	public List<LDate> findAll(int start, int end,
		OrderByComparator<LDate> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the l dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LDateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l dates
	 * @param end the upper bound of the range of l dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of l dates
	 */
	@Override
	public List<LDate> findAll(int start, int end,
		OrderByComparator<LDate> orderByComparator, boolean retrieveFromCache) {
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

		List<LDate> list = null;

		if (retrieveFromCache) {
			list = (List<LDate>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LDATE;

				if (pagination) {
					sql = sql.concat(LDateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LDate>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LDate>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the l dates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LDate lDate : findAll()) {
			remove(lDate);
		}
	}

	/**
	 * Returns the number of l dates.
	 *
	 * @return the number of l dates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LDATE);

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
		return LDateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the l date persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LDateImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LDATE = "SELECT lDate FROM LDate lDate";
	private static final String _SQL_SELECT_LDATE_WHERE_PKS_IN = "SELECT lDate FROM LDate lDate WHERE dateId IN (";
	private static final String _SQL_SELECT_LDATE_WHERE = "SELECT lDate FROM LDate lDate WHERE ";
	private static final String _SQL_COUNT_LDATE = "SELECT COUNT(lDate) FROM LDate lDate";
	private static final String _SQL_COUNT_LDATE_WHERE = "SELECT COUNT(lDate) FROM LDate lDate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lDate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LDate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LDate exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LDatePersistenceImpl.class);
}
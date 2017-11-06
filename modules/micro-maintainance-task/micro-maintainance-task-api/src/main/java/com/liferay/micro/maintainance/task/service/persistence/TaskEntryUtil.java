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

package com.liferay.micro.maintainance.task.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.task.model.TaskEntry;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the task entry service. This utility wraps {@link com.liferay.micro.maintainance.task.service.persistence.impl.TaskEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntryPersistence
 * @see com.liferay.micro.maintainance.task.service.persistence.impl.TaskEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class TaskEntryUtil {
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
	public static void clearCache(TaskEntry taskEntry) {
		getPersistence().clearCache(taskEntry);
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
	public static List<TaskEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaskEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaskEntry update(TaskEntry taskEntry) {
		return getPersistence().update(taskEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaskEntry update(TaskEntry taskEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(taskEntry, serviceContext);
	}

	/**
	* Returns all the task entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching task entries
	*/
	public static List<TaskEntry> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the task entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @return the range of matching task entries
	*/
	public static List<TaskEntry> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the task entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching task entries
	*/
	public static List<TaskEntry> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<TaskEntry> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the task entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching task entries
	*/
	public static List<TaskEntry> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<TaskEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first task entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public static TaskEntry findByUuid_First(java.lang.String uuid,
		OrderByComparator<TaskEntry> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first task entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<TaskEntry> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last task entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public static TaskEntry findByUuid_Last(java.lang.String uuid,
		OrderByComparator<TaskEntry> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last task entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<TaskEntry> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the task entries before and after the current task entry in the ordered set where uuid = &#63;.
	*
	* @param taskEntryId the primary key of the current task entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next task entry
	* @throws NoSuchEntryException if a task entry with the primary key could not be found
	*/
	public static TaskEntry[] findByUuid_PrevAndNext(long taskEntryId,
		java.lang.String uuid, OrderByComparator<TaskEntry> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(taskEntryId, uuid, orderByComparator);
	}

	/**
	* Removes all the task entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of task entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching task entries
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the task entry where taskEntryId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param taskEntryId the task entry ID
	* @return the matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public static TaskEntry findByTasksById(long taskEntryId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().findByTasksById(taskEntryId);
	}

	/**
	* Returns the task entry where taskEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taskEntryId the task entry ID
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByTasksById(long taskEntryId) {
		return getPersistence().fetchByTasksById(taskEntryId);
	}

	/**
	* Returns the task entry where taskEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taskEntryId the task entry ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByTasksById(long taskEntryId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByTasksById(taskEntryId, retrieveFromCache);
	}

	/**
	* Removes the task entry where taskEntryId = &#63; from the database.
	*
	* @param taskEntryId the task entry ID
	* @return the task entry that was removed
	*/
	public static TaskEntry removeByTasksById(long taskEntryId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().removeByTasksById(taskEntryId);
	}

	/**
	* Returns the number of task entries where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @return the number of matching task entries
	*/
	public static int countByTasksById(long taskEntryId) {
		return getPersistence().countByTasksById(taskEntryId);
	}

	/**
	* Returns the task entry where taskEntryName = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param taskEntryName the task entry name
	* @return the matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public static TaskEntry findByTasksByName(java.lang.String taskEntryName)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().findByTasksByName(taskEntryName);
	}

	/**
	* Returns the task entry where taskEntryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taskEntryName the task entry name
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByTasksByName(java.lang.String taskEntryName) {
		return getPersistence().fetchByTasksByName(taskEntryName);
	}

	/**
	* Returns the task entry where taskEntryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taskEntryName the task entry name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByTasksByName(java.lang.String taskEntryName,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTasksByName(taskEntryName, retrieveFromCache);
	}

	/**
	* Removes the task entry where taskEntryName = &#63; from the database.
	*
	* @param taskEntryName the task entry name
	* @return the task entry that was removed
	*/
	public static TaskEntry removeByTasksByName(java.lang.String taskEntryName)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().removeByTasksByName(taskEntryName);
	}

	/**
	* Returns the number of task entries where taskEntryName = &#63;.
	*
	* @param taskEntryName the task entry name
	* @return the number of matching task entries
	*/
	public static int countByTasksByName(java.lang.String taskEntryName) {
		return getPersistence().countByTasksByName(taskEntryName);
	}

	/**
	* Caches the task entry in the entity cache if it is enabled.
	*
	* @param taskEntry the task entry
	*/
	public static void cacheResult(TaskEntry taskEntry) {
		getPersistence().cacheResult(taskEntry);
	}

	/**
	* Caches the task entries in the entity cache if it is enabled.
	*
	* @param taskEntries the task entries
	*/
	public static void cacheResult(List<TaskEntry> taskEntries) {
		getPersistence().cacheResult(taskEntries);
	}

	/**
	* Creates a new task entry with the primary key. Does not add the task entry to the database.
	*
	* @param taskEntryId the primary key for the new task entry
	* @return the new task entry
	*/
	public static TaskEntry create(long taskEntryId) {
		return getPersistence().create(taskEntryId);
	}

	/**
	* Removes the task entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskEntryId the primary key of the task entry
	* @return the task entry that was removed
	* @throws NoSuchEntryException if a task entry with the primary key could not be found
	*/
	public static TaskEntry remove(long taskEntryId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().remove(taskEntryId);
	}

	public static TaskEntry updateImpl(TaskEntry taskEntry) {
		return getPersistence().updateImpl(taskEntry);
	}

	/**
	* Returns the task entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param taskEntryId the primary key of the task entry
	* @return the task entry
	* @throws NoSuchEntryException if a task entry with the primary key could not be found
	*/
	public static TaskEntry findByPrimaryKey(long taskEntryId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(taskEntryId);
	}

	/**
	* Returns the task entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskEntryId the primary key of the task entry
	* @return the task entry, or <code>null</code> if a task entry with the primary key could not be found
	*/
	public static TaskEntry fetchByPrimaryKey(long taskEntryId) {
		return getPersistence().fetchByPrimaryKey(taskEntryId);
	}

	public static java.util.Map<java.io.Serializable, TaskEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the task entries.
	*
	* @return the task entries
	*/
	public static List<TaskEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the task entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @return the range of task entries
	*/
	public static List<TaskEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the task entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of task entries
	*/
	public static List<TaskEntry> findAll(int start, int end,
		OrderByComparator<TaskEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the task entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of task entries
	*/
	public static List<TaskEntry> findAll(int start, int end,
		OrderByComparator<TaskEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the task entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of task entries.
	*
	* @return the number of task entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TaskEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskEntryPersistence, TaskEntryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TaskEntryPersistence.class);
}
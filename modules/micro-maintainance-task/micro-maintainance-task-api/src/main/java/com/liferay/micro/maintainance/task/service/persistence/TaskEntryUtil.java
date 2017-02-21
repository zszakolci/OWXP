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
	* @param taskId the primary key of the current task entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next task entry
	* @throws NoSuchEntryException if a task entry with the primary key could not be found
	*/
	public static TaskEntry[] findByUuid_PrevAndNext(long taskId,
		java.lang.String uuid, OrderByComparator<TaskEntry> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(taskId, uuid, orderByComparator);
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
	* Returns the task entry where taskId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param taskId the task ID
	* @return the matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public static TaskEntry findByTasksById(long taskId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().findByTasksById(taskId);
	}

	/**
	* Returns the task entry where taskId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taskId the task ID
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByTasksById(long taskId) {
		return getPersistence().fetchByTasksById(taskId);
	}

	/**
	* Returns the task entry where taskId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taskId the task ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByTasksById(long taskId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByTasksById(taskId, retrieveFromCache);
	}

	/**
	* Removes the task entry where taskId = &#63; from the database.
	*
	* @param taskId the task ID
	* @return the task entry that was removed
	*/
	public static TaskEntry removeByTasksById(long taskId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().removeByTasksById(taskId);
	}

	/**
	* Returns the number of task entries where taskId = &#63;.
	*
	* @param taskId the task ID
	* @return the number of matching task entries
	*/
	public static int countByTasksById(long taskId) {
		return getPersistence().countByTasksById(taskId);
	}

	/**
	* Returns the task entry where taskName = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param taskName the task name
	* @return the matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public static TaskEntry findByTasksByName(java.lang.String taskName)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().findByTasksByName(taskName);
	}

	/**
	* Returns the task entry where taskName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taskName the task name
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByTasksByName(java.lang.String taskName) {
		return getPersistence().fetchByTasksByName(taskName);
	}

	/**
	* Returns the task entry where taskName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taskName the task name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public static TaskEntry fetchByTasksByName(java.lang.String taskName,
		boolean retrieveFromCache) {
		return getPersistence().fetchByTasksByName(taskName, retrieveFromCache);
	}

	/**
	* Removes the task entry where taskName = &#63; from the database.
	*
	* @param taskName the task name
	* @return the task entry that was removed
	*/
	public static TaskEntry removeByTasksByName(java.lang.String taskName)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().removeByTasksByName(taskName);
	}

	/**
	* Returns the number of task entries where taskName = &#63;.
	*
	* @param taskName the task name
	* @return the number of matching task entries
	*/
	public static int countByTasksByName(java.lang.String taskName) {
		return getPersistence().countByTasksByName(taskName);
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
	* @param taskId the primary key for the new task entry
	* @return the new task entry
	*/
	public static TaskEntry create(long taskId) {
		return getPersistence().create(taskId);
	}

	/**
	* Removes the task entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the task entry
	* @return the task entry that was removed
	* @throws NoSuchEntryException if a task entry with the primary key could not be found
	*/
	public static TaskEntry remove(long taskId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().remove(taskId);
	}

	public static TaskEntry updateImpl(TaskEntry taskEntry) {
		return getPersistence().updateImpl(taskEntry);
	}

	/**
	* Returns the task entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param taskId the primary key of the task entry
	* @return the task entry
	* @throws NoSuchEntryException if a task entry with the primary key could not be found
	*/
	public static TaskEntry findByPrimaryKey(long taskId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(taskId);
	}

	/**
	* Returns the task entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the task entry
	* @return the task entry, or <code>null</code> if a task entry with the primary key could not be found
	*/
	public static TaskEntry fetchByPrimaryKey(long taskId) {
		return getPersistence().fetchByPrimaryKey(taskId);
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
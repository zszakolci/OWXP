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

package com.liferay.micro.maintainance.task.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TaskEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntry
 * @generated
 */
@ProviderType
public class TaskEntryWrapper implements TaskEntry, ModelWrapper<TaskEntry> {
	public TaskEntryWrapper(TaskEntry taskEntry) {
		_taskEntry = taskEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return TaskEntry.class;
	}

	@Override
	public String getModelClassName() {
		return TaskEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("taskId", getTaskId());
		attributes.put("createDate", getCreateDate());
		attributes.put("taskName", getTaskName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String taskName = (String)attributes.get("taskName");

		if (taskName != null) {
			setTaskName(taskName);
		}
	}

	@Override
	public TaskEntry toEscapedModel() {
		return new TaskEntryWrapper(_taskEntry.toEscapedModel());
	}

	@Override
	public TaskEntry toUnescapedModel() {
		return new TaskEntryWrapper(_taskEntry.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _taskEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _taskEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _taskEntry.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _taskEntry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TaskEntry> toCacheModel() {
		return _taskEntry.toCacheModel();
	}

	@Override
	public int compareTo(TaskEntry taskEntry) {
		return _taskEntry.compareTo(taskEntry);
	}

	@Override
	public int hashCode() {
		return _taskEntry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taskEntry.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TaskEntryWrapper((TaskEntry)_taskEntry.clone());
	}

	/**
	* Returns the task name of this task entry.
	*
	* @return the task name of this task entry
	*/
	@Override
	public java.lang.String getTaskName() {
		return _taskEntry.getTaskName();
	}

	/**
	* Returns the uuid of this task entry.
	*
	* @return the uuid of this task entry
	*/
	@Override
	public java.lang.String getUuid() {
		return _taskEntry.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _taskEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _taskEntry.toXmlString();
	}

	/**
	* Returns the create date of this task entry.
	*
	* @return the create date of this task entry
	*/
	@Override
	public Date getCreateDate() {
		return _taskEntry.getCreateDate();
	}

	/**
	* Returns the primary key of this task entry.
	*
	* @return the primary key of this task entry
	*/
	@Override
	public long getPrimaryKey() {
		return _taskEntry.getPrimaryKey();
	}

	/**
	* Returns the task ID of this task entry.
	*
	* @return the task ID of this task entry
	*/
	@Override
	public long getTaskId() {
		return _taskEntry.getTaskId();
	}

	@Override
	public void persist() {
		_taskEntry.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taskEntry.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this task entry.
	*
	* @param createDate the create date of this task entry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_taskEntry.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_taskEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_taskEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_taskEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_taskEntry.setNew(n);
	}

	/**
	* Sets the primary key of this task entry.
	*
	* @param primaryKey the primary key of this task entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taskEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_taskEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the task ID of this task entry.
	*
	* @param taskId the task ID of this task entry
	*/
	@Override
	public void setTaskId(long taskId) {
		_taskEntry.setTaskId(taskId);
	}

	/**
	* Sets the task name of this task entry.
	*
	* @param taskName the task name of this task entry
	*/
	@Override
	public void setTaskName(java.lang.String taskName) {
		_taskEntry.setTaskName(taskName);
	}

	/**
	* Sets the uuid of this task entry.
	*
	* @param uuid the uuid of this task entry
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_taskEntry.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskEntryWrapper)) {
			return false;
		}

		TaskEntryWrapper taskEntryWrapper = (TaskEntryWrapper)obj;

		if (Objects.equals(_taskEntry, taskEntryWrapper._taskEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public TaskEntry getWrappedModel() {
		return _taskEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _taskEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _taskEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_taskEntry.resetOriginalValues();
	}

	private final TaskEntry _taskEntry;
}
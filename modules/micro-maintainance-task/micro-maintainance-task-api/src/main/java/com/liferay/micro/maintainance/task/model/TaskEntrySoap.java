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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.micro.maintainance.task.service.http.TaskEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.task.service.http.TaskEntryServiceSoap
 * @generated
 */
@ProviderType
public class TaskEntrySoap implements Serializable {
	public static TaskEntrySoap toSoapModel(TaskEntry model) {
		TaskEntrySoap soapModel = new TaskEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setTaskName(model.getTaskName());

		return soapModel;
	}

	public static TaskEntrySoap[] toSoapModels(TaskEntry[] models) {
		TaskEntrySoap[] soapModels = new TaskEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskEntrySoap[][] toSoapModels(TaskEntry[][] models) {
		TaskEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskEntrySoap[] toSoapModels(List<TaskEntry> models) {
		List<TaskEntrySoap> soapModels = new ArrayList<TaskEntrySoap>(models.size());

		for (TaskEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskEntrySoap[soapModels.size()]);
	}

	public TaskEntrySoap() {
	}

	public long getPrimaryKey() {
		return _taskId;
	}

	public void setPrimaryKey(long pk) {
		setTaskId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getTaskName() {
		return _taskName;
	}

	public void setTaskName(String taskName) {
		_taskName = taskName;
	}

	private String _uuid;
	private long _taskId;
	private Date _createDate;
	private String _taskName;
}
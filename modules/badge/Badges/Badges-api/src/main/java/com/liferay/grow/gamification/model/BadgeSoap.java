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

package com.liferay.grow.gamification.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.grow.gamification.service.http.BadgeServiceSoap}.
 *
 * @author Vilmos Papp
 * @see com.liferay.grow.gamification.service.http.BadgeServiceSoap
 * @generated
 */
@ProviderType
public class BadgeSoap implements Serializable {
	public static BadgeSoap toSoapModel(Badge model) {
		BadgeSoap soapModel = new BadgeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBadgeId(model.getBadgeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setBadgeTypeId(model.getBadgeTypeId());
		soapModel.setToUserId(model.getToUserId());
		soapModel.setDescription(model.getDescription());
		soapModel.setAssignedDateId(model.getAssignedDateId());

		return soapModel;
	}

	public static BadgeSoap[] toSoapModels(Badge[] models) {
		BadgeSoap[] soapModels = new BadgeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BadgeSoap[][] toSoapModels(Badge[][] models) {
		BadgeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BadgeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BadgeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BadgeSoap[] toSoapModels(List<Badge> models) {
		List<BadgeSoap> soapModels = new ArrayList<BadgeSoap>(models.size());

		for (Badge model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BadgeSoap[soapModels.size()]);
	}

	public BadgeSoap() {
	}

	public long getPrimaryKey() {
		return _badgeId;
	}

	public void setPrimaryKey(long pk) {
		setBadgeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBadgeId() {
		return _badgeId;
	}

	public void setBadgeId(long badgeId) {
		_badgeId = badgeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getBadgeTypeId() {
		return _badgeTypeId;
	}

	public void setBadgeTypeId(long badgeTypeId) {
		_badgeTypeId = badgeTypeId;
	}

	public long getToUserId() {
		return _toUserId;
	}

	public void setToUserId(long toUserId) {
		_toUserId = toUserId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getAssignedDateId() {
		return _assignedDateId;
	}

	public void setAssignedDateId(long assignedDateId) {
		_assignedDateId = assignedDateId;
	}

	private String _uuid;
	private long _badgeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _badgeTypeId;
	private long _toUserId;
	private String _description;
	private long _assignedDateId;
}
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
 * This class is used by SOAP remote services, specifically {@link com.liferay.grow.gamification.service.http.BadgeTypeServiceSoap}.
 *
 * @author Vilmos Papp
 * @see com.liferay.grow.gamification.service.http.BadgeTypeServiceSoap
 * @generated
 */
@ProviderType
public class BadgeTypeSoap implements Serializable {
	public static BadgeTypeSoap toSoapModel(BadgeType model) {
		BadgeTypeSoap soapModel = new BadgeTypeSoap();

		soapModel.setBadgeTypeId(model.getBadgeTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());
		soapModel.setAssignableFrom(model.getAssignableFrom());
		soapModel.setAssignableTo(model.getAssignableTo());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static BadgeTypeSoap[] toSoapModels(BadgeType[] models) {
		BadgeTypeSoap[] soapModels = new BadgeTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BadgeTypeSoap[][] toSoapModels(BadgeType[][] models) {
		BadgeTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BadgeTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BadgeTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BadgeTypeSoap[] toSoapModels(List<BadgeType> models) {
		List<BadgeTypeSoap> soapModels = new ArrayList<BadgeTypeSoap>(models.size());

		for (BadgeType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BadgeTypeSoap[soapModels.size()]);
	}

	public BadgeTypeSoap() {
	}

	public long getPrimaryKey() {
		return _badgeTypeId;
	}

	public void setPrimaryKey(long pk) {
		setBadgeTypeId(pk);
	}

	public long getBadgeTypeId() {
		return _badgeTypeId;
	}

	public void setBadgeTypeId(long badgeTypeId) {
		_badgeTypeId = badgeTypeId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public Date getAssignableFrom() {
		return _assignableFrom;
	}

	public void setAssignableFrom(Date assignableFrom) {
		_assignableFrom = assignableFrom;
	}

	public Date getAssignableTo() {
		return _assignableTo;
	}

	public void setAssignableTo(Date assignableTo) {
		_assignableTo = assignableTo;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	private long _badgeTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _type;
	private Date _assignableFrom;
	private Date _assignableTo;
	private long _fileEntryId;
}
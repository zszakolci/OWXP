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
 * This class is used by SOAP remote services, specifically {@link com.liferay.grow.gamification.service.http.SubscriberServiceSoap}.
 *
 * @author Vilmos Papp
 * @see com.liferay.grow.gamification.service.http.SubscriberServiceSoap
 * @generated
 */
@ProviderType
public class SubscriberSoap implements Serializable {
	public static SubscriberSoap toSoapModel(Subscriber model) {
		SubscriberSoap soapModel = new SubscriberSoap();

		soapModel.setSubscriberId(model.getSubscriberId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSubscriberUserId(model.getSubscriberUserId());
		soapModel.setBadgeType(model.getBadgeType());

		return soapModel;
	}

	public static SubscriberSoap[] toSoapModels(Subscriber[] models) {
		SubscriberSoap[] soapModels = new SubscriberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubscriberSoap[][] toSoapModels(Subscriber[][] models) {
		SubscriberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubscriberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubscriberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubscriberSoap[] toSoapModels(List<Subscriber> models) {
		List<SubscriberSoap> soapModels = new ArrayList<SubscriberSoap>(models.size());

		for (Subscriber model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubscriberSoap[soapModels.size()]);
	}

	public SubscriberSoap() {
	}

	public long getPrimaryKey() {
		return _subscriberId;
	}

	public void setPrimaryKey(long pk) {
		setSubscriberId(pk);
	}

	public long getSubscriberId() {
		return _subscriberId;
	}

	public void setSubscriberId(long subscriberId) {
		_subscriberId = subscriberId;
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

	public long getSubscriberUserId() {
		return _subscriberUserId;
	}

	public void setSubscriberUserId(long subscriberUserId) {
		_subscriberUserId = subscriberUserId;
	}

	public long getBadgeType() {
		return _badgeType;
	}

	public void setBadgeType(long badgeType) {
		_badgeType = badgeType;
	}

	private long _subscriberId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _subscriberUserId;
	private long _badgeType;
}
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

package com.liferay.grow.gamification.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.grow.gamification.model.Subscriber;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subscriber in entity cache.
 *
 * @author Vilmos Papp
 * @see Subscriber
 * @generated
 */
@ProviderType
public class SubscriberCacheModel implements CacheModel<Subscriber>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubscriberCacheModel)) {
			return false;
		}

		SubscriberCacheModel subscriberCacheModel = (SubscriberCacheModel)obj;

		if (subscriberId == subscriberCacheModel.subscriberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subscriberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{subscriberId=");
		sb.append(subscriberId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", subscriberUserId=");
		sb.append(subscriberUserId);
		sb.append(", badgeType=");
		sb.append(badgeType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subscriber toEntityModel() {
		SubscriberImpl subscriberImpl = new SubscriberImpl();

		subscriberImpl.setSubscriberId(subscriberId);
		subscriberImpl.setGroupId(groupId);
		subscriberImpl.setCompanyId(companyId);
		subscriberImpl.setUserId(userId);

		if (userName == null) {
			subscriberImpl.setUserName("");
		}
		else {
			subscriberImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			subscriberImpl.setCreateDate(null);
		}
		else {
			subscriberImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subscriberImpl.setModifiedDate(null);
		}
		else {
			subscriberImpl.setModifiedDate(new Date(modifiedDate));
		}

		subscriberImpl.setSubscriberUserId(subscriberUserId);
		subscriberImpl.setBadgeType(badgeType);

		subscriberImpl.resetOriginalValues();

		return subscriberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		subscriberId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		subscriberUserId = objectInput.readLong();

		badgeType = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(subscriberId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(subscriberUserId);

		objectOutput.writeLong(badgeType);
	}

	public long subscriberId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long subscriberUserId;
	public long badgeType;
}
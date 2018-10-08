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

import com.liferay.grow.gamification.model.BadgeType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BadgeType in entity cache.
 *
 * @author Vilmos Papp
 * @see BadgeType
 * @generated
 */
@ProviderType
public class BadgeTypeCacheModel implements CacheModel<BadgeType>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeTypeCacheModel)) {
			return false;
		}

		BadgeTypeCacheModel badgeTypeCacheModel = (BadgeTypeCacheModel)obj;

		if (badgeTypeId == badgeTypeCacheModel.badgeTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, badgeTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{badgeTypeId=");
		sb.append(badgeTypeId);
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
		sb.append(", type=");
		sb.append(type);
		sb.append(", assignableFrom=");
		sb.append(assignableFrom);
		sb.append(", assignableTo=");
		sb.append(assignableTo);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BadgeType toEntityModel() {
		BadgeTypeImpl badgeTypeImpl = new BadgeTypeImpl();

		badgeTypeImpl.setBadgeTypeId(badgeTypeId);
		badgeTypeImpl.setGroupId(groupId);
		badgeTypeImpl.setCompanyId(companyId);
		badgeTypeImpl.setUserId(userId);

		if (userName == null) {
			badgeTypeImpl.setUserName("");
		}
		else {
			badgeTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			badgeTypeImpl.setCreateDate(null);
		}
		else {
			badgeTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			badgeTypeImpl.setModifiedDate(null);
		}
		else {
			badgeTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			badgeTypeImpl.setType("");
		}
		else {
			badgeTypeImpl.setType(type);
		}

		if (assignableFrom == Long.MIN_VALUE) {
			badgeTypeImpl.setAssignableFrom(null);
		}
		else {
			badgeTypeImpl.setAssignableFrom(new Date(assignableFrom));
		}

		if (assignableTo == Long.MIN_VALUE) {
			badgeTypeImpl.setAssignableTo(null);
		}
		else {
			badgeTypeImpl.setAssignableTo(new Date(assignableTo));
		}

		badgeTypeImpl.setFileEntryId(fileEntryId);

		badgeTypeImpl.resetOriginalValues();

		return badgeTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		badgeTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		type = objectInput.readUTF();
		assignableFrom = objectInput.readLong();
		assignableTo = objectInput.readLong();

		fileEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(badgeTypeId);

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

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(assignableFrom);
		objectOutput.writeLong(assignableTo);

		objectOutput.writeLong(fileEntryId);
	}

	public long badgeTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String type;
	public long assignableFrom;
	public long assignableTo;
	public long fileEntryId;
}
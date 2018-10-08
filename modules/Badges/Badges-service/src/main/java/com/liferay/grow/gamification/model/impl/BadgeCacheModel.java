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

import com.liferay.grow.gamification.model.Badge;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Badge in entity cache.
 *
 * @author Vilmos Papp
 * @see Badge
 * @generated
 */
@ProviderType
public class BadgeCacheModel implements CacheModel<Badge>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeCacheModel)) {
			return false;
		}

		BadgeCacheModel badgeCacheModel = (BadgeCacheModel)obj;

		if (badgeId == badgeCacheModel.badgeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, badgeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", badgeId=");
		sb.append(badgeId);
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
		sb.append(", badgeTypeId=");
		sb.append(badgeTypeId);
		sb.append(", toUserId=");
		sb.append(toUserId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", assignedDateId=");
		sb.append(assignedDateId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Badge toEntityModel() {
		BadgeImpl badgeImpl = new BadgeImpl();

		if (uuid == null) {
			badgeImpl.setUuid("");
		}
		else {
			badgeImpl.setUuid(uuid);
		}

		badgeImpl.setBadgeId(badgeId);
		badgeImpl.setGroupId(groupId);
		badgeImpl.setCompanyId(companyId);
		badgeImpl.setUserId(userId);

		if (userName == null) {
			badgeImpl.setUserName("");
		}
		else {
			badgeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			badgeImpl.setCreateDate(null);
		}
		else {
			badgeImpl.setCreateDate(new Date(createDate));
		}

		badgeImpl.setBadgeTypeId(badgeTypeId);
		badgeImpl.setToUserId(toUserId);

		if (description == null) {
			badgeImpl.setDescription("");
		}
		else {
			badgeImpl.setDescription(description);
		}

		badgeImpl.setAssignedDateId(assignedDateId);

		badgeImpl.resetOriginalValues();

		return badgeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		badgeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		badgeTypeId = objectInput.readLong();

		toUserId = objectInput.readLong();
		description = objectInput.readUTF();

		assignedDateId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(badgeId);

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

		objectOutput.writeLong(badgeTypeId);

		objectOutput.writeLong(toUserId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(assignedDateId);
	}

	public String uuid;
	public long badgeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long badgeTypeId;
	public long toUserId;
	public String description;
	public long assignedDateId;
}
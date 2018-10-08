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
 * This class is a wrapper for {@link Badge}.
 * </p>
 *
 * @author Vilmos Papp
 * @see Badge
 * @generated
 */
@ProviderType
public class BadgeWrapper implements Badge, ModelWrapper<Badge> {
	public BadgeWrapper(Badge badge) {
		_badge = badge;
	}

	@Override
	public Class<?> getModelClass() {
		return Badge.class;
	}

	@Override
	public String getModelClassName() {
		return Badge.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("badgeId", getBadgeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("badgeTypeId", getBadgeTypeId());
		attributes.put("toUserId", getToUserId());
		attributes.put("description", getDescription());
		attributes.put("assignedDateId", getAssignedDateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long badgeId = (Long)attributes.get("badgeId");

		if (badgeId != null) {
			setBadgeId(badgeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long badgeTypeId = (Long)attributes.get("badgeTypeId");

		if (badgeTypeId != null) {
			setBadgeTypeId(badgeTypeId);
		}

		Long toUserId = (Long)attributes.get("toUserId");

		if (toUserId != null) {
			setToUserId(toUserId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long assignedDateId = (Long)attributes.get("assignedDateId");

		if (assignedDateId != null) {
			setAssignedDateId(assignedDateId);
		}
	}

	@Override
	public Object clone() {
		return new BadgeWrapper((Badge)_badge.clone());
	}

	@Override
	public int compareTo(Badge badge) {
		return _badge.compareTo(badge);
	}

	/**
	* Returns the assigned date ID of this badge.
	*
	* @return the assigned date ID of this badge
	*/
	@Override
	public long getAssignedDateId() {
		return _badge.getAssignedDateId();
	}

	/**
	* Returns the badge ID of this badge.
	*
	* @return the badge ID of this badge
	*/
	@Override
	public long getBadgeId() {
		return _badge.getBadgeId();
	}

	/**
	* Returns the badge type ID of this badge.
	*
	* @return the badge type ID of this badge
	*/
	@Override
	public long getBadgeTypeId() {
		return _badge.getBadgeTypeId();
	}

	/**
	* Returns the company ID of this badge.
	*
	* @return the company ID of this badge
	*/
	@Override
	public long getCompanyId() {
		return _badge.getCompanyId();
	}

	/**
	* Returns the create date of this badge.
	*
	* @return the create date of this badge
	*/
	@Override
	public Date getCreateDate() {
		return _badge.getCreateDate();
	}

	/**
	* Returns the description of this badge.
	*
	* @return the description of this badge
	*/
	@Override
	public String getDescription() {
		return _badge.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _badge.getExpandoBridge();
	}

	/**
	* Returns the group ID of this badge.
	*
	* @return the group ID of this badge
	*/
	@Override
	public long getGroupId() {
		return _badge.getGroupId();
	}

	/**
	* Returns the primary key of this badge.
	*
	* @return the primary key of this badge
	*/
	@Override
	public long getPrimaryKey() {
		return _badge.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _badge.getPrimaryKeyObj();
	}

	/**
	* Returns the to user ID of this badge.
	*
	* @return the to user ID of this badge
	*/
	@Override
	public long getToUserId() {
		return _badge.getToUserId();
	}

	/**
	* Returns the to user uuid of this badge.
	*
	* @return the to user uuid of this badge
	*/
	@Override
	public String getToUserUuid() {
		return _badge.getToUserUuid();
	}

	/**
	* Returns the user ID of this badge.
	*
	* @return the user ID of this badge
	*/
	@Override
	public long getUserId() {
		return _badge.getUserId();
	}

	/**
	* Returns the user name of this badge.
	*
	* @return the user name of this badge
	*/
	@Override
	public String getUserName() {
		return _badge.getUserName();
	}

	/**
	* Returns the user uuid of this badge.
	*
	* @return the user uuid of this badge
	*/
	@Override
	public String getUserUuid() {
		return _badge.getUserUuid();
	}

	/**
	* Returns the uuid of this badge.
	*
	* @return the uuid of this badge
	*/
	@Override
	public String getUuid() {
		return _badge.getUuid();
	}

	@Override
	public int hashCode() {
		return _badge.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _badge.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _badge.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _badge.isNew();
	}

	@Override
	public void persist() {
		_badge.persist();
	}

	/**
	* Sets the assigned date ID of this badge.
	*
	* @param assignedDateId the assigned date ID of this badge
	*/
	@Override
	public void setAssignedDateId(long assignedDateId) {
		_badge.setAssignedDateId(assignedDateId);
	}

	/**
	* Sets the badge ID of this badge.
	*
	* @param badgeId the badge ID of this badge
	*/
	@Override
	public void setBadgeId(long badgeId) {
		_badge.setBadgeId(badgeId);
	}

	/**
	* Sets the badge type ID of this badge.
	*
	* @param badgeTypeId the badge type ID of this badge
	*/
	@Override
	public void setBadgeTypeId(long badgeTypeId) {
		_badge.setBadgeTypeId(badgeTypeId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_badge.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this badge.
	*
	* @param companyId the company ID of this badge
	*/
	@Override
	public void setCompanyId(long companyId) {
		_badge.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this badge.
	*
	* @param createDate the create date of this badge
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_badge.setCreateDate(createDate);
	}

	/**
	* Sets the description of this badge.
	*
	* @param description the description of this badge
	*/
	@Override
	public void setDescription(String description) {
		_badge.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_badge.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_badge.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_badge.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this badge.
	*
	* @param groupId the group ID of this badge
	*/
	@Override
	public void setGroupId(long groupId) {
		_badge.setGroupId(groupId);
	}

	@Override
	public void setNew(boolean n) {
		_badge.setNew(n);
	}

	/**
	* Sets the primary key of this badge.
	*
	* @param primaryKey the primary key of this badge
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_badge.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_badge.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the to user ID of this badge.
	*
	* @param toUserId the to user ID of this badge
	*/
	@Override
	public void setToUserId(long toUserId) {
		_badge.setToUserId(toUserId);
	}

	/**
	* Sets the to user uuid of this badge.
	*
	* @param toUserUuid the to user uuid of this badge
	*/
	@Override
	public void setToUserUuid(String toUserUuid) {
		_badge.setToUserUuid(toUserUuid);
	}

	/**
	* Sets the user ID of this badge.
	*
	* @param userId the user ID of this badge
	*/
	@Override
	public void setUserId(long userId) {
		_badge.setUserId(userId);
	}

	/**
	* Sets the user name of this badge.
	*
	* @param userName the user name of this badge
	*/
	@Override
	public void setUserName(String userName) {
		_badge.setUserName(userName);
	}

	/**
	* Sets the user uuid of this badge.
	*
	* @param userUuid the user uuid of this badge
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_badge.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this badge.
	*
	* @param uuid the uuid of this badge
	*/
	@Override
	public void setUuid(String uuid) {
		_badge.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Badge> toCacheModel() {
		return _badge.toCacheModel();
	}

	@Override
	public Badge toEscapedModel() {
		return new BadgeWrapper(_badge.toEscapedModel());
	}

	@Override
	public String toString() {
		return _badge.toString();
	}

	@Override
	public Badge toUnescapedModel() {
		return new BadgeWrapper(_badge.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _badge.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeWrapper)) {
			return false;
		}

		BadgeWrapper badgeWrapper = (BadgeWrapper)obj;

		if (Objects.equals(_badge, badgeWrapper._badge)) {
			return true;
		}

		return false;
	}

	@Override
	public Badge getWrappedModel() {
		return _badge;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _badge.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _badge.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_badge.resetOriginalValues();
	}

	private final Badge _badge;
}
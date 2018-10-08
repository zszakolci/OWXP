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
 * This class is a wrapper for {@link BadgeType}.
 * </p>
 *
 * @author Vilmos Papp
 * @see BadgeType
 * @generated
 */
@ProviderType
public class BadgeTypeWrapper implements BadgeType, ModelWrapper<BadgeType> {
	public BadgeTypeWrapper(BadgeType badgeType) {
		_badgeType = badgeType;
	}

	@Override
	public Class<?> getModelClass() {
		return BadgeType.class;
	}

	@Override
	public String getModelClassName() {
		return BadgeType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("badgeTypeId", getBadgeTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());
		attributes.put("assignableFrom", getAssignableFrom());
		attributes.put("assignableTo", getAssignableTo());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long badgeTypeId = (Long)attributes.get("badgeTypeId");

		if (badgeTypeId != null) {
			setBadgeTypeId(badgeTypeId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Date assignableFrom = (Date)attributes.get("assignableFrom");

		if (assignableFrom != null) {
			setAssignableFrom(assignableFrom);
		}

		Date assignableTo = (Date)attributes.get("assignableTo");

		if (assignableTo != null) {
			setAssignableTo(assignableTo);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	@Override
	public Object clone() {
		return new BadgeTypeWrapper((BadgeType)_badgeType.clone());
	}

	@Override
	public int compareTo(BadgeType badgeType) {
		return _badgeType.compareTo(badgeType);
	}

	/**
	* Returns the assignable from of this badge type.
	*
	* @return the assignable from of this badge type
	*/
	@Override
	public Date getAssignableFrom() {
		return _badgeType.getAssignableFrom();
	}

	/**
	* Returns the assignable to of this badge type.
	*
	* @return the assignable to of this badge type
	*/
	@Override
	public Date getAssignableTo() {
		return _badgeType.getAssignableTo();
	}

	/**
	* Returns the badge type ID of this badge type.
	*
	* @return the badge type ID of this badge type
	*/
	@Override
	public long getBadgeTypeId() {
		return _badgeType.getBadgeTypeId();
	}

	/**
	* Returns the company ID of this badge type.
	*
	* @return the company ID of this badge type
	*/
	@Override
	public long getCompanyId() {
		return _badgeType.getCompanyId();
	}

	/**
	* Returns the create date of this badge type.
	*
	* @return the create date of this badge type
	*/
	@Override
	public Date getCreateDate() {
		return _badgeType.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _badgeType.getExpandoBridge();
	}

	/**
	* Returns the file entry ID of this badge type.
	*
	* @return the file entry ID of this badge type
	*/
	@Override
	public long getFileEntryId() {
		return _badgeType.getFileEntryId();
	}

	/**
	* Returns the group ID of this badge type.
	*
	* @return the group ID of this badge type
	*/
	@Override
	public long getGroupId() {
		return _badgeType.getGroupId();
	}

	/**
	* Returns the modified date of this badge type.
	*
	* @return the modified date of this badge type
	*/
	@Override
	public Date getModifiedDate() {
		return _badgeType.getModifiedDate();
	}

	/**
	* Returns the primary key of this badge type.
	*
	* @return the primary key of this badge type
	*/
	@Override
	public long getPrimaryKey() {
		return _badgeType.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _badgeType.getPrimaryKeyObj();
	}

	/**
	* Returns the type of this badge type.
	*
	* @return the type of this badge type
	*/
	@Override
	public String getType() {
		return _badgeType.getType();
	}

	/**
	* Returns the user ID of this badge type.
	*
	* @return the user ID of this badge type
	*/
	@Override
	public long getUserId() {
		return _badgeType.getUserId();
	}

	/**
	* Returns the user name of this badge type.
	*
	* @return the user name of this badge type
	*/
	@Override
	public String getUserName() {
		return _badgeType.getUserName();
	}

	/**
	* Returns the user uuid of this badge type.
	*
	* @return the user uuid of this badge type
	*/
	@Override
	public String getUserUuid() {
		return _badgeType.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _badgeType.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _badgeType.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _badgeType.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _badgeType.isNew();
	}

	@Override
	public void persist() {
		_badgeType.persist();
	}

	/**
	* Sets the assignable from of this badge type.
	*
	* @param assignableFrom the assignable from of this badge type
	*/
	@Override
	public void setAssignableFrom(Date assignableFrom) {
		_badgeType.setAssignableFrom(assignableFrom);
	}

	/**
	* Sets the assignable to of this badge type.
	*
	* @param assignableTo the assignable to of this badge type
	*/
	@Override
	public void setAssignableTo(Date assignableTo) {
		_badgeType.setAssignableTo(assignableTo);
	}

	/**
	* Sets the badge type ID of this badge type.
	*
	* @param badgeTypeId the badge type ID of this badge type
	*/
	@Override
	public void setBadgeTypeId(long badgeTypeId) {
		_badgeType.setBadgeTypeId(badgeTypeId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_badgeType.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this badge type.
	*
	* @param companyId the company ID of this badge type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_badgeType.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this badge type.
	*
	* @param createDate the create date of this badge type
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_badgeType.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_badgeType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_badgeType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_badgeType.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this badge type.
	*
	* @param fileEntryId the file entry ID of this badge type
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_badgeType.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the group ID of this badge type.
	*
	* @param groupId the group ID of this badge type
	*/
	@Override
	public void setGroupId(long groupId) {
		_badgeType.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this badge type.
	*
	* @param modifiedDate the modified date of this badge type
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_badgeType.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_badgeType.setNew(n);
	}

	/**
	* Sets the primary key of this badge type.
	*
	* @param primaryKey the primary key of this badge type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_badgeType.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_badgeType.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type of this badge type.
	*
	* @param type the type of this badge type
	*/
	@Override
	public void setType(String type) {
		_badgeType.setType(type);
	}

	/**
	* Sets the user ID of this badge type.
	*
	* @param userId the user ID of this badge type
	*/
	@Override
	public void setUserId(long userId) {
		_badgeType.setUserId(userId);
	}

	/**
	* Sets the user name of this badge type.
	*
	* @param userName the user name of this badge type
	*/
	@Override
	public void setUserName(String userName) {
		_badgeType.setUserName(userName);
	}

	/**
	* Sets the user uuid of this badge type.
	*
	* @param userUuid the user uuid of this badge type
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_badgeType.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<BadgeType> toCacheModel() {
		return _badgeType.toCacheModel();
	}

	@Override
	public BadgeType toEscapedModel() {
		return new BadgeTypeWrapper(_badgeType.toEscapedModel());
	}

	@Override
	public String toString() {
		return _badgeType.toString();
	}

	@Override
	public BadgeType toUnescapedModel() {
		return new BadgeTypeWrapper(_badgeType.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _badgeType.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeTypeWrapper)) {
			return false;
		}

		BadgeTypeWrapper badgeTypeWrapper = (BadgeTypeWrapper)obj;

		if (Objects.equals(_badgeType, badgeTypeWrapper._badgeType)) {
			return true;
		}

		return false;
	}

	@Override
	public BadgeType getWrappedModel() {
		return _badgeType;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _badgeType.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _badgeType.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_badgeType.resetOriginalValues();
	}

	private final BadgeType _badgeType;
}
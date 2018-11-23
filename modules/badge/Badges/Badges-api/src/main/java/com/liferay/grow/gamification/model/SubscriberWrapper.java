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
 * This class is a wrapper for {@link Subscriber}.
 * </p>
 *
 * @author Vilmos Papp
 * @see Subscriber
 * @generated
 */
@ProviderType
public class SubscriberWrapper implements Subscriber, ModelWrapper<Subscriber> {
	public SubscriberWrapper(Subscriber subscriber) {
		_subscriber = subscriber;
	}

	@Override
	public Class<?> getModelClass() {
		return Subscriber.class;
	}

	@Override
	public String getModelClassName() {
		return Subscriber.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subscriberId", getSubscriberId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("subscriberUserId", getSubscriberUserId());
		attributes.put("badgeType", getBadgeType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subscriberId = (Long)attributes.get("subscriberId");

		if (subscriberId != null) {
			setSubscriberId(subscriberId);
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

		Long subscriberUserId = (Long)attributes.get("subscriberUserId");

		if (subscriberUserId != null) {
			setSubscriberUserId(subscriberUserId);
		}

		Long badgeType = (Long)attributes.get("badgeType");

		if (badgeType != null) {
			setBadgeType(badgeType);
		}
	}

	@Override
	public Object clone() {
		return new SubscriberWrapper((Subscriber)_subscriber.clone());
	}

	@Override
	public int compareTo(Subscriber subscriber) {
		return _subscriber.compareTo(subscriber);
	}

	/**
	* Returns the badge type of this subscriber.
	*
	* @return the badge type of this subscriber
	*/
	@Override
	public long getBadgeType() {
		return _subscriber.getBadgeType();
	}

	/**
	* Returns the company ID of this subscriber.
	*
	* @return the company ID of this subscriber
	*/
	@Override
	public long getCompanyId() {
		return _subscriber.getCompanyId();
	}

	/**
	* Returns the create date of this subscriber.
	*
	* @return the create date of this subscriber
	*/
	@Override
	public Date getCreateDate() {
		return _subscriber.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _subscriber.getExpandoBridge();
	}

	/**
	* Returns the group ID of this subscriber.
	*
	* @return the group ID of this subscriber
	*/
	@Override
	public long getGroupId() {
		return _subscriber.getGroupId();
	}

	/**
	* Returns the modified date of this subscriber.
	*
	* @return the modified date of this subscriber
	*/
	@Override
	public Date getModifiedDate() {
		return _subscriber.getModifiedDate();
	}

	/**
	* Returns the primary key of this subscriber.
	*
	* @return the primary key of this subscriber
	*/
	@Override
	public long getPrimaryKey() {
		return _subscriber.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subscriber.getPrimaryKeyObj();
	}

	/**
	* Returns the subscriber ID of this subscriber.
	*
	* @return the subscriber ID of this subscriber
	*/
	@Override
	public long getSubscriberId() {
		return _subscriber.getSubscriberId();
	}

	/**
	* Returns the subscriber user ID of this subscriber.
	*
	* @return the subscriber user ID of this subscriber
	*/
	@Override
	public long getSubscriberUserId() {
		return _subscriber.getSubscriberUserId();
	}

	/**
	* Returns the subscriber user uuid of this subscriber.
	*
	* @return the subscriber user uuid of this subscriber
	*/
	@Override
	public String getSubscriberUserUuid() {
		return _subscriber.getSubscriberUserUuid();
	}

	/**
	* Returns the user ID of this subscriber.
	*
	* @return the user ID of this subscriber
	*/
	@Override
	public long getUserId() {
		return _subscriber.getUserId();
	}

	/**
	* Returns the user name of this subscriber.
	*
	* @return the user name of this subscriber
	*/
	@Override
	public String getUserName() {
		return _subscriber.getUserName();
	}

	/**
	* Returns the user uuid of this subscriber.
	*
	* @return the user uuid of this subscriber
	*/
	@Override
	public String getUserUuid() {
		return _subscriber.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _subscriber.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _subscriber.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _subscriber.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _subscriber.isNew();
	}

	@Override
	public void persist() {
		_subscriber.persist();
	}

	/**
	* Sets the badge type of this subscriber.
	*
	* @param badgeType the badge type of this subscriber
	*/
	@Override
	public void setBadgeType(long badgeType) {
		_subscriber.setBadgeType(badgeType);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subscriber.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this subscriber.
	*
	* @param companyId the company ID of this subscriber
	*/
	@Override
	public void setCompanyId(long companyId) {
		_subscriber.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this subscriber.
	*
	* @param createDate the create date of this subscriber
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_subscriber.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_subscriber.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_subscriber.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_subscriber.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this subscriber.
	*
	* @param groupId the group ID of this subscriber
	*/
	@Override
	public void setGroupId(long groupId) {
		_subscriber.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this subscriber.
	*
	* @param modifiedDate the modified date of this subscriber
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_subscriber.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_subscriber.setNew(n);
	}

	/**
	* Sets the primary key of this subscriber.
	*
	* @param primaryKey the primary key of this subscriber
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subscriber.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_subscriber.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the subscriber ID of this subscriber.
	*
	* @param subscriberId the subscriber ID of this subscriber
	*/
	@Override
	public void setSubscriberId(long subscriberId) {
		_subscriber.setSubscriberId(subscriberId);
	}

	/**
	* Sets the subscriber user ID of this subscriber.
	*
	* @param subscriberUserId the subscriber user ID of this subscriber
	*/
	@Override
	public void setSubscriberUserId(long subscriberUserId) {
		_subscriber.setSubscriberUserId(subscriberUserId);
	}

	/**
	* Sets the subscriber user uuid of this subscriber.
	*
	* @param subscriberUserUuid the subscriber user uuid of this subscriber
	*/
	@Override
	public void setSubscriberUserUuid(String subscriberUserUuid) {
		_subscriber.setSubscriberUserUuid(subscriberUserUuid);
	}

	/**
	* Sets the user ID of this subscriber.
	*
	* @param userId the user ID of this subscriber
	*/
	@Override
	public void setUserId(long userId) {
		_subscriber.setUserId(userId);
	}

	/**
	* Sets the user name of this subscriber.
	*
	* @param userName the user name of this subscriber
	*/
	@Override
	public void setUserName(String userName) {
		_subscriber.setUserName(userName);
	}

	/**
	* Sets the user uuid of this subscriber.
	*
	* @param userUuid the user uuid of this subscriber
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_subscriber.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Subscriber> toCacheModel() {
		return _subscriber.toCacheModel();
	}

	@Override
	public Subscriber toEscapedModel() {
		return new SubscriberWrapper(_subscriber.toEscapedModel());
	}

	@Override
	public String toString() {
		return _subscriber.toString();
	}

	@Override
	public Subscriber toUnescapedModel() {
		return new SubscriberWrapper(_subscriber.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _subscriber.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubscriberWrapper)) {
			return false;
		}

		SubscriberWrapper subscriberWrapper = (SubscriberWrapper)obj;

		if (Objects.equals(_subscriber, subscriberWrapper._subscriber)) {
			return true;
		}

		return false;
	}

	@Override
	public Subscriber getWrappedModel() {
		return _subscriber;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _subscriber.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _subscriber.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_subscriber.resetOriginalValues();
	}

	private final Subscriber _subscriber;
}
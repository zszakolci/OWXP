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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link LDate}.
 * </p>
 *
 * @author Vilmos Papp
 * @see LDate
 * @generated
 */
@ProviderType
public class LDateWrapper implements LDate, ModelWrapper<LDate> {
	public LDateWrapper(LDate lDate) {
		_lDate = lDate;
	}

	@Override
	public Class<?> getModelClass() {
		return LDate.class;
	}

	@Override
	public String getModelClassName() {
		return LDate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dateId", getDateId());
		attributes.put("year", getYear());
		attributes.put("month", getMonth());
		attributes.put("monthName", getMonthName());
		attributes.put("day", getDay());
		attributes.put("dayOfYear", getDayOfYear());
		attributes.put("week", getWeek());
		attributes.put("weekDay", getWeekDay());
		attributes.put("quarter", getQuarter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dateId = (Long)attributes.get("dateId");

		if (dateId != null) {
			setDateId(dateId);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		String monthName = (String)attributes.get("monthName");

		if (monthName != null) {
			setMonthName(monthName);
		}

		Integer day = (Integer)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		Integer dayOfYear = (Integer)attributes.get("dayOfYear");

		if (dayOfYear != null) {
			setDayOfYear(dayOfYear);
		}

		Integer week = (Integer)attributes.get("week");

		if (week != null) {
			setWeek(week);
		}

		String weekDay = (String)attributes.get("weekDay");

		if (weekDay != null) {
			setWeekDay(weekDay);
		}

		String quarter = (String)attributes.get("quarter");

		if (quarter != null) {
			setQuarter(quarter);
		}
	}

	@Override
	public Object clone() {
		return new LDateWrapper((LDate)_lDate.clone());
	}

	@Override
	public int compareTo(LDate lDate) {
		return _lDate.compareTo(lDate);
	}

	/**
	* Returns the date ID of this l date.
	*
	* @return the date ID of this l date
	*/
	@Override
	public long getDateId() {
		return _lDate.getDateId();
	}

	/**
	* Returns the day of this l date.
	*
	* @return the day of this l date
	*/
	@Override
	public int getDay() {
		return _lDate.getDay();
	}

	/**
	* Returns the day of year of this l date.
	*
	* @return the day of year of this l date
	*/
	@Override
	public int getDayOfYear() {
		return _lDate.getDayOfYear();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _lDate.getExpandoBridge();
	}

	/**
	* Returns the month of this l date.
	*
	* @return the month of this l date
	*/
	@Override
	public int getMonth() {
		return _lDate.getMonth();
	}

	/**
	* Returns the month name of this l date.
	*
	* @return the month name of this l date
	*/
	@Override
	public String getMonthName() {
		return _lDate.getMonthName();
	}

	/**
	* Returns the primary key of this l date.
	*
	* @return the primary key of this l date
	*/
	@Override
	public long getPrimaryKey() {
		return _lDate.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lDate.getPrimaryKeyObj();
	}

	/**
	* Returns the quarter of this l date.
	*
	* @return the quarter of this l date
	*/
	@Override
	public String getQuarter() {
		return _lDate.getQuarter();
	}

	/**
	* Returns the week of this l date.
	*
	* @return the week of this l date
	*/
	@Override
	public int getWeek() {
		return _lDate.getWeek();
	}

	/**
	* Returns the week day of this l date.
	*
	* @return the week day of this l date
	*/
	@Override
	public String getWeekDay() {
		return _lDate.getWeekDay();
	}

	/**
	* Returns the year of this l date.
	*
	* @return the year of this l date
	*/
	@Override
	public int getYear() {
		return _lDate.getYear();
	}

	@Override
	public int hashCode() {
		return _lDate.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _lDate.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _lDate.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _lDate.isNew();
	}

	@Override
	public void persist() {
		_lDate.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lDate.setCachedModel(cachedModel);
	}

	/**
	* Sets the date ID of this l date.
	*
	* @param dateId the date ID of this l date
	*/
	@Override
	public void setDateId(long dateId) {
		_lDate.setDateId(dateId);
	}

	/**
	* Sets the day of this l date.
	*
	* @param day the day of this l date
	*/
	@Override
	public void setDay(int day) {
		_lDate.setDay(day);
	}

	/**
	* Sets the day of year of this l date.
	*
	* @param dayOfYear the day of year of this l date
	*/
	@Override
	public void setDayOfYear(int dayOfYear) {
		_lDate.setDayOfYear(dayOfYear);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_lDate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_lDate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_lDate.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the month of this l date.
	*
	* @param month the month of this l date
	*/
	@Override
	public void setMonth(int month) {
		_lDate.setMonth(month);
	}

	/**
	* Sets the month name of this l date.
	*
	* @param monthName the month name of this l date
	*/
	@Override
	public void setMonthName(String monthName) {
		_lDate.setMonthName(monthName);
	}

	@Override
	public void setNew(boolean n) {
		_lDate.setNew(n);
	}

	/**
	* Sets the primary key of this l date.
	*
	* @param primaryKey the primary key of this l date
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lDate.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_lDate.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the quarter of this l date.
	*
	* @param quarter the quarter of this l date
	*/
	@Override
	public void setQuarter(String quarter) {
		_lDate.setQuarter(quarter);
	}

	/**
	* Sets the week of this l date.
	*
	* @param week the week of this l date
	*/
	@Override
	public void setWeek(int week) {
		_lDate.setWeek(week);
	}

	/**
	* Sets the week day of this l date.
	*
	* @param weekDay the week day of this l date
	*/
	@Override
	public void setWeekDay(String weekDay) {
		_lDate.setWeekDay(weekDay);
	}

	/**
	* Sets the year of this l date.
	*
	* @param year the year of this l date
	*/
	@Override
	public void setYear(int year) {
		_lDate.setYear(year);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LDate> toCacheModel() {
		return _lDate.toCacheModel();
	}

	@Override
	public LDate toEscapedModel() {
		return new LDateWrapper(_lDate.toEscapedModel());
	}

	@Override
	public String toString() {
		return _lDate.toString();
	}

	@Override
	public LDate toUnescapedModel() {
		return new LDateWrapper(_lDate.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _lDate.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LDateWrapper)) {
			return false;
		}

		LDateWrapper lDateWrapper = (LDateWrapper)obj;

		if (Objects.equals(_lDate, lDateWrapper._lDate)) {
			return true;
		}

		return false;
	}

	@Override
	public LDate getWrappedModel() {
		return _lDate;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _lDate.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _lDate.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_lDate.resetOriginalValues();
	}

	private final LDate _lDate;
}
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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.grow.gamification.service.http.LDateServiceSoap}.
 *
 * @author Vilmos Papp
 * @see com.liferay.grow.gamification.service.http.LDateServiceSoap
 * @generated
 */
@ProviderType
public class LDateSoap implements Serializable {
	public static LDateSoap toSoapModel(LDate model) {
		LDateSoap soapModel = new LDateSoap();

		soapModel.setDateId(model.getDateId());
		soapModel.setYear(model.getYear());
		soapModel.setMonth(model.getMonth());
		soapModel.setMonthName(model.getMonthName());
		soapModel.setDay(model.getDay());
		soapModel.setDayOfYear(model.getDayOfYear());
		soapModel.setWeek(model.getWeek());
		soapModel.setWeekDay(model.getWeekDay());
		soapModel.setQuarter(model.getQuarter());

		return soapModel;
	}

	public static LDateSoap[] toSoapModels(LDate[] models) {
		LDateSoap[] soapModels = new LDateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LDateSoap[][] toSoapModels(LDate[][] models) {
		LDateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LDateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LDateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LDateSoap[] toSoapModels(List<LDate> models) {
		List<LDateSoap> soapModels = new ArrayList<LDateSoap>(models.size());

		for (LDate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LDateSoap[soapModels.size()]);
	}

	public LDateSoap() {
	}

	public long getPrimaryKey() {
		return _dateId;
	}

	public void setPrimaryKey(long pk) {
		setDateId(pk);
	}

	public long getDateId() {
		return _dateId;
	}

	public void setDateId(long dateId) {
		_dateId = dateId;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public int getMonth() {
		return _month;
	}

	public void setMonth(int month) {
		_month = month;
	}

	public String getMonthName() {
		return _monthName;
	}

	public void setMonthName(String monthName) {
		_monthName = monthName;
	}

	public int getDay() {
		return _day;
	}

	public void setDay(int day) {
		_day = day;
	}

	public int getDayOfYear() {
		return _dayOfYear;
	}

	public void setDayOfYear(int dayOfYear) {
		_dayOfYear = dayOfYear;
	}

	public int getWeek() {
		return _week;
	}

	public void setWeek(int week) {
		_week = week;
	}

	public String getWeekDay() {
		return _weekDay;
	}

	public void setWeekDay(String weekDay) {
		_weekDay = weekDay;
	}

	public String getQuarter() {
		return _quarter;
	}

	public void setQuarter(String quarter) {
		_quarter = quarter;
	}

	private long _dateId;
	private int _year;
	private int _month;
	private String _monthName;
	private int _day;
	private int _dayOfYear;
	private int _week;
	private String _weekDay;
	private String _quarter;
}
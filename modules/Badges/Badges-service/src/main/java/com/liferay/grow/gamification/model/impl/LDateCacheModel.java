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

import com.liferay.grow.gamification.model.LDate;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LDate in entity cache.
 *
 * @author Vilmos Papp
 * @see LDate
 * @generated
 */
@ProviderType
public class LDateCacheModel implements CacheModel<LDate>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LDateCacheModel)) {
			return false;
		}

		LDateCacheModel lDateCacheModel = (LDateCacheModel)obj;

		if (dateId == lDateCacheModel.dateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{dateId=");
		sb.append(dateId);
		sb.append(", year=");
		sb.append(year);
		sb.append(", month=");
		sb.append(month);
		sb.append(", monthName=");
		sb.append(monthName);
		sb.append(", day=");
		sb.append(day);
		sb.append(", dayOfYear=");
		sb.append(dayOfYear);
		sb.append(", week=");
		sb.append(week);
		sb.append(", weekDay=");
		sb.append(weekDay);
		sb.append(", quarter=");
		sb.append(quarter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LDate toEntityModel() {
		LDateImpl lDateImpl = new LDateImpl();

		lDateImpl.setDateId(dateId);
		lDateImpl.setYear(year);
		lDateImpl.setMonth(month);

		if (monthName == null) {
			lDateImpl.setMonthName("");
		}
		else {
			lDateImpl.setMonthName(monthName);
		}

		lDateImpl.setDay(day);
		lDateImpl.setDayOfYear(dayOfYear);
		lDateImpl.setWeek(week);

		if (weekDay == null) {
			lDateImpl.setWeekDay("");
		}
		else {
			lDateImpl.setWeekDay(weekDay);
		}

		if (quarter == null) {
			lDateImpl.setQuarter("");
		}
		else {
			lDateImpl.setQuarter(quarter);
		}

		lDateImpl.resetOriginalValues();

		return lDateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dateId = objectInput.readLong();

		year = objectInput.readInt();

		month = objectInput.readInt();
		monthName = objectInput.readUTF();

		day = objectInput.readInt();

		dayOfYear = objectInput.readInt();

		week = objectInput.readInt();
		weekDay = objectInput.readUTF();
		quarter = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dateId);

		objectOutput.writeInt(year);

		objectOutput.writeInt(month);

		if (monthName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(monthName);
		}

		objectOutput.writeInt(day);

		objectOutput.writeInt(dayOfYear);

		objectOutput.writeInt(week);

		if (weekDay == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(weekDay);
		}

		if (quarter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quarter);
		}
	}

	public long dateId;
	public int year;
	public int month;
	public String monthName;
	public int day;
	public int dayOfYear;
	public int week;
	public String weekDay;
	public String quarter;
}
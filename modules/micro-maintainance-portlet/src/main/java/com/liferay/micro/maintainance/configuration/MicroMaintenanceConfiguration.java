package com.liferay.micro.maintainance.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.liferay.micro.maintainance.configuration.MicroMaintenanceConfiguration")
public interface MicroMaintenanceConfiguration {

	@Meta.AD(
		deflt = "0",
		required = true
	)
	public int checkingPeriodDays();

	@Meta.AD(
		deflt = "1",
		required = true
	)
	public int checkingPeriodHours();

	@Meta.AD(
		deflt = "0",
		required = true
	)
	public int checkingPeriodMinutes();
}

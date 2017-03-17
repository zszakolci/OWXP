package com.liferay.micro.maintainance.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.liferay.micro.maintainance.configuration.OutdatedTaskConfiguration")
public interface OutdatedTaskConfiguration {

	@Meta.AD(
		deflt = "14",
		required = false
	)
	public int votingPeriodDays();

	@Meta.AD(
		deflt = "5",
		required = false
	)
	public int requiredVotingPercentage();

	@Meta.AD(
		deflt = "5",
		required = false
	)
	public int requiredYesVotesPercentage();
}

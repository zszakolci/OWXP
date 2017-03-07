create table Task_CandidateMaintenance (
	uuid_ VARCHAR(75) null,
	candidateMaintenanceId LONG not null primary key,
	candidateId LONG,
	taskId LONG,
	createDate DATE null
);

create table Task_TaskEntry (
	uuid_ VARCHAR(75) null,
	taskId LONG not null primary key,
	createDate DATE null,
	taskName VARCHAR(75) null
);
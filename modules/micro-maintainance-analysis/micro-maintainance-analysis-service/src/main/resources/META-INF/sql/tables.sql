create table Analysis_AnalysisEntry (
	uuid_ VARCHAR(75) null,
	analysisId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	canMainId LONG,
	analysisData VARCHAR(75) null
);
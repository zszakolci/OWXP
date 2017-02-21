create table Decision_DecisionEntry (
	uuid_ VARCHAR(75) null,
	decisionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	analysisId LONG,
	outcome VARCHAR(75) null,
	handled BOOLEAN
);
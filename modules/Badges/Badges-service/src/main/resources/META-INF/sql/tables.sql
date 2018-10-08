create table gamification_Badge (
	uuid_ VARCHAR(75) null,
	badgeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	badgeTypeId LONG,
	toUserId LONG,
	description VARCHAR(255) null,
	assignedDateId LONG
);

create table gamification_BadgeType (
	badgeTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	type_ VARCHAR(75) null,
	assignableFrom DATE null,
	assignableTo DATE null,
	fileEntryId LONG
);

create table gamification_LDate (
	dateId LONG not null primary key,
	year INTEGER,
	month INTEGER,
	monthName VARCHAR(75) null,
	day INTEGER,
	dayOfYear INTEGER,
	week INTEGER,
	weekDay VARCHAR(75) null,
	quarter VARCHAR(75) null
);

create table gamification_Subscriber (
	subscriberId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	subscriberUserId LONG,
	badgeType LONG
);
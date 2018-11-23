create index IX_D8A6C893 on gamification_Badge (badgeTypeId);
create index IX_DE2F644A on gamification_Badge (toUserId);
create index IX_8ED8DE6F on gamification_Badge (userId);
create index IX_88BF89E9 on gamification_Badge (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_54376AB on gamification_Badge (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5741DE67 on gamification_BadgeType (assignableTo);
create index IX_F191AA66 on gamification_BadgeType (type_[$COLUMN_LENGTH:75$]);

create index IX_80447019 on gamification_LDate (year, month, day);

create index IX_EC8376E4 on gamification_Subscriber (subscriberUserId);
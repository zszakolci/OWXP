create index IX_1711639D on Decision_DecisionEntry (companyId, handled);
create index IX_E130AE84 on Decision_DecisionEntry (decisionId, companyId);
create index IX_619738C8 on Decision_DecisionEntry (decisionId, handled);
create index IX_A2B9B20A on Decision_DecisionEntry (decisionId, userId, companyId);
create index IX_E25B449 on Decision_DecisionEntry (outcome[$COLUMN_LENGTH:75$]);
create index IX_D73D3104 on Decision_DecisionEntry (userId, handled, decisionId);
create index IX_9815178D on Decision_DecisionEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create index IX_73393C27 on Decision_DecisionEntry (wikiPageId);
create index IX_92584F17 on Decision_DecisionEntry (wikiPageName[$COLUMN_LENGTH:75$]);
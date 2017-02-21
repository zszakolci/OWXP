create index IX_3C6AC7FA on Decision_DecisionEntry (companyId, analysisId);
create index IX_1711639D on Decision_DecisionEntry (companyId, handled);
create index IX_7FAFA55D on Decision_DecisionEntry (decisionId, analysisId, handled);
create index IX_E130AE84 on Decision_DecisionEntry (decisionId, companyId);
create index IX_619738C8 on Decision_DecisionEntry (decisionId, handled);
create index IX_A2B9B20A on Decision_DecisionEntry (decisionId, userId, companyId);
create index IX_BB02225E on Decision_DecisionEntry (userId, analysisId);
create index IX_D73D3104 on Decision_DecisionEntry (userId, handled, decisionId);
create index IX_9815178D on Decision_DecisionEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
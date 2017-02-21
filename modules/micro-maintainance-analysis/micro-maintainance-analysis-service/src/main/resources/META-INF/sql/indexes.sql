create index IX_D118AB0 on Analysis_AnalysisEntry (analysisId, canMainId);
create index IX_11BDAB84 on Analysis_AnalysisEntry (analysisId, companyId);
create index IX_244D8E36 on Analysis_AnalysisEntry (analysisId, userId, canMainId);
create index IX_66002515 on Analysis_AnalysisEntry (canMainId, userId);
create index IX_553831E9 on Analysis_AnalysisEntry (companyId, userId);
create index IX_8FB35351 on Analysis_AnalysisEntry (userId, createDate);
create index IX_AF4DB78D on Analysis_AnalysisEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
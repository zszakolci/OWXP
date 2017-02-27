create index IX_D118AB0 on Analysis_AnalysisEntry (analysisId, canMainId);
create index IX_11BDAB84 on Analysis_AnalysisEntry (analysisId, companyId);
create index IX_244D8E36 on Analysis_AnalysisEntry (analysisId, userId, canMainId);
create index IX_66002515 on Analysis_AnalysisEntry (canMainId, userId);
create index IX_553831E9 on Analysis_AnalysisEntry (companyId, userId);
create index IX_8FB35351 on Analysis_AnalysisEntry (userId, createDate);
create index IX_AF4DB78D on Analysis_AnalysisEntry (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_7BCF3195 on Analysis_AnalysisUser (analysisId, userId);
create index IX_1A18EA2F on Analysis_AnalysisUser (analysisId, voted);
create index IX_4B2ACFC6 on Analysis_AnalysisUser (analysisUserId);
create index IX_F98BC6CA on Analysis_AnalysisUser (userId);
create index IX_CE32BCFA on Analysis_AnalysisUser (userName[$COLUMN_LENGTH:75$]);
create index IX_7F45A924 on Analysis_AnalysisUser (uuid_[$COLUMN_LENGTH:75$]);
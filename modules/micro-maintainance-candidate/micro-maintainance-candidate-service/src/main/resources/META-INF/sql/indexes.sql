create index IX_3C5A1B95 on Candidate_CandidateEntry (companyId, createDate);
create index IX_7C072891 on Candidate_CandidateEntry (companyId, userId);
create index IX_E0D9D221 on Candidate_CandidateEntry (groupId, userId, wikiPageId);
create unique index IX_4D8C29E7 on Candidate_CandidateEntry (groupId, wikiPageId);
create index IX_42C331A9 on Candidate_CandidateEntry (userId, createDate);
create index IX_C91122B9 on Candidate_CandidateEntry (userId, wikiPageId);
create index IX_3CF14BE5 on Candidate_CandidateEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DB587A7 on Candidate_CandidateEntry (uuid_[$COLUMN_LENGTH:75$], groupId);
create unique index IX_2D09927F on Candidate_CandidateEntry (wikiPageId);
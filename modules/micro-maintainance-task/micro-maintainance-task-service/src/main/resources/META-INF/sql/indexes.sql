create index IX_C7569E52 on Task_CandidateMaintenance (candidateId, taskId);
create index IX_4FC32244 on Task_CandidateMaintenance (taskId);
create index IX_FE335264 on Task_CandidateMaintenance (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B13E96AD on Task_TaskEntry (taskId);
create index IX_6471201D on Task_TaskEntry (taskName[$COLUMN_LENGTH:75$]);
create index IX_6CB32CDB on Task_TaskEntry (uuid_[$COLUMN_LENGTH:75$]);
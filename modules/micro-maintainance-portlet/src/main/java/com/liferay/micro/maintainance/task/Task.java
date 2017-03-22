package com.liferay.micro.maintainance.task;

import com.liferay.micro.maintainance.action.Action;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;

import java.util.List;
public interface Task {

	public List<Action> analyze(AnalysisEntry analysisEntry);

	public String getOutcome();

	public long getTaskId();

	public String getTaskName();

	public boolean isAnalyseReady(CandidateMaintenance canMain);

	public void setTaskId(long taskId);

}
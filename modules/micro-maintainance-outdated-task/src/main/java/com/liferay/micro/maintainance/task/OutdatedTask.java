package com.liferay.micro.maintainance.task;

import java.util.List;

import com.liferay.micro.maintainance.action.Action;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;

public class OutdatedTask implements Task {

	@Override
	public List<Action> analyze(AnalysisEntry analysisEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTaskId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTaskName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTaskId(long taskId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAnalyseReady(CandidateMaintenance canMain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getOutcome() {
		// TODO Auto-generated method stub
		return null;
	}

}

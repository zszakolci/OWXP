package com.liferay.micro.maintainance.task;

import java.util.HashMap;
import java.util.List;

import com.liferay.micro.maintainance.action.Action;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;

public class OutdatedTask implements Task {

	protected OutdatedTask() {
		this.taskId = 0;
	}

	public static OutdatedTask getOutdatedTaskInstance() {
		if(outdatedTask == null) {
			outdatedTask = new OutdatedTask();
		}

		return outdatedTask;
	}

	@Override
	public List<Action> analyze(AnalysisEntry analysisEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTaskId() {
		return taskId;
	}

	@Override
	public String getTaskName() {
		return TASK_NAME;
	}

	@Override
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	@Override
	public boolean isAnalyseReady(CandidateMaintenance canMain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getOutcome() {
		return outcome;
	}

	private static String TASK_NAME = "Outdated";
	private long taskId = 0;
	private static OutdatedTask outdatedTask = null;
	private String outcome = "";
}

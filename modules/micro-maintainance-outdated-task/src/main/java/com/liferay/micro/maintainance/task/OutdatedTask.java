package com.liferay.micro.maintainance.task;

import com.liferay.micro.maintainance.action.Action;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;

import java.util.List;
public class OutdatedTask implements Task {

	public static OutdatedTask getOutdatedTaskInstance() {
		if (outdatedTask == null) {
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
	public String getOutcome() {
		return outcome;
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
	public boolean isAnalyseReady(CandidateMaintenance canMain) {

		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	protected OutdatedTask() {
		this.taskId = 0;
	}

	private static String TASK_NAME = "Outdated";

	private static OutdatedTask outdatedTask = null;

	private String outcome = "";
	private long taskId = 0;

}
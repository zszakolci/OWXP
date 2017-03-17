package com.liferay.micro.maintainance.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.micro.maintainance.action.Action;
import com.liferay.micro.maintainance.action.NotifyCreatorAction;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.util.VoteCalculations;
import com.liferay.micro.maintainance.util.VoteConstants;
import com.liferay.micro.maintainance.util.VotesJSONSerializer;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;

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
		List<Action> actions = new ArrayList<Action>();

		double percentageYesVotes =VoteCalculations.getVotePercentage(
			analysisEntry.getAnalysisData(), VoteConstants.YES_DESCRIPTION);
		int totalUsers = UserLocalServiceUtil.getUsersCount();
		int totalVotedUsers = VoteCalculations.getTotalVotes(
			analysisEntry.getAnalysisData());
		double percentageVoted = 0.00;

		if(totalVotedUsers > 0) {
			percentageVoted = (totalVotedUsers * 100/ totalUsers);
		}

		if(percentageVoted > requiredVotingPercentage && 
			percentageYesVotes > requiredYesVotesPercentage) {
			actions.add(new NotifyCreatorAction());
		}

		return actions;
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
		Date now = new Date();

		if(DateUtil
			.getDaysBetween(now, canMain.getCreateDate()) > votingPeriodDays) {

			return true;
		}

		return false;
	}

	@Override
	public String getOutcome() {
		return outcome;
	}

	public int getVotingPeriodDays() {
		return votingPeriodDays;
	}

	public void setVotingPeriodDays(int votingPeriodDays) {
		this.votingPeriodDays = votingPeriodDays;
	}

	public int getRequiredVotingPercentage() {
		return requiredVotingPercentage;
	}

	public void setRequiredVotingPercentage(int requiredVotingPercentage) {
		this.requiredVotingPercentage = requiredVotingPercentage;
	}

	public int getRequiredYesVotesPercentage() {
		return requiredYesVotesPercentage;
	}

	public void setRequiredYesVotesPercentage(int requiredYesVotesPercentage) {
		this.requiredYesVotesPercentage = requiredYesVotesPercentage;
	}

	private static String TASK_NAME = "Outdated";
	private long taskId = 0;
	private static OutdatedTask outdatedTask;
	private String outcome = "";

	private int votingPeriodDays;
	private int requiredVotingPercentage;
	private int requiredYesVotesPercentage;
}

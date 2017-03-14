package com.liferay.micro.maintainance.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.micro.maintainance.analysis.exception.NoSuchUserException;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.analysis.model.AnalysisUser;
import com.liferay.micro.maintainance.analysis.service.AnalysisUserLocalServiceUtil;
import com.liferay.micro.maintainance.analysis.service.persistence.AnalysisEntryUtil;
import com.liferay.micro.maintainance.analysis.service.persistence.AnalysisUserUtil;
import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.service.persistence.CandidateEntryUtil;
import com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.model.TaskEntry;
import com.liferay.micro.maintainance.task.service.TaskEntryLocalServiceUtil;
import com.liferay.micro.maintainance.task.service.persistence.CandidateMaintenanceUtil;
import com.liferay.micro.maintainance.task.service.persistence.TaskEntryUtil;
import com.liferay.micro.maintainance.util.VoteConstants;
import com.liferay.micro.maintainance.util.VotesJSONSerializer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;

public class TaskHandler {

	protected TaskHandler() {
		registeredTasks = new HashMap<Long, Task>();
	}

	public static TaskHandler getTaskHandlerInstance() {
		if(taskHandlerInstance == null) {
			taskHandlerInstance = new TaskHandler();
		}

		return taskHandlerInstance;
	}

	/**
	 * Registers maintenance task modules
	 *  called upon deploying a task module
	 *  adds the task to the database
	 *  adds the task to the tasklist
	 *  
	 * @param task: the deployed task
	 */
	public void registerTask(Task task) throws PortalException {
		TaskEntry taskEntry = 
			TaskEntryUtil.findByTasksByName(task.getTaskName());

		if(Validator.isNull(taskEntry)) {
			taskEntry =
				TaskEntryLocalServiceUtil.addTaskEntry(task.getTaskName());
		}

		task.setTaskId(taskEntry.getTaskId());

		registeredTasks.put(task.getTaskId(), task);
	}

	/**
	 * Unregister task modules
	 * 	Called upon undeploying a task module
	 * 	Removes the task from the task list
	 * 	Remove it from the database
	 * 
	 * @param task: the undeployed task
	 */
	public void unregisterTask(Task task) throws PortalException {
		TaskEntryLocalServiceUtil.deleteTaskEntry(task.getTaskId());
		registeredTasks.remove(task);
	}

	/**
	 * Returns the list of the maintenance tasks for which the wiki page with
	 * the given id is not yet nominated for voting. If a task is not in the
	 * list the voting should be displayed.
	 * 
	 * @param wikiPageId
	 * @throws PortalException
	 */
	public List<Task> getAvailableFlags(long wikiPageId) 
		throws PortalException {

		List<Task> availableFlags = new ArrayList<Task>();

		CandidateEntry candidate =
			CandidateEntryUtil.findByWikiPageId(wikiPageId);

		for(Task task : registeredTasks.values()) {
			try {
				CandidateMaintenanceUtil.findByC_T(
					candidate.getEntryId(), task.getTaskId());
			}
			catch (NoSuchCandidateMaintenanceException e) {
				availableFlags.add(task);
			}
		}

		return availableFlags;
	}

	public Map<Long, Task> getTaskEntries() {
		return registeredTasks;
	}

	public List<Task> getTaskEntryList() {
		return ListUtil.fromCollection(registeredTasks.values());
	}

	/**
	 * Returns the vote of the user on the given maintenance task for the
	 * current wiki page, upon visiting the page
	 * 
	 * @param userId: the visiting user's id
	 * @param wikiPageId: the visited wiki page's id
	 * @param taskId: the current task's id
	 * @return the vote
	 * @throws PortalException
	 */
	public int getVote(long userId, long wikiPageId, long taskId)
		throws PortalException {

		CandidateEntry candidateEntry =
			CandidateEntryUtil.findByWikiPageId(wikiPageId);

		CandidateMaintenance canMain =
			CandidateMaintenanceUtil.findByC_T(
				candidateEntry.getEntryId(), taskId);

		AnalysisEntry analysisEntry;

		analysisEntry = AnalysisEntryUtil.findByCanMainId(
			canMain.getCandidateMaintenanceId());

		long analysisId = analysisEntry.getAnalysisId();

		try {
			AnalysisUser analysisUser = 
				AnalysisUserUtil.findByA_U(analysisId, userId);
			
			return analysisUser.getVoted();
		} catch (NoSuchUserException e) {
			AnalysisUserLocalServiceUtil.addAnalysisUser(
				analysisId, userId, VoteConstants.NOT_VOTED);
		}

		return VoteConstants.NOT_VOTED;
	}

	/**
	 * Stores a user's vote and updates the analysis belonging to the task in 
	 * question.
	 * 
	 * @param userId: the visiting user's id
	 * @param wikiPageId: the visited wiki page's id
	 * @param taskId: the current task's id
	 * @param vote: the user's decision
	 * @throws PortalException
	 */
	public void vote(long userId, long wikiPageId, long taskId, int vote) 
		throws PortalException {

		CandidateEntry candidateEntry =
				CandidateEntryUtil.findByWikiPageId(wikiPageId);

		CandidateMaintenance canMain =
			CandidateMaintenanceUtil.findByC_T(
				candidateEntry.getEntryId(), taskId);

		AnalysisEntry analysisEntry;

		analysisEntry = AnalysisEntryUtil.findByCanMainId(
			canMain.getCandidateMaintenanceId());

		long analysisId = analysisEntry.getAnalysisId();

		AnalysisUser analysisUser = 
			AnalysisUserUtil.findByA_U(analysisId, userId);

		int previousVote = analysisUser.getVoted();

		analysisUser.setVoted(vote);
		analysisUser.persist();

		String analysisData = analysisEntry.getAnalysisData();
		analysisData = VotesJSONSerializer.updateVotes(
			analysisData, previousVote, vote);

		analysisEntry.setAnalysisData(analysisData);
		analysisEntry.persist();
	}

	public void setTaskEntries(Map<Long,Task> taskEntries) {
		this.registeredTasks = taskEntries;
	}

	private Map<Long, Task> registeredTasks;
	private static TaskHandler taskHandlerInstance = null;
}

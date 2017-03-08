package com.liferay.micro.maintainance.task;

import com.liferay.bnd.util.ConfigurableUtil;
import com.liferay.micro.maintainance.action.Action;
import com.liferay.micro.maintainance.configuration.MicroMaintenanceConfiguration;
import com.liferay.micro.maintainance.task.model.TaskEntry;
import com.liferay.micro.maintainance.task.service.TaskEntryLocalServiceUtil;
import com.liferay.micro.maintainance.task.service.persistence.TaskEntryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

public class TaskHandler {

	protected TaskHandler() {
		registeredTasks = new ArrayList<Task>();
	}

	public static TaskHandler getTaskHandlerInstance() {
		if(taskHandlerInstance == null) {
			taskHandlerInstance = new TaskHandler();
		}

		return taskHandlerInstance;
	}

	/*
	 * Calls the analysis
	 */
	public List<Action> callAnalysis(Task task, long analysisId) {
		return task.analyze(analysisId);
	}

	/*
	 * Register maintenance task modules
	 *  called upon deploying a task module
	 *  adds the task to the database
	 *  adds the task to the tasklist
	 */
	public void registerTask(Task task) throws PortalException {
		TaskEntry taskEntry = 
			TaskEntryUtil.findByTasksByName(task.getTaskName());

		if(Validator.isNull(taskEntry)) {
			taskEntry =
				TaskEntryLocalServiceUtil.addTaskEntry(task.getTaskName());
		}

		task.setTaskId(taskEntry.getTaskId());

		registeredTasks.add(task);
	}

	/*
	 * Unregister task modules
	 * 	Called upon undeploying a task module
	 * 	Removes the task from the task list
	 * 	Remove it from the database
	 */
	public void unregisterTask(Task task) throws PortalException {
		TaskEntryLocalServiceUtil.deleteTaskEntry(task.getTaskId());
		registeredTasks.remove(task);
	}

	public List<Task> getTaskEntries() {
		return registeredTasks;
	}

	public void setTaskEntries(List<Task> taskEntries) {
		this.registeredTasks = taskEntries;
	}

	private List<Task> registeredTasks;
	private static TaskHandler taskHandlerInstance = null;
}

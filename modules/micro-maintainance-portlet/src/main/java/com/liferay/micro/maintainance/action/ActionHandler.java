package com.liferay.micro.maintainance.action;

import java.util.List;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.analysis.service.AnalysisEntryLocalServiceUtil;

public class ActionHandler {

	public static void performActions(
		List<Action> actions, AnalysisEntry analysisEntry) {

		for (Action action: actions) {
			action.performAction(analysisEntry);
		}
	}
}

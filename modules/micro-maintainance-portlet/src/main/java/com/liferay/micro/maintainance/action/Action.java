package com.liferay.micro.maintainance.action;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;

public interface Action {
	public boolean performAction(AnalysisEntry analysisEntry);
}

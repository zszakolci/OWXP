package com.liferay.micro.maintainance.action;

import java.util.Map;

public interface Action {
	public boolean performAction(Map<Object, Object> parameterMap);
}

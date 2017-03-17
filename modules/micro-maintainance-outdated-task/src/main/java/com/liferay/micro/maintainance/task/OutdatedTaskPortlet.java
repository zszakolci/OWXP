package com.liferay.micro.maintainance.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import com.liferay.micro.maintainance.configuration.OutdatedTaskConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=micro-maintainance-outdated-task Portlet",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OutdatedTaskPortlet extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
		throws PortletException, IOException {

		PrintWriter printWriter = response.getWriter();

		printWriter.print("micro-maintainance-outdated-task Portlet - Hello World!");
	}

	@Activate
	protected void activate(Map<String, Object> properties) throws PortalException {
		_configuration = ConfigurableUtil.createConfigurable(
			OutdatedTaskConfiguration.class, properties);

		outdatedTask = OutdatedTask.getOutdatedTaskInstance();

		configureTask();

		TaskHandler.getTaskHandlerInstance().registerTask(outdatedTask);
	}

	@Modified
	protected void modified(Map<String,Object> config) {
		configureTask();
	}


	@Deactivate
	protected void deactivate() throws PortalException {

		TaskHandler.getTaskHandlerInstance().unregisterTask(outdatedTask);
	}

	private void configureTask() {
		outdatedTask.setRequiredVotingPercentage(
			_configuration.requiredVotingPercentage());
		outdatedTask.setRequiredYesVotesPercentage(
			_configuration.requiredYesVotesPercentage());
		outdatedTask.setVotingPeriodDays(_configuration.votingPeriodDays());
	}

	private static OutdatedTask outdatedTask;
	private volatile OutdatedTaskConfiguration _configuration;
}
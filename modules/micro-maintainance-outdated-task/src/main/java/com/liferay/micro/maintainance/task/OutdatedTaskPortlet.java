package com.liferay.micro.maintainance.task;

import com.liferay.portal.kernel.exception.PortalException;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
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

	@Activate
	protected void activate() throws PortalException {
		outdatedTask = OutdatedTask.getOutdatedTaskInstance();
		TaskHandler.getTaskHandlerInstance().registerTask(outdatedTask);
	}

	@Deactivate
	protected void deactivate() throws PortalException {
		TaskHandler.getTaskHandlerInstance().unregisterTask(outdatedTask);
	}

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		PrintWriter printWriter = response.getWriter();

		printWriter.print(
			"micro-maintainance-outdated-task Portlet - Hello World!");
	}

	private static OutdatedTask outdatedTask;

}
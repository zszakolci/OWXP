package com.liferay.social.activity.customizer.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.social.activities.constants.SocialActivitiesPortletKeys;
import com.liferay.social.activities.web.internal.constants.SocialActivitiesWebKeys;
import com.liferay.social.activity.customizer.query.helper.CustomSocialActivitiesQueryHelper;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Istvan Sajtos
 */
@Component(
	property = {
		"javax.portlet.name=" + SocialActivitiesPortletKeys.SOCIAL_ACTIVITIES,
		"mvc.command.name=/", "service.ranking:Integer=100"
	},
	service = MVCRenderCommand.class
)
public class CustomViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		renderRequest.setAttribute(
			SocialActivitiesWebKeys.SOCIAL_ACTIVITIES_QUERY_HELPER,
			_customSocialActivitiesQueryHelper);

		return "/view.jsp";
	}

	@Reference(unbind = "-")
	protected void setSocialActivitiesQueryHelper(
		CustomSocialActivitiesQueryHelper customSocialActivitiesQueryHelper) {

		_customSocialActivitiesQueryHelper = customSocialActivitiesQueryHelper;
	}

	@Reference(
		target = "(component.name=com.liferay.social.activities.web.internal.portlet.action.ViewMVCRenderCommand)"
	)
	protected MVCRenderCommand mvcRenderCommand;

	private CustomSocialActivitiesQueryHelper
		_customSocialActivitiesQueryHelper;

}
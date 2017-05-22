package recommendedpages.action;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.WebKeys;

import recommendedpages.portlet.RecommendedPagesPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Zsolt Szabo
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + RecommendedPagesPortletKeys.RECOMMENDEDPAGES,
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class RecommendedPagesMVCRenderCommand implements MVCRenderCommand {

	public static final String PATH = "RecommendedPages";

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		template.put("getRecommendedPagesURL", getGetRecommendedPagesURL(renderResponse));

		template.put("portletNamespace", renderResponse.getNamespace());

		return PATH;
	}

	protected String getGetRecommendedPagesURL(RenderResponse renderResponse) {
		ResourceURL portletURL = renderResponse.createResourceURL();

		portletURL.setResourceID("get_recommended_pages");

		return portletURL.toString();
	}

}

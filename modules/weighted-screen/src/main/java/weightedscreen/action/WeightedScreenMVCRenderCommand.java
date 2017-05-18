package weightedscreen.action;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.WebKeys;

import weightedscreen.portlet.WeightedScreenPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Zsolt Szabo
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + WeightedScreenPortletKeys.WEIGHTEDSCREEN,
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class WeightedScreenMVCRenderCommand implements MVCRenderCommand {

	public static final String PATH = "WeightedScreen";

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		template.put("getWikiPagesURL", getGetWikiPagesURL(renderResponse));

		template.put("portletNamespace", renderResponse.getNamespace());

		return PATH;
	}

	protected String getGetWikiPagesURL(RenderResponse renderResponse) {
		ResourceURL portletURL = renderResponse.createResourceURL();

		portletURL.setResourceID("get_wiki_pages");

		return portletURL.toString();
	}

}

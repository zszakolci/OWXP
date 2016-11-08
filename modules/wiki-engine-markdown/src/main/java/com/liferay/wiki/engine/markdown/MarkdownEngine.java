package com.liferay.wiki.engine.markdown;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.portal.kernel.portlet.Router;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.wiki.configuration.WikiGroupServiceConfiguration;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.engine.WikiEngine;
import com.liferay.wiki.engine.input.editor.common.BaseInputEditorWikiEngine;
import com.liferay.wiki.engine.markdown.pegdown.ast.LiferayPegDownProcessor;
import com.liferay.wiki.exception.NoSuchNodeException;
import com.liferay.wiki.exception.PageContentException;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiNodeLocalService;

import java.util.Collections;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import org.parboiled.Parboiled;

import org.pegdown.Extensions;
import org.pegdown.LiferayParser;
import org.pegdown.LinkRenderer;

@Component(service = WikiEngine.class)
public class MarkdownEngine extends BaseInputEditorWikiEngine {

	@Override
	public String convert(
			WikiPage page, PortletURL viewPageURL, PortletURL editPageURL,
			String attachmentURLPrefix)
		throws PageContentException {

		return _liferayPegDownProcessor.get().markdownToHtml(
				page.getContent(), new LinkRenderer());
	}

	@Override
	public String getEditorName() {
		return "simple"; //TODO
	}

	@Override
	public String getFormat() {
		return "markdown";
	}

	@Override
	public String getHelpPageTitle(HttpServletRequest request) {
		return null;
	}

	@Override
	public String getHelpURL() {
		return null;
	}

	@Override
	public Map<String, Boolean> getOutgoingLinks(WikiPage page)
		throws PageContentException {

		//try {
			return Collections.EMPTY_MAP;
		//}
		/*catch (PortalException pe) {
			throw new PageContentException(pe);
		}*/
	}

	@Override
	public String getToolbarSet() {
		return null;
	}

	@Override
	protected ServletContext getHelpPageServletContext() {
		return null;
	}

	@Override
	protected ResourceBundleLoader getResourceBundleLoader() {
		return ResourceBundleLoaderUtil.getPortalResourceBundleLoader();
	}

	@Reference(
		target = "(javax.portlet.name=" + WikiPortletKeys.WIKI + ")",
		unbind = "-"
	)
	protected void setFriendlyURLMapper(FriendlyURLMapper friendlyURLMapper) {
		_friendlyURLMapping =
			Portal.FRIENDLY_URL_SEPARATOR + friendlyURLMapper.getMapping();

		_router = friendlyURLMapper.getRouter();
	}

	@Reference
	protected void setWikiGroupServiceConfiguration(
		WikiGroupServiceConfiguration wikiGroupServiceConfiguration) {

		_wikiGroupServiceConfiguration = wikiGroupServiceConfiguration;
	}

	@Reference(unbind = "-")
	protected void setWikiNodeLocalService(
		WikiNodeLocalService wikiNodeLocalService) {

		_wikiNodeLocalService = wikiNodeLocalService;
	}

	@Activate
	protected void activate() {
		_liferayPegDownProcessor =
			new ThreadLocal<LiferayPegDownProcessor>() {
				@Override
				protected LiferayPegDownProcessor initialValue() {
					LiferayParser liferayParser = Parboiled.createParser(
							LiferayParser.class, Extensions.ALL & ~Extensions.HARDWRAPS);
	
					return new LiferayPegDownProcessor(liferayParser);
				}
			
			};
	}

	@Deactivate
	protected void deactivate() {
		_liferayPegDownProcessor = null;
	}

	private static final Log _log = LogFactoryUtil.getLog(MarkdownEngine.class);

	private static ThreadLocal<LiferayPegDownProcessor> _liferayPegDownProcessor;

	private String _friendlyURLMapping;
	private Router _router;
	private WikiGroupServiceConfiguration _wikiGroupServiceConfiguration;
	private WikiNodeLocalService _wikiNodeLocalService;
}
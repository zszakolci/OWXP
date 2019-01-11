/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.wiki.engine.markdown;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.portal.kernel.portlet.Router;
import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.language.LanguageResources;
import com.liferay.wiki.configuration.WikiGroupServiceConfiguration;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.engine.WikiEngine;
import com.liferay.wiki.engine.input.editor.common.BaseInputEditorWikiEngine;
import com.liferay.wiki.exception.PageContentException;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiNodeLocalService;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.ext.gitlab.GitLabExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.toc.TocExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.Parser.Builder;
import com.vladsch.flexmark.superscript.SuperscriptExtension;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Norbert Kocsis
 */
@Component(service = WikiEngine.class)
public class MarkdownEngine extends BaseInputEditorWikiEngine {

	@Override
	public String convert(
			WikiPage page, PortletURL viewPageURL, PortletURL editPageURL,
			String attachmentURLPrefix)
		throws PageContentException {

		Parser parser = _parserThreadLocal.get();
		HtmlRenderer renderer = _rendererThreadLocal.get();

		Node document = parser.parse(page.getContent());

		return renderer.render(document);
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
		return "https://daringfireball.net/projects/markdown/syntax";
	}

	@Override
	public Map<String, Boolean> getOutgoingLinks(WikiPage page)
		throws PageContentException {

		String content = convert(page, null, null, null);

		if (Validator.isNull(content)) {
			return Collections.emptyMap();
		}

		Map<String, Boolean> links = new HashMap<>();

		Source source = new Source(content);

		List<StartTag> startTags = source.getAllStartTags("a");

		for (StartTag startTag : startTags) {
			String href = startTag.getAttributeValue("href");

			if (Validator.isNull(href)) {
				continue;
			}

			int pos = href.lastIndexOf(_friendlyURLMapping);

			if (pos == -1) {
				continue;
			}

			String friendlyURL = href.substring(
				pos + _friendlyURLMapping.length());

			if (friendlyURL.endsWith(StringPool.SLASH)) {
				friendlyURL = friendlyURL.substring(
					0, friendlyURL.length() - 1);
			}

			Map<String, String> routeParameters = new HashMap<>();

			if (!_router.urlToParameters(friendlyURL, routeParameters)) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"No route could be found to match URL " + friendlyURL);
				}

				continue;
			}

			String title = routeParameters.get("title");
			String nodeName = routeParameters.get("nodeName");

			if (Validator.isNull(title) || Validator.isNull(nodeName)) {
				continue;
			}

			try {
				_wikiNodeLocalService.getNode(page.getGroupId(), nodeName);

				links.put(StringUtil.toLowerCase(title), Boolean.TRUE);
			}
			catch (PortalException pe) {
				if (_log.isWarnEnabled()) {
					_log.warn(pe.getMessage());
				}
			}
		}

		return links;
	}

	@Override
	public String getToolbarSet() {
		return null;
	}

	@Activate
	protected void activate() {
		_parserThreadLocal = new ThreadLocal<Parser>() {

			@Override
			protected Parser initialValue() {
				MutableDataSet options = _getOptions();

				Builder builder = Parser.builder(options);

				return builder.build();
			}

		};

		_rendererThreadLocal = new ThreadLocal<HtmlRenderer>() {

			@Override
			protected HtmlRenderer initialValue() {
				MutableDataSet options = _getOptions();

				HtmlRenderer.Builder builder = HtmlRenderer.builder(options);

				HtmlRenderer renderer = builder.build();

				return renderer;
			}

		};
	}

	@Deactivate
	protected void deactivate() {
		_parserThreadLocal = null;
		_rendererThreadLocal = null;
	}

	@Override
	protected ServletContext getHelpPageServletContext() {
		return null;
	}

	@Override
	protected ResourceBundleLoader getResourceBundleLoader() {
		return _resourceBundleLoader;
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

	@Reference(target = "(bundle.symbolic.name=owxp.lang)", unbind = "-")
	protected void setResourceBundleLoader(
		ResourceBundleLoader resourceBundleLoader) {

		_resourceBundleLoader = new AggregateResourceBundleLoader(
			resourceBundleLoader, LanguageResources.RESOURCE_BUNDLE_LOADER);
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

	private MutableDataSet _getOptions() {
		MutableDataSet options = new MutableDataSet();

		// uncomment to set optional extensions

		options.set(
			Parser.EXTENSIONS,
			Arrays.asList(
				AutolinkExtension.create(), EmojiExtension.create(),
				FootnoteExtension.create(), GitLabExtension.create(),
				StrikethroughExtension.create(), SuperscriptExtension.create(),
				TablesExtension.create(), TaskListExtension.create(),
				TocExtension.create()));

		options.set(
			EmojiExtension.ROOT_IMAGE_PATH, "/o/grow-theme/images/emojis/");

		// Use 2 dashes to be compatible with StackEdit

		options.set(TablesExtension.MIN_SEPARATOR_DASHES, 1);

		// uncomment to convert soft-breaks to hard breaks

		options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

		return options;
	}

	private static final Log _log = LogFactoryUtil.getLog(MarkdownEngine.class);

	private String _friendlyURLMapping;
	private ThreadLocal<Parser> _parserThreadLocal;
	private ThreadLocal<HtmlRenderer> _rendererThreadLocal;
	private ResourceBundleLoader _resourceBundleLoader;
	private Router _router;
	private WikiGroupServiceConfiguration _wikiGroupServiceConfiguration;
	private WikiNodeLocalService _wikiNodeLocalService;

}
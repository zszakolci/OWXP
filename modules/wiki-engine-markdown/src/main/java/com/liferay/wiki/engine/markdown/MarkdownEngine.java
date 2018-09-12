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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.wiki.engine.BaseWikiEngine;
import com.liferay.wiki.engine.WikiEngine;
import com.liferay.wiki.exception.PageContentException;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.model.WikiPage;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.gfm.issues.GfmIssuesExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.ext.gfm.users.GfmUsersExtension;
import com.vladsch.flexmark.ext.gitlab.GitLabExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.toc.TocExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.Parser.Builder;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.io.IOException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletURL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Norbert Kocsis
 * @author Tamas Molnar
 */
@Component(immediate = true, service = WikiEngine.class)
public class MarkdownEngine extends BaseWikiEngine {

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
		return "https://github.github.com/gfm/";
	}

	@Override
	public Map<String, Boolean> getOutgoingLinks(WikiPage page)
		throws PageContentException {

		return new HashMap<>();
	}

	@Override
	public String getToolbarSet() {
		return null;
	}

	@Override
	public void renderEditPage(
			ServletRequest servletRequest, ServletResponse servletResponse,
			WikiNode node, WikiPage page)
		throws IOException, ServletException {

		servletRequest.setAttribute("markdown", "true");

		super.renderEditPage(servletRequest, servletResponse, node, page);
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
	protected ServletContext getEditPageServletContext() {
		return _servletContext;
	}

	@Override
	protected ServletContext getHelpPageServletContext() {
		return null;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.wiki.engine.text)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private MutableDataSet _getOptions() {
		MutableDataSet options = new MutableDataSet();

		// uncomment to set optional extensions

		options.set(
			Parser.EXTENSIONS,
			Arrays.asList(
				AutolinkExtension.create(), EmojiExtension.create(),
				GitLabExtension.create(), GfmIssuesExtension.create(),
				GfmUsersExtension.create(), StrikethroughExtension.create(),
				TablesExtension.create(), TaskListExtension.create(),
				TocExtension.create()));

		options.set(
			EmojiExtension.ROOT_IMAGE_PATH, "/o/grow-theme/images/emojis/");

		// Use 2 dashes to be compatible with StackEdit

		options.set(TablesExtension.MIN_SEPARATOR_DASHES, 2);

		// uncomment to convert soft-breaks to hard breaks

		options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

		return options;
	}

	private static final Log _log = LogFactoryUtil.getLog(MarkdownEngine.class);

	private ThreadLocal<Parser> _parserThreadLocal;
	private ThreadLocal<HtmlRenderer> _rendererThreadLocal;
	private ServletContext _servletContext;

}
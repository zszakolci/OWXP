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

package com.liferay.mentions.web.editor.configuration;

import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.wiki.constants.WikiPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Norbert Kocsis
 */
@Component(
	property = {
		"editor.config.key=contentEditor", "editor.name=alloyeditor_creole",
		"editor.name=ckeditor", "javax.portlet.name=" + WikiPortletKeys.WIKI,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_DISPLAY,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_ADMIN,
		"service.ranking:Integer=10"
	},
	service = EditorConfigContributor.class
)
public class WikiPageMentionsEditorConfigContributor
	extends BaseMentionsEditorConfigContributor {
}
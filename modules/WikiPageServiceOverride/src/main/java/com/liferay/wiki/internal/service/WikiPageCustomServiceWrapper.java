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

package com.liferay.wiki.internal.service;

import org.osgi.service.component.annotations.Component;

import com.liferay.exportimport.kernel.lar.ExportImportThreadLocal;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalService;
import com.liferay.wiki.service.WikiPageLocalServiceWrapper;

/**
 * @author Istvan Sajtos
 * @author Norbert Kocsis
 * @author Tamas Molnar
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class WikiPageCustomServiceWrapper extends WikiPageLocalServiceWrapper {

	public WikiPageCustomServiceWrapper() {
		super(null);
	}

	public WikiPageCustomServiceWrapper(
		WikiPageLocalService wikiPageLocalService) {

		super(wikiPageLocalService);
	}

	@Override
	public WikiPage addPage(
			long userId, long nodeId, String title, double version,
			String content, String summary, boolean minorEdit, String format,
			boolean head, String parentTitle, String redirectTitle,
			ServiceContext serviceContext)
		throws PortalException {

		WikiPage page = super.addPage(
			userId, nodeId, title, version, content, summary, minorEdit, format,
			head, parentTitle, redirectTitle, serviceContext);

		if (!ExportImportThreadLocal.isImportInProcess()) {
			super.subscribePage(userId, nodeId, title);
		}

		return page;
	}

	@Override
	public WikiPage addPage(
			long userId, long nodeId, String title, String content,
			String summary, boolean minorEdit, ServiceContext serviceContext)
		throws PortalException {

		WikiPage page = super.addPage(
			userId, nodeId, title, content, summary, minorEdit, serviceContext);

		if (!ExportImportThreadLocal.isImportInProcess()) {
			super.subscribePage(userId, nodeId, title);
		}

		return page;
	}

}
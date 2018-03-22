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

package com.liferay.grow.wiki.helper.service;

import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Tamas Molnar
 */
public interface WikiHelperService {

	public JSONObject getChildWikiPages(long nodeId, String title)
		throws PortalException;

	public Map<String, String> getLinkedPages(long nodeId, String title)
		throws PortalException;

	public JSONObject getParentWikiPage(long nodeId, String title)
		throws PortalException;

	public JSONObject getWikiPageContributors(long nodeId, String title)
		throws PortalException;

}
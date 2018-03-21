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

package com.liferay.grow.wiki.helper.service.impl;

import com.liferay.grow.wiki.helper.comparator.PageModifiedDateComparator;
import com.liferay.grow.wiki.helper.service.WikiHelperService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalService;
import com.liferay.wiki.util.comparator.PageVersionComparator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tamas Molnar
 */
@Component(immediate = true, service = WikiHelperService.class)
public class WikiHelperServiceImpl implements WikiHelperService {

	@Override
	public JSONObject getChildWikiPages(long nodeId, String title)
		throws PortalException {

		JSONObject childWikiPagesJSONObject =
			JSONFactoryUtil.createJSONObject();

		WikiPage wikiPage = _wikiPageLocalService.getPage(nodeId, title);

		long childPagesCount = _wikiPageLocalService.getChildrenCount(
			wikiPage.getNodeId(), true, wikiPage.getTitle());

		childWikiPagesJSONObject.put("childPagesCount", childPagesCount);

		List<WikiPage> childPages = _wikiPageLocalService.getChildren(
			wikiPage.getNodeId(), true, wikiPage.getTitle(),
			WorkflowConstants.STATUS_APPROVED, 0, 15,
			new PageModifiedDateComparator());

		JSONArray childPagesJSONArray = JSONFactoryUtil.createJSONArray();

		for (WikiPage childPage : childPages) {
			childPagesJSONArray.put(getWikiPageJSONObject(childPage));
		}

		childWikiPagesJSONObject.put("childPages", childPagesJSONArray);

		return childWikiPagesJSONObject;
	}

	@Override
	public JSONObject getParentWikiPage(long nodeId, String title)
		throws PortalException {

		WikiPage wikiPage = _wikiPageLocalService.getPage(nodeId, title);

		return getWikiPageJSONObject(wikiPage.getParentPage());
	}

	public JSONObject getWikiPageContributors(long nodeId, String title)
		throws PortalException {

		JSONObject contributorsJSONObject = JSONFactoryUtil.createJSONObject();

		List<WikiPage> wikiPages = _wikiPageLocalService.getPages(
			nodeId, title, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			new PageVersionComparator(true));

		WikiPage firstWikiPage = wikiPages.get(0);

		long authorUserId = firstWikiPage.getStatusByUserId();

		contributorsJSONObject.put(
			"author",
			getUserNameDateJSONObject(
				authorUserId, firstWikiPage.getStatusDate()));

		Map<Long, Date> contributorsMap = new HashMap<>();

		for (WikiPage wikiPage : wikiPages) {
			if (wikiPage.getStatusByUserId() == authorUserId) {
				continue;
			}

			contributorsMap.put(
				wikiPage.getStatusByUserId(), wikiPage.getStatusDate());
		}

		JSONArray editorsJSONArray = JSONFactoryUtil.createJSONArray();

		for (Map.Entry<Long, Date> entry : contributorsMap.entrySet()) {
			editorsJSONArray.put(
				getUserNameDateJSONObject(entry.getKey(), entry.getValue()));
		}

		contributorsJSONObject.put("contributors", editorsJSONArray);

		return contributorsJSONObject;
	}

	protected JSONObject getUserNameDateJSONObject(long userId, Date date)
		throws PortalException {

		JSONObject userJSONObject = JSONFactoryUtil.createJSONObject();

		User user = _userLocalService.getUser(userId);

		userJSONObject.put("date", date);
		userJSONObject.put("userScreenName", user.getScreenName());

		return userJSONObject;
	}

	protected JSONObject getWikiPageJSONObject(WikiPage wikiPage) {
		JSONObject wikiPageJSONObject = JSONFactoryUtil.createJSONObject();

		String title = StringPool.BLANK;

		if (wikiPage != null) {
			title = wikiPage.getTitle();
		}

		wikiPageJSONObject.put("title", title);

		return wikiPageJSONObject;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	@Reference(unbind = "-")
	protected void setWikiPageLocalService(
		WikiPageLocalService wikiPageLocalService) {

		_wikiPageLocalService = wikiPageLocalService;
	}

	private UserLocalService _userLocalService;
	private WikiPageLocalService _wikiPageLocalService;

}
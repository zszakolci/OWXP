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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.wiki.escape.WikiEscapeUtil;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalService;
import com.liferay.wiki.util.comparator.PageVersionComparator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	public JSONObject getLinkedPages(long nodeId, String title)
		throws PortalException {

		WikiPage wikiPage = _wikiPageLocalService.getPage(nodeId, title);

		Map<String, String> linkedPages = fillLinkedPages(wikiPage);

		List<WikiPage> linkedWikiPages = new ArrayList<>();

		for (String linkedWikiPageTitle : linkedPages.keySet()) {
			WikiPage linkedWikiPage = _wikiPageLocalService.fetchPage(
				nodeId, linkedWikiPageTitle);

			if (linkedWikiPage != null) {
				linkedWikiPages.add(linkedWikiPage);
			}
			else {
				if (_log.isWarnEnabled()) {
					_log.warn("No linked WikiPage exists with title " + title);
				}
			}
		}

		JSONObject linkedWikiPagesJSONObject =
			JSONFactoryUtil.createJSONObject();

		linkedWikiPagesJSONObject.put(
			"linkedPagesCount", linkedWikiPages.size());

		JSONArray linkedPagesJSONArray = JSONFactoryUtil.createJSONArray();

		for (WikiPage linkedPage : linkedWikiPages) {
			linkedPagesJSONArray.put(getWikiPageJSONObject(linkedPage));

			if (linkedWikiPages.size() == 10) {
				break;
			}
		}

		linkedWikiPagesJSONObject.put("linkedPages", linkedPagesJSONArray);

		return linkedWikiPagesJSONObject;
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

		Map<Long, Date> contributorsMap = new HashMap<>();
		Map<Long, Long> contributorsCountMap = new HashMap<>();

		for (WikiPage wikiPage : wikiPages) {
			long userId = wikiPage.getStatusByUserId();

			long count = 1;

			if (contributorsCountMap.get(userId) != null) {
				count = contributorsCountMap.get(userId) + 1;
			}

			contributorsCountMap.put(userId, count);

			if (userId == authorUserId) {
				continue;
			}

			contributorsMap.put(userId, wikiPage.getStatusDate());
		}

		contributorsJSONObject.put(
			"author",
			getUserNameDateJSONObject(
				authorUserId, firstWikiPage.getStatusDate(),
				contributorsCountMap));

		JSONArray editorsJSONArray = JSONFactoryUtil.createJSONArray();

		for (Map.Entry<Long, Date> entry : contributorsMap.entrySet()) {
			editorsJSONArray.put(
				getUserNameDateJSONObject(
					entry.getKey(), entry.getValue(), contributorsCountMap));
		}

		contributorsJSONObject.put("contributors", editorsJSONArray);

		return contributorsJSONObject;
	}

	protected Map<String, String> fillLinkedPages(WikiPage wikiPage)
		throws PortalException {

		Map<String, String> linkedPages = new TreeMap<>();

		String content = wikiPage.getContent();

		if (wikiPage.getFormat().equals("creole")) {
			_addLinksCreole(content, linkedPages);
		}
		else if (wikiPage.getFormat().equals("html")) {
			_addLinksHTML(content, linkedPages);
		}
		else if (wikiPage.getFormat().equals("markdown")) {
			_addLinksMarkdown(content, linkedPages);
		}

		return linkedPages;
	}

	protected JSONObject getUserNameDateJSONObject(
			long userId, Date date, Map<Long, Long> contributorsCountMap)
		throws PortalException {

		JSONObject userJSONObject = JSONFactoryUtil.createJSONObject();

		User user = _userLocalService.getUser(userId);

		userJSONObject.put("count", contributorsCountMap.get(userId));
		userJSONObject.put("date", date);
		userJSONObject.put("userFullName", user.getFullName());
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

	private void _addLink(String link, Map<String, String> linkedPages) {
		if (!link.contains(_GROW_URL + _PUBLIC_PAGE)) {
			String title = link.substring(link.lastIndexOf('/') + 1);

			title = title.replace('+', CharPool.SPACE);

			if (title.contains("#section")) {
				title = title.substring(0, title.indexOf("#section"));
			}

			title = WikiEscapeUtil.unescapeName(title);

			linkedPages.put(title, link);
		}
	}

	private void _addLinksCreole(
		String content, Map<String, String> linkedPages) {

		while (content.indexOf(_GROW_URL) > 0) {
			content = content.substring(content.indexOf(_GROW_URL));

			String link = content.substring(0, content.indexOf("]]"));

			if (link.contains("|")) {
				link = link.substring(0, link.indexOf("|"));
			}

			_addLink(link, linkedPages);

			content = content.substring(content.indexOf("]]") + 2);
		}
	}

	private void _addLinksHTML(
		String content, Map<String, String> linkedPages) {

		while (content.indexOf(_GROW_URL) > 0) {
			content = content.substring(content.indexOf(_GROW_URL));

			String link = content.substring(0, content.indexOf("\">"));

			_addLink(link, linkedPages);

			content = content.substring(content.indexOf("</a>") + 4);
		}
	}

	private void _addLinksMarkdown(
		String content, Map<String, String> linkedPages) {

		content = content.replace(CharPool.NEW_LINE, CharPool.SPACE).replace(
			CharPool.CLOSE_BRACKET, CharPool.SPACE);

		String[] contentElements = StringUtil.split(content, CharPool.SPACE);

		for (String element : contentElements) {
			if (element.contains(_GROW_URL)) {
				if (element.startsWith("(")) {
					element = element.substring(1);
				}

				if (element.endsWith(")")) {
					element = element.substring(0, element.length() - 1);
				}

				_addLink(element, linkedPages);
			}
		}
	}

	private static final String _GROW_URL = "https://grow.liferay.com/";

	private static final String _PUBLIC_PAGE = "web";

	private static final Log _log = LogFactoryUtil.getLog(
		WikiHelperServiceImpl.class);

	private UserLocalService _userLocalService;
	private WikiPageLocalService _wikiPageLocalService;

}
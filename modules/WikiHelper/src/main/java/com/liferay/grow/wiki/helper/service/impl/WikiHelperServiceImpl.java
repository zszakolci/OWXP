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
import java.util.Comparator;
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

		JSONArray childPagesJSONArray = JSONFactoryUtil.createJSONArray();

		long childPagesCount = 0;

		try {
			WikiPage wikiPage = _wikiPageLocalService.getPage(nodeId, title);

			childPagesCount = _wikiPageLocalService.getChildrenCount(
				wikiPage.getNodeId(), true, wikiPage.getTitle());

			List<WikiPage> childPages = _wikiPageLocalService.getChildren(
				wikiPage.getNodeId(), true, wikiPage.getTitle(),
				WorkflowConstants.STATUS_APPROVED, 0, 60,
				new PageModifiedDateComparator());

			for (WikiPage childPage : childPages) {
				childPagesJSONArray.put(getWikiPageJSONObject(childPage));
			}
		}
		catch (Exception e) {
			_log.error("Cannot create childWikiPagesJSONObject ", e);
		}

		childWikiPagesJSONObject.put("childPages", childPagesJSONArray);
		childWikiPagesJSONObject.put("childPagesCount", childPagesCount);

		return childWikiPagesJSONObject;
	}

	@Override
	public JSONObject getLinkedPages(long nodeId, String title)
		throws PortalException {

		JSONObject linkedWikiPagesJSONObject =
			JSONFactoryUtil.createJSONObject();

		JSONArray linkedPagesJSONArray = JSONFactoryUtil.createJSONArray();

		try {
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
						_log.warn(
							"No linked WikiPage exists with title " + title);
					}
				}
			}

			for (WikiPage linkedPage : linkedWikiPages) {
				linkedPagesJSONArray.put(getWikiPageJSONObject(linkedPage));

				if (linkedWikiPages.size() == 60) {
					break;
				}
			}
		}
		catch (Exception e) {
			_log.error("Cannot create linkedWikiPagesJSONObject ", e);
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
		JSONArray editorsJSONArray = JSONFactoryUtil.createJSONArray();
		JSONObject creatorJSONObject = JSONFactoryUtil.createJSONObject();

		try {
			Map<Long, Contributor> contributorsMap = new HashMap<>();

			List<WikiPage> wikiPages = _wikiPageLocalService.getPages(
				nodeId, title, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new PageVersionComparator(true));

			for (WikiPage wikiPage : wikiPages) {
				long userId = wikiPage.getStatusByUserId();

				try {
					_userLocalService.getUser(userId);
				}
				catch (Exception e) {
					continue;
				}

				Contributor contributor = null;

				if (contributorsMap.containsKey(userId)) {
					contributor = contributorsMap.get(userId);

					contributor.count++;
				}
				else {
					contributor = new Contributor(userId);

					contributorsMap.put(userId, contributor);
				}
			}

			WikiPage firstWikiPage = wikiPages.get(0);

			Contributor creator = contributorsMap.remove(
				firstWikiPage.getStatusByUserId());

			creator.modifiedDate = firstWikiPage.getStatusDate();

			creatorJSONObject = getContributorJSONObject(creator);

			List<Contributor> contributors = new ArrayList<>(
				contributorsMap.values());

			contributors.sort(
				Comparator.comparing(Contributor::getCount).reversed());

			for (Contributor contributor : contributors) {
				editorsJSONArray.put(getContributorJSONObject(contributor));
			}
		}
		catch (Exception e) {
			_log.error("Cannot create contributorsJSONObject ", e);
		}

		contributorsJSONObject.put("contributors", editorsJSONArray);
		contributorsJSONObject.put("creator", creatorJSONObject);

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

	protected JSONObject getContributorJSONObject(Contributor contributor)
		throws PortalException {

		JSONObject userJSONObject = JSONFactoryUtil.createJSONObject();

		if (contributor != null) {
			userJSONObject.put("count", contributor.count);
			userJSONObject.put("date", contributor.modifiedDate);
			userJSONObject.put("userFullName", contributor.userFullName);
			userJSONObject.put("userScreenName", contributor.userScreenName);
		}

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

	private class Contributor {

		public Contributor(long userId) throws PortalException {
			User user = _userLocalService.getUser(userId);

			count = 1;
			userFullName = user.getFullName();
			userScreenName = user.getScreenName();
		}

		public long getCount() {
			return count;
		}

		public long count;
		public Date modifiedDate;
		public String userFullName;
		public String userScreenName;

	}

}
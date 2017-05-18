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

package weightedscreen.action;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;

import weightedscreen.portlet.WeightedScreenPortletKeys;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;

/**
 * @author Zsolt Szabo
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + WeightedScreenPortletKeys.WEIGHTEDSCREEN,
		"mvc.command.name=get_wiki_pages"
	},
	service = MVCResourceCommand.class
)
public class GetWikiPagesMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		JSONArray wikiPages = JSONFactoryUtil.createJSONArray();

		int start = ParamUtil.getInteger(resourceRequest, "start", 0);
		int end = ParamUtil.getInteger(resourceRequest, "end", 10);

		List<AssetEntry> assetEntries = AssetEntryLocalServiceUtil.getTopViewedEntries(
			WikiPage.class.getName(), true, start, end);

		for (AssetEntry assetEntry: assetEntries) {;
			WikiPage wikiPage = WikiPageLocalServiceUtil.getPage(assetEntry.getClassPK());

			@SuppressWarnings("unchecked")
			AssetRenderer<WikiPage> assetRenderer = (AssetRenderer<WikiPage>)assetEntry.getAssetRenderer();

			String viewURL = assetRenderer.getURLView((LiferayPortletResponse)resourceResponse, WindowState.MAXIMIZED);

			wikiPages.put(toJSONWikiPage(wikiPage, assetEntry.getViewCount(), viewURL));
		}

		JSONPortletResponseUtil.writeJSON(
			resourceRequest, resourceResponse, wikiPages);
	}

	protected JSONObject toJSONWikiPage(WikiPage wikiPage, int viewCount, String viewURL) {
		JSONObject wikiPagesJSON = JSONFactoryUtil.createJSONObject();

		wikiPagesJSON.put("id", wikiPage.getPageId());
		wikiPagesJSON.put("name", wikiPage.getTitle());
		wikiPagesJSON.put("views", viewCount);
		wikiPagesJSON.put("url", viewURL);

		return wikiPagesJSON;
	}

}
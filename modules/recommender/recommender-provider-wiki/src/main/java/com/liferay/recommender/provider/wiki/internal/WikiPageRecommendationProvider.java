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

package com.liferay.recommender.provider.wiki.internal;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.recommender.provider.RecommendationProvider;
import com.liferay.wiki.model.WikiPage;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tibor Lipusz
 */
@Component(
	immediate = true,
	property = {"recommendation.provider.type=com.liferay.wiki.model.WikiPage"},
	service = RecommendationProvider.class
)
public class WikiPageRecommendationProvider
	implements RecommendationProvider<WikiPage> {

	public static final String PROVIDER_TYPE = WikiPage.class.getName();

	@Override
	public String getProviderType() {
		return PROVIDER_TYPE;
	}

	@Override
	public List<WikiPage> getRecommendations(long userId, int maxEntries)
		throws Exception {

		// TODO Implement :-)

		if (_log.isDebugEnabled()) {
			_log.debug("Invoked");
		}

		return new ArrayList<>();
	}

	@Override
	public List<String> getRecommendationURLs(long userId, int maxEntries)
		throws Exception {

		// TODO Implement :-)

		if (_log.isDebugEnabled()) {
			_log.debug("Invoked");
		}

		return new ArrayList<>();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		WikiPageRecommendationProvider.class);

}
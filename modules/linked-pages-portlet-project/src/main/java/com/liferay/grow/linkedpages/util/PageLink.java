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

package com.liferay.grow.linkedpages.util;

/**
 * @author Laszlo Hudak
 */
public class PageLink implements Comparable {

	public PageLink(String pageTitle, String pageLink) {
		this._pageLink = pageLink;
		this._pageTitle = pageTitle;
	}

	@Override
	public int compareTo(Object o) {
		return _pageTitle.toLowerCase().compareTo(
			((PageLink)o).getPageTitle().toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PageLink) {
			if (_pageLink.equals(((PageLink)obj).getPageLink()) &&
				_pageTitle.equals(((PageLink)obj).getPageTitle())) {

				return true;
			}

			return false;
		}

		return false;
	}

	public String getPageLink() {
		return _pageLink;
	}

	public String getPageTitle() {
		return _pageTitle;
	}

	public void setPageLink(String pageLink) {
		this._pageLink = pageLink;
	}

	public void setPageTitle(String pageTitle) {
		this._pageTitle = pageTitle;
	}

	private String _pageLink;
	private String _pageTitle;

}
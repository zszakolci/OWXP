package com.liferay.grow.linkedpages.util;

public class PageLink implements Comparable {

	public PageLink(String pageTitle, String pageLink) {
		this._pageLink = pageLink;
		this._pageTitle = pageTitle;
	}

	public String getPageTitle() {
		return _pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this._pageTitle = pageTitle;
	}

	public String getPageLink() {
		return _pageLink;
	}

	public void setPageLink(String pageLink) {
		this._pageLink = pageLink;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PageLink) {
			return _pageLink.equals(((PageLink) obj).getPageLink()) &&
				_pageTitle.equals(((PageLink) obj).getPageTitle());
		}

		return false;
	}

	@Override
	public int compareTo(Object o) {
		return _pageTitle.toLowerCase().compareTo(
			((PageLink) o).getPageTitle().toLowerCase());
	}

	private String _pageTitle;
	private String _pageLink;
}

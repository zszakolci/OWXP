package com.liferay.grow.linkedpages.util;
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
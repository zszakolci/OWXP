package com.liferay.grow.gamification.badges.model;

public class BadgeAggregator {

	public long getBadgeTypeId() {
		return _badgeTypeId;
	}

	public int getCount() {
		return _count;
	}

	public String getImage() {
		return _image;
	}

	public String getName() {
		return _name;
	}

	public void increaseCount() {
		_count ++;
	}

	public void setBadgeTypeId(long badgeTypeId) {
		_badgeTypeId = badgeTypeId;
	}

	public void setCount(int count) {
		this._count = count;
	}

	public void setImage(String image) {
		this._image = image;
	}

	public void setName(String name) {
		this._name = name;
	}


	@Override
	public String toString() {
		return "BadgeAggregator [_badgeTypeId=" + _badgeTypeId + ", _count=" + _count + ", _image=" + _image
				+ ", _name=" + _name + "]";
	}

	private long _badgeTypeId;
	private int _count;
	private String _image;
	private String _name;

}

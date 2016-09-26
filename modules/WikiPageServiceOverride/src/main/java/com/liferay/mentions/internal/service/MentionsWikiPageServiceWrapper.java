package com.liferay.mentions.internal.service;

import com.liferay.wiki.service.WikiPageLocalServiceWrapper;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class MentionsWikiPageServiceWrapper extends WikiPageLocalServiceWrapper {

	public MentionsWikiPageServiceWrapper() {
		super(null);
	}

}
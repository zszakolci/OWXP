package com.liferay.wiki.engine.markdown;

import com.liferay.wiki.engine.WikiEngine;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
	},
	service = WikiEngine.class
)
public class MarkdownEngine implements WikiEngine {
}
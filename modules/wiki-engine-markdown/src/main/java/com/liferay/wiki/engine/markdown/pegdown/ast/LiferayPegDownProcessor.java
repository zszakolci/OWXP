package com.liferay.wiki.engine.markdown.pegdown.ast;

import org.pegdown.PegDownProcessor;

import org.pegdown.LinkRenderer;
import org.pegdown.Parser;
import org.pegdown.PegDownProcessor;
import org.pegdown.ast.RootNode;

public class LiferayPegDownProcessor extends PegDownProcessor {

	public LiferayPegDownProcessor(Parser parser) {
		super(parser);
	}

	@Override
	public String markdownToHtml(
		char[] markdownSource, LinkRenderer linkRenderer) {

		RootNode rootNode = parseMarkdown(markdownSource);

		LiferayToHtmlSerializer liferayToHtmlSerializer =
			new LiferayToHtmlSerializer(linkRenderer);

		return liferayToHtmlSerializer.toHtml(rootNode);
	}
}

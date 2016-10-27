package org.pegdown;

import org.parboiled.Rule;
import org.parboiled.common.ArrayBuilder;

import com.liferay.wiki.engine.markdown.pegdown.ast.PicWithCaptionNode;

public class LiferayParser extends Parser {

	public LiferayParser(Integer options) {
		super(options);
	}

	public LiferayParser(
		Integer options, ParseRunnerProvider parseRunnerProvider) {

		super(options, parseRunnerProvider);
	}

	@Override
	public Rule Block() {
		ArrayBuilder<Rule> arrayBuilder = new ArrayBuilder<>();

		arrayBuilder.add(BlockQuote(), Verbatim());

		if (ext(ABBREVIATIONS)) {
			arrayBuilder.addNonNulls(Abbreviation());
		}

		arrayBuilder.add(
			PictureWithCaption(), Reference(), HorizontalRule(), Heading(),
			OrderedList(), BulletList(), HtmlBlock());

		if (ext(TABLES)) {
			arrayBuilder.addNonNulls(Table());
		}

		if (ext(DEFINITIONS)) {
			arrayBuilder.addNonNulls(DefinitionList());
		}

		if (ext(FENCED_CODE_BLOCKS)) {
			arrayBuilder.addNonNulls(FencedCodeBlock());
		}

		arrayBuilder.add(Para(), Inlines());

		return Sequence(ZeroOrMore(BlankLine()), FirstOf(arrayBuilder.get()));
	}

	public Rule PictureWithCaption() {
		return NodeSequence(
			TestNot(OneOrMore(CharEntity())), '!', Label(), Spn1(), '(', Sp(),
			LinkSource(), Spn1(), FirstOf(LinkTitle(), push("")), Sp(), ')',
			TestNot(OneOrMore(Spacechar())), TestNot(OneOrMore(CharEntity())),
			drop(), push(new PicWithCaptionNode(popAsString(), popAsNode())));
	}

}

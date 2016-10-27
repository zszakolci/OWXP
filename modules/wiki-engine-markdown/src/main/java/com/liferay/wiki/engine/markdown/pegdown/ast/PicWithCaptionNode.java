package com.liferay.wiki.engine.markdown.pegdown.ast;

import java.util.List;

import org.pegdown.ast.Node;
import org.pegdown.ast.SuperNode;
import org.pegdown.ast.TextNode;
import org.pegdown.ast.Visitor;

public class PicWithCaptionNode extends SuperNode {

	public PicWithCaptionNode(String src, Node node) {
		super(node);

		_alt = _getAlt(node);
		_src = src;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public String getAlt() {
		return _alt;
	}

	public String getSrc() {
		return _src;
	}

	private String _getAlt(Node node) {
		if (node == null) {
			return "";
		}

		List<Node> nodes = node.getChildren();

		if ((nodes != null) && !nodes.isEmpty() &&
			(nodes.get(0) instanceof TextNode)) {

			TextNode textNode = (TextNode)nodes.get(0);

			return textNode.getText();
		}

		return "";
	}

	private final String _alt;
	private final String _src;

}

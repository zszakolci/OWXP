<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/init.jsp" %>

<%
String portletId = portletDisplay.getRootPortletId();

boolean autoCreate = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-editor:autoCreate"));
String contents = (String)request.getAttribute("liferay-ui:input-editor:contents");
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:cssClass"));
String initMethod = (String)request.getAttribute("liferay-ui:input-editor:initMethod");
String name = namespace + GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:name"));

String onChangeMethod = (String)request.getAttribute("liferay-ui:input-editor:onChangeMethod");

if (Validator.isNotNull(onChangeMethod)) {
	onChangeMethod = namespace + onChangeMethod;
}

String onInitMethod = (String)request.getAttribute("liferay-ui:input-editor:onInitMethod");

if (Validator.isNotNull(onInitMethod)) {
	onInitMethod = namespace + onInitMethod;
}

boolean resizable = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-editor:resizable"));

String modules = "aui-event-input";

if (resizable) {
	modules += ",resize";
}
%>

<liferay-util:buffer var="editor">
	<blockquote class=".main-content">
		<textarea class="lfr-editor-textarea" id="<%= HtmlUtil.escapeAttribute(name) %>" name="<%= HtmlUtil.escapeAttribute(name) %>" style="resize:<%= resizable ? "vertical" : "none" %>"><%= (contents != null) ? HtmlUtil.escape(contents) : StringPool.BLANK %></textarea>

		<div class="stackedit-button-wrapper">
			<a id="stackEdit" href="javascript:void(0);"> <img src="/o/grow-theme/images/stackedit.svg"> Edit with StackEdit</a>
		</div>
	</blockquote>
</liferay-util:buffer>

<%
String containerId = HtmlUtil.escapeAttribute(name) + "Container";

name = HtmlUtil.escapeJS(name);
%>

<script src="https://unpkg.com/stackedit-js@1.0.7/docs/lib/stackedit.min.js"></script>

<aui:script use="<%= modules %>">

	var el = document.querySelector('textarea');
	var stackedit = new Stackedit({
		url: 'https://stackedit.lfr.io/app'
	});

	var a = document.getElementById("stackEdit");
	a.onclick = function() {

		// Open the iframe
		stackedit.openFile({
			content: {
				text: el.value // and the Markdown content.
			},
			properties: {
				extensions: {
					preset: 'gfm'
				}
			}
		});

		return false;
	}

	// Listen to StackEdit events and apply the changes to the textarea.
	stackedit.on('fileChange', function (file) {
		el.value = file.content.text;
	});

	var onInputHandle;

	var onInput = function(event) {
		<%= HtmlUtil.escapeJS(onChangeMethod) %>(window['<%= name %>'].getHTML());
	};

	var getInitialContent = function() {
		var data;

		if (window['<%= HtmlUtil.escapeJS(namespace + initMethod) %>']) {
			data = <%= HtmlUtil.escapeJS(namespace + initMethod) %>();
		}
		else {
			data = '<%= contents != null ? HtmlUtil.escapeJS(contents) : StringPool.BLANK %>';
		}

		return data;
	};

	window['<%= name %>'] = {
		create: function() {
			if (!window['<%= name %>'].instanceReady) {
				var editorNode = A.Node.create('<%= HtmlUtil.escapeJS(editor) %>');

				var editorContainer = A.one('#<%= name %>Container');

				editorContainer.appendChild(editorNode);

				window['<%= name %>'].initEditor();
			}
		},

		destroy: function() {
			window['<%= name %>'].dispose();

			window['<%= name %>'] = null;
		},

		dispose: function() {
			var editorEl = document.getElementById('<%= name %>Container');

			if (editorEl) {
				editorEl.parentNode.removeChild(editorEl);

				window['<%= name %>'].instanceReady = false;
			}

			if (onInputHandle) {
				onInputHandle.detach();
			}
		},

		focus: function() {
			var focus;

			if (window['<%= name %>'].instanceReady) {
				focus = document.getElementById('<%= name %>').focus();
			}

			return focus;
		},

		getHTML: function() {
			return window['<%= name %>'].getText();
		},

		getNativeEditor: function() {
			return document.getElementById('<%= name %>');
		},

		getText: function() {
			var value;

			if (window['<%= name %>'].instanceReady) {
				value = document.getElementById('<%= name %>').value;
			}
			else {
				value = getInitialContent();
			}

			return value;
		},

		initEditor: function() {
			<c:if test="<%= (contents == null) && Validator.isNotNull(initMethod) %>">
				<%= name %>.setHTML(<%= HtmlUtil.escapeJS(namespace + initMethod) %>());
			</c:if>

			<c:if test="<%= Validator.isNotNull(onChangeMethod) %>">
				onInputHandle = A.one('#<%= name %>').on('input', A.bind(onInput, this));
			</c:if>

			<c:if test="<%= resizable && BrowserSnifferUtil.isIe(request) %>">
				setTimeout(
					function() {
						new A.Resize(
							{
								handles: 'br',
								node: '#<%= name %>Container',
								wrap: true
							}
						);
					},
					0
				);
			</c:if>

			<c:if test="<%= Validator.isNotNull(onInitMethod) %>">
				window['<%= HtmlUtil.escapeJS(onInitMethod) %>']();
			</c:if>

			window['<%= name %>'].instanceReady = true;
		},

		instanceReady: false,

		setHTML: function(value) {
			if (window['<%= name %>'].instanceReady) {
				document.getElementById('<%= name %>').value = value || '';
			}
		}
	};

	Liferay.fire(
		'editorAPIReady',
		{
			editor: window['<%= name %>'],
			editorName: '<%= name %>'
		}
	);

	<c:if test="<%= autoCreate %>">
		window['<%= name %>'].initEditor();
	</c:if>

	var destroyInstance = function(event) {
		if (event.portletId === '<%= portletId %>') {
			window['<%= name %>'].destroy();

			Liferay.detach('destroyPortlet', destroyInstance);
		}
	};

	Liferay.on('destroyPortlet', destroyInstance);
</aui:script>

<div class="<%= HtmlUtil.escapeAttribute(cssClass) %>" id="<%= containerId %>">
	<c:if test="<%= autoCreate %>">
		<%= editor %>
	</c:if>
</div>
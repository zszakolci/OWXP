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

<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>

<%
WikiPage wikiPage = BaseWikiEngine.getWikiPage(request);

boolean markdown = GetterUtil.getBoolean(request.getAttribute("markdown"));

if (markdown) {
%>

<blockquote class=".main-content">
	<liferay-ui:input-field
		bean="<%= wikiPage %>"
		field="content"
		model="<%= WikiPage.class %>"
	/>

	<div class="stackedit-button-wrapper">
		<a href="javascript:void(0);" id="stackEdit"> <img src="/o/grow-theme/images/stackedit.svg"> Edit with StackEdit</a>
	</div>
</blockquote>

<%
}
else {
%>

<p>
	<liferay-ui:input-field
		bean="<%= wikiPage %>"
		field="content"
		model="<%= WikiPage.class %>"
	/>
</p>

<%
}
%>

<script src="https://unpkg.com/stackedit-js@1.0.7/docs/lib/stackedit.min.js"></script>

<script>
	var el = document.querySelector('textarea');
	var stackedit = new Stackedit();

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
	stackedit.on(
		'fileChange',
		function(file) {
			el.value = file.content.text;
		}
	);
</script>
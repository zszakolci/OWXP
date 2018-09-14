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

<%@ include file="/dynamic_include/init.jsp" %>

<%
PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);

WikiNode node = (WikiNode)request.getAttribute(WikiWebKeys.WIKI_NODE);

WikiWebComponentProvider wikiWebComponentProvider = WikiWebComponentProvider.getWikiWebComponentProvider();

WikiGroupServiceConfiguration wikiGroupServiceConfiguration = wikiWebComponentProvider.getWikiGroupServiceConfiguration();

WikiRequestHelper wikiRequestHelper = new WikiRequestHelper(request);

WikiURLHelper wikiURLHelper = new WikiURLHelper(wikiRequestHelper, portletResponse, wikiGroupServiceConfiguration);

PortletURL searchURL = wikiURLHelper.getSearchURL();
%>

<aui:form action="<%= searchURL %>" method="get" name="searchFm">
	<liferay-portlet:renderURLParams portletURL="<%= searchURL %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="nodeId" type="hidden" value="<%= node.getNodeId() %>" />

	<liferay-ui:input-search
		id='<%= portletResponse.getNamespace() + "keywords1" %>'
		markupView="lexicon"
		name='<%= portletResponse.getNamespace() + "keywords" %>'
		useNamespace="<%= false %>"
	/>
</aui:form>
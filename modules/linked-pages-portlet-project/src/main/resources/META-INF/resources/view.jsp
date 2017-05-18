<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
String portletNamespace = PortalUtil.getPortletNamespace(LinkedPagesPortletKeys.LINKED_PAGES);

LinkedPagesView linkedPagesView = new LinkedPagesView(themeDisplay);

WikiPage wikiPage = linkedPagesView.getWikiPage();

List<Task> availableTasks = new ArrayList<Task>();

if (wikiPage != null) {
	availableTasks = TaskHandlerUtil.getRunningVotes(wikiPage.getPageId());
}

%>


<div id="linkedPages">
	<h4 class="header">Linked Pages</h4>
	<c:choose>
		<c:when test="<%= linkedPagesView.getLinkedPages().isEmpty() %>">
			<div class="content">
				No Wiki page is available
			</div>
		</c:when>
		<c:otherwise>
			<div class="content">
				<ul class="nav">

					<%
					for (PageLink pageLink : linkedPagesView.getLinkedPages()) {
					%>

						<li class="">
							<a href="<%= pageLink.getPageLink() %>" style="color:#6a708b;">
								<%= pageLink.getPageTitle() %>
							</a>
						</li>

					<%
					}
					%>

				</ul>
			</div>
		</c:otherwise>
	</c:choose>

	<h4 class="header">Votings</h4>

	<c:choose>
		<c:when test="<%= availableTasks.isEmpty() %>">
			<div class="content">
				No voting tasks are available
			</div>
		</c:when>
		<c:otherwise>
			<div class="content">
			<%
				for (Task task : availableTasks) {
					String taskName = task.getTaskName();

					int vote = TaskHandlerUtil.getVote(themeDisplay.getUserId(), wikiPage.getPageId(), task.getTaskId());
			%>
					<div>
						<h5><%= task.getTaskName() %></h5>
						<aui:input checked="<%= vote == 1 %>" label="Agree" name="<%= taskName %>" type="radio" value="<%= true %>" />

						<aui:input checked="<%= vote == 0 %>" label="Not Agree" name="<%= taskName %>" type="radio" value="<%= false %>" />

						<aui:script use="aui-base">
							var <%= taskName %>CheckboxNodes = A.all('input[name="<%= taskName %>"]');

							<%= taskName %>CheckboxNodes.each(
								function(node) {
									node.on(
										'change',
										function(event) {
											var radioValue = event.currentTarget.attr('value');
											var value = 1;

											if (radioValue === 'false') {
												value = 0;
											}

											window.<portlet:namespace />votingService(<%= task.getTaskId()%>, value);
										}
									);
								}
							);
						</aui:script>
					</div>
			<%
				}
			%>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<c:if test="<%= wikiPage != null %>">
	<aui:script use="aui-toggler">

	var toggler = new A.TogglerDelegate(
		{
			animated: true,
			container: '#linkedPages',
			content: '.content',
			expanded: true,
			header: '.header',
			transition: {
				duration: 0.2,
				easing: 'cubic-bezier(0, 0.1, 0, 1)'
			}
		}
	);

	window.<portlet:namespace />votingService = function(taskId, value) {
		Liferay.Service(
			'/task.taskentry/vote',
			{
				taskId: taskId,
				wikiPageId: <%= wikiPage.getPageId() %>,
				userId: <%= themeDisplay.getUserId() %>,
				vote: value
			},
			function(response) {
			}
		);
	}
	</aui:script>
</c:if>
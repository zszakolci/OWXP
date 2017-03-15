<%@ include file="/init.jsp" %>

<%
String portletNamespace = PortalUtil.getPortletNamespace(LinkedPagesPortletKeys.LINKED_PAGES);

LinkedPagesView linkedPagesView = new LinkedPagesView(themeDisplay);
%>

<div>
	<div class="closed lfr-admin-panel lfr-product-menu-panel lfr-simulation-panel sidenav-fixed sidenav-menu-slider sidenav-right" id="<%= portletNamespace %>linkedPagesPanelId">
		<div class="product-menu sidebar sidebar-inverse sidenav-menu">
			<div class="sidebar-header">
				<span><liferay-ui:message key="linked_pages_portlet_project_LinkedPagesPortlet.caption"/></span>
			</div>

			<div class="sidebar-body"></div>
			<c:choose>
				<c:when test="<%= linkedPagesView.getLinkedPages().isEmpty() %>">
					<div>
						No Wiki page is available
					</div>
				</c:when>
				<c:otherwise>
					<div>
						Linked Pages:
					</div>

					<div class="">
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
		</div>
	</div>
</div>
<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.grow.gamification.badges.model.BadgeAggregator" %>
<%@ page import="com.liferay.grow.gamification.model.BadgeType" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.grow.gamification.badges.portlet.constants.SimpleBadgePortletKeys"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%
List<BadgeAggregator> aggregators = (List<BadgeAggregator>)request.getAttribute(SimpleBadgePortletKeys.BADGE_AGGRETAGORS);
List<BadgeType> badgeTypes = (List<BadgeType>)request.getAttribute(SimpleBadgePortletKeys.BADGE_TYPES);
long userId = 0;
String userName = "";
%>

<portlet:actionURL name="addBadge" var="addBadgeURL" />

<div class="modal" id="badgeModal" tabindex="-1" role="dialog" aria-hidden="true" style="display:none; z-index">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<aui:form name="badgeForm" id="badgeForm" method="post" action="<%= addBadgeURL %>">
			<aui:input type="hidden" id="userId" name="userId" />
			<aui:input type="hidden" id="badgeTypeId" name="badgeTypeId" />

			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Add Badge To title</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<aui:input name="description" type="textarea" value="" class="form-control" />
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					<button type="submit" onclick="addBadge()" class="btn btn-primary">Add Badge</button>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<div class="container">

	<%
	if (themeDisplay.getScopeGroup().isUser()) {
		userId = (long)request.getAttribute(SimpleBadgePortletKeys.BADGE_USER_I);
		userName = (String)request.getAttribute(SimpleBadgePortletKeys.BADGE_USER_NAME);
		if (aggregators != null) {
			for (BadgeAggregator aggregator : aggregators) {
	%>
	<div class="row">
		<div class="col-sm-1">
		<img class="badge-image" src="<%= aggregator.getImage() %>" />
			<span class="badge badge-danger"> <%= (aggregator.getCount() > 99) ? "99+" : aggregator.getCount() %></span>
			</div>
			<div class="col-sm-2">
			<p class="badge-type"><%= aggregator.getName() %></p>
			</div>
		</div>
	<%		}
		}

		if (themeDisplay.isSignedIn()) {
	%>
	<div class="row">
			<div class="btn-group">
				<button type="button" class="btn btn-info dropdown-toggle" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Add a Badge
				</button>
				<div class="dropdown-menu">
					<%for (BadgeType badgeType : badgeTypes) { 	%>
						<a class="dropdown-item" href="#" data-toggle="modal" data-target="#badgeModal" onclick="showBadgeDialog(<%= userId %>, <%= badgeType.getBadgeTypeId() %>, '<%= badgeType.getType() %>', '<%= userName %>')"><%= badgeType.getType() %></a>
					<% } %>
				</div>
			</div>
	</div>
	<% 	}
		}%>
</div>


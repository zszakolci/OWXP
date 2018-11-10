<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.grow.gamification.model.BadgeType" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%
List<BadgeType> badgeTypes = (List<BadgeType>)request.getAttribute("BADGE_TYPES");
List<User> users = (List<User>)request.getAttribute("USER_LIST");
%>
<% if (themeDisplay.isSignedIn())  { %>
<portlet:actionURL name="addBadge" var="addBadgeURL" />

<div class="container">
	<div class="row">
		<div class="col-sm-3">
			<select class="flexselect" id="nameSelect" name="nameSelect" palceholder="this is a placeholder">
					<% for (User userItem : users) { 	%>
						<%--  a class="dropdown-item" href="#" onclick="selectUser(<%= userItem.getUserId() %>, '<%= (userItem.getFullName().trim().equals("")) ? "Select user" : userItem.getFullName()  %>')"><%= (userItem.getFullName().trim().equals("")) ? "Select user" :  userItem.getFullName()  %></a --%>
						<option value="<%= userItem.getUserId() %>"><%= (userItem.getFullName().trim().equals("")) ? "" : userItem.getFullName()  %></option>
					<% } %>
			</select>
		</div>
		<div class="col-sm-2">
			<div class="btn-group">
				<button type="button" class="btn btn-info dropdown-toggle" id="simpleDropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" disabled>
					Add a Badge
				</button>
				<div class="dropdown-menu">
					<%for (BadgeType badgeType : badgeTypes) { 	%>
						<a class="dropdown-item" href="#" data-toggle="modal" data-target="#simpleBadgeModal" onclick="showSimpleBadgeDialog(<%= badgeType.getBadgeTypeId() %>, '<%= badgeType.getType() %>');"><%= badgeType.getType() %></a>
					<% } %>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal" id="simpleBadgeModal" tabindex="-1" role="dialog" aria-hidden="true" style="display:none; z-index">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<aui:form name="simpleBadgeForm" id="simpleBadgeForm" method="post" action="<%= addBadgeURL %>">
			<aui:input type="hidden" id="userId" name="userId" />
			<aui:input type="hidden" id="userName" name="userId" />
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
						<aui:input name="description" type="textarea" value="" class="form-control"/>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					<button type="submit" onclick="addSimpleBadge()" class="btn btn-primary">Add Badge</button>
				</div>
			</div>
		</aui:form>
	</div>
</div>
<% } %>

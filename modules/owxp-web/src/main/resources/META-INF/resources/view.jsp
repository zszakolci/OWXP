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
User subscribeToUser = UserLocalServiceUtil.getUser(layout.getUserId());
%>

<div class="subscribe">
	<portlet:actionURL name="subscribe" var="subscribeURL">
		<portlet:param name="companyId" value="<%= String.valueOf(user.getCompanyId()) %>" />
		<portlet:param name="subscriberId" value="<%= String.valueOf(user.getUserId()) %>" />
		<portlet:param name="subscribeToId" value="<%= String.valueOf(subscribeToUser.getUserId()) %>" />
	</portlet:actionURL>

	<c:choose>
		<c:when test="<%= themeDisplay.isSignedIn() %>">
			<c:choose>
				<c:when test="<%= SubscriptionLocalServiceUtil.isSubscribed(company.getCompanyId(), user.getUserId(), User.class.getName(), subscribeToUser.getUserId()) %>">
					<liferay-ui:icon
						iconCssClass="icon-remove-sign"
						label="<%= true %>"
						message='<%= "Unfollow " + subscribeToUser.getFirstName() %>'
						url="<%= subscribeURL %>"
					/>
				</c:when>
				<c:otherwise>
					<liferay-ui:icon
						iconCssClass="icon-ok-sign"
						label="<%= true %>"
						message='<%= "Follow " + subscribeToUser.getFirstName() %>'
						url="<%= subscribeURL %>"
					/>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<liferay-ui:message key="please-sign-in-to-access-this-application" />
		</c:otherwise>
	</c:choose>
</div>
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
		<c:when test="<%= SubscriptionLocalServiceUtil.isSubscribed(company.getCompanyId(), user.getUserId(), User.class.getName(), subscribeToUser.getUserId()) %>">
			<liferay-ui:icon
				iconCssClass="icon-remove-sign"
				label="<%= true %>"
				message="unsubscribe"
				url="<%= subscribeURL %>"
			/>
		</c:when>
		<c:otherwise>
			<liferay-ui:icon
				iconCssClass="icon-ok-sign"
				label="<%= true %>"
				message="subscribe"
				url="<%= subscribeURL %>"
			/>
		</c:otherwise>
	</c:choose>
</div>
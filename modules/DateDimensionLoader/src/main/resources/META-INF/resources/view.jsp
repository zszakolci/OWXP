<%@page import="com.liferay.grow.gamification.service.LDateLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<% if (LDateLocalServiceUtil.getLDatesCount() == 0) { %>
<portlet:actionURL name="generate" var="generateURL" />

<aui:form action="<%= generateURL %>" method="post" name="fm" >
	<aui:input type="submit" name="" value="Generate Date Dimension Table" />
</aui:form>

<% } else { %>
<h2>Date Dimension is already filled out</h2>
<% } %>
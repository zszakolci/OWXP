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

<%@ include file="/message_boards/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Object[] objArray = (Object[])row.getObject();

MBMessage message = (MBMessage)objArray[0];

Set<Long> threadSubscriptionClassPKs = (Set<Long>)request.getAttribute("view.jsp-threadSubscriptionClassPKs");

MBCategory category = message.getCategory();
MBThread thread = message.getThread();
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
	<c:if test="<%= MBMessagePermission.contains(permissionChecker, message, ActionKeys.UPDATE) && !thread.isLocked() %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="mvcRenderCommandName" value="/message_boards/edit_message" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="messageId" value="<%= String.valueOf(message.getMessageId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editURL %>"
		/>
	</c:if>

	<c:if test="<%= portletName.equals(MBPortletKeys.MESSAGE_BOARDS) && enableRSS && MBMessagePermission.contains(permissionChecker, message, ActionKeys.VIEW) %>">
		<liferay-ui:rss
			delta="<%= rssDelta %>"
			displayStyle="<%= rssDisplayStyle %>"
			feedType="<%= rssFeedType %>"
			url="<%= MBUtil.getRSSURL(plid, 0, message.getThreadId(), 0, themeDisplay) %>"
		/>
	</c:if>

	<c:if test="<%= MBMessagePermission.contains(permissionChecker, message, ActionKeys.SUBSCRIBE) && (mbGroupServiceSettings.isEmailMessageAddedEnabled() || mbGroupServiceSettings.isEmailMessageUpdatedEnabled()) %>">
		<c:choose>
			<c:when test="<%= (threadSubscriptionClassPKs != null) && threadSubscriptionClassPKs.contains(message.getThreadId()) %>">
				<portlet:actionURL name="/message_boards/edit_message" var="unsubscribeURL">
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UNSUBSCRIBE %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="messageId" value="<%= String.valueOf(message.getMessageId()) %>" />
				</portlet:actionURL>

				<liferay-ui:icon
					message="unsubscribe"
					url="<%= unsubscribeURL %>"
				/>
			</c:when>
			<c:otherwise>
				<portlet:actionURL name="/message_boards/edit_message" var="subscribeURL">
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SUBSCRIBE %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="messageId" value="<%= String.valueOf(message.getMessageId()) %>" />
				</portlet:actionURL>

				<liferay-ui:icon
					message="subscribe"
					url="<%= subscribeURL %>"
				/>
			</c:otherwise>
		</c:choose>
	</c:if>
</liferay-ui:icon-menu>
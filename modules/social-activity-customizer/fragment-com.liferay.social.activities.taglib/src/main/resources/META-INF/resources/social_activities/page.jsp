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

<%@ include file="/social_activities/init.jsp" %>

<%
int delta = ParamUtil.getInteger(request, "delta");

if (delta == 0) {
	delta = 10;
}
%>

<div class="taglib-social-activities">
	<c:if test="<%= feedEnabled && !activityDescriptors.isEmpty() %>">
		<div class="clearfix">
			<div class="pull-right">
				<liferay-rss:rss
					delta="<%= feedDelta %>"
					displayStyle="<%= feedDisplayStyle %>"
					feedType="<%= feedType %>"
					message="<%= feedURLMessage %>"
					name="<%= feedTitle %>"
					resourceURL="<%= feedResourceURL %>"
					url="<%= feedURL %>"
				/>
			</div>
		</div>
	</c:if>

	<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

	boolean hasActivities = false;

	Date now = new Date();

	Group scopeGroup = serviceContext.getScopeGroup();

	if (scopeGroup.isUser()) {
		selector = "CUSTOM";
	}
	else {
		selector = "GENERAL";
	}

	int daysBetween = -1;

	ArrayList<FeedEntryHolder> feedEntries = new ArrayList<>();
	%>

	<c:if test="<%= scopeGroup.isUser() %>">

		<%
		String activityType = ParamUtil.getString(request, "activityType");
		%>

		<aui:select id="user-activity-selector" label="Activity type to display:" name="user-activity-selector" onChange="filterByActivityType();">
			<aui:option label="All" selected='<%= activityType.equals(StringPool.BLANK) || activityType.equals("ALL") %>' value="ALL" />
			<aui:option label="Commented" selected='<%= activityType.equals("COMMENTED") %>' value="COMMENTED" />
			<aui:option label="Created" selected='<%= activityType.equals("CREATED") %>' value="CREATED" />
			<aui:option label="Updated" selected='<%= activityType.equals("UPDATED") %>' value="UPDATED" />
		</aui:select>

		<%
		for (SocialActivityDescriptor activityDescriptor : activityDescriptors) {
			SocialActivityFeedEntry activityFeedEntry = activityDescriptor.interpret(selector, serviceContext);

			if (activityFeedEntry == null) {
				continue;
			}

			FeedEntryHolder entryHolder = new FeedEntryHolder(activityFeedEntry.getTitle() + activityFeedEntry.getBody());

			feedEntries.add(entryHolder);
		}

		String headerName = "x's-activities";
		%>

		<liferay-portlet:renderURL varImpl="iteratorURL">
			<liferay-portlet:param name="activityType" value="<%= activityType %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:search-container delta="<%= delta %>" emptyResultsMessage="there-are-no-recent-activities" iteratorURL="<%= iteratorURL %>" total="<%= feedEntries.size() %>">
			<liferay-ui:search-container-results results="<%= ListUtil.subList(feedEntries, searchContainer.getStart(), searchContainer.getEnd()) %>" />

			<liferay-ui:search-container-row className="FeedEntryHolder" keyProperty="feedEntryText" modelVar="enrty">
				<liferay-ui:search-container-column-text name="<%= LanguageUtil.format(request, headerName, UserLocalServiceUtil.getUserById(scopeGroup.getClassPK()).getFirstName()) %>" property="feedEntryText" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" />
		</liferay-ui:search-container>
	</c:if>

	<c:if test="<%= !scopeGroup.isUser() %>">

		<%
		for (SocialActivityDescriptor activityDescriptor : activityDescriptors) {
			SocialActivityFeedEntry activityFeedEntry = activityDescriptor.interpret(selector, serviceContext);

			if (activityFeedEntry == null) {
				continue;
			}

			int curDaysBetween = DateUtil.getDaysBetween(new Date(activityDescriptor.getCreateDate()), now, timeZone);
		%>

		<c:if test="<%= curDaysBetween > daysBetween %>">

			<%
			daysBetween = curDaysBetween;

			if (hasActivities) {
			%>

				</ul>

			<%
			}
			%>

			<ul class="list-group-card list-unstyled">
				<li class="splitter">
					<c:choose>
						<c:when test="<%= curDaysBetween == 0 %>">
							<liferay-ui:message key="today" />
						</c:when>
						<c:when test="<%= curDaysBetween == 1 %>">
							<liferay-ui:message key="yesterday" />
						</c:when>
						<c:when test="<%= curDaysBetween < 365 %>">
							<%= dateFormatDate.format(activityDescriptor.getCreateDate()) %>
						</c:when>
						<c:otherwise>
							<%= yearDateFormatDate.format(activityDescriptor.getCreateDate()) %>
						</c:otherwise>
					</c:choose>
				</li>
		</c:if>

		<li class="list-group-item">
			<div class="card card-horizontal">
				<div class="card-row card-row-padded">
					<div class="card-col-field">
						<liferay-ui:user-portrait
							userId="<%= activityDescriptor.getUserId() %>"
						/>
					</div>

					<div class="card-col-content card-col-gutters">
						<h5 class="text-default">
							<%= timeFormatDate.format(activityDescriptor.getCreateDate()) %>
						</h5>

						<%= activityFeedEntry.getTitle() %>

						<%= activityFeedEntry.getBody() %>
					</div>
				</div>
			</div>
		</li>

		<%
			if (!hasActivities) {
				hasActivities = true;
			}
		}
		%>

		<c:choose>
			<c:when test="<%= hasActivities %>">
				</ul>
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="there-are-no-recent-activities" />
			</c:otherwise>
		</c:choose>
	</c:if>
</div>

<%!
private class FeedEntryHolder {
	public FeedEntryHolder(String feedEntryText) {
		this.feedEntryText = feedEntryText;
	}

	public String getFeedEntryText() {
		return feedEntryText;
	}

	private String feedEntryText;

}
%>

<aui:script use="aui-base">
	window.filterByActivityType = function() {
		var uri = '<portlet:renderURL />';

		uri = Liferay.Util.addParams('<portlet:namespace />activityType=' + A.one('#<portlet:namespace />user-activity-selector').get('value'), uri);
		uri = Liferay.Util.addParams('<portlet:namespace />delta=<%= delta %>', uri);

		window.location.href = uri;
	};
</aui:script>
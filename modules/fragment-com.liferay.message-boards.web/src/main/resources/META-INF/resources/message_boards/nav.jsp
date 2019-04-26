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
String mvcRenderCommandName = ParamUtil.getString(request, "mvcRenderCommandName", "/message_boards/view");

boolean signedIn = themeDisplay.isSignedIn();
		 String recentQuestionLabel= "Recent Questions";
%>
NA MI A FASZ VAN
<clay:navigation-bar
	navigationItems='<%=
		new JSPNavigationItemList(pageContext) {
			{
				PortletURL messageBoardsHomeURL = renderResponse.createRenderURL();

				messageBoardsHomeURL.setParameter("mvcRenderCommandName", "/message_boards/view");
				messageBoardsHomeURL.setParameter("tag", StringPool.BLANK);

				add(
					navigationItem -> {
						navigationItem.setActive(mvcRenderCommandName.equals("/message_boards/edit_category") || mvcRenderCommandName.equals("/message_boards/edit_message") || mvcRenderCommandName.equals("/message_boards/view") || mvcRenderCommandName.equals("/message_boards/view_category") || mvcRenderCommandName.equals("/message_boards/view_message"));
						navigationItem.setHref(messageBoardsHomeURL);
						navigationItem.setLabel(LanguageUtil.get(request, "categories"));
					});

				PortletURL viewRecentPostsURL = renderResponse.createRenderURL();

				viewRecentPostsURL.setParameter("mvcRenderCommandName", "/message_boards/view_recent_posts");

				add(
					navigationItem -> {
						navigationItem.setActive(mvcRenderCommandName.equals("/message_boards/view_recent_posts"));
						navigationItem.setHref(viewRecentPostsURL);
						navigationItem.setLabel(recentQuestionLabel);
					});

				if (signedIn) {
					PortletURL viewMyPostsURL = renderResponse.createRenderURL();

					viewMyPostsURL.setParameter("mvcRenderCommandName", "/message_boards/view_my_posts");

					add(
						navigationItem -> {
							navigationItem.setActive(mvcRenderCommandName.equals("/message_boards/view_my_posts"));
							navigationItem.setHref(viewMyPostsURL);
							navigationItem.setLabel(LanguageUtil.get(request, "my-posts"));
						});

					if (mbGroupServiceSettings.isEmailMessageAddedEnabled() || mbGroupServiceSettings.isEmailMessageUpdatedEnabled()) {
						PortletURL viewMySubscriptionsURL = renderResponse.createRenderURL();

						viewMySubscriptionsURL.setParameter("mvcRenderCommandName", "/message_boards/view_my_subscriptions");

						add(
							navigationItem -> {
								navigationItem.setActive(mvcRenderCommandName.equals("/message_boards/view_my_subscriptions"));
								navigationItem.setHref(viewMySubscriptionsURL);
								navigationItem.setLabel(LanguageUtil.get(request, "my-subscriptions"));
							});
					}
				}

				PortletURL viewStatisticsURL = renderResponse.createRenderURL();

				viewStatisticsURL.setParameter("mvcRenderCommandName", "/message_boards/view_statistics");

				add(
					navigationItem -> {
						navigationItem.setActive(mvcRenderCommandName.equals("/message_boards/view_statistics"));
						navigationItem.setHref(viewStatisticsURL);
						navigationItem.setLabel(LanguageUtil.get(request, "statistics"));
					});
			}
		}
	%>'
/>

<div class="lfr-alert-container"></div>
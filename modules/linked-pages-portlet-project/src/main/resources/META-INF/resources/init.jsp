<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.grow.linkedpages.LinkedPagesView" %>
<%@ page import="com.liferay.grow.linkedpages.util.LinkedPagesPortletKeys" %>
<%@ page import="com.liferay.grow.linkedpages.util.PageLink" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletRequest" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

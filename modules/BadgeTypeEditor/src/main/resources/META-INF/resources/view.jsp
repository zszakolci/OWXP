<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.grow.gamification.service.BadgeTypeLocalServiceUtil" %>
<%@ page import="com.liferay.document.library.kernel.util.DLUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil" %>
<%@ page import="com.liferay.document.library.kernel.exception.DuplicateFileEntryException" %>
<liferay-ui:error exception="<%= DuplicateFileEntryException.class %>" message="badge-image-file-already-exists" />

<div class="container">
	<div class="row">
		<div class="col-sm">
			<liferay-ui:search-container total="<%= BadgeTypeLocalServiceUtil.getBadgeTypesCount() %>">
				<liferay-ui:search-container-results
					results="<%= BadgeTypeLocalServiceUtil.getBadgeTypes( 
						searchContainer.getStart(), searchContainer.getEnd()) %>" />
					<liferay-ui:search-container-row className="com.liferay.grow.gamification.model.BadgeType" modelVar="badgeType">
						<liferay-ui:search-container-column-text name="Badge">
							<%
								FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(badgeType.getFileEntryId());
								String downloadUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, "", false, true);
							%>
							<p class="badge-icon">
								<img class="badge-image" src="<%= downloadUrl %>" />
							</p>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text property="type" />
			
						<liferay-ui:search-container-column-text name="User Created">
							<c:out value="${badgeType.getUserName()}"></c:out>
						</liferay-ui:search-container-column-text>
			
						<liferay-ui:search-container-column-text name="Available Since">
							<c:if test="${badgeType.getAssignableFrom() != null}">
								<%= DateUtil.getDate(badgeType.getAssignableFrom(), "yyyy-MM-dd", Locale.US) %>
							</c:if>
							<c:if test="${badgeType.getAssignableFrom() == null}">
								Start of GROW
							</c:if>
						</liferay-ui:search-container-column-text>
			
						<liferay-ui:search-container-column-text name="Available Until">
							<c:if test="${badgeType.getAssignableTo() != null}">
								<%= DateUtil.getDate(badgeType.getAssignableTo(), "yyyy-MM-dd", Locale.US) %>
							</c:if>
							<c:if test="${badgeType.getAssignableTo() == null}">
								Forever
							</c:if>
						</liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</div>
	<div class="row">
		<div class="col-sm">
			<button type="button" class="btn btn-primary right" data-toggle="modal" data-target="#badgeTypeModal">+</button>
		</div>
	</div>
</div>
<portlet:actionURL name="addBadgeType" var="addBadgeTypeURL" />

<c:if test="${themeDisplay.isSignedIn() == true}">
	<div class="modal" id="badgeTypeModal" tabindex="-1" role="dialog" aria-hidden="true" style="display:none; z-index">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<aui:form name="badgeForm" id="badgeForm" method="post" action="<%= addBadgeTypeURL %>" enctype="multipart/form-data">
				<aui:input type="hidden" id="userId" name="userId" value=""/>

				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Add Badge Type</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<aui:input name="type" type="input" value="" class="form-control" />
						</div>
						<div class="form-group">
							<aui:input name="availableFrom" type="date" value="" class="form-control" />
						</div>
						<div class="form-group">
							<aui:input name="availableTo" type="date" value="" class="form-control" />
						</div>
						<div class="form-group">
							<aui:input name="fileEntry" type="file" value="" class="form-control" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
						<button type="submit" onclick="addBadgeType()" class="btn btn-primary">Add Badge Type</button>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</c:if>
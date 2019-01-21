

<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.document.library.kernel.exception.DuplicateFileEntryException" %><%@
page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %><%@
page import="com.liferay.document.library.kernel.util.DLUtil" %><%@
page import="com.liferay.grow.gamification.service.BadgeTypeLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.repository.model.FileEntry" %><%@
page import="com.liferay.portal.kernel.util.DateUtil" %>

<%@ page import="java.util.Locale" %>

<liferay-ui:error exception="<%= DuplicateFileEntryException.class %>" message="badge-image-file-already-exists" />

<div class="container">
	<div class="row">
		<div class="col-sm">
			<liferay-ui:search-container total="<%= BadgeTypeLocalServiceUtil.getBadgeTypesCount() %>">
				<liferay-ui:search-container-results
					results="<%= BadgeTypeLocalServiceUtil.getBadgeTypes(
						searchContainer.getStart(), searchContainer.getEnd()) %>"
					/>

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
			<button class="btn btn-primary right" data-target="#badgeTypeModal" data-toggle="modal" type="button">+</button>
		</div>
	</div>
</div>

<portlet:actionURL name="addBadgeType" var="addBadgeTypeURL" />

<c:if test="${themeDisplay.isSignedIn() == true}">
	<div aria-hidden="true" class="modal" id="badgeTypeModal" role="dialog" style="display:none; z-index" tabindex="-1">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<aui:form action="<%= addBadgeTypeURL %>" enctype="multipart/form-data" id="badgeForm" method="post" name="badgeForm">
				<aui:input id="userId" name="userId" type="hidden" value="" />

				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Add Badge Type</h5>
						<button aria-label="Close" class="close" data-dismiss="modal" type="button">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<div class="modal-body">
						<div class="form-group">
							<input class="form-control" id="_badgetypeeditor_type" name="_badgetypeeditor_type" required="required" type="input" value="" />
						</div>

						<div class="form-group">
							<aui:input class="form-control" name="availableFrom" type="date" value="" />
						</div>

						<div class="form-group">
							<aui:input class="form-control" name="availableTo" type="date" value="" />
						</div>

						<div class="form-group">
							<label for="fileEntry">Upload a transparent PNG file with 200x200 pixel size.</label>
							<input class="form-control" name="fileEntry" required="required" type="file" value="" />
						</div>
					</div>

					<div class="modal-footer">
						<button class="btn btn-secondary" data-dismiss="modal" type="button">Cancel</button>
						<button class="btn btn-primary" onclick="addBadgeType()" type="submit">Add Badge Type</button>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</c:if>
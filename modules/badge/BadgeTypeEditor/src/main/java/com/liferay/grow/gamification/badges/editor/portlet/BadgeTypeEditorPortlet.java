package com.liferay.grow.gamification.badges.editor.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.grow.gamification.badges.editor.constants.BadgeTypeEditorPortletKeys;
import com.liferay.grow.gamification.model.BadgeType;
import com.liferay.grow.gamification.service.BadgeTypeLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author vili
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.header-portlet-css=/css/style.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/jquery.form-validator.min.js",
		"javax.portlet.name=" + BadgeTypeEditorPortletKeys.BadgeTypeEditor,
		"javax.portlet.display-name=Badge Type Editor",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BadgeTypeEditorPortlet extends MVCPortlet {

	public void addBadgeType(ActionRequest actionRequest, ActionResponse actionResponse) {
		String type = actionRequest.getParameter(BadgeTypeEditorPortletKeys.TYPE);
		String availableFrom = actionRequest.getParameter(BadgeTypeEditorPortletKeys.AVAILABLE_FROM);
		String availableTo = actionRequest.getParameter(BadgeTypeEditorPortletKeys.AVAILABLE_TO);
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String fileName = "";

		try {
			long badgeTypeId = _counterLocalService.increment(BadgeType.class.getName());

			User user = (User)actionRequest.getAttribute(WebKeys.USER);

			BadgeType badgeType = _badgeTypeLocalService.createBadgeType(badgeTypeId);

			if (!availableFrom.equals("")) {
				badgeType.setAssignableFrom(_parseDate(availableFrom));
			}

			if (!availableTo.equals("")) {
				badgeType.setAssignableTo(_parseDate(availableTo));
			}

			badgeType.setCompanyId(user.getCompanyId());
			badgeType.setCreateDate(new Date());

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

			if (uploadRequest.getSize(BadgeTypeEditorPortletKeys.FILE_ENTRY) == 0) {
				throw new Exception("Received file is 0 bytes!");
			}
	 
			// Get the uploaded file as a file.
			File uploadedFile = uploadRequest.getFile(BadgeTypeEditorPortletKeys.FILE_ENTRY);
	 
			fileName = uploadRequest.getFileName(BadgeTypeEditorPortletKeys.FILE_ENTRY);
			Folder badgesFolder = null;

			try {
				badgesFolder = _dlAppLocalService.getFolder(themeDisplay.getSiteGroupId(), 0, BadgeTypeEditorPortletKeys.BADGES);
			}
			catch (NoSuchFolderException nsfe) {
				badgesFolder = _dlAppLocalService.addFolder(user.getUserId(), themeDisplay.getSiteGroupId(), 0, BadgeTypeEditorPortletKeys.BADGES, BadgeTypeEditorPortletKeys.FOLDER_DESCRIPTION, new ServiceContext());
			}

			FileEntry fileEntry = _dlAppLocalService.addFileEntry(user.getUserId(), badgesFolder.getRepositoryId(), badgesFolder.getFolderId(), fileName, MimeTypesUtil.getContentType(fileName), FileUtil.getBytes(uploadedFile), new ServiceContext());

			badgeType.setFileEntryId(fileEntry.getFileEntryId());
			badgeType.setGroupId(user.getGroupId());
			badgeType.setModifiedDate(new Date());
			badgeType.setType(type);
			badgeType.setUserId(user.getUserId());
			badgeType.setUserName(user.getFullName());

			_badgeTypeLocalService.addBadgeType(badgeType);

		}
		catch (DuplicateFileEntryException dfee) {
			_log.error(dfee);
			SessionErrors.add(actionRequest, DuplicateFileEntryException.class);
		}
		catch (org.hibernate.exception.ConstraintViolationException cve) {
			SessionErrors.add(actionRequest, org.hibernate.exception.ConstraintViolationException.class);
		}
		catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getMessage());
		}
		
	}

	private Date _parseDate(String date) throws Exception {
			return DateUtil.parseDate("yyyy-MM-dd", date, Locale.US);
	}

	@Reference(unbind = "-")
	protected void setBadgeTypeLocalService(BadgeTypeLocalService badgeTypeLocalService) {
		_badgeTypeLocalService = badgeTypeLocalService;
	}

	@Reference(unbind = "-")
	protected void setCounterLocalService(CounterLocalService counterLocalService) {
		_counterLocalService = counterLocalService;
	}

	@Reference(unbind = "-")
	protected void setDLAppLocalService(DLAppLocalService dlAppLocalService) {
		_dlAppLocalService = dlAppLocalService;
	}

	private BadgeTypeLocalService _badgeTypeLocalService;
	private CounterLocalService _counterLocalService;
	private DLAppLocalService _dlAppLocalService;

	private Log _log = LogFactoryUtil.getLog(BadgeTypeEditorPortlet.class.getName());

}
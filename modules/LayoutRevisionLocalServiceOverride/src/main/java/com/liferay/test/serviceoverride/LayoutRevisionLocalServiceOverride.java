package com.liferay.test.serviceoverride;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutRevision;
import com.liferay.portal.kernel.service.LayoutRevisionLocalServiceWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author tamas.molnar
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class LayoutRevisionLocalServiceOverride
	extends LayoutRevisionLocalServiceWrapper {

	public LayoutRevisionLocalServiceOverride() {
		super(null);
	}

	@Override
	public LayoutRevision updateLayoutRevision(
			long userId, long layoutRevisionId, long layoutBranchId,
			String name, String title, String description, String keywords,
			String robots, String typeSettings, boolean iconImage,
			long iconImageId, String themeId, String colorSchemeId, String css,
			ServiceContext serviceContext)
		throws PortalException {

		System.out.println("Inside the updateLayoutRevision function");

		return super.updateLayoutRevision(
			userId, layoutRevisionId, layoutBranchId, name, title, description,
			keywords, robots, typeSettings, iconImage, iconImageId, themeId,
			colorSchemeId, css, serviceContext);
	}

}
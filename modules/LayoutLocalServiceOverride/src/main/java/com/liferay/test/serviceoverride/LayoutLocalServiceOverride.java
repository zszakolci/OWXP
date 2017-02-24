package com.liferay.test.serviceoverride;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalServiceWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author tamas.molnar
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class LayoutLocalServiceOverride extends LayoutLocalServiceWrapper {

	public LayoutLocalServiceOverride() {
		super(null);
	}

	@Override
	public Layout updateLayout(
			long groupId, boolean privateLayout, long layoutId,
			long parentLayoutId, Map<Locale, String> nameMap,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> keywordsMap, Map<Locale, String> robotsMap,
			String type, boolean hidden, Map<Locale, String> friendlyURLMap,
			boolean iconImage, byte[] iconBytes, ServiceContext serviceContext)
		throws PortalException {

		System.out.println("Inside the updateLayout function");

		return super.updateLayout(
			groupId, privateLayout, layoutId, parentLayoutId, nameMap, titleMap,
			descriptionMap, keywordsMap, robotsMap, type, hidden,
			friendlyURLMap, iconImage, iconBytes, serviceContext);
	}

}
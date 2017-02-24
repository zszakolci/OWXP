package com.liferay.test.serviceoverride;

import com.liferay.portal.kernel.service.LayoutRevisionLocalServiceWrapper;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author tamas.molnar
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class LayoutRevisionLocalServiceOverride extends LayoutRevisionLocalServiceWrapper {

	public LayoutRevisionLocalServiceOverride() {
		super(null);
	}

}
package com.liferay.test.serviceoverride;

import com.liferay.portal.kernel.service.LayoutLocalServiceWrapper;

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
public class LayoutLocalServiceOverride extends LayoutLocalServiceWrapper {

	public LayoutLocalServiceOverride() {
		super(null);
	}

}
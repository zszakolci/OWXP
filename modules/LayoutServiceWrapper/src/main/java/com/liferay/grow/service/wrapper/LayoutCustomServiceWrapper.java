package com.liferay.grow.service.wrapper;

import com.liferay.portal.kernel.service.LayoutLocalServiceWrapper;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Liferay
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class LayoutCustomServiceWrapper extends LayoutLocalServiceWrapper {

	public LayoutCustomServiceWrapper() {
		super(null);
	}

}
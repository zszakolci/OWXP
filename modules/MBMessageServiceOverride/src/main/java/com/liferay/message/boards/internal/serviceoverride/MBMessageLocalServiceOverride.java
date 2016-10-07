package com.liferay.message.boards.internal.serviceoverride;

import com.liferay.message.boards.kernel.service.MBMessageLocalServiceWrapper;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class MBMessageLocalServiceOverride extends MBMessageLocalServiceWrapper {

	public MBMessageLocalServiceOverride() {
		super(null);
	}

}
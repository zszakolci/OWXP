package com.liferay.user.notification.event.service;

import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceWrapper;

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
public class UserNotificationEventCustomServiceWrapper extends UserNotificationEventLocalServiceWrapper {

	public UserNotificationEventCustomServiceWrapper() {
		super(null);
	}

}
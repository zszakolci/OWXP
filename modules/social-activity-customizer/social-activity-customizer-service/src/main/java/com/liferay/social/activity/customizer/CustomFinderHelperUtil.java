/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.social.activity.customizer;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Istvan Sajtos
 */
public class CustomFinderHelperUtil {

	public static Class getImplClass(
		String implClassName, ClassLoader classLoader) {

		Class<?> clazz = _classMap.get(implClassName);

		if (clazz == null) {
			try {
				if (classLoader == null) {
					Thread currentThread = Thread.currentThread();

					classLoader = currentThread.getContextClassLoader();
				}

				clazz = classLoader.loadClass(implClassName);

				_classMap.put(implClassName, clazz);
			}
			catch (Exception e) {
				_log.error("Unable find model " + implClassName, e);
			}
		}

		return clazz;
	}

	public static Session openPortalSession() throws ORMException {
		return _sessionFactory.openSession();
	}

	private static Log _log = LogFactoryUtil.getLog(
		CustomFinderHelperUtil.class);

	private static Map<String, Class> _classMap = new HashMap<>();
	private static SessionFactory _sessionFactory =
		(SessionFactory)PortalBeanLocatorUtil.locate("liferaySessionFactory");

}
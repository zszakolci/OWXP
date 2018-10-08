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

package com.liferay.grow.gamification.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Subscriber. This utility wraps
 * {@link com.liferay.grow.gamification.service.impl.SubscriberLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Vilmos Papp
 * @see SubscriberLocalService
 * @see com.liferay.grow.gamification.service.base.SubscriberLocalServiceBaseImpl
 * @see com.liferay.grow.gamification.service.impl.SubscriberLocalServiceImpl
 * @generated
 */
@ProviderType
public class SubscriberLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.grow.gamification.service.impl.SubscriberLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the subscriber to the database. Also notifies the appropriate model listeners.
	*
	* @param subscriber the subscriber
	* @return the subscriber that was added
	*/
	public static com.liferay.grow.gamification.model.Subscriber addSubscriber(
		com.liferay.grow.gamification.model.Subscriber subscriber) {
		return getService().addSubscriber(subscriber);
	}

	/**
	* Creates a new subscriber with the primary key. Does not add the subscriber to the database.
	*
	* @param subscriberId the primary key for the new subscriber
	* @return the new subscriber
	*/
	public static com.liferay.grow.gamification.model.Subscriber createSubscriber(
		long subscriberId) {
		return getService().createSubscriber(subscriberId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the subscriber with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subscriberId the primary key of the subscriber
	* @return the subscriber that was removed
	* @throws PortalException if a subscriber with the primary key could not be found
	*/
	public static com.liferay.grow.gamification.model.Subscriber deleteSubscriber(
		long subscriberId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSubscriber(subscriberId);
	}

	/**
	* Deletes the subscriber from the database. Also notifies the appropriate model listeners.
	*
	* @param subscriber the subscriber
	* @return the subscriber that was removed
	*/
	public static com.liferay.grow.gamification.model.Subscriber deleteSubscriber(
		com.liferay.grow.gamification.model.Subscriber subscriber) {
		return getService().deleteSubscriber(subscriber);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.grow.gamification.model.impl.SubscriberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.grow.gamification.model.impl.SubscriberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.grow.gamification.model.Subscriber fetchSubscriber(
		long subscriberId) {
		return getService().fetchSubscriber(subscriberId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the subscriber with the primary key.
	*
	* @param subscriberId the primary key of the subscriber
	* @return the subscriber
	* @throws PortalException if a subscriber with the primary key could not be found
	*/
	public static com.liferay.grow.gamification.model.Subscriber getSubscriber(
		long subscriberId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSubscriber(subscriberId);
	}

	/**
	* Returns a range of all the subscribers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.grow.gamification.model.impl.SubscriberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscribers
	* @param end the upper bound of the range of subscribers (not inclusive)
	* @return the range of subscribers
	*/
	public static java.util.List<com.liferay.grow.gamification.model.Subscriber> getSubscribers(
		int start, int end) {
		return getService().getSubscribers(start, end);
	}

	/**
	* Returns the number of subscribers.
	*
	* @return the number of subscribers
	*/
	public static int getSubscribersCount() {
		return getService().getSubscribersCount();
	}

	/**
	* Updates the subscriber in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subscriber the subscriber
	* @return the subscriber that was updated
	*/
	public static com.liferay.grow.gamification.model.Subscriber updateSubscriber(
		com.liferay.grow.gamification.model.Subscriber subscriber) {
		return getService().updateSubscriber(subscriber);
	}

	public static SubscriberLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SubscriberLocalService, SubscriberLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SubscriberLocalService.class);

		ServiceTracker<SubscriberLocalService, SubscriberLocalService> serviceTracker =
			new ServiceTracker<SubscriberLocalService, SubscriberLocalService>(bundle.getBundleContext(),
				SubscriberLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
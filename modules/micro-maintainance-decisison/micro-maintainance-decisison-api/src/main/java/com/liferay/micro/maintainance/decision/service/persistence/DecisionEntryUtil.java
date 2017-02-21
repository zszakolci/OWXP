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

package com.liferay.micro.maintainance.decision.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.decision.model.DecisionEntry;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the decision entry service. This utility wraps {@link com.liferay.micro.maintainance.decision.service.persistence.impl.DecisionEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntryPersistence
 * @see com.liferay.micro.maintainance.decision.service.persistence.impl.DecisionEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class DecisionEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DecisionEntry decisionEntry) {
		getPersistence().clearCache(decisionEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DecisionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DecisionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DecisionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DecisionEntry update(DecisionEntry decisionEntry) {
		return getPersistence().update(decisionEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DecisionEntry update(DecisionEntry decisionEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(decisionEntry, serviceContext);
	}

	/**
	* Returns all the decision entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the decision entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByUuid_First(java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByUuid_Last(java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where uuid = &#63;.
	*
	* @param decisionId the primary key of the current decision entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByUuid_PrevAndNext(long decisionId,
		java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(decisionId, uuid, orderByComparator);
	}

	/**
	* Removes all the decision entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of decision entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching decision entries
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param decisionId the primary key of the current decision entry
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByUuid_C_PrevAndNext(long decisionId,
		java.lang.String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(decisionId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of decision entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the decision entries where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByDecisionId(long decisionId) {
		return getPersistence().findByDecisionId(decisionId);
	}

	/**
	* Returns a range of all the decision entries where decisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByDecisionId(long decisionId,
		int start, int end) {
		return getPersistence().findByDecisionId(decisionId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByDecisionId(long decisionId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByDecisionId(decisionId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByDecisionId(long decisionId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDecisionId(decisionId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByDecisionId_First(long decisionId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByDecisionId_First(decisionId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByDecisionId_First(long decisionId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByDecisionId_First(decisionId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByDecisionId_Last(long decisionId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByDecisionId_Last(decisionId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByDecisionId_Last(long decisionId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByDecisionId_Last(decisionId, orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionId = &#63; from the database.
	*
	* @param decisionId the decision ID
	*/
	public static void removeByDecisionId(long decisionId) {
		getPersistence().removeByDecisionId(decisionId);
	}

	/**
	* Returns the number of decision entries where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @return the number of matching decision entries
	*/
	public static int countByDecisionId(long decisionId) {
		return getPersistence().countByDecisionId(decisionId);
	}

	/**
	* Returns all the decision entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the decision entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByCompanyId_First(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByCompanyId_First(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByCompanyId_Last(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByCompanyId_Last(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63;.
	*
	* @param decisionId the primary key of the current decision entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByCompanyId_PrevAndNext(long decisionId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(decisionId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of decision entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the decision entries where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_C(long decisionId, long companyId) {
		return getPersistence().findByD_C(decisionId, companyId);
	}

	/**
	* Returns a range of all the decision entries where decisionId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_C(long decisionId,
		long companyId, int start, int end) {
		return getPersistence().findByD_C(decisionId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_C(long decisionId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_C(decisionId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_C(long decisionId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_C(decisionId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_C_First(long decisionId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_C_First(decisionId, companyId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_C_First(long decisionId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_C_First(decisionId, companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_C_Last(long decisionId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_C_Last(decisionId, companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_C_Last(long decisionId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_C_Last(decisionId, companyId, orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionId = &#63; and companyId = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	*/
	public static void removeByD_C(long decisionId, long companyId) {
		getPersistence().removeByD_C(decisionId, companyId);
	}

	/**
	* Returns the number of decision entries where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public static int countByD_C(long decisionId, long companyId) {
		return getPersistence().countByD_C(decisionId, companyId);
	}

	/**
	* Returns all the decision entries where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_A(long decisionId, long analysisId) {
		return getPersistence().findByD_A(decisionId, analysisId);
	}

	/**
	* Returns a range of all the decision entries where decisionId = &#63; and analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_A(long decisionId,
		long analysisId, int start, int end) {
		return getPersistence().findByD_A(decisionId, analysisId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_A(long decisionId,
		long analysisId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_A(decisionId, analysisId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_A(long decisionId,
		long analysisId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_A(decisionId, analysisId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_A_First(long decisionId,
		long analysisId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_A_First(decisionId, analysisId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_A_First(long decisionId,
		long analysisId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_A_First(decisionId, analysisId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_A_Last(long decisionId,
		long analysisId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_A_Last(decisionId, analysisId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_A_Last(long decisionId,
		long analysisId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_A_Last(decisionId, analysisId, orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionId = &#63; and analysisId = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	*/
	public static void removeByD_A(long decisionId, long analysisId) {
		getPersistence().removeByD_A(decisionId, analysisId);
	}

	/**
	* Returns the number of decision entries where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @return the number of matching decision entries
	*/
	public static int countByD_A(long decisionId, long analysisId) {
		return getPersistence().countByD_A(decisionId, analysisId);
	}

	/**
	* Returns all the decision entries where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_H(long decisionId, boolean handled) {
		return getPersistence().findByD_H(decisionId, handled);
	}

	/**
	* Returns a range of all the decision entries where decisionId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_H(long decisionId,
		boolean handled, int start, int end) {
		return getPersistence().findByD_H(decisionId, handled, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_H(long decisionId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_H(decisionId, handled, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_H(long decisionId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_H(decisionId, handled, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_H_First(long decisionId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_H_First(decisionId, handled, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_H_First(long decisionId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_H_First(decisionId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_H_Last(long decisionId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_H_Last(decisionId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_H_Last(long decisionId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_H_Last(decisionId, handled, orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionId = &#63; and handled = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	*/
	public static void removeByD_H(long decisionId, boolean handled) {
		getPersistence().removeByD_H(decisionId, handled);
	}

	/**
	* Returns the number of decision entries where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public static int countByD_H(long decisionId, boolean handled) {
		return getPersistence().countByD_H(decisionId, handled);
	}

	/**
	* Returns all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_A_H(long decisionId,
		long analysisId, boolean handled) {
		return getPersistence().findByD_A_H(decisionId, analysisId, handled);
	}

	/**
	* Returns a range of all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_A_H(long decisionId,
		long analysisId, boolean handled, int start, int end) {
		return getPersistence()
				   .findByD_A_H(decisionId, analysisId, handled, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_A_H(long decisionId,
		long analysisId, boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_A_H(decisionId, analysisId, handled, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_A_H(long decisionId,
		long analysisId, boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_A_H(decisionId, analysisId, handled, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_A_H_First(long decisionId,
		long analysisId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_A_H_First(decisionId, analysisId, handled,
			orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_A_H_First(long decisionId,
		long analysisId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_A_H_First(decisionId, analysisId, handled,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_A_H_Last(long decisionId,
		long analysisId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_A_H_Last(decisionId, analysisId, handled,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_A_H_Last(long decisionId,
		long analysisId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_A_H_Last(decisionId, analysisId, handled,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	*/
	public static void removeByD_A_H(long decisionId, long analysisId,
		boolean handled) {
		getPersistence().removeByD_A_H(decisionId, analysisId, handled);
	}

	/**
	* Returns the number of decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public static int countByD_A_H(long decisionId, long analysisId,
		boolean handled) {
		return getPersistence().countByD_A_H(decisionId, analysisId, handled);
	}

	/**
	* Returns all the decision entries where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_U(long decisionId, long userId) {
		return getPersistence().findByD_U(decisionId, userId);
	}

	/**
	* Returns a range of all the decision entries where decisionId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U(long decisionId, long userId,
		int start, int end) {
		return getPersistence().findByD_U(decisionId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U(long decisionId, long userId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_U(decisionId, userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U(long decisionId, long userId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_U(decisionId, userId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_U_First(long decisionId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_U_First(decisionId, userId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_U_First(long decisionId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_U_First(decisionId, userId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_U_Last(long decisionId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_U_Last(decisionId, userId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_U_Last(long decisionId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_U_Last(decisionId, userId, orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionId = &#63; and userId = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	*/
	public static void removeByD_U(long decisionId, long userId) {
		getPersistence().removeByD_U(decisionId, userId);
	}

	/**
	* Returns the number of decision entries where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @return the number of matching decision entries
	*/
	public static int countByD_U(long decisionId, long userId) {
		return getPersistence().countByD_U(decisionId, userId);
	}

	/**
	* Returns all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_U_C(long decisionId, long userId,
		long companyId) {
		return getPersistence().findByD_U_C(decisionId, userId, companyId);
	}

	/**
	* Returns a range of all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U_C(long decisionId, long userId,
		long companyId, int start, int end) {
		return getPersistence()
				   .findByD_U_C(decisionId, userId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U_C(long decisionId, long userId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_U_C(decisionId, userId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U_C(long decisionId, long userId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_U_C(decisionId, userId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_U_C_First(long decisionId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_U_C_First(decisionId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_U_C_First(long decisionId,
		long userId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_U_C_First(decisionId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_U_C_Last(long decisionId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_U_C_Last(decisionId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_U_C_Last(long decisionId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_U_C_Last(decisionId, userId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public static void removeByD_U_C(long decisionId, long userId,
		long companyId) {
		getPersistence().removeByD_U_C(decisionId, userId, companyId);
	}

	/**
	* Returns the number of decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public static int countByD_U_C(long decisionId, long userId, long companyId) {
		return getPersistence().countByD_U_C(decisionId, userId, companyId);
	}

	/**
	* Returns all the decision entries where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByC_A(long companyId, long analysisId) {
		return getPersistence().findByC_A(companyId, analysisId);
	}

	/**
	* Returns a range of all the decision entries where companyId = &#63; and analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByC_A(long companyId,
		long analysisId, int start, int end) {
		return getPersistence().findByC_A(companyId, analysisId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63; and analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByC_A(long companyId,
		long analysisId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByC_A(companyId, analysisId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63; and analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByC_A(long companyId,
		long analysisId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_A(companyId, analysisId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByC_A_First(long companyId,
		long analysisId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_A_First(companyId, analysisId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByC_A_First(long companyId,
		long analysisId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_A_First(companyId, analysisId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByC_A_Last(long companyId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_A_Last(companyId, analysisId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByC_A_Last(long companyId,
		long analysisId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_A_Last(companyId, analysisId, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the primary key of the current decision entry
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByC_A_PrevAndNext(long decisionId,
		long companyId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_A_PrevAndNext(decisionId, companyId, analysisId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where companyId = &#63; and analysisId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	*/
	public static void removeByC_A(long companyId, long analysisId) {
		getPersistence().removeByC_A(companyId, analysisId);
	}

	/**
	* Returns the number of decision entries where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @return the number of matching decision entries
	*/
	public static int countByC_A(long companyId, long analysisId) {
		return getPersistence().countByC_A(companyId, analysisId);
	}

	/**
	* Returns all the decision entries where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByU_A(long userId, long analysisId) {
		return getPersistence().findByU_A(userId, analysisId);
	}

	/**
	* Returns a range of all the decision entries where userId = &#63; and analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_A(long userId, long analysisId,
		int start, int end) {
		return getPersistence().findByU_A(userId, analysisId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_A(long userId, long analysisId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByU_A(userId, analysisId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_A(long userId, long analysisId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_A(userId, analysisId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_A_First(long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_A_First(userId, analysisId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_A_First(long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_A_First(userId, analysisId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_A_Last(long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_A_Last(userId, analysisId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_A_Last(long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_A_Last(userId, analysisId, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the primary key of the current decision entry
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByU_A_PrevAndNext(long decisionId,
		long userId, long analysisId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_A_PrevAndNext(decisionId, userId, analysisId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where userId = &#63; and analysisId = &#63; from the database.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	*/
	public static void removeByU_A(long userId, long analysisId) {
		getPersistence().removeByU_A(userId, analysisId);
	}

	/**
	* Returns the number of decision entries where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @return the number of matching decision entries
	*/
	public static int countByU_A(long userId, long analysisId) {
		return getPersistence().countByU_A(userId, analysisId);
	}

	/**
	* Returns all the decision entries where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByU_H(long userId, boolean handled) {
		return getPersistence().findByU_H(userId, handled);
	}

	/**
	* Returns a range of all the decision entries where userId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end) {
		return getPersistence().findByU_H(userId, handled, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByU_H(userId, handled, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_H(userId, handled, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_H_First(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_First(userId, handled, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_H_First(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_First(userId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_H_Last(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_Last(userId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_H_Last(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_Last(userId, handled, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param decisionId the primary key of the current decision entry
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByU_H_PrevAndNext(long decisionId,
		long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_PrevAndNext(decisionId, userId, handled,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where userId = &#63; and handled = &#63; from the database.
	*
	* @param userId the user ID
	* @param handled the handled
	*/
	public static void removeByU_H(long userId, boolean handled) {
		getPersistence().removeByU_H(userId, handled);
	}

	/**
	* Returns the number of decision entries where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public static int countByU_H(long userId, boolean handled) {
		return getPersistence().countByU_H(userId, handled);
	}

	/**
	* Returns all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionId) {
		return getPersistence().findByU_H_D(userId, handled, decisionId);
	}

	/**
	* Returns a range of all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionId, int start, int end) {
		return getPersistence()
				   .findByU_H_D(userId, handled, decisionId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByU_H_D(userId, handled, decisionId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_H_D(userId, handled, decisionId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_H_D_First(long userId, boolean handled,
		long decisionId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_D_First(userId, handled, decisionId,
			orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_H_D_First(long userId,
		boolean handled, long decisionId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_D_First(userId, handled, decisionId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_H_D_Last(long userId, boolean handled,
		long decisionId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_D_Last(userId, handled, decisionId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_H_D_Last(long userId, boolean handled,
		long decisionId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_D_Last(userId, handled, decisionId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63; from the database.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	*/
	public static void removeByU_H_D(long userId, boolean handled,
		long decisionId) {
		getPersistence().removeByU_H_D(userId, handled, decisionId);
	}

	/**
	* Returns the number of decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @return the number of matching decision entries
	*/
	public static int countByU_H_D(long userId, boolean handled, long decisionId) {
		return getPersistence().countByU_H_D(userId, handled, decisionId);
	}

	/**
	* Returns all the decision entries where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByC_NotH(long companyId,
		boolean handled) {
		return getPersistence().findByC_NotH(companyId, handled);
	}

	/**
	* Returns a range of all the decision entries where companyId = &#63; and handled &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByC_NotH(long companyId,
		boolean handled, int start, int end) {
		return getPersistence().findByC_NotH(companyId, handled, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63; and handled &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByC_NotH(long companyId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByC_NotH(companyId, handled, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63; and handled &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByC_NotH(long companyId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_NotH(companyId, handled, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByC_NotH_First(long companyId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_NotH_First(companyId, handled, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByC_NotH_First(long companyId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_NotH_First(companyId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByC_NotH_Last(long companyId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_NotH_Last(companyId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByC_NotH_Last(long companyId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_NotH_Last(companyId, handled, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	*
	* @param decisionId the primary key of the current decision entry
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByC_NotH_PrevAndNext(long decisionId,
		long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_NotH_PrevAndNext(decisionId, companyId, handled,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where companyId = &#63; and handled &ne; &#63; from the database.
	*
	* @param companyId the company ID
	* @param handled the handled
	*/
	public static void removeByC_NotH(long companyId, boolean handled) {
		getPersistence().removeByC_NotH(companyId, handled);
	}

	/**
	* Returns the number of decision entries where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public static int countByC_NotH(long companyId, boolean handled) {
		return getPersistence().countByC_NotH(companyId, handled);
	}

	/**
	* Caches the decision entry in the entity cache if it is enabled.
	*
	* @param decisionEntry the decision entry
	*/
	public static void cacheResult(DecisionEntry decisionEntry) {
		getPersistence().cacheResult(decisionEntry);
	}

	/**
	* Caches the decision entries in the entity cache if it is enabled.
	*
	* @param decisionEntries the decision entries
	*/
	public static void cacheResult(List<DecisionEntry> decisionEntries) {
		getPersistence().cacheResult(decisionEntries);
	}

	/**
	* Creates a new decision entry with the primary key. Does not add the decision entry to the database.
	*
	* @param decisionId the primary key for the new decision entry
	* @return the new decision entry
	*/
	public static DecisionEntry create(long decisionId) {
		return getPersistence().create(decisionId);
	}

	/**
	* Removes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param decisionId the primary key of the decision entry
	* @return the decision entry that was removed
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry remove(long decisionId)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().remove(decisionId);
	}

	public static DecisionEntry updateImpl(DecisionEntry decisionEntry) {
		return getPersistence().updateImpl(decisionEntry);
	}

	/**
	* Returns the decision entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param decisionId the primary key of the decision entry
	* @return the decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry findByPrimaryKey(long decisionId)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(decisionId);
	}

	/**
	* Returns the decision entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param decisionId the primary key of the decision entry
	* @return the decision entry, or <code>null</code> if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry fetchByPrimaryKey(long decisionId) {
		return getPersistence().fetchByPrimaryKey(decisionId);
	}

	public static java.util.Map<java.io.Serializable, DecisionEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the decision entries.
	*
	* @return the decision entries
	*/
	public static List<DecisionEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the decision entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of decision entries
	*/
	public static List<DecisionEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the decision entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of decision entries
	*/
	public static List<DecisionEntry> findAll(int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of decision entries
	*/
	public static List<DecisionEntry> findAll(int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the decision entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of decision entries.
	*
	* @return the number of decision entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DecisionEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DecisionEntryPersistence, DecisionEntryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DecisionEntryPersistence.class);
}
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

import com.liferay.micro.maintainance.decision.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.decision.model.DecisionEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the decision entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.decision.service.persistence.impl.DecisionEntryPersistenceImpl
 * @see DecisionEntryUtil
 * @generated
 */
@ProviderType
public interface DecisionEntryPersistence extends BasePersistence<DecisionEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DecisionEntryUtil} to access the decision entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the decision entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByUuid(java.lang.String uuid);

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
	public java.util.List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where uuid = &#63;.
	*
	* @param decisionId the primary key of the current decision entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry[] findByUuid_PrevAndNext(long decisionId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of decision entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching decision entries
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry[] findByUuid_C_PrevAndNext(long decisionId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of decision entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the decision entries where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByDecisionId(long decisionId);

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
	public java.util.List<DecisionEntry> findByDecisionId(long decisionId,
		int start, int end);

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
	public java.util.List<DecisionEntry> findByDecisionId(long decisionId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByDecisionId(long decisionId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByDecisionId_First(long decisionId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByDecisionId_First(long decisionId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByDecisionId_Last(long decisionId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByDecisionId_Last(long decisionId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionId = &#63; from the database.
	*
	* @param decisionId the decision ID
	*/
	public void removeByDecisionId(long decisionId);

	/**
	* Returns the number of decision entries where decisionId = &#63;.
	*
	* @param decisionId the decision ID
	* @return the number of matching decision entries
	*/
	public int countByDecisionId(long decisionId);

	/**
	* Returns all the decision entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByCompanyId(long companyId);

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
	public java.util.List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end);

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
	public java.util.List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63;.
	*
	* @param decisionId the primary key of the current decision entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry[] findByCompanyId_PrevAndNext(long decisionId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of decision entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns all the decision entries where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_C(long decisionId,
		long companyId);

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
	public java.util.List<DecisionEntry> findByD_C(long decisionId,
		long companyId, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_C(long decisionId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_C(long decisionId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_C_First(long decisionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_C_First(long decisionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_C_Last(long decisionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_C_Last(long decisionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionId = &#63; and companyId = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	*/
	public void removeByD_C(long decisionId, long companyId);

	/**
	* Returns the number of decision entries where decisionId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public int countByD_C(long decisionId, long companyId);

	/**
	* Returns all the decision entries where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_A(long decisionId,
		long analysisId);

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
	public java.util.List<DecisionEntry> findByD_A(long decisionId,
		long analysisId, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_A(long decisionId,
		long analysisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_A(long decisionId,
		long analysisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_A_First(long decisionId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_A_First(long decisionId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_A_Last(long decisionId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_A_Last(long decisionId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionId = &#63; and analysisId = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	*/
	public void removeByD_A(long decisionId, long analysisId);

	/**
	* Returns the number of decision entries where decisionId = &#63; and analysisId = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @return the number of matching decision entries
	*/
	public int countByD_A(long decisionId, long analysisId);

	/**
	* Returns all the decision entries where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_H(long decisionId,
		boolean handled);

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
	public java.util.List<DecisionEntry> findByD_H(long decisionId,
		boolean handled, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_H(long decisionId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_H(long decisionId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_H_First(long decisionId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_H_First(long decisionId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_H_Last(long decisionId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_H_Last(long decisionId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionId = &#63; and handled = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	*/
	public void removeByD_H(long decisionId, boolean handled);

	/**
	* Returns the number of decision entries where decisionId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public int countByD_H(long decisionId, boolean handled);

	/**
	* Returns all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_A_H(long decisionId,
		long analysisId, boolean handled);

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
	public java.util.List<DecisionEntry> findByD_A_H(long decisionId,
		long analysisId, boolean handled, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_A_H(long decisionId,
		long analysisId, boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_A_H(long decisionId,
		long analysisId, boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

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
	public DecisionEntry findByD_A_H_First(long decisionId, long analysisId,
		boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_A_H_First(long decisionId, long analysisId,
		boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry findByD_A_H_Last(long decisionId, long analysisId,
		boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_A_H_Last(long decisionId, long analysisId,
		boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	*/
	public void removeByD_A_H(long decisionId, long analysisId, boolean handled);

	/**
	* Returns the number of decision entries where decisionId = &#63; and analysisId = &#63; and handled = &#63;.
	*
	* @param decisionId the decision ID
	* @param analysisId the analysis ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public int countByD_A_H(long decisionId, long analysisId, boolean handled);

	/**
	* Returns all the decision entries where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_U(long decisionId, long userId);

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
	public java.util.List<DecisionEntry> findByD_U(long decisionId,
		long userId, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_U(long decisionId,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_U(long decisionId,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_U_First(long decisionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_U_First(long decisionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_U_Last(long decisionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_U_Last(long decisionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionId = &#63; and userId = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	*/
	public void removeByD_U(long decisionId, long userId);

	/**
	* Returns the number of decision entries where decisionId = &#63; and userId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @return the number of matching decision entries
	*/
	public int countByD_U(long decisionId, long userId);

	/**
	* Returns all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_U_C(long decisionId,
		long userId, long companyId);

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
	public java.util.List<DecisionEntry> findByD_U_C(long decisionId,
		long userId, long companyId, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_U_C(long decisionId,
		long userId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_U_C(long decisionId,
		long userId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

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
	public DecisionEntry findByD_U_C_First(long decisionId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_U_C_First(long decisionId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry findByD_U_C_Last(long decisionId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_U_C_Last(long decisionId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63; from the database.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public void removeByD_U_C(long decisionId, long userId, long companyId);

	/**
	* Returns the number of decision entries where decisionId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionId the decision ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public int countByD_U_C(long decisionId, long userId, long companyId);

	/**
	* Returns all the decision entries where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByC_A(long companyId,
		long analysisId);

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
	public java.util.List<DecisionEntry> findByC_A(long companyId,
		long analysisId, int start, int end);

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
	public java.util.List<DecisionEntry> findByC_A(long companyId,
		long analysisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByC_A(long companyId,
		long analysisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByC_A_First(long companyId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByC_A_First(long companyId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByC_A_Last(long companyId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByC_A_Last(long companyId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry[] findByC_A_PrevAndNext(long decisionId,
		long companyId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where companyId = &#63; and analysisId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	*/
	public void removeByC_A(long companyId, long analysisId);

	/**
	* Returns the number of decision entries where companyId = &#63; and analysisId = &#63;.
	*
	* @param companyId the company ID
	* @param analysisId the analysis ID
	* @return the number of matching decision entries
	*/
	public int countByC_A(long companyId, long analysisId);

	/**
	* Returns all the decision entries where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByU_A(long userId, long analysisId);

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
	public java.util.List<DecisionEntry> findByU_A(long userId,
		long analysisId, int start, int end);

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
	public java.util.List<DecisionEntry> findByU_A(long userId,
		long analysisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByU_A(long userId,
		long analysisId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByU_A_First(long userId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_A_First(long userId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByU_A_Last(long userId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_A_Last(long userId, long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry[] findByU_A_PrevAndNext(long decisionId, long userId,
		long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where userId = &#63; and analysisId = &#63; from the database.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	*/
	public void removeByU_A(long userId, long analysisId);

	/**
	* Returns the number of decision entries where userId = &#63; and analysisId = &#63;.
	*
	* @param userId the user ID
	* @param analysisId the analysis ID
	* @return the number of matching decision entries
	*/
	public int countByU_A(long userId, long analysisId);

	/**
	* Returns all the decision entries where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByU_H(long userId, boolean handled);

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
	public java.util.List<DecisionEntry> findByU_H(long userId,
		boolean handled, int start, int end);

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
	public java.util.List<DecisionEntry> findByU_H(long userId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByU_H(long userId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByU_H_First(long userId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_H_First(long userId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByU_H_Last(long userId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_H_Last(long userId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry[] findByU_H_PrevAndNext(long decisionId, long userId,
		boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where userId = &#63; and handled = &#63; from the database.
	*
	* @param userId the user ID
	* @param handled the handled
	*/
	public void removeByU_H(long userId, boolean handled);

	/**
	* Returns the number of decision entries where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public int countByU_H(long userId, boolean handled);

	/**
	* Returns all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByU_H_D(long userId,
		boolean handled, long decisionId);

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
	public java.util.List<DecisionEntry> findByU_H_D(long userId,
		boolean handled, long decisionId, int start, int end);

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
	public java.util.List<DecisionEntry> findByU_H_D(long userId,
		boolean handled, long decisionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByU_H_D(long userId,
		boolean handled, long decisionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

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
	public DecisionEntry findByU_H_D_First(long userId, boolean handled,
		long decisionId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_H_D_First(long userId, boolean handled,
		long decisionId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry findByU_H_D_Last(long userId, boolean handled,
		long decisionId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_H_D_Last(long userId, boolean handled,
		long decisionId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where userId = &#63; and handled = &#63; and decisionId = &#63; from the database.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	*/
	public void removeByU_H_D(long userId, boolean handled, long decisionId);

	/**
	* Returns the number of decision entries where userId = &#63; and handled = &#63; and decisionId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionId the decision ID
	* @return the number of matching decision entries
	*/
	public int countByU_H_D(long userId, boolean handled, long decisionId);

	/**
	* Returns all the decision entries where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByC_NotH(long companyId,
		boolean handled);

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
	public java.util.List<DecisionEntry> findByC_NotH(long companyId,
		boolean handled, int start, int end);

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
	public java.util.List<DecisionEntry> findByC_NotH(long companyId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByC_NotH(long companyId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByC_NotH_First(long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByC_NotH_First(long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByC_NotH_Last(long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByC_NotH_Last(long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry[] findByC_NotH_PrevAndNext(long decisionId,
		long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where companyId = &#63; and handled &ne; &#63; from the database.
	*
	* @param companyId the company ID
	* @param handled the handled
	*/
	public void removeByC_NotH(long companyId, boolean handled);

	/**
	* Returns the number of decision entries where companyId = &#63; and handled &ne; &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public int countByC_NotH(long companyId, boolean handled);

	/**
	* Caches the decision entry in the entity cache if it is enabled.
	*
	* @param decisionEntry the decision entry
	*/
	public void cacheResult(DecisionEntry decisionEntry);

	/**
	* Caches the decision entries in the entity cache if it is enabled.
	*
	* @param decisionEntries the decision entries
	*/
	public void cacheResult(java.util.List<DecisionEntry> decisionEntries);

	/**
	* Creates a new decision entry with the primary key. Does not add the decision entry to the database.
	*
	* @param decisionId the primary key for the new decision entry
	* @return the new decision entry
	*/
	public DecisionEntry create(long decisionId);

	/**
	* Removes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param decisionId the primary key of the decision entry
	* @return the decision entry that was removed
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry remove(long decisionId) throws NoSuchEntryException;

	public DecisionEntry updateImpl(DecisionEntry decisionEntry);

	/**
	* Returns the decision entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param decisionId the primary key of the decision entry
	* @return the decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry findByPrimaryKey(long decisionId)
		throws NoSuchEntryException;

	/**
	* Returns the decision entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param decisionId the primary key of the decision entry
	* @return the decision entry, or <code>null</code> if a decision entry with the primary key could not be found
	*/
	public DecisionEntry fetchByPrimaryKey(long decisionId);

	@Override
	public java.util.Map<java.io.Serializable, DecisionEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the decision entries.
	*
	* @return the decision entries
	*/
	public java.util.List<DecisionEntry> findAll();

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
	public java.util.List<DecisionEntry> findAll(int start, int end);

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
	public java.util.List<DecisionEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the decision entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of decision entries.
	*
	* @return the number of decision entries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}
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

package com.liferay.micro.maintainance.analysis.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the analysis entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.analysis.service.persistence.impl.AnalysisEntryPersistenceImpl
 * @see AnalysisEntryUtil
 * @generated
 */
@ProviderType
public interface AnalysisEntryPersistence extends BasePersistence<AnalysisEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnalysisEntryUtil} to access the analysis entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the analysis entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the analysis entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where uuid = &#63;.
	*
	* @param analysisId the primary key of the current analysis entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public AnalysisEntry[] findByUuid_PrevAndNext(long analysisId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the analysis entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of analysis entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching analysis entries
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param analysisId the primary key of the current analysis entry
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public AnalysisEntry[] findByUuid_C_PrevAndNext(long analysisId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the analysis entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching analysis entries
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the analysis entries where analysisId = &#63;.
	*
	* @param analysisId the analysis ID
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByAnalysisId(long analysisId);

	/**
	* Returns a range of all the analysis entries where analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByAnalysisId(long analysisId,
		int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByAnalysisId(long analysisId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where analysisId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByAnalysisId(long analysisId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where analysisId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByAnalysisId_First(long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where analysisId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByAnalysisId_First(long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where analysisId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByAnalysisId_Last(long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where analysisId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByAnalysisId_Last(long analysisId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Removes all the analysis entries where analysisId = &#63; from the database.
	*
	* @param analysisId the analysis ID
	*/
	public void removeByAnalysisId(long analysisId);

	/**
	* Returns the number of analysis entries where analysisId = &#63;.
	*
	* @param analysisId the analysis ID
	* @return the number of matching analysis entries
	*/
	public int countByAnalysisId(long analysisId);

	/**
	* Returns all the analysis entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByCompanyId(long companyId);

	/**
	* Returns a range of all the analysis entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByCompanyId(long companyId,
		int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where companyId = &#63;.
	*
	* @param analysisId the primary key of the current analysis entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public AnalysisEntry[] findByCompanyId_PrevAndNext(long analysisId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the analysis entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of analysis entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching analysis entries
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns all the analysis entries where analysisId = &#63; and companyId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_C(long analysisId,
		long companyId);

	/**
	* Returns a range of all the analysis entries where analysisId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_C(long analysisId,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where analysisId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_C(long analysisId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where analysisId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_C(long analysisId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where analysisId = &#63; and companyId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByA_C_First(long analysisId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where analysisId = &#63; and companyId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByA_C_First(long analysisId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where analysisId = &#63; and companyId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByA_C_Last(long analysisId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where analysisId = &#63; and companyId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByA_C_Last(long analysisId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Removes all the analysis entries where analysisId = &#63; and companyId = &#63; from the database.
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	*/
	public void removeByA_C(long analysisId, long companyId);

	/**
	* Returns the number of analysis entries where analysisId = &#63; and companyId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param companyId the company ID
	* @return the number of matching analysis entries
	*/
	public int countByA_C(long analysisId, long companyId);

	/**
	* Returns all the analysis entries where analysisId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_CM(long analysisId,
		long canMainId);

	/**
	* Returns a range of all the analysis entries where analysisId = &#63; and canMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_CM(long analysisId,
		long canMainId, int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where analysisId = &#63; and canMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_CM(long analysisId,
		long canMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where analysisId = &#63; and canMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_CM(long analysisId,
		long canMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where analysisId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByA_CM_First(long analysisId, long canMainId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where analysisId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByA_CM_First(long analysisId, long canMainId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where analysisId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByA_CM_Last(long analysisId, long canMainId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where analysisId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByA_CM_Last(long analysisId, long canMainId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Removes all the analysis entries where analysisId = &#63; and canMainId = &#63; from the database.
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	*/
	public void removeByA_CM(long analysisId, long canMainId);

	/**
	* Returns the number of analysis entries where analysisId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param canMainId the can main ID
	* @return the number of matching analysis entries
	*/
	public int countByA_CM(long analysisId, long canMainId);

	/**
	* Returns all the analysis entries where analysisId = &#63; and userId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_U_CM(long analysisId,
		long userId, long canMainId);

	/**
	* Returns a range of all the analysis entries where analysisId = &#63; and userId = &#63; and canMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_U_CM(long analysisId,
		long userId, long canMainId, int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where analysisId = &#63; and userId = &#63; and canMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_U_CM(long analysisId,
		long userId, long canMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where analysisId = &#63; and userId = &#63; and canMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByA_U_CM(long analysisId,
		long userId, long canMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where analysisId = &#63; and userId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByA_U_CM_First(long analysisId, long userId,
		long canMainId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where analysisId = &#63; and userId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByA_U_CM_First(long analysisId, long userId,
		long canMainId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where analysisId = &#63; and userId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByA_U_CM_Last(long analysisId, long userId,
		long canMainId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where analysisId = &#63; and userId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByA_U_CM_Last(long analysisId, long userId,
		long canMainId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Removes all the analysis entries where analysisId = &#63; and userId = &#63; and canMainId = &#63; from the database.
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	*/
	public void removeByA_U_CM(long analysisId, long userId, long canMainId);

	/**
	* Returns the number of analysis entries where analysisId = &#63; and userId = &#63; and canMainId = &#63;.
	*
	* @param analysisId the analysis ID
	* @param userId the user ID
	* @param canMainId the can main ID
	* @return the number of matching analysis entries
	*/
	public int countByA_U_CM(long analysisId, long userId, long canMainId);

	/**
	* Returns all the analysis entries where canMainId = &#63; and userId = &#63;.
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByCM_U(long canMainId, long userId);

	/**
	* Returns a range of all the analysis entries where canMainId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByCM_U(long canMainId,
		long userId, int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where canMainId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByCM_U(long canMainId,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where canMainId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByCM_U(long canMainId,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where canMainId = &#63; and userId = &#63;.
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByCM_U_First(long canMainId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where canMainId = &#63; and userId = &#63;.
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByCM_U_First(long canMainId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where canMainId = &#63; and userId = &#63;.
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByCM_U_Last(long canMainId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where canMainId = &#63; and userId = &#63;.
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByCM_U_Last(long canMainId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where canMainId = &#63; and userId = &#63;.
	*
	* @param analysisId the primary key of the current analysis entry
	* @param canMainId the can main ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public AnalysisEntry[] findByCM_U_PrevAndNext(long analysisId,
		long canMainId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the analysis entries where canMainId = &#63; and userId = &#63; from the database.
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	*/
	public void removeByCM_U(long canMainId, long userId);

	/**
	* Returns the number of analysis entries where canMainId = &#63; and userId = &#63;.
	*
	* @param canMainId the can main ID
	* @param userId the user ID
	* @return the number of matching analysis entries
	*/
	public int countByCM_U(long canMainId, long userId);

	/**
	* Returns all the analysis entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByC_U(long companyId, long userId);

	/**
	* Returns a range of all the analysis entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByC_U(long companyId, long userId,
		int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByC_U(long companyId, long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByC_U(long companyId, long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByC_U_First(long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByC_U_First(long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByC_U_Last(long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByC_U_Last(long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param analysisId the primary key of the current analysis entry
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public AnalysisEntry[] findByC_U_PrevAndNext(long analysisId,
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the analysis entries where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	*/
	public void removeByC_U(long companyId, long userId);

	/**
	* Returns the number of analysis entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching analysis entries
	*/
	public int countByC_U(long companyId, long userId);

	/**
	* Returns all the analysis entries where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @return the matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByU_cD(long userId, Date createDate);

	/**
	* Returns a range of all the analysis entries where userId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByU_cD(long userId,
		Date createDate, int start, int end);

	/**
	* Returns an ordered range of all the analysis entries where userId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByU_cD(long userId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries where userId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public java.util.List<AnalysisEntry> findByU_cD(long userId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByU_cD_First(long userId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByU_cD_First(long userId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the last analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public AnalysisEntry findByU_cD_Last(long userId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public AnalysisEntry fetchByU_cD_Last(long userId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param analysisId the primary key of the current analysis entry
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public AnalysisEntry[] findByU_cD_PrevAndNext(long analysisId, long userId,
		Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the analysis entries where userId = &#63; and createDate = &#63; from the database.
	*
	* @param userId the user ID
	* @param createDate the create date
	*/
	public void removeByU_cD(long userId, Date createDate);

	/**
	* Returns the number of analysis entries where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @return the number of matching analysis entries
	*/
	public int countByU_cD(long userId, Date createDate);

	/**
	* Caches the analysis entry in the entity cache if it is enabled.
	*
	* @param analysisEntry the analysis entry
	*/
	public void cacheResult(AnalysisEntry analysisEntry);

	/**
	* Caches the analysis entries in the entity cache if it is enabled.
	*
	* @param analysisEntries the analysis entries
	*/
	public void cacheResult(java.util.List<AnalysisEntry> analysisEntries);

	/**
	* Creates a new analysis entry with the primary key. Does not add the analysis entry to the database.
	*
	* @param analysisId the primary key for the new analysis entry
	* @return the new analysis entry
	*/
	public AnalysisEntry create(long analysisId);

	/**
	* Removes the analysis entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisId the primary key of the analysis entry
	* @return the analysis entry that was removed
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public AnalysisEntry remove(long analysisId) throws NoSuchEntryException;

	public AnalysisEntry updateImpl(AnalysisEntry analysisEntry);

	/**
	* Returns the analysis entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param analysisId the primary key of the analysis entry
	* @return the analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public AnalysisEntry findByPrimaryKey(long analysisId)
		throws NoSuchEntryException;

	/**
	* Returns the analysis entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param analysisId the primary key of the analysis entry
	* @return the analysis entry, or <code>null</code> if a analysis entry with the primary key could not be found
	*/
	public AnalysisEntry fetchByPrimaryKey(long analysisId);

	@Override
	public java.util.Map<java.io.Serializable, AnalysisEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the analysis entries.
	*
	* @return the analysis entries
	*/
	public java.util.List<AnalysisEntry> findAll();

	/**
	* Returns a range of all the analysis entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of analysis entries
	*/
	public java.util.List<AnalysisEntry> findAll(int start, int end);

	/**
	* Returns an ordered range of all the analysis entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of analysis entries
	*/
	public java.util.List<AnalysisEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator);

	/**
	* Returns an ordered range of all the analysis entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of analysis entries
	*/
	public java.util.List<AnalysisEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the analysis entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of analysis entries.
	*
	* @return the number of analysis entries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}
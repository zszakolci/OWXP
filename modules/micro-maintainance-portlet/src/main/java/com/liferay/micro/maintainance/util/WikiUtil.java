package com.liferay.micro.maintainance.util;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.analysis.service.AnalysisEntryLocalServiceUtil;
import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalServiceUtil;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;

public class WikiUtil {

	public static WikiPage getWikiPageByAnalysis(long analysisId) 
		throws PortalException {

		AnalysisEntry analysisEntry = 
			AnalysisEntryLocalServiceUtil.getAnalysisEntry(analysisId);

		if (Validator.isNotNull(analysisEntry)) {
			return getWikiPageByCandiadteMaintenacne(
				analysisEntry.getCanMainId());
		}

		return null;
	}

	public static WikiPage getWikiPageByCandiadte(long candidateId)
		throws PortalException {
		CandidateEntry candidateEntry = 
			CandidateEntryLocalServiceUtil.getCandidateEntry(candidateId);

		if (Validator.isNotNull(candidateEntry)) {
			return WikiPageLocalServiceUtil.getWikiPage(
				candidateEntry.getWikiPageId());
		}

		return null;
	}

	public static WikiPage getWikiPageByCandiadteMaintenacne(long canMainId)
		throws PortalException {

		CandidateMaintenance canMain = 
			CandidateMaintenanceLocalServiceUtil
				.getCandidateMaintenance(canMainId);

		if (Validator.isNotNull(canMain)) {
			return getWikiPageByCandiadte(canMain.getCandidateId());
		}

		return null;
	}
}

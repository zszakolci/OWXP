package com.liferay.owxp.service;

import com.liferay.journal.service.JournalArticleLocalServiceWrapper;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class OWXPJournalArticleLocalServiceWrapper extends JournalArticleLocalServiceWrapper {

        public OWXPJournalArticleLocalServiceWrapper() {
            super(null);
        }

}

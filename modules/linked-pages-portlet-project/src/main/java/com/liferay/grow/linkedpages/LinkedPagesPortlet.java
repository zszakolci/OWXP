package com.liferay.grow.linkedpages;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.grow.linkedpages.util.LinkedPagesPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.show-portlet-access-denied=false",
		"com.liferay.portlet.system=true",
		"com.liferay.portlet.use-default-template=false",
		"javax.portlet.display-name=Linked Pages",
		"javax.portlet.name=" + LinkedPagesPortletKeys.LINKED_PAGES,
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language"
	},
	service = Portlet.class
)
public class LinkedPagesPortlet extends MVCPortlet {

}
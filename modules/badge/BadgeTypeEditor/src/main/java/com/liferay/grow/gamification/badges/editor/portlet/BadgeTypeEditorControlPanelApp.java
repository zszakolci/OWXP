package com.liferay.grow.gamification.badges.editor.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=10000",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONFIGURATION
	},
	service = PanelApp.class
)

public class BadgeTypeEditorControlPanelApp extends BasePanelApp {
	@Override
	public String getPortletId() {
		return "badgetypeeditor";	// Same name of the portlet.
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=badgetypeeditor)",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}

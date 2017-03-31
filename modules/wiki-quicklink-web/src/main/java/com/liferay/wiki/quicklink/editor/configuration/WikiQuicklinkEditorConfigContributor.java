package com.liferay.wiki.quicklink.editor.configuration;

import java.util.Map;

import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import com.liferay.grow.wiki.quicklink.constants.WikiQuicklinkPortletKeys;
import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.wiki.constants.WikiPortletKeys;

@Component(
	property = {
		"editor.config.key=contentEditor", "editor.name=alloyeditor_creole",
		"editor.name=ckeditor", "javax.portlet.name=" + WikiPortletKeys.WIKI,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_DISPLAY,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_ADMIN,
		"service.ranking:Integer=10"
	},
	service = EditorConfigContributor.class
)
public class WikiQuicklinkEditorConfigContributor extends BaseEditorConfigContributor {

	@Override
	public void populateConfigJSONObject(
		JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
		ThemeDisplay themeDisplay,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		JSONObject autoCompleteConfigJSONObject =
			JSONFactoryUtil.createJSONObject();

		autoCompleteConfigJSONObject.put("requestTemplate", "query={query}");

		JSONArray triggerJSONArray = JSONFactoryUtil.createJSONArray();

		JSONObject triggerJSONObject = JSONFactoryUtil.createJSONObject();

		triggerJSONObject.put(
			"regExp",
			"(?:\\strigger|^trigger)([^\\\\\\]\\|:;%<>\\s]+)");
		triggerJSONObject.put(
			"resultFilters", "function(query, results) {return results;}");
		triggerJSONObject.put("resultTextLocator", "pageTitle");
		triggerJSONObject.put("term", "§");
		triggerJSONObject.put("tplReplace", "{quicklink}");

		StringBundler sb = new StringBundler(5);

		sb.append("<div class=\"title\"><div class=\"title-field\">");
		sb.append("<div class=\"nameplate-content\"><h4>");
		sb.append("{title}</h4></div></div></div>");

		triggerJSONObject.put("tplResults", sb.toString());

		PortletURL autoCompleteWikiPageURL =
			requestBackedPortletURLFactory.createResourceURL(
				WikiQuicklinkPortletKeys.WIKI_QUICKLINK);

		String source =
			autoCompleteWikiPageURL.toString() + "&" +
				PortalUtil.getPortletNamespace(
					WikiQuicklinkPortletKeys.WIKI_QUICKLINK);

		triggerJSONObject.put("source", source);

		triggerJSONArray.put(triggerJSONObject);

		autoCompleteConfigJSONObject.put("trigger", triggerJSONArray);

		jsonObject.put("autocomplete", autoCompleteConfigJSONObject);

		String extraPlugins = jsonObject.getString("extraPlugins");

		if (Validator.isNotNull(extraPlugins)) {
			extraPlugins += ",autocomplete";
		}
		else {
			extraPlugins =
				"autocomplete,ae_placeholder,ae_selectionregion,ae_uicore";
		}

		jsonObject.put("extraPlugins", extraPlugins);
	}

}

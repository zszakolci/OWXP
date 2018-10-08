package com.liferay.grow.gamification.date.loader.portlet;

import com.liferay.grow.gamification.date.loader.constants.DateDimensionLoaderPortletKeys;
import com.liferay.grow.gamification.model.LDate;
import com.liferay.grow.gamification.service.LDateLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author vili
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DateDimensionLoaderPortletKeys.DateDimensionLoader,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DateDimensionLoaderPortlet extends MVCPortlet {
	public void generate(ActionRequest actionRequest, ActionResponse actionResponse) {
		synchronized (IS_RUNNING) {
			if (!IS_RUNNING) {

				IS_RUNNING = Boolean.TRUE;

				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 1970);
				calendar.set(Calendar.MONTH, Calendar.JANUARY);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				int idx = 1;

				while (calendar.get(Calendar.YEAR) < 2100) {
					LDate date = _lDateLocalService.createLDate(idx);
					date.setDay(calendar.get(Calendar.DAY_OF_MONTH));
					date.setMonth(calendar.get(Calendar.MONTH) + 1);
					date.setQuarter("Q" + (((date.getMonth()-1)/3) + 1));
					date.setYear(calendar.get(Calendar.YEAR));
					date.setDayOfYear(calendar.get(Calendar.DAY_OF_YEAR));
					switch(calendar.get(Calendar.MONTH)) {
						case Calendar.JANUARY: date.setMonthName("Januray");
						break;
						case Calendar.FEBRUARY: date.setMonthName("February");
						break;
						case Calendar.MARCH: date.setMonthName("March");
						break;
						case Calendar.APRIL: date.setMonthName("April");
						break;
						case Calendar.MAY: date.setMonthName("May");
						break;
						case Calendar.JUNE: date.setMonthName("June");
						break;
						case Calendar.JULY: date.setMonthName("July");
						break;
						case Calendar.AUGUST: date.setMonthName("August");
						break;
						case Calendar.SEPTEMBER: date.setMonthName("September");
						break;
						case Calendar.OCTOBER: date.setMonthName("October");
						break;
						case Calendar.NOVEMBER: date.setMonthName("November");
						break;
						case Calendar.DECEMBER: date.setMonthName("December");
						break;
					}

					date.setWeek(calendar.get(Calendar.WEEK_OF_YEAR));

					switch(calendar.get(Calendar.DAY_OF_WEEK)) {
						case Calendar.MONDAY : date.setWeekDay("Monday");
						break;
						case Calendar.TUESDAY : date.setWeekDay("Tuesday");
						break;
						case Calendar.WEDNESDAY : date.setWeekDay("Wednesday");
						break;
						case Calendar.THURSDAY : date.setWeekDay("Thursday");
						break;
						case Calendar.FRIDAY : date.setWeekDay("Friday");
						break;
						case Calendar.SATURDAY : date.setWeekDay("Saturday");
						break;
						case Calendar.SUNDAY : date.setWeekDay("Sunday");
						break;
					}

					idx++;
					calendar.add(Calendar.DAY_OF_YEAR, 1);
					System.out.println(date);
					_lDateLocalService.addLDate(date);
				}
				IS_RUNNING = Boolean.FALSE;
			}
		}
	}

	@Reference(unbind = "-")
	protected void setLDateLocalService(LDateLocalService lDateLocalService) {
		_lDateLocalService = lDateLocalService;
	}

	private LDateLocalService _lDateLocalService;
	private static Boolean IS_RUNNING = Boolean.FALSE;
}
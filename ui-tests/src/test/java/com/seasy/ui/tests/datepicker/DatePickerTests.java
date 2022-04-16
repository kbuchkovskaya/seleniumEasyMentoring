package com.seasy.ui.tests.datepicker;

import com.seasy.ui.pages.datepicker.BootstrapDatePickerPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.DateFormatter;
import com.seasy.ui.tests.utils.pages.DatePickerPageName;
import org.testng.annotations.Test;

public class DatePickerTests extends BaseTest {
	
	DateFormatter dateFormatter = new DateFormatter();
	
	@Test
	public void checkDayToday() {
		openBrowser(DatePickerPageName.BOOTSTRAP_DATE_PICKER, BootstrapDatePickerPage.class)
				.openDateExampleDatePicker()
				.selectTodayExampleDatePicker()
				.openDateExampleDatePicker()
				.checkTodayDayExampleDatePicker(dateFormatter.getDayToday());
	}
	
	@Test
	public void checkUnavailableFutureDay() {
		openBrowser(DatePickerPageName.BOOTSTRAP_DATE_PICKER, BootstrapDatePickerPage.class)
				.openDateExampleDatePicker()
				.clearDateDateExampleDatePicker()
				.openDateExampleDatePicker()
				.selectFutureDateExampleDatePicker(dateFormatter.getDayToday())
				.checkTodayIsSelectedExampleDatePicker(dateFormatter.getDayToday());
	}
}

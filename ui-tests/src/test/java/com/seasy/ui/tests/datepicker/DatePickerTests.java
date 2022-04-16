package com.seasy.ui.tests.datepicker;

import com.seasy.ui.pages.datepicker.BootstrapDatePickerPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.pages.utils.Date;
import com.seasy.ui.tests.utils.pages.DatePickerPageName;
import org.testng.annotations.Test;

public class DatePickerTests extends BaseTest {
	
	Date date = new Date();
	
	@Test
	public void checkDayToday() {
		openBrowser(DatePickerPageName.BOOTSTRAP_DATE_PICKER, BootstrapDatePickerPage.class)
				.openDateExampleDatePicker()
				.selectTodayExampleDatePicker()
				.openDateExampleDatePicker()
				.checkTodayDayExampleDatePicker(date.getDayToday());
	}
	
	@Test
	public void checkUnavailableFutureDay() {
		openBrowser(DatePickerPageName.BOOTSTRAP_DATE_PICKER, BootstrapDatePickerPage.class)
				.openDateExampleDatePicker()
				.clearDateDateExampleDatePicker()
				.openDateExampleDatePicker()
				.selectFutureDateExampleDatePicker(date.getDayToday())
				.checkTodayIsSelectedExampleDatePicker(date.getDayToday());
	}
}

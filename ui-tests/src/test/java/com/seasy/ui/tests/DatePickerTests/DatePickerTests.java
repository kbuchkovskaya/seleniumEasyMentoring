package com.seasy.ui.tests.DatePickerTests;

import com.codeborne.selenide.testng.TextReport;
import com.seasy.ui.tests.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TextReport.class)
public class DatePickerTests extends BaseTest {

    @Test
    public void checkDayToday(){
        openBootstrapDatePickerPage()
                .openDateExampleDatePicker()
                .selectTodayExampleDatePicker()
                .openDateExampleDatePicker()
                .checkTodayDayExampleDatePicker(getDayToday());
    }

    @Test
    public void checkUnavailableFutureDay(){
        openBootstrapDatePickerPage()
                .openDateExampleDatePicker()
                .clearDateDateExampleDatePicker()
                .openDateExampleDatePicker()
                .selectFutureDateExampleDatePicker(getDayToday())
                .checkTodayIsSelectedExampleDatePicker(getDayToday());
    }
}

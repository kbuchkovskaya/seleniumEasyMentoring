package com.seasy.ui.tests;

import org.testng.annotations.Test;

public class DatePickerTests extends BaseTest{

    @Test
    public void checkDayToday(){
        openBootstrapDatePickerPage()
                .selectTodayExampleDate(getDayToday());
    }

    @Test
    public void checkUnavailableFutureDay(){
        openBootstrapDatePickerPage()
                .selectFutureDateExampleDate(getDayToday());
    }
}

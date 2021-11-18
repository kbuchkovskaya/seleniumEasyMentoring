package com.seasy.ui.pages.DatePickers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;

public class BootstrapDatePickerPage {

    private final SelenideElement openDateExampleDatePicker = $(".input-group.date .input-group-addon"),
    dateExampleDatePicker = $(".datepicker-days"),
    todayDateExampleButton = $(".datepicker-days tfoot tr .today"),
    //todayActiveDayDateExample = $(".today.active.disabled.disabled-date.day"),
    selectedDayDateExample = $(".active.day"),
    dayInInputDateExample = $(".input-group.date input"),
    clearDateInDateExample = $(".datepicker-days .clear");

    //public SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");

    public BootstrapDatePickerPage openDateExampleDatePicker(){
        openDateExampleDatePicker.click();
        dateExampleDatePicker.shouldBe(Condition.visible);
        return new BootstrapDatePickerPage();
    }

    public void selectTodayExampleDate(String today){
        openDateExampleDatePicker.click();
        todayDateExampleButton.click();
        openDateExampleDatePicker.click();
        LocalDate currentDate = LocalDate.parse(today);
        int day = currentDate.getDayOfMonth();
        selectedDayDateExample.shouldHave(Condition.text(String.valueOf(day)));
        new BootstrapDatePickerPage();
    }

    public void selectFutureDateExampleDate(String today){
        openDateExampleDatePicker.click();
        clearDateInDateExample.click();
        LocalDate currentDate = LocalDate.parse(today);
        dayInInputDateExample.setValue(String.valueOf(currentDate.plusMonths(1)));//.sendKeys(Keys.ENTER);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dayInInputDateExample.shouldHave(Condition.text(today));//invalid date displayed (2021-12-14)
        new BootstrapDatePickerPage();
    }




}

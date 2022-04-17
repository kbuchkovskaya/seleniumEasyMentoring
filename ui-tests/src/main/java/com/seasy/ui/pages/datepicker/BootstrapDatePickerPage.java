package com.seasy.ui.pages.datepicker;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;

public class BootstrapDatePickerPage {
	
	private final SelenideElement openDateExampleDatePicker = $(".input-group.date .input-group-addon");
	private final SelenideElement dateExampleDatePicker = $(".datepicker-days");
	private final SelenideElement todayDateExampleButton = $(".datepicker-days tfoot tr .today");
	private final SelenideElement selectedDayDateExample = $(".active.day");
	private final SelenideElement dayInInputDateExample = $(".input-group.date input");
	private final SelenideElement clearDateInDateExample = $(".datepicker-days .clear");
	
	public BootstrapDatePickerPage openDateExampleDatePicker() {
		openDateExampleDatePicker.click();
		return new BootstrapDatePickerPage();
	}
	
	public BootstrapDatePickerPage checkDateExampleDatePickerIsOpened() {
		dateExampleDatePicker.shouldBe(Condition.visible);
		return new BootstrapDatePickerPage();
	}
	
	public BootstrapDatePickerPage selectTodayExampleDatePicker() {
		todayDateExampleButton.click();
		return new BootstrapDatePickerPage();
	}
	
	public BootstrapDatePickerPage checkTodayDayExampleDatePicker(LocalDate localDate) {
		int day = localDate.getDayOfMonth();  //Parses text from a string to produce a Date.
		selectedDayDateExample.shouldHave(Condition.text(String.valueOf(day)));
		return new BootstrapDatePickerPage();
	}
	
	public BootstrapDatePickerPage clearDateDateExampleDatePicker() {
		clearDateInDateExample.click();
		return new BootstrapDatePickerPage();
	}
	
	public BootstrapDatePickerPage checkDateExampleDatePickerIsEmpty() {
		dayInInputDateExample.shouldBe(Condition.empty);
		return new BootstrapDatePickerPage();
	}
	
	public BootstrapDatePickerPage selectFutureDateExampleDatePicker(LocalDate localDate) {
		//LocalDate.parse(today) - Parses text from a string to produce a Date.
		//format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) - Create formatter
		String futureDate = localDate.plusMonths(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		if (!localDate.getDayOfWeek().name().equals("Sunday")) {
			dayInInputDateExample.setValue(futureDate).pressEnter();
		} //log that future day is sunday
		return new BootstrapDatePickerPage();
	}
	
	public BootstrapDatePickerPage checkTodayIsSelectedExampleDatePicker(LocalDate localDate) {
		dayInInputDateExample.shouldHave(Condition.attribute("value", localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		return new BootstrapDatePickerPage();
	}
	
	
}

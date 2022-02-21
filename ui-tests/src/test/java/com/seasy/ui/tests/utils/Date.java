package com.seasy.ui.tests.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * The Date class provide local date in special format
 */
public class Date {
	
	/*
	 * getDayToday() provide date in format yyyy-MM-dd
	 * used in DatePickerTests
	 * */
	public LocalDate getDayToday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return LocalDate.parse(formatter.format(date));
	}
	
}

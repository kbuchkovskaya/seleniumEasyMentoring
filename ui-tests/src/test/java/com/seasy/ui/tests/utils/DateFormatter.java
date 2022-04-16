package com.seasy.ui.tests.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateFormatter {
	
	public LocalDate getDayToday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return LocalDate.parse(formatter.format(date));
	}

}

package com.seasy.ui.pages.form;

public enum AgeGroup {
	
	ZERO_TO_FIVE("0 - 5"),
	FIVE_TO_FIFTEEN("5 - 15"),
	FIFTEEN_TO_FIFTY("15 - 50");
	
	String value;
	
	AgeGroup(String ageValues) {
		this.value = ageValues;
	}
}

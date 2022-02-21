package com.seasy.ui.pages;

public enum SubmitFormFieldsName {
	
	FIRST_NAME_FIELD("First Name"),
	LAST_NAME_FIELD("Last Name"),
	EMAIL_FIELD("E-Mail"),
	PHONE_FIELD("Phone"),
	ADDRESS_FIELD("Address"),
	CITY_FILED("City"),
	ZIP_CODE_FILED("Zip Code"),
	WEBSITE_FIELD("Website"),
	PROJECT_DESCRIPTION_FIELD("Project Description");
	
	public final String value;
	
	SubmitFormFieldsName(String fieldName) {
		this.value = fieldName;
	}
	
}

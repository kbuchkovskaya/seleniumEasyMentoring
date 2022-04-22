package com.seasy.ui.tests.form;

import com.codeborne.selenide.Condition;
import com.seasy.ui.pages.form.InputFormSubmitPage;
import com.seasy.ui.pages.User;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.InputFormsPageName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.seasy.ui.pages.SubmitFormFieldsName.*;

public class InputFormSubmitTests extends BaseTest {
	
	public User user = new User.Builder()
			.withFirstName("Kateryna")
			.withLastName("Buchkovska")
			.withEmail("buchkovska@gmail.com")
			.withPhone("++3834233454")
			.withAddress("Ent str.")
			.withCity("Chernivtsi")
			.withZipCode("58032")
			.withWebSite("buchkovska.com")
			.withProjectDescription("Project description")
			.build();
	
	@Test
	public void checkDeletedFirstName() {
		openBrowser(InputFormsPageName.INPUT_FORM_SUBMIT, InputFormSubmitPage.class)
				.inputData(FIRST_NAME_FIELD, user.getFirstName())
				.deleteEnteredData(FIRST_NAME_FIELD)
				.checkFieldValidation(FIRST_NAME_FIELD, visible);
	}
	
	@Test
	public void checkFromSubmitWithAllDataEntered() {
		openBrowser(InputFormsPageName.INPUT_FORM_SUBMIT, InputFormSubmitPage.class)
				.inputData(FIRST_NAME_FIELD, user.getFirstName())
				.inputData(LAST_NAME_FIELD, user.getLastName())
				.inputData(EMAIL_FIELD, user.getEmail())
				.inputData(PHONE_FIELD, user.getPhone())
				.inputData(ADDRESS_FIELD, user.getAddress())
				.inputData(CITY_FILED, user.getCity())
				.selectState("Alaska")
				.inputData(ZIP_CODE_FILED, user.getZipCode())
				.inputData(WEBSITE_FIELD, user.getWebSite())
				.selectHosting(false)
				.inputTextAreaData(PROJECT_DESCRIPTION_FIELD, user.getProjectDescription())
				.submitForm();
	}
	
	@Test
	public void checkSubmitButtonIsDisabled() {
		openBrowser(InputFormsPageName.INPUT_FORM_SUBMIT, InputFormSubmitPage.class)
				.inputData(FIRST_NAME_FIELD, user.getFirstName())
				.inputData(LAST_NAME_FIELD, user.getLastName())
				.submitForm()
				.checkFieldValidation(EMAIL_FIELD, visible)
				.checkFieldValidation(ADDRESS_FIELD, Condition.text("Please supply your email address"))
				.submitButtonIsDisabled();
	}
}

package com.seasy.ui.tests.form.tests;

import com.seasy.ui.pages.form.AjaxFormSubmitPage;
import com.seasy.ui.pages.User;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.InputFormsPageName;
import org.testng.annotations.Test;

public class AjaxSubmitFormTests extends BaseTest {

/*
    User user = User.builder()
            .firstName("Kateryna")
            .projectDescription("Project description")
            .build();
*/
	
	User user = new User.Builder()
			.withFirstName("Kateryna")
			.withProjectDescription("Project Description")
			.build();
	
	@Test
	public void checkFormIsSubmitted() {
		openBrowser(InputFormsPageName.AJAX_FORM_SUBMIT, AjaxFormSubmitPage.class)
				.enterName(user.getFirstName())
				.enterDescription(user.getProjectDescription())
				.clickSubmitButton()
				.verifyFormIsProcessing()
				.verifyFormIsSubmitted();
	}
	
	@Test
	public void checkRequiredNameField() {
		openBrowser(InputFormsPageName.AJAX_FORM_SUBMIT, AjaxFormSubmitPage.class)
				.clickSubmitButton()
				.checkNameIsRequiredField();
	}
}

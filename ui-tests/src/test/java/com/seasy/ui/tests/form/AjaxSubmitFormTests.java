package com.seasy.ui.tests.form;

import com.seasy.ui.pages.form.AjaxFormSubmitPage;
import com.seasy.ui.pages.User;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.InputFormsPageName;
import org.testng.annotations.Test;

public class AjaxSubmitFormTests extends BaseTest {
	
	User user = new User.Builder()
			.withFirstName("Kateryna")
			.withProjectDescription("Project Description")
			.build();
	
	//incorrect label 'Form submited Successfully!'
	@Test
	public void checkFormIsSubmittedWithOneFilledField() {
		openBrowser(InputFormsPageName.AJAX_FORM_SUBMIT, AjaxFormSubmitPage.class)
				.enterData("title", user.getFirstName())
				.clickSubmitButton()
				.verifyFormIsProcessing()
				.verifyFormIsSubmitted();
	}
	
	//incorrect label 'Form submited Successfully!'
	@Test
	public void checkFormIsSubmittedWithAllFilledFields() {
		openBrowser(InputFormsPageName.AJAX_FORM_SUBMIT, AjaxFormSubmitPage.class)
				.enterData("title", user.getFirstName())
				.enterData("description", user.getProjectDescription())
				.clickSubmitButton()
				.verifyFormIsProcessing()
				.verifyFormIsSubmitted();
	}
 
	@Test
	public void checkRequiredNameField() {
		openBrowser(InputFormsPageName.AJAX_FORM_SUBMIT, AjaxFormSubmitPage.class)
				.clickSubmitButton()
				.checkNameIsRequiredField("title");
	}
}

package com.seasy.ui.tests.form;

import com.seasy.ui.pages.form.SimpleFormPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.InputFormsPageName;
import org.testng.annotations.Test;

public class SimpleFormTest extends BaseTest {
	
	@Test
	public void checkEmptyMessageTest() {
		openBrowser(InputFormsPageName.SIMPLE_FORM_DEMO, SimpleFormPage.class)
				.clickShowMessageButton()
				.verifyEmptyMessage();
	}
	
	@Test
	public void checkYourMessageTest() {
		openBrowser(InputFormsPageName.SIMPLE_FORM_DEMO, SimpleFormPage.class)
				.enterSingleInput("22")
				.clickShowMessageButton()
				.verifyYourMessage("22");
	}
	
	@Test
	public void checkTotalResultWithIntegerValuesTest() {
		openBrowser(InputFormsPageName.SIMPLE_FORM_DEMO, SimpleFormPage.class)
				.enterTwoInput(5, 6)
				.clickGetTotalButton()
				.verifySumOfTwoIntegerValues(11);
	}
	
	@Test
	public void checkTotalResultWithStringValuesTest() {
		openBrowser(InputFormsPageName.SIMPLE_FORM_DEMO, SimpleFormPage.class)
				.enterNegativeValue("test1", "test2")
				.clickGetTotalButton()
				.verifySumOfNonValidData("Nan");
	}
	
	@Test
	public void checkTotalResultWithEmptyFieldsTest() {
		openBrowser(InputFormsPageName.SIMPLE_FORM_DEMO, SimpleFormPage.class)
				.clearDataFields()
				.clickGetTotalButton()
				.verifySumOfNonValidData("Nan");
	}
}

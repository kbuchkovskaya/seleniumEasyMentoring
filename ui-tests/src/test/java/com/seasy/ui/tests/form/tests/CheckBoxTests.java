package com.seasy.ui.tests.form.tests;

import com.codeborne.selenide.Condition;
import com.seasy.ui.pages.form.CheckBoxPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.InputFormsPageName;
import org.testng.annotations.Test;


public class CheckBoxTests extends BaseTest {
	
	@Test
	public void selectSingleCheckBoxTest() {
		openBrowser(InputFormsPageName.CHECKBOX_DEMO, CheckBoxPage.class)
				.selectSingleCheckBox()
				.verifySingleCheckBoxIsSelected();
	}
	
	@Test
	public void checkUnselectOfSelectedCheckBoxTest() {
		openBrowser(InputFormsPageName.CHECKBOX_DEMO, CheckBoxPage.class)
				.selectSingleCheckBox()
				.unselectSingleCheckBox()
				.verifySingleCheckBoxIsUnselected();
	}
	
	@Test
	public void checkUnselectedCheckBox() {
		openBrowser(InputFormsPageName.CHECKBOX_DEMO, CheckBoxPage.class)
				.verifySingleCheckBoxIsUnselected();
	}
	
	@Test
	public void checkMultipleCheckBoxIsSelected() {
		openBrowser(InputFormsPageName.CHECKBOX_DEMO, CheckBoxPage.class)
				.selectMultipleCheckboxByIndex(1, true)
				.verifyMultipleCheckBoxIsSelected(1, Condition.selected);
	}
	
	@Test
	public void checkAllCheckboxesAreSelected() {
		openBrowser(InputFormsPageName.CHECKBOX_DEMO, CheckBoxPage.class)
				.selectAllCheckboxes()
				.verifyAllCheckboxesAreSelected()
				.checkUncheckAllButtonIsDisplayed();
	}
	
	@Test
	public void checkMultipleCheckBoxIsUnselected() {
		openBrowser(InputFormsPageName.CHECKBOX_DEMO, CheckBoxPage.class)
				.selectAllCheckboxes()
				.verifyAllCheckboxesAreSelected()
				.checkUncheckAllButtonIsDisplayed()
				.unselectAllCheckboxes()
				.verifyMultipleCheckBoxIsUnselected()
				.checkCheckAllButtonIsDisplayed();
	}
	
	@Test
	public void checkCheckAllButtonWithOneUnselectedCheckbox() {
		openBrowser(InputFormsPageName.CHECKBOX_DEMO, CheckBoxPage.class)
				.selectAllCheckboxes()
				.verifyAllCheckboxesAreSelected()
				.checkUncheckAllButtonIsDisplayed()
				.unselectMultipleCheckBoxByIndex(3, false)
				.verifyMultipleCheckBoxIsNotSelected(3, Condition.not(Condition.selected))
				.checkCheckAllButtonIsDisplayed();
	}
}

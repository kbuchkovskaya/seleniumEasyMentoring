package com.seasy.ui.tests.form;

import com.seasy.ui.pages.form.AgeGroup;
import com.seasy.ui.pages.form.Gender;
import com.seasy.ui.pages.form.RadioButtonsPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.InputFormsPageName;
import org.testng.annotations.Test;

public class RadioButtonPageTests extends BaseTest {
	
	@Test
	public void checkSelectedGenderRadioButton() {
		openBrowser(InputFormsPageName.RADIO_BUTTONS_DEMO, RadioButtonsPage.class)
				.selectSingleGenderRadioButton(Gender.MALE)
				.clickGetCheckedValueButton()
				.verifySelectedSingleGender(Gender.MALE);
	}
	
	@Test
	public void checkUnselectedValue() {
		openBrowser(InputFormsPageName.RADIO_BUTTONS_DEMO, RadioButtonsPage.class)
				.clickGetCheckedValueButton()
				.verifySingleRadioButtonIsNotSelected();
	}
	
	@Test
	public void checkGenderAgeGroup() {
		openBrowser(InputFormsPageName.RADIO_BUTTONS_DEMO, RadioButtonsPage.class)
				.verifyGenderIsNotSelected(Gender.MALE)
				.verifyAgeGroupIsNotSelected(AgeGroup.FIVE_TO_FIFTEEN)
				.selectGenderInRadioButtonsGroup(Gender.MALE)
				.selectAgeGroupInRadioButtonsGroup(AgeGroup.FIVE_TO_FIFTEEN)
				.clickGetValuesButton()
				.verifyGender(Gender.MALE)
				.verifyAgeGroupIsSelected(AgeGroup.FIVE_TO_FIFTEEN);
	}
	
}

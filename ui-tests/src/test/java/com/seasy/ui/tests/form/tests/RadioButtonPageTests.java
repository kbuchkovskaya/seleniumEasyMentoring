package com.seasy.ui.tests.form.tests;

import com.seasy.ui.pages.form.RadioButtonsPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.InputFormsPageName;
import org.testng.annotations.Test;

public class RadioButtonPageTests extends BaseTest {

    @Test
    public void checkSelectMaleRadioButton(){
        openBrowser(InputFormsPageName.RADIO_BUTTONS_DEMO, RadioButtonsPage.class)
                .selectMaleRadioButton()
                .clickGetCheckedValueButton()
                .verifySelectedMaleRadioButton();
    }

    @Test
    public void checkSelectedFemaleRadioButton(){
        openBrowser(InputFormsPageName.RADIO_BUTTONS_DEMO, RadioButtonsPage.class)
                .selectFemaleRadioButton()
                .clickGetCheckedValueButton()
                .verifySelectedFemaleRadioButton();
    }

    @Test
    public void checkUnselectedValue(){
        openBrowser(InputFormsPageName.RADIO_BUTTONS_DEMO, RadioButtonsPage.class)
                .clickGetCheckedValueButton()
                .verifySingleRadioButtonIsNotSelected();
    }

    @Test(description = "Check 'Male' gender and '5-15' age group")
    public void checkMaleGenderAndFiveToFifteenAgeGroup(){
        openBrowser(InputFormsPageName.RADIO_BUTTONS_DEMO, RadioButtonsPage.class)
                .selectMaleGroupRadioButton()
                .selectAgeGroupFromFiveToFifteen()
                .clickGetValuesButton()
                .verifyGenderIsMale()
                .verifyAgeGroupIsFromFiveToFifteen();
    }

    @Test(description = "Check 'Female' gender and '0-5' age group")
    public void checkFemaleGenderAndZeroToFiveAgeGroup(){
        openBrowser(InputFormsPageName.RADIO_BUTTONS_DEMO, RadioButtonsPage.class)
                .selectFemaleGroupRadioButton()
                .selectAgeGroupFromZeroToFive()
                .clickGetValuesButton()
                .verifyGenderIsFemale()
                .verifyAgeGroupIsFromZeroToFive();
    }

}

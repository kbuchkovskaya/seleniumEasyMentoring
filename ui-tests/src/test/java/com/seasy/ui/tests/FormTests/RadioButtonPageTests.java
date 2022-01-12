package com.seasy.ui.tests.FormTests;

import com.seasy.ui.tests.BaseTest;
import org.testng.annotations.Test;

public class RadioButtonPageTests extends BaseTest {

    @Test
    public void checkSelectMaleRadioButton(){
        openRadioButtonsPage()
                .selectMaleRadioButton()
                .clickGetCheckedValueButton()
                .verifySelectedMaleRadioButton();
    }

    @Test
    public void checkSelectedFemaleRadioButton(){
        openRadioButtonsPage()
                .selectFemaleRadioButton()
                .clickGetCheckedValueButton()
                .verifySelectedFemaleRadioButton();
    }

    @Test
    public void checkUnselectedValue(){
        openRadioButtonsPage()
                .clickGetCheckedValueButton()
                .verifySingleRadioButtonIsNotSelected();
    }

    @Test(description = "Check 'Male' gender and '5-15' age group")
    public void checkMaleGenderAndFiveToFifteenAgeGroup(){
        openRadioButtonsPage()
                .selectMaleGroupRadioButton()
                .selectAgeGroupFromFiveToFifteen()
                .clickGetValuesButton()
                .verifyGenderIsMale()
                .verifyAgeGroupIsFromFiveToFifteen();
    }

    @Test(description = "Check 'Female' gender and '0-5' age group")
    public void checkFemaleGenderAndZeroToFiveAgeGroup(){
        openRadioButtonsPage()
                .selectFemaleGroupRadioButton()
                .selectAgeGroupFromZeroToFive()
                .clickGetValuesButton()
                .verifyGenderIsFemale()
                .verifyAgeGroupIsFromZeroToFive();
    }

}

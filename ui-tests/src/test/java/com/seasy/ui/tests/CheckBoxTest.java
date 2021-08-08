package com.seasy.ui.tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;


public class CheckBoxTest extends BaseTest{

    @Test
    public void selectSingleCheckBoxTest(){
        openCheckBoxPage()
                .selectSingleCheckBox()
                .verifySingleCheckBoxIsSelected();
    }

    @Test
    public void checkUnselectOfSelectedCheckBoxTest(){
        openCheckBoxPage()
                .selectSingleCheckBox()
                .unselectSingleCheckBox()
                .verifySingleCheckBoxIsUnselected();
    }

    @Test
    public void checkUnselectedCheckBox(){
        openCheckBoxPage()
                .verifySingleCheckBoxIsUnselected();
    }

    @Test
    public void checkMultipleCheckBoxIsSelected(){
        openCheckBoxPage()
                .selectMultipleCheckboxByIndex(1, true)
                .verifyMultipleCheckBoxIsSelected(1, Condition.selected);
    }

    @Test
    public void checkAllCheckboxesAreSelected(){
        openCheckBoxPage()
                .selectAllCheckboxes()
                .verifyAllCheckboxesAreSelected()
                .checkCheckAllButtonIsDisplayed();
    }

    @Test
    public void checkMultipleCheckBoxIsUnselected(){
        openCheckBoxPage()
                .selectAllCheckboxes()
                .verifyAllCheckboxesAreSelected()
                .checkUncheckAllButtonIsDisplayed()
                .unselectAllCheckboxes()
                .verifyMultipleCheckBoxIsUnselected()
                .checkCheckAllButtonIsDisplayed();
    }

    @Test
    public void checkCheckAllButtonWithOneUnselectedCheckbox(){
        openCheckBoxPage()
                .selectAllCheckboxes()
                .verifyAllCheckboxesAreSelected()
                .checkUncheckAllButtonIsDisplayed()
                .unselectMultipleCheckBoxByIndex(3, false)
                .verifyMultipleCheckBoxIsNotSelected(3, Condition.not(Condition.selected))
                .checkCheckAllButtonIsDisplayed();
    }
}

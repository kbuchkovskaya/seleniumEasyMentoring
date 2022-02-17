package com.seasy.ui.tests.form.tests;

import com.seasy.ui.pages.form.JQuerySelectDropDownPage;
import com.seasy.ui.pages.form.Language;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.InputFormsPageName;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class JQuerySelectDropDownTests extends BaseTest {

    @Test
    public void checkSelectedCountry(@Optional("Select Country") String dropdownName){
        openBrowser(InputFormsPageName.JQUERY_SELECT_DROPDOWN, JQuerySelectDropDownPage.class)
                .selectItemFromDropDown(dropdownName, "India")
                .checkSingleDropdownIsSelected(dropdownName);
    }

    @Test
    public void checkSelectedState(@Optional("Select State") String dropdownName){
        openBrowser(InputFormsPageName.JQUERY_SELECT_DROPDOWN, JQuerySelectDropDownPage.class)
                .selectItemFromDropDown(dropdownName, "Iowa")
                .selectItemFromDropDown(dropdownName, "Alaska")
                .selectItemFromDropDown(dropdownName, "Nevada")
                .selectItemFromDropDown(dropdownName, "Colorado")
                .selectItemFromDropDown(dropdownName, "Kansas")
                .removeSelectedItems(dropdownName)
                .checkEmptyMultipleDropDown();
    }

    @Test
    public void checkSelectedRandomItems(@Optional("Select US Outlying Territories") String dropdownName){
        openBrowser(InputFormsPageName.JQUERY_SELECT_DROPDOWN, JQuerySelectDropDownPage.class)
                .randomItemFromDropdown(dropdownName, 1)
                .checkSingleDropdownIsSelected(dropdownName);
    }

    @Test
    public void checkSelectedUsTerritories(@Optional("Select US Outlying Territories") String dropdownName){
        openBrowser(InputFormsPageName.JQUERY_SELECT_DROPDOWN, JQuerySelectDropDownPage.class)
                .selectItemFromDropDown(dropdownName, "Puerto Rico");
    }

    @Test
    public void checkNoResultFound(@Optional("Select Country") String dropdownName){
        openBrowser(InputFormsPageName.JQUERY_SELECT_DROPDOWN, JQuerySelectDropDownPage.class)
                .selectItemFromDropDown(dropdownName, "WEr")
                .checkNoResultsFound();
    }

    @Test
    public void checkCategoriesOptionsInNotEmpty(){
        openBrowser(InputFormsPageName.JQUERY_SELECT_DROPDOWN, JQuerySelectDropDownPage.class)
                .checkCategoryOptionsIsNotEmpty();
    }

    @Test
    public void checkCategoriesOptions(){
        openBrowser(InputFormsPageName.JQUERY_SELECT_DROPDOWN, JQuerySelectDropDownPage.class)
                .verifyLanguageIsInRightCategory(Language.PHP);
    }
}

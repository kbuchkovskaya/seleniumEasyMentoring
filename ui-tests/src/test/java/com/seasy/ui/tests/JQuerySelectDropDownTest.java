package com.seasy.ui.tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class JQuerySelectDropDownTest extends BaseTest{

    @Test
    public void checkSelectedCountry(@Optional("Select Country") String dropdownName){
        openJQuerySelectDropDownPage()
                .selectItemFromDropDown(dropdownName, "India")
                .checkSingleDropdownIsSelected(dropdownName);
    }

    @Test
    public void checkSelectedState(@Optional("Select State") String dropdownName){
        openJQuerySelectDropDownPage()
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
        openJQuerySelectDropDownPage()
                .randomItemFromDropdown(dropdownName, 1)
                .checkSingleDropdownIsSelected(dropdownName);
    }

    @Test
    public void checkSelectedUsTerritories(@Optional("Select US Outlying Territories") String dropdownName){
        openJQuerySelectDropDownPage()
                .selectItemFromDropDown(dropdownName, "Puerto Rico");
    }

    @Test
    public void checkNoResultFound(@Optional("Select Country") String dropdownName){
        openJQuerySelectDropDownPage()
                .selectItemFromDropDown(dropdownName, "WEr")
                .checkNoResultsFound();
    }

    @Test
    public void checkCategoriesOptionsInNotEmpty(){
        openJQuerySelectDropDownPage()
                .checkCategoryOptionsIsNotEmpty();
    }
}

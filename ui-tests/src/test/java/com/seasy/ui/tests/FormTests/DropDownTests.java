package com.seasy.ui.tests.FormTests;

import com.seasy.ui.tests.BaseTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropDownTests extends BaseTest {

    @Test
    public void checkSelectedDayFromDropDown(){
        openDropDownPage()
                .selectDayFromList();
    }

    @Parameters({"Ohio"})
    @Test
    public void checkSelectedCity(@Optional("Ohio") String city){
        openDropDownPage()
                .selectCityFromMultiDropDown(city)
                .clickGetFirstCityFromMultiDropDownButton()
                .verifyOneSelectedCity(city);
    }

    @Parameters({"Ohio", "Florida"})
    @Test
    public void checkSelectedCities(@Optional("Ohio") String city1, @Optional("Florida") String city2) {
        openDropDownPage()
                .selectCityFromMultiDropDown(city1)
                .selectCityFromMultiDropDown(city2)
                .clickGetAllCitiesFromMultiDropDownButton()
                .verifySelectedCities(city1, city2);
    }
}

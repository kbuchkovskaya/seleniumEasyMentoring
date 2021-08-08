package com.seasy.ui.tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropDownTests extends BaseTest{

    @Parameters({"singleDayDropDown"})
    @Test
    public void checkSelectedDayFromDropDown(String param){
        openDropDownPage()
                .selectDayFromList(param)
                .verifySelectedDay(param);
    }

    @Parameters({"Ohio"})
    @Test
    public void checkSelectedCity(@Optional("Ohio") String city){
        openDropDownPage()
                .selectOneCityFromMultiList(city)
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

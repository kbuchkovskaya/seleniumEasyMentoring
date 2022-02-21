package com.seasy.ui.tests.form.tests;

import com.seasy.ui.pages.form.DropDownPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.InputFormsPageName;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropDownTests extends BaseTest {
	
	@Test
	public void checkSelectedDayFromDropDown() {
		openBrowser(InputFormsPageName.SELECT_DROPDOWN_LIST, DropDownPage.class)
				.selectDayFromList();
	}
	
	@Parameters({"Ohio"})
	@Test
	public void checkSelectedCity(@Optional("Ohio") String city) {
		openBrowser(InputFormsPageName.SELECT_DROPDOWN_LIST, DropDownPage.class)
				.selectCityFromMultiDropDown(city)
				.clickGetFirstCityFromMultiDropDownButton()
				.verifyOneSelectedCity(city);
	}
	
	@Parameters({"Ohio", "Florida"})
	@Test
	public void checkSelectedCities(@Optional("Ohio") String city1, @Optional("Florida") String city2) {
		openBrowser(InputFormsPageName.SELECT_DROPDOWN_LIST, DropDownPage.class)
				/* .selectCityFromMultiDropDown(city1)
				 .selectCityFromMultiDropDown(city2)*/
				.selectTwoCitiesFromList(city1, city2)
				.clickGetAllCitiesFromMultiDropDownButton()
				.verifySelectedCities(city1, city2);
	}
}

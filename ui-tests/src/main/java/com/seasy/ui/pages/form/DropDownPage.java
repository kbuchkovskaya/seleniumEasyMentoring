package com.seasy.ui.pages.form;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class DropDownPage {
	
	private final SelenideElement firstSelectedCityCheckButton = $("#printMe");
	private final SelenideElement allSelectedCitiesCheckButton = $("#printAll");
	private final SelenideElement checkSelectedCities = $(".getall-selected");
	
	private final ElementsCollection daysList = $$("#select-demo option");
	private final ElementsCollection citiesList = $$("#multi-select option");
	
	Random random = new Random();
	
	public DropDownPage selectDayFromList() {
		int randomItem = random.nextInt(daysList.size());
		daysList.get(randomItem).click();
		return new DropDownPage();
	}
	
	public DropDownPage verifyOneSelectedCity(String city) {
		checkSelectedCities.shouldHave(Condition.text(city));
		return new DropDownPage();
	}
	
	public DropDownPage selectCityFromMultiDropDown(String city) {
		citiesList.filterBy(Condition.text(city)).forEach(SelenideElement::click);
		return new DropDownPage(); //return this;
	}
	
	public DropDownPage selectTwoCitiesFromList(String city1, String city2) {
		SelenideElement c1 = citiesList.findBy(Condition.text(city1));
		SelenideElement c2 = citiesList.findBy(Condition.text(city2));
		//fail
		Selenide.actions().keyDown(Keys.CONTROL).click(c1).click(c2).keyUp(Keys.CONTROL).build().perform();
		return new DropDownPage();
	}
	
	public DropDownPage clickGetFirstCityFromMultiDropDownButton() {
		firstSelectedCityCheckButton.click();
		return new DropDownPage();
	}
	
	public DropDownPage clickGetAllCitiesFromMultiDropDownButton() {
		allSelectedCitiesCheckButton.click();
		return new DropDownPage();
	}
	
	public DropDownPage verifySelectedCities(String city1, String city2) {
		checkSelectedCities.shouldBe(Condition.text("Options selected are : " + city1 + "," + city2));
		return new DropDownPage();
	}
	
}

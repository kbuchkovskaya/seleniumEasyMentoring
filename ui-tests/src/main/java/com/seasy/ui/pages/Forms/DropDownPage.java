package com.seasy.ui.pages.Forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class DropDownPage{

    private final SelenideElement selectedDay = $(".selected-value"),
    firstSelectedCityCheckButton = $("#printMe"),
    allSelectedCitiesCheckButton = $("#printAll"),
    checkSelectedCities = $(".getall-selected");

    private final ElementsCollection daysList = $$("#select-demo option"),
    citiesList = $$("#multi-select option");

    public void selectDayFromList(){
        Random random = new Random();
        int randomItem = random.nextInt(daysList.size());
        daysList.get(randomItem).click();
        selectedDay.shouldHave(Condition.text(daysList.get(randomItem).text()));
        new DropDownPage();
    }

    public void verifyOneSelectedCity(String city){
        checkSelectedCities.shouldHave(Condition.text(city));
        new DropDownPage();
    }

    public DropDownPage selectCityFromMultiDropDown(String city){
        citiesList.filterBy(Condition.text(city)).forEach(SelenideElement::click);
        //citiesList.forEach(cit -> cit.text(city)..;
        //sendKeys(Keys.chord(Keys.CONTROL, Keys.DOWN))
        return new DropDownPage();
    }

    public DropDownPage clickGetFirstCityFromMultiDropDownButton(){
        firstSelectedCityCheckButton.click();
        return new DropDownPage();
    }

    public DropDownPage clickGetAllCitiesFromMultiDropDownButton(){
        allSelectedCitiesCheckButton.click();
        return new DropDownPage();
    }

    public void verifySelectedCities(String city1, String city2){
        checkSelectedCities.shouldBe(Condition.text("Options selected are : " + city1 + "," + city2));
    }

}

package com.seasy.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DropDownPage{

    private final SelenideElement daysSelector = $("#select-demo"),
    selectedDay = $(".selected-value"),
    firstSelectedCityCheckButton = $("#printMe"),
    allSelectedCitiesCheckButton = $("#printAll"),
    checkSelectedCities = $(".getall-selected");

    private final ElementsCollection daysList = $$("#select-demo option"),
    citiesList = $$("#multi-select option");

    public DropDownPage selectDayFromList(String day){
        //daysSelector.click();
        daysList.filterBy(Condition.text(day)).forEach(SelenideElement::click);
        return new DropDownPage();
    }

    public void verifySelectedDay(String day){
        selectedDay.shouldHave(Condition.text(day));
        new DropDownPage();
    }

    public DropDownPage selectOneCityFromMultiList(String city){
        citiesList.filterBy(Condition.text(city)).forEach(SelenideElement::click);
        return new DropDownPage();
    }

    public void verifyOneSelectedCity(String city){
        checkSelectedCities.shouldHave(Condition.text(city));
        new DropDownPage();
    }

    public DropDownPage selectCityFromMultiDropDown(String city){
        citiesList.filterBy(Condition.text(city)).forEach(SelenideElement::click);
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

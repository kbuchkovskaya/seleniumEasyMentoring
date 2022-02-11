package com.seasy.ui.pages.Forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class DropDownPage{

    private final SelenideElement firstSelectedCityCheckButton = $("#printMe"),
    allSelectedCitiesCheckButton = $("#printAll"),
    checkSelectedCities = $(".getall-selected");

    private final ElementsCollection daysList = $$("#select-demo option"),
    citiesList = $$("#multi-select option");

    public void selectDayFromList(){
        Random random = new Random();
        int randomItem = random.nextInt(daysList.size());
        daysList.get(randomItem).click();
    }

    public void verifyOneSelectedCity(String city){
        checkSelectedCities.shouldHave(Condition.text(city));
    }

    public DropDownPage selectCityFromMultiDropDown(String city){
        citiesList.filterBy(Condition.text(city)).forEach(SelenideElement::click);
        return new DropDownPage();
        //return this;
    }

    public DropDownPage selectTwoCitiesFromList(String city1, String city2){
        SelenideElement c1 = citiesList.findBy(Condition.text(city1));
        SelenideElement c2 = citiesList.findBy(Condition.text(city2));
        //fail
        Selenide.actions().keyDown(Keys.CONTROL).click(c1).click(c2).keyUp(Keys.CONTROL).build().perform();
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

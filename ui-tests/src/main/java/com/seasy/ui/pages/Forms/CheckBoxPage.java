package com.seasy.ui.pages.Forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckBoxPage {

    private final SelenideElement singleCheckBox = $("#isAgeSelected"),
    checkButton = $("#check1");

    private final ElementsCollection optionsCollection = $x("//div[@class=\"panel panel-default\"][contains(., \"Multiple Checkbox Demo\")]").$$(".checkbox");

    public CheckBoxPage selectSingleCheckBox(){
        singleCheckBox.click();
        return new CheckBoxPage();
    }

    public CheckBoxPage unselectSingleCheckBox(){
        singleCheckBox.shouldBe(Condition.selected);
        singleCheckBox.click();
        return new CheckBoxPage();
    }

    public void verifySingleCheckBoxIsSelected(){
        singleCheckBox.should(Condition.selected);
        new CheckBoxPage();
    }

    public void verifySingleCheckBoxIsUnselected(){
        singleCheckBox.shouldNotBe(Condition.selected);
        new CheckBoxPage();
    }

    //start from 1
    public CheckBoxPage selectMultipleCheckboxByIndex(int index, boolean isSelected){
        optionsCollection.findBy(text("Option " + index)).$("input").setSelected(isSelected);
        return new CheckBoxPage();
    }

    public CheckBoxPage unselectMultipleCheckBoxByIndex(int index, boolean isSelected){
        optionsCollection.findBy(text("Option " + index)).$("input").setSelected(isSelected);
        return new CheckBoxPage();
    }

    public void verifyMultipleCheckBoxIsSelected(int index, Condition condition){
        optionsCollection.findBy(text("Option " + index)).$("input").should(condition);
        new CheckBoxPage();
    }

    public CheckBoxPage verifyMultipleCheckBoxIsNotSelected(int index, Condition condition){
        optionsCollection.findBy(text("Option " + index)).$("input").should(condition);
        return new CheckBoxPage();
    }

    public CheckBoxPage selectAllCheckboxes(){
        optionsCollection.forEach(checkbox-> checkbox.$("input").click());
        return new CheckBoxPage();
    }

    public CheckBoxPage verifyAllCheckboxesAreSelected(){
        optionsCollection.forEach(checkbox-> checkbox.$("input").shouldBe(selected));
        return new CheckBoxPage();
    }

    public CheckBoxPage checkCheckAllButtonIsDisplayed(){
        checkButton.shouldHave(attribute("value", "Check All"));
        return new CheckBoxPage();
    }

    public CheckBoxPage unselectAllCheckboxes(){
        optionsCollection.forEach(checkbox-> checkbox.$("input").click());
        return new CheckBoxPage();
    }

    public CheckBoxPage verifyMultipleCheckBoxIsUnselected(){
        optionsCollection.forEach(checkbox-> checkbox.$("input").shouldNotBe(selected));
        return new CheckBoxPage();
    }

    public CheckBoxPage checkUncheckAllButtonIsDisplayed(){
        checkButton.shouldHave(attribute("value", "Uncheck All"));
        return new CheckBoxPage();
    }
}

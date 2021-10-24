package com.seasy.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class InputFormSubmitPage {

    private final SelenideElement submitButton = $("button[type=\"submit\"][class=\"btn btn-default\"]");

    private final ElementsCollection states = $$("select[name=\"state\"] option"),
    hosting = $$(".radio"),
    formInput = $$("div.form-group");

    public InputFormSubmitPage inputData(SubmitFormFieldsName fieldName, String fieldValue){
        SelenideElement input = formInput.findBy(Condition.have(Condition.text(fieldName.val))).$("input");
        input.setValue(fieldValue);
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage checkEnteredData(String fieldName, String fieldValue){
        SelenideElement input = formInput.findBy(Condition.have(Condition.text(fieldName))).$("input");
        input.shouldHave(Condition.value(fieldValue));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage inputTextAreaData(SubmitFormFieldsName fieldName, String fieldValue){
        SelenideElement input = formInput.findBy(Condition.have(Condition.text(fieldName.val))).$("textarea");
        input.setValue(fieldValue);
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage deleteEnteredData(SubmitFormFieldsName fieldName){
        SelenideElement input = formInput.findBy(Condition.have(Condition.text(fieldName.val))).$("input");
        int length = Objects.requireNonNull(input.val()).length();
        for(int i = 0; i < length; i++){
            input.sendKeys(Keys.BACK_SPACE);
        }
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage checkFieldValidation(SubmitFormFieldsName fieldName, Condition condition){
        ElementsCollection validations = formInput.findBy(Condition.have(Condition.text(fieldName.val))).$$("small");
        SelenideElement validation = validations.filterBy((Condition.attribute("data-bv-result", "INVALID"))).get(0);
        validation.shouldBe(condition);
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage selectState(String usaState){
        states.filterBy(Condition.text(usaState)).forEach(SelenideElement::click);
        states.findBy(Condition.text(usaState)).shouldBe(Condition.selected);
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage selectHosting(boolean isPresented){
        if(isPresented){
            hosting.findBy(Condition.text("Yes")).$("input").click();
        } else
            hosting.findBy(Condition.text("No")).$("input").click();
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage submitForm(){
        submitButton.click();
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage submitButtonIsDisabled(){
        submitButton.shouldBe(Condition.disabled);
        return new InputFormSubmitPage();
    }
}

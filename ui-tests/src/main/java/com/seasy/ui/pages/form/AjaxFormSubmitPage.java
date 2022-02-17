package com.seasy.ui.pages.form;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AjaxFormSubmitPage {

    private final SelenideElement name = $("#title");
    private final SelenideElement description = $("#description");
    private final SelenideElement submitButton = $("#btn-submit");
    private final SelenideElement submitResult = $("#submit-control");

    public AjaxFormSubmitPage enterName(String formName){
        name.setValue(formName);
        name.shouldHave(Condition.attribute("value", formName));
        return new AjaxFormSubmitPage();
    }

    public AjaxFormSubmitPage enterDescription(String formDescription){
        description.setValue(formDescription);
        description.shouldHave(Condition.attribute("value", formDescription));
        return new AjaxFormSubmitPage();
    }

    public AjaxFormSubmitPage clickSubmitButton(){
        submitButton.click();
        return new AjaxFormSubmitPage();
    }

    public AjaxFormSubmitPage checkNameIsRequiredField(){
        name.shouldBe(Condition.empty);
        name.shouldHave(Condition.attribute("style", "border: 1px solid rgb(255, 0, 0);"));
        return new AjaxFormSubmitPage();
    }

    public AjaxFormSubmitPage verifyFormIsProcessing(){
        submitResult.shouldHave(Condition.text("Ajax Request Is Processing"));
        submitButton.shouldBe(Condition.hidden);
        return new AjaxFormSubmitPage();
    }

    public AjaxFormSubmitPage verifyFormIsSubmitted(){
        submitResult.shouldHave(Condition.text("Form submited Successfully!"));
        submitButton.shouldBe(Condition.hidden);
        return new AjaxFormSubmitPage();
    }
}

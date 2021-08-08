package com.seasy.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class InputFormSubmitPage {

    private final SelenideElement firstName = $x("//div[@class[contains(., \"form-group has-feedback\")]][contains(., \"First Name\")]"),
    emptyFirstNameValidation = $x("//small[@data-bv-validator=\"notEmpty\"][@data-bv-for=\"first_name\"]"),
    firstNameStringLengthValidation = $x("//small[@data-bv-validator=\"stringLength\"][@data-bv-for=\"first_name\"]"),
    lastName = $x("//div[@class[contains(., \"form-group has-feedback\")]][contains(., \"Last Name\")]"),
    emptyLastNameValidation = $("small[data-bv-validator=\"notEmpty\"][data-bv-for=\"last_name\"]"),
    lastNameStringLengthValidation = $("small[data-bv-validator=\"stringLength\"][data-bv-for=\"last_name\"]"),
    email = $x("//div[@class[contains(., \"form-group has-feedback\")]][contains(., \"E-Mail\")]"),
    phone = $x("//div[@class[contains(., \"form-group has-feedback\")]][contains(., \"Phone\")]"),
    address = $x("//div[@class[contains(., \"form-group has-feedback\")]][contains(., \"Address\")]"),
    city = $x("//div[@class[contains(., \"form-group has-feedback\")]][contains(., \"City\")]"),
    zipCode = $x("//div[@class[contains(., \"form-group has-feedback\")]][contains(., \"Zip Code\")]"),
    website = $x("//div[@class=\"form-group\"][contains(., \"Website\")]"),
    description = $x("//div[@class[contains(., \"form-group has-feedback\")]][contains(., \"Project Description\")]"),
    submitButton = $("button[type=\"submit\"][class=\"btn btn-default\"]");

    private final ElementsCollection states = $$("select[name=\"state\"] option"),
    hosting = $$(".radio");

    public InputFormSubmitPage enterFirstName(String name){
        firstName.$("input").setValue(name);
        firstName.$("input").shouldHave(Condition.attribute("value", name));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage verifyFirstNameIsMoreThanTwoCharacters(){
        firstName.shouldHave(Condition.attribute("class", "form-group has-feedback has-success"));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage deleteEnteredFirstName(){
        while (Objects.requireNonNull(firstName.$("input").val()).length() != 0){
            firstName.$("input").sendKeys(Keys.BACK_SPACE);
        }
        firstName.$("input").shouldBe(Condition.empty);
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage verifyFirstNameFieldIsEmpty(){
        emptyFirstNameValidation.shouldBe(Condition.visible);
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage verifyEnteredLessThanTwoCharacterFirstName(){
        firstNameStringLengthValidation.should(Condition.be(Condition.visible));
        return new InputFormSubmitPage();
    }


    public InputFormSubmitPage enterLastName(String surname){
        lastName.$("input").setValue(surname);
        lastName.$("input").shouldHave(Condition.attribute("value",  surname));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage verifyLastNameIsMoreThanTwoCharacters(){
        lastName.shouldHave(Condition.attribute("class", "form-group has-feedback has-success"));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage deleteEnteredLastName(){
        lastName.$("input").shouldNotBe(Condition.empty);
        while (lastName.$("input").val().length() != 0){
            lastName.$("input").sendKeys(Keys.BACK_SPACE);
        }
        lastName.$("input").shouldBe(Condition.empty);
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage verifyLastNameFieldIsEmpty(){
        emptyLastNameValidation.should(Condition.be(Condition.visible));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage verifyEnteredLessThanTwoCharacterLastName(){
        lastNameStringLengthValidation.should(Condition.be(Condition.visible));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage enterEmail(String emailAddress){
        email.$("input").setValue(emailAddress);
        email.$("input").shouldHave(Condition.attribute("value",  emailAddress));
        email.shouldHave(Condition.attribute("class", "form-group has-feedback has-success"));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage enterPhone(String phoneNumber){
        phone.$("input").setValue(phoneNumber);
        phone.$("input").shouldBe(Condition.not(Condition.empty));
        phone.shouldHave(Condition.attribute("class", "form-group has-feedback has-success"));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage enterAddress(String homeAddress){
        address.$("input").setValue(homeAddress);
        address.$("input").shouldHave(Condition.attribute("value",  homeAddress));
        address.shouldHave(Condition.attribute("class", "form-group has-feedback has-success"));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage enterCity(String homeCity){
        city.$("input").setValue(homeCity);
        city.$("input").shouldHave(Condition.attribute("value",  homeCity));
        city.shouldHave(Condition.attribute("class", "form-group has-feedback has-success"));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage selectState(String usaState){
        states.filterBy(Condition.text(usaState)).forEach(SelenideElement::click);
        states.findBy(Condition.text(usaState)).shouldBe(Condition.selected);
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage enterZipCode(String code){
        zipCode.$("input").setValue(code);
        zipCode.$("input").shouldHave(Condition.attribute("value",  code));
        zipCode.shouldHave(Condition.attribute("class", "form-group has-feedback has-success"));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage enterWebsite(String site){
        website.$("input").setValue(site);
        website.$("input").shouldHave(Condition.attribute("value",  site));
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage selectHosting(boolean isPresented){
        if(isPresented){
            hosting.findBy(Condition.text("Yes")).$("input").click();
        } else
            hosting.findBy(Condition.text("No")).$("input").click();
        return new InputFormSubmitPage();
    }

    public InputFormSubmitPage enterProjectDescription(String projectDescription){
        description.$("textarea").setValue(projectDescription);
        description.$("textarea").shouldHave(Condition.attribute("value",  projectDescription));
        description.shouldHave(Condition.attribute("class", "form-group has-feedback has-success"));
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

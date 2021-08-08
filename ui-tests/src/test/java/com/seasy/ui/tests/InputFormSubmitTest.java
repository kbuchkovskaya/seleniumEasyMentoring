package com.seasy.ui.tests;

import org.testng.annotations.Test;

public class InputFormSubmitTest extends BaseTest{

    @Test
    public void submitContactForm(){
        openInputFormSubmit()
                .enterFirstName("Kateryna")
                .verifyFirstNameIsMoreThanTwoCharacters()
                .enterLastName("Buchkovska")
                .verifyLastNameIsMoreThanTwoCharacters()
                .enterEmail("kateryna@gmail.com")
                .enterPhone("+1545345355")
                .enterAddress("Enth str.")
                .enterCity("Chernivtsi")
                .selectState("Georgia")
                .enterZipCode("12345")
                .enterWebsite("seleniumeasy.com/")
                .selectHosting(true)
                .enterProjectDescription("Project description")
                .submitForm();
    }

    @Test
    public void checkEmptyFirstAndLastName(){
        openInputFormSubmit()
                .enterFirstName("Kateryna")
                .verifyFirstNameIsMoreThanTwoCharacters()
                .deleteEnteredFirstName()
                .verifyFirstNameFieldIsEmpty()
                .enterLastName("Buchkovska")
                .verifyLastNameIsMoreThanTwoCharacters()
                .deleteEnteredLastName()
                .verifyLastNameFieldIsEmpty();
    }

    @Test
    public void checkFirstAndLastNameLengthLessThanTwoCharacters(){
        openInputFormSubmit()
                .enterFirstName("K")
                .verifyEnteredLessThanTwoCharacterFirstName()
                .enterLastName("B")
                .verifyEnteredLessThanTwoCharacterLastName();
    }

    @Test
    public void checkSendFormIsImpossibleWithEmptyFields(){
        openInputFormSubmit()
                .enterFirstName("Kateryna")
                .verifyFirstNameIsMoreThanTwoCharacters()
                .deleteEnteredFirstName()
                .verifyFirstNameFieldIsEmpty()
                .submitButtonIsDisabled();
    }

}

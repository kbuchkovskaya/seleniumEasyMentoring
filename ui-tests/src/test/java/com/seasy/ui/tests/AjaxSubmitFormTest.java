package com.seasy.ui.tests;

import org.testng.annotations.Test;

public class AjaxSubmitFormTest extends BaseTest{

    @Test
    public void submitForm(){
        openAjaxSubmitForm()
                .enterName("Kateryna")
                .enterDescription("Description")
                .clickSubmitButton();
    }

    @Test
    public void checkFormIsSubmitted(){
        openAjaxSubmitForm()
                .enterName("Kateryna")
                .enterDescription("Description")
                .clickSubmitButton()
                .verifyFormIsProcessing()
                .verifyFormIsSubmitted();
    }

    @Test
    public void checkRequiredNameField(){
        openAjaxSubmitForm()
                .clickSubmitButton()
                .checkNameIsRequiredField();
    }
}

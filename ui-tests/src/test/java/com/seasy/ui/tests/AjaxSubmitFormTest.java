package com.seasy.ui.tests;

import com.seasy.ui.pages.User;
import org.testng.annotations.Test;

public class AjaxSubmitFormTest extends BaseTest{

    User user = new User.Builder()
            .withFirstName("Kateryna")
            .withProjectDescription("Project Description")
            .build();

    @Test
    public void submitForm(){
        openAjaxSubmitForm()
                .enterName(user.firstName)
                .enterDescription(user.projectDescription)
                .clickSubmitButton();
    }

    @Test
    public void checkFormIsSubmitted(){
        openAjaxSubmitForm()
                .enterName(user.firstName)
                .enterDescription(user.projectDescription)
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

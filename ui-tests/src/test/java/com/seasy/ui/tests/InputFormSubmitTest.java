package com.seasy.ui.tests;

import com.codeborne.selenide.Condition;
import com.seasy.ui.pages.User;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.seasy.ui.pages.SubmitFormFieldsName.*;

public class InputFormSubmitTest extends BaseTest{

    public User user = new User.Builder()
            .withFirstName("Kateryna")
            .withLastName("Buchkovska")
            .withEmail("buchkovska@gmail.com")
            .withPhone("++3834233454")
            .withAddress("Ent str.")
            .withCity("Chernivtsi")
            .withZipCode("58032")
            .withWebSite("buchkovska.com")
            .withProjectDescription("Project description")
            .build();

    @Test
    public void checkDeletedFirstName(){
        openInputFormSubmit()
                .inputData(FIRST_NAME_FIELD, user.firstName)
                .deleteEnteredData(FIRST_NAME_FIELD)
                .checkFieldValidation(FIRST_NAME_FIELD, visible);
    }

    @Test
    public void checkFromSubmitWithAllDataEntered(){
        openInputFormSubmit()
                .inputData(FIRST_NAME_FIELD, user.firstName)
                .inputData(LAST_NAME_FIELD, user.lastName)
                .inputData(EMAIL_FIELD, user.email)
                .inputData(PHONE_FIELD, user.phone)
                .inputData(ADDRESS_FIELD, user.address)
                .inputData(CITY_FILED, user.city)
                .selectState("Alaska")
                .inputData(ZIP_CODE_FILED, user.zipCode)
                .inputData(WEBSITE_FIELD, user.webSite)
                .selectHosting(false)
                .inputTextAreaData(PROJECT_DESCRIPTION_FIELD, user.projectDescription)
                .submitForm();
    }

    @Test
    public void checkSubmitButtonIsDisabled(){
        openInputFormSubmit()
                .inputData(FIRST_NAME_FIELD, user.firstName)
                .inputData(LAST_NAME_FIELD, user.lastName)
                .submitForm()
                .checkFieldValidation(EMAIL_FIELD, visible)
                .checkFieldValidation(ADDRESS_FIELD, Condition.text("Please supply your email address"))
                .submitButtonIsDisabled();
    }
}

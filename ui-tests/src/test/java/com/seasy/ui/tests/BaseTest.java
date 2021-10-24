package com.seasy.ui.tests;

import com.codeborne.selenide.Selenide;
import com.seasy.ui.pages.*;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    public CheckBoxPage openCheckBoxPage(){
        openBrowser("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
        return new CheckBoxPage();
    }

    public SimpleFormPage openSimpleFormPage(){
        openBrowser("https://demo.seleniumeasy.com/basic-first-form-demo.html");
        return new SimpleFormPage();
    }

    public RadioButtonsPage openRadioButtonsPage(){
        openBrowser("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        return new RadioButtonsPage();
    }

    public DropDownPage openDropDownPage(){
        openBrowser("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        return new DropDownPage();
    }

    public InputFormSubmitPage openInputFormSubmit(){
        openBrowser("https://demo.seleniumeasy.com/input-form-demo.html");
        return new InputFormSubmitPage();
    }

    public AjaxFormSubmitPage openAjaxSubmitForm(){
        openBrowser("https://demo.seleniumeasy.com/ajax-form-submit-demo.html");
        return new AjaxFormSubmitPage();
    }

    public JQuerySelectDropDownPage openJQuerySelectDropDownPage(){
        openBrowser("https://demo.seleniumeasy.com/jquery-dropdown-search-demo.html");
        return new JQuerySelectDropDownPage();
    }

    public void openBrowser(String url){
        open(url);
        Selenide.switchTo().activeElement().sendKeys(Keys.ESCAPE);
    }

}

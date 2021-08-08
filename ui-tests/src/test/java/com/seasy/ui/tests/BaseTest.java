package com.seasy.ui.tests;

import com.codeborne.selenide.Selenide;
import com.seasy.ui.pages.*;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    public CheckBoxPage openCheckBoxPage(){
        openBrowser("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        return new CheckBoxPage();
    }

    public SimpleFormPage openSimpleFormPage(){
        openBrowser("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        return new SimpleFormPage();
    }

    public RadioButtonsPage openRadioButtonsPage(){
        openBrowser("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        return new RadioButtonsPage();
    }

    public DropDownPage openDropDownPage(){
        openBrowser("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        return new DropDownPage();
    }

    public InputFormSubmitPage openInputFormSubmit(){
        openBrowser("https://www.seleniumeasy.com/test/input-form-demo.html");
        return new InputFormSubmitPage();
    }

    public AjaxFormSubmitPage openAjaxSubmitForm(){
        openBrowser("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
        return new AjaxFormSubmitPage();
    }

    public void openBrowser(String url){
        open(url);
        Selenide.switchTo().activeElement().sendKeys(Keys.ESCAPE);
    }

}

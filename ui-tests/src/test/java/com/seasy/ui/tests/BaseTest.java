package com.seasy.ui.tests;

import com.codeborne.selenide.Selenide;
import com.seasy.ui.pages.*;
import com.seasy.ui.pages.DatePickers.BootstrapDatePickerPage;
import org.openqa.selenium.Keys;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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

    public BootstrapDatePickerPage openBootstrapDatePickerPage(){
        openBrowser("https://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");
        return new BootstrapDatePickerPage();
    }

    public void openBrowser(String url){
        //Configuration.browser = SelenoidChromeDriverProvider.class.getName();
        open(url);
        Selenide.switchTo().activeElement().sendKeys(Keys.ESCAPE);
    }

    public String getDayToday(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return formatter.format(date);
    }

 /*   @BeforeMethod
    protected void setUp(Method method){
        String browser = System.getProperty("Browser", "chrome");

    }
*/
}

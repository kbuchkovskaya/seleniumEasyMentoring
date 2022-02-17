package com.seasy.ui.tests;

import com.codeborne.selenide.Selenide;
import com.seasy.ui.tests.utils.ReadProperties;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {

    ReadProperties path = new ReadProperties();

    public <PageObjectClass> PageObjectClass openBrowser(String pageName, Class<PageObjectClass> pageObjectClassClass){
        //Configuration.browser = SelenoidChromeDriverProvider.class.getName();
        open(path.getPath(pageName));
        Selenide.switchTo().activeElement().sendKeys(Keys.ESCAPE); //close adv popup
        return page(pageObjectClassClass);
    }

/*
    @BeforeMethod
    protected void setUp(Method method){
        String browser = System.getProperty("Browser", "chrome");

    }
*/
}

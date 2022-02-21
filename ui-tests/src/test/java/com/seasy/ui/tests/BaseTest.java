package com.seasy.ui.tests;

import com.codeborne.selenide.Selenide;
import com.seasy.ui.tests.utils.files.Path;
import com.seasy.ui.tests.utils.files.ReadProperties;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {
	
	ReadProperties path = new ReadProperties();
	
	public <PageObjectClass> PageObjectClass openBrowser(String pageName, Class<PageObjectClass> pageObjectClassClass) {
		//Configuration.browser = SelenoidChromeDriverProvider.class.getName();
		open(path.getPropertiesValue(pageName, "src/main/resources/paths.properties"));
		Selenide.switchTo().activeElement().sendKeys(Keys.ESCAPE); //close adv popup
		return page(pageObjectClassClass);
	}
	
	@BeforeSuite
	public void maximizeBrowser() {
		//Configuration.browser = SelenoidChromeDriverProvider.class.getName();
		//path.getPropertiesValue()
		//selenide.properties
	}

/*    @BeforeMethod
    protected void setUp(Method method){
        String browser = System.getProperty("Browser", "chrome");

    }*/
    
}

package com.seasy.ui.tests;

import com.codeborne.selenide.Selenide;
import com.seasy.ui.pages.utils.files.ReadProperties;
import com.seasy.ui.tests.utils.files.Path;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {
	
	ReadProperties path = new ReadProperties();
	
	public <PageObjectClass> PageObjectClass openBrowser(String pageName, Class<PageObjectClass> pageObjectClassClass) {
		//Configuration.browser = SelenoidChromeDriverProvider.class.getName();
		open(path.getPropertiesValue(pageName, Path.PATH_TO_URL_FILE));
		Selenide.switchTo().activeElement().sendKeys(Keys.ESCAPE); //close adv popup
		return page(pageObjectClassClass);
	}
	
}

package com.seasy.ui.tests.utils.selenoid;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public interface SelenoidProvider extends WebDriverProvider {
	
	default WebDriver instantiateDriver(DesiredCapabilities capabilities) {
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo", false);
		/**
		 *  Default value is 'Europe/Moscow' which causes the angular errors when
		 *  application tries to obtain some scripts from eba.ibm.com(IBM Watson)
		 * */
		capabilities.setCapability("timeZone", "Europe/Kiev");
		try {
			String remoteUrl = "http://localtest:4444/wd/hub/";
			RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
			remoteWebDriver.setFileDetector(new LocalFileDetector());
			return remoteWebDriver;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}

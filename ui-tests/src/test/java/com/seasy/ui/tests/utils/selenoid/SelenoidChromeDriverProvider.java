package com.seasy.ui.tests.utils.selenoid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SelenoidChromeDriverProvider implements SelenoidProvider {
	@Nonnull
	@Override
	public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//WebDriverManager.chromedriver().browserVersion("97").setup();
		capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
		try {
			return new RemoteWebDriver(new URL(System.getProperty("remoteUrl") == null ? "http://localhost:4444/wd/hub" : System.getProperty("remoteUrl")), capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static ChromeOptions getChromeOptions() {
		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		//chromePrefs.put("download.default_directory", BaseTest.getDownloadDir());
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("password_manager_enabled", false);
		chromePrefs.put(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--allow-running-insecure-content");
		return options;
	}
}

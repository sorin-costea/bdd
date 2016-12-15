package org.sorincos.bdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private DriverFactory() {
		// Do-nothing..Do not allow to initialize this class from outside
	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local
			// driver
			// object
			// for
			// webdriver
			{
		@Override
		protected WebDriver initialValue() {
			return new FirefoxDriver(); // can be replaced with other browser
			// drivers
		}
			};

			public WebDriver getDriver() // call this method to get the driver object
			// and launch the browser
			{
				return driver.get();
			}

			public void removeDriver() // Quits the driver and closes the browser
			{
				driver.get().quit();
				driver.remove();
			}
}
package org.sorincos.bdd.pageobj;

import org.openqa.selenium.WebDriver;
import org.sorincos.bdd.DriverFactory;

public abstract class AbstractPage {
	protected final WebDriver driver;

	public AbstractPage() {
		driver = DriverFactory.getInstance().getDriver();
	}
}

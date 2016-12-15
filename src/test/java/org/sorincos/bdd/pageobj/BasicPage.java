package org.sorincos.bdd.pageobj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "basicpage")
public class BasicPage extends AbstractPage {
	@Autowired
	private LoginPage loginPage;

	@Autowired
	private ContactPage contactPage;

	public ContactPage createContact() {
		assertThat(driver.getTitle(), is(equalTo("SuiteCRM")));
		driver.findElement(By.id("quickcreatetop")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Create Contact')]")).click();
		return contactPage;
	}

	public LoginPage logout() {
		driver.findElement(By.id("usermenucollapsed")).click();
		final WebElement button = driver.findElement(By.id("logout_link"));
		final JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", button);
		return loginPage;
	}
}

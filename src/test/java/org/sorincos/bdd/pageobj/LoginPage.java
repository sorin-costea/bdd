package org.sorincos.bdd.pageobj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "loginpage")
public class LoginPage extends AbstractPage {

	@Autowired
	private BasicPage basicPage;

	public BasicPage doLogin(final String testUser, final String testPass) {
		assertThat(driver.getTitle(), is(equalTo("SuiteCRM")));
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
		driver.findElement(By.id("user_name")).sendKeys(testUser);
		driver.findElement(By.id("user_password")).sendKeys(testPass);
		final WebElement button = driver.findElement(By.id("bigbutton"));
		final JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", button);
		final List<WebElement> listErrors = driver.findElements(By.className("error"));
		assertThat(listErrors, is(empty()));
		return basicPage;
	}

	public void quit() {
		driver.quit();
	}
}

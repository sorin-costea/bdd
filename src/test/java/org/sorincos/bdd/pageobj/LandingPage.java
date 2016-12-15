package org.sorincos.bdd.pageobj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "landingpage")
public class LandingPage extends AbstractPage {
	@Value("${app.baseurl}")
	private String baseurl;

	private String title;

	@Autowired
	private LoginPage loginPage;

	public LoginPage goToLogin() {
		driver.navigate().to(baseurl);
		assertThat(driver.getTitle(), is(equalTo(title)));
		final WebElement button = driver.findElement(By.xpath("//a[contains(text(), 'Log in to Demo')]"));
		final JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", button);
		return loginPage;
	}

	public void quit(){
		driver.quit();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}
}

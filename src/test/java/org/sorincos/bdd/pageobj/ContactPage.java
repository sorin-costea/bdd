package org.sorincos.bdd.pageobj;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "contactpage")
public class ContactPage extends AbstractPage {

	@Autowired
	private BasicPage basicPage;

	public void editContact(final String name) {
		driver.findElement(By.id("last_name")).sendKeys(name);
		driver.findElement(By.id("SAVE")).click();
		final List<WebElement> listTitles = driver.findElements(By.xpath("//h2[contains(text(), ' " + name + " ')]"));
		assertThat(listTitles, hasSize(1));
	}

	public BasicPage deleteCurrent() {
		driver.findElement(By.id("delete_button")).click();
		final Alert alt = driver.switchTo().alert();
		alt.accept();
		final List<WebElement> listTitles = driver.findElements(By.id("advanced_search_link"));
		assertThat(listTitles, hasSize(1));
		return basicPage;
	}

}

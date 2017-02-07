package org.sorincos.bdd.pageobj;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.sorincos.bdd.DriverFactory;

public abstract class AbstractPage {
  public void navigate(final String value) {
    DriverFactory.getInstance().getDriver().navigate().to(value);
  }

  protected String pageTitle() {
    return DriverFactory.getInstance().getDriver().getTitle();
  }

  protected void acceptAlert() {
    (new FluentWait<>(DriverFactory.getInstance().getDriver())).withTimeout(10, TimeUnit.SECONDS)
        .pollingEvery(10, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.alertIsPresent());
    DriverFactory.getInstance().getDriver().switchTo().alert().accept();
  }

  protected boolean isThere(final String name) {
    final List<WebElement> listTitles = DriverFactory.getInstance().getDriver()
        .findElements(By.xpath("//h2[contains(text(), ' " + name + " ')]"));
    return listTitles.size() == 1;
  }

  protected void editText(final String id, final String value) {
    final WebElement element = (new FluentWait<>(DriverFactory.getInstance().getDriver()))
        .withTimeout(10, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.MILLISECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    element.sendKeys(value);
  }

  protected void clickId(final String id) {
    final WebElement button = DriverFactory.getInstance().getDriver().findElement(By.id(id));
    final JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance()
        .getDriver();
    executor.executeScript("arguments[0].click();", button);
  }

  protected void clickXpathJs(final String value) {
    final WebElement button = DriverFactory.getInstance().getDriver()
        .findElement(By.xpath("//a[contains(text(), '" + value + "')]"));
    final JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance()
        .getDriver();
    executor.executeScript("arguments[0].click();", button);
  }

  protected void clickXpath(final String value) {
    DriverFactory.getInstance().getDriver()
        .findElement(By.xpath("//*[contains(text(), '" + value + "')]")).click();
  }

  protected boolean hasErrors() {
    final List<WebElement> errors = DriverFactory.getInstance().getDriver()
        .findElements(By.className("error"));
    return (errors.size() > 0) && errors.get(0).isDisplayed();
  }

  public void quit() {
    DriverFactory.getInstance().getDriver().quit();
  }

}

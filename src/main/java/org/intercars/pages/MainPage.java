package org.intercars.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.intercars.utils.PropertiesHandler.getUrl;

@Slf4j
public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openApplication() {
        log.info("Opening url: {}", getUrl());
        driver.get(getUrl());
    }

    public void acceptCookies() {
        var element = driver.findElement(By.xpath("//button[contains(@class,'osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept')]"));
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(element));
        clickWhenClickable(element);
    }

    public void clickSelectVehicle() {
        clickWhenClickable(By.xpath("//div[contains(@class,'button-quilt-vehicle')]"));
        driver.switchTo().activeElement();
    }

    public void clickWhenClickable(By element) {
        log.info("Clicking on {}", element.toString());
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public void clickWhenClickable(WebElement element) {
        log.info("Clicking on {}", element.getText());
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}

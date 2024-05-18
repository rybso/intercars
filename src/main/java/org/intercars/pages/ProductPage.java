package org.intercars.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class ProductPage extends MainPage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void adjustAmountAndAddToCart(String amount) {
        log.info("Adding {} amount of product to cart", amount);
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("fcCounter")));
        var element = driver.findElement(By.id("fcCounter"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = arguments[1]", element, amount);
        clickWhenClickable(By.className("cart-add-confirm"));
    }
}

package org.intercars.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class CartPage extends MainPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkItemInCart() {
        log.info("Checking item in cart");
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(@class,'panel-title wynik_active')]")));
        String name = driver.findElement(By.id("name_0")).getText();
        assertEquals(CartModalPage.getDescription(), name);
    }

    public void deleteItemInCart() {
        log.info("Deleting item in cart");
        clickWhenClickable(By.className("cart_trash_item"));
        driver.switchTo().activeElement();
        clickWhenClickable(By.className("swal2-confirm"));
        driver.switchTo().activeElement();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBe(By.className("containerCard"), "KOSZYK JEST PUSTY"));
    }

    public void assertCartIsEmpty() {
        log.info("Checking is cart empty");
        assertTrue(driver.findElement(By.className("containerCard")).getText().contains("KOSZYK JEST PUSTY"));
    }
}

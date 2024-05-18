package org.intercars.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartModalPage extends MainPage {

    public CartModalPage(WebDriver driver) {
        super(driver);
    }

    public void getProductNameAndGoToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("descriptionAddToCard")));
        description = driver.findElement(By.id("descriptionAddToCard")).getText();
        clickWhenClickable(By.xpath("//button[contains(@class,'opistext button-modal-card-red c hide_content add_to_cart2_ok_full_card btn-primary-footer')]"));
    }

    @Getter
    private static String description;
}

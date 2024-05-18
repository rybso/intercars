package org.intercars.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class SelectVehicleModalPage extends MainPage {

    public SelectVehicleModalPage(WebDriver driver) {
        super(driver);
    }

    public void selectBrandModelAndType(String brand, String model, String type, String kod) {
        log.info("Selecting: {} {} {} {}", brand, model, type, kod);
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MakeModelType-select']")));
        clickWhenClickable(By.xpath("//span[@id='select2-ExpandableMake-container']"));
        clickWhenClickable(By.xpath("//ul[contains(@class,'select2-results__options--nested')]//li[contains(.,'" + brand + "')]"));
        clickWhenClickable(By.xpath("//ul[contains(@class,'select2-results__options')]//li[contains(.,'" + model + "')]"));
        clickWhenClickable(By.xpath("//ul[contains(@class,'select2-results__options')]//div[contains(.,'" + type + "')]//div//span[contains(.,'" + kod + "')]"));
    }

}

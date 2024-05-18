package org.intercars.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Slf4j
public class OponyFelgiAkcesoriaPage extends MainPage {

    public OponyFelgiAkcesoriaPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstWithExpectedAvailability() {
        log.info("Click on first product with data availability");
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(.,'Opony / Felgi / Akcesoria')]")));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='fc-add-cart' and @data-availability > 4]/preceding::div[5]"));
        elements.get(1).click();
    }
}

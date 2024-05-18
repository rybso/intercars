package org.intercars.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffertPage extends MainPage {

    public OffertPage(WebDriver driver) {
        super(driver);
    }

    public void goToOponyFelgiAkcesoriaPage() {
        clickWhenClickable(By.xpath("//*[contains(@class,'opony-felgi-akcesoria')]"));
    }

}

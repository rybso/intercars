package org.intercars.automationtests.steps;

import io.cucumber.java8.En;
import org.intercars.driver.DriverFactory;
import org.intercars.pages.*;

public class IntercarsSteps implements En {

    public IntercarsSteps() {
        Given("Strona glowna jest otwarta", () -> new MainPage(DriverFactory.getWebDriver()).openApplication());
        Given("Cookies zostaly zaakceptowane", () -> new MainPage(DriverFactory.getWebDriver()).acceptCookies());

        When("Wybranie samochodu: {string} {string} {string} {string}", (String brand, String model, String type, String kod) -> {
            new MainPage(DriverFactory.getWebDriver()).clickSelectVehicle();
            new SelectVehicleModalPage(DriverFactory.getWebDriver()).selectBrandModelAndType(brand, model, type, kod);
        });
        When("Przejdz do akcesoriow", () -> new OffertPage(DriverFactory.getWebDriver()).goToOponyFelgiAkcesoriaPage());
        When("Dodaj {} sztuki wybranego produktu do koszyka", (String amount) -> {
            new OponyFelgiAkcesoriaPage(DriverFactory.getWebDriver()).clickOnFirstWithExpectedAvailability();
            new ProductPage(DriverFactory.getWebDriver()).adjustAmountAndAddToCart(amount);
            new CartModalPage(DriverFactory.getWebDriver()).getProductNameAndGoToCart();
        });
        When("Usun pozycje w koszyku", () -> new CartPage(DriverFactory.getWebDriver()).deleteItemInCart());

        Then("Sprawdz czy poprawny produkt zostal dodany do koszyka", () -> new CartPage(DriverFactory.getWebDriver()).checkItemInCart());
        Then("Koszyk jest pusty", () -> new CartPage(DriverFactory.getWebDriver()).assertCartIsEmpty());
    }
}

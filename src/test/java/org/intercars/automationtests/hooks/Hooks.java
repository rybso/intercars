package org.intercars.automationtests.hooks;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.intercars.driver.DriverFactory;

@Slf4j
public class Hooks implements En {

    public Hooks() {
        String browser = System.getProperty("browser", "firefox");

        Before((Scenario scenario) -> {
            DriverFactory.initDriver(browser);
            DriverFactory.getWebDriver().manage().window().maximize();
        });

        After((Scenario scenario) -> {
            try {
                DriverFactory.getWebDriver().close();
                DriverFactory.getWebDriver().quit();
            } catch (Exception e) {
                log.info("WebDriver not running");
            }
        });
    }

}

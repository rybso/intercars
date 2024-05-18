package org.intercars.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver getWebDriver() {
        return THREAD_LOCAL.get();
    }

    public static synchronized void initDriver(String browser) {
        if (browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            setChromeDriver(chromeOptions);
            getWebDriver();
        } else if (browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            setFirefoxDriver(firefoxOptions);
            getWebDriver();
        }
    }

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();

    private static void setChromeDriver(ChromeOptions options) {
        THREAD_LOCAL.set(new ChromeDriver(options));
    }

    private static void setFirefoxDriver(FirefoxOptions options) {
        THREAD_LOCAL.set(new FirefoxDriver(options));
    }
}



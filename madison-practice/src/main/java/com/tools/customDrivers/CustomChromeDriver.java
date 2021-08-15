package com.tools.customDrivers;

import java.util.concurrent.TimeUnit;

import net.thucydides.core.webdriver.DriverSource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.tools.constants.Constants;

public class CustomChromeDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        return setCustomChrome();
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

    private WebDriver setCustomChrome() {
        System.out.println("Custom chrome driver instance is created now...");
        System.setProperty("webdriver.chrome.driver", Constants.WEB_DRIVERS_PATH + "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-web-security");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }
}

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getDriver().findElement(By.cssSelector(".product-name span")).getText();
    }

    public Double getPrice() {
        return Double.parseDouble(getDriver().findElement(By.cssSelector("span[id*='product-price']")).getText().replaceAll("[^0-9.]+", ""));
    }

    public String getProductRandomColor() {
        WebElement colorElement = getRandomElementFromList(By.cssSelector("#configurable_swatch_color>li a"));
        clickOn(colorElement);
        return colorElement.getAttribute("title");
    }

    public String getProductRandomSize() {
        WebElement sizeElement = getRandomElementFromList(By.cssSelector("#configurable_swatch_size li:not(.not-available) a"));
        clickOn(sizeElement);
        return sizeElement.getAttribute("title");
    }
}

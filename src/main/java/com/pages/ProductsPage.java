package com.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".next.i-next")
    private WebElementFacade nextButton;

    public WebElement getProductContainer(String productName) {
        boolean isFound = false;
        do {
            List<WebElement> productContainers = getDriver().findElements(By.cssSelector(".products-grid>li"));
            for (WebElement productContainer : productContainers) {
                if (productContainer.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                    return productContainer;
                }
            }
            nextButton.click();
            isFound = false;
        } while (!isFound);
        return null;
    }

    public void openProductDetailsPage(String productName) {
        clickOn(getProductContainer(productName).findElement(By.cssSelector(".product-name a")));

    }

}

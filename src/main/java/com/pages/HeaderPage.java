package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#search")
    private WebElementFacade searchInput;
    @FindBy(css = "button[title='Search']")
    private WebElementFacade searchIcon;

    public void inputSearchTerm(String term) {
        typeInto(searchInput, term);
    }

    public void clickSearchIcon() {
        clickOn(searchIcon);
    }
    //

    @FindBy(css = "#nav li[class*='level0']")
    private List<WebElement> categoryElements;

    @FindBy(css = ".account-cart-wrapper a[class*='skip-account']")
    private WebElement account;

    @FindBy(css = ".account-cart-wrapper a[class*='skip-cart']")
    private WebElement cart;

    public void clickOnAccount() {
        clickOn(account);
    }

    public void clickOnALinkFromAccount(String title) {
        getDriver().findElement(By.cssSelector("#header-account .links ul li a[title='" + title + "']")).click();
    }

    public void clickOnCategory(String categoryName) {
        for (WebElement category : categoryElements) {
            if (category.getText().equalsIgnoreCase(categoryName)) {
                clickOn(category);
                break;
            }
        }
    }

}

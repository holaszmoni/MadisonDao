package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.WebDriver;

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
}

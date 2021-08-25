package com.pages;

import com.tools.constants.ReviewConstants;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MagentoLoginPage extends BasePage {


    public MagentoLoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateThroughCategories(String... pathNodes) {
        Actions actions = new Actions(getDriver());
        for (int i = 0; i < pathNodes.length; i++) {
            WebElement currentElement = getDriver().findElement(By.xpath("//ul/li[a/span[text()='" + pathNodes[i] + "']]"));
            actions.moveToElement(currentElement).perform();
            actions.click().perform();
        }
    }

    @FindBy(css = "input[value='Login']")
    private WebElementFacade loginButton;

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    @FindBy(css = "#message-popup-window > div.message-popup-head > a")
    private WebElementFacade popupMessage;

    public void navigateToMagentoLoginPage() {
        getDriver().get(ReviewConstants.MAGENTO_URL);
    }

    public void loginInMagento() {
        typeInInputWithId("username", ReviewConstants.MAGENTO_USER_NAME);
        typeInInputWithId("login", ReviewConstants.MAGENTO_PASSWORD);
        clickLoginButton();
    }

    public void closePopupMessage() {
        clickOn(popupMessage);
    }

    @FindBy(className = "review-meta")
    private WebElementFacade reviewSection;

    public boolean verifyPresenceOfReview(String name) {
        return reviewSection.containsText(name);
    }

}

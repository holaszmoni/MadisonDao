package com.pages;

import com.tools.constants.Constants;
import com.tools.constants.ReviewConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tools.constants.EnvironmentConstants;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        clickOnWebElementWithText("Account");
        clickOnWebElementWithText("Log In");
        typeInInputWithTitle("Email Address", EnvironmentConstants.EMAIL);
        typeInInputWithTitle("Password", EnvironmentConstants.PASS);
        clickOnWebElementWithText("Login");
    }

    public void login(String email, String password) {
        clickOnWebElementWithText("Account");
        clickOnWebElementWithText("Log In");
        typeInInputWithTitle("Email Address", email);
        typeInInputWithTitle("Password", password);
        clickOnWebElementWithText("Login");
    }

    public void navigateThroughCategories(String... pathNodes) {
        Actions actions = new Actions(getDriver());
        WebElement currentElement = getDriver().findElement(By.xpath("//ul[@id='nav']/li[a/span[text()='" + pathNodes[0] + "']]"));
        actions.moveToElement(currentElement).perform();
        for (int i = 1; i < pathNodes.length - 1; i++) {
            currentElement = currentElement.findElement(By.xpath("/ul/li[a/span[text()='" + pathNodes[i] + "']]"));
            actions.moveToElement(currentElement);
        }
    }

    //
    @FindBy(name = "login[username]")
    private WebElement emailInput;

    @FindBy(name = "login[password]")
    private WebElement passwordInput;

    @FindBy(name = "send")
    private WebElement loginBtn;

    public void setEmailInput(String email) {
        typeInto(emailInput, email);
    }

    public void setPasswordInput(String password) {
        typeInto(passwordInput, password);
    }

    public void clickOnLoginBtn() {
        clickOn(loginBtn);
    }

    public void logIn() {
        setEmailInput(Constants.EMAIL);
        setPasswordInput(Constants.PASSWORD);
        clickOnLoginBtn();
    }
    public void logInConstantsCredentials(){
        setEmailInput(ReviewConstants.USER_TO_UPDATE_USERNAME);
        setPasswordInput(ReviewConstants.USER_TO_UPDATE_PASSWORD);
        clickOnLoginBtn();
    }
}

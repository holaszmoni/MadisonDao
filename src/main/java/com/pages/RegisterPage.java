package com.pages;

import com.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends BasePage {

    @FindBy(css = ".success-msg span")
    private WebElement registrationMsg;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String getRegistrationMsg() {
        return registrationMsg.getText();
    }

    @FindBy(css = ".page-title h1")
    private WebElement createAnAccountMsg;

    public String getCreateAnAccountMsg() {
        return createAnAccountMsg.getText();
    }


    @FindBy(css = "button[title='Register']")
    private WebElement submitBtn;

    public void populateInputField(String name, String value) {
        typeInto(getDriver().findElement(By.cssSelector("input[name='" + name + "']")), value);
    }

    public void fillUserDetails(User user) {
        populateInputField("firstname", user.getFirstName());
        populateInputField("middlename", user.getMiddleName());
        populateInputField("lastname", user.getLastName());
        populateInputField("email", user.getEmail());
        populateInputField("password", user.getPassword());
        populateInputField("confirmation", user.getPassword());
    }

    public void clickOnRegisterBtn() {
        clickOn(submitBtn);
    }

    public String getFirstName() {
        return getDriver().findElement(By.cssSelector("input[name='firstname']")).getText();
    }

    public String getAttribute(String name) {
        System.out.println(getDriver().findElement(By.cssSelector("input[name='" + name + "']")).getText());
        return getDriver().findElement(By.cssSelector("input[name='" + name + "']")).getText();
    }
}

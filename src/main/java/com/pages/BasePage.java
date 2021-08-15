package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import net.serenitybdd.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage extends PageObject {
    public BasePage(final WebDriver driver) {
        super();
    }

    public void waitForWebElementToAppear(WebElement element) {
        withTimeoutOf(Duration.ofSeconds(60)).waitFor(element);
    }

    public void clickOnWebElementWithText(String text) {
        clickOn(getWebElementWithText(text));
    }

    public void moveToElementWithText(String text) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getWebElementWithText(text)).perform();
    }

    public boolean isElementPresent(By by) {
        return getDriver().findElements(by).size() != 0;
    }

    public WebElement getWebElementWithText(String text) {
        List<WebElement> elements = getDriver().findElements(By.xpath("//*[text()='" + text + "']"));
        return elements.stream().filter(element -> element.isDisplayed()).findFirst()
                .orElse(getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]")));
    }

    public void typeInInputWithTitle(String inputTitle, String value) {
        typeInto(getDriver().findElement(By.cssSelector("input[title='" + inputTitle + "']")), value);
    }

    public WebElement getRandomElementFromList(By by) {
        List<WebElement> elements = getDriver().findElements(by);
        Random rand = new Random();
        return elements.get(rand.nextInt(elements.size()));
    }
}

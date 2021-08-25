package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MagentoReviewsPage extends BasePage {
    public MagentoReviewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#reviwGrid_table > tbody > tr:nth-child(1)")
    private List<WebElementFacade> reviewContainer;
    @FindBy(css = "#status_id")
    private WebElementFacade statusReviewDropdownlist;
    @FindBy(css = "button[onclick*='editForm.submit();'")
    private WebElementFacade saveReviewButton;

    public WebElement getReviewContainer(String name) {
        for (WebElement product : reviewContainer) {
            if (product.findElement(org.openqa.selenium.By.cssSelector("#reviwGrid_table > tbody > tr:nth-child(1) > td:nth-child(9)")).getText().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void clickOnPendingReview(String product) {
        getReviewContainer(product).findElement(org.openqa.selenium.By.cssSelector("#reviwGrid_table > tbody > tr:nth-child(1) > td:nth-child(9)")).click();
    }

    public WebElement approveReview(String text) {
        Select oselect = new Select(statusReviewDropdownlist);
        // findByField.selectByVisibleText(text);
        List<WebElement> status = oselect.getOptions();
        for (WebElement approve : status) {
            if (approve.getText().equalsIgnoreCase(text)) {
                approve.click();
                return approve;

            }

        }
        return null;

    }

    public void clickOnSaveReviewButton() {
        clickOn(saveReviewButton);

    }
}

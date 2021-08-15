package com.steps;

import net.thucydides.core.annotations.Step;

import com.pages.HeaderPage;

public class HeaderSteps extends AbstractSteps {
    private static final long serialVersionUID = 1L;
    private HeaderPage headerPage;

    @Step
    public void openAccountSection(String section) {
        basePage.clickOnWebElementWithText("Account");
        basePage.clickOnWebElementWithText(section);
    }

    @Step
    public void navigateToSubmenu(String menuItem, String submenuItem) {
        basePage.moveToElementWithText(menuItem);
        basePage.clickOnWebElementWithText(submenuItem);
    }

    @Step
    public void searchForProduct(String productName) {
        headerPage.inputSearchTerm(productName);
        headerPage.clickSearchIcon();
    }
}

package com.steps;

import net.thucydides.core.annotations.Step;

import com.pages.ProductsPage;

public class ProductsSteps extends AbstractSteps {
    private static final long serialVersionUID = 1L;
    private ProductsPage productsPage;

    @Step
    public void openProductsDetailsPage(String productName) {
        productsPage.openProductDetailsPage(productName);
    }
}

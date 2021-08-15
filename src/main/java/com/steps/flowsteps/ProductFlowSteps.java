package com.steps.flowsteps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import com.steps.AbstractSteps;
import com.steps.HeaderSteps;
import com.steps.ProductDetailsSteps;
import com.steps.ProductsSteps;

public class ProductFlowSteps extends AbstractSteps {
    private static final long serialVersionUID = 1L;
    @Steps
    private HeaderSteps headerSteps;
    @Steps
    private ProductsSteps productsSteps;
    @Steps
    private ProductDetailsSteps productDetailsSteps;

    @Step
    public void addProductToCart(String productName, int quantity) {
        headerSteps.searchForProduct(productName);
        productsSteps.openProductsDetailsPage(productName);
        productDetailsSteps.addProductToCart(3);
    }

    @Step
    public void addProductToWishlist(String productName, int quantity) {
        headerSteps.searchForProduct(productName);
        productsSteps.openProductsDetailsPage(productName);
        productDetailsSteps.addProductToWishList(3);
    }
}

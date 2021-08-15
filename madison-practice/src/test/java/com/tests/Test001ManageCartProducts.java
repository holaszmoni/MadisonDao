package com.tests;

import java.lang.reflect.InvocationTargetException;

import net.serenitybdd.junit.runners.SerenityRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tools.constants.Constants;

@RunWith(SerenityRunner.class)
public class Test001ManageCartProducts extends BaseTest {
    @Test
    public void test001ManageCustomerCartProducts() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        loginSteps.login();
        cartSteps.emptyCartIfIsNotAlreadyEmpty();

        productFlowSteps.addProductToCart("Chelsea Tee", 3);
        productFlowSteps.addProductToCart("Slim fit Dobby Oxford Shirt", 2);
        cartSteps.verifyNoTaxesCartDetails();

        cartSteps.updateCartProductQuantity("Slim fit Dobby Oxford Shirt", 10);
        cartSteps.verifyNoTaxesCartDetails();

        cartSteps.removeCartProduct("Chelsea Tee");
        cartSteps.verifyNoTaxesCartDetails();

        cartSteps.emptyCart();
        cartSteps.verifyCartIsEmpty();

    }

    @Test
    public void test001ManageGuestCartProducts() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        productFlowSteps.addProductToCart("Chelsea Tee", 3);
        productFlowSteps.addProductToCart("Slim fit Dobby Oxford Shirt", 2);
        cartSteps.verifyCartWithPercentageTaxesDetails(Constants.CART_TAX_RATE);

        cartSteps.updateCartProductQuantity("Slim fit Dobby Oxford Shirt", 10);
        cartSteps.verifyCartWithPercentageTaxesDetails(Constants.CART_TAX_RATE);

        cartSteps.removeCartProduct("Chelsea Tee");
        cartSteps.verifyCartWithPercentageTaxesDetails(Constants.CART_TAX_RATE);

        cartSteps.emptyCart();
        cartSteps.verifyCartIsEmpty();
    }
}

package com.tests;

import java.lang.reflect.InvocationTargetException;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.steps.StepEventBus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class Test002ManageWishlistProducts extends BaseTest {
    @Before
    public void dataPrep() {
        loginSteps.login();
        wishlistSteps.emptyWishlistIfIsNotAlreadyEmpty();
    }

    @Test
    public void test002ManageWishlistProducts() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        productFlowSteps.addProductToWishlist("Chelsea Tee", 3);
        productFlowSteps.addProductToWishlist("Slim fit Dobby Oxford Shirt", 2);
        wishlistSteps.verifyWishListDetails();

        wishlistSteps.updateProductQuantity("Slim fit Dobby Oxford Shirt", 10);
        wishlistSteps.verifyWishListDetails();

        wishlistSteps.removeWishlistProduct("Slim fit Dobby Oxford Shirt");
        wishlistSteps.verifyWishListDetails();

        wishlistSteps.emptyWishlist();
        wishlistSteps.verifyWishlistIsEmpty();

    }

    @Override
    @After
    public void tearDown() {
        StepEventBus.getEventBus().clearStepFailures();
        wishlistSteps.emptyWishlistIfIsNotAlreadyEmpty();
        webdriver.quit();
    }
}

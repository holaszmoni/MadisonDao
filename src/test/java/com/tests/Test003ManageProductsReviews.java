package com.tests;

import java.lang.reflect.InvocationTargetException;

import net.bytebuddy.utility.RandomString;
import net.serenitybdd.junit.runners.SerenityRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class Test003ManageProductsReviews extends BaseTest {
    private String reviewSummary = RandomString.make(10);

    @Before
    public void dataPrep() {
        loginSteps.login();
    }

    @Test
    public void test003ManageProductsReviews() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        productFlowSteps.addProductReview("Chelsea Tee", reviewSummary);
        //TODO approve the review from magento admin if that's the only way to make it visible under the product
        //...
        productDetailsSteps.verifyProductReview(reviewSummary);
    }

    @Override
    @Before
    public void tearDown() {
        //ideally, here you could remove the review from admin
    }
}

package com.tests;

import java.lang.reflect.InvocationTargetException;

import com.steps.MagentoLoginSteps;
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
        loginSteps.loginWithConstantCredentials();
    }

    @Test
    public void test003ManageProductsReviews() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        productFlowSteps.addProductReview("AVIATOR SUNGLASSES", reviewSummary);
        productDetailsSteps.clickOnAddAReviewLink();
        productDetailsSteps.setReviewRating("QUALITY", 3);
        productDetailsSteps.setReviewRating("PRICE", 4);
        productDetailsSteps.setReviewRating("VALUE", 1);
        productDetailsSteps.reviewProduct("beautiful product(color, type)", "beautiful", "mona");
        productDetailsSteps.clickOnSubmitReviewButton();

        magentoLoginSteps.navigateToMagentoLoginPage();
        magentoLoginSteps.magentoLogin();
        magentoReviewsSteps.navigateThroughCategories("Catalog", "Reviews and Ratings", "Customer Reviews", "Pending Reviews");
        magentoReviewsSteps.approveReviewsInMagento("AVIATOR SUNGLASSES" , "Approved");

        //TODO approve the review from magento admin if that's the only way to make it visible under the product
        setup();
        productFlowSteps.addProductReview("AVIATOR SUNGLASSES", reviewSummary);
        productDetailsSteps.clickOnAddAReviewLink();
        magentoLoginSteps.verifyPresenceOfReviewInReviewsSection("MONA");

    }

    @Override
    @Before
    public void tearDown() {
        //ideally, here you could remove the review from admin to avoid having too many reviews on certain products
    }
}

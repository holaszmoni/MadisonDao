package com.steps;

import com.pages.MagentoLoginPage;
import com.pages.MagentoReviewsPage;
import net.thucydides.core.annotations.Step;

public class MagentoReviewsSteps extends AbstractSteps {
    private MagentoLoginPage magentoLoginPage;
    private MagentoReviewsPage magentoReviewsPage;

    @Step
    public void navigateThroughCategories(String... pathNodes) {
        magentoLoginPage.navigateThroughCategories(pathNodes);
    }

    @Step
    public void approveReviewsInMagento(String name, String status){
        magentoReviewsPage.clickOnPendingReview(name);
        magentoReviewsPage.approveReview(status);
        magentoReviewsPage.clickOnSaveReviewButton();
    }
}
package com.steps;

import com.pages.MagentoLoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class MagentoLoginSteps extends AbstractSteps{
    private MagentoLoginPage magentoLoginPage;

    @Step
    public void navigateToMagentoLoginPage(){
        magentoLoginPage.navigateToMagentoLoginPage();
    }
    @Step
    public void magentoLogin(){
        magentoLoginPage.loginInMagento();
        magentoLoginPage.closePopupMessage();
    }
    @Step
    public void verifyPresenceOfReviewInReviewsSection(String name) {
        Assert.assertTrue(magentoLoginPage.verifyPresenceOfReview(name));
    }
}

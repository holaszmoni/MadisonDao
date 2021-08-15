package com.tests;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.StepEventBus;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import com.steps.CartSteps;
import com.steps.LoginSteps;
import com.steps.WishlistSteps;
import com.steps.flowsteps.ProductFlowSteps;
import com.tools.constants.EnvironmentConstants;

public class BaseTest {
    @Managed(uniqueSession = true)
    WebDriver webdriver;
    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected CartSteps cartSteps;
    @Steps
    protected ProductFlowSteps productFlowSteps;
    @Steps
    protected WishlistSteps wishlistSteps;

    @Before
    public void setup() {
        System.setProperty("env", "qa2-env");
        webdriver.navigate().to(EnvironmentConstants.BASE_URL);
        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("https.proxyHost", "localhost");
        System.setProperty("https.proxyPort", "8080");
    }

    @After
    public void tearDown() {
        StepEventBus.getEventBus().clearStepFailures();
        webdriver.quit();
    }
}

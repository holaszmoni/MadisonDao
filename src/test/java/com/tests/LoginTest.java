package com.tests;

import com.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;


public class LoginTest extends BaseTest {
    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginTest() {
        loginSteps.loginWithValidCredentials();
    }
}

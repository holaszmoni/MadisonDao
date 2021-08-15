package com.steps;

import net.thucydides.core.annotations.Step;

import com.pages.LoginPage;
import com.tools.constants.Constants;

public class LoginSteps extends AbstractSteps {
    private static final long serialVersionUID = 1L;
    private LoginPage loginPage;

    @Step
    public void login() {
        loginPage.login();
    }

    @Step
    public void login(String email) {
        loginPage.login(email, Constants.USERS_PASSWORD_UNIVERSAL);
    }
}

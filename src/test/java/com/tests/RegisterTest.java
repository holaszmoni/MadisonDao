package com.tests;

import com.factories.UserFactory;
import com.steps.RegisterSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Steps
    private RegisterSteps registerSteps;


    @Test
    public void registerTest() {
        registerSteps.goToRegister();
        registerSteps.registerUser(UserFactory.generateUser());
    }
}

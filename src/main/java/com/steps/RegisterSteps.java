package com.steps;

import com.dao.registration.UserAbstractDao;
import com.dao.registration.UserDao;
import com.models.User;
import net.thucydides.core.annotations.Step;
import com.pages.HeaderPage;
import com.pages.RegisterPage;
import com.tools.constants.MessageConstants;
import org.junit.Assert;

public class RegisterSteps {
    private RegisterPage registerPage;
    private UserAbstractDao userDao = new UserDao();
    private HeaderPage headerPage;

    public User getUserData() {
        User user = new User();
        user.setFirstName(registerPage.getFirstName());
        user.setMiddleName(registerPage.getAttribute("middlename"));
        user.setLastName(registerPage.getAttribute("lastname"));
        user.setEmail(registerPage.getAttribute("email"));
        user.setPassword(registerPage.getAttribute("password"));

        return user;
    }

    @Step
    public void goToRegister() {
        headerPage.clickOnAccount();
        headerPage.clickOnALinkFromAccount("Register");
        Assert.assertEquals(registerPage.getCreateAnAccountMsg(), MessageConstants.createAccountMsg);
    }

    @Step
    public void registerUser(User user) {
        System.out.println(user);
        registerPage.fillUserDetails(user);
        registerPage.clickOnRegisterBtn();
        Assert.assertEquals(registerPage.getRegistrationMsg(), MessageConstants.registrationMsg);
        userDao.saveUser(user);

    }

}

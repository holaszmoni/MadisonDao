package com.factories;

import com.models.User;
import net.bytebuddy.utility.RandomString;

public class UserFactory {

    public static User generateUser() {
        User user = new User();
        user.setFirstName(RandomString.make(10));
        user.setMiddleName(RandomString.make(10));
        user.setLastName(RandomString.make(10));
        user.setEmail(RandomString.make(10) + "@yahoo.com");
        user.setPassword(RandomString.make(10));
        return user;
    }
}
package com.tools.constants;

import com.tools.persistence.PropertyFileReader;
import net.bytebuddy.utility.RandomString;

import java.io.File;

public class Constants {
    public static final String ACCOUNT_MY_CART = "My Cart";
    public static final String ACCOUNT_MY_WISHLIST = "My Wishlist";

    public static final double CART_TAX_RATE = 0.0825;

    public static final String WEB_DRIVERS_PATH = "src" + File.separator + "test" + File.separator + "resources"
            + File.separator + "drivers" + File.separator;

    public static final String USERS_PASSWORD_UNIVERSAL = "test.123";

    //
    public static final String FIRSTNAME = PropertyFileReader.getEnvConstantsItem("FIRSTNAME");
    public static final String MIDDLENAME = PropertyFileReader.getEnvConstantsItem("MIDDLENAME");
    public static final String LASTNAME = PropertyFileReader.getEnvConstantsItem("LASTNAME");
    public static final String EMAIL = RandomString.make(10) + "" + PropertyFileReader.getEnvConstantsItem("EMAIL");
    public static final String PASSWORD = PropertyFileReader.getEnvConstantsItem("PASSWORD");


}

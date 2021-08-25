package com.tools.constants;

import com.tools.persistence.PropertyFileReader;
import org.apache.bcel.generic.PUSH;

public class ReviewConstants {
    public static  final String USER_TO_UPDATE_PASSWORD = "eminem";
    public static  final String USER_TO_UPDATE_USERNAME = "mona@yahoo.com";

    public static final String MAGENTO_URL = PropertyFileReader.getEnvConstantsItem("MAGENTO_URL");
    public static final String MAGENTO_USER_NAME = PropertyFileReader.getEnvConstantsItem("MAGENTO_USER_NAME");
    public static final String MAGENTO_PASSWORD = PropertyFileReader.getEnvConstantsItem("MAGENTO_PASSWORD");
}

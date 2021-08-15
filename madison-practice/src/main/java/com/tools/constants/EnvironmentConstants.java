package com.tools.constants;

import com.tools.persistence.PropertyFileReader;

public class EnvironmentConstants {
    public static final String BASE_URL = PropertyFileReader.getEnvConstantsItem("BASE_URL");
    public static final String EMAIL = PropertyFileReader.getEnvConstantsItem("EMAIL");
    public static final String PASS = PropertyFileReader.getEnvConstantsItem("PASS");
}

package com.tools.persistence;

import java.io.*;
import java.util.Properties;

public class PropertyFileReader {
    public static String getEnvConstantsItem(String key) {
        String Path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + System.getProperty("env") + File.separator;
        Properties prop = new Properties();
        InputStream input = null;
        String propertyValue = "";
        try {
            input = new FileInputStream(Path + "environmentConstants.properties");
            prop.load(input);
            propertyValue = prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propertyValue;

    }
//    //
//
//    public static String getValue(String key) {
//        String value = "";
//        String path = "src/main/resources/qa2-env/environmentConstants.properties";
//        Properties properties = new Properties();
//        InputStream inputStream = null;
//
//        try {
//            inputStream = new FileInputStream(path);
//            properties.load(inputStream);
//            value = properties.getProperty(key);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return value;
//    }

}

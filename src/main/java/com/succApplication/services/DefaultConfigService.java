package com.succApplication.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DefaultConfigService implements ConfigurationService {

    private final String CONFIG_FILE_NAME = "config.properties";
    private Properties prop;
    private InputStream inputStream ;

    public DefaultConfigService() {
        prop = new Properties();
        inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
        try{
            prop.load(inputStream);
        } catch (IOException e){
            throw new RuntimeException("property file '" + CONFIG_FILE_NAME + "' not found in the classpath");
        }
    }

    @Override
    public String getProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }
}
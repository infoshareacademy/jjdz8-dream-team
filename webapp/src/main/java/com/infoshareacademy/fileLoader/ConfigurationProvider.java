package com.infoshareacademy.fileLoader;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
public class ConfigurationProvider {


    private static final Logger log = Logger.getLogger(ConfigurationProvider.class.getName());

    public String getUploadImageFilesPath() {
        Properties properties = new Properties();
        InputStream stream = ConfigurationProvider.class.getResourceAsStream("/settings.properties");
        try {
            properties.load(stream);
            return properties.getProperty("Upload.Path.Images");
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage(), e);
            return null;
        }

    }


}
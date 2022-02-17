package com.seasy.ui.tests.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties implements PathToPages {

    @Override
    public String getPath(String pageName) {

        Properties properties = new Properties();
        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(PATH_TO_URL_FILE);
            properties.load(fileInputStream);

            fileInputStream.close();

            return properties.getProperty(pageName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "default";
    }
}

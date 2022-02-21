package com.seasy.ui.tests.utils.files;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties implements PathToPages {
	
	private static final Logger LOGGER = Logger.getLogger(ReadProperties.class);
	
	@Override
	public String getPropertiesValue(String property, String path) {
		
		Properties properties = new Properties();
		FileInputStream fileInputStream;
		
		try {
			fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
			
			fileInputStream.close();
			
			LOGGER.info("test log");
			
			return properties.getProperty(property);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "default";
	}
}

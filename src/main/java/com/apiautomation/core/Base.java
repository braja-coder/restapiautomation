package com.apiautomation.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base extends Declarations {
	static String path = "/src/test/resources/TestData/config.properties";
	 public static final String getProperties(String propName) {
		 	Properties prop = new Properties();
		 	FileInputStream fileInputStream = null;
	        String propvalue = null;    
		 try {
		       	fileInputStream = new FileInputStream(System.getProperty("user.dir") + path);
	            prop.load(fileInputStream);
	            url= prop.getProperty("URL");
	    		serviceUrl = prop.getProperty(propName);
	    		propvalue = url+serviceUrl;
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (fileInputStream != null) {
	                try {
	                	fileInputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        return propvalue;
	    }

	
}

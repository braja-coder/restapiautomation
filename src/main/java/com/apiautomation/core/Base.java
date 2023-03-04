package com.apiautomation.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base extends Declarations {
	

	public static final String getProperties() {
		String path = "/src/test/resources/TestData/config.properties";
		try {
		fileInputStream = new FileInputStream(System.getProperty("user.dir") + path);
		prop = new Properties();
		prop.load(fileInputStream);
		url= prop.getProperty("URL");
		serviceUrl = prop.getProperty("serviceURL");
		uri = url+serviceUrl;
		}
		catch (IOException e) {
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
		System.out.println("URI : " + uri);
		return uri;
	}
	
}

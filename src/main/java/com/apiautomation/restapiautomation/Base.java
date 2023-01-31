package com.apiautomation.restapiautomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
	public Properties prop;
	public int responseStatuscode_200 = 200;
	public int responseStatuscode_201 = 201;
	public int responseStatuscode_400 = 400;
	public int responseStatuscode_401 = 401;
	public int responseStatuscode_403 = 403;
	public int responseStatuscode_500 = 500;
	
	
	public Base() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/apiautomation/config/config.properties");
		prop = new Properties();
		prop.load(fis);
	}
	
}

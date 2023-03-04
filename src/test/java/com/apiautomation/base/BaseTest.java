package com.apiautomation.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;

import com.apiautomation.client.RestClient;
import com.apiautomation.core.Base;
import com.apiautomation.core.PropertiesValue;

public class BaseTest extends Base{

	
	@BeforeMethod
	public void executeGet(Method testMethod) throws IOException {
		if(testMethod.getName().contains("_WithHeaders")){
			restClient = new RestClient();
			Map<String, String> headersMap = new HashMap<String, String>();
			headersMap.put("Content-Type", "application/json");
			responseGetRequest = restClient.get(PropertiesValue.URL, headersMap);
		}else {
			restClient = new RestClient();
			responseGetRequest = restClient.get(PropertiesValue.URL);
		}
		
	}
}

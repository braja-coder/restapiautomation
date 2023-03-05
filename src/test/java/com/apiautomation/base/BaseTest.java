package com.apiautomation.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;

import com.apiautomation.bean.JsonBodyBean;
import com.apiautomation.client.RestClient;
import com.apiautomation.core.Base;
import com.apiautomation.core.PropertiesValue;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest extends Base{

	
	@BeforeMethod
	public void execute(Method testMethod) throws IOException {
		if(testMethod.getName().contains("_GetApiWithHeaders")){
			restClient = new RestClient();
			Map<String, String> headersMap = new HashMap<String, String>();
			headersMap.put("Content-Type", "application/json");
			responseGetRequest = restClient.get(PropertiesValue.URL, headersMap);
			
		}else if(testMethod.getName().contains("_SimpleJsonPost")) {
			restClient = new RestClient();
			Map<String, String> headersMap = new HashMap<String, String>();
			headersMap.put("Content-Type", "application/json");
			try {
				responsePostRequest = restClient.post(PropertiesValue.URL, headersMap);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}else if(testMethod.getName().contains("_SimpleJsonPut")){
			restClient = new RestClient();
			Map<String, String> headersMap = new HashMap<String, String>();
			headersMap.put("Content-Type", "application/json");
			try {
				
				responsePutRequest = restClient.put(PropertiesValue.URL_PUT, headersMap);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}else if(testMethod.getName().contains("_PostApiWithHeaders")) {
			restClient = new RestClient();
			Map<String, String> headersMap = new HashMap<String, String>();
			headersMap.put("Content-Type", "application/json");
			ObjectMapper mapper = new ObjectMapper();
			JsonBodyBean bean = new JsonBodyBean("braja","Software engineer");
			String jsonBody = mapper.writeValueAsString(bean);
			responsePostRequest = restClient.post(PropertiesValue.URL, headersMap, jsonBody);
			mapper.writeValue(new File("D:\\SeleniumJava_Automation\\restapiautomation\\src\\\\test\\resources\\TestOutput\\postrequest.json"), bean);
		}
		else {
			restClient = new RestClient();
			responseGetRequest = restClient.get(PropertiesValue.URL);
		}
		
	}
}

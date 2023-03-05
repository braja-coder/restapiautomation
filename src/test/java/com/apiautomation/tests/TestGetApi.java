package com.apiautomation.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.apiautomation.base.BaseTest;
import com.apiautomation.client.RestClient;
import com.apiautomation.core.Base;
import com.apiautomation.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.beans.binding.StringExpression;


public class TestGetApi extends BaseTest {
	
	
	@Test
	public void getAllHearders() {
		// get all headers
		Header headerArr[] = responseGetRequest.getAllHeaders();
		HashMap<String, String> map = new HashMap();
		for (Header header : headerArr) {
			map.put(header.getName(), header.getValue());
		}
		System.out.println(map);
	}

	@Test
	public void test_GetApi() throws ClientProtocolException, IOException {
		// get tresponseGetRequesthe Status code
		int statusCode = responseGetRequest.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, responseStatuscode_200, "status code not 200");

		// get the response as Json String
		String responseAsString = EntityUtils.toString(responseGetRequest.getEntity(), "UTF-8");

		// convert the jsonstring to jsonObject
		JSONObject responseInJson = new JSONObject(responseAsString);
		String perPageValue = Util.getValueFromJsonOutput(responseInJson, "/per_page");
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);

		String totalValue = Util.getValueFromJsonOutput(responseInJson, "/total");
		Assert.assertEquals(Integer.parseInt(totalValue), 12);

		// get the values from JSONArray
		String id = Util.getValueFromJsonOutput(responseInJson, "/data[0]/id");
		System.out.println("**********************" + id);
		Assert.assertEquals(Integer.parseInt(id), 1);

	}

	@Test
	public void test_GetApiWithHeaders() throws ClientProtocolException, IOException {
		try {
			// get tresponseGetRequesthe Status code
			int statusCode = responseGetRequest.getStatusLine().getStatusCode();
			Assert.assertEquals(statusCode, responseStatuscode_200, "status code not 200");
			
			// get the response as String
			String responseAsString = EntityUtils.toString(responseGetRequest.getEntity(), "UTF-8");
			JSONObject responseInJson = new JSONObject(responseAsString);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+responseInJson);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+responseInJson.toString());
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("D:\\SeleniumJava_Automation\\restapiautomation\\src\\test\\resources\\TestOutput\\resposeGet.json"), responseInJson);
			mapper.writeValueAsString(responseInJson);
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader("D:\\SeleniumJava_Automation\\restapiautomation\\src\\test\\resources\\TestOutput\\resposeGet.json"));

			
		//	JSONObject jsonObject = (JSONObject) object;
					
			String fullContent = Util.getValueFromJsonOutput(responseInJson, "/");
			Assert.assertEquals(fullContent, responseInJson.toString());
	
			
			String fullInfo = Util.getValueFromJsonOutput(responseInJson, "/data");
			JSONArray jsonArray = (JSONArray) responseInJson.get("data");
			Assert.assertEquals(fullInfo, jsonArray.toString());

			// convert the jsonstring to jsonObject
			
			String perPageValue = Util.getValueFromJsonOutput(responseInJson, "/per_page");
			Assert.assertEquals(Integer.parseInt(perPageValue), 6);

			String totalValue = Util.getValueFromJsonOutput(responseInJson, "/total");
			Assert.assertEquals(Integer.parseInt(totalValue), 12);

			// get the values from JSONArray
			String id = Util.getValueFromJsonOutput(responseInJson, "/data[0]/id");
			Assert.assertEquals(Integer.parseInt(id), 1);

			String fullInfoFirstIndex = Util.getValueFromJsonOutput(responseInJson, "/data[0]");
		

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

package com.apiautomation.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apiautomation.client.RestClient;
import com.apiautomation.restapiautomation.Base;
import com.apiautomation.util.Util;

public class TestGetApi extends Base {
	RestClient restClient;
	String uri;
	CloseableHttpResponse responseGetRequest;

	public TestGetApi() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		String url = prop.getProperty("URL");
		String serviceUrl = prop.getProperty("serviceURL");
		uri = url + serviceUrl;

	}

	@Test
	public void testGetApiWithOutHeaders() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		responseGetRequest = restClient.get(uri);
		
		// get tresponseGetRequesthe Status code
		int statusCode = responseGetRequest.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, responseStatuscode_200, "status code not 200");
		
		// get the response as Json String
		String responseAsString = EntityUtils.toString(responseGetRequest.getEntity(), "UTF-8");
		// convert the jsonstring to jsonObject
		JSONObject responseInJson = new JSONObject(responseAsString);
		String perPageValue  = Util.getValueFromJsonOutput(responseInJson,"/per_page");
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		String totalValue  = Util.getValueFromJsonOutput(responseInJson,"/total");
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		// get the values from JSONArray
		String id  = Util.getValueFromJsonOutput(responseInJson,"/data[0]/id");
		System.out.println("**********************" + id);
		Assert.assertEquals(Integer.parseInt(id), 1);
		
		// get all headers
		Header headerArr[] = responseGetRequest.getAllHeaders();
		HashMap<String, String> map = new HashMap();
		for (Header header : headerArr) {
			map.put(header.getName(), header.getValue());
		}
		System.out.println(map);
	}
	
	@Test
	public void testGetApiWithHeaders() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		Map<String,String> headersMap = new HashMap<String,String>();
		headersMap.put("Content-Type","application/json");
		responseGetRequest = restClient.get(uri,headersMap);
		
		// get tresponseGetRequesthe Status code
		int statusCode = responseGetRequest.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, responseStatuscode_200, "status code not 200");
		
		// get the response as Json String
		String responseAsString = EntityUtils.toString(responseGetRequest.getEntity(), "UTF-8");
		// convert the jsonstring to jsonObject
		JSONObject responseInJson = new JSONObject(responseAsString);
		String perPageValue  = Util.getValueFromJsonOutput(responseInJson,"/per_page");
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		String totalValue  = Util.getValueFromJsonOutput(responseInJson,"/total");
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		// get the values from JSONArray
		String id  = Util.getValueFromJsonOutput(responseInJson,"/data[0]/id");
		System.out.println("**********************" + id);
		Assert.assertEquals(Integer.parseInt(id), 1);
		
		String fullInfoFirstIndex  = Util.getValueFromJsonOutput(responseInJson,"/data[0]");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+fullInfoFirstIndex);
		
		String fullInfo  = Util.getValueFromJsonOutput(responseInJson,"/data");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+fullInfo);
		
		// get all headers
		Header headerArr[] = responseGetRequest.getAllHeaders();
		HashMap<String, String> map = new HashMap();
		for (Header header : headerArr) {
			map.put(header.getName(), header.getValue());
		}
		System.out.println(map);
	}
}

package com.apiautomation.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiautomation.base.BaseTest;
import com.apiautomation.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestPostApi extends BaseTest{
	
	@Test
	public void test_PostApiWithHeaders() throws ClientProtocolException, IOException {
		try {
			// get tresponseGetRequesthe Status code
			int statusCode = responsePostRequest.getStatusLine().getStatusCode();
			Assert.assertEquals(statusCode, responseStatuscode_201, "status code not 201");
			
			String responseString = EntityUtils.toString(responsePostRequest.getEntity(),"UTF-8");
			JSONObject responseJson = new JSONObject(responseString);
			System.out.println(responseJson);
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

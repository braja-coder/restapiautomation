package com.apiautomation.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiautomation.base.BaseTest;

public class TestPostApiWithSimpleJson extends BaseTest{
	
	@Test
	public void testPostApiWithHeaders_SimpleJson() throws ClientProtocolException, IOException {
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

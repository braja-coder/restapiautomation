package com.apiautomation.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiautomation.base.BaseTest;

public class TestPutApiWithSimpleJson extends BaseTest{
	
	@Test
	public void testApiWithHeaders_SimpleJsonPut() throws ClientProtocolException, IOException {
		try {
			// get tresponseGetRequesthe Status code
			int statusCode = responsePutRequest.getStatusLine().getStatusCode();
			Assert.assertEquals(statusCode, responseStatuscode_200, "status code not 200");
			
			String responseString = EntityUtils.toString(responsePutRequest.getEntity(),"UTF-8");
			JSONObject responseJson = new JSONObject(responseString);
			System.out.println(responseJson);
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

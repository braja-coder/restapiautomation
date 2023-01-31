package com.apiautomation.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//GET Method without headers
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpGet httpGet =  new HttpGet(url); //http GET call
		 CloseableHttpResponse responseGetRequest = httpClient.execute(httpGet);//hit the GET URL
		 return responseGetRequest;
	}
	
	//GET Method with headers
	public CloseableHttpResponse get(String url, Map<String,String> headers) throws ClientProtocolException, IOException {
		
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpGet httpGet =  new HttpGet(url); //http GET call
		 for(Map.Entry<String, String> entry : headers.entrySet()) {
			 httpGet.addHeader(entry.getKey(),entry.getValue());
		 }
		 CloseableHttpResponse responseGetRequest = httpClient.execute(httpGet);//hit the GET URL
		 return responseGetRequest;
	}

}

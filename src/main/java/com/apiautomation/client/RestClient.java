package com.apiautomation.client;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	
	//Post method with hearders
	public CloseableHttpResponse post(String url, Map<String,String> headers, String jsonbBody) throws ClientProtocolException, IOException {
		
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpPost httpPost =  new HttpPost(url); //http GET call
		 StringEntity payload =  new StringEntity(jsonbBody);
		 httpPost.setEntity(payload);	
		 Set<Entry<String, String>> set = headers.entrySet();
		 for(Entry<String, String> entry : set) {
			 httpPost.addHeader(entry.getKey(),entry.getValue());
		 }
		 CloseableHttpResponse responsePostRequest = httpClient.execute(httpPost);//hit the GET URL
		 return responsePostRequest;
	}
	
	//Post with Simple Json
		public CloseableHttpResponse post(String url, Map<String,String> headers) throws ClientProtocolException, IOException, ParseException {
			
			 CloseableHttpClient httpClient = HttpClients.createDefault();
			 HttpPost httpPost =  new HttpPost(url);
			 JSONParser parser = new JSONParser();
			 Object object = parser.parse(new FileReader("D:\\SeleniumJava_Automation\\restapiautomation\\src\\test\\resources\\TestOutput\\postrequest_simple.json"));
			 JSONObject jsonObject = (JSONObject) object;
			 JSONObject data = (JSONObject) jsonObject.get("data");
			 String jsonString = data.toString();
			 StringEntity payload =  new StringEntity(jsonString);
			 httpPost.setEntity(payload);	
			 Set<Entry<String, String>> set = headers.entrySet();
			 for(Entry<String, String> entry : set) {
				 httpPost.addHeader(entry.getKey(),entry.getValue());
			 }
			 CloseableHttpResponse responsePostRequest = httpClient.execute(httpPost);//hit the GET URL
			 return responsePostRequest;
		}

}

package com.apiautomation.core;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.http.client.methods.CloseableHttpResponse;

import com.apiautomation.client.RestClient;

public class Declarations {
	public static String uri;
	public static String url;
	public static String serviceUrl;
	public CloseableHttpResponse responseGetRequest;
	public CloseableHttpResponse responsePostRequest;
	public CloseableHttpResponse responsePutRequest;
	//user defiend classes
	public RestClient restClient;
	
	
	
	public int responseStatuscode_200 = 200;
	public int responseStatuscode_201 = 201;
	public int responseStatuscode_400 = 400;
	public int responseStatuscode_401 = 401;
	public int responseStatuscode_403 = 403;
	public int responseStatuscode_500 = 500;

}

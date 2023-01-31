package com.apiautomation.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class Util {
	
	public static String getValueFromJsonOutput(JSONObject jsonObject, String jsonPath) {
		Object obj = jsonObject;
		for(String s: jsonPath.split("/")) {
			if(!s.isEmpty()) {
				if(!(s.contains("[") || s.contains("]"))){
					obj = ((JSONObject) obj).get(s);
				}else if(s.contains("[") || s.contains("]")) {
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
				}
			}
		}
		return obj.toString();
	}

	
}

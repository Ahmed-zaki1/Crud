package com.voice;

import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
@SuppressWarnings("unchecked")
public class JsonRead {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("/C:/Users/agamy/Desktop/Doc/Read.json"));
 
			JSONObject jsonObject = (JSONObject) obj;
 
			JSONArray companyList = (JSONArray) jsonObject.get("Details");
 
		
			Iterator<JSONObject> iterator = companyList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
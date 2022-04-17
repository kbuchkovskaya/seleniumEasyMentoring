package com.seasy.ui.pages.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JsonParser {
	
	public List<String> getListNamesFromJson(String path) {
		
		Storage storage = new Storage();
		
		try {
			Object ob = new JSONParser().parse(new FileReader(path));
			JSONArray jsonArray = (JSONArray) ob;
			for (Object o : jsonArray) {
				JSONObject js = (JSONObject) o;
				storage.addItemInDataList((String)js.get("name"));
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		return storage.getList();
	}
	
}

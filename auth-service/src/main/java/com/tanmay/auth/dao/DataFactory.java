package com.tanmay.auth.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.tanmay.auth.entity.ResponseDTO;

public class DataFactory {

	public static final List<ResponseDTO> getData() throws FileNotFoundException, IOException, ParseException {
		String fileName = "datastore.json";
		ClassLoader classLoader = new DataFactory().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(file));
		JSONArray array = (JSONArray) obj;
		List<ResponseDTO> response = new ArrayList<ResponseDTO>();
		for (int i = 0; i < array.size(); i++) {
			ResponseDTO res = new ResponseDTO();
			JSONObject jsonObj = (JSONObject) array.get(i);
			res.setName(jsonObj.get("name").toString());
			res.setPrice(jsonObj.get("price").toString());
			res.setSummary(jsonObj.get("summary").toString());
			response.add(res);
		}

		return response;
		// for(int i=0;i<response.size();i++){
		// System.out.println(response.get(i).getName());
		// }

	}
	
	public static final String getData1() throws FileNotFoundException, IOException, ParseException{
		String fileName = "datastore.json";
		ClassLoader classLoader = new DataFactory().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(file));
		JSONArray array = (JSONArray) obj;
		return array.toString();
	}

}

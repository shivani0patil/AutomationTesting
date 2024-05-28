package com.crm.generic.Fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String gateDataJason(String key) throws FileNotFoundException, ParseException
	{
	 FileInputStream fss=new FileInputStream(".src/test/resources/jscomman.json");
	 JSONParser par=new JSONParser();
	 Object ob=par.parse("fss");
	 JSONObject j=(JSONObject)ob;
	 String data=j.get(key).toString();
	return data;

  }
	}

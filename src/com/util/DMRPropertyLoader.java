package com.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class DMRPropertyLoader {
	HashMap<String, String> propertyMap;
	static DMRPropertyLoader instance ; 
	
	private DMRPropertyLoader()
	{
		propertyMap = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream input = null;
		
		try{
			input = DMRPropertyLoader.class.getClassLoader().getResourceAsStream("config.properties");

			// load a properties file
			prop.load(input);
			
			propertyMap.put("mobilewareURL", prop.getProperty("mobilewareURL"));
			propertyMap.put("ekoURL", prop.getProperty("ekoURL"));
			propertyMap.put("ekodeveloperkey", prop.getProperty("ekodeveloperkey"));
			propertyMap.put("mobilewaredeveloperkey", prop.getProperty("mobilewaredeveloperkey"));
			propertyMap.put("channel1", prop.getProperty("channel1"));
			propertyMap.put("channel2", prop.getProperty("channel2"));
			propertyMap.put("apiIdExist_msg", prop.getProperty("apiIdExist_msg"));
			propertyMap.put("apiIdExist_code", prop.getProperty("apiIdExist_code"));
			propertyMap.put("apiCredential_msg", prop.getProperty("apiCredential_msg"));
			propertyMap.put("apiCredential_code", prop.getProperty("apiCredential_code"));
			propertyMap.put("json_valid_msg", prop.getProperty("json_valid_msg"));
			propertyMap.put("json_valid_code", prop.getProperty("json_valid_code"));
			propertyMap.put("apidown_code", prop.getProperty("apidown_code"));
			propertyMap.put("apidown_msg", prop.getProperty("apidown_msg"));
			propertyMap.put("apiId_inactive", prop.getProperty("apiId_inactive"));
			propertyMap.put("apiIdinactive_code", prop.getProperty("apiIdinactive_code"));
			propertyMap.put("apiId_operator", prop.getProperty("apiId_operator"));
			propertyMap.put("apiIdoperator_code", prop.getProperty("apiIdoperator_code"));
		}catch(Exception e){
			
		}
	}
	
	public static DMRPropertyLoader getInstance()
	{
		if(instance != null)
		{
			return instance;
		}
		else
		{
			return instance = new DMRPropertyLoader();
		}
	}

	public HashMap<String, String> getPropertyMap() {
		return propertyMap;
	}
}

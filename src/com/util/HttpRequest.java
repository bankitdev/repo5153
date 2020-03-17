package com.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class HttpRequest {

	public static String getResponseFromHttps(String urlLocation, String postMessage,String requestContentType, String requestMethod,Map<String, String> requestHeaders) throws NoSuchAlgorithmException, KeyManagementException, MalformedURLException, IOException
	{
		String results="";
		try
		{
			System.out.println("urlLocation------in EGEN Controller------------"+urlLocation);
			
			results = doHttpsUrlConnectionAction(urlLocation,postMessage,requestContentType,requestMethod,requestHeaders,null);
			if(results.contains("&"))
			{
				String rs=results.replaceAll("&", "and");
				results=rs;
			}
			System.out.println(results);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return results;		
	}
	
	private static String doHttpsUrlConnectionAction(String desiredUrl, String postMessage,String requestContentType, String requestMethod,Map<String, String> requestHeaders,String body)throws Exception
	{
	    URL url = null;
	    BufferedReader reader = null;
	    StringBuilder stringBuilder;
	    try
	    {
	    	System.setProperty("jsse.enableSNIExtension", "false");
	    	System.out.println("1111111111111111111111111111111111111111111111111111");
	    	url = new URL(desiredUrl);
	    	HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
	    	connection.setRequestMethod(requestMethod);	
	    	connection.setRequestProperty("Content-Type", requestContentType);
	    	
	    	if(requestMethod.equalsIgnoreCase("POST")){
	    		connection.setDoOutput(true);
	    		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
	    		wr.writeBytes(body);
	    		wr.flush();
	    		wr.close();
	    	}
	     			
	    	reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    	stringBuilder = new StringBuilder();
	    	String line = null;
	    	while ((line = reader.readLine()) != null)
	    	{
	    		stringBuilder.append(line + "\n");
	    	}
	    	return stringBuilder.toString();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw e;
	    }
	    finally
	    {
	    	if (reader != null)
	    	{
	    		try
	    		{
	    			reader.close();
	    		}
	    		catch (IOException ioe)
	    		{
	    			ioe.printStackTrace();
	    		}
	    	}
	    }
	}
}

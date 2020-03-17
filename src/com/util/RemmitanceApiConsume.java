package com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;

public class RemmitanceApiConsume {
	private static Logger log = Logger.getLogger(RemmitanceApiConsume.class);

	public static final String apiCall(String url, String json, String channelheader) throws Exception {
		log.info("executing apiCall method of RemmitanceApiConsume class");
		String output = null;
		try {
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelheader)) {
				output=consumeAPMaheshApi(url, json);
			} else {
				output=consumeEkoApiGet(url);
			}
		} catch (Exception ex) {
			log.error("Error in  apiCall method of RemmitanceApiConsume class" + UtilityP.printException(ex));
		}
		return output;
	}

	public static String finoapiCall1(String url,JSONObject json) throws Exception {
		String output=null;  
		try{
			log.info("executing finoapiCall method of RemmitanceApiConsume class");
			BASE64Encoder encoder = new BASE64Encoder();
			String userNameAndPassword = json.getString(AadhaarshilaProperties.AgentAuthId)+":"+json.getString(AadhaarshilaProperties.AgentAuthPassword);
			log.info("userNameAndPassword String is :"+userNameAndPassword);
			Client client = Client.create();
			client.setConnectTimeout(150000);
			client.setReadTimeout(150000);
			WebResource webResource = client .resource(url);
			String authString = encoder.encode(userNameAndPassword.getBytes());
			log.info("Auth String is :"+authString);
			ClientResponse response1 = webResource.type("application/json")
					.header("Authorization", "Basic " +authString).post(ClientResponse.class,json.toString());
			       
			output = response1.getEntity(String.class);
			log.info("RemmitanceApiConsume response1.getStatus():"+response1.getStatus()+": api response:"+output);

		}catch(Exception ex){
			log.info("RemmitanceApiConsume Exception occurrs..."+ex.getMessage());
			log.error("Error in  consumeAPMaheshApi method of RemmitanceApiConsume class" + UtilityP.printException(ex));
			output="{\"errorCode\":\"01\",\"errorMsg\":\"Pending\",\"reason\":\""+ex.getMessage()+"\"}";
			ex.printStackTrace();
			ex.getMessage();
		}
		return output;
	}
	
	public static String finoapiCall(String url,JSONObject json) throws Exception {
		log.info("executing finoapiCall method of RemmitanceApiConsume class");
		String output=null;  
		try{
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
			BASE64Encoder encoder = new BASE64Encoder();
			String userNameAndPassword =json.getString(AadhaarshilaProperties.AgentAuthId)+":"+json.getString(AadhaarshilaProperties.AgentAuthPassword);
			log.info("userNameAndPassword"+userNameAndPassword);
			Client client = Client.create();
			client.setConnectTimeout(150000);
			client.setReadTimeout(150000);
			WebResource webResource = client .resource(url);
			String authString = encoder.encode(userNameAndPassword.getBytes());
			log.info("Auth String is :"+authString);
			ClientResponse response1 = webResource.type("application/json")
					.header("Authorization", "Basic " +authString).post(ClientResponse.class,json.toString());
			       
			output = response1.getEntity(String.class);

		}catch(Exception ex){
			ex.printStackTrace();
			ex.getMessage();
		}
		return output;
	}
	public static final String consumeEkoApiGet(String httpsURL) {
		log.info("executing consumeEkoApiGet method of RemmitanceApiConsume class");
		String inputLine = "";
		StringBuilder stringBuilder = null;
		URL myurl;
		try {
			myurl = new URL(httpsURL);

			HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
			con.setRequestProperty("developer_key",
					DMRPropertyLoader.getInstance().getPropertyMap().get("ekodeveloperkey"));

			InputStream ins = con.getInputStream();
			InputStreamReader isr = new InputStreamReader(ins);
			BufferedReader in = new BufferedReader(isr);
			stringBuilder = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				stringBuilder.append(inputLine);

			}
			log.info(inputLine);
			in.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error in consumeEkoApiGet method of RemmitanceApiConsume class" + UtilityP.printException(e));
		}

		return stringBuilder.toString();
	}

	public final static String consumeAPMaheshApi(String url, String json) {
		log.info("executing consumeAPMaheshApi method of RemmitanceApiConsume class");
		String output = null;
		try {
			log.info("developer key::" + DMRPropertyLoader.getInstance().getPropertyMap().get("mobilewaredeveloperkey"));
			log.info("json is::::" + json);
			Client client = Client.create();
			client.setConnectTimeout(220000);
			client.setReadTimeout(220000);
			WebResource webResource = client.resource(url);
			ClientResponse response1 = webResource.type("application/json")
					.header("Authorization",
							DMRPropertyLoader.getInstance().getPropertyMap().get("mobilewaredeveloperkey"))
					.post(ClientResponse.class, json);
			log.info("response1.getResponseStatus():::"+response1.getResponseStatus());
			output = response1.getEntity(String.class);
			log.info("output::" + output);
		} catch (Exception ex) {
			log.error("Error in  consumeAPMaheshApi method of RemmitanceApiConsume class" + UtilityP.printException(ex));
			output="{\"errorCode\":\"01\",\"errorMsg\":\"Pending\",\"reason\":\""+ex.getMessage()+"\"}";
		}
		return output;
	}

}

package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import sun.misc.BASE64Encoder;

public class UtilityP {
	private static Logger log = Logger.getLogger(UtilityP.class);
	private final static String USER_AGENT = "Mozilla/5.0";

	public static String timeDiffrence(String time1,String time2)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String diff="";
		try {
			Date dt=sdf.parse(time1.substring(0,time1.length()-1));
			Date dt1=sdf1.parse(time2.substring(0,time2.length()-1));
			int diffrence=Integer.parseInt(String.valueOf(dt1.getTime()-dt.getTime()));
			int hrs=diffrence/3600000;
			int minutes = (diffrence - hrs * 3600000) / 60000;
			DecimalFormat twoDigits = new DecimalFormat("00");
			diff = twoDigits.format(hrs) + "Hr " + twoDigits.format(minutes)+"min";

		} catch (ParseException e) {

			e.printStackTrace();
		}
		return diff;
	}

	
	public static String hashKey(String s) {
		String hashkey = "";
		try {
			MessageDigest m=MessageDigest.getInstance("MD5");
			m.update(s.getBytes(),0,s.length());
			hashkey= new BigInteger(1,m.digest()).toString(16);
			while(hashkey.length()<32){
				hashkey="0"+hashkey;
			}
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashkey;
	}
	
	
	public static String printException (Exception e){
		StringBuilder sb=new StringBuilder();
		for(StackTraceElement element : e.getStackTrace()){
			sb.append(element.toString());
			sb.append("\n");
		}
		return sb.toString();

	}
	public static String changeTime(String val)
	{
		if(val.length()==3)
		{
			val="0"+val;
		}

		if(val.length()==2)
		{
			val="00"+val;
		}
		if(val.length()==1)
		{
			val="000"+val;
		}
		if(val.length()==0)
		{
			val="0000"+val;
		}
		String h = val.substring(0,2);
		String m = val.substring(2,4);

		return val=h+":"+m;	
	}

	public static String changeDate(String val)
	{

		StringTokenizer aa=new StringTokenizer(val,"-");

		String day="";
		String month="";
		String year="";
		while(aa.hasMoreTokens())
		{

			day=aa.nextToken();
			month=aa.nextToken();
			year=aa.nextToken();

		}
		String newdate=year+"-"+month+"-"+day;
		System.out.println("abhishek printing date"+newdate);
		return newdate;	
	}

	public static String changeDate(String val,String fromToken,String toToken)
	{

		StringTokenizer aa=new StringTokenizer(val,fromToken);

		String day="";
		String month="";
		String year="";
		while(aa.hasMoreTokens())
		{			
			day=aa.nextToken();
			month=aa.nextToken();
			year=aa.nextToken();			
		}
		String newdate=year+toToken+month+toToken+day;
		System.out.println("newdate : "+newdate);
		return newdate;	
	}

	public static String changeTimeFormat(String val)
	{
		StringTokenizer aa=new StringTokenizer(val,":");

		String hrs="";
		String min="";
		while(aa.hasMoreTokens())
		{
			hrs=aa.nextToken();
			min=aa.nextToken();
		}
		String newdate=hrs+min;
		return newdate;	
	}
	public static String changeDateDDMMYY(String val)
	{

		StringTokenizer aa=new StringTokenizer(val,"-");

		String day="";
		String month="";
		String year="";
		while(aa.hasMoreTokens())
		{

			day=aa.nextToken();
			month=aa.nextToken();
			year=aa.nextToken();

		}
		String newdate=day+"/"+month+"/"+year;
		return newdate;	
	}
	public static String changeDateModify(String val)
	{

		String y = val.substring(0,4);

		String M = val.substring(4,6);

		String mon="";
		switch(Integer.parseInt(M))
		{
		case 01: mon="Jan";break;
		case 02: mon="Feb";break;
		case 03: mon="Mar";break;
		case 04: mon="Apr";break;
		case 05: mon="May";break;
		case 06: mon="Jun";break;
		case 07: mon="Jul";break;
		case 8: mon="Aug";break;
		case 9: mon="Sep";break;
		case 10: mon="Oct";break;
		case 11: mon="Nov";break;
		case 12: mon="Dec";break;
		}
		String d = val.substring(6,8);
		System.out.println("d is"+d);
		return val=d+"-"+mon+"-"+y;
	}
	public static String changeDateModify1(String val)
	{

		String y = val.substring(0,4);

		String M = val.substring(5,7);

		String mon="";
		switch(Integer.parseInt(M))
		{
		case 01: mon="Jan";break;
		case 02: mon="Feb";break;
		case 03: mon="Mar";break;
		case 04: mon="Apr";break;
		case 05: mon="May";break;
		case 06: mon="Jun";break;
		case 07: mon="Jul";break;
		case 8: mon="Aug";break;
		case 9: mon="Sep";break;
		case 10: mon="Oct";break;
		case 11: mon="Nov";break;
		case 12: mon="Dec";break;
		}
		String d = val.substring(8,10);

		return val=d+"-"+mon+"-"+y;
	}

	public static String changeMonthDate(String val)
	{

		String y = val.substring((val.length()-4),val.length());
		String M = val.substring(3,(val.length()-5));
		M=M.trim();
		String mon="";
		if(M.equals("Jan")) mon="01";
		if(M.equals("Feb")) mon="02";
		if(M.equals("Mar")) mon="03";
		if(M.equals("Apr")) mon="04";
		if(M.equals("May")) mon="05";
		if(M.equals("Jun")) mon="06";
		if(M.equals("Jul")) mon="07";
		if(M.equals("Aug")) mon="08";
		if(M.equals("Sep")) mon="09";
		if(M.equals("Oct")) mon="10";
		if(M.equals("Nov")) mon="11";
		if(M.equals("Dec")) mon="12";

		String d = val.substring(0,2);

		return val=y+mon+d;
	}


	public static String changeMonthDateINDIA(String val)
	{

		String y = val.substring((val.length()-4),val.length());
		String M = val.substring(3,(val.length()-5));
		M=M.trim();
		String mon="";
		if(M.equals("Jan")) mon="01";
		if(M.equals("Feb")) mon="02";
		if(M.equals("Mar")) mon="03";
		if(M.equals("Apr")) mon="04";
		if(M.equals("May")) mon="05";
		if(M.equals("Jun")) mon="06";
		if(M.equals("Jul")) mon="07";
		if(M.equals("Aug")) mon="08";
		if(M.equals("Sep")) mon="09";
		if(M.equals("Oct")) mon="10";
		if(M.equals("Nov")) mon="11";
		if(M.equals("Dec")) mon="12";

		String d = val.substring(0,2);

		return val=y+"-"+mon+"-"+d;
	}


	public int  dateDiffrence(String date1,String date2,String time1,String time2)
	{	

		String  diff="";
		int year1=0; 
		int month1=0;
		//int h1=0;
		//int min1=0;
		int day1=0;
		int year2=0;
		int month2=0;
		int day2=0;
		//int h2=0;
		//int min2=0;

		year1=Integer.parseInt(date1.substring(0,4));
		month1=Integer.parseInt(date1.substring(4,6));
		day1=Integer.parseInt(date1.substring(6,8));

		if(time1.length()==3)
		{
			time1="0"+time1;
		}

		if(time1.length()==2)
		{
			time1="00"+time1;
		}

		//h1=Integer.parseInt(time1.substring(0,2));
		//min1=Integer.parseInt(time1.substring(2,4));


		year2=Integer.parseInt(date2.substring(0,4));
		month2=Integer.parseInt(date2.substring(4,6));
		day2=Integer.parseInt(date2.substring(6,8));

		if(time2.length()==3)
		{
			time2="0"+time2;
		}

		if(time2.length()==2)
		{
			time2="00"+time2;
		}

		//h2=Integer.parseInt(time2.substring(0,2));
		//min2=Integer.parseInt(time2.substring(2,4));

		Date d1 = new GregorianCalendar(year1, month1-1, day1, 00 ,00).getTime();
		Date d2 = new GregorianCalendar(year2, month2-1, day2, 00, 00).getTime();
		diff = String.valueOf(((d1.getTime()-d2.getTime())/(1000 * 60 * 60 * 24)));

		return Integer.parseInt(diff);
	}


	public String createDate(String aDate,int l,String token)
	{
		StringTokenizer aa=new StringTokenizer(aDate,token);
		int day=0;
		int month=0;
		int year=0;
		while(aa.hasMoreTokens())
		{
			day=Integer.parseInt(aa.nextToken());
			month=Integer.parseInt(aa.nextToken());			
			year=Integer.parseInt(aa.nextToken());
		}

		Date d1 = new GregorianCalendar(year, month-1, day, 00 ,00).getTime();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d1);
		calendar.add(Calendar.DATE, l);
		SimpleDateFormat format =new SimpleDateFormat("dd MM yyyy");
		String parsed = format.format(calendar.getTime()).replace(" ",token);

		return parsed;
	}	

	public String dateMon_day_year(String val)
	{
		String day="";
		String month="";
		String year="";
		month=val.substring(4,6);
		day=val.substring(6,8);
		year=val.substring(0,4);


		String newdate=month+"-"+day+"-"+year;
		return newdate;	
	}
	public String new_dateMon_day_year(String val)
	{
		String day="";
		String month="";
		String year="";

		day=val.substring(3,5);
		month=val.substring(0,2);
		year=val.substring(6,10);		

		if(month.equals("01")) month="Jan";
		if(month.equals("02")) month="Feb";
		if(month.equals("03")) month="Mar";
		if(month.equals("04")) month="Apr";
		if(month.equals("05")) month="May";
		if(month.equals("06")) month="Jun";
		if(month.equals("07")) month="Jul";
		if(month.equals("08")) month="Aug";
		if(month.equals("09")) month="Sep";
		if(month.equals("10")) month="Oct";
		if(month.equals("11")) month="Nov";
		if(month.equals("12")) month="Dec";



		String newdate=day+"-"+month+"-"+year;
		return newdate;	
	}

	public String new_date_Mon_year(String val)
	{
		String day="";
		String month="";
		String year="";

		StringTokenizer aa=new StringTokenizer(val,"/");
		while(aa.hasMoreTokens())
		{
			day=aa.nextToken();
			month=aa.nextToken();
			year=aa.nextToken();

		}

		if(day.length()==1)
			day="0"+day;
		if(month.length()==1)
			month="0"+month;

		if(month.equals("01")) month="Jan";
		if(month.equals("02")) month="Feb";
		if(month.equals("03")) month="Mar";
		if(month.equals("04")) month="Apr";
		if(month.equals("05")) month="May";
		if(month.equals("06")) month="Jun";
		if(month.equals("07")) month="Jul";
		if(month.equals("08")) month="Aug";
		if(month.equals("09")) month="Sep";
		if(month.equals("10")) month="Oct";
		if(month.equals("11")) month="Nov";
		if(month.equals("12")) month="Dec";



		String newdate=day+"-"+month+"-"+year;
		return newdate;	
	}

	public static String changeTimeFormatUpdate(String val)
	{
		String newdate = "";
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy HH:mm");

		try
		{
			Date today = df.parse(val);            
			newdate = df.format(today);

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return newdate;	
	}


	public String changeDateDeccanSaving(String val)
	{
		StringTokenizer aa=new StringTokenizer(val,"-");

		String day="";
		String month="";
		String year="";
		while(aa.hasMoreTokens())
		{
			year=aa.nextToken();
			month=aa.nextToken();
			day=aa.nextToken();

		}
		String newdate=year+month+day;
		return newdate;	
	}


	public static String deccanDateChangeSending(String val)
	{
		StringTokenizer aa=new StringTokenizer(val,"-");

		String day="";
		String month="";
		String year="";
		while(aa.hasMoreTokens())
		{
			day=aa.nextToken();
			month=aa.nextToken();
			year=aa.nextToken();

		}
		String newdate=year+"-"+month+"-"+day;
		return newdate;	
	}

	public static String changeCity(String val)
	{

		StringTokenizer aa=new StringTokenizer(val,"-");

		String day="";


		while(aa.hasMoreTokens())
		{

			day=aa.nextToken();


		}
		String newdate=day;
		//		System.out.println("abhishek printing date"+newdate);
		return newdate;	
	}


	public static String post(String urlLocation, String postMessage,
			String requestContentType, String requestMethod,
			Map<String, String> requestHeaders) throws IOException {
		String response = null;
		if (urlLocation != null) {
			BufferedReader reader = null;
			OutputStreamWriter writer = null;
			HttpURLConnection connection = null;
			//			   System.out.println("before try--------....");
			try {
				BASE64Encoder encoder = new BASE64Encoder();
				String password = "girish:girish"; 
				String authString = "Basic "+ encoder.encode(password.getBytes());
				URL url = new URL(urlLocation);
				connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(220000);
				connection.setReadTimeout(220000);
				connection.setDoOutput(true);
				connection.setRequestMethod(requestMethod);
				connection.setRequestProperty("Authorization", authString);

				if (requestContentType != null) {
					connection.setRequestProperty("Content-Type",
							requestContentType);
				}

				if (requestHeaders != null) {
					for (String key : requestHeaders.keySet()) {
						connection.setRequestProperty(key, requestHeaders
								.get(key));
					}
				}

				if (postMessage != null) 
				{
					connection.setRequestProperty("Content-Length", ""+ postMessage.length());
					System.out.println("abhishek MIshra in pnr location"+postMessage.length());
					try 
					{
						writer = new OutputStreamWriter(connection
								.getOutputStream());
					} catch (Exception use) {
						use.getMessage();
					} 

					writer.write(postMessage);
					writer.flush();
				}

				StringBuilder sb = new StringBuilder();
				String line = null;

				try 
				{
					reader = new BufferedReader(new InputStreamReader(
							connection.getInputStream()));
				} 
				catch (IOException e) 
				{
					InputStream errorIp = connection.getErrorStream();
					if (errorIp != null) {
						BufferedReader errorReader = new BufferedReader(
								new InputStreamReader(errorIp));
						while ((line = errorReader.readLine()) != null) {
							sb.append(line);
						}
					}     
					e.printStackTrace();
				}

				while ((line = reader.readLine()) != null) 
				{
					sb.append(line);
				}
				response = sb.toString();
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
					if (reader != null) {
						reader.close();
					}
					if (connection != null) {
						connection.disconnect();
					}
				} catch (Exception e) {
				}
			}
		}
		if (response != null) {
			response = new String(response.getBytes());
		}

		return response;
	}

	
	
	public static String getJSONobjectPost(String url) throws Exception {
		   Client client = Client.create();
		   WebResource webResource = client
		    .resource(url);
		   ClientResponse response1 = webResource.type("text/xml").get(ClientResponse.class);
		  
		   String output = response1.getEntity(String.class);
		  if (response1.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
		     + response1.getStatus());
		  }
		  return output;
		 }
	
	public static String sendGet(String url) throws Exception {


		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response+"";

	}


	public final static String createMultipleTransactionID(String apiId) {
		log.info("Execption in UtilityP method (createMultipleTransactionID)");
		String AgentTranID = "";
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSS");
			Date date = new Date();
			String tranID = sdf.format(date);
			int n = 4;
			Random randGen = new Random();
			int startNum = (int) Math.pow(10, n - 1);
			int range = (int) (Math.pow(10, n) - startNum);
			int randomNum = randGen.nextInt(range) + startNum;
			String ran = String.valueOf(randomNum);
			AgentTranID = apiId+tranID + ran;
			log.info("AgentTranID------------" + AgentTranID);

		} catch (Exception e) {
			log.error("Execption in UtilityP method (createMultipleTransactionID)"
					+ UtilityP.printException(e));
		}
		return AgentTranID;
	}
	  

}

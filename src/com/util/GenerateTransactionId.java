package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateTransactionId {

	public static String generateTransactionId(long apiId) {
		
		String tranid="";
		try{
			Date date=new Date();
			DateFormat df=new SimpleDateFormat("dd/MM/yy");
			String stDate=df.format(date);
			stDate=stDate.replaceAll("/","");
			int n =3;
			Random randGen = new Random();
			int startNum = (int) Math.pow(10, n-1);
			int range = (int) (Math.pow(10, n) - startNum);
			int randomNum = randGen.nextInt(range) + startNum;			
			String str = String.valueOf(randomNum);
			System.out.println("str:::::::"+str);
			tranid=stDate+apiId+str;
			System.out.println("GenerateTransactionId.generateTransactionId()"+tranid.length());
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}		
		return tranid;	
	}
	
	public static void main(String[] args) {
		System.out.println(GenerateTransactionId.generateTransactionId(10001));
	}
}

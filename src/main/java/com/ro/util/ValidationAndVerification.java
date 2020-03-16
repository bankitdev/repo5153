/**
 * 
 */
package com.ro.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sunil Kashyap
 *
 * Created Date 15-Oct-2018
 */
public class ValidationAndVerification
{
	public boolean nameValidation(String name) 
	{
		String str="^[A-Za-z_][A-Za-z0-9_]{3,35}$";
		Pattern pattern=Pattern.compile(str);
		Matcher matcher=pattern.matcher(name);
		return (matcher.find() && matcher.group().equals(name));
	}
	public boolean validNumber(String s) 
	{
		Pattern patter=Pattern.compile("(0/91)?[6-9][0-9]{9}");
		Matcher matcher=patter.matcher(s);
		return(matcher.find() && matcher.group().equals(s));
		//return s.charAt(0)=='0' && s.charAt(1)=='6' && s.length()==11 && s.matches("[0-9]+");
	}
	public boolean emailvalidation(String email) 
	{	
		String emailsyn="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		Pattern pattern=Pattern.compile(emailsyn);
		Matcher matcher=pattern.matcher(email);
		return (matcher.find() && matcher.group().equals(email));
	}
}

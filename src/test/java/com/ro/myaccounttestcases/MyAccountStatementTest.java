/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.MyAccountStatement;

/**
 * @author Sunil Kashyap
 *
 * Created Date 23-Jan-2019
 */
public class MyAccountStatementTest extends LoginPage
{	
	@Test
	public void startProcess() 
	{
		MyAccountStatement accountStatement=PageFactory.initElements(driver, MyAccountStatement.class);
		accountStatement.initializeProcess();
		accountStatement.verifySizeAndText();
	}
}

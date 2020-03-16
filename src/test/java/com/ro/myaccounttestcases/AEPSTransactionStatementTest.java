/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.AEPSTransactionStatement;

/**
 * @author Sunil Kashyap
 *
 * Created Date 08-Mar-2019
 */
public class AEPSTransactionStatementTest extends LoginPage{
	
	@Test
	public void initializeProcess() 
	{
		AEPSTransactionStatement aepsTransactionStatement=PageFactory.initElements(driver, AEPSTransactionStatement.class);
		aepsTransactionStatement.clickOnAEPSTransStatmnt();
	}

}

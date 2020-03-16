/**
 * 
 */
package com.ro.utilitytestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.utility.PayBills;

/**
 * @author Sunil Kashyap
 *
 * Created Date 11-Dec-2018
 */
public class PayBillsTest extends LoginPage
{	
	/*LoginPage loginPage;
	@BeforeMethod
	public void initialize() 
	{
		loginPage=new LoginPage();
	}*/
	@Test
	public void fillPayBillsTestDetails() 
	{
		PayBills payBills = PageFactory.initElements(driver, PayBills.class);
		payBills.initializeMethod();
		payBills.payBillRechargeTC1("AIRCEL","90000000000","1");
		/*payBills.payBillRechargeTC2();
		payBills.payBillRechargeTC3();*/
	}
	/*@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}*/
}

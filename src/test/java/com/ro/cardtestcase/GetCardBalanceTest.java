/**
 * 
 */
package com.ro.cardtestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.card.GetCardBalance;

/**
 * @author Sunil Kashyap
 *
 * Created Date 24-Dec-2018
 */
public class GetCardBalanceTest extends LoginPage{

	@Test
	public void initiliazeMethod() 
	{
		GetCardBalance getCardBalance=PageFactory.initElements(driver, GetCardBalance.class);
		getCardBalance.setUp();
		getCardBalance.getCardBalanceDetails("8800540474", "1193");
		getCardBalance.verifySizeAndText();
	} 
	/*@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}*/
}

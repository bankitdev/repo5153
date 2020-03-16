/**
 * 
 */
package com.ro.cardtestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.card.GetCardDetails;

/**
 * @author Sunil Kashyap
 *
 * Created Date 16-Oct-2018
 */
public class GetCardDetailsTest extends LoginPage
{	
	@Test
	public void enterDetail() 
	{
		GetCardDetails getCardDetails=PageFactory.initElements(driver, GetCardDetails.class);
		getCardDetails.clickOnGetCardDetailsBtn();
		getCardDetails.enterCardDetails("sunil.kumar@bankit.in", 8800540474l);
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
}

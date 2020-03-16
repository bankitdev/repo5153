/**
 * 
 */
package com.ro.cardtestcase;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.card.GetVirtualCardDetails;
/**
 * @author Sunil Kashyap
 *
 * Created Date 26-Oct-2018
 */
public class GetVirtualCardDetailsTest extends LoginPage
{	
	
	@Test
	public void enterDetails()  
	{
		GetVirtualCardDetails getVirtualCardDetails= PageFactory.initElements(driver, GetVirtualCardDetails.class);
		getVirtualCardDetails.clickOnGetVirtualCardDetails();
		getVirtualCardDetails.enterCardDetails("sunil.kumar@bankit.in", 8800540474L);
		getVirtualCardDetails.verifyTextAndSize();
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
}

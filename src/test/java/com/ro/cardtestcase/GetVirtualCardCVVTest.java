/**
 * 
 */
package com.ro.cardtestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.card.GetVirtualCardCVV;

/**
 * @author Sunil Kashyap
 *
 * Created Date 21-Dec-2018
 */
public class GetVirtualCardCVVTest extends LoginPage {
	@Test
	public void EnterDetails() 
	{
		GetVirtualCardCVV getVirtualCardCVV=PageFactory.initElements(driver, GetVirtualCardCVV.class);
		getVirtualCardCVV.clickOnGetVirtualCardCVVBtn();
		getVirtualCardCVV.enterCardDetails("sunil.kumar@bankit.in", 8800540474l);
		getVirtualCardCVV.verifyTextAndSize();
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
}

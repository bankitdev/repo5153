/**
 * 
 */
package com.ro.utilitytestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.utility.Gas;

/**
 * @author Sunil Kashyap
 *
 * Created Date 11-Dec-2018
 */
public class GasTest extends LoginPage
{
	@Test
	public void fillGasTestDetails() 
	{
		Gas gas=PageFactory.initElements(driver, Gas.class);
		gas.clickOnGasLink();
		gas.selectOnOperatorName("Indraprastha Gas Limited");
		gas.custAccountNo("1234567890");
		gas.billAmount("250");
		gas.groupNo("12345");
		gas.verifyTextService();
		gas.clickOnContinueBtn();
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
}

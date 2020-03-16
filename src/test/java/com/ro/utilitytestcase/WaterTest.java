/**
 * 
 */
package com.ro.utilitytestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.utility.Water;

/**
 * @author Sunil Kashyap
 *
 * Created Date 12-Dec-2018
 */
public class WaterTest extends LoginPage {
	
	@Test
	public void fillWaterTestDetails() 
	{
		Water water=PageFactory.initElements(driver, Water.class);
		water.clickOnWaterBtn();
		water.waterDetails("HYDERABAD METROPOLITAN WATER SUPPLY","1234567890", "abc@bankit.in", "1234567890", "234");
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
}

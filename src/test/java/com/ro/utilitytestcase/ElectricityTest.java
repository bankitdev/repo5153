/**
 * 
 */
package com.ro.utilitytestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.utility.Electricity;

/**
 * @author Sunil Kashyap
 *
 * Created Date 11-Dec-2018
 */
public class ElectricityTest extends LoginPage {

	@Test
	public void fillElectricityTestDetails() 
	{
		Electricity electricity = PageFactory.initElements(driver, Electricity.class);
		electricity.clickOnElectricityBtn();
		electricity.electricityDetails("1234567890", "235");
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
}

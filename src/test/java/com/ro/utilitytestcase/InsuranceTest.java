/**
 * 
 */
package com.ro.utilitytestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.utility.Insurance;

/**
 * @author Sunil Kashyap
 *
 * Created Date 11-Dec-2018
 */
public class InsuranceTest extends LoginPage
{
	@Test
	public void fillInsuranceTestDetails() 
	{
		Insurance insurance = PageFactory.initElements(driver, Insurance.class);
		insurance.initialize();
		/*insurance.selectIsuranceCompany();
		insurance.holderNameTxt("ABC");
		insurance.enterPolicyNumber("12345678999");
		insurance.enterDate("04/02/1993");
		insurance.amount("100");
		insurance.contactNumber("1234567890");
		insurance.emailID("abc@bankit.in");
		insurance.clickOnCountinueBtn();*/
		insurance.insuranceDetails("ABC", "12345678999", "04/02/1993", "100", "1234567890", "abc@bankit.in");
	} 
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
	
}

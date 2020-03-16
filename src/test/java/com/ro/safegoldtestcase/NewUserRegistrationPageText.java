/**
 * 
 */
package com.ro.safegoldtestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ro.safegold.LoginPage;
import com.ro.safegold.NewUserRegistrationPage;
import com.ro.safegold.SafeGoldHomePage;

/**
 * @author Sunil Kashyap
 *
 * Created Date 26-Nov-2018
 */
public class NewUserRegistrationPageText extends LoginPage
{	
	/*LoginPage loginpage;
	@BeforeMethod
	public void initiateMethod() 
	{
		loginpage=new LoginPage();
	}*/
	@Test
	public void setMethod()
	{	
		SafeGoldHomePage safeGoldHomePagePage=PageFactory.initElements(driver, SafeGoldHomePage.class);
		safeGoldHomePagePage.clickOnSafeGoldLink();
		safeGoldHomePagePage.customerMobileNumer();
		safeGoldHomePagePage.newUserRegistrationPage();
		
		NewUserRegistrationPage newUserRegistrationPage = PageFactory.initElements(driver, NewUserRegistrationPage.class);
		//newUserRegistrationPage.setData("AB", "ab@gmail.com", "201301");
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
}

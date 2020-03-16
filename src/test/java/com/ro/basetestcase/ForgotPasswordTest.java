/**
 * 
 */
package com.ro.basetestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ro.Base.ForgotPassword;
import com.ro.Base.Set_Path;

/**
 * @author Sunil Kashyap
 *
 * Created Date 25-Jan-2019
 */
public class ForgotPasswordTest  extends Set_Path
{	
	@Test
	public ForgotPasswordTest() 
	{
		super("Chrome");
		driver.switchTo().frame("Main");
		
		ForgotPassword forgotPassword=PageFactory.initElements(driver,ForgotPassword.class);
		forgotPassword.forgotPassword("7860690515");
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}

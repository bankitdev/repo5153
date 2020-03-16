/**
 * 
 */
package com.ro.basetestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ro.Base.Set_Path;
import com.ro.Base.SignUp;

/**
 * @author Sunil Kashyap
 *
 * Created Date 25-Jan-2019
 */
public class SignUpTest extends Set_Path
{	
	@Test
	public SignUpTest() 
	{
		super("Chrome");
		driver.switchTo().frame("Main");
		
		SignUp signUp=PageFactory.initElements(driver, SignUp.class);
		signUp.signUpLink();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
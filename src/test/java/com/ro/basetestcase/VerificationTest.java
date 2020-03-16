/**
 * 
 */
package com.ro.basetestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.Base.Verification;

/**
 * @author Sunil Kashyap
 *
 * Created Date 28-Jan-2019
 */
public class VerificationTest extends LoginPage
{	
	@Test
	public VerificationTest() 
	{	
		Verification verification=PageFactory.initElements(driver, Verification.class);
		verification.verifyImage();
		verification.imageSize();
		verification.verifyTexts();
		verification.verifyButton();
		verification.serviceTutorialLink();
		verification.yourPerformance();
	}
	/*@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}*/
}

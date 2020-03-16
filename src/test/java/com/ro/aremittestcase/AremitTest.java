/**
 * 
 */
package com.ro.aremittestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.aremit.Aremit;

/**
 * @author Sunil Kashyap
 *
 * Created Date 11-Mar-2019
 */
public class AremitTest extends LoginPage {
	
	@Test
	public void initializeAremit() 
	{
		Aremit armt = PageFactory.initElements(driver, Aremit.class);
		try {
			armt.aermit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}

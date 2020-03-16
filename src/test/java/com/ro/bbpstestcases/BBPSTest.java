/**
 * 
 */
package com.ro.bbpstestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.bbps.BBPS;

/**
 * @author Sunil Kashyap
 *
 * Created Date 15-Jan-2019
 */
public class BBPSTest extends LoginPage {
	
	@Test
	public void enterBBPSDetails() 
	{
		BBPS bbps = PageFactory.initElements(driver, BBPS.class);
		bbps.initialize();
		bbps.enterBBPSDetails("Electricity", "Uttar Pradesh Power Corp Ltd (UPPCL) - URBAN", "9717978800", "8341747885");
		//bbps.getText();
	}

}

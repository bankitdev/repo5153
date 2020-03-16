/**
 * 
 */
package com.ro.basetestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.Footer;
import com.ro.Base.LoginPage;

/**
 * @author Sunil Kashyap
 * @description This class is use for Footer Test
 * Created Date 28-Mar-2019
 */
public class FooterTest extends LoginPage{
	
	@Test
	public void startProcess() {
		
		Footer footer=PageFactory.initElements(driver, Footer.class);
		footer.supportText();
		footer.biometricDeviceSupportforMorpho();
		footer.biometricDeviceSupportforMantra();
		footer.openFooterLinks();
	}

}

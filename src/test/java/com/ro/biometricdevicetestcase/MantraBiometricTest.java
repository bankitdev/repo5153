/**
 * 
 */
package com.ro.biometricdevicetestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.biometricdevice.MantraBiometric;
/**
 * @author Sunil Kashyap
 *
 * Created Date 20-Dec-2018
 */
public class MantraBiometricTest extends LoginPage
{
	@Test
	public void initializeMorpho() 
	{
		MantraBiometric mantraBiometric=PageFactory.initElements(driver, MantraBiometric.class);
		mantraBiometric.morphoBiometricLink();
		mantraBiometric.enterQuantity(2);
		mantraBiometric.gstDetails();
		mantraBiometric.companyName("BankIT");
		mantraBiometric.enterPanNumber("CYWHK7853U");
		mantraBiometric.gstRegistrationNumber(123456789081234L);
		mantraBiometric.principalPlaceOfBussiness("A");
		mantraBiometric.shopName("Bank");
		mantraBiometric.emailID("abc@bankit.in");
		mantraBiometric.mobileNu("9876543210");
		mantraBiometric.add1("D-49");
		mantraBiometric.add2("Noida");
		mantraBiometric.countryName("India");
		mantraBiometric.stateName("Uttar Pradesh");
		mantraBiometric.disName("Gautam Buddha Nagar");
		mantraBiometric.submitButton();
		try {
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}catch (Exception e) {
			mantraBiometric.verifySizeAndText();
		}
		
		
	}
}

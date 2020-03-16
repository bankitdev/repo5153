/**
 * 
 */
package com.ro.biometricdevicetestcase;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.biometricdevice.MorphoBiometric;

/**
 * @author Sunil Kashyap
 *
 * Created Date 19-Dec-2018
 */
public class MorphoBiometricTest extends LoginPage
{
	@Test
	public void initializeMorpho() 
	{
		MorphoBiometric morphoBiometric=PageFactory.initElements(driver, MorphoBiometric.class);
		morphoBiometric.morphoBiometricLink();
		morphoBiometric.enterQuantity(2);
		morphoBiometric.gstDetails();
		morphoBiometric.companyName("BankIT");
		morphoBiometric.enterPanNumber("CYWHK7853U");
		morphoBiometric.gstRegistrationNumber(12345678);
		morphoBiometric.principalPlaceOfBussiness("A");
		morphoBiometric.shopName("Bank");
		morphoBiometric.emailID("abc@bankit.in");
		morphoBiometric.mobileNu("9876543210");
		morphoBiometric.add1("D-49");
		morphoBiometric.add2("Noida");
		morphoBiometric.countryName("India");
		morphoBiometric.stateName("Uttar Pradesh");
		morphoBiometric.disName("Gautam Buddha Nagar");
		morphoBiometric.submitButton();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		morphoBiometric.verifySizeAndText();
	}
}

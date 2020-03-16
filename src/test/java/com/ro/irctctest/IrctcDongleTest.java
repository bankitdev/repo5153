/**
 * 
 */
package com.ro.irctctest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.irctc.IrctcDongle;

/**
 * @author Sunil Kashyap
 *
 * Created Date 20-Dec-2018
 */
public class IrctcDongleTest extends LoginPage
{
	@Test
	public void initialize() 
	{
		IrctcDongle irctcDongle=PageFactory.initElements(driver, IrctcDongle.class);
		irctcDongle.irctcDongleLink();
		irctcDongle.process("Noida", "Uttar Pradesh", "Gautam Buddha Nagar", 201301, "sunil.kumar@bankit.in");
		irctcDongle.verifySizeAndText();
	}
}

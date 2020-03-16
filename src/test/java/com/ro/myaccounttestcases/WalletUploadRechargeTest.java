/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.WalletUploadRecharge;

/**
 * @author Sunil Kashyap
 *
 * Created Date 24-Jan-2019
 */
public class WalletUploadRechargeTest extends LoginPage
{	
	@Test
	public void startProcess() 
	{
		WalletUploadRecharge walletUploadRecharge=PageFactory.initElements(driver, WalletUploadRecharge.class);
		walletUploadRecharge.initializeProcess(500, "Axis Bank", "7860690515", "Noida", "C:\\Users\\admin\\eclipse-workspace\\ROPortal\\screenshots\\image.png", "Testing by Sunil",
				"ABC", "12345678901234", "HDFC Bank", "65463223522", "ICICI Bank", "ABCD", "C:\\Users\\admin\\eclipse-workspace\\ROPortal\\screenshots\\image.png", "Testing by Sunil",
				"BankIt", "State Bank Of India", "23456789098", "Noida", "Greater Noida", "Sector63", "C:\\Users\\admin\\eclipse-workspace\\ROPortal\\screenshots\\image.png", "Testing by Sunil");
	}
}

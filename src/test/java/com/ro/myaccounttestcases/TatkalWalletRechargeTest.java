/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.TatkalWalletRecharge;

/**
 * @author Sunil Kashyap
 *
 * Created Date 08-Mar-2019
 */
public class TatkalWalletRechargeTest extends LoginPage{
	
	@Test
	public void initializeProcess() {
		TatkalWalletRecharge tatkalWalletRecharge=PageFactory.initElements(driver, TatkalWalletRecharge.class);
		tatkalWalletRecharge.openTatkalWalletRecharge(1000, "Mr. ABC", "Testing");
		tatkalWalletRecharge.verifySizeAndText();
	}
}

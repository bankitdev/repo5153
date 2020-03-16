/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.WalletToWalletTopup;

/**
 * @author Sunil Kashyap
 *
 * Created Date 24-Jan-2019
 */
public class WalletToWalletTopupTest extends LoginPage
{	
	@Test
	public void startProcess() 
	{
		WalletToWalletTopup walletToWalletTopup= PageFactory.initElements(driver, WalletToWalletTopup.class);
		walletToWalletTopup.initializeProcess("2190","100");
		walletToWalletTopup.verifySizeAndTexts();
	}
}

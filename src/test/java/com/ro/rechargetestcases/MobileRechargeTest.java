/**
 * 
 */
package com.ro.rechargetestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.recharge.MobileRecharge;

/**
 * @author Sunil Kashyap
 *
 * Created Date 12-Dec-2018
 */
public class MobileRechargeTest extends LoginPage{
	
	@Test
	public void fillMobileRechargeTestDetails() 
	{
		MobileRecharge mobileRecharge=PageFactory.initElements(driver, MobileRecharge.class);
		mobileRecharge.setUprMobileRechargePage();
		mobileRecharge.mobileRecharge("Airtel", "9000000", "0");
		mobileRecharge.mobileRechargeTC1("Airtel","9000000000","1");
		mobileRecharge.printPlaceholder();
	}
}

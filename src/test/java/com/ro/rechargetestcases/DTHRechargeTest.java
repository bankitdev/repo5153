/**
 * 
 */
package com.ro.rechargetestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.recharge.DTHRecharge;

/**
 * @author Sunil Kashyap
 *
 * Created Date 12-Dec-2018
 */
public class DTHRechargeTest extends LoginPage{
	
	@Test
	public void fillDTHRechargeTestDetails() 
	{
		DTHRecharge dthRecharge=PageFactory.initElements(driver, DTHRecharge.class);
		dthRecharge.setUpRechargeModule();
		dthRecharge.dthRechargeTC1("Dish TV","9000000000","1");
		//dthRecharge.dthRechargeTC2();
		dthRecharge.verifyDTHOperator();
	}
}

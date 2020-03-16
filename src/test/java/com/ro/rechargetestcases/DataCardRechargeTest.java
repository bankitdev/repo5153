/**
 * 
 */
package com.ro.rechargetestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.recharge.DataCardRecharge;

/**
 * @author Sunil Kashyap
 *
 * Created Date 12-Dec-2018
 */
public class DataCardRechargeTest extends LoginPage
{
	@Test
	public void fillDataCardRechargeTestDetails() 
	{
		DataCardRecharge dataCardRecharge=PageFactory.initElements(driver, DataCardRecharge.class);
		dataCardRecharge.clickOnDataCardLinkBtn();
		dataCardRecharge.dataCardRechargeTC1("Idea","9000000000","1");
		dataCardRecharge.dataCardRechargeTC2("Idea","900000","0");
		dataCardRecharge.dataCardRechargeTC3();
		dataCardRecharge.verifyDataCardOperatorText();
	}
}

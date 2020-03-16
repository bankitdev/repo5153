/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.HelpCenter;

/**
 * @author Sunil Kashyap
 *
 * Created Date 17-Jan-2019
 */
public class HelpCenterTest extends LoginPage
{	
	@Test
	public void enterTransDetails() 
	{
		HelpCenter helpCenter=PageFactory.initElements(driver, HelpCenter.class);
		helpCenter.setUpProcess();
	}
}

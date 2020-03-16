/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.MyProfile;

/**
 * @author Sunil Kashyap
 *
 * Created Date 08-Mar-2019
 */
public class MyProfileTest extends LoginPage{
	
	@Test
	public void initializeProcess() 
	{
		MyProfile myProfile = PageFactory.initElements(driver, MyProfile.class);
		myProfile.openMyProfile();
	}
}

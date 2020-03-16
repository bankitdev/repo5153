/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.DownloadReports;

/**
 * @author Sunil Kashyap
 *
 * Created Date 17-Jan-2019
 */
public class DownloadReportsTest extends LoginPage
{	
	@Test
	public void setUpProcess() 
	{
		DownloadReports downloadReports=PageFactory.initElements(driver, DownloadReports.class);
		downloadReports.initialize();
		downloadReports.verifySizeAndText();
	}
}

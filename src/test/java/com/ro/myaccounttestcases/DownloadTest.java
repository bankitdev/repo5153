/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.Download;

/**
 * @author Sunil Kashyap
 *
 * Created Date 23-Jan-2019
 */
public class DownloadTest extends LoginPage
{	
	@Test
	public void startProcess() 
	{
		Download download=PageFactory.initElements(driver, Download.class);
		download.initializeProcess();
	}
}

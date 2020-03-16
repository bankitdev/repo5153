/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.SenderRecipientReports;

/**
 * @author Sunil Kashyap
 *
 * Created Date 08-Mar-2019
 */
public class SenderRecipientReportsTest extends LoginPage{
	
	@Test
	public void initializeProcess() 
	{
		SenderRecipientReports senderRecipientReports= PageFactory.initElements(driver, SenderRecipientReports.class);
		senderRecipientReports.openSenRecRep(8800540474L);
	}
}

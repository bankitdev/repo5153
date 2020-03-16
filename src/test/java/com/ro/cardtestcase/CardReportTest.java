/**
 * 
 */
package com.ro.cardtestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.card.CardReport;

/**
 * @author Sunil Kashyap
 *
 * Created Date 24-Dec-2018
 */
public class CardReportTest extends LoginPage
{
	@Test
	public void initalizeMethods() 
	{
		CardReport cardReport=PageFactory.initElements(driver, CardReport.class);
		cardReport.initilize();
		cardReport.fillDetailsTC1();
		cardReport.fillDetailsTC2();
		cardReport.fillDetailsTC3();
		cardReport.fillDetailsTC4();
		cardReport.verifyTextAndSize();
	}
	/*@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}*/
}

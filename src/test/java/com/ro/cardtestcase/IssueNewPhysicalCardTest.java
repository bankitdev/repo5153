/**
 * 
 */
package com.ro.cardtestcase;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.card.IssueNewPhysicalCard;

/**
 * @author Sunil Kashyap
 *
 * Created Date 09-Oct-2018
 */
public class IssueNewPhysicalCardTest extends LoginPage
{
	@Test
	public void initializeMethod() 
	{
		IssueNewPhysicalCard issueNewPhysicalCard=PageFactory.initElements(driver, IssueNewPhysicalCard.class);
		issueNewPhysicalCard.setUp();
		issueNewPhysicalCard.issueNewPhysicalCardDetails("abc@bankit.in", "7685433668");
		issueNewPhysicalCard.newPhysicalCardDetails("Swipe Card","A","B","Male","Sector 63","Noida","Noida","Uttar Pradesh",201301,"PAN Card","ABGDR8734K");
	}
	@AfterMethod
	public void quitBrowser() 
	{
		driver.quit();
	}
}

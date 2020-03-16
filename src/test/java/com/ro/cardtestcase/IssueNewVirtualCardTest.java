/**
 * 
 */
package com.ro.cardtestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.card.IssueNewVirtualCard;

/**
 * @author Sunil Kashyap
 *
 * Created Date 25-Oct-2018
 */
public class IssueNewVirtualCardTest extends LoginPage
{	
	@Test
	public void issueNewVirtualCrd() 
	{
		IssueNewVirtualCard issueNewVirtualCard=PageFactory.initElements(driver, IssueNewVirtualCard.class);
		issueNewVirtualCard.clickOnIssueNewVirtualCardBtn();
		issueNewVirtualCard.enterFirstName("Sunil");
		issueNewVirtualCard.enterLastName("Kashyap");
		issueNewVirtualCard.selectGender("Male");
		issueNewVirtualCard.dateOfBirth();
		issueNewVirtualCard.enterMobileNumber("8800540474");
		issueNewVirtualCard.enterEmailID("Sunil.kumar@bankit.in");
		issueNewVirtualCard.enterAddress1("sec 63");
		issueNewVirtualCard.enterAddress2("Noida");
		issueNewVirtualCard.selectState("Uttar Pradesh");
		issueNewVirtualCard.entyerCity("Noida");
		issueNewVirtualCard.enterPincode(201301);
		issueNewVirtualCard.selectOVDType("PAN Card");
		issueNewVirtualCard.enterDocumentNumber("HGF68GWP");
		issueNewVirtualCard.clickOnSubmitBtn();
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
}

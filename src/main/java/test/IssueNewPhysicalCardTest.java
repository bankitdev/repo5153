/**
 * 
 */
package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;

/**
 * @author Sunil Kashyap
 *
 * Created Date 21-Dec-2018
 */
public class IssueNewPhysicalCardTest extends LoginPage {
	
	@Test
	public void initialize() 
	{
		IssueNewPhysicalCard issueNewPhysicalCard=PageFactory.initElements(driver, IssueNewPhysicalCard.class);
		issueNewPhysicalCard.clickOnIssueNewPhysicalCard();
		issueNewPhysicalCard.enterEmailID("agdshg@hdg.com");
		issueNewPhysicalCard.enterMobileNum("7896543086");
		issueNewPhysicalCard.clickOnSubmitBtn();
	}
}

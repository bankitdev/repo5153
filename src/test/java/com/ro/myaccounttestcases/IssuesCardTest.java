/**
 * 
 */
package com.ro.myaccounttestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.myaccount.IssuesCard;

/**
 * @author Sunil Kashyap
 *
 * Created Date 08-Mar-2019
 */
public class IssuesCardTest extends LoginPage {
	
	@Test
	public void initializeProcess() 
	{
		IssuesCard issuesCard =PageFactory.initElements(driver, IssuesCard.class);
		issuesCard.openIssueCard();
	}

}

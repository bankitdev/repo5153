/**
 * 
 */
package com.ro.card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
/**
 * @author Sunil Kashyap
 *
 * Created Date 03-Oct-2018
 */
public class VirtualCard extends LoginPage
{	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Issue New Virtual Card']")
	WebElement issueNewVirtualCard;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Get Virtual Card Details']")
	WebElement getVirtualCardDetails;
	
	public VirtualCard() throws Exception
	{	
		PageFactory.initElements(driver, this);
	}
	/*public IssueNewVirtualCard issueNewVirtualCard() throws Exception 
	{	
		issueNewVirtualCard.click();
		return new IssueNewVirtualCard();
	}*/
	public GetVirtualCardDetails getVirtualCardDetails() throws Exception 
	{
		getVirtualCardDetails.click();
		return getVirtualCardDetails();
	}
}

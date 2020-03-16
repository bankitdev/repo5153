/**
 * 
 */
package com.ro.card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ro.Base.LoginPage;
import com.ro.util.ValidationAndVerification;

/**
 * @author Sunil Kashyap
 *
 * Created Date 05-Oct-2018
 */
public class TransactwithExistingCard extends LoginPage
{	

	@FindBy(xpath="//a[@id='a_benfeciary']/input[@value='Get Card Details']")
	WebElement getCardDetails;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Load Card']")
	WebElement loadCard;
	
	@FindBy(xpath="//a[@id='a_benfeciary']/input[@value='Card To Card Transfer']")
	WebElement cardToCardTransfer;
	
	@FindBy(xpath="//a[@id='a_benfeciary']/input[@value='Get Card Balance']")
	WebElement getCardBalance;
	
	
	public TransactwithExistingCard() {
		PageFactory.initElements(driver, this);
	}
	
	public void getCardDetails() 
	{	
		/*Actions action=new Actions(driver);
		action.moveToElement(getCardDetails).click().build().perform();*/
		getCardDetails.click();
	}
}

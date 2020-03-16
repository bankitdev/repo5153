/**
 * 
 */
package com.ro.myaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 08-Mar-2019
 */
public class SenderRecipientReports {
	
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle' and @type='button']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[contains(text(),'Sender/Recipient Report')]")
	WebElement senderRecipientReport;
	
	@FindBy(name="mobileno")
	WebElement mobileNu;
	
	@FindBy(id="img_btn")
	WebElement submitBtn;
	WebDriver driver;
	
	public SenderRecipientReports(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void openSenRecRep(long mobNu) 
	{
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(myAccount).click().build().perform();
		senderRecipientReport.click();
		
		mobileNu.sendKeys(String.valueOf(mobNu));
		
		submitBtn.click();
	}

}

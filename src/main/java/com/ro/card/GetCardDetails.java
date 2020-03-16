/**
 * 
 */
package com.ro.card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 16-Oct-2018
 */
public class GetCardDetails {
	
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement clickOnCardBtn;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Transact with Existing Card']")
	WebElement transactWithExistingCard;
	
	@FindBy(xpath="//a[@id='a_benfeciary']/input[@value='Get Card Details']")
	WebElement getCardDetails;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="mobile")
	WebElement mobileNo;
	
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Clear']")
	WebElement clear;
	
	WebDriver driver;
	
	public GetCardDetails(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void clickOnGetCardDetailsBtn() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(clickOnCardBtn).click().perform();
		transactWithExistingCard.click();
		
		getCardDetails.click();
	}
	public void enterCardDetails(String eID, long mobNum) 
	{	
		String[] button= {"Clear","Submit"};
		for(int i=0;i<button.length;i++) {
			
		//	emailId.sendKeys(eID);
			mobileNo.sendKeys(String.valueOf(mobNum));
			verifySizeAndText();
			
			String btn=button[i];
			if(btn.equals("Clear")) {
				clear.click();
			}else {
				submit.click();
				try {
					WebElement msg=driver.findElement(By.xpath("//h4[contains(text(),'Card Information')]"));
					String textMsg=msg.getText();
					System.out.println(textMsg+" is showing seccessfully");
				} catch (Exception e) {
					System.out.println(driver.findElement(By.xpath("//form[@name='cardDetailsForm']/table[2]/tbody/tr/td/span")).getText());
				}
			}
		}
	}
	
	public void verifySizeAndText() 
	{
		int emailIdHeight=emailId.getSize().getHeight();
		int emailIdWidth=emailId.getSize().getWidth();
		System.out.println("The Email ID textfield Height is "+emailIdHeight+" The Email ID textfield Width is"+emailIdWidth);
		
		int mobileNoHeight=mobileNo.getSize().getHeight();
		int mobileNoWidth=mobileNo.getSize().getWidth();
		System.out.println("The Mobile No textfield Height is "+mobileNoHeight+" The Mobile No textfield Width is"+mobileNoWidth);
		
		int submitHeight=submit.getSize().getHeight();
		int submitWidth=submit.getSize().getWidth();
		System.out.println("The Submit Btn Height is "+submitHeight+" The Submit Btn Width is"+submitWidth);
		String submittxt=submit.getAttribute("value");
		if(submittxt.equals("Submit")) {System.out.println("Submit Button text is matched");}
		else {System.out.println("Submit Button text is not matched");}
		
		int clearHeight=clear.getSize().getHeight();
		int clearWidth=clear.getSize().getWidth();
		System.out.println("The Clear Btn Height is "+clearHeight+" The Clear Btn Width is"+clearWidth);
		String cleartxt=clear.getAttribute("value");
		if(cleartxt.equals("Clear")) {System.out.println("Clear Button text is matched");}
		else {System.out.println("Clear Button text is not matched");}
	}
}

/**
 * 
 */
package com.ro.card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;
import com.ro.Base.LoginPageLocal;

/**
 * @author Sunil Kashyap
 *
 * Created Date 22-Oct-2018
 */
public class GetCardDetailsLocal extends LoginPage
{
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement clickOnCardBtn;
	@FindBy(xpath="//input[@value='Transact with Existing Card']")
	WebElement transactwithExistingCard;
	@FindBy(id="email")
	WebElement emails;
	@FindBy(id="mobile")
	WebElement mobiles;
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Submit']")
	WebElement submitBtn;
	@FindBy(xpath="//form[@name='cardDetailsForm']/table[2]/tbody/tr/td/span")
	WebElement texts;
	
	public GetCardDetailsLocal() 
	{
		PageFactory.initElements(driver, this);
	}
	@BeforeMethod
	public void initialize() 
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(clickOnCardBtn).click().build().perform();
		transactwithExistingCard.click();
	}
	@Test
	public void checkingValidation() 
	{
		String[] emailId= {"bankiyybb@hhyb.bhuu","65346625257","sunil.kumar@bankit.in"};
		String[] mobileNo= {"765467ygytfy","@$^^t765","8800540474"};
		for(int i=0; i< emailId.length;i++) 
		{
			String email=emailId[i];
			String mobile=mobileNo[i];
			
			emails.sendKeys(email);
			mobiles.sendKeys(mobile);
			submitBtn.click();
			
			try
			{
				driver.findElement(By.xpath("//h4[text()='Card Information']"));
				
				System.out.println("------------------------------------------------");
				System.out.println("Successfully click on card Details");
			}catch(Exception e) 
			{
				System.out.println("------------------------------------------------");
				System.out.println(texts.getText());
			}
		}
	}
	@AfterMethod
	public void quit() 
	{
		driver.quit();
	}
}

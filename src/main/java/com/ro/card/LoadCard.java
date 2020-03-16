/**
 * 
 */
package com.ro.card;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ro.Base.LoginPage;

/**
 * @author Sunil Kashyap
 *
 * Created Date 22-Oct-2018
 */
public class LoadCard extends LoginPage
{
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement clickOnCardBtn;
	@FindBy(xpath="//input[@value='Transact with Existing Card']")
	WebElement transactwithExistingCard;
	@FindBy(xpath="//a[@id='rftran']/input[@value='Load Card']")
	WebElement loadCard;
	@FindBy(id="mobileNumber")
	WebElement mobile;
	@FindBy(id="cardNumber")
	WebElement cardNo;
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Submit']")
	WebElement submit;
	@FindBy(id="amount")
	WebElement bal;
	@FindBy(xpath="//div[@id='header']//div//p//span[contains(text(),'Balance ')]//strong")
	WebElement actualBalance;
	@FindBy(xpath="//form[@name='loadCardForm']/div")
	WebElement cardLoadSuccessfully;
	
	public LoadCard() 
	{
		PageFactory.initElements(driver, this);
	}
	@BeforeMethod
	public void initialize() 
	{	
	
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(clickOnCardBtn).click().perform();
		transactwithExistingCard.click();
		
		loadCard.click();
	}
	@Test(priority=1)
	public void amountTC1() 
	{
		mobile.sendKeys("8368711960");
		cardNo.sendKeys("9862");
		submit.click();
	
		/*String value1 = actualBalance.getText();
		System.out.println("The Actual Balance is "+value1);                           //print actual balance
		int amountX=Integer.parseInt(value1)*/;
		
		String amount="1.15";
		bal.sendKeys(amount);
		System.out.println("Recharge amount is "+bal.getAttribute("value"));
		submit.click();
		try 
		{	
			System.out.println("------------------------------------------------");
			System.out.println(cardLoadSuccessfully.getText());
			System.out.println("TestCase passed________Successfully transactions");
		}catch(Exception e) {
			System.out.println("------------------------------------------------");
			System.out.println("tranctions failed");
		}
		
		/*String value = actualBalance.getText();
		System.out.println("The Expected Balance is "+value);                // print expected balance 
		int valuex=Integer.parseInt(value);

		int deductionBalance=amountX-valuex;    							//deduction balance
		System.out.println("The deduction Balance is "+deductionBalance);*/
	}
	@Test(priority=2)
	public void amountTC2() 
	{
		mobile.sendKeys("8368711960");
		cardNo.sendKeys("9862");
		submit.click();
		
		bal.sendKeys("stmnubfu");
		submit.click();
		
		try 
		{	
			
			System.out.println("------------------------------------------------");
			System.out.println(cardLoadSuccessfully.getText());
			System.out.println("TestCase passed________Successfully transactions");
		}catch(Exception e) {
			System.out.println("------------------------------------------------");
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			
			System.out.println("tranctions failed");
		}
	}
	@Test(priority=3)
	public void amountTC3() 
	{
		mobile.sendKeys("8368711960");
		cardNo.sendKeys("9862");
		submit.click();
		
		bal.sendKeys("@#$^%");
		submit.click();
		try 
		{	
			
			System.out.println("------------------------------------------------");
			System.out.println(cardLoadSuccessfully.getText());
			System.out.println("TestCase passed________Successfully transactions");
		}catch(Exception e) {
			System.out.println("------------------------------------------------");
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			
			System.out.println("tranctions failed");
		}
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
}

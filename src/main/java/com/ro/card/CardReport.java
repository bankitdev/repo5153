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
 * Created Date 15-Oct-2018
 */
public class CardReport
{	
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement clickOnCardBtn;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Card Report']")
	WebElement cardReport;
	
	@FindBy(id="mobileNumber")
	WebElement mobileNo;
	
	@FindBy(id="cardNumber")
	WebElement cardNo;
	
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Send OTP']")
	WebElement sendOTP;
	
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Submit']")
	WebElement submit;
	
	WebDriver driver;
	
	public CardReport(WebDriver driver) 
	{
		this.driver=driver;
		
	}
	
	public void initilize() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(clickOnCardBtn).click().perform();	
		cardReport.click();
		
	}
	
	public void fillDetailsTC1() 
	{		
		//code for the negative test case on the mobile no. and card no.
		
			mobileNo.sendKeys("8800540");
			cardNo.sendKeys("119");
			sendOTP.click();
			try {
				submit.click();
				System.out.println("TestCase passed");
			}catch (Exception e) {
				System.out.println("----------------------------------------------");
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				System.out.println("TestCase failed");
			}
	}

	public void fillDetailsTC2() 
	{
		//code for the negative test case with alphabet value on the mobile no. and card no.

		mobileNo.sendKeys("dfsfterfho");
		cardNo.sendKeys("1233");
		sendOTP.click();
		try {
			submit.click();
			System.out.println("TestCase passed");
		}catch (Exception e) {
			System.out.println("----------------------------------------------");
			System.out.println("TestCase failed");
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			WebElement textMsg=driver.findElement(By.xpath("//form[@name='cardDetailsForm']/table/tbody/tr/td/span"));
			System.out.println(textMsg.getText());	
		}
	}
	
	public void fillDetailsTC3() 
	{
		//code for the negative test case with special character on the mobile no. and card no.

		
		mobileNo.sendKeys("@#$%^&**&#");
		cardNo.sendKeys("#$%^");
		sendOTP.click();
		try {
			submit.click();
			System.out.println("TestCase passed");
		}catch (Exception e) {
			System.out.println("----------------------------------------------");
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			System.out.println("TestCase failed");
		}
	}
	
	public void fillDetailsTC4() 
	{
		//code for the positive test case on the mobile no. and card no with +ve value.
		
		mobileNo.sendKeys("8800540474");
		cardNo.sendKeys("1193");
		sendOTP.click();
		try {
			submit.click();
			System.out.println("TestCase passed");
		}catch (Exception e) {
			System.out.println("----------------------------------------------");
			System.out.println("TestCase failed");
			WebElement textMsg=driver.findElement(By.xpath("//form[@name='cardDetailsForm']/table/tbody/tr/td/span"));
			System.out.println(textMsg.getText());	
		}
	}
	public void verifyTextAndSize() 
	{
		int mobileNoHeight=mobileNo.getSize().getHeight();
		int mobileNoWidth=mobileNo.getSize().getWidth();
		System.out.println("The Mobile No textfield height is "+mobileNoHeight+" The mobile No textfield width is"+mobileNoWidth);
		
		int cardNoHeight=cardNo.getSize().getHeight();
		int cardNoWidth=cardNo.getSize().getWidth();
		System.out.println("The card No textfield height is "+cardNoHeight+" The card No textfield width is"+cardNoWidth);
		
		/*int submitBtnHeight=submit.getSize().getHeight();
		int submitBtnWidth=submit.getSize().getWidth();
		System.out.println("The submitBtn height is "+submitBtnHeight+" The submitBtn width is"+submitBtnWidth);*/
	}
}

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
 * Created Date 24-Oct-2018
 */
public class CardToCardTransfer 
{
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement clickOnCardBtn;
	@FindBy(xpath="//input[@value='Transact with Existing Card']")
	WebElement transactwithExistingCard;
	@FindBy(xpath="//a[@id='a_benfeciary']/input[@value='Card To Card Transfer']")
	WebElement cardTocardTransfer;
	@FindBy(id="mobileNumber")
	WebElement mobile;
	@FindBy(id="senderCardNum")
	WebElement cardNu;
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Submit']")
	WebElement submitBtn;
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Clear']")
	WebElement clearBtn;
	@FindBy(id="recCardNum")
	WebElement recCardNo;
	@FindBy(id="recMobileNumber")
	WebElement recMobileNo;
	@FindBy(xpath="//section[@class='main_space']/div/div/div/div[2]")
	WebElement texts;
	
	WebDriver driver;
	
	public CardToCardTransfer(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void setUpMethod() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(clickOnCardBtn).click().perform();
		transactwithExistingCard.click();
		cardTocardTransfer.click();
	}
	
	public void fillUpDetailsTC1() 
	{
		String[] mobileNo= {"8800540474","8368711960"};
		String[] cardNo= {"1193","9862"};
		for(int i=0;i<mobileNo.length;i++) 
		{
			String mob=mobileNo[i];
			String card=cardNo[i];
			
			mobile.sendKeys(mob);
			cardNu.sendKeys(card);
			submitBtn.click();
			verifySizeAndText();
			
			try 
			{
				recCardNo.sendKeys("9995");
				recMobileNo.sendKeys("9999003824");
				submitBtn.click();
				System.out.println("Card is KYC");
				try {
					String[] amount= {"10","ahdiu","@^%#^"};
					for(int j=0;j<amount.length;j++) {
						String amt=amount[i];
						WebElement amounts=driver.findElement(By.id("amount"));
						amounts.sendKeys(amt);
						submitBtn.click();
					}					
					submitBtn.click();
					WebElement text1=driver.findElement(By.xpath("//section[@class='main_space']/div/div/div[2]/div[2]"));
					System.out.println(text1.getText());
				}
				catch(Exception c) {System.out.println("------------------------------------------------");
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				System.out.println("tranctions failed");}
			}catch(Exception e) {
				System.out.println(texts.getText());
			}			
		}
	}
	
	public void fillUpDetailsTC2() 
	{
		String[] mobileNo= {"8800540474","8368711960"};
		String[] cardNo= {"1193","9862"};
		for(int i=0;i<mobileNo.length;i++) 
		{
			String mob=mobileNo[i];
			String card=cardNo[i];
			
			mobile.sendKeys(mob);
			cardNu.sendKeys(card);
			submitBtn.click();
			
			try 
			{
				recCardNo.sendKeys("9995");
				recMobileNo.sendKeys("9999003824");
				submitBtn.click();
				System.out.println("Card is KYC");
				try {
					WebElement amount=driver.findElement(By.id("amount"));
					amount.sendKeys("agstdb");
					submitBtn.click();
					
					submitBtn.click();
					WebElement text1=driver.findElement(By.xpath("//section[@class='main_space']/div/div/div[2]/div[2]"));
					System.out.println(text1.getText());    }
				catch(Exception c) {System.out.println("------------------------------------------------");
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();				
				System.out.println("tranctions failed");}
			}catch(Exception e) {
				System.out.println(texts.getText());
			}			
		}
	}
	
	public void fillUpDetailsTC3() 
	{
		String[] mobileNo= {"8800540474","8368711960"};
		String[] cardNo= {"1193","9862"};
		for(int i=0;i<mobileNo.length;i++) 
		{
			String mob=mobileNo[i];
			String card=cardNo[i];
			
			mobile.sendKeys(mob);
			cardNu.sendKeys(card);
			submitBtn.click();
			
			
			try 
			{
				recCardNo.sendKeys("9995");
				recMobileNo.sendKeys("9999003824");
				submitBtn.click();
				System.out.println("Card is KYC");
				try {
					WebElement amount=driver.findElement(By.id("amount"));
					amount.sendKeys("@#$%&^!*");
					submitBtn.click();
					
					submitBtn.click();
					WebElement text1=driver.findElement(By.xpath("//section[@class='main_space']/div/div/div[2]/div[2]"));
					System.out.println(text1.getText());
				}
				catch(Exception c) {System.out.println("------------------------------------------------");
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();				
				System.out.println("tranctions failed");}
			}catch(Exception e) {
				System.out.println(texts.getText());
			}			
		}
	}

	public void fillUpDetailsTC4() 
	{
		String[] mobileNo= {"8800540474","8368711960"};
		String[] cardNo= {"1193","9862"};
		for(int i=0;i<mobileNo.length;i++) 
		{
			String mob=mobileNo[i];
			String card=cardNo[i];
			
			mobile.sendKeys(mob);
			cardNu.sendKeys(card);
			submitBtn.click();
			
			try 
			{
				recCardNo.sendKeys("9995");
				recMobileNo.sendKeys("9999003824");
				submitBtn.click();
				System.out.println("Card is KYC");
				try {
					WebElement amount=driver.findElement(By.id("amount"));
					amount.sendKeys("1");
					submitBtn.click();
					
					submitBtn.click();
					WebElement text1=driver.findElement(By.xpath("//section[@class='main_space']/div/div/div[2]/div[2]"));
					System.out.println(text1.getText());
				    }
				    catch(Exception c) {System.out.println(texts.getText());}
			 }catch(Exception e) {
				System.out.println(texts.getText());
			}
		}
	}
	public void verifySizeAndText() 
	{
		int mobileHeight=mobile.getSize().getHeight();
		int mobileWidth=mobile.getSize().getWidth();
		System.out.println("The Mobile Number textfield Height is "+mobileHeight+"The Mobile Number textfield Width is"+mobileWidth);
		
		int cardNuHeight=cardNu.getSize().getHeight();
		int cardNuWidth=cardNu.getSize().getWidth();
		System.out.println("The Card Number textfield Height is "+cardNuHeight+"The Card Number textfield Width is"+cardNuWidth);
		
		int submitBtnHeight=submitBtn.getSize().getHeight();
		int submitBtnWidth=submitBtn.getSize().getWidth();
		System.out.println("The Submit Button textfield Height is "+submitBtnHeight+"The Submit Button textfield Width is"+submitBtnWidth);
		
		int clearBtnHeight=clearBtn.getSize().getHeight();
		int clearBtnWidth=clearBtn.getSize().getWidth();
		System.out.println("The Clear button textfield Height is "+clearBtnHeight+"The Clear Button textfield Width is"+clearBtnWidth);
	}
}
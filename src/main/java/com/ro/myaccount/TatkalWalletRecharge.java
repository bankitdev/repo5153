/**
 * 
 */
package com.ro.myaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 08-Mar-2019
 */
public class TatkalWalletRecharge {
	
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle' and @type='button']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[contains(text(),'Tatkal Wallet Recharge')]")
	WebElement tatkalWalletRechargebtn;
	
	@FindBy(id="amount")
	WebElement requestForAmount;
	
	@FindBy(name="depositerName")
	WebElement depositorName;
	
	@FindBy(name="remark")
	WebElement remark;
	
	@FindBy(id="img_btn")
	WebElement submitBtn;
	
	WebDriver driver;
	
	public TatkalWalletRecharge(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void openTatkalWalletRecharge(int amount,String depoName,String rem) 
	{
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(myAccount).click().build().perform();
		tatkalWalletRechargebtn.click();
		
		String[] buttons= {"Back","Submit"};
		for(int i=0;i<buttons.length;i++) {
			
			requestForAmount.sendKeys(String.valueOf(amount));
			depositorName.sendKeys(depoName);
			remark.sendKeys(rem);
			submitBtn.click();
			
			String btn=buttons[i];
			
			if(btn.equals("Back"))
			{
				driver.findElement(By.xpath("//input[@id='img_btn' and @value='Back']")).click();
			}else {driver.findElement(By.xpath("//input[@id='img_btn' and @value='Submit']")).click();
					driver.findElement(By.xpath("//a[contains(text(),'Cancel Payment')]")).click();}
			
		}	
	}
	public void verifySizeAndText() 
	{	
		// size of Request for Amount textfield
		int requestForAmountHeight=requestForAmount.getSize().getHeight();
		int requestForAmountWidth=requestForAmount.getSize().getWidth();
		System.out.println("The Request for Amount textfield Height is "+requestForAmountHeight+" The Request for Amount textfield Width is "+requestForAmountWidth);
		
		// size of depositor Name textfield
		int depositorNameHeight=depositorName.getSize().getHeight();
		int depositorNameWidth=depositorName.getSize().getWidth();
		System.out.println("The depositor Name textfield Height is "+depositorNameHeight+" The depositor Name textfield Width is "+depositorNameWidth);

		// size of remark textfield
		int remarkHeight=remark.getSize().getHeight();
		int remarkWidth=remark.getSize().getWidth();
		System.out.println("The Request for Amount textfield Height is "+remarkHeight+" The Request for Amount textfield Width is "+remarkWidth);

	}	
	
	

}

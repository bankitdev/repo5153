/**
 * 
 */
package com.ro.myaccount;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 24-Jan-2019
 */
public class WalletToWalletTopup
{
	@FindBy(xpath="//div[@class='btn-group']/button[@type='button']")
	WebElement myAccount;
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right text-right']//a[contains(text(),'Wallet To Wallet Topup')]")
	WebElement walletToWalletTopup;
	@FindBy(name="ag_id")
	WebElement agentID;
	@FindBy(name="amt")
	WebElement amount;
	@FindBy(id="img_btn")
	WebElement submitBtn;
	@FindBy(id="img_btn_back")
	WebElement clearBtn;
	
	WebDriver driver;
	
	public WalletToWalletTopup(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void initializeProcess(String id,String amt) 
	{		
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(myAccount).click().build().perform();
		walletToWalletTopup.click();
		
		String[] button= {"Clear","Submit"};
		for(int i=0;i<button.length;i++) 
		{
			String btn=button[i];
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			agentID.sendKeys(id);
			amount.sendKeys(amt);
			if(btn.equals("Clear")) 
			{
				clearBtn.click();
			}else {submitBtn.click();}
		}
		
	}
	public void verifySizeAndTexts() 
	{
		int agentIDHeight=agentID.getSize().getHeight();
		int agentIDWidth=agentID.getSize().getWidth();
		System.out.println("The Agent ID textfield Height is"+agentIDHeight+" The Agent ID textfield Width is"+agentIDWidth);
		
		int amountHeight=amount.getSize().getHeight();
		int amountWidth=amount.getSize().getWidth();
		System.out.println("The amount textfield Height is"+amountHeight+" The amount textfield Width is"+amountWidth);
		
		int clearBtnHeight=clearBtn.getSize().getHeight();
		int clearBtnWidth=clearBtn.getSize().getWidth();
		System.out.println("The clearBtn Height is"+clearBtnHeight+" The clearBtn Width is"+clearBtnWidth);
		String clearBtntxt=clearBtn.getAttribute("value");
		if(clearBtntxt.equals("Clear")) {System.out.println("Clear Btn text is matched");}
		else {System.out.println("Clear Btn text is not matched");}
		
		int submitBtnHeight=submitBtn.getSize().getHeight();
		int submitBtnWidth=submitBtn.getSize().getWidth();
		System.out.println("The submitBtn Height is"+submitBtnHeight+" The submitBtn Width is"+submitBtnWidth);
		String submitBtntxt=submitBtn.getAttribute("value");
		if(submitBtntxt.equals("Submit")) {System.out.println("Submit Btn text is matched");}
		else {System.out.println("Submit Btn text is not matched");}
	}
}

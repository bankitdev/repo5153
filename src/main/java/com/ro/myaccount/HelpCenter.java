/**
 * 
 */
package com.ro.myaccount;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 17-Jan-2019
 */
public class HelpCenter 
{
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle' and @type='button']")
	WebElement myAccount;
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right text-right']//a[contains(text(),'Help Center')]")
	WebElement helpCenter;
	@FindBy(id="tran_id")
	WebElement enterTransID;
	@FindBy(id="basic-addon2")
	WebElement searchBtn;
	@FindBy(id="submitbutton")
	WebElement clickOnSendBtn;
	@FindBy(xpath="//form[@name='tranform']/div[3]/p/strong")
	WebElement textMsg;
	WebDriver driver;
	public HelpCenter(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void setUpProcess() 
	{
		myAccount.click();
		WebElement helpCenter=driver.findElement(By.xpath("//div[@class='col-md-2 my_account noP']/div/ul/li/a[contains(text(),'Help Center')]"));
		helpCenter.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		enterTransID.sendKeys("19011203185306931422");
		searchBtn.click();
		clickOnSendBtn.click();
		System.out.println(textMsg.getText());
		
	}
}

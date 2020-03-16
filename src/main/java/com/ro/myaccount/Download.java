/**
 * 
 */
package com.ro.myaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 23-Jan-2019
 */
public class Download
{
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle' and @type='button']")
	WebElement myAccount;
	@FindBy(xpath="(//div[@class='col-md-2 my_account noP']/div/ul/li/a[contains(text(),'Download')])[2]")
	WebElement download;
	WebDriver driver;
	
	public Download(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void initializeProcess() 
	{
		myAccount.click();
		download.click();
	}
}

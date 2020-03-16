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
public class MyProfile {
	
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle' and @type='button']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement myProfile;
	
	WebDriver driver;
	
	public MyProfile(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void openMyProfile() 
	{
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(myAccount).click().build().perform();
		myProfile.click();
	}

}

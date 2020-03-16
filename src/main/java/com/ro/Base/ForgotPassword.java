/**
 * 
 */
package com.ro.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 25-Jan-2019
 */
public class ForgotPassword 
{	
	@FindBy(xpath="//a[contains(text(),' Forgot Password?')]")
	WebElement forgotPassword;
	@FindBy(name="EmailID")
	WebElement registeredMobileAndEmailID;
	@FindBy(xpath="//a[contains(text(),'Submit')]")
	WebElement submitBtn;
	
	WebDriver driver;
	
	public ForgotPassword(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void forgotPassword(String iDAndNo) 
	{
		forgotPassword.click();
		registeredMobileAndEmailID.sendKeys(iDAndNo);
		
		submitBtn.click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.navigate().refresh();
	}
}

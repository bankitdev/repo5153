/**
 * 
 */
package com.ro.Base;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 25-Jan-2019
 */
public class SignUp
{
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	WebDriver driver;
	
	public SignUp(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void signUpLink() 
	{
		signUp.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.switchTo().window(tabs2.get(0));
	}
}

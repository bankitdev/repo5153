/**
 * 
 */
package com.ro.safegold;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Sunil Kashyap
 *
 * Created Date 26-Nov-2018
 */
public class ExistingUserRegisteredPage extends LoginPage
{
	@FindBy(xpath="//a[contains(text(),'SAFEGOLD')]")
	WebElement safeGoldBtn;
	
	@FindBy(id="regMobile")
	WebElement customerMobileNumber;
	
	@FindBy(id="otpLogin")
	WebElement otp;
	
	@FindBy(xpath="//div[@id='rst']/input[@value='Submit']")
	WebElement submit;
	
	public ExistingUserRegisteredPage() 
	{	
		PageFactory.initElements(driver, this);
	}
	@BeforeMethod
	public void initialize() 
	{
		Actions action=new Actions(driver);
		action.moveToElement(safeGoldBtn).click().build().perform();
		
		customerMobileNumber.sendKeys("8800540474");
		submit.click();
	}
	@Test
	public void setData() 
	{
		otp.sendKeys("123456");
	}
}

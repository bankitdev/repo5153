/**
 * 
 */
package com.ro.safegold;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author Sunil Kashyap
 *
 * Created Date 26-Nov-2018
 */
public class SafeGoldHomePage
{	
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'SAFEGOLD')]")
	WebElement safeGoldBtn;
	
	@FindBy(xpath="//h3[contains(text(),'SafeGold')]")
	WebElement verifySafeGoldText;
	
	@FindBy(id="regMobile")
	WebElement customerMobileNumber;
	
	@FindBy(xpath="//div[@id='rst']/input[@type='submit']")
	WebElement submit;
	
	@FindBy(id="reset_text")
	WebElement clear;
	
	/*public SafeGoldHomePage() 
	{
		PageFactory.initElements(driver, this);
	}*/
	public void clickOnSafeGoldLink() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(safeGoldBtn).click().build().perform();
	}
	public void customerMobileNumer() 
	{
		customerMobileNumber.sendKeys("7654567765");
		submit.click();
	}
	public void verifyText() 
	{
		Assert.assertEquals(verifySafeGoldText, "SafeGold");
	}
	public NewUserRegistrationPage newUserRegistrationPage() 
	{
		return new NewUserRegistrationPage();
	}
	public ExistingUserRegisteredPage existingUserregisteredPage() 
	{
		return new ExistingUserRegisteredPage();
	}
	/*public static void main(String args[]) 
	{
		SafeGoldHomePage safeGoldHomePage=new SafeGoldHomePage();
		safeGoldHomePage.clickOnSafeGoldLink();
		safeGoldHomePage.customerMobileNumer();
	}*/
}

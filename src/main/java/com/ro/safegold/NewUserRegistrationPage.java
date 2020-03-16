/**
 * 
 */
package com.ro.safegold;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Sunil Kashyap
 *
 * Created Date 26-Nov-2018
 */
public class NewUserRegistrationPage extends LoginPage
{	
	
	@FindBy(xpath="//a[contains(text(),'SAFEGOLD')]")
	WebElement safeGoldBtn;
	
	@FindBy(id="regMobile")
	WebElement customerMobileNumber;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="txtDate")
	WebElement dob;
	
	@FindBy(id="pincode")
	WebElement pincode;
	
	@FindBy(xpath="//select[@id='lang_preference']")
	WebElement language;
	
	@FindBy(xpath="//div[@id='rst']/input[@value='Submit']")
	WebElement submit;
	
	@FindBy(name="back")
	WebElement back;
	
	@FindBy(id="clear")
	WebElement clear;
	
	public NewUserRegistrationPage() 
	{
		PageFactory.initElements(driver, this);
	}
	@BeforeMethod
	public void initialize() 
	{	
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();}
		action.moveToElement(safeGoldBtn).click().build().perform();
	
		customerMobileNumber.sendKeys("7654567765");
		submit.click();
	}
	@Test
	public void fillDetails() 
	{	
	
		
		name.sendKeys("Sunil");
		emailId.sendKeys("sunil.kumar@bankit.in");
		
		dob.sendKeys("93-02-04");
		
		/*WebElement year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
		new Select(year).selectByVisibleText("1993");
		
		WebElement month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		new Select(month).selectByVisibleText("February");
		
		WebElement date=driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[5]/a[text()='4']"));
		date.click();*/
		
		pincode.sendKeys("201301");
		
		new Select(language).selectByVisibleText("English");
		
		/*driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		clear.click();*/
	}
}
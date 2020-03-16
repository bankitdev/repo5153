/**
 * 
 */
package com.ro.card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * @author Sunil Kashyap
 *
 * Created Date 09-Oct-2018
 */
public class IssueNewPhysicalCard 
{	
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement clickOnCardBtn;
	
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Issue New Physical Card']")
	WebElement clickOnIssueNewPhysicalCardBtn;
	
	@FindBy(id="email1")
	WebElement emailid;
	
	@FindBy(id="mobile1")
	WebElement mobileNo;
	
	@FindBy(id="fname")
	WebElement firstName;
	
	@FindBy(id="lname")
	WebElement lastName;
	
	@FindBy(id="address1")
	WebElement add1;
	
	@FindBy(id="address2")
	WebElement add2;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="pincode")
	WebElement pinCode;
	
	@FindBy(id="ovdNo")
	WebElement ovdNu;
	
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Submit']")
	WebElement submit;
	
	WebDriver driver;
	
	public IssueNewPhysicalCard(WebDriver driver) 
	{	
		this.driver=driver;
	}
	public void setUp() 
	{
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(clickOnCardBtn).click().perform();
		clickOnIssueNewPhysicalCardBtn.click();
	}
	public void issueNewPhysicalCardDetails(String eID,String MobNum) 
	{
		emailid.sendKeys(eID);
		mobileNo.sendKeys(MobNum);
		submit.click();
	}
	public void newPhysicalCardDetails(String swipeCard,String fname, String lname,String gen,String addr1,String addr2,
			String cty,String states,int pin,String pan,String ovd) 
	{
		new Select(driver.findElement(By.xpath("//select[@id='merchantTypeCard']"))).selectByVisibleText(swipeCard);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		new Select(driver.findElement(By.id("gender"))).selectByVisibleText(gen);
		driver.findElement(By.id("dob")).click();
		// select year
		new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"))).selectByVisibleText("1993");
		//select month of year
		new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"))).selectByVisibleText("Feb");
		// select date of month
		WebElement select_day=driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a[text()='4']"));
		select_day.click();
		add1.sendKeys(addr1);
		add2.sendKeys(addr2);
		city.sendKeys(cty);
		new Select(driver.findElement(By.id("state"))).selectByVisibleText(states);
		pinCode.sendKeys(String.valueOf(pin));
		new Select(driver.findElement(By.xpath("//span[@id='select2-ovdType-container']/span[contains(text(),'PAN Card')]"))).selectByVisibleText(pan);
		//driver.findElement(By.xpath("//span[@id='select2-ovdType-container']/span[contains(text(),'PAN Card')]"));
		ovdNu.sendKeys(ovd);
		//submit.click();
		
	}
}

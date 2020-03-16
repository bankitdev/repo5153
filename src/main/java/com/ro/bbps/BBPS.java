/**
 * 
 */
package com.ro.bbps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Sunil Kashyap
 *
 * Created Date 15-Jan-2019
 */
public class BBPS
{
	@FindBy(xpath="//a[contains(text(),'BBPS')]")
	WebElement clickOnBBPSLink;
	@FindBy(id="category")
	WebElement billerCategory;
	@FindBy(id="billerName")
	WebElement billerName;
	@FindBy(id="mobile")
	WebElement mobilNumber;
	@FindBy(id="customerId")
	WebElement consumerNumber;
	@FindBy(xpath="//input[@class='form_submit_btn' and @onclick='fetchBill();']")
	WebElement fetchBillBtn;
	@FindBy(id="payButton")
	WebElement payBill;
	
	WebDriver driver;
	
	public BBPS(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void initialize() 
	{
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(clickOnBBPSLink).click().perform();
	}
	
	public void enterBBPSDetails(String billCate,String billName,String mob, String conID) 
	{	
		billerCategory.click();
		new Select(billerCategory).selectByVisibleText(billCate);
		//billerName.click();
		new Select(driver.findElement(By.xpath("//select[@id='billerName']"))).selectByVisibleText(billName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mobilNumber.sendKeys(mob);
		consumerNumber.sendKeys(conID);
		fetchBillBtn.click();
		//payBill.click();
	}
	public void getText() 
	{
		WebElement textMsg=driver.findElement(By.id("errorMessage"));
		System.out.println(textMsg.getText());
	}
}

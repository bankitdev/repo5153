/**
 * 
 */
package com.ro.myaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Sunil Kashyap
 *
 * Created Date 08-Mar-2019
 */
public class AEPSTransactionStatement {
	
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle' and @type='button']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[contains(text(),'AEPS Transaction Statement')]")
	WebElement aepsTranStatemnt;
	
	@FindBy(xpath="//form[@name='AccountStmtReportForm']/table/tbody/tr/td[4]/a/img")
	WebElement frmdate;
	
	@FindBy(xpath="//form[@name='AccountStmtReportForm']/table/tbody/tr/td[8]/a/img")
	WebElement todate;
	
	@FindBy(id="img_btn")
	WebElement submitBtn;
	
	WebDriver driver;
	
	public AEPSTransactionStatement(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void clickOnAEPSTransStatmnt() 
	{
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(myAccount).click().build().perform();
		aepsTranStatemnt.click();
		
		frmdate.click();
		new Select(driver.findElement(By.id("selectMonth"))).selectByVisibleText("Feb");
		new Select(driver.findElement(By.id("selectYear"))).selectByVisibleText("2019");
		driver.findElement(By.xpath("//tbody[@id='calender']/tr/td[6]")).click();
		
		todate.click();
		new Select(driver.findElement(By.id("selectMonth"))).selectByVisibleText("Mar");
		new Select(driver.findElement(By.id("selectYear"))).selectByVisibleText("2019");
		driver.findElement(By.xpath("//tbody[@id='calender']/tr[2]/td[5]")).click();
		
		submitBtn.click();
	}
}

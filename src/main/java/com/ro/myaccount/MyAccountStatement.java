/**
 * 
 */
package com.ro.myaccount;

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
 * Created Date 23-Jan-2019
 */
public class MyAccountStatement 
{
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle' and @type='button']")
	WebElement myAccount;
	@FindBy(xpath="//div[@class='col-md-2 my_account noP']/div/ul/li/a[contains(text(),'My Account Statement')]")
	WebElement myAccountStatement;
	@FindBy(xpath="//form[@name='AccountStmtForm']/table/tbody/tr/td[4]/a/img")
	WebElement fdate;
	@FindBy(xpath="//form[@name='AccountStmtForm']/table/tbody/tr/td[8]/a/img")
	WebElement tdate;
	@FindBy(xpath="//input[@id='img_btn' and @value='Submit']")
	WebElement submitBtn;
	WebDriver driver;
	
	public MyAccountStatement(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void initializeProcess() 
	{	
		
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(myAccount).click().build().perform();
		myAccountStatement.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		fdate.click();
		new Select(driver.findElement(By.id("selectMonth"))).selectByVisibleText("Jan");
		new Select(driver.findElement(By.id("selectYear"))).selectByVisibleText("2019");
		//new Select(driver.findElement(By.xpath("//tbody[@id='calender']/tr/td[3]"))).selectByVisibleText("1");
		driver.findElement(By.xpath("//tbody[@id='calender']/tr/td[3]")).click();
		tdate.click();
		new Select(driver.findElement(By.id("selectMonth"))).selectByVisibleText("Jan");
		new Select(driver.findElement(By.id("selectYear"))).selectByVisibleText("2019");
		//new Select(driver.findElement(By.xpath("//tbody[@id='calender']/tr[3]/td[4]"))).selectByVisibleText("16");
		driver.findElement(By.xpath("//tbody[@id='calender']/tr[3]/td[4]")).click();
		
		submitBtn.click();
	}
	public void verifySizeAndText() 
	{
		int fdateHeight=fdate.getSize().getHeight();
		int fdateWidth=fdate.getSize().getWidth();
		System.out.println("The From date textfield Height is"+fdateHeight+" The From date textfield Width is"+fdateWidth);
		
		int tdateHeight=tdate.getSize().getHeight();
		int tdateWidth=tdate.getSize().getWidth();
		System.out.println("The To date textfield Height is"+tdateHeight+" The To date textfield Width is"+tdateWidth);
		
		int submitBtnHeight=submitBtn.getSize().getHeight();
		int submitBtnWidth=submitBtn.getSize().getWidth();
		System.out.println("The Submit Button Height is"+submitBtnHeight+" The Submit Button Width is"+submitBtnWidth);
		String submitBtntxt=submitBtn.getAttribute("value");
		if(submitBtntxt.equals("Submit")) {System.out.println("The Submit btn text is matched");}
		else {System.out.println("The Submit btn text is not matched");}
	}
}

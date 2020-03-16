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
 * Created Date 17-Jan-2019
 */
public class DownloadReports
{
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle' and @type='button']")
	WebElement myAccount;
	@FindBy(xpath="//div[@class='col-md-2 my_account noP']/div/ul/li/a[contains(text(),'Download Reports')]")
	WebElement downloadReports;
	@FindBy(xpath="//form[@name='AccountStmtReportForm']/table/tbody/tr/td[4]/a/img")
	WebElement fdate;
	@FindBy(xpath="//form[@name='AccountStmtReportForm']/table/tbody/tr/td[8]/a/img")
	WebElement tdate;
	@FindBy(xpath="//input[@id='img_btn' and @value='Submit']")
	WebElement submitBtn;
	@FindBy(xpath="//input[@id='img_btn' and @value='Download']")
	WebElement downloadBtn;
	WebDriver driver;
	
	public DownloadReports(WebDriver driver) 
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
		actions.moveToElement(myAccount).click().build().perform();
		downloadReports.click();

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
		/*driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		downloadBtn.click();*/
		
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

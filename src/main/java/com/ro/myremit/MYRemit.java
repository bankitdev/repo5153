package com.ro.myremit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ro.Base.LoginPage;

/**
 * @author Sunil Kashyap
 *
 * Created Date 27-Sep-2018
 */
public class MYRemit extends LoginPage
{
	public MYRemit() throws Exception{
		super();
	}
	public void myremitLogin() throws Exception 
	{	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// click/action on the 'MYREMIT' head menu
		WebElement myremit=driver.findElement(By.xpath("//a[contains(text(),'MYRemit')]"));
		Actions action=new Actions(driver);
		action.click(myremit).build().perform();    
		
		String[] numArr= {"1234567890","8512001213"};
		for(int i=0;i<numArr.length;i++)
		{
			String num=numArr[i];
			WebElement mobile_number=driver.findElement(By.id("mobile_no"));
			WebElement submitButton=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Submit' ]"));
			WebElement clearButton=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Clear']"));
			Thread.sleep(2000);
			if(num.equals("1234567890")) 
			{
				mobile_number.sendKeys(num);
				clearButton.click();
			}
			else if(num.equals("8512001213"))
			{
				mobile_number.sendKeys(num);
				submitButton.click();
				Thread.sleep(2000);
				//submitButton.click();
				break;
			}
		}
	}
	public static void main(String[] args) throws Exception 
	{
		MYRemit myremit=new MYRemit();
		myremit.myremitLogin();
	}
}

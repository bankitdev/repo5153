package com.ro.fastagLocal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ro.Base.Set_PathLocal;
import com.ro.util.ValidationAndVerification;

public class FastagLocal extends Set_PathLocal
{	
	public ValidationAndVerification validationAndVerification;
	
	public FastagLocal() throws Exception 
	{		
		

		Set_PathLocal.setPathLocal();
		if(LoginPage()) 
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='popup2']/div/div/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='popup3']/div/div/button")).click();
			Thread.sleep(2000);
			fastag();
			Thread.sleep(2000);
			
			String[] numbArr= {"8512001213","7865687656"};

			for(int i=0;i<numbArr.length;i++) 
			{
				String num=numbArr[i];

				if(getDetailsButton(num))
				{
					if(num.equals(num)) 
					{	
						Thread.sleep(2000);
						Recharge_Detail recharge_Datail=new Recharge_Detail(driver);
						recharge_Datail.recharge_Now();
					}
					else if(num.equals(num))
					{
						clearButton();
						Thread.sleep(2000);
						verifyOTP();
						Thread.sleep(2000);
						New_Registration_Local new_Registration_Local=new New_Registration_Local(driver);		
						new_Registration_Local.newRegistration();
					}
				}
				else
				{
					break;
				}
			}
		}
		else 
		{
			WebElement text=driver.findElement(By.xpath("//div[@class='col-md-5 col-md-offset-7']/form/p/strong"));  //invalid username and password
			System.out.println(text.getText());
		}
		


	}
	public boolean LoginPage() 
	{
		driver.switchTo().frame("Main");
		
		String userName="8512001213";
		String password="Yahoo@123";
		
		if(userName.equals("8512001213") && password.equals("Yahoo@123")) 
		{
			driver.findElement(By.name("userName")).sendKeys(userName);
			driver.findElement(By.name("pass")).sendKeys(password);
			driver.findElement(By.id("login")).click(); 
		    return true;
		}
		else 
		{		
			driver.findElement(By.name("userName")).sendKeys(userName);
			driver.findElement(By.name("pass")).sendKeys(password);
			driver.findElement(By.id("login")).click(); 
			return false;
		}
	}
	public void fastag() 
	{	
		WebElement fastag=driver.findElement(By.xpath("//div[@id='head_menu']//ul//li//a[text()='FASTAG']"));
		Actions action=new Actions(driver);
		action.moveToElement(fastag).click().perform();
	}
	public void clearButton() 
	{
		driver.findElement(By.id("mobile")).sendKeys("1234567890");
		WebElement bankName=driver.findElement(By.id("bankId"));
		Select selectBankName=new Select(bankName);
		selectBankName.selectByVisibleText("HDFC");

		driver.findElement(By.xpath("//input[@value='Clear']")).click();
	}
	public boolean getDetailsButton(String num) 
	{
		WebElement mobileNumber=driver.findElement(By.id("mobile"));
		mobileNumber.sendKeys(num); 
		
		if(validationAndVerification.validNumber(num))
		{   
			/*String hdfcBank="HDFC";
			String saraswatBank="SARASWAT";
			
			if(hdfcBank.equals("HDFC")) 
			{*/
				new Select(driver.findElement(By.id("bankId"))).selectByVisibleText("HDFC");
			/*	return true;
			}else if(saraswatBank.equals("SARASWAT"))
			{*/
				new Select(driver.findElement(By.id("bankId"))).selectByVisibleText("SARASWAT");
				/*verifyOTP();
				return true;
			}else {}*/
			driver.findElement(By.xpath("//input[@class='form_submit_btn_new' or @onclick='getTagDetail();']")).click();	
			System.out.println("Test case passed______Valid Mobile number");
			return true;
		}else
		{
			driver.findElement(By.id("mobileno")); 
			System.out.println("Test case not passed______invalid Mobile number");
			return false;
		}
	}

	public void verifyOTP() 
	{
		WebElement otpText=driver.findElement(By.id("otpmob"));
		String otpValue = otpText.getText();
		System.out.println("The OTP is "+otpValue);
		WebElement enterOtpField=driver.findElement(By.xpath("//input[@id='otp' and @class='particularsText']"));
		enterOtpField.clear();
		enterOtpField.sendKeys(otpValue);
	}
	public static void main(String args[]) throws Exception 
	{
		new FastagLocal();
	}

}

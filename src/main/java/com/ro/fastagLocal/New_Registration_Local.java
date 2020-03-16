package com.ro.fastagLocal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class New_Registration_Local
{	
	public WebDriver driver;
	
	public New_Registration_Local() 
	{
		super();	
	}

	public New_Registration_Local(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void newRegistration() throws Exception 
	{
		driver.findElement(By.xpath("//input[@class='form_submit_btn_new' and @value='Verify OTP']")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("scroll(0,600)", "");
		
		driver.findElement(By.id("name")).sendKeys("BankIt");
		driver.findElement(By.id("email")).sendKeys("abc@bankit.in");
		
		new Select(driver.findElement(By.id("gender"))).selectByVisibleText("Female");
		
		//new Select(driver.findElement(By.id("bankId"))).selectByVisibleText("HDFC");
		
		driver.findElement(By.xpath("//input[@id='vehicleNo']")).sendKeys("12423546");
		
		driver.findElement(By.id("address")).sendKeys("Noida");
		driver.findElement(By.id("aadhaar")).sendKeys("242567698454");
		
		driver.findElement(By.xpath("//input[@id='aadhaarImage']")).sendKeys("C:\\Users\\admin\\eclipse-workspace\\RO_Portal\\screenshots\\image.png");
		
		driver.findElement(By.id("panNo")).sendKeys("NFBDG53453");
		
		driver.findElement(By.id("panImage")).sendKeys("C:\\Users\\admin\\eclipse-workspace\\RO_Portal\\screenshots\\image.png");
		driver.findElement(By.id("rcImage")).sendKeys("C:\\Users\\admin\\eclipse-workspace\\RO_Portal\\screenshots\\image.png");
		driver.findElement(By.id("custImage")).sendKeys("C:\\Users\\admin\\eclipse-workspace\\RO_Portal\\screenshots\\image.png");
		
		Thread.sleep(3000);
		driver.findElement(By.id("submit")).click();
	}
}

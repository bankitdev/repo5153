package com.ro.fastagLocal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Recharge_Detail
{	
	public WebDriver driver;
	public Recharge_Detail() 
	{
		super();
	}
	public Recharge_Detail(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void recharge_Now() throws Exception 
	{	
		WebElement enterBalance=driver.findElement(By.xpath("//input[@id='amount']"));  
		enterBalance.sendKeys("100");                                                    //enter the  value in amount field 
		String amount=enterBalance.getAttribute("value");
		System.out.println("Recharge amount is "+amount);                                  //print the value from amount field 
		
		WebElement actualBalance=driver.findElement(By.xpath("//div[@id='header']//div//p//span[contains(text(),'Balance ')]//strong"));
		String value1 = actualBalance.getText();
		System.out.println("The Actual Balance is "+value1);                           //print actual balance
		int amountX=Integer.parseInt(value1);


		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='form_submit_btn_new' and @value='Recharge']")).click();  //click on Recharges button 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='form_submit_btn_new' and @value='Cancel']")).click();
		
		WebElement currentBalance=driver.findElement(By.xpath("//div[@id='header']//div//p//span[contains(text(),'Balance ')]//strong"));
		String value = currentBalance.getText();
		System.out.println("The Expected Balance is "+value);                // print expected balance 
		int valuex=Integer.parseInt(value);

		int deductionBalance=amountX-valuex;    							//deduction balance
		System.out.println("The deduction Balance is "+deductionBalance);
		
		
	}	
}

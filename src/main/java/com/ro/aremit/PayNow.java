package com.ro.aremit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayNow 
{	
	public WebDriver driver;
	public PayNow() 
	{
		super();
	}
	public PayNow(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void payNow() throws Exception 
	{	
		System.out.println("--------------------Pay NOw Button Actions------------------");
		Thread.sleep(2000);
		WebElement payNow=driver.findElement(By.id("payifsc1"));
		int payNowHeight=payNow.getSize().getHeight();
		int payNowWidth=payNow.getSize().getWidth();
		System.out.println("The Height of Pay Now Button is "+payNowHeight+"The Width of Pay Now Button is"+payNowWidth);
		String payNowText=payNow.getText();
		if(payNowText.equals("PAY NOW")) {
			System.out.println(" Pay Now Text is matched");
			payNow.click();
		}else{System.out.println(" Pay Now Text is not matched");}
		
		WebElement transAmt=driver.findElement(By.id("amount"));
		int transAmtHeight=transAmt.getSize().getHeight();
		int transAmtWidth=transAmt.getSize().getWidth();
		System.out.println("The Height of Transfer Amount textfield is "+transAmtHeight+"The Width of Transfer Amount textfield is"+transAmtWidth);
		transAmt.sendKeys("100");
		
		WebElement fee=driver.findElement(By.id("charge"));
		int feeHeight=fee.getSize().getHeight();
		int feeWidth=fee.getSize().getWidth();
		System.out.println("The Height of Bankit fee textfield is "+feeHeight+"The Width of Bankit fee textfield is"+feeWidth);
		fee.sendKeys("2");
		
		WebElement totalAmount=driver.findElement(By.id("tamt"));
		int totalAmountHeight=totalAmount.getSize().getHeight();
		int totalAmountWidth=totalAmount.getSize().getWidth();
		System.out.println("The Height of Total Amount textfield is "+totalAmountHeight+"The Width of Total Amount textfield is"+totalAmountWidth);
		totalAmount.click();
		System.out.println("The Total pay now amount is "+totalAmount.getAttribute("value"));
		
		WebElement remark=driver.findElement(By.id("remark"));
		int remarkHeight=remark.getSize().getHeight();
		int remarkWidth=remark.getSize().getWidth();
		System.out.println("The Height of Remark textfield is "+remarkHeight+"The Width of Remark textfield is"+remarkWidth);
		remark.sendKeys("Testing");
		
		WebElement neftRadioBtn=driver.findElement(By.xpath("//input[@name='channel' and @value='NEFT']"));
		neftRadioBtn.click();
		boolean status=neftRadioBtn.isSelected();
		System.out.println("The NEFT radio button is selected "+status);
		
		boolean status1=driver.findElement(By.xpath("//input[@name='channel' and @value='NEFT']")).isEnabled();
		if(status1) {System.out.println("NEFT radion btn is enable");}
		else {System.out.println("NEFT radion btn is not enable");}
		
		boolean status2=driver.findElement(By.xpath("//input[@name='channel' and @value='IMPS']")).isEnabled();
		if(status2) {System.out.println("IMPS radion btn is enable");}
		else {System.out.println("IMPS radion btn is not enable");}
		
		
		WebElement payNowBtn=driver.findElement(By.xpath("//input[@id='img_btn' and @value='Pay Now']"));
		int payNowBtnHeight=payNowBtn.getSize().getHeight();
		int payNowBtnWidth=payNowBtn.getSize().getWidth();
		System.out.println("The Height of Cancel Button is "+payNowBtnHeight+"The Width of Cancel Button is"+payNowBtnWidth);
		String payNowBtnText=payNowBtn.getAttribute("value");
		if(payNowBtnText.equals("Pay Now")) {
			System.out.println("Pay Now Text is matched");
			payNowBtn.click();
		}else{System.out.println("Pay Now Text is not matched");}
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='form_row form-success']")).getText());
	}
}

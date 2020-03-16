/**
 * 
 */
package com.ro.Base;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * @author Sunil Kashyap
 *
 * Created Date 28-Mar-2019
 */
public class Footer {
	
	@FindBy(xpath="//a[contains(@href,'https://www.facebook.com/bankit.in/')]")
	WebElement facebook;
	@FindBy(xpath="//a[contains(@href,'https://www.linkedin.com/company/13403608/')]")
	WebElement linkedin;
	@FindBy(xpath="//a[contains(@href,'https://twitter.com/BankIT_India')]")
	WebElement twitter;
	@FindBy(xpath="//a[contains(@href,'https://play.google.com/store/apps/details?id=in.bankitagent')]")
	WebElement playStore;
	@FindBy(xpath="//a[contains(@href,'https://www.youtube.com/c/BANKITIndia')]")
	WebElement youtube;
	
	WebDriver driver;
	
	public Footer(WebDriver driver) {
		this.driver=driver;
	}
	
	public void supportText() 
	{	
		//driver.switchTo().frame("Main");
		((JavascriptExecutor)driver).executeScript("scroll(0,900)");
		
		System.out.println("===========================Support====================================");
		
		WebElement strvalue = driver.findElement(By.xpath("//h4[text()='Support']"));
		String exprslt = "Support";
		String actrslt=strvalue.getText();
		Assert.assertEquals(actrslt, exprslt);
		System.out.println(actrslt);
		System.out.println("Support text is matched. Test Case passed");
		System.out.println("-----------------------------------------------------");
			
		WebElement emailtxt=driver.findElement(By.xpath("//h5[contains(text(),'support@bankit.in')]"));
		String emailactltxt=emailtxt.getText();
		String emailexptxt="   support@bankit.in";
		Assert.assertEquals(emailactltxt, emailexptxt);
		System.out.println(emailactltxt);
		System.out.println("Email id - support@bankit.in text is matched. Test Case passed");
		System.out.println("-----------------------------------------------------");
		
		WebElement phonrNumbertxt=driver.findElement(By.xpath("//h5[contains(text(),'180030109585')]"));
		String actlphonrNumbertxt=phonrNumbertxt.getText();
		String expdphonrNumbertxt="   180030109585";
		Assert.assertEquals(actlphonrNumbertxt, expdphonrNumbertxt);
		System.out.println(actlphonrNumbertxt);
		System.out.println("Phone Number - 180030109585 is matched. Test Case passed");
		
		
	}
	public void biometricDeviceSupportforMorpho() {
		
		System.out.println("=======================Biometric Device Support for Morpho=====================================");
		WebElement text=driver.findElement(By.xpath("//h4[contains(text(),'Biometric Device Support for Morpho ')]"));
		String actltext=text.getText();
		String expdtext="Biometric Device Support for Morpho";
		Assert.assertEquals(actltext, expdtext);
		System.out.println(actltext);
		System.out.println("Title is"+ actltext+" matched. Test Case passed");
		System.out.println("-----------------------------------------------------");
		
		WebElement emailtxt=driver.findElement(By.xpath("//h5[contains(text(),'support@rdserviceonline.com')]"));
		String actlemailtxt=emailtxt.getText();
		String expdemailtxt="   support@rdserviceonline.com";
		Assert.assertEquals(actlemailtxt, expdemailtxt);
		System.out.println(actlemailtxt);
		System.out.println("Email id - "+actlemailtxt+" is matched. Test Case passed");
		System.out.println("-----------------------------------------------------");
		
		WebElement phonrNumbertxt=driver.findElement(By.xpath("//h5[contains(text(),'0120 - 4882100')]"));
		String actlphonrNumbertxt=phonrNumbertxt.getText();
		String expdphonrNumbertxt="   0120 - 4882100";
		Assert.assertEquals(actlphonrNumbertxt, expdphonrNumbertxt);
		System.out.println(actlphonrNumbertxt);
		System.out.println("Phone Number "+actlemailtxt+" is matched. Test Case passed");
		
	}
	public void biometricDeviceSupportforMantra() {
		
		System.out.println("===========================Biometric Device Support for Mantra====================================");

		
		WebElement text=driver.findElement(By.xpath("//h4[contains(text(),'Biometric Device Support for Mantra')]"));
		String actltext=text.getText();
		String expdtext="Biometric Device Support for Mantra";
		Assert.assertEquals(actltext, expdtext);
		System.out.println(actltext);
		System.out.println("Title is"+ actltext+" matched. Test Case passed");
		System.out.println("-----------------------------------------------------");
		
		WebElement emailtxt=driver.findElement(By.xpath("//h5[contains(text(),'servico@mantratec.com')]"));
		String actlemailtxt=emailtxt.getText();
		String expdemailtxt="   servico@mantratec.com";
		Assert.assertEquals(actlemailtxt, expdemailtxt);
		System.out.println(actlemailtxt);
		System.out.println("Email id - "+actlemailtxt+" is matched. Test Case passed");
		System.out.println("-----------------------------------------------------");
		
		WebElement phonrNumbertxt=driver.findElement(By.xpath("//h5[contains(text(),'+91-079-49068000/ 1')]"));
		String actlphonrNumbertxt=phonrNumbertxt.getText();
		String expdphonrNumbertxt="   +91-079-49068000/ 1";
		Assert.assertEquals(actlphonrNumbertxt, expdphonrNumbertxt);
		System.out.println(actlphonrNumbertxt);
		System.out.println("Phone Number "+actlemailtxt+" is matched. Test Case passed");
		
	}
	public void openFooterLinks() {
		
		System.out.println("================================Connect with us/BankIT on Mobile/© Copyright 2015, BankIT======================");

		
		WebElement connectwithusText=driver.findElement(By.xpath("//h4[contains(text(),'Connect with us')]"));
		String actlconnectwithusTextMsg=connectwithusText.getText();
		String ExpcdconnectwithusTextMsg="Connect with us";
		Assert.assertEquals(actlconnectwithusTextMsg, ExpcdconnectwithusTextMsg);
		System.out.println(actlconnectwithusTextMsg);
		System.out.println("Title "+actlconnectwithusTextMsg+" is matched. Test Case is passed");
		System.out.println("-----------------------------------------------------");
		
		WebElement bankITonMobileText=driver.findElement(By.xpath("//h4[contains(text(),'BankIT on Mobile')]"));
		String actlbankITonMobileTextMsg=bankITonMobileText.getText();
		String ExpcdbankITonMobileTextMsg="BankIT on Mobile";
		Assert.assertEquals(actlbankITonMobileTextMsg, ExpcdbankITonMobileTextMsg);
		System.out.println(actlbankITonMobileTextMsg);
		System.out.println("Title "+actlbankITonMobileTextMsg+" is matched. Test Case is passed");
		System.out.println("-----------------------------------------------------");
		
		WebElement copyrightBankITText=driver.findElement(By.xpath("//p[contains(text(),'© Copyright 2015, BankIT')]"));
		String actlcopyrightBankITTextMsg=copyrightBankITText.getText();
		String ExpcdcopyrightBankITTextMsg="© Copyright 2015, BankIT";
		Assert.assertEquals(actlcopyrightBankITTextMsg, ExpcdcopyrightBankITTextMsg);
		System.out.println(actlcopyrightBankITTextMsg);
		System.out.println("Title "+actlcopyrightBankITTextMsg+" is matched. Test Case is passed");

		
		ArrayList<String> list = new ArrayList<String>();

		list.add("facebook");
		list.add("linkedin");
		list.add("twitter");
		list.add("playStore");
		list.add("youtube");
		
		for (int i = 0; i < list.size(); i++) 
		{
			String linksList = (String) list.get(i);

			if (linksList.equals("facebook")) 
			{
				facebook.click();
			} else if (linksList.equals("linkedin")) 
			{
				linkedin.click();
			} else if (linksList.equals("twitter")) 
			{
				twitter.click();
			} else if (linksList.equals("playStore")) 
			{
				playStore.click();
			} else if (linksList.equals("youtube")) 
			{
				youtube.click();
			} else {
				System.out.println("Something went Wrong");
			}
		}
		
		System.out.println("-----------------------------------------------------");
		System.out.println("--------All footer links opened------------");
	}

}

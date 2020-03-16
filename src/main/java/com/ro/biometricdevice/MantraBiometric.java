/**
 * 
 */
package com.ro.biometricdevice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Sunil Kashyap
 *
 * Created Date 20-Dec-2018
 */
public class MantraBiometric
{
	@FindBy(xpath="//a[contains(text(),'BIOMETRIC DEVICES')]")
	WebElement biometricDevicesLink;
	
	@FindBy(xpath="//a[contains(text(),'Mantra MFS 100')]")
	WebElement mantra;
	
	@FindBy(id="deviceQty")
	WebElement quantity;
	
	@FindBy(id="gststatus")
	WebElement gstDetails;
	
	@FindBy(id="companyName")
	WebElement cName;
	
	@FindBy(id="panNumber")
	WebElement panNumber;
	
	@FindBy(id="gstRegNo")
	WebElement gstRegNo;
	
	@FindBy(id="businessAddr")
	WebElement bussinessAddr;
	
	@FindBy(id="deliverTo")
	WebElement shopName;
	
	@FindBy(id="emailId")
	WebElement emailID;
	
	@FindBy(id="mobileNum")
	WebElement mobileNumber;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(name="country")
	WebElement countryName;
	
	@FindBy(name="state")
	WebElement stateName;
	
	@FindBy(id="officeDist")
	WebElement distName;
	
	@FindBy(xpath="//input[@id='img_btn' and @value='Confirm Order']")
	WebElement confirmOrder;
	
	WebDriver driver;
	
	public MantraBiometric(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void morphoBiometricLink() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(biometricDevicesLink).perform();
		mantra.click();
	}
	public void enterQuantity(int qau) 
	{
		quantity.sendKeys(String.valueOf(qau));
	}
	public void gstDetails() 
	{
		new Select(gstDetails).selectByVisibleText("YES");
	}
	public void companyName(String comName)
	{
		cName.sendKeys(comName);
	}
	public void enterPanNumber(String panNo) 
	{
		panNumber.sendKeys(panNo);
	}
	public void gstRegistrationNumber(long gstRegNum) 
	{
		gstRegNo.sendKeys(String.valueOf(gstRegNum));
	}
	public void principalPlaceOfBussiness(String ppBussi) 
	{
		bussinessAddr.sendKeys(ppBussi);
	}
	public void shopName(String sName)
	{
		shopName.sendKeys(sName);
	}
	public void emailID(String eID) 
	{
		emailID.sendKeys(eID);
	}
	public void mobileNu(String mob)
	{
		mobileNumber.sendKeys(mob);
	}
	public void add1(String addr1) 
	{
		address1.sendKeys(addr1);
	}
	public void add2(String add2) 
	{
		address2.sendKeys(add2);
	}
	public void countryName(String contName) 
	{
		new Select(countryName).selectByVisibleText(contName);
	}
	public void stateName(String sName) 
	{
		new Select(stateName).selectByVisibleText(sName);
	}
	public void disName(String distname) 
	{
		new Select(distName).selectByVisibleText(distname);
	}
	public void submitButton() 
	{
		confirmOrder.click();
	}
	public void verifySizeAndText() 
	{
		int quantityHeight=quantity.getSize().getHeight();
		int quantityWidth=quantity.getSize().getWidth();
		System.out.println("The Quantity textfield Height is "+quantityHeight+" The Quantity textfield Width is "+quantityWidth);
		
		int gstDetailsHeight=gstDetails.getSize().getHeight();
		int gstDetailsWidth=quantity.getSize().getWidth();
		System.out.println("The GST Details textfield Height is "+gstDetailsHeight+" The GST Details textfield  Width is "+gstDetailsWidth);
		
		int cNameHeight=cName.getSize().getHeight();
		int cNameWidth=cName.getSize().getWidth();
		System.out.println("The Company NAme textfield Height is "+cNameHeight+" The Company Name textfield Width is "+cNameWidth);
		
		int panNumberHeight=panNumber.getSize().getHeight();
		int panNumberWidth=panNumber.getSize().getWidth();
		System.out.println("The pan Number textfield Height is "+panNumberHeight+" The pan Number textfield Width is "+panNumberWidth);
		
		int gstRegNoHeight=gstRegNo.getSize().getHeight();
		int gstRegNoWidth=gstRegNo.getSize().getWidth();
		System.out.println("The GST Registration Number textfield Height is "+gstRegNoHeight+" The GST Registration Number textfield Width is "+gstRegNoWidth);
		
		int bussinessAddrHeight=bussinessAddr.getSize().getHeight();
		int bussinessAddrWidth=bussinessAddr.getSize().getWidth();
		System.out.println("The Principal Place Business textfield Height is "+bussinessAddrHeight+" The Principal Place Business textfield Width is "+bussinessAddrWidth);
		
		int emailIDHeight=emailID.getSize().getHeight();
		int emailIDWidth=emailID.getSize().getWidth();
		System.out.println("The Email Id textfield Height is "+emailIDHeight+" The Email Id textfield Width is "+emailIDWidth);
		
		
	}
}

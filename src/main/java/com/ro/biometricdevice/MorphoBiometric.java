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
 * Created Date 18-Dec-2018
 */
public class MorphoBiometric 
{
	@FindBy(xpath="//a[contains(text(),'BIOMETRIC DEVICES')]")
	WebElement biometricDevicesLink;
	
	@FindBy(xpath="//a[contains(text(),'Morpho MSO 1300 E3')]")
	WebElement morpho;
	
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
	
	@FindBy(xpath="//input[@id='img_btn' and @value='Cancel Order']")
	WebElement cancelOrder;
	
	WebDriver driver;
	
	public MorphoBiometric(WebDriver driver) 
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
		morpho.click();
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
	public void gstRegistrationNumber(int gstRegNum) 
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
		System.out.println("The enter quantity Height is "+quantityHeight+"The enter quantity Width is "+quantityWidth);
		
		int cNameHeight=cName.getSize().getHeight();
		int cNameWidth=cName.getSize().getWidth();
		System.out.println("The Comapany Name Height is "+cNameHeight+"The Company Name Width is "+cNameWidth);
		
		int panNumberHeight=panNumber.getSize().getHeight();
		int panNumberWidth=panNumber.getSize().getWidth();
		System.out.println("The Pan Number  Height is "+panNumberHeight+"The Pan Number Width is "+panNumberWidth);
		
		int gstDetailsHeight=gstDetails.getSize().getHeight();
		int gstDetailsWidth=gstDetails.getSize().getWidth();
		System.out.println("The GST Reg No Height is "+gstDetailsHeight+"The GST Reg. No Width is "+gstDetailsWidth);
		
		int bussinessAddrHeight=bussinessAddr.getSize().getHeight();
		int bussinessAddrWidth=bussinessAddr.getSize().getWidth();
		System.out.println("The Business Addr Height is "+bussinessAddrHeight+"The Business Addr Width is "+bussinessAddrWidth);
		
		int shopNameHeight=shopName.getSize().getHeight();
		int shopNameWidth=shopName.getSize().getWidth();
		System.out.println("The Shop Name Height is "+shopNameHeight+"The Shop Name Width is "+shopNameWidth);
		
		int cancelOrderHeight=cancelOrder.getSize().getHeight();
		int cancelOrderWidth=cancelOrder.getSize().getWidth();
		System.out.println("The Cancel Order Height is "+cancelOrderHeight+"The Cancel Order Width is "+cancelOrderWidth);
		String cancelOrdertxt=cancelOrder.getText();
		if(cancelOrdertxt.equals("Cancel Order")) {
			System.out.println("The Cancel Order Button text is matched");
		}else {System.out.println("The Cancel Order Button text is not matched");}
		
		int confirmOrderHeight=confirmOrder.getSize().getHeight();
		int confirmOrderWidth=confirmOrder.getSize().getWidth();
		System.out.println("The confirm Order Height is "+confirmOrderHeight+"The confirmOrder Width is "+confirmOrderWidth);
		String confirmOrdertxt=cancelOrder.getText();
		if(confirmOrdertxt.equals("Confirm Order")) {
			System.out.println("The Continue Order Button text is matched");
		}else {System.out.println("The Continue Order Button text is not matched");}
	}
}

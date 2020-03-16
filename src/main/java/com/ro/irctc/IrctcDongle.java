/**
 * 
 */
package com.ro.irctc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 20-Dec-2018
 */
public class IrctcDongle
{
	@FindBy(xpath="//li[@class='dropdown-toggle']/a[contains(text(),'IRCTC')]")
	WebElement irctcBtnLink;
	
	@FindBy(xpath="//a[contains(text(),'IRCTC DONGLE')]")
	WebElement irctcDongle;
	
	@FindBy(id="address")
	WebElement shipmentAddr;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="pincode")
	WebElement pincode;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="bt-confirm")
	WebElement confirmOrder;
	
	@FindBy(id="img_btn")
	WebElement cancelBtn;
	
	WebDriver driver;
	
	public IrctcDongle(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void irctcDongleLink() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(irctcBtnLink).perform();
		irctcDongle.click();
	}
	public void process(String address,String selState,String selCity,int pin,String eID)
	{
		String[] buttons= {"Cancel","ConfOrder"};
		for(int i=0;i<buttons.length;i++)
		{
			String btn=buttons[i];
			
			shipmentAddr.sendKeys(address);
			state.sendKeys(selState);
			city.sendKeys(selCity);
			pincode.sendKeys(String.valueOf(pin));
			emailId.sendKeys(eID);
			
			if(btn.equals("Cancel")) {
				cancelBtn.click();
			}else{confirmOrder.click();
			driver.findElement(By.id("jqDialog_yes")).click();  					//handle popup
			}		
		}
	}
	public void verifySizeAndText() 
	{	
		// size of Shipment Address textfield
		int shipmentAddrHeight=shipmentAddr.getSize().getHeight();
		int shipmentAddrWidth=shipmentAddr.getSize().getWidth();
		System.out.println("The Shipment Address textfield Height is "+shipmentAddrHeight+" The Shipment Address textfield Width is "+shipmentAddrWidth);
		
		//size of state textfield
		int stateHeight=state.getSize().getHeight();
		int stateWidth=state.getSize().getWidth();
		System.out.println("The State textfield Height is "+stateHeight+" The State textfield Width is "+stateWidth);
		
		//size of city textfield
		int cityHeight=city.getSize().getHeight();
		int cityWidth=city.getSize().getWidth();
		System.out.println("The city textfield Height is "+cityHeight+" The city textfield Width is "+cityWidth);
		
		//size of pincode textfield
		int pincodeHeight=pincode.getSize().getHeight();
		int pincodeWidth=pincode.getSize().getWidth();
		System.out.println("The pincode textfield Height is "+pincodeHeight+" The pincode textfield Width is "+pincodeWidth);
		
		//size of emailId textfield
		int emailIdHeight=emailId.getSize().getHeight();
		int emailIdWidth=emailId.getSize().getWidth();
		System.out.println("The emailId textfield Height is "+emailIdHeight+" The emailId textfield Width is "+emailIdWidth);
		
		//size and text of Confirm button
		int confirmOrderHeight=confirmOrder.getSize().getHeight();
		int confirmOrderWidth=confirmOrder.getSize().getWidth();
		System.out.println("The confirmOrder Button Height is "+confirmOrderHeight+" The confirmOrder Button Width is "+confirmOrderWidth);
		String confirmOrdertxt=confirmOrder.getText();
		if(confirmOrdertxt.equals("Confirm Order")) {
			System.out.println("Confirm Order btn text is matched");
		}else {System.out.println("Confirm Order btn text is matched");}
		
		//size and text of Cancel Button
		int cancelBtnHeight=cancelBtn.getSize().getHeight();
		int cancelBtnWidth=cancelBtn.getSize().getWidth();
		System.out.println("The cancelBtn  Height is "+cancelBtnHeight+" The cancelBtn Width is "+cancelBtnWidth);
		String cancelBtnText=cancelBtn.getText();
		System.out.println(cancelBtnText);
		if(cancelBtnText.equals("Cancel Order")) {
			System.out.println("Cancel Btn text is matched");
		}else {System.out.println("Cancel Btn text is not matched");}
	}
}

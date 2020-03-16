/**
 * 
 */
package com.ro.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Sunil Kashyap
 *
 * Created Date 12-Dec-2018
 */
public class Water {
	
	@FindBy(xpath="//a[contains(text(),'UTILITY')]")
	WebElement utility;
	
	@FindBy(xpath="//a[contains(text(),'Water')]")
	WebElement clickOnWaterBtn;
	
	@FindBy(id="reliance_energy_water")
	WebElement operatorName;
	
	@FindBy(id="acclen")
	WebElement rrNumber;
	
	@FindBy(name="EmailId")
	WebElement emailId;
	
	@FindBy(name="contact")
	WebElement contactNumber;
	
	@FindBy(xpath="(//input[@name='ElecBillAmount'])[3]")
	WebElement billAmount;
	
	@FindBy(xpath="//button[@id='img_btn3' and @onclick='WaterFormValidate(event)']")
	WebElement continueBtn;
	
	WebDriver driver;
	
	public Water(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void clickOnWaterBtn() 
	{
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(utility).click().build().perform();
		clickOnWaterBtn.click();
		
		int waterBtnHeight=clickOnWaterBtn.getSize().getHeight();
		int waterBtnWidth=clickOnWaterBtn.getSize().getWidth();
		System.out.println("The Water Button Hieght is "+waterBtnHeight+" The Water Button Width is "+waterBtnWidth);
	}
	/*public void selectOperatorName() 
	{
		new Select(operatorName).selectByVisibleText("HYDERABAD METROPOLITAN WATER SUPPLY");
	}
	public void enterRRNumber(String rrnum) 
	{
		rrNumber.sendKeys(rrnum);
	}
	public void enterEmailId(String eID) 
	{
		emailId.sendKeys(eID);
	}
	public void enterContactNum(String ContNum) 
	{
		contactNumber.sendKeys(ContNum);
	}
	public void enterBillAmount(String bAmount) 
	{
		billAmount.sendKeys(bAmount);
	}
	public void clickOnContinue() 
	{
		continueBtn.click();
	}*/
	public void waterDetails(String oprName,String rrnum,String eID,String ContNum,String bAmount) 
	{
		new Select(operatorName).selectByVisibleText(oprName);
		int operatorNameHeight=operatorName.getSize().getHeight();
		int operatorNameWidth=operatorName.getSize().getWidth();
		System.out.println("The operator Name textfield Hieght is "+operatorNameHeight+" The operator Name textfield Width is "+operatorNameWidth);
		
		rrNumber.sendKeys(rrnum);
		int rrNumberHeight=rrNumber.getSize().getHeight();
		int rrNumberWidth=rrNumber.getSize().getWidth();
		System.out.println("The Card Number textfield Hieght is "+rrNumberHeight+" The Card Number textfield Width is "+rrNumberWidth);
		
		emailId.sendKeys(eID);
		int emailIdHeight=emailId.getSize().getHeight();
		int emailIdWidth=emailId.getSize().getWidth();
		System.out.println("The emailId textfield Hieght is "+emailIdHeight+" The textfield Width is "+emailIdWidth);
		
		contactNumber.sendKeys(ContNum);
		int contactNumberHeight=contactNumber.getSize().getHeight();
		int contactNumberWidth=contactNumber.getSize().getWidth();
		System.out.println("The Contact Number textfield Hieght is "+contactNumberHeight+" The Contact Number textfield Width is "+contactNumberWidth);
		
		billAmount.sendKeys(bAmount);
		int billAmountHeight=billAmount.getSize().getHeight();
		int billAmountWidth=billAmount.getSize().getWidth();
		System.out.println("The Bill Amount textfield Hieght is "+billAmountHeight+" The Bill Amount textfield Width is "+billAmountWidth);
		
		int continueBtnHeight=continueBtn.getSize().getHeight();
		int continueBtnWidth=continueBtn.getSize().getWidth();
		System.out.println("The Continue Button textfield Hieght is "+continueBtnHeight+" The Continue Button textfield Width is "+continueBtnWidth);
		String continueBtntxt=continueBtn.getText();
		if(continueBtntxt.equals("Continue")) {
			System.out.println("Countinue button text is matched");
			continueBtn.click();
		}else {System.out.println("Countinue button text is not matched");}
		
	}
}

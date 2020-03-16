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
 * Created Date 03-Dec-2018
 */
public class PayBills
{
	@FindBy(xpath="//a[contains(text(),'UTILITY')]")
	WebElement utility;
	
	@FindBy(xpath="//a[contains(text(),' Pay Bills')]")
	WebElement payBills;
	
	@FindBy(id="change_td")
	WebElement selectOperator;
	
	@FindBy(name="connectionType")
	WebElement selectConnType;
	
	@FindBy(id="textcn")
	WebElement landlineNumber;
	
	@FindBy(id="productCode")
	WebElement sonyProductType;
	
	@FindBy(id="billAmount")
	WebElement billAmount;
	
	@FindBy(id="con_no")
	WebElement accountNumber;
	
	@FindBy(id="img_btn1")
	WebElement submit;
	
	WebDriver driver;
	
	public PayBills(WebDriver driver) 
	{	
		this.driver=driver;
	}
	public void initializeMethod() 
	{
		Actions action= new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(utility).click().build().perform();
		payBills.click();
		
		int payBillHeight=payBills.getSize().getHeight();
		int payBillWidth=payBills.getSize().getWidth();
		System.out.println("The Pay Bills Button Height is "+payBillHeight+" The PAy Bills Button Width is "+payBillWidth);
	}
	public void payBillRechargeTC1(String oprName, String landlinNu, String amt) 
	{
		new Select(selectOperator).selectByVisibleText(oprName);
		int selectOperatorHeight=selectOperator.getSize().getHeight();
		int selectOperatorWidth=selectOperator.getSize().getWidth();
		System.out.println("The Operator textfield Height is "+selectOperatorHeight+" The Operator textfield Width is "+selectOperatorWidth);
		
		landlineNumber.sendKeys(landlinNu);
		int landlineNumberHeight=landlineNumber.getSize().getHeight();
		int landlineNumberWidth=landlineNumber.getSize().getWidth();
		System.out.println("The Land line Number textfield Height is "+landlineNumberHeight+" The Land line Number textfield Width is "+landlineNumberWidth);
		
		billAmount.sendKeys(amt);
		int billAmountHeight=billAmount.getSize().getHeight();
		int billAmountWidth=billAmount.getSize().getWidth();
		System.out.println("The Bill Amount textfield Height is "+billAmountHeight+" The Bill AMount textfield Width is "+billAmountWidth);
		
		int submitHeight=submit.getSize().getHeight();
		int submitWidth=submit.getSize().getWidth();
		System.out.println("The Submit Button Height is "+submitHeight+" The Submit Button Width is "+submitWidth);
		String submittext=submit.getText();
		if(submittext.equals("Continue")) {
			System.out.println("The Continue btn text is matched");
			submit.click();
		}else {System.out.println("The Continue btn text is matched");}
		
	}
	/*public void payBillRechargeTC2() 
	{
		new Select(selectOperator).selectByVisibleText("BSNL Landline");
		new Select(selectConnType).selectByVisibleText("Landline Individual");
		landlineNumber.sendKeys("9000000000");
		billAmount.sendKeys("00");
		accountNumber.sendKeys("1234567890");
		submit.click();
		
	}
	public void payBillRechargeTC3() 
	{
		new Select(selectOperator).selectByVisibleText("Sony Liv");
		new Select(sonyProductType).selectByVisibleText("12months pack");
		landlineNumber.sendKeys("9000000000");
		billAmount.sendKeys("00");
		accountNumber.sendKeys("1234567890");
		submit.click();
	}*/	
}

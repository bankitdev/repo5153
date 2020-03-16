/**
 * 
 */
package com.ro.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Sunil Kashyap
 *
 * Created Date 11-Dec-2018
 */
public class Electricity {
	
	@FindBy(xpath="//a[contains(text(),'UTILITY')]")
	WebElement utility;
	
	@FindBy(xpath="//a[contains(text(),'Electricity')]")
	WebElement electricityLinBtn;
	
	@FindBy(id="reliance_energy")
	WebElement operatorName;
	
	@FindBy(id="etxtcn")
	WebElement accountNumber;
	
	@FindBy(name="ElecBillAmount")
	WebElement billAmount;
	
	@FindBy(xpath="//button[@id='img_btn3' and @onclick='ElectricityFormValidate(event)']")
	WebElement continueBtn;
	
	WebDriver driver;
	
	public Electricity(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void clickOnElectricityBtn() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(utility).click().build().perform();
		electricityLinBtn.click();
		
		int electricityLinBtnBtnHeight=electricityLinBtn.getSize().getHeight();
		int electricityLinBtnWidth=electricityLinBtn.getSize().getWidth();
		System.out.println("The electricity Button Height is "+electricityLinBtnBtnHeight+"The electricity Button Width is "+electricityLinBtnWidth);
	}
	
	public void electricityDetails(String accNum, String bill)
	{
		new Select(operatorName).selectByVisibleText("Calcutta Electricity Supply Company Limited");
		int electricityLinBtnBtnHeight=electricityLinBtn.getSize().getHeight();
		int electricityLinBtnWidth=electricityLinBtn.getSize().getWidth();
		System.out.println("The electricity Button Height is "+electricityLinBtnBtnHeight+"The electricity Button Width is "+electricityLinBtnWidth);
		
		accountNumber.sendKeys(accNum);
		int accountNumberHeight=accountNumber.getSize().getHeight();
		int accountNumberWidth=accountNumber.getSize().getWidth();
		System.out.println("The accountNumber textfield Height is "+accountNumberHeight+"The accountNumber textfield Width is "+accountNumberWidth);

		billAmount.sendKeys(bill);
		int billAmountHeight=billAmount.getSize().getHeight();
		int billAmountWidth=billAmount.getSize().getWidth();
		System.out.println("The billAmount textfield Height is "+billAmountHeight+"The billAmount textfield Width is "+billAmountWidth);
		
		int continueBtnHeight=continueBtn.getSize().getHeight();
		int continueBtnWidth=continueBtn.getSize().getWidth();
		System.out.println("The continue Button Height is "+continueBtnHeight+"The continue Button Width is "+continueBtnWidth);
		String continueBtntxt=continueBtn.getText();
		if(continueBtntxt.equals("Continue")) {
			System.out.println("Continue btn text is matched");
			continueBtn.click();
		}else {System.out.println("Continue btn text is not matched");}
		
		
		WebElement texts=driver.findElement(By.xpath("//form[@name='ElectricityForm']/div[10]"));
		System.out.println(texts.getText());
	}

}

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
 * Created Date 04-Dec-2018
 */
public class Insurance {
	
	@FindBy(xpath="//a[contains(text(),'UTILITY')]")
	WebElement utility;
	
	@FindBy(xpath="//a[contains(text(),'Insurance')]")
	WebElement insuranceLinkBtn;
	
	@FindBy(name="insurancePayOperator")
	WebElement insuranceCompany;
	
	@FindBy(name="policyHolderName")
	WebElement holderName;
	
	@FindBy(name="policyNumber")
	WebElement policyNumber;
	
	@FindBy(name="dob")
	WebElement dob;
	
	@FindBy(name="premiumAmount")
	WebElement premiumAmount;
	
	@FindBy(name="insuranceContactNo")
	WebElement contactNumber;
	
	@FindBy(id="insurenceEmailId")
	WebElement emailId;
	
	@FindBy(id="img_btn2")
	WebElement countinueBtn;
	
	WebDriver driver;
	
	public Insurance(WebDriver driver) 
	{	
		this.driver=driver;
	}
	public void initialize() 
	{
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(utility).click().build().perform();
		insuranceLinkBtn.click();
		
		int insuranceBtnHeight=insuranceLinkBtn.getSize().getHeight();
		int insuranceWidth=insuranceLinkBtn.getSize().getWidth();
		System.out.println("The Insurance Button Height is "+insuranceBtnHeight+"The Insurance Button Width is "+insuranceWidth);
		
	}
	/*public void selectIsuranceCompany() 
	{
		new Select(insuranceCompany).selectByVisibleText("Birla Sun Life Insurance");
	}
	public void holderNameTxt(String hName)
	{
		holderName.sendKeys(hName);
	}
	public void enterPolicyNumber(String pNumber) 
	{
		policyNumber.sendKeys(pNumber);
	}
	public void enterDate(String dobirth) 
	{
		dob.sendKeys(dobirth);
	}
	public void amount(String amnt) 
	{
		premiumAmount.sendKeys(amnt);
	}
	public void contactNumber(String cNumber) 
	{
		contactNumber.sendKeys(cNumber);
	}
	public void emailID(String eID) 
	{
		emailId.sendKeys(eID);
	}
	public void clickOnCountinueBtn() 
	{
		countinueBtn.click();
	}*/
	public void insuranceDetails(String hName, String pNumber, String dobirth, String amnt, String cNumber, String eID)
	{
		new Select(insuranceCompany).selectByVisibleText("Birla Sun Life Insurance");
		int insuranceBtnHeight=insuranceLinkBtn.getSize().getHeight();
		int insuranceWidth=insuranceLinkBtn.getSize().getWidth();
		System.out.println("The Insurance Button Height is "+insuranceBtnHeight+"The Insurance Button Width is "+insuranceWidth);
		
		holderName.sendKeys(hName);
		int holderNameHeight=holderName.getSize().getHeight();
		int holderNameWidth=holderName.getSize().getWidth();
		System.out.println("The holderName textfield Height is "+holderNameHeight+"The holderName textfield Width is "+holderNameWidth);
		
		policyNumber.sendKeys(pNumber);
		int policyNumberHeight=policyNumber.getSize().getHeight();
		int policyNumberWidth=policyNumber.getSize().getWidth();
		System.out.println("The policyNumber textfield Height is "+policyNumberHeight+"The policyNumber textfield Width is "+policyNumberWidth);
		
		dob.sendKeys(dobirth);
		int dobHeight=dob.getSize().getHeight();
		int dobWidth=dob.getSize().getWidth();
		System.out.println("The dob textfield Height is "+dobHeight+"The dob textfield Width is "+dobWidth);
		
		premiumAmount.sendKeys(amnt);
		int premiumAmountHeight=premiumAmount.getSize().getHeight();
		int premiumAmountWidth=premiumAmount.getSize().getWidth();
		System.out.println("The premiumAmount textfield Height is "+premiumAmountHeight+"The premiumAmount textfield Width is "+premiumAmountWidth);
		
		contactNumber.sendKeys(cNumber);
		int contactNumberHeight=contactNumber.getSize().getHeight();
		int contactNumberWidth=contactNumber.getSize().getWidth();
		System.out.println("The contactNumber textfield Height is "+contactNumberHeight+"The contactNumber textfield Width is "+contactNumberWidth);
		
		emailId.sendKeys(eID);
		int emailIdHeight=emailId.getSize().getHeight();
		int emailIdWidth=emailId.getSize().getWidth();
		System.out.println("The emailId textfield Height is "+emailIdHeight+"The emailId textfield Width is "+emailIdWidth);
		
		int countinueBtnHeight=countinueBtn.getSize().getHeight();
		int countinueBtnWidth=countinueBtn.getSize().getWidth();
		System.out.println("The countinueBtn Button Height is "+countinueBtnHeight+"The countinueBtn Button Width is "+countinueBtnWidth);
		String countinueBtntxt=countinueBtn.getText();
		if(countinueBtntxt.equals("Continue")) {
			System.out.println("Continue text is matched");
			countinueBtn.click();
		}else {System.out.println("Continue text is not matched");}
			
		
		/*WebElement text=driver.findElement(By.xpath("//form[@name='InsuranceForm']/div[contains(text(),'You have Insufficient Balance.')]"));
		System.out.println(text.getText());*/
	}
}

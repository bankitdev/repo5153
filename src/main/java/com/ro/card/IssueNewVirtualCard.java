/**
 * 
 */
package com.ro.card;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Sunil Kashyap
 *
 * Created Date 09-Oct-2018
 */
public class IssueNewVirtualCard {
	
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement clickOnCardBtn;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Virtual Card']")
	WebElement virtualCard;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Issue New Virtual Card']")
	WebElement issueNewVirtualCard;
	
	@FindBy(id="fname")
	WebElement firstname;
	
	@FindBy(id="lname")
	WebElement lastname;
	
	@FindBy(id="gender")
	WebElement gen;
	
	@FindBy(id="dob")
	WebElement dateOfBirth;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement year;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement month;
	@FindBy(xpath="//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[text()='4']")
	WebElement date;
	
	@FindBy(id="mobileNumber")
	WebElement mobile;
	
	@FindBy(id="email1")
	WebElement emailId;
	
	@FindBy(id="address1")
	WebElement addr1;
	
	@FindBy(id="address2")
	WebElement addr2;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="pincode")
	WebElement pincode;
	
	@FindBy(id="ovdType")
	WebElement ovdType;
	
	@FindBy(id="ovdNo")
	WebElement documentNo;
	
	@FindBy(id="checkBox")
	WebElement clickCheckBox;
	
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Submit']")
	WebElement submitBtn;
	
	WebDriver driver;
	
	public IssueNewVirtualCard(WebDriver driver) 
	{	
		this.driver=driver;
	}
	
	public void clickOnIssueNewVirtualCardBtn() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(clickOnCardBtn).click().perform();
		virtualCard.click();
		
		issueNewVirtualCard.click();
	}
	
	/*public void issueNewVirtualCardBtn() 
	{
		String frstname="Sunil";
		firstname.sendKeys(frstname);
		if(validationAndVerification.nameValidation(frstname)) {System.out.println("Test case passed______Valid firstName");}
		else {System.out.println("Test case failed______Invalid FirstName");}
		
		String lstname="Kashyap";
		lastname.sendKeys(lstname);
		if(validationAndVerification.nameValidation(lstname)) {System.out.println("Test case passed______Valid lastName");}
		else {System.out.println("Test case failed______Invalid lastName");}
	
		Select select=new Select(gen);
		select.selectByVisibleText("Male");
		
		dateOfBirth.click();
		new Select(year).selectByVisibleText("1993");
		new Select(month).selectByVisibleText("Feb");
		date.click();
			
		String number="7860690515";
		mobile.sendKeys(number);
		if(validationAndVerification.validNumber(number)) {System.out.println("Test case passed______Valid mobile number");}
		else {System.out.println("Test case failed______InValid mobile Number");}
		
		String email="sunil.kumar@bankit.in";
		emailId.sendKeys(email);
		if(validationAndVerification.emailvalidation(email)) {System.out.println("Test case passed______Valid Email Id");}
		else {System.out.println("Test case failed______InValid Email Id");}
		
		addr.sendKeys("Noida");
		
		new Select(ovdType).selectByVisibleText("PAN Card");
		
		documentNo.sendKeys("HGF68GWP");
		
	}*/
	public void enterFirstName(String name) 
	{
		firstname.sendKeys(name);
	}
	public void enterLastName(String lName) 
	{
		lastname.sendKeys(lName);
	}
	public void selectGender(String gend) 
	{
		new Select(gen).selectByVisibleText(gend);
	}
	public void dateOfBirth() 
	{
		dateOfBirth.click();
		new Select(year).selectByVisibleText("1993");
		new Select(month).selectByVisibleText("Feb");
		date.click();
	}
	public void enterMobileNumber(String MObNum) 
	{
		mobile.sendKeys(MObNum);
	}
	public void enterEmailID(String eID) 
	{
		emailId.sendKeys(eID);
	}
	public void enterAddress1(String address) 
	{
		addr1.sendKeys(address);
	}
	public void enterAddress2(String address) 
	{
		addr2.sendKeys(address);
	}
	public void selectState(String stateName) 
	{
		new Select(state).selectByVisibleText(stateName);
	}
	public void entyerCity(String cityName) 
	{
		city.sendKeys(cityName);
	}
	public void enterPincode(int pin) 
	{
		pincode.sendKeys(String.valueOf(pin));
	}
	public void selectOVDType(String idCard) 
	{
		new Select(ovdType).selectByVisibleText("PAN Card");
	}
	public void enterDocumentNumber(String number) 
	{
		documentNo.sendKeys(number);
	}
	public void clickOnSubmitBtn() 
	{
		//clickCheckBox.click();
		submitBtn.click();
	}

}

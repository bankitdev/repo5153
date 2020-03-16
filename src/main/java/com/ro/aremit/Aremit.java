package com.ro.aremit;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ro.Base.LoginPage;


public class Aremit     
{	
	WebDriver driver;
	public Aremit(WebDriver driver) throws Exception {
		super();
		this.driver=driver;
	}
	
	public void aermit() throws Exception
	{		
		// click/action on the 'AREMIT' head menu
		WebElement aremit=driver.findElement(By.xpath("//a[text()='AREMIT']"));
		Actions action=new Actions(driver);
		action.moveToElement(aremit).click().perform();                              
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//performing action on clear button
		System.out.println("--------------------Clear Button Actions------------------");
		driver.findElement(By.id("mobile_no")).sendKeys("1234567890");
		Thread.sleep(2000);	
		WebElement clearBtn=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Clear']"));
		int clearBtnWidth=clearBtn.getSize().getWidth();
		int clearBtnHeight=clearBtn.getSize().getHeight();
		System.out.println("The Height of Clear Button is "+clearBtnHeight +" The Width of Clear Button is "+clearBtnWidth);
		String clearBtnText=clearBtn.getAttribute("value");
		if(clearBtnText.equals("Clear")) {
			System.out.println("Clear Text is matched");
			clearBtn.click();
		}else {System.out.println("Clear text is not match");}
		
		//performing action on Submit button
		System.out.println("--------------------Submit Button Actions------------------");
		
		WebElement mobile_number=driver.findElement(By.id("mobile_no"));
		int mobileNumberHeight=mobile_number.getSize().getHeight();
		int mobileNumberWidth=mobile_number.getSize().getWidth();
		System.out.println("The Height of Mobile No textField is "+mobileNumberHeight+" The Width of Mobile No textfield is "+mobileNumberWidth);
		mobile_number.sendKeys("8800540474");
		
		//Thread.sleep(2000);
		WebElement submitBtn=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Submit' ]"));
		int submitBtnWidth=submitBtn.getSize().getWidth();
		int submitBtnHeight=submitBtn.getSize().getHeight();
		System.out.println("The Height of Submit Button is "+submitBtnHeight+" The Width of Submit Button is "+submitBtnWidth);
		String submitBtnText=submitBtn.getAttribute("value");
		if(submitBtnText.equals("Submit")) {
			System.out.println("Submit Text is matched");
			submitBtn.click();
		}else {System.out.println("Submit text is not match");}
		
		
		boolean customerExistStatus=false;
		
		try {
			driver.findElement(By.id("c_address"));
		} catch (Exception e) {
			customerExistStatus=true;
		}
		
		if(customerExistStatus) 
		{	
			refundTransaction();
			addRecipient();
			accountVerification();
			PayNow payNow=new PayNow(driver);
			payNow.payNow();
		}else
		{
			/*String alertMessage = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			System.out.println(alertMessage);*/

			driver.findElement(By.id("c_name")).sendKeys("BankIT");
			driver.findElement(By.id("c_address")).sendKeys("Noida");
			driver.findElement(By.id("c_dob")).click();
			// select year
			WebElement drapdown_of_year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			Select select=new Select(drapdown_of_year);
			select.selectByVisibleText("1993");
			//select month of year
			WebElement dropdown_of_month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			Select select1=new Select(dropdown_of_month);
			select1.selectByVisibleText("Feb");
			// select date of month
			WebElement select_day=driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a[text()='4']"));
			select_day.click();
			//System.out.println("date is "+ select_day.getText() +" Feb");
			/*boolean mobileNumber=false;
			
			if(mobileNumber) {*/
			driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Submit']")).click();
			/*}else 
			{	*/
				driver.findElement(By.id("otp"));
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Clear']")).click();
			//}
		}

	}
	public void refundTransaction() 
	{	
		System.out.println("--------------------Refund Transaction Button Actions------------------");
		WebElement refundTrans=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Refund Transaction']"));
		int refundTransHeight=refundTrans.getSize().getHeight();
		int refundTransWidth=refundTrans.getSize().getWidth();
		System.out.println("The Height of Refund Transaction is "+refundTransHeight+" The Width of Refund Transaction is"+refundTransWidth);
		String refundTransText=refundTrans.getAttribute("Value");
		if(refundTransText.equals("Refund Transaction")){
			System.out.println("Refund Transaction text is matched");
			refundTrans.click();
		}else {System.out.println("Refund Transaction text is not matched");}
		
		WebElement transactionID=driver.findElement(By.id("tran_id"));
		int transTextfieldHeight=transactionID.getSize().getHeight();
		int transTextfieldWidth=transactionID.getSize().getWidth();
		System.out.println("The Height of Transaction Id textfield is "+transTextfieldHeight+" The Width of Transaction Id textfield is"+transTextfieldWidth);
		
		WebElement backBtn=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Back']"));
		int backBtnHeight=backBtn.getSize().getHeight();
		int backBtnWidth=backBtn.getSize().getWidth();
		System.out.println("The Height of Back btn is "+backBtnHeight+" The Width of Back btn is"+backBtnWidth);
		String backBtnText=backBtn.getAttribute("value");
		if(backBtnText.equals("Back")){
			System.out.println("The Back Button text is matched");
			backBtn.click();
		}else {System.out.println("The Back Button text is not matched");}
		
		
	}
	public void addRecipient() throws Exception 
	{	
		    System.out.println("--------------------Add Recipient Button Actions------------------");
			WebElement addRecipient=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Add Recipient']"));
			int addRecipientHeight=addRecipient.getSize().getHeight();
			int addRecipientWidth=addRecipient.getSize().getWidth();
			System.out.println("The Height of add Recipient Button is "+addRecipientHeight+"The Width of add Recipient Button is"+addRecipientWidth);
			String addRecipientText=addRecipient.getAttribute("value");
			if(addRecipientText.equals("Add Recipient")) {
				System.out.println("Add Recipient Text is matched");
				addRecipient.click();
			}else{System.out.println("Add Recipient Text is not matched");}
			
			//((JavascriptExecutor)driver).executeAsyncScript("scroll(0,200)"," ");
			WebElement backBtn=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Back']"));
			int backBtnHeight=backBtn.getSize().getHeight();
			int backBtnWidth=backBtn.getSize().getWidth();
			System.out.println("The Height of Back Button is "+backBtnHeight+"The Width of Back Button is"+backBtnWidth);
			String backBtnText=backBtn.getAttribute("value");
			if(backBtnText.equals("Back")) {
				System.out.println("Back Text is matched");
				backBtn.click();
			}else{System.out.println("Back Text is not matched");}	
			
			
			Thread.sleep(2000);
			//click again on 'Add Recipient' button
			WebElement addRecipient1=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Add Recipient']"));
			addRecipient1.click();                                
		
			WebElement recipientName=driver.findElement(By.name("beneficiary_name"));
			int recipientNameHeight=recipientName.getSize().getHeight();
			int recipientNameWidth=recipientName.getSize().getWidth();
			System.out.println("The Height of Recipient Name textfield is "+recipientNameHeight+"The Width of Recipient Name textfield  is "+recipientNameWidth);
			recipientName.sendKeys("BankIT");
			WebElement recMobNO=driver.findElement(By.id("beneficiary_mob_no"));
			int recMobNoHeight=recMobNO.getSize().getHeight();
			int recMobNoWidth=recMobNO.getSize().getWidth();
			System.out.println("The Height of Recipient Mobile No textfield is "+recMobNoHeight+"The Width of Recipient Mobile No textfield is "+recMobNoWidth);
			recMobNO.sendKeys("7860690515");
			WebElement accNo=driver.findElement(By.name("account_no"));
			int accNoHeight=accNo.getSize().getHeight();
			int accNoWidth=accNo.getSize().getWidth();
			System.out.println("The Height of Account No textfield is "+accNoHeight+"The Width of Account No textfield is "+accNoWidth);
			accNo.sendKeys("324587134525");
			WebElement confAccNo=driver.findElement(By.id("confirm_acc_no"));
			int confAccNoHeight=confAccNo.getSize().getHeight();
			int confAccNoWidth=confAccNo.getSize().getWidth();
			System.out.println("The Height of Confirm Account No textfield is "+confAccNoHeight+"The Width of Confirm Account No textfield is "+confAccNoWidth);
			confAccNo.sendKeys("324587134525");
			new Select(driver.findElement(By.id("bankname"))).selectByVisibleText("CENTRAL BANK OF INDIA");
		    driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Cancel']")).click();     //click on 'Cancel' button
		    //Re-enter again all data
			driver.findElement(By.name("beneficiary_name")).sendKeys("BankIT");
			driver.findElement(By.id("beneficiary_mob_no")).sendKeys("7860690515");
			driver.findElement(By.name("account_no")).sendKeys("8059857188131");
			driver.findElement(By.id("confirm_acc_no")).sendKeys("8059857188131");
			new Select(driver.findElement(By.id("bankname"))).selectByVisibleText("CENTRAL BANK OF INDIA");
			WebElement ifscNumber=driver.findElement(By.id("ifsc"));
			System.out.println("Add Recipient Bank IFSC Code is "+ifscNumber.getAttribute("value"));
			WebElement submitBtn=driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Submit']"));
			int submitBtnHeight=submitBtn.getSize().getHeight();
			int submitBtnWidth=submitBtn.getSize().getWidth();
			System.out.println("The Height of Submit Button is "+submitBtnHeight+"The Width of Submit Button is"+submitBtnWidth);
			String submitBtnText=submitBtn.getAttribute("value");
			if(submitBtnText.equals("Submit")) {
				System.out.println("Submit Text is matched");
				submitBtn.click();                                                                //click on 'Submit' button
			}else{System.out.println("Submit Text is not matched");}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@class='form_submit_btn' and @value='Back']")).click();
			
	}
	public void accountVerification() 
	{	
	        System.out.println("--------------------Account Verification Button Actions------------------");
			WebElement accVerBtn=driver.findElement(By.xpath("//input[@value='Account Verification']"));
			int accVerBtnHeight=accVerBtn.getSize().getHeight();
			int accVerBtnWidth=accVerBtn.getSize().getWidth();
			System.out.println("The Height of Submit Button is "+accVerBtnHeight+"The Width of Submit Button is"+accVerBtnWidth);
			String accVerBtnText=accVerBtn.getAttribute("value");
			if(accVerBtnText.equals("Account Verification")) {
				System.out.println("Account Verification Text is matched");
				accVerBtn.click();                                                               
			}else{System.out.println("Account Verification Text is not matched");}
			
			WebElement accNo=driver.findElement(By.id("acc_no"));
			int accNoBtnHeight=accNo.getSize().getHeight();
			int accNoBtnWidth=accNo.getSize().getWidth();
			System.out.println("The Height of Account Number textfield is "+accNoBtnHeight+"The Width of Account Number textfield is"+accNoBtnWidth);
			accNo.sendKeys("3146059978");
			new Select(driver.findElement(By.id("bankname"))).selectByVisibleText("ICICI BANK");
			WebElement ifscCode=driver.findElement(By.id("ifsc"));
			int ifscCodeHeight=ifscCode.getSize().getHeight();
			int ifscCodeWidth=ifscCode.getSize().getWidth();
			System.out.println("The Height of IFSC Code textfield is "+ifscCodeHeight+"The Width of IFSC Code textfield is"+ifscCodeWidth);
			System.out.println("Account Verification Bank IFSC Code is "+ifscCode.getAttribute("value"));
			WebElement backBtn=driver.findElement(By.xpath("//input[@value='Back']"));
			int backBtnHeight=backBtn.getSize().getHeight();
			int backBtnWidth=backBtn.getSize().getWidth();
			System.out.println("The Height of Back Button is "+backBtnHeight+"The Width of Back Button is"+backBtnWidth);
			String backBtnText=backBtn.getAttribute("value");
			if(backBtnText.equals("Back")) {
				System.out.println("Back Text is matched");
				backBtn.click();
			}else{System.out.println("Back Text is not matched");}
	}
	/*public static void main(String args[]) throws Exception 
	{
		Aremit a=new Aremit();
		a.aermit();
	}*/
}

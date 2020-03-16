/**
 * 
 */
package com.ro.card;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
/**
 * @author Sunil Kashyap
 *
 * Created Date 26-Oct-2018
 */
public class GetVirtualCardDetails{
	
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement clickOnCardBtn;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Virtual Card']")
	WebElement virtualCard;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Get Virtual Card Details']")
	WebElement getVirtualCardDetails;
	
	@FindBy(id="email")
	WebElement emailID;
	
	@FindBy(id="mobile")
	WebElement mobileNu;
	
	@FindBy(xpath="//input[@class='form_submit_btn_new' and @value='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@class='form_submit_btn_new' and @value='Clear']")
	WebElement clearBtn;
	
	@FindBy(xpath="//input[@class='form_submit_btn_new' and @value='Back']")
	WebElement backBtn;
	
	@FindBy(xpath="//section[@class='main_space']/div/div/div/div/div")
	WebElement textMsg;
	
	WebDriver driver;
	
	public GetVirtualCardDetails(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void clickOnGetVirtualCardDetails() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(clickOnCardBtn).click().perform();
		virtualCard.click();
		
		getVirtualCardDetails.click();
	}

	public void enterCardDetails(String eID,long mobNum) 
	{
		
		String[] buttons= {"Back","Clear","Submit"};
		for(int i=0;i<buttons.length;i++) {
			
			emailID.sendKeys(eID);
			mobileNu.sendKeys(String.valueOf(mobNum));
			
			String btns=buttons[i];
			if(btns.equals("Back")) {
				backBtn.click();
				getVirtualCardDetails.click();
			}else if(btns.equals("Clear")) {
				clearBtn.click();
			}else {
				submitBtn.click();
			}
		}
		
		System.out.println(textMsg.getText());
	}
	public void verifyTextAndSize() 
	{
		int emailIDHeight=emailID.getSize().getHeight();
		int emailIDWidth=emailID.getSize().getWidth();
		System.out.println("The Height of Email ID is "+emailIDHeight+"The Width Email ID is "+emailIDWidth);
		
		int mobileNuHeight=mobileNu.getSize().getHeight();
		int mobileNuWidth=mobileNu.getSize().getWidth();
		System.out.println("The Height of Mobile No ID is "+mobileNuHeight+"The Width Mobile No is "+mobileNuWidth);
		
		int backBtnHeight=backBtn.getSize().getHeight();
		int backBtnWidth=backBtn.getSize().getWidth();
		System.out.println("The Height of BAck Button is "+backBtnHeight+"The Width Back Button is "+backBtnWidth);
		String backbtntxt=backBtn.getAttribute("value");
		if(backbtntxt.equals("Back")) {
			System.out.println("Back btn text is matched");
		}else {System.out.println("Back btn text is matched");}
		
		int clearBtnHeight=clearBtn.getSize().getHeight();
		int clearBtnWidth=clearBtn.getSize().getWidth();
		System.out.println("The Height of Clear button is "+clearBtnHeight+"The Width Clear Button is "+clearBtnWidth);
		String clearBtntxt=clearBtn.getAttribute("value");
		if(clearBtntxt.equals("Clear")) {
			System.out.println("Clear btn text is matched");
		}else {System.out.println("Clear btn text is matched");}
		
		int submitBtnHeight=submitBtn.getSize().getHeight();
		int submitBtnWidth=submitBtn.getSize().getWidth();
		System.out.println("The Height of Email ID is "+submitBtnHeight+"The Width Email ID is "+submitBtnWidth);
		String submitBtntxt=submitBtn.getAttribute("value");
		if(submitBtntxt.equals("Submit")) {
			System.out.println("Submit btn text is matched");
		}else {System.out.println("Submit btn text is matched");}
		
	}
	
}

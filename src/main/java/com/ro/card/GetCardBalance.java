/**
 * 
 */
package com.ro.card;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * @author Sunil Kashyap
 *
 * Created Date 25-Oct-2018
 */
public class GetCardBalance 

{
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement clickOnCardBtn;
	@FindBy(xpath="//input[@value='Transact with Existing Card']")
	WebElement transactwithExistingCard;
	@FindBy(xpath="//a[@id='a_benfeciary']/input[@value='Get Card Balance']")
	WebElement getCardBalance;
	@FindBy(id="mobileNumber")
	WebElement mobile;
	@FindBy(id="cardNumber")
	WebElement card;
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Submit']")
	WebElement submitBtn;
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Clear']")
	WebElement clearBtn;
	@FindBy(xpath="//section[@class='main_space']/div/div/div[2]/div[2]/span")
	WebElement textMsg;
	
	WebDriver driver;
	
	public GetCardBalance(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void setUp() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(clickOnCardBtn).click().perform();
		transactwithExistingCard.click();
		
		getCardBalance.click();
	}
	
	/*public void getCardBalanceTestCase1(String MobNum, String CardNUm) 
	{
		
		if(MobNum.charAt(0) == 10 && CardNUm.charAt(0) == 4) 
		{
			mobile.sendKeys(String.valueOf(MobNum));
			card.sendKeys(String.valueOf(CardNUm));
			submitBtn.click();
		}
		else 
		{System.out.println("not correct");}
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}*/
	public void getCardBalanceDetails(String MobNum, String CardNUm) 
	{	
		String[] buttons= {"Clear","Submit"};
		for(int i=0;i<buttons.length;i++) {
			
			String btns=buttons[i];
			mobile.sendKeys(MobNum);
			card.sendKeys(CardNUm);
			
			if(btns.equals("Clear")) {
				clearBtn.click();
			}else {submitBtn.click();
			//System.out.println(textMsg.getText());
			}
		}	
	}
	public void verifySizeAndText() 
	{
		int mobileHeight=mobile.getSize().getHeight();
		int mobileWidth=mobile.getSize().getWidth();
		System.out.println("The Mobile No textfield height is "+mobileHeight+" The mobile No textfield width is"+mobileWidth);
		
		int cardHeight=card.getSize().getHeight();
		int cardWidth=card.getSize().getWidth();
		System.out.println("The card No textfield height is "+cardHeight+" The card No textfield width is"+cardWidth);
		
		int clearBtnHeight=clearBtn.getSize().getHeight();
		int clearBtnWidth=clearBtn.getSize().getWidth();
		System.out.println("The clearBtn height is "+clearBtnHeight+" The clearBtn width is"+clearBtnWidth);
		String actualtxt=clearBtn.getAttribute("value");
		Assert.assertEquals(actualtxt, "Clear","clear text is matched");
		//Reporter.log("Clear text");
		
		int submitBtnHeight=submitBtn.getSize().getHeight();
		int submitBtnWidth=submitBtn.getSize().getWidth();
		System.out.println("The submitBtn height is "+submitBtnHeight+" The submitBtn width is"+submitBtnWidth);	
	}
	
}

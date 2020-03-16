/**
 * 
 */
package com.ro.recharge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
/**
 * @author Sunil Kashyap
 *
 * Created Date 30-Oct-2018
 */
public class MobileRecharge {

	@FindBy(xpath="//a[text()='RECHARGE']")
	WebElement recharge;
	
	@FindBy(xpath="//a[text()=' Mobile']")
	WebElement mobile;
	
	@FindBy(id="OperatorMobile")
	WebElement mobileOperator;
	
	@FindBy(name="mobileNo")
	WebElement mobileNumber;
	
	@FindBy(name="amountMobile")
	WebElement amount;
	
	@FindBy(id="img_btn1")
	WebElement proceedToRecharge;
	
	@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[contains(text(),'My Account Statement')]")
	WebElement myAccountStatement;
	
	@FindBy(xpath="//table[@class='table table-fixed']/tbody/tr[2]/td[12]")
	WebElement refundText;
	
	WebDriver driver;
	
	public MobileRecharge(WebDriver driver) 
	{	
		this.driver=driver;
	}
	
	public void setUprMobileRechargePage() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.moveToElement(recharge).click().build().perform();
		mobile.click();
		
		int mobileHeight=mobile.getSize().getHeight();
		int mobileWidth=mobile.getSize().getWidth();
		System.out.println("The mobile Button Height is "+mobileHeight+"The mobile Button Width is "+mobileWidth);
		
		
	}
	
	public void mobileRecharge(String oprName,String mobNo,String amt) 
	{
		new Select(mobileOperator).selectByVisibleText(oprName);
		mobileNumber.sendKeys(mobNo);
		amount.sendKeys(amt);
		proceedToRecharge.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();	
		System.out.println("Test Case failed");
	}

	public void mobileRechargeTC1(String oprName,String mobNo,String amt) 
	{
		new Select(mobileOperator).selectByVisibleText(oprName);
		int mobileOperatorHeight=mobileOperator.getSize().getHeight();
		int mobileOperatorWidth=mobileOperator.getSize().getWidth();
		System.out.println("The mobile Operator textfield Height is "+mobileOperatorHeight+"The mobile Operator textfield Width is "+mobileOperatorWidth);
		
		mobileNumber.sendKeys(mobNo);
		int mobileNumberHeight=mobileNumber.getSize().getHeight();
		int mobileNumberWidth=mobileNumber.getSize().getWidth();
		System.out.println("The mobile Number textfield Height is "+mobileNumberHeight+"The mobile Number textfield Width is "+mobileNumberWidth);
		
		amount.sendKeys(amt);
		int amountHeight=amount.getSize().getHeight();
		int amountWidth=amount.getSize().getWidth();
		System.out.println("The amount textfield Height is "+amountHeight+"The amount textfield Width is "+amountWidth);
		
		int proceedToRechargeHeight=proceedToRecharge.getSize().getHeight();
		int proceedToRechargeWidth=proceedToRecharge.getSize().getWidth();
		System.out.println("The Proceed to Recharge Button Height is "+proceedToRechargeHeight+"The Proceed to Recharge Button Width is "+proceedToRechargeWidth);
		String proceedToRechargeText=proceedToRecharge.getText();
		if(proceedToRechargeText.equals("Proceed to Recharge")) {
			System.out.println("Proceed to Recharge button text is matched");
			proceedToRecharge.click();
		}else {System.out.println("Proceed to Recharge button text is not matched");}
		
		WebElement textMsg=driver.findElement(By.xpath("//form[@name='MobileForm']/div[7]"));
		System.out.println(textMsg.getText());
		System.out.println("Test Case passed");
	}
	
	public void refundStatement() 
	{	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		myAccount.click();
		myAccountStatement.click();
		String text=refundText.getTagName();
		Assert.assertEquals(text, "Refunded","Refunded successfully");
	}
	
	public void printPlaceholder() 
	{	
		System.out.println("-------------------------------------------------");
		WebElement operatorNameText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[@value='-1']"));
		System.out.println("Operatore Name Placeholder is - "+operatorNameText.getText());
		
		WebElement mobileNumberPlhText=driver.findElement(By.xpath("//input[@placeholder='Enter your 10 digit mobile number']"));
		System.out.println("mobile No Placeholder is - "+mobileNumberPlhText.getAttribute("placeholder"));
		
		WebElement amountText=driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		System.out.println("The amount placeholder is - "+amountText.getAttribute("placeholder"));
	}
	
	public void verifyTextService() 
	{
		WebElement airtelText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Airtel']"));
		String string=airtelText.getText();	
		Assert.assertEquals(string, "AIRTEL");
		//Reporter.log("Airtel title do not match");
		
		WebElement aircelText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='AIRCEL']"));
		String aircelString=aircelText.getText();
		Assert.assertEquals(aircelString, "AIRCEL");
		
		WebElement bsnlText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='BSNL Special']"));
		String bsnlString=bsnlText.getText();
		Assert.assertEquals(bsnlString, "BSNL SPECIAL");
		
		WebElement bsnlTopupText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='BSNL Topup']"));
		String bsnlTopupString=bsnlTopupText.getText();
		Assert.assertEquals(bsnlTopupString, "BSNL TOPUP");
		
		WebElement ideaText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='IDEA']"));
		String ideaString=ideaText.getText();
		Assert.assertEquals(ideaString, "IDEA");
		
		WebElement jioText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Jio']"));
		String jioString=jioText.getText();
		Assert.assertEquals(jioString, "JIO");
		
		WebElement mtnlText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='MTNL Topup Delhi']"));
		String mtnlString=mtnlText.getText();
		Assert.assertEquals(mtnlString, "MTNL TOPUP DELHI");
		
		WebElement mtnlValidityText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='MTNL Validity Delhi']"));
		String mtnlValidityString=mtnlValidityText.getText();
		Assert.assertEquals(mtnlValidityString, "MTNL VALIDITY DELHI");
		
		WebElement mtsText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='MTS']"));
		String mtsString=mtsText.getText();
		Assert.assertEquals(mtsString, "MTS");
		
		WebElement relianceText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Reliance CDMA']"));
		String relianceString=relianceText.getText();
		Assert.assertEquals(relianceString, "RELIANCE CDMA");
		
		WebElement relianceGSMText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Reliance GSM']"));
		String relianceGSMString=relianceGSMText.getText();
		Assert.assertEquals(relianceGSMString, "RELIANCE GSM");
		
		WebElement tataDocomoText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Tata Docomo']"));
		String tataDocomoString=tataDocomoText.getText();
		Assert.assertEquals(tataDocomoString, "TATA DOCOMO");
		
		WebElement tataDocomoSpecialText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Tata Docomo Special']"));
		String tataDocomoSpecialString=tataDocomoSpecialText.getText();
		Assert.assertEquals(tataDocomoSpecialString, "TATA DOCOMO SPECIAL");
		
		WebElement tataIndicomText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Tata Indicom']"));
		String tataIndicomString=tataIndicomText.getText();
		Assert.assertEquals(tataIndicomString, "TATA INDICOM");
		
		WebElement telenorText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Telenor Special']"));
		String telenorString=telenorText.getText();
		Assert.assertEquals(telenorString, "TELENOR SPECIAL");
		
		WebElement telenorTopupText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Telenor Topup']"));
		String telenorTopupString=telenorTopupText.getText();
		Assert.assertEquals(telenorTopupString, "TELENOR TOPUP");
		
		WebElement videoconText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Videocon Special']"));
		String videoconString=videoconText.getText();
		Assert.assertEquals(videoconString, "VIDEOCON SPECIAL");
		
		WebElement videoconTopupText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Videocon Topup']"));
		String videoconTopupString=videoconTopupText.getText();
		Assert.assertEquals(videoconTopupString, "VIDEOCON TOPUP");
		
		WebElement vodafoneText=driver.findElement(By.xpath("//select[@id='OperatorMobile']/option[text()='Vodafone']"));
		String vodafoneString=vodafoneText.getText();
		Assert.assertEquals(vodafoneString, "VODAFONE");

	}
	
	
}

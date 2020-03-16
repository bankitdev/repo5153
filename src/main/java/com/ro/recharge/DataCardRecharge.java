/**
 * 
 */
package com.ro.recharge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;


/**
 * @author Sunil Kashyap
 *
 * Created Date 31-Oct-2018
 */
public class DataCardRecharge {
	
	@FindBy(xpath="//a[text()='RECHARGE']")
	WebElement recharge;
	
	@FindBy(xpath="//a[contains(text(),'DATA')]")
	WebElement dataCardBtn;
	
	@FindBy(name="OperatorDataCrd")
	WebElement dataCardOperator;
	
	@FindBy(name="datacardno")
	WebElement dataCardNo;
	
	@FindBy(name="amountDataCrd")
	WebElement dataCardAmount;
	
	@FindBy(xpath="//button[@id='img_btn3']")
	WebElement rechargeProcessBtn;
	
	WebDriver driver;
	
	public DataCardRecharge(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void clickOnDataCardLinkBtn() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();}
		action.moveToElement(recharge).click().build().perform();
		dataCardBtn.click();
		
		int dataCardBtnHeight=dataCardBtn.getSize().getHeight();
		int dataCardBtnWidth=dataCardBtn.getSize().getWidth();
		System.out.println("The Data Card Button Height is "+dataCardBtnHeight+"The Data Card Button Width is "+dataCardBtnWidth);
	}
	
	public void dataCardRechargeTC1(String operName,String dataCardNu, String amt) 
	{
		new Select(dataCardOperator).selectByVisibleText(operName);
		int dataCardOperatorBtnHeight=dataCardOperator.getSize().getHeight();
		int dataCardOperatorWidth=dataCardBtn.getSize().getWidth();
		System.out.println("The Data Card Operator textfield Height is "+dataCardOperatorBtnHeight+"The Data Card Operator textfield Width is "+dataCardOperatorWidth);
		
		dataCardNo.sendKeys(dataCardNu);
		int dataCardNoBtnHeight=dataCardNo.getSize().getHeight();
		int dataCardNoWidth=dataCardNo.getSize().getWidth();
		System.out.println("The Data Card No textfield Height is "+dataCardNoBtnHeight+"The Data Card No textfield Width is "+dataCardNoWidth);
		
		dataCardAmount.sendKeys(amt);
		int dataCardAmountHeight=dataCardAmount.getSize().getHeight();
		int dataCardAmountWidth=dataCardAmount.getSize().getWidth();
		System.out.println("The Data Card Amount textfield Height is "+dataCardAmountHeight+"The Data Card Amount textfield Width is "+dataCardAmountWidth);
		
		int rechargeProcessBtnHeight=rechargeProcessBtn.getSize().getHeight();
		int rechargeProcessBtnWidth=rechargeProcessBtn.getSize().getWidth();
		System.out.println("The recharge Process Btn Height is "+rechargeProcessBtnHeight+"The recharge Process Btn Width is "+rechargeProcessBtnWidth);
		String rechargeProcessBtnText=rechargeProcessBtn.getText();
		if(rechargeProcessBtnText.equals("Proceed to Recharge")) {
			System.out.println("Recharge Process Btn is matched");
			rechargeProcessBtn.click();
		}else {System.out.println("Recharge Process Btn is not matched");}
		
	}
	
	public void dataCardRechargeTC2(String operName,String dataCardNu, String amt) 
	{	
		new Select(dataCardOperator).selectByVisibleText(operName);
		dataCardNo.sendKeys(dataCardNu);
		dataCardAmount.sendKeys(amt);
		rechargeProcessBtn.click();
		System.out.println(driver.findElement(By.xpath("//form[@name='DataCardForm']/div[7]")).getText());
		System.out.println("Test case failed");
		
	}

	public void dataCardRechargeTC3() 
	{
		new Select(dataCardOperator).selectByVisibleText("Reliance");
		dataCardNo.sendKeys("0000000000000");
		dataCardAmount.sendKeys("0");
		rechargeProcessBtn.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println("Test case failed");
	}

	public void verifyDataCardOperatorText() 
	{
		WebElement ideaText=driver.findElement(By.xpath("//select[@name='OperatorDataCrd']/option[text()='Idea']"));
		String ideaString=ideaText.getText();
		Assert.assertEquals(ideaString, "IDEA");	
		
		WebElement ideaNetsetterPostphoneText=driver.findElement(By.xpath("//select[@name='OperatorDataCrd']/option[text()='Idea NetSetter Postpaid']"));
		String ideaNetSetterPostPhoneString=ideaNetsetterPostphoneText.getText();
		Assert.assertEquals(ideaNetSetterPostPhoneString, "IDEA NETSETTER POSTPAID");
		
		WebElement mtsText=driver.findElement(By.xpath("//select[@name='OperatorDataCrd']/option[text()='MTS']"));
		String mtsString=mtsText.getText();
		Assert.assertEquals(mtsString, "MTS");
		
		WebElement relianceText=driver.findElement(By.xpath("//select[@name='OperatorDataCrd']/option[text()='Reliance']"));
		String relianceString=relianceText.getText();
		Assert.assertEquals(relianceString, "RELIANCE");
		
		WebElement relianceNetConnectPostPhoneText=driver.findElement(By.xpath("//select[@name='OperatorDataCrd']/option[text()='Reliance NetConnect Postpaid']"));
		String relianceNetConnectPostPhoneString=relianceNetConnectPostPhoneText.getText();
		Assert.assertEquals(relianceNetConnectPostPhoneString, "RELIANCE NETCONNECT POSTPAID");
		
		WebElement tataText=driver.findElement(By.xpath("//select[@name='OperatorDataCrd']/option[text()='Tata']"));
		String tataString=tataText.getText();
		Assert.assertEquals(tataString, "TATA");
		
		WebElement tataIndicomPostphoneText=driver.findElement(By.xpath("//select[@name='OperatorDataCrd']/option[text()='Tata Indicom Postpaid']"));
		String tataIndicomPostPhoneString=tataIndicomPostphoneText.getText();
		Assert.assertEquals(tataIndicomPostPhoneString, "TATA INDICOM POSTPAID");
		
		WebElement tataPhotomText=driver.findElement(By.xpath("//select[@name='OperatorDataCrd']/option[text()='Tata Photom Postpaid']"));
		String tataPhotomString=tataPhotomText.getText();
		//Assert.assertEquals(tataPhotomString, "TATA PHOTON POSTPAID");
		Assert.assertEquals(tataPhotomString, "TATA PHOTOM POSTPAID", "This is matched");
		
		System.out.println("Test Case Passed");
	}
	
}


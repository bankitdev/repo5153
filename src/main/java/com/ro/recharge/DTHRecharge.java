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

/**
 * @author Sunil Kashyap
 *
 * Created Date 31-Oct-2018
 */
public class DTHRecharge {
	
	@FindBy(xpath="//a[text()='RECHARGE']")
	WebElement recharge;
	
	@FindBy(xpath="//a[text()='DTH']")
	WebElement dth;
	
	@FindBy(name="OperatorDTH")
	WebElement dthOperator;
	
	@FindBy(name="DTHNo")
	WebElement dthNo;
	
	@FindBy(name="amountDTH")
	WebElement dthAmount;
	
	@FindBy(id="img_btn2")
	WebElement rechargeProcessingBtn;
	
	WebDriver driver;
	
	public DTHRecharge(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void setUpRechargeModule() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();}
		action.moveToElement(recharge).click().build().perform();
		dth.click();
		
		int dthHeight=dth.getSize().getHeight();
		int dthWidth=dth.getSize().getWidth();
		System.out.println("The DTH Button Height is "+dthHeight+"The DTH Button Width is "+dthWidth);
	}
	
	public void dthRechargeTC1(String operName,String dthNu, String amt) 
	{
		new Select(dthOperator).selectByVisibleText(operName);
		int dthOperatorHeight=dthOperator.getSize().getHeight();
		int dthOperatorWidth=dthOperator.getSize().getWidth();
		System.out.println("The DTH Operator textfield Height is "+dthOperatorHeight+"The DTH DTH Operator textfield Width is "+dthOperatorWidth);
		
		dthNo.sendKeys(dthNu);
		int dthNoHeight=dthNo.getSize().getHeight();
		int dthNoWidth=dthNo.getSize().getWidth();
		System.out.println("The DTH No textfield Height is "+dthNoHeight+"The DTH No Textfield Width is "+dthNoWidth);
		
		dthAmount.sendKeys(amt);
		int dthAmountHeight=dthAmount.getSize().getHeight();
		int dthAmountWidth=dthAmount.getSize().getWidth();
		System.out.println("The Amount textfield Height is "+dthAmountHeight+"The DTH Amount textfield Width is "+dthAmountWidth);
		
		int rechargeProcessingBtnHeight=rechargeProcessingBtn.getSize().getHeight();
		int rechargeProcessingBtnWidth=rechargeProcessingBtn.getSize().getWidth();
		System.out.println("The DTH Button Height is "+rechargeProcessingBtnHeight+"The DTH Button Width is "+rechargeProcessingBtnWidth);
		String rechargeProcessingBtnText=rechargeProcessingBtn.getText();
		if(rechargeProcessingBtnText.equals("Proceed to Recharge")) {
			System.out.println("Proceed to Recharge Button text is matched");
			rechargeProcessingBtn.click();
		}else {System.out.println("Proceed to Recharge Button text is not matched");}
		
	}
	
	/*public void dthRechargeTC2() 
	{
		new Select(dthOperator).selectByVisibleText("Sun Direct");
		dthNo.sendKeys("12345");
		dthAmount.sendKeys("1000");
		rechargeProcessingBtn.click();
	}*/
	
	public void verifyDTHOperator() 
	{
		WebElement tataSkyText=driver.findElement(By.xpath("//select[@name='OperatorDTH']/option[text()='Tata Sky']"));
		String tataSkyString=tataSkyText.getText();	
		Assert.assertEquals(tataSkyString, "TATA SKY");
		
		WebElement airtelDTHText=driver.findElement(By.xpath("//select[@name='OperatorDTH']/option[text()='Airtel DTH']"));
		String airtelDTHString=airtelDTHText.getText();	
		Assert.assertEquals(airtelDTHString, "AIRTEL DTH");
		
		WebElement bigTVText=driver.findElement(By.xpath("//select[@name='OperatorDTH']/option[text()='Big TV']"));
		String bigTVString=bigTVText.getText();	
		Assert.assertEquals(bigTVString, "BIG TV");
		
		WebElement dishTVText=driver.findElement(By.xpath("//select[@name='OperatorDTH']/option[text()='Dish TV']"));
		String dishTVString=dishTVText.getText();	
		Assert.assertEquals(dishTVString, "DISH TV");
		
		WebElement sunDirectText=driver.findElement(By.xpath("//select[@name='OperatorDTH']/option[text()='Sun Direct']"));
		String sunDirectString=sunDirectText.getText();	
		Assert.assertEquals(sunDirectString, "SUN DIRECT");
		
		WebElement videoconDTHText=driver.findElement(By.xpath("//select[@name='OperatorDTH']/option[text()='Videocon DTH']"));
		String videoconDTHString=videoconDTHText.getText();	
		Assert.assertEquals(videoconDTHString, "VIDEOCON DTH");
	}
}

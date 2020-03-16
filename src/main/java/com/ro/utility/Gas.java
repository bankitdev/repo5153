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
import org.testng.asserts.SoftAssert;

/**
 * @author Sunil Kashyap
 *
 * Created Date 11-Dec-2018
 */
public class Gas {
	
	@FindBy(xpath="//a[contains(text(),'UTILITY')]")
	WebElement utility;
	
	@FindBy(xpath="//a[contains(text(),'Gas')]")
	WebElement clickOnGasBtn;
	
	@FindBy(id="reliance_energy_gas")
	WebElement operatorName;
	
	@FindBy(id="pay_number_gas")
	WebElement custAmountNo;
	
	@FindBy(xpath="(//input[@name='ElecBillAmount' and @placeholder='Enter your Bill Amount'])[2]")
	WebElement billAmount;
	
	@FindBy(xpath="//input[@id='add_text' and @onkeyup='textCounter(this.value,this.form.remLen14);']")
	WebElement groupId;
	
	@FindBy(xpath="//button[@id='img_btn3' and @onclick='GasFormValidate(event)']")
	WebElement clickOnContinueBtn;
	
	WebDriver driver;
	
	public Gas(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void clickOnGasLink() 
	{
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(utility).click().build().perform();
		clickOnGasBtn.click();
		
		int clickOnGasBtnHeigth=clickOnGasBtn.getSize().getHeight();
		int clickOnGasBtnWidth=clickOnGasBtn.getSize().getWidth();
		System.out.println("The Gas Button Height is "+clickOnGasBtnHeigth+"The Gas Button Width is "+clickOnGasBtnWidth);
	}
	public void selectOnOperatorName(String oprNAme) 
	{
		new Select(operatorName).selectByVisibleText(oprNAme);
		int operatorNameHeigth=operatorName.getSize().getHeight();
		int operatorNameWidth=operatorName.getSize().getWidth();
		System.out.println("The operatorName textfield Height is "+operatorNameHeigth+"The operatorName textfield Width is "+operatorNameWidth);
	}
	public void custAccountNo(String cAccountNo)
	{
		custAmountNo.sendKeys(cAccountNo);
		int custAmountNoHeigth=custAmountNo.getSize().getHeight();
		int custAmountNoWidth=custAmountNo.getSize().getWidth();
		System.out.println("The custAmountNo textfield Height is "+custAmountNoHeigth+"The textfield Width is "+custAmountNoWidth);
	}
	public void billAmount(String bAmount) 
	{
		billAmount.sendKeys(bAmount);
		int billAmountHeigth=billAmount.getSize().getHeight();
		int billAmountWidth=billAmount.getSize().getWidth();
		System.out.println("The billAmount textfield Height is "+billAmountHeigth+"The textfield Width is "+billAmountWidth);
	}
	public void groupNo(String grpNo)
	{
		groupId.sendKeys(grpNo);
		int groupIdHeigth=groupId.getSize().getHeight();
		int groupIdWidth=groupId.getSize().getWidth();
		System.out.println("The groupId textfield Height is "+groupIdHeigth+"The textfield Width is "+groupIdWidth);
	}
	public void clickOnContinueBtn() 
	{	
		int clickOnContinueBtnHeigth=clickOnContinueBtn.getSize().getHeight();
		int clickOnContinueBtnWidth=clickOnContinueBtn.getSize().getWidth();
		System.out.println("The Continue Button Height is "+clickOnContinueBtnHeigth+"The Continue Button Width is "+clickOnContinueBtnWidth);
		String clickOnContinueBtntxt=clickOnContinueBtn.getText();
		if(clickOnContinueBtntxt.equals("Continue")) {
			System.out.println("Continue Button text is matched");
			clickOnContinueBtn.click();
		}else {System.out.println("Continue Button text is matched");}
		
	}
	public void verifyTextService() 
	{	
		SoftAssert softAssert=new SoftAssert();
		
		WebElement gujratGasText=driver.findElement(By.xpath("//select[@id='reliance_energy_gas']/option[text()='Gujrat Gas']"));
		String gujratGasStr=gujratGasText.getText();
		softAssert.assertEquals(gujratGasStr, "Gujrat Gas");
		
		WebElement indraprasthaGasLtText=driver.findElement(By.xpath("//select[@id='reliance_energy_gas']/option[text()='Indraprastha Gas Limited']"));
		String indraprasthaGasLtStr=indraprasthaGasLtText.getText();
		softAssert.assertEquals(indraprasthaGasLtStr, "INDRAPRASTHA Gas LIMITED");
		
		WebElement mahanagarGasLmtText=driver.findElement(By.xpath("//select[@id='reliance_energy_gas']/option[text()='Mahanagar Gas Limited']"));
		String mahanagarGasLmtStr=mahanagarGasLmtText.getText();
		softAssert.assertEquals(mahanagarGasLmtStr, "MAHANAGAR GAS LIMITED");
	}
}

/**
 * 
 */
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author Sunil Kashyap
 *
 * Created Date 16-Nov-2018
 */
public class Loginpage {
	
	@FindBy(name="userName")
	WebElement usernm;
	
	@FindBy(name="pass")
	WebElement passwrd;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(xpath="//font[contains(text(),'Hello !')]")
	WebElement text;
	
	WebDriver driver;
	
	public Loginpage(WebDriver driver) 
	{	
		this.driver=driver;
	}
	public void userNameTxt(String un) 
	{	
		driver.switchTo().frame("Main");
		usernm.sendKeys(un);
	}
	
	public void passWordTxt(String pw) 
	{
		passwrd.sendKeys(pw);
	}
	
	public void clickOnSubmitBtn() 
	{
		submit.click();
	}
	
	public void compareText() 
	{
		Assert.assertEquals(text, "Hello !");
	}
	public void setData(String uName, String pwd) 
	{
		userNameTxt(uName);
		passWordTxt(pwd);
		clickOnSubmitBtn();
	}
}

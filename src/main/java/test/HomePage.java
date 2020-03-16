/**
 * 
 */
package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sunil Kashyap
 *
 * Created Date 16-Nov-2018
 */
public class HomePage {
	
	@FindBy(xpath="//div[@id='popup2']/div/div/button/span")
	WebElement popup1;
	
	@FindBy(xpath="//div[@id='popup3']/div/div/button/span")
	WebElement popup2;
	
	@FindBy(xpath="//a[contains(text(),'CARD')]")
	WebElement card;
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void clickOnPopUps() 
	{	
		try {
			Thread.sleep(2000);
			popup1.click();
			Thread.sleep(2000);
			popup2.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clickOnCard() 
	{
		Actions action=new Actions(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.moveToElement(card).click().build().perform();
	}
}

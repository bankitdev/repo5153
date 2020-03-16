/**
 * 
 */
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 * Created Date 21-Dec-2018
 */
public class IssueNewPhysicalCard {
	
	@FindBy(id="email1")
	WebElement email;
	
	@FindBy(id="mobile1")
	WebElement mobile;
	
	@FindBy(xpath="//input[@class='form_submit_btn' and @value='Submit']")
	WebElement submit;
	WebDriver driver;
	Card card;
	
	public IssueNewPhysicalCard(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void clickOnIssueNewPhysicalCard() 
	{
		card=new Card(driver);
		card.clickOnCardLink();
		//card.issueNewPhysicalCard();
	}
	public void enterEmailID(String eID) 
	{
		email.sendKeys(eID);
	}
	public void enterMobileNum(String MobNum) 
	{
		mobile.sendKeys(MobNum);
	}
	public void clickOnSubmitBtn() 
	{
		submit.click();
	}

}

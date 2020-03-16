/**
 * 
 */
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.ro.card.IssueNewPhysicalCard;
import com.ro.card.VirtualCard;

/**
 * @author Sunil Kashyap
 *
 * Created Date 21-Dec-2018
 */
public class Card {
	
	WebDriver driver;
	@FindBy(xpath="//a[text()='CARD']")
	WebElement card;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Issue New Physical Card']")
	WebElement issueNewPhysicalCard;
	
	@FindBy(xpath="//a[@id='rftran']/input[@value='Virtual Card']")
	WebElement virtualCard;
	
	public Card(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void clickOnCardLink() 
	{	
		Actions actions=new Actions(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(card).click().build().perform();
		
	}
	
	/*public IssueNewPhysicalCard issueNewPhysicalCard()
	{	
		issueNewPhysicalCard.click();
		return new IssueNewPhysicalCard();
	}*/
	public VirtualCard virtualCard() throws Exception 
	{
		virtualCard.click();
		return new VirtualCard();
	}
}

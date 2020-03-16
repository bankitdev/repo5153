/**
 * 
 */
package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Sunil Kashyap
 *
 * Created Date 16-Nov-2018
 */
public class LoginTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void initialized() 
	{
		System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://portal.bankit.in:9090/RO/");
	}
	@Test
	public void setMethod() throws Exception
	{
		Loginpage loginPage = PageFactory.initElements(driver, Loginpage.class);
		loginPage.setData("8512001213", "Yahoo@123");
		//loginPage.compareText();
		
		
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.clickOnPopUps();
		homepage.clickOnCard();
		
	}
	/*@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}*/
	
}

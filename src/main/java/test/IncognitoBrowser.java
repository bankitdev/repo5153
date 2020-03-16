/**
 * 
 */
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Sunil Kashyap
 *
 * Created Date 06-Feb-2019
 */
public class IncognitoBrowser {

	public static void main(String args[]) 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

}

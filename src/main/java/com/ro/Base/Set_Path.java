package com.ro.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Set_Path
{	
	public WebDriver driver;
	public Set_Path(String browser) 
	{	
		if(browser.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("Chrome Browser launched");
		}
		else if(browser.equalsIgnoreCase("FireFox")) 
		{
			System.setProperty("webdriver.gecko.driver", ".\\exefiles\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Firefox Browser launched");
		}
		else if(browser.equalsIgnoreCase("IE")) 
		{
			System.setProperty("webdriver.ie.driver", ".\\exefiles\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			System.out.println("Internet Explorer Browser launched");
		}
		else
		{
			driver=new ChromeDriver();
			System.out.println("Chrome Browser launched");
		}
		
		driver.manage().window().maximize();
		driver.navigate().to("https://portal.bankit.in:9090/RO/");
	}
}

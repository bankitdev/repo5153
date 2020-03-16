package com.ro.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Set_PathLocal 
{	
	public static WebDriver driver;
	public static void setPathLocal() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\RO_Portal\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://125.63.96.115:9012/RO/");
	}
}

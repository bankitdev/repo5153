/**
 * 
 */
package com.ro.safegold;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Sunil Kashyap
 *
 * Created Date 26-Nov-2018
 */
public class LoginPage extends SetLocalPath
{
	public LoginPage()  
	{	
		super("Chrome");
		driver.switchTo().frame("Main");
		
		String[] username= {"Sunil","amit.malu@bankit.in"};
		String[] password= {"bankit","Amit@123"};
		
		for(int i=0;i<username.length;i++) 
		{
			String user,pass;
			user=username[i];
			pass=password[i];
			
			WebElement usrName =driver.findElement(By.xpath("//input[@name='userName']"));
			usrName.sendKeys(user);
			WebElement pwd =driver.findElement(By.xpath("//input[@name='pass']"));
			pwd.sendKeys(pass);
			WebElement submit=driver.findElement(By.xpath("//input[@id='login']"));
			submit.click();
			
			try
			{	
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='popup2']/div/div/button/span")).click();  //handling starting pop-up 1
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='popup3']/div/div/button/span")).click();   //handling starting pop-up 2
				
				System.out.println("------------------------------------------------");
				System.out.println("Valid Username and password");
				System.out.println("Login successfully");
				
			} catch (Exception e) {
				System.out.println("------------------------------------------------");
				System.out.println("Invalid Username and password");
				WebElement text=driver.findElement(By.xpath("//strong[text()='Your User Name or Password is Invalid.']"));
				System.out.println(text.getText());
			}	
		}
	}
	/*public static void main(String args[]) 
	{
		new LoginPage();
	}*/
}

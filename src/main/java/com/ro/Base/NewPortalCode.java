package com.ro.Base;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewPortalCode {
private static CharSequence KeyUpAction;
private static String year;

public static void main(String[] args) throws InterruptedException 
{
 
	//Set the path and property of below driver that u wann to use.
	System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
 
	//launching browser
    WebDriver driver = new ChromeDriver();
 
    //Maximizing brwoser window using maximize() method
    driver.manage().window().maximize();
 
 
    //Enter the URL of the website
    String baseUrl = "https://portal.bankit.in:9090/RO/";
        
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    // Passing the Title
    String expectedTitle = "BankIT";
    System.out.println("The title of the website is: " +expectedTitle);
    String actualTitle = "";
    String tagName = "";

        

    // launch Chrome Driver and direct it to the Base URL
    driver.navigate().to(baseUrl);

    // get the actual value of the title
    actualTitle = driver.getTitle();

        
       //  * compare the actual title of the page with the expected one and print
      //   * the result as "Passed" or "Failed"
         
        if (actualTitle.contentEquals(expectedTitle))
        {
            System.out.println("Test Passed!");
        } 
        else 
        {
            System.out.println("Test Failed");
        }
        
        Thread.sleep(3000);
       
        /*  // Storing Title length in the Int variable
		int titleLength = driver.getTitle().length();
 
		// Printing Title & Title length in the Console window
		System.out.println("Title of the page is : " + actualTitle);
		System.out.println("Length of the title is : "+ titleLength);
     	// Storing Page Source in String variable
		String pageSource = driver.getPageSource();

		// Storing Page Source length in Int variable

       	int pageSourceLength = pageSource.length();
       
		// Printing length of the Page Source on console
		System.out.println("Total length of the Pgae Source is : " + pageSourceLength);
        */
       
      /* List<WebElement> link=driver.findElements(By.tagName("a"));
       System.out.println("the total size of links is "+link.size());
       for(int i=1;i<=link.size();i++) 
       {
    	   String linksName = link.get(i).getText();
    	   System.out.println("The Total name of links"+linksName);
       }*/
        
        driver.switchTo().frame("Main");
        
      
        // Scroll to footer and click on social links
        ((JavascriptExecutor)driver).executeScript("scroll(0,900)");
        
        WebElement wb = driver.findElement(By.xpath("//p[@class='footer_social']/a[@href='https://www.facebook.com/bankit.in/']"));

        if(wb.isDisplayed())
        {
        	wb.click();
  
        	WebElement wb1 =driver.findElement(By.xpath("//p[@class='footer_social']/a[@href='https://www.linkedin.com/company/13403608/']"));
 
        	if(wb1.isDisplayed())
        	{
        		wb1.click();
 
        		WebElement wb2 =driver.findElement(By.xpath("//p[@class='footer_social']/a[@href='#']"));
 
        		if(wb2.isDisplayed())
        		{
        			wb2.click();
 
        			((JavascriptExecutor)driver).executeScript("scroll(0,900)");
 
 
        			WebElement wb3=driver.findElement(By.xpath("//p[@class='footer_social']/a[@href='https://twitter.com/BankIT_India']"));
        			if(wb3.isDisplayed())
        			{
        				wb3.click();
        				
        				// BankIT on Android play store 
        				
        				WebElement wb4=driver.findElement(By.xpath("//p[@class='app_icon']/a[@href='https://play.google.com/store/apps/details?id=in.bankitagent']"));
        				if(wb.isDisplayed()) 
        				{
        					wb4.click();
        				}
        				
        				// Compare 'Support' text in footer on login page
        				WebElement strvalue = driver.findElement(By.xpath("//h4[text()='Support']"));
        				String exprslt = "Support";
        				String actrslt=strvalue.getText();
        				
        				
        				if(exprslt.equals(actrslt))
        				{
        					System.out.println("Test Case passed__Support");
        					System.out.println(actrslt);
        				}
        				else { System.out.println("Test Case does not passed__Support"); }
        				
        				//compare 'support@bankit.in' icon on login page
        				
        				WebElement icon=driver.findElement(By.xpath("//i[@class='fa fa-envelope']"));
        				if(icon.isDisplayed()) 
        				{
        					System.out.println("icon is displayed");
        				} else { System.out.println("icon is not displayed");}
        				
        				// Compare 'support@bankit.in' text in footer on login page
        				
        				WebElement strvalue1=driver.findElement(By.xpath("//h5[contains(text(),'support@bankit.in')]"));
        				String exprslt1="support@bankit.in";
        				String actrslt1=strvalue1.getText();
        				
        				if(exprslt1.equals(actrslt1)) 
        				{
        					System.out.println("Test Case passed__support@bankit.in");
        					System.out.println(actrslt1);
        				}
        				else {System.out.println("Test Case not passed__support@bankit.in");}
        				
        				// Compare 'Connect with us' text in footer on login page
        				
        				WebElement strvalue2 = driver.findElement(By.xpath("//h4[text()='Connect with us']"));
        				String exprslt2="Connect with us";
        				String actrslt2=strvalue2.getText();
        				if(exprslt2.equals(actrslt2)) 
        				{
        					System.out.println("Test Case passed__connect with us");
        					System.out.println(actrslt2);
        				}else {System.out.println("Test Case not passed__connect with us");}
        				
        				// Compare 'Biomatric Device Support for Morpho' text in footer on login page
        				
        				WebElement strvalue3=driver.findElement(By.xpath("//h4[text()='Biometric Device Support for Morpho ']"));
        				String exprslt3="Biomatric Device Support for Morpho";
        				String actrslt3=strvalue3.getText();
        				if(exprslt3.equals(actrslt3)) 
        				{
        					System.out.println("Test Case passed__biomatric device support for us");
        					System.out.println(actrslt3);
        				}else {System.out.println("Test Case not passed__biomatric device support for us");}
        				
        				// Compare '180030109585' number in footer on login page
        				
        				WebElement strvalue4=driver.findElement(By.xpath("//h5[contains(text(),'180030109585')]"));
        				String exprslt4="180030109585";
        				String actrslt4=strvalue4.getText();
        				if(exprslt4.equals(actrslt4)) 
        				{
        					System.out.println("Test Case passed__180030109585");
        					System.out.println(actrslt4);
        				}else {System.out.println("Test Case not passed__180030109585");}
        				
        				
        				// Compare 'Biometric Device Support for Mantra' number in footer on login page
        				
        				WebElement strvalue5=driver.findElement(By.xpath("//h4[text()='Biometric Device Support for Mantra']"));
        				String exprslt5="Biometric Device Support for Mantra";
        				String actrslt5=strvalue5.getText();
        				if(exprslt5.equals(actrslt5)) 
        				{
        					System.out.println("Test Case passed__Biometric Device Supoort for Mantra");
        					System.out.println(actrslt5);
        				}else {System.out.println("Test Case not passed__Biometric Device Supoort for Mantra");}
        				
        				// Compare 'Hello !' number in footer on login page
        				
        				WebElement strvalue6=driver.findElement(By.xpath("//font[text()='Hello !']"));
        				String exprslt6="Hello !";
        				String actrslt6=strvalue6.getText();
        				if(exprslt6.equals(actrslt6)) 
        				{
        					System.out.println("Test Case passed__Hello");
        					System.out.println(actrslt6);
        				}else {System.out.println("Test Case not passed__Hello");}
        				
        				// Compare 'Retailer' number in footer on login page
        				
        				WebElement strvalue7=driver.findElement(By.xpath("//strong[text()='Retailer']"));
        				String exprslt7="Retailer";
        				String actrslt7=strvalue7.getText();
        				if(exprslt7.equals(actrslt7)) 
        				{
        					System.out.println("Test Case passed__Retailer");
        					System.out.println(actrslt7);
        				}else {System.out.println("Test Case not passed__Reatiler");}
        				
        				
        				// Switch to parent window and match all window
 
        				String firstTab = driver.getWindowHandle();
 
        				System.out.println("firstTab::::::"+firstTab);
 
        				for(String handler : driver.getWindowHandles())
        				{
        					if(firstTab.equalsIgnoreCase(handler))
        					{
        						System.out.println("firstTab::"+firstTab);
        						System.out.println("handler::"+handler);
        						driver.switchTo().window(firstTab);
                            
        						// Enter into the frame
        						driver.switchTo().frame("Main");
                            
        						tagName = driver.findElement(By.xpath("//*[@id='div1']/input[1]")).getTagName();
        						System.out.println(tagName);
        						
        						//click on sign up button
        						WebElement gettext=driver.findElement(By.xpath("//a[text()='Sign Up']"));
        						gettext.click();
        						System.out.println(gettext.getText());
        						
        						Thread.sleep(2000);
        						
        						driver.switchTo().window(firstTab);   //switch to first window
        						
        						Thread.sleep(2000);
        						
        						driver.switchTo().frame("Main");      //switch to frame from first window
        						
        						//click on forgot password
        						WebElement gettext1 = driver.findElement(By.xpath("//a[text()=' Forgot Password?']"));
        						gettext1.click();
        						
        						Thread.sleep(2000);
        						
        						driver.navigate().back();    //back to parent page
        						
        						driver.switchTo().frame("Main"); //switch to frame again
                   
        						Thread.sleep(1000);
        						//Enter wrong email id for seach result.
        						driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Pooja");
        						driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("12345");
        						driver.findElement(By.xpath("//input[@id='login']")).click();
        						WebElement text1 = driver.findElement(By.xpath("//strong[text()='Your User Name or Password is Invalid.']"));
        						String text2 = "Your User Name or Password is Invalid.";
        						String textprint=text1.getText();
        						
        						if (textprint.equals(text2))
        						{
        							System.out.println("Test Case has Passed.");
        							System.out.println(textprint);
        						}
        						else
        							System.out.println("Test Case has failed.");
                   
        						Thread.sleep(1000);
        						// Enter correct email id or phone no.
        						driver.findElement(By.xpath("//*[@id='div1']/input[1]")).sendKeys("8512001213");
        						driver.findElement(By.xpath("//*[@id='div1']/input[1]")).sendKeys(Keys.TAB);
        						driver.findElement(By.xpath("//*[@id='div2']/input")).sendKeys("Yahoo@123");
        						driver.findElement(By.xpath("//*[@id='login']")).click();
                            
        						Thread.sleep(4000);
        						
        						
 
        						//ARemit
                            
        						// Handle alert message
        						
        						//driver.switchTo().frame("Main");
        						
        						driver.findElement(By.xpath("//*[@id='popup2']/div/div/button")).click();
                            
        						Thread.sleep(1000);
        						driver.findElement(By.xpath("//*[@id='popup3']/div/div/button")).click();

        						String alertMessage = "Please enter correct mobile number.";
        						WebElement MN = driver.findElement(By.id("mobile_no"));
        						MN.sendKeys("8512008818");
        						Thread.sleep(1000);
                            
        						WebElement Submit = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[1]/form/table/tbody/tr[2]/td[2]/input"));
        						Submit.click();
        						alertMessage = driver.switchTo().alert().getText();
        						driver.switchTo().alert().accept();
        						System.out.println(alertMessage);

        						//Enter for new registration
                            
        						//WebElement MN = driver.findElement(By.id("mobile_no"));
        						MN.sendKeys("8512008813");
        						driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[1]/form/table/tbody/tr[2]/td[2]/input")).click();
        						driver.findElement(By.id("c_name")).sendKeys("Idika");
        						driver.findElement(By.id("c_address")).sendKeys("GZB");
        						// WebElement dateBox = driver.findElement(By.id("c_dob"));

        						//Clicking on calendar to open calendar widget

                                 WebElement calendar = driver.findElement(By.id("c_dob"));
                                 calendar.click();
               
               
                                 // Select year first
                                 // Since drop down has been created using SELECT tag, We can use Select class.
               
                                 WebElement yearDropDown= driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]"));
                                 Select selectYear= new Select(yearDropDown);
                                 selectYear.selectByVisibleText("1987");
               
                                 Thread.sleep(2000);
               
                                 // Select Month
               
				                WebElement monthDropDown= driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]"));
				                Select selectMonth= new Select(monthDropDown);
				                selectMonth.selectByVisibleText("Jan");
				               
				                // Select date
				               
				                WebElement date= driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a"));
				                date.click();
				               
				                // Printing selected date
				                String selectedDate= calendar.getAttribute("value");
				                System.out.println("Selected Date: "+selectedDate);
				               
				                //Click on Submit button
				                            driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[1]/form/table/tbody/tr[5]/td[2]/input")).click();
				                       
				                         //Click on resend otp button
				                            String alertMessage1 = "OTP send to registered mobile number";
				                            driver.findElement(By.id("resend")).click();
				                            Thread.sleep(1000);
				                            alertMessage1 = driver.switchTo().alert().getText();
				                            driver.switchTo().alert().accept();
				                            System.out.println(alertMessage1);
                        
                        
                            
                            
                            //Enter incorrect OTP
				            driver.findElement(By.name("otp")).click();
                            driver.findElement(By.name("otp")).sendKeys("123456");
                            driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[1]/form/table/tbody/tr[6]/td[2]/input")).click();
                            String text3 = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[5]/div/div")).getText();
                    String text4 = "Problem to add customer.";
                   
                    if (text3.equals(text4)){
                    System.out.println("Test Case has Passed.");
                    System.out.println("Pelase enter correct OTP.");
                    }
                    else
                    System.out.println("Test Case has failed.");
                            Thread.sleep(1000);
                            
                            driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[1]/form/table/tbody/tr[2]/td[2]/input")).click();

                            Thread.sleep(1000);
                            String alertMessage2 = "Enter Correct mobile number";
                            alertMessage2 = driver.switchTo().alert().getText();
                            driver.switchTo().alert().accept();
                            System.out.println(alertMessage2);
                         

                    //Enter register mobile number
                                driver.findElement(By.name("mobile_no")).click();
                                driver.findElement(By.name("mobile_no")).sendKeys("8512001213");
                            driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[1]/form/table/tbody/tr[2]/td[2]/input")).click();

                                // Click on Refund TAB
                            driver.findElement(By.xpath("//*[@id='rftran']/input")).click();

                            
                           // driver.findElement(By.linkText("Resend OTP")).click();
                            driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[2]/form/table/tbody/tr[3]/td[3]/a")).click();
                            String alertMessage3 = "Service Delivery TID";
                            alertMessage3 = driver.switchTo().alert().getText();
                            driver.switchTo().alert().accept();
                                                        
                                driver.findElement(By.xpath("//*[@id='tran_id']")).sendKeys("1234567890");
                            
                            driver.findElement(By.name("otp")).click();
                            driver.findElement(By.name("otp")).sendKeys("123456");
                            driver.findElement(By.xpath("//*[@id='img_btn']")).click();
                            String text5 = driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[2]/form/table/tbody/tr[1]/td/span")).getText();
                    String text6 = "Problem to add customer.";
                   
                    if (text5.equals(text6)){
                    System.out.println("Test Case has Passed.");
                    System.out.println("Invalid Transaction and OTP.");
                    }
                    else
                    System.out.println("Test Case has failed.");
                   
                    Thread.sleep(1000);
                   
                    driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[2]/form/table/tbody/tr[4]/td[1]/a/input")).click();
                    Thread.sleep(1000);

                    driver.findElement(By.xpath("//*[@id='a_benfeciary']/input")).click();
                    //driver.findElement(By.xpath("//*[@id='mob_no']")).isEnabled();// == false
                   
                    /*WebElement elable = driver.findElement(By.xpath("//*[@id='mob_no']"));
                    boolean status = elable.isEnabled();
                    System.out.println(status);
                     
                    if(status ){
                    elable.sendKeys("98765432345");*/
                     driver.findElement(By.xpath("//*[@id='beneficiary_name']")).sendKeys("Pooja");
				     driver.findElement(By.xpath("//*[@id='beneficiary_mob_no']")).sendKeys("9719777049");
				     driver.findElement(By.xpath("//*[@id='account_no']")).sendKeys("34963119248");
				     driver.findElement(By.xpath("//*[@id='confirm_acc_no']")).sendKeys("34963119248");
				     driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[2]/form/div/table/tbody/tr/td[1]/input")).click();
				                    //text1.equals(text2)
				        //driver.navigate().refresh();
        
        
}}}}}}}}  

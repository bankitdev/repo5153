/**
 * 
 */
package com.ro.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jfree.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sunil Kashyap
 *
 *         Created Date 04-Feb-2019
 */
public class VideoTutorials {
	@FindBy(xpath = "//u[contains(text(),'AEPS cash withdrawal tutorial')]")
	WebElement withdrawalTutorial;
	@FindBy(xpath = "//u[contains(text(),'AEPS balance inquiry tutorial')]")
	WebElement balanceInquiryTutorial;
	@FindBy(xpath = "//u[contains(text(),' AEPS report tutorial')]")
	WebElement reportTutorial;
	@FindBy(xpath = "//u[contains(text(),'AEPS Settlement in Bank Account')]")
	WebElement settlementBankAcc;
	@FindBy(xpath = "(//u[contains(text(),'SafeGold Tutorial')])[2]")
	WebElement safeGoldTutorial;

	WebDriver driver;

	public VideoTutorials(WebDriver driver) {
		this.driver = driver;
	}

	@SuppressWarnings("unchecked")
	public void videoTutorial() 
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String winHandleMain = driver.getWindowHandle();
		
		List list = new ArrayList<>();

		list.add("withdrawalTutorial");
		list.add("balanceInquiryTutorial");
		list.add("reportTutorial");
		list.add("settlementBankAcc");
		list.add("safeGoldTutorial");

		for (int i = 0; i < list.size(); i++) 
		{
			String linksList = (String) list.get(i);

			if (linksList.equals("withdrawalTutorial")) 
			{
				withdrawalTutorial.click();
			} else if (linksList.equals("balanceInquiryTutorial")) 
			{
				balanceInquiryTutorial.click();
			} else if (linksList.equals("reportTutorial")) 
			{
				reportTutorial.click();
			} else if (linksList.equals("settlementBankAcc")) 
			{
				settlementBankAcc.click();
			} else if (linksList.equals("safeGoldTutorial")) 
			{
				safeGoldTutorial.click();
				driver.switchTo().window(winHandleMain);
			} else {
				System.out.println("Something went Wrong");
			}
		}
	}
}

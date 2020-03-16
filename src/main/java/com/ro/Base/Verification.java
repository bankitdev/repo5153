/**
 * 
 */
package com.ro.Base;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


/**
 * @author Sunil Kashyap
 *
 *         Created Date 28-Jan-2019
 */
public class Verification {
	
	@FindBy(xpath = "//img[contains(@src,'https://www.bankit.in/assets/images/logo.png')]")
	WebElement image;
	
	WebDriver driver;

	public Verification(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyImage() {
		String text = "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0";
		Boolean imagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(text, image);
		if (!imagePresent) {
			System.out.println("Image not displayed.");
		} else {
			System.out.println("Image displayed.");
		}
	}

	public void imageSize() {
		int width = image.getSize().getWidth();
		int height = image.getSize().getHeight();

		System.out.println("----------------------------------------------");
		System.out.println("The image width is = " + width + " And The image height is = " + height);

		// Assert.assertEquals(width, "235");
		// Assert.assertSame(width, 235, "Image width is equal");

		/*-------------print marquee------------------------
		*/
		try {
				WebElement textHtml = driver.findElement(By.xpath("//marquee[@id='marq6']/a"));
				String textmsg=textHtml.getText();
				if(textmsg != null) {
					System.out.println(textmsg);
				}
			} catch (Exception e) {
				System.out.println("HTML text is not visible");
			}

			System.out.println("----------------------------------------------");
		try {
				WebElement textHtml1 = driver.findElement(By.xpath("//marquee[@id='marq7']/a"));
				String msg = textHtml1.getText();
				if (msg != null) {
					System.out.println(textHtml1.getText());
				} 
			} catch (Exception e) {
			System.out.println("HTML text is not visiable");
			}
	}

	public void verifyTexts() {
		System.out.println("----------------------------------------------");
		WebElement texts = driver.findElement(By.xpath("//p[@class='welcome_txt pull-right']"));
		String textsMsg = texts.getText();
		if (textsMsg.equals("Welcome SUNIL KUMAR-RO EMP AES, AG22052.")) {
			System.out.println("Texts is matched");
		} else {
			System.out.println("Text is not match");
		}
		System.out.println(texts.getText());

		System.out.println("----------------------------------------------");
		WebElement welcometexts = driver.findElement(By.xpath("//div[@class='col-md-9 get_reg']/h2/a"));
		String welCometextsMsg = welcometexts.getText();
		if (welCometextsMsg.equals("Welcome to the world of BankIT!")) {
			System.out.println("Welcome.. Texts is matched.Test Case passed");
		} else {
			System.out.println("Welcome.. Text is not match.Test Case failed");
		}
		System.out.println(welcometexts.getText());
		System.out.println("----------------------------------------------");

		WebElement text=driver.findElement(By.xpath("//div[@class='col-md-9 get_reg']/p"));
		String actltextMsg=text.getText();
		String expcdtextMsg="Get ready to experience the best & the simplest Digital Service Delivery Portal.Lets serve every city & village of India together";
		if(actltextMsg.equals(expcdtextMsg)) {
			System.out.println("Get ready to... texts is match. Test Case passed");
		}else {System.out.println("Get ready to... texts is not match. Test Case failed");}
		System.out.println(actltextMsg);
		System.out.println("----------------------------------------------");
		
		WebElement otherLinktext=driver.findElement(By.xpath("//div[@class='col-md-12']/h2/a"));
		String actlotherLinktextMsg=otherLinktext.getText();
		String expcdotherLinktextMsg="Other Links";
		if(actlotherLinktextMsg.equals(expcdotherLinktextMsg)) {
			System.out.println("Other Links... texts is match. Test Case passed");
		}else {System.out.println("Other Links... texts is not match. Test Case failed");}
		System.out.println(actlotherLinktextMsg);
		
		System.out.println("----------------------------------------------");
		WebElement otherLinkTexts = driver.findElement(By.xpath("//h2[@class='mT30 pLR15']/a"));
		String otherLinktextsMsg = otherLinkTexts.getText();
		if (otherLinktextsMsg.equals("Other Links")) {
			System.out.println("Other Link Texts is matched");
		} else {
			System.out.println("Other Link Text is not match");
		}
		System.out.println(otherLinkTexts.getText());

		System.out.println("----------------------------------------------");
		WebElement serviceTutorialTexts = driver.findElement(By.xpath("(//span[@class='oth_txt']/h3)[1]"));
		String serviceTutorialtextsMsg = serviceTutorialTexts.getText();
		if (serviceTutorialtextsMsg.equals("Service Tutorials")) {
			System.out.println("Service Tutorial Texts is matched");
		} else {
			System.out.println("Service Tutorial Text is not match");
		}
		System.out.println(serviceTutorialTexts.getText());

		System.out.println("----------------------------------------------");
		WebElement videoTutorialTexts = driver.findElement(By.xpath("(//span[@class='oth_txt']/h3)[2]"));
		String videoTutorialtextsMsg = videoTutorialTexts.getText();
		if (videoTutorialtextsMsg.equals("Video Tutorials")) {
			System.out.println("Video Tutorial Texts is matched");
		} else {
			System.out.println("Video Tutorial Text is not match");
		}
		System.out.println(videoTutorialTexts.getText());

		System.out.println("----------------------------------------------");
		WebElement yourperformanceTexts = driver.findElement(By.xpath("(//span[@class='oth_txt']/h3)[3]"));
		String yourPerformancetextsMsg = yourperformanceTexts.getText();
		if (yourPerformancetextsMsg.equals("Your Performance")) {
			System.out.println("Your Performance Texts is matched");
		} else {
			System.out.println("Your Performance Text is not match");
		}
		System.out.println(yourperformanceTexts.getText());
	}

	public void verifyButton() {
		/*----------------Balance button size-------------------
		*/
		System.out.println("----------------------------------------------");
		WebElement balanceButton = driver.findElement(By.xpath("//p[@class='balance_box']"));
		int balancewidth = balanceButton.getSize().getWidth();
		int balanceheight = balanceButton.getSize().getHeight();
		System.out.println("The balance button width is = " + balancewidth + " And The balance button height is = "
				+ balanceheight);
		WebElement balancetexts = driver.findElement(By.xpath("//p[@class='balance_box']/span"));
		String balanceMsg = balancetexts.getText();
		if (balanceMsg.equals("Balance ")) {
			System.out.println("Balance Texts is match");
		} else {
			System.out.println("Balance Text is not match");
		}
		System.out.println(balancetexts.getText());

		/*----------------My Account button size-------------------
		*/

		WebElement myAccountButton = driver.findElement(By.xpath("//div[@class='btn-group']/button"));
		int myAccountWidth = myAccountButton.getSize().getWidth();
		int myAccountHeight = myAccountButton.getSize().getHeight();
		System.out.println("The my account button width is = " + myAccountWidth
				+ " And The my account button height is = " + myAccountHeight);
		WebElement myAccounttexts = driver.findElement(By.xpath("//button[@class='btn btn-default dropdown-toggle']"));
		String myAccountMsg = myAccounttexts.getText();
		System.out.println("----------------------------------------------");
		if (myAccountMsg.equals("My Account")) {
			System.out.println("My Account Texts is matched");
		} else {
			System.out.println("My Account Text is not match");
		}
		System.out.println(myAccounttexts.getText());
	}

	public void serviceTutorialLink() {
		WebElement aepsServiceTutorial = driver
				.findElement(By.xpath("//u[contains(text(),'AEPS Service Tutorial (step by step)')]"));
		aepsServiceTutorial.click();

		WebElement morphoRDServiceSetup = driver
				.findElement(By.xpath("//u[contains(text(),'Morpho- RD Service Setup file download')]"));
		morphoRDServiceSetup.click();

		WebElement morphoRDServiceSetupInstallation = driver
				.findElement(By.xpath("//u[contains(text(),'Morpho- RD Service Setup Installation Guide')]"));
		morphoRDServiceSetupInstallation.click();

		WebElement mantraUserManuals = driver.findElement(By.xpath("//u[contains(text(),'Mantra User Manuals')]"));
		mantraUserManuals.click();

		WebElement mantraInstallationSetUp = driver
				.findElement(By.xpath("//u[contains(text(),'Mantra Installation Setups')]"));
		mantraInstallationSetUp.click();

		WebElement safeGoldTutorial = driver.findElement(By.xpath("(//u[contains(text(),'SafeGold Tutorial')])[1]"));
		safeGoldTutorial.click();
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement more = driver.findElement(By.xpath("//a[contains(text(),'More...')]"));
		more.click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.switchTo().window(tabs2.get(0));

		System.out.println("----------------------------------------------");
		System.out.println("Service Tutorial's all links is clickable...");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void yourPerformance() {
		
		System.out.println("================Your Performance==========================");
		
		WebElement yourPerfTexts=driver.findElement(By.xpath("(//span[@class='oth_txt']/h3)[3]"));
		String actlyourPerfTextsMsg=yourPerfTexts.getText();
		String expctyourPerfTextsMsg="Your Performance";
		Assert.assertEquals(actlyourPerfTextsMsg, expctyourPerfTextsMsg);
		System.out.println(actlyourPerfTextsMsg);
		System.out.println("The Text "+actlyourPerfTextsMsg+" is matched. Test Case passed");
		
	}

}

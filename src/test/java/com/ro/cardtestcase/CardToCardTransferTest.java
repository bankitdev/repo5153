/**
 * 
 */
package com.ro.cardtestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.ro.Base.LoginPage;
import com.ro.card.CardToCardTransfer;

/**
 * @author Sunil Kashyap
 *
 * Created Date 24-Dec-2018
 */
public class CardToCardTransferTest extends LoginPage{
	
	@Test
	public void initializeMethod() 
	{
		CardToCardTransfer cardToCardTransfer=PageFactory.initElements(driver, CardToCardTransfer.class);
		cardToCardTransfer.setUpMethod();
		cardToCardTransfer.fillUpDetailsTC1();
		/*cardToCardTransfer.fillUpDetailsTC2();
		cardToCardTransfer.fillUpDetailsTC3();
		cardToCardTransfer.fillUpDetailsTC4();*/
		//cardToCardTransfer.verifySizeAndText();
	}
	/*@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}*/
}

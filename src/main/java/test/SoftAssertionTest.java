/**
 * 
 */
package test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @author Sunil Kashyap
 *
 * Created Date 18-Dec-2018
 */
public class SoftAssertionTest 
{	
	SoftAssert softAssert=new SoftAssert();
	@Test
	public void softAssert() 
	{
		softAssert.assertEquals(10, 12,"this number is same");
		Reporter.log("Both are not same");
	//	softAssert.assertAll();
	}
	@Test
	public void softAssert1() 
	{
		softAssert.assertEquals("Batman", "SuperMan","both is same");
		Reporter.log("Both are not same");
	//	softAssert.assertAll();
	}
	@Test
	public void softAssert2() 
	{
		softAssert.assertEquals("INDIA", "INDIA");
		Reporter.log("Both are same");
		//softAssert.assertAll();
	}
}

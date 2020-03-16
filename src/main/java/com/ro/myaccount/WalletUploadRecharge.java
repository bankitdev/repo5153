/**
 * 
 */
package com.ro.myaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Sunil Kashyap
 *
 *         Created Date 24-Jan-2019
 */
public class WalletUploadRecharge {
	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle' and @type='button']")
	WebElement myAccount;
	@FindBy(xpath = "//div[@class='col-md-2 my_account noP']/div/ul/li/a[contains(text(),'Wallet Upload/Recharge')]")
	WebElement walletUploadRecharge;
	@FindBy(name = "requestAmount")
	WebElement requestForAmount;
	/*-------------------------CMD--------------------------------*/
	@FindBy(name = "recvBankName")
	WebElement recBankName;
	@FindBy(name="depositByMobileNo")
	WebElement MobileNo;
	@FindBy(name="depositToMobileNo")
	WebElement branchName;
	@FindBy(id="cdmReceiptFile")
	WebElement cdmUploadReceipt;
	@FindBy(name="eRemark")
	WebElement cdmRemark;
	/*-------------------------NEFT/RTGS/FT/IMPS--------------------------------*/
	@FindBy(name = "neftSenderName")
	WebElement senderName;
	@FindBy(name = "neftSenderAcNo")
	WebElement accountNo;
	@FindBy(name = "neftBankName")
	WebElement bankName;
	@FindBy(name = "neftTransferTID")
	WebElement transNo;
	@FindBy(name = "neftToBankName")
	WebElement sendToBankName;
	@FindBy(name = "neftBenifisharyName")
	WebElement benifisharyName;
	@FindBy(id = "neftReceiptFile")
	WebElement neftUploadReceipt;
	@FindBy(name = "neftRemark")
	WebElement neftremarks;
	/*-------------------------Cash in Bank--------------------------------*/
	@FindBy(name="depositerName")
	WebElement depoName;
	@FindBy(name="cdReceivingBankName")
	WebElement aesBankName;
	@FindBy(name="cdReceivingBankAcNo")
	WebElement cibAccNo;
	@FindBy(name="cdReceivingBranchName")
	WebElement cibBranchName;
	@FindBy(name="cdDepositLocation")
	WebElement depoLocation;
	@FindBy(name="cdDepositingBranchTID")
	WebElement depoBranchCode;
	@FindBy(id="cashReceiptFile")
	WebElement cashRcptFile;
	@FindBy(name="cdRemark")
	WebElement cibRemark;
	
	@FindBy(id="img_btn")
	WebElement submitBtn;
	@FindBy(id="img_btn2")
	WebElement continueBtn;
	
	@FindBy(name="paymentMode")
	WebElement paymntMode;
	WebDriver driver;

	public WalletUploadRecharge(WebDriver driver) {
		this.driver = driver;
	}

	public void initializeProcess(int amt, String recBnkName, String mobNo, String brnchName, String uploadrcpt,String remarkText,
			String sndrName,String accNo, String bName, String transNu, String sendTobnkName,String benifName, String neftUploadrcpt,String neftRmrk,
		String depName, String aesBnkName,String cibAccNum, String cibBrnchName, String dLocation, String dBrnchCode,String cibRecfile, String cibRmrk) {
		
		
		Actions actions = new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(myAccount).click().build().perform();
		walletUploadRecharge.click();

		requestForAmount.sendKeys(String.valueOf(amt));
		paymntMode.click();
		
		String[] paymentMode= {"CDM","NEFT/RTGS/FT/IMPS","Cash in Bank"};
		for(int i=0;i<paymentMode.length;i++) 
		{
			String paymentModes=paymentMode[i];
			if(paymentModes.equals("CDM")) {
				
				new Select(paymntMode).selectByValue("CDM");
				new Select(recBankName).selectByVisibleText(recBnkName);
				MobileNo.sendKeys(mobNo);
				branchName.sendKeys(brnchName);
				cdmUploadReceipt.sendKeys(uploadrcpt);
				cdmRemark.sendKeys(remarkText);
				submitBtn.click();
				continueBtn.click();
			}
			else if(paymentModes.equals("NEFT/RTGS/FT/IMPS")) {
				requestForAmount.sendKeys(String.valueOf(amt));
				new Select(paymntMode).selectByValue("NEFT/RTGS/FT/IMPS");
				senderName.sendKeys(sndrName);
				accountNo.sendKeys(accNo);
				new Select(bankName).selectByVisibleText(bName);
				transNo.sendKeys(transNu);
				new Select(sendToBankName).selectByVisibleText(sendTobnkName);
				benifisharyName.sendKeys(benifName);
				neftUploadReceipt.sendKeys(neftUploadrcpt);
				neftremarks.sendKeys(neftRmrk);
				submitBtn.click();
				continueBtn.click();
			}
			else {
				requestForAmount.sendKeys(String.valueOf(amt));
				new Select(paymntMode).selectByValue("Cash in Bank");
				depoName.sendKeys(depName);
				new Select(aesBankName).selectByVisibleText(aesBnkName);
				cibAccNo.sendKeys(cibAccNum);
				cibBranchName.sendKeys(cibBrnchName);
				depoLocation.sendKeys(dLocation);
				depoBranchCode.sendKeys(dBrnchCode);
				cashRcptFile.sendKeys(cibRecfile);
				cibRemark.sendKeys(cibRmrk);
				submitBtn.click();
				continueBtn.click();
			}	
		}
		WebElement textMsg=driver.findElement(By.xpath("//div[@class='col-md-12 tog_box']/div/div/div[1]"));
		System.out.println(textMsg.getText());
	}
}

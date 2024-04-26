package com.uitest.pages;

import java.time.Duration;
import com.uitest.pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

	public WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	// Fields of Payment form

	@FindBy(id = "cardHolderName")
	public WebElement txt_chname;

	@FindBy(id = "cardTypeVISA")
	public WebElement cbox_visa;

	@FindBy(id = "cardNumber")
	public WebElement txt_cnum;

	@FindBy(id = "cardCVV")
	public WebElement txt_ccvv;

	@FindBy(id = "cardExpiryMonth")
	public WebElement drpdwn_expMonth;

	@FindBy(id = "cardExpiryYear")
	public WebElement txt_expYear;

	@FindBy(xpath = "//*[text()='Next']")
	public WebElement nextbtn;
	
	@FindBy(xpath = "//label[@for='termsAndConditions']")
	public WebElement label_tnc;
	
	// Payment methods
	public void clickNxtBtn() {
		nextbtn.click();
	}
	
	public String labelTnC() {
		wait.until(ExpectedConditions.visibilityOf(label_tnc));
		return label_tnc.getText();

	}
		
public void prevPageFormFill() {
	RegistrationPage rp = new RegistrationPage(driver);
	ContactPage cp = new ContactPage(driver);
	rp.registerUser("Siri@123.com", "qwe", "qwe");
	cp.userContactInfo("user", "", "lname", "xxxxx, xxxxxx", "", "", "123654", "Hyderabad", "Northern Territory");
}
	

	public void paymentInfo(String CHolderName, String cardNumb, String cardCVV, String cExpMnth, String cExpYear) {

		txt_chname.sendKeys(CHolderName);
		txt_cnum.sendKeys(cardNumb);
		cbox_visa.sendKeys(cardCVV);
		txt_expYear.sendKeys(cExpYear);
		Select dropdown = new Select(drpdwn_expMonth);
		dropdown.selectByValue(cExpMnth);
		clickNxtBtn();
		wait.until(ExpectedConditions.visibilityOf(nextbtn));

	}

	public String getPaymentemsg(String pemsgtext) {

		String etext = String.format("//span[normalize-space()='%s']", pemsgtext);
		return driver.findElement(By.xpath(etext)).getText();
	}

}

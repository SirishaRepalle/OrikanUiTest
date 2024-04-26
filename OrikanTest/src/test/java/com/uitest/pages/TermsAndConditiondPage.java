package com.uitest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TermsAndConditiondPage {

	public WebDriver driver;

	public TermsAndConditiondPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	// Elements of Terms and Conditions

	@FindBy(id = "termsAndConditions")
	public WebElement txtarea_tandc;

	@FindBy(id = "termsCheckbox")
	public WebElement termsCheckbox;

	@FindBy(xpath = "//*[text()='Next']")
	public WebElement nextbtn;

	@FindBy(xpath = "//div[@class='validation error']")
	public WebElement txt_pemsg;

	@FindBy(id = "successMessage")
	public WebElement txt_cnfmsg;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	public WebElement btn_sbmt;
	
	@FindBy(xpath = "//p[normalize-space()='Welcome, .']")
	public WebElement label_cnf;
	
	

	// Methods

	public void clicksbmtBtn() {

		btn_sbmt.click();

	}
	
	public void prevPageFormFill() {
		RegistrationPage rp = new RegistrationPage(driver);
		ContactPage cp = new ContactPage(driver);
		PaymentPage pp = new PaymentPage(driver);
		rp.registerUser("Siri@123.com", "qwe", "qwe");
		cp.userContactInfo("user", "", "lname", "xxxxx, xxxxxx", "", "", "123654", "Hyderabad", "Northern Territory");
		pp.paymentInfo("Sirisha", "1234123456987825", "321", "September", "1965");
	}
		

	public void checkTermsCheckbox() {
		if (!termsCheckbox.isSelected()) {
			termsCheckbox.click();
		}
	}

	public void uncheckTermsCheckbox() {
		if (termsCheckbox.isSelected()) {
			termsCheckbox.click();
		}
	}

	public void submitForm(boolean acceptTerms) {
		if (acceptTerms) {
			checkTermsCheckbox();
		} else {
			uncheckTermsCheckbox();
		}

		clicksbmtBtn();
	}

	public String labelTnC() {
		wait.until(ExpectedConditions.visibilityOf(label_cnf));
		return label_cnf.getText();

	}
	
	public String gettncemsg() {

		return txt_pemsg.getText();
	}

	public String gettncsucmsg() {

		return txt_cnfmsg.getText();
	}

}

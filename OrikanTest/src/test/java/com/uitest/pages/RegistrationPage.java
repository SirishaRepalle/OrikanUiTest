package com.uitest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uitest.base.BaseTest;

public class RegistrationPage extends BaseTest {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Registration form
	@FindBy(id = "emailAddress")
	public WebElement emailfield;

	@FindBy(id = "password")
	public WebElement passwordfield;

	@FindBy(id = "confirmPassword")
	public WebElement cPasswordfield;

	@FindBy(xpath = "//*[text()='Next']")
	public WebElement nextbtn;

	@FindBy(xpath = "(//span[normalize-space()='Invalid email address.'])[1]")
	public WebElement emailError;

	@FindBy(css = "div[class='validation error'] span")
	public WebElement cpswdError;

	@FindBy(xpath = "//button[normalize-space()='Back']")
	public WebElement backBtn;

	@FindBy(id = "successMessage")
	public WebElement successMessage;

	@FindBy(xpath = "//div[@class='main']//div[1]//label[1]")
	public WebElement txt_fNameLabel;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	// Registration methods

	public void registerUser(String email, String password, String confirmPassword) {

		emailfield.clear();
		emailfield.sendKeys(email);
		passwordfield.clear();
		passwordfield.sendKeys(password);
		cPasswordfield.clear();
		cPasswordfield.sendKeys(confirmPassword);
		clickNxtBtn();
		wait.until(ExpectedConditions.visibilityOf(nextbtn));

	}
	
	

	public String firstName() {
		wait.until(ExpectedConditions.visibilityOf(txt_fNameLabel));
		return txt_fNameLabel.getText();

	}


	public String getErrorMessage(String emsgtext) {
		String dynamicXPath = String.format("//span[normalize-space()='%s']", emsgtext);
		return driver.findElement(By.xpath(dynamicXPath)).getText();

	}

	public void clickNxtBtn() {

		nextbtn.click();

	}

	public String cpswErrorMessage() {
		return cpswdError.getText();
	}

	public String getEmailErrorMessage() {
		return emailError.getText();
	}

}

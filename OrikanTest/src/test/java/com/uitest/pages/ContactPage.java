package com.uitest.pages;

import com.uitest.pages.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

	public WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	// Fields of Contact form

	@FindBy(id = "firstName")
	public WebElement txt_fName;

	@FindBy(id = "lastName")
	public WebElement txt_lName;

	@FindBy(id = "middleName")
	public WebElement txt_mName;

	@FindBy(id = "addressLine1")
	public WebElement txt_addressLine1;

	@FindBy(id = "addressLine2")
	public WebElement txt_addressLine2;

	@FindBy(id = "addressLine3")
	public WebElement txt_addressLine3;

	@FindBy(id = "preferredFullName")
	public WebElement txt_pFname;

	@FindBy(id = "postcode")
	public WebElement txt_postCode;

	@FindBy(id = "city")
	public WebElement txt_city;

	@FindBy(xpath = "//select[@id='state']")
	public WebElement drpdwn_state;

	@FindBy(xpath = "//*[text()='Next']")
	public WebElement nextbtn;
	
	@FindBy(xpath = "//label[contains(text(), 'Card Holder Name')]")
	public WebElement label_crdhldr;
	

	// Contact methods

	public void clickNxtBtn() {

		nextbtn.click();

	}

	public String cardHolder() {
		wait.until(ExpectedConditions.visibilityOf(label_crdhldr));
		return label_crdhldr.getText();

	}
	
	
	
	public void registerUser(String email, String password, String confirmPassword) {
		RegistrationPage rp = new RegistrationPage(driver);

		rp.emailfield.sendKeys("sirisha@test.com");
		rp.passwordfield.sendKeys("123");
		rp.cPasswordfield.sendKeys("123");		
		clickNxtBtn();
		wait.until(ExpectedConditions.visibilityOf(nextbtn));

	}
	
	public void userContactInfo(String firstName, String midName, String lastName, String addr1, String addr2,
			String addr3, String postCodeValue, String cityName, String stateName) {
		txt_fName.sendKeys(firstName);
		txt_mName.sendKeys(midName);
		txt_lName.sendKeys(lastName);
		txt_addressLine1.sendKeys(addr1);
		txt_addressLine2.sendKeys(addr2);
		txt_addressLine3.sendKeys(addr3);
		txt_postCode.sendKeys(postCodeValue);
		txt_city.sendKeys(cityName);
		Select dropdown1 = new Select(drpdwn_state);
		dropdown1.selectByValue(stateName);
		clickNxtBtn();
		wait.until(ExpectedConditions.visibilityOf(nextbtn));

	}
	

	public String getErrorMessage(String emsgtext) {
		String dynamicXPath = String.format("//span[normalize-space()='%s']", emsgtext);
		return driver.findElement(By.xpath(dynamicXPath)).getText();
	}

	
}

package com.uitest.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.uitest.annotations.dataProviders;
import com.uitest.base.BaseTest;
import com.uitest.pages.*;

public class Contact extends BaseTest {
/*This test is to verify the positive flow*/
	@Test(dataProvider = "contactpositiveData", dataProviderClass = dataProviders.class, priority = 4)
	public void contactformPositiveFlow(String firstName, String midName, String lastName, String addr1, String addr2, String addr3,
			String postCodeValue, String cityName, String stateName, String expectedMessage,
			boolean isSuccessExpected) {

		ContactPage cp = new ContactPage(driver);
		cp.registerUser(cityName, stateName, expectedMessage);
		cp.userContactInfo(firstName, midName, lastName, addr1, addr2, addr3, postCodeValue, cityName, stateName);

		if (isSuccessExpected) {
			assertEquals(cp.cardHolder(), "Card Holder Name*");
			navigateToReg();
		} else {
			assertEquals(cp.getErrorMessage(expectedMessage), expectedMessage);
		}

	}

	
	/*This test is to verify the positive flow*/
	@Test(dataProvider = "contactNegativeData", dataProviderClass = dataProviders.class, priority = 5)
	public void contactformNegativeFlow(String firstName, String midName, String lastName, String addr1, String addr2, String addr3,
			String postCodeValue, String cityName, String stateName, String expectedMessage,
			boolean isSuccessExpected) {

		ContactPage cp = new ContactPage(driver);

		cp.userContactInfo(firstName, midName, lastName, addr1, addr2, addr3, postCodeValue, cityName, stateName);
		
		if (isSuccessExpected) {
			assertEquals(cp.cardHolder(),  "Card Holder Name*");
		} else {
			assertEquals(cp.getErrorMessage(expectedMessage), expectedMessage);
		}

	}

	
}

package com.uitest.tests;

import com.uitest.base.BaseTest;
import com.uitest.pages.RegistrationPage;
import com.uitest.annotations.dataProviders;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/* To verify the positive valid flow of Registration form */
public class Registration extends BaseTest {

	
	@Test(dataProvider = "registrationPositive", dataProviderClass = dataProviders.class, priority = 1)
	public void registrationform(String email, String password, String cPassword, String expectedMessage,
			boolean isSuccessExpected) throws InterruptedException {

		RegistrationPage rp = new RegistrationPage(driver);

		rp.registerUser(email, password, cPassword);

		if (isSuccessExpected) {
			// Verify success message for positive test cases
			assertEquals(rp.firstName(), "First Name*");
			navigateToReg();

		} else {
			// Verify error message for negative test cases
			assertEquals(rp.getErrorMessage(expectedMessage), expectedMessage);
		}

	}

	/* To verify the negative flow and Error Messaged of Registration form */
	@Test(dataProvider = "registrationNegative", dataProviderClass = dataProviders.class, priority = 2)
	public void registrationformNegativeCases(String email, String password, String cPassword, String expectedMessage,
			boolean isSuccessExpected) throws InterruptedException {

		RegistrationPage rp = new RegistrationPage(driver);

		rp.registerUser(email, password, cPassword);

		if (isSuccessExpected) {
			// Verify success message for positive test cases
			assertEquals(rp.firstName(), "First Name*");
			navigateToReg();
		} else {
			// Verify error message for negative test cases
			assertEquals(rp.getErrorMessage(expectedMessage), expectedMessage);
			navigateToReg();
		}

	}

	/*
	 * On Clicking the next button twice, payment form displayed instead of Contact
	 * Form
	 */
	@Test(priority = 3)
	public void dblClickOnNxt() throws InterruptedException {

		RegistrationPage rp = new RegistrationPage(driver);
		rp.registerUser("uese@test.com", "qwe", "qwe");
		rp.clickNxtBtn();
		assertEquals(rp.firstName(), "First Name*");

	}

}

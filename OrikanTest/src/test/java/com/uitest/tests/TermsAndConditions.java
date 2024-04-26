package com.uitest.tests;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.uitest.base.BaseTest;
import com.uitest.pages.PaymentPage;
import com.uitest.pages.TermsAndConditiondPage;

public class TermsAndConditions extends BaseTest {

	@Test(priority = 7)
	public void testSubmitWithAcceptedTerms() {
		// Create an instance of the TermsAndConditionsPage
		TermsAndConditiondPage tc = new TermsAndConditiondPage(driver);
		PaymentPage pp = new PaymentPage(driver);
		pp.prevPageFormFill();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down the text area (you may need to adjust the scroll amount)
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", tc.txtarea_tandc);
		tc.checkTermsCheckbox();

		tc.submitForm(true);

		// Verify the success message
		assertEquals(tc.labelTnC(), "Welcome, .");
	}

	@Test(priority = 8)
	public void testSubmitWithoutAcceptedTerms() {
		TermsAndConditiondPage tc = new TermsAndConditiondPage(driver);

		tc.submitForm(false);

		assertEquals(tc.gettncemsg(), "You must accept the terms and conditions.");
	}
}

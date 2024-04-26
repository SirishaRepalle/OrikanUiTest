package com.uitest.tests;

import com.uitest.base.BaseTest;
import com.uitest.pages.PaymentPage;
import com.uitest.annotations.dataProviders;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/* To verify the positive valid flow of Terms and Conditions form */
public class Payment extends BaseTest {
	@Test(dataProvider = "paymentPositiveData", dataProviderClass = dataProviders.class, priority = 5)
	public void paymentFormPositiveData(String CHolderName, String cardNumb, String cardCVV, String cExpMnth, String cExpYear,
			String expectedMessage, boolean isSuccessExpected) {

		PaymentPage pp = new PaymentPage(driver);
		pp.prevPageFormFill();

		pp.paymentInfo(CHolderName, cardNumb, cardCVV, cExpMnth, cExpYear);
		pp.clickNxtBtn();

		if (isSuccessExpected) {
			// Verify success message for positive test cases
			assertEquals(pp.labelTnC(), "Terms and Conditions*");
		} else {
			// Verify error message for negative test cases
			assertEquals(pp.getPaymentemsg(expectedMessage), expectedMessage);
		}

	}
	
	/* To verify the Negative flow of Terms and Conditions form */
		@Test(dataProvider = "paymentNegativeData", dataProviderClass = dataProviders.class, priority = 6)
		public void paymentFormNegativeData(String CHolderName, String cardNumb, String cardCVV, String cExpMnth, String cExpYear,
				String expectedMessage, boolean isSuccessExpected) {

			PaymentPage pp = new PaymentPage(driver);
			pp.prevPageFormFill();

			pp.paymentInfo(CHolderName, cardNumb, cardCVV, cExpMnth, cExpYear);
			pp.clickNxtBtn();

			if (isSuccessExpected) {
				// Verify success message for positive test cases
				assertEquals(pp.getPaymentemsg(expectedMessage), expectedMessage);
			} else {
				// Verify error message for negative test cases
				assertEquals(pp.getPaymentemsg(expectedMessage), expectedMessage);
			}

		}


}

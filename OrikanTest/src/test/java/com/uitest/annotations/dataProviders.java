package com.uitest.annotations;

import org.testng.annotations.DataProvider;

public class dataProviders {

	/* DataProvider of Registration - positive test data */
	@DataProvider(name = "registrationPositiveData")
	public Object[][] getRegistrationData() {

		return new Object[][] { { "user@test.com", "ValidPass123", "ValidPass123", "Registration successful!", true } };

	}

	/* DataProvider of Registration - negative test data */
	@DataProvider(name = "registrationNegativeData")
	public Object[][] getRegistrationDataNegative() {

		return new Object[][] { { "user@test.com", "ValidPass123", "ValidPass123", "Registration successful!", true },

				// Negative test cases

				{ "user1@test", "ValidPass123", "ValidPass123", "Invalid email format", false },
				{ "user1@test", "ValidPass123", "ValidPass", "Passwords do not match", false },
				{ "validUser", "ValidPass123", "ValidPass123", "Password Criteria not met", false } };

	}

	/* DataProvider of Contact - positive test data */
	@DataProvider(name = "contactpositiveData")
	public Object[][] getcontactPositiveData() {

		return new Object[][] { { "user", "", "lname", "xxxxx, xxxxxx", "", "", "123654", "Hyderabad", "", "", true } };

	}

	/* DataProvider of Contact - Negative test data */
	@DataProvider(name = "contactNegativeData")
	public Object[][] getcontactNegativeData() {

		return new Object[][] {
				{ "user", "", "lname", "xxxxx, xxxxxx", "", "", "123654", "Hyderabad", "", "First Name is required",
						false },
				{ "user", "", "", "", "", "", "123654", "Hyderabad", "", "Last Name is required", false },
				{ "user", "", "lname", "", "", "", "123654", "Hyderabad", "", "Address Line 1 is required", false },
				{ "user", "", "lname", "xxxxx, xxxxxx", "", "", "", "Hyderabad", "", "Postcode is required", false },
				{ "user", "", "lname", "xxxxx, xxxxxx", "", "", "123654", "Hyderabad", "", "Postcode is required",
						false },
				{ "user", "", "lname", "xxxxx, xxxxxx", "", "", "123654", "", "", "City is required", false },
				{ "user", "", "lname", "xxxxx, xxxxxx", "", "", "123654", "HYderabad", "", "State is required", false },
				{ "useruseruseruseruseruseruser", "", "lname", "xxxxx, xxxxxx", "", "", "123654", "HYderabad", "", "",
						true },
				{ "user", "", "useruseruseruseruseruseruser", "xxxxx, xxxxxx", "", "", "123654", "HYderabad", "", "",
						true },
				{ "user", "", "lname", "xxxxx, xxxxxxxxxxx, xxxxxxxxxxx, xxxxxxxxxxx, xxxxxx", "", "", "123654",
						"HYderabad", "", "", true },
				{ "user", "", "lname", "xxxxx, xxxxxxxxxxx", "", "", "123654",
						"HYderabadHYderabadHYderabadHYderabadHYderabad", "", "", true }

		};

	}

	/* DataProvider of Payment - Positive test data */
	@DataProvider(name = "paymentPositiveData")
	public Object[][] getPaymentData() {

		return new Object[][] {
				{ "user1@test.com", "ValidPass123", "ValidPass123", "Registration successful!", true } };

	}

	/* DataProvider of Payment - Negative test data */
	@DataProvider(name = "paymentNegativeData")
	public Object[][] getPaymentNegativePositiveData() {

		return new Object[][] { { "user1@test.com", "ValidPass123", "ValidPass123", "Registration successful!", true },
				// Negative test cases
				{ "user1@test", "ValidPass123", "ValidPass123", "Invalid email format", false },
				{ "user1@test", "ValidPass123", "ValidPass", "Passwords do not match", false },
				{ "validUser", "ValidPass123", "ValidPass123", "Password Criteria not met", false } };

	}

}

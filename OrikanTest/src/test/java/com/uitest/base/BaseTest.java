package com.uitest.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	public void SetUp() {
		String projectpath = System.getProperty("user.dir");
		System.out.println("Project Path" + projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://orikan-ui-automation-test.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	public void navigateToReg() {
		driver.get("https://orikan-ui-automation-test.azurewebsites.net/");

	}

	@AfterTest
	public void closeApplication() {
		if (driver != null) {
			driver.quit();
		}

	}

}

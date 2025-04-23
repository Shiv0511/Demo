package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumStudy.SeleniumFramework.Cartpage;
import SeleniumStudy.SeleniumFramework.CheckoutPage;
import SeleniumStudy.SeleniumFramework.ConfirmationPage;
import SeleniumStudy.SeleniumFramework.Productpage;
import SeleniumStudy.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test(groups = {"errorhandle"})
	public void submitTest() throws InterruptedException, IOException {
	//	String ProductName = "ZARA COAT 3";
		login.loginapplication("Shiv@gmail.com", "Shiv@05");
		
		Assert.assertEquals("Incorrect email or password.", login.getErrorMessage());
	

	}

}

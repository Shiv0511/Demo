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

public class LoginTest extends BaseTest {
	
	@Test
	public void MatchTest() throws InterruptedException, IOException {
		String ProductName = "ZARA COAT 3";
		Productpage product = login.loginapplication("Shivanshu@gmail.com", "Shivanshu@05");

		List<WebElement> Products = product.getProducts();

		product.addProductToCart(ProductName);

		Thread.sleep(3000);

		Cartpage cart = product.Gotocart();

		boolean match = cart.getCartItems(ProductName);

		Assert.assertTrue(match);
	}



	@Test
	public void submitOrderTest() throws InterruptedException, IOException {
		String ProductName = "ADIDAS ORIGINAL";
		Productpage product = login.loginapplication("Shivanshu0511@gmail.com", "Shivanshu0511@");

		List<WebElement> Products = product.getProducts();

		product.addProductToCart(ProductName);

		Thread.sleep(3000);

		Cartpage cart = product.Gotocart();

		boolean match = cart.getCartItems(ProductName);

		Assert.assertTrue(match);

		CheckoutPage checkout = cart.CheckOut();

		checkout.selectCountry("india");
		ConfirmationPage confirmationpage = checkout.submitOrder();
		String confirmMessage = confirmationpage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	

	}

}

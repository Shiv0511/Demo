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
import SeleniumStudy.SeleniumFramework.Orderpage;
import SeleniumStudy.SeleniumFramework.Productpage;
import SeleniumStudy.TestComponents.BaseTest;

public class TestDay1 extends BaseTest {
	String ProductName = "ZARA COAT 3";
	
	@Test
	public void submitTest() throws InterruptedException, IOException {
		
		Productpage product = login.loginapplication("Shivanshu@gmail.com", "Shivanshu@05");

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

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	

	}

	@Test(dependsOnMethods= {"submitTest"})
	public void OrderHistoryTest() {
		
		Productpage product = login.loginapplication("Shivanshu@gmail.com", "Shivanshu@05");
		Orderpage orderpage =product.goToOrdersPage();
		
		Assert.assertTrue(orderpage.VerifyorderDisplay(ProductName));
	}
}

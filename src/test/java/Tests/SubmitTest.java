package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumStudy.SeleniumFramework.Cartpage;
import SeleniumStudy.SeleniumFramework.CheckoutPage;
import SeleniumStudy.SeleniumFramework.ConfirmationPage;
import SeleniumStudy.SeleniumFramework.Productpage;
import SeleniumStudy.TestComponents.BaseTest;

public class SubmitTest extends BaseTest{
	
	@Test(dataProvider="getData",groups="purchase")
	public void submitOrderTest(HashMap<String,String> input) throws InterruptedException, IOException {
		//String ProductName = "ADIDAS ORIGINAL";
		
		Productpage product = login.loginapplication(input.get("email"), input.get("password"));

		List<WebElement> Products = product.getProducts();

		product.addProductToCart(input.get("ProductName"));

		Thread.sleep(3000);

		Cartpage cart = product.Gotocart();

		boolean match = cart.getCartItems(input.get("ProductName"));

		Assert.assertTrue(match);

		CheckoutPage checkout = cart.CheckOut();

		checkout.selectCountry("india");
		ConfirmationPage confirmationpage = checkout.submitOrder();
		String confirmMessage = confirmationpage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	

	}
	
	 @DataProvider
  public Object[][] getData()
 {
		 
		 HashMap<String,String> map = new HashMap<String,String>();
		 map.put("email", "Shivanshu0511@gmail.com");
		 map.put("password", "Shivanshu0511@");
		 map.put("ProductName", "ZARA COAT 3");
		 
		 HashMap<String,String> map1 = new HashMap<String,String>();
		 map1.put("email", "shetty@gmail.com");
		 map1.put("password", "Iamking@000");
		 map1.put("ProductName", "ADIDAS ORIGINAL");
		 
		 
		 
  return new Object[][]  {{map}, {map1}};
 
  }

}



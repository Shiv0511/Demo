package SeleniumStudy.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage extends Findabs {
	WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> verifycartitems;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	public boolean getCartItems(String ProductName) {
		boolean match = verifycartitems.stream()
				.anyMatch(products -> products.getText().equalsIgnoreCase(ProductName));

		return match;

	}

	

	public CheckoutPage CheckOut() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	
	}

	

}

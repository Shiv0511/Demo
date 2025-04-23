package SeleniumStudy.SeleniumFramework;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;

public class Productpage extends Findabs {

	WebDriver driver;

	public Productpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".offset-sm-1")
	List<WebElement> products;

	By productsBy = By.cssSelector(".offset-sm-1");
	By productNameBy = By.cssSelector("b");
	By addToCartBy = By.cssSelector(".btn.w-10.rounded");
	By Toastappear = By.id("\"toast-container\"");
	By Spinner = By.cssSelector(".ng-animating");

	public List<WebElement> getProducts() {
		ElementToAppear(productsBy);
		return products;
	}

	public void addProductToCart(String productNameText) {
		for (WebElement product : products) {
			WebElement nameElement = product.findElement(productNameBy);
			String actualName = nameElement.getText().trim();

			if (actualName.equalsIgnoreCase(productNameText.trim())) {
				System.out.println("✅ Found product: " + actualName + " | Clicking 'Add to Cart'");
				product.findElement(addToCartBy).click();
				return;
			}
		}
		ElementToAppear(Toastappear);

		ElementToDisappear(Spinner);

		System.out.println("❌ Product not found: " + productNameText);
	}
	
	public Cartpage GoToCart() {
		
		driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
		 return new Cartpage(driver);
	}
}

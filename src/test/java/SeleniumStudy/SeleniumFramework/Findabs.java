package SeleniumStudy.SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Findabs {
	WebDriver driver;
	
	public Findabs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void ElementToAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

	}
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	public void ElementToDisappear(By findby1) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(findby1));

	}
	
	public Cartpage Gotocart() {
		cart.click();
		Cartpage cartpage = new Cartpage(driver);
		return cartpage;
		
	}
	public Orderpage goToOrdersPage()
	{
		orderHeader.click();
		Orderpage orderpage = new Orderpage(driver);
		return orderpage;
	}
}

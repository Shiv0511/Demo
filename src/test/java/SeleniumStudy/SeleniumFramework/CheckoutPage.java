package SeleniumStudy.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class CheckoutPage extends Findabs {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".action__submit")
	  WebElement submit;

	@FindBy(css = "[placeholder='Select Country']")
	 WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	 WebElement selectCountry;
	
	@FindBy(css = "li[class='totalRow'] button[type='button']")
	WebElement SelectCheckout;

	
	 By results = By.cssSelector(".ta-results");
	
	
	public void CheckOut() {
		
		SelectCheckout.click();

	}

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		ElementToAppear(results);
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
		
		
	}

}

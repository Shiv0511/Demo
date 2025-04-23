package SeleniumStudy.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage extends Findabs {

	WebDriver driver;

	public loginpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#userEmail")
	WebElement useremail;

	@FindBy(id = "userPassword")
	WebElement getpassword;

	@FindBy(id = "login")
	WebElement buttton;
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public Productpage loginapplication(String email, String password) {
		useremail.sendKeys(email);
		getpassword.sendKeys(password);
		buttton.click();
		Productpage productpage = new Productpage(driver);
		return productpage;

	}

	public void GoTo() {

		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	

}

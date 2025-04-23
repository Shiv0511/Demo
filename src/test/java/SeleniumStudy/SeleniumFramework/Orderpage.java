package SeleniumStudy.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderpage extends Findabs {
	
	WebDriver driver;
	
	public Orderpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	public boolean VerifyorderDisplay(String ProductName) {
		
		boolean match = productNames.stream()
				.anyMatch(products -> products.getText().equalsIgnoreCase(ProductName));

		return match;

	}

	

}

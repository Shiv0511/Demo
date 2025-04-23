package CricTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cricbuzz {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.cricbuzz.com/cricket-stats/icc-rankings/men/teams");

		// Locate the rankings table
		wait.until(ExpectedConditions.
				visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cb-col cb-col-100 cb-font-14 cb-brdr-thin-btm text-center']")));
		
		
		List<WebElement> teams = driver
				.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-font-14 cb-brdr-thin-btm text-center']"));

		for (int i = 0; i < teams.size(); i++) {
			String teamName = teams.get(i).getText().trim();

			if (teamName.equalsIgnoreCase("INDIA")) {

				WebElement rankingDetails = teams.get(i)
						.findElement(By.xpath("//div[@class='cb-col cb-col-14 cb-lst-itm-sm']"));
				System.out.println("Ranking details for India: " + rankingDetails.getText());
				break;

			}
		}

		// Close browser
		// driver.quit();
	}
}

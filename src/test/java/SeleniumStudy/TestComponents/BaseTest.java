package SeleniumStudy.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import SeleniumStudy.SeleniumFramework.loginpage;

public class BaseTest {
public	WebDriver driver;
public loginpage login;

	public WebDriver InitializeDriver() throws IOException {
		
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"/Users/shivanshusingh/eclipse-workspace/SeleniumFramework/src/main/java/SeleniumStudy/Resources/GlobalData.properties");
		prop.load(fis);

		String BrowserName = prop.getProperty("browser");

		if (BrowserName.equalsIgnoreCase("chrome")) {

		 driver = new ChromeDriver();
		}

		else if (BrowserName.equalsIgnoreCase("firefox")) {

			// firefox
		} else if (BrowserName.equalsIgnoreCase("edge")) {

			// edge
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	
	@BeforeMethod(alwaysRun=true)
	public loginpage launchapp() throws IOException {
		
		driver = InitializeDriver();
		 login = new loginpage(driver);
		login.GoTo();
		driver.manage().deleteAllCookies();
		return login;
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.close();
	}
	

	
	
	
	
	
	
	}



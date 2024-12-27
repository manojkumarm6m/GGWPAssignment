package TestComponents;

import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import PageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();

        String path = "/home/manoj5/eclipse-workspace/GGWPAutomation/src/main/java/resources/Global.properties";
		try (FileInputStream fits = new FileInputStream(path)) {
		    prop.load(fits);
		} catch (IOException e) {
		    e.printStackTrace(); 
		}

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTODemoWebShop();
		return landingPage;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}

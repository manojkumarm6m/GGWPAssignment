package AbstractComponnents;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.LoginPage;
import PageObjects.RegisterPage;

public class AbstractComponents {

	public WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "ico-register")
	WebElement register;

	@FindBy(className = "ico-login")
	WebElement login;;

	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}


	public LoginPage clickOnLogin() {
		login.click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public RegisterPage clickOnRegister() {
		register.click();
		return new RegisterPage(driver);
	}

	public void scrollToElementExactly(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.err.println("Failed to scroll to the element: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void scrollToElement(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		} catch (Exception e) {
			System.err.println("Failed to scroll to the element: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			boolean isDisplayed = element.isDisplayed();
			return isDisplayed;
		} catch (Exception e) {
			System.err.println("Failed to check if the element is displayed: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean isElementEnabled(WebElement element) {
		try {
			boolean isEnabled = element.isEnabled();
			return isEnabled;
		} catch (Exception e) {
			System.err.println("Failed to check if the element is enabled: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public void clickElementUsingJavaScript(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.err.println("Failed to click the element using JavaScript: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
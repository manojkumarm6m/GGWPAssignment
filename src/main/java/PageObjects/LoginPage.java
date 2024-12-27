package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponnents.AbstractComponents;

public class LoginPage extends AbstractComponents {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "email")
	WebElement email;

	@FindBy(className = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;
	
	@FindBy(xpath = "//h2[normalize-space(text())='Welcome to our store']")
	WebElement loginSucces;
	
	
	
	public String loginApplication(String ema, String pass) {
		email.sendKeys(ema);
		password.sendKeys(pass);
		loginButton.click();
		return loginSucces.getText();
	}

}

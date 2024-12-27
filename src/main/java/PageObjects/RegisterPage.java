package PageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponnents.AbstractComponents;

public class RegisterPage extends AbstractComponents {

	public WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public static  String userMail;
	public static  String userPassword = "107Me13025";


	@FindBy(className = "ico-register")
	WebElement register;

	@FindBy(id = "gender-male")
	WebElement male;

	@FindBy(id = "FirstName")
	WebElement firstName;

	@FindBy(id = "LastName")
	WebElement lastName;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(xpath = "//div[normalize-space(text())='Your registration completed']")
	WebElement registered;

	public String registerUser() throws InterruptedException {
		waitForElementToAppear(male);
		male.click();
		waitForElementToAppear(firstName);
		firstName.sendKeys("manoj");
		waitForElementToAppear(lastName);
		lastName.sendKeys("kumar");
		waitForElementToAppear(email);
		email.sendKeys(generateUniqueEmail());
		waitForElementToAppear(password);
		password.sendKeys(userPassword);
		waitForElementToAppear(confirmPassword);
		confirmPassword.sendKeys(userPassword);
		waitForElementToAppear(registerButton);
		registerButton.click();
		waitForElementToAppear(registered);
		Thread.sleep(1000);
		return registered.getText();
	}

	public String generateUniqueEmail() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String timestamp = LocalDateTime.now().format(formatter);
		userMail = "manoj" + timestamp + "@gmail.com";
		return userMail;
	}

	public String registrationSuccess() {
		String succesMessage = registered.getText();
		return succesMessage;

	}
}

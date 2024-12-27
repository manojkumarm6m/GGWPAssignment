package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponnents.AbstractComponents;


public class LandingPage extends AbstractComponents {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "ico-register")
	WebElement register;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	//By.xpath("//ul[@class=\"top-menu\"]/descendant::a[@href='/books']"
	
	@FindBy(xpath = "//ul[@class='top-menu']/descendant::a[@href='/books']")
	WebElement books;
	
	public void goTODemoWebShop() {
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	public void selectBooks() {
		books.click();
	}


}

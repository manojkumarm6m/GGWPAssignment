package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;

public class AddToCartTest extends BaseTest{
	String book = "Computing and Internet";

	
	@Test
	public void addToCart() {
		LoginPage loginPage = landingPage.clickOnLogin();		
		String loginMessage = loginPage.loginApplication("manojreddy@gmail.com", "DW6sdWP_v7DBA");
		AssertJUnit.assertEquals(loginMessage, "Welcome to our store");
		landingPage.selectBooks();
		ProductCatalogue  productCatalogue = new ProductCatalogue(driver);
		WebElement toastMessageCart =  productCatalogue.addProductToCart(book);
		Assert.assertTrue(toastMessageCart.isDisplayed());
	}
}

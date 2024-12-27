package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import PageObjects.LoginPage;
import TestComponents.BaseTest;

public class LoginTest extends BaseTest {
	
	
	
	@Test
	public void LoginApplication() {
		LoginPage loginPage = landingPage.clickOnLogin();		
		String loginMessage = loginPage.loginApplication("manojreddy@gmail.com", "DW6sdWP_v7DBA");
		AssertJUnit.assertEquals(loginMessage, "Welcome to our store");
		
	}
}

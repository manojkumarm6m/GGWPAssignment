package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import PageObjects.RegisterPage;
import TestComponents.BaseTest;

public class RegisterTest extends BaseTest {
	
	@Test
	public void RegisterUserDetails() throws InterruptedException {
		RegisterPage registerPage = landingPage.clickOnRegister();
		String registrationSuccess =  registerPage.registerUser();
		AssertJUnit.assertEquals(registrationSuccess, "Your registration completed");
		
	}

}

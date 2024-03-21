package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class ErrorValidation extends BaseTest{
	
	@Test
	public void errorValid() {
		loginpage.logIn("gjdndruf1222@gmail.com", "GJdndruf123456");
		Assert.assertEquals(loginpage.getErrorMessage(), "Incorrect email or password.");
	}
}

package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;

public class TestPractice extends BaseTest{
	
	@Test(dataProvider="getData")
	public void practiceTest(HashMap<String,String> input) {
		String productName = "ADIDAS ORIGINAL";
		String expectedMessage = "THANKYOU FOR THE ORDER.";
		
		ProductCatalogue productcatalogue = loginpage.logIn(input.get("email"), input.get("password"));
		productcatalogue.addSelectedProduct(input.get("productName"));
		CartPage cartpage = productcatalogue.goToCart();
		Boolean match = cartpage.verifyProductName(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.goToCheckoutPage();
		checkoutpage.enterCountry("india");
		ConfirmationPage confirmationpage = checkoutpage.goToConfirmationPage();
		String message = confirmationpage.verifyConfirmationMessage();
		Assert.assertEquals(message, expectedMessage);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = interpreteData();
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}

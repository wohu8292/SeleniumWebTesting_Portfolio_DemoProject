package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.Utility;

public class CartPage extends Utility {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="ul.cartWrap h3")
	List<WebElement> names;
	
	@FindBy(css="li[class='totalRow'] button[type='button']")
	WebElement checkout_btn;
	
	public Boolean verifyProductName(String productName) {
		Boolean match = names.stream().anyMatch(name->name.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckoutPage() {
		checkout_btn.click();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		return checkoutpage;
		
	}
}

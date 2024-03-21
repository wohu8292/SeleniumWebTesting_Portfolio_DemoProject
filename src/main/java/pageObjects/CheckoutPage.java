package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.Utility;

public class CheckoutPage extends Utility{
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country_text;
	
	@FindBy(xpath="//div[@class='payment__shipping']//button[2]")
	WebElement selectCountry;
	
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement place_order_btn;
	
	public void enterCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country_text, countryName).build().perform();
		selectCountry.click();
		waitForWebElementToAppear(place_order_btn);

	}
	
	public ConfirmationPage goToConfirmationPage() {
		Actions a = new Actions(driver);
		a.moveToElement(place_order_btn).click().build().perform();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
	}
}

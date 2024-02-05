package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.Utility;

public class ConfirmationPage extends Utility{
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//h1[@class='hero-primary']")
	WebElement confirmMessage;
	
	public String verifyConfirmationMessage() {
		String getMessage = confirmMessage.getText();
		return getMessage;
	}
}

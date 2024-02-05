package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.Utility;

public class ProductCatalogue extends Utility{
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By add_btn = By.cssSelector(".w-10");
	By toast = By.cssSelector("#toast-container");

	public WebElement selectProduct(String productName) {
		WebElement found = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return found;
	}
	
	public void addSelectedProduct(String productName) {
		WebElement found = selectProduct(productName);
		found.findElement(add_btn).click();
		waitUntilVisible(toast);
		waitUntilInvisible(toast);
	}
}

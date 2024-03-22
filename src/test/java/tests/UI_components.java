package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;

public class UI_components {
	
	@Test
	public void HandlingComponents() {
			//Initialize WebDriver
			System.setProperty("webdriver.chrome.driver", "C:/Users/gjdnd/Documents/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//GoToExpediaWebsite
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			//Calendar
			
			//SelectCheckbox
			WebElement checkbox = driver.findElement(By.cssSelector("#ctl00_mainContent_chk_StudentDiscount"));
			checkbox.click();
			Boolean isSelected = checkbox.isSelected();
			Assert.assertTrue(isSelected);
			
			//Dropdown
			WebElement dropdown = driver.findElement(By.cssSelector("select[name*='ctl00$mainContent$DropDownListCurrency']"));
			Select select = new Select(dropdown);
			select.selectByVisibleText("USD");
			select.selectByValue("AED");
			
		}

}

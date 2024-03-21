package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageObjects.LoginPage;
import pageObjects.ProductCatalogue;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginpage;
	
	public WebDriver getDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/Users/gjdnd/Desktop/selenium/Selenium/src/main/java/resources/browser.properties");
		prop.load(fis);
		
		String brow = System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
		
		if(brow.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:/Users/gjdnd/Documents/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(brow.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		return driver;
	}
	
	public List<HashMap<String, String>> interpreteData() throws IOException {
		String jsonContent = FileUtils.readFileToString(new File("C:/Users/gjdnd/Desktop/selenium/Selenium/src/main/java/resources/data.json"), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File copyFile = new File(System.getProperty("user.dir")+"/reports/"+testCaseName+".png");
		FileUtils.copyFile(source, copyFile);
		return System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage landingPage() throws IOException {
		driver= getDriver();
		loginpage = new LoginPage(driver);
		loginpage.goTo();
		return loginpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closePage() {
		driver.close();
	}
}

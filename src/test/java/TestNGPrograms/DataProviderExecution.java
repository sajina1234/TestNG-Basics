package TestNGPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExecution {
	WebDriver driver;

	@BeforeMethod
	public void launch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();

	}
@Test (dataProvider = "Amazondata",dataProviderClass = DataProviders.class)
public void verify(String product) {
	driver.get("https://www.amazon.in");
	WebElement search=driver.findElement(By.xpath("//span[contains(text(),'Select your address')]//following::input[@id='twotabsearchtextbox']"));
	search.sendKeys(product);
    WebElement searchbutton=driver.findElement(By.cssSelector("#nav-search-submit-button"));
	searchbutton.click();
	String url=driver.getCurrentUrl();
	boolean s=url.contains(product);
	Assert.assertTrue(s);
}
@Test(dataProvider = "logindata",dataProviderClass = DataProviders.class)
public void verifyFacebookLogin(String usernamedata,String passworddata) {
	driver.get("https://www.facebook.com/login.php");
	WebElement email=driver.findElement(By.xpath("//input[contains(@aria-label,'Email address or phone number')]"));
	email.sendKeys(usernamedata);
	WebElement password=driver.findElement(By.xpath("//input[contains(@aria-label,'Email address or phone number')]"));
	password.sendKeys(passworddata);
}
}

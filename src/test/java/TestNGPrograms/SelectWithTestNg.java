package TestNGPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectWithTestNg {
	WebDriver driver;
	@BeforeMethod
	public void launchingAmazon() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	}
	@Test(priority=1,enabled=false)
	public void amazonTitle() {
		
	
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle=driver.getTitle();
		System.out.println(expectedTitle);
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	@Test(priority = 2,enabled=true,dependsOnMethods = "verifyText")
	public void amazonUrl() {
		String expectedUrl="https://www.amazon.in/";
		String actualUrl=driver.getCurrentUrl();
		System.out.println(expectedUrl);
		System.out.println(actualUrl);
		Assert.assertEquals(actualUrl,expectedUrl);
		
	}
	@Test
	public void verifyText() {
		WebElement text=driver.findElement(By.xpath("//span[@id='glow-ingress-line2']"));
		String actualtext=text.getText();
		String expectedtext="Select your address";
		Assert.assertEquals(actualtext,expectedtext);
		}
	@Test
	public void verifytooltip() {
		WebElement tooltip=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		String actualtooltip=tooltip.getAttribute("title");
		String expectedtooltip="search in";
		Assert.assertEquals(actualtooltip,expectedtooltip);
	}
	@Test
	public void verifyWhetherSearchbuttonIsDisplayed() {
		WebElement search=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		Boolean actual=search.isDisplayed();
		Assert.assertTrue(actual);
		System.out.println(actual);
		
	}
@AfterMethod
public void terminatingChrome() {
	driver.quit();
	
}
}

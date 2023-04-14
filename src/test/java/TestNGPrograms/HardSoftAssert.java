package TestNGPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardSoftAssert {
	WebDriver driver;

	@BeforeMethod
	public void launch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();

	}
@Test (priority=1,enabled =true)
public void verify() {
	WebElement messageField = driver.findElement(By.xpath("//input[@type='text']"));
	WebElement Button = driver.findElement(By.xpath("//button[@id='button-one']"));
	String expected="Show Message";
	String actual=Button.getText();
	SoftAssert softassert=new SoftAssert();         /////soft Assert
	softassert.assertTrue(messageField.isDisplayed());
	softassert.assertEquals(actual,expected);
	softassert.assertAll();
}

}

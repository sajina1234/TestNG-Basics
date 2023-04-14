package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertExample {
	WebDriver driver;

	@BeforeMethod
	public void launch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = true)
	public void verifycheckboxes() {
		WebElement singlecheckbox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='check-box-one']"));
		WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='check-box-two']"));
		WebElement checkbox3 = driver.findElement(By.xpath("//input[@id='check-box-three']"));
		WebElement checkbox4 = driver.findElement(By.xpath("//input[@id='check-box-four']"));
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(singlecheckbox.isEnabled());
		softassert.assertTrue(checkbox1.isEnabled());
		softassert.assertTrue(checkbox2.isEnabled());
		softassert.assertTrue(checkbox3.isEnabled());
		softassert.assertTrue(checkbox4.isEnabled());
		softassert.assertAll();
	}

	@AfterMethod
	public void terminatingChrome() {
		driver.quit();

	}

}

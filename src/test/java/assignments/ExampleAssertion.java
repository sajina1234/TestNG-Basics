package assignments;

import java.util.List;

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

public class ExampleAssertion {
	WebDriver driver;

	@BeforeMethod
	public void launchingAmazon() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = false)
	public void verifyButtonName() {
		WebElement selectall = driver.findElement(By.xpath("//input[@id='button-two']"));
		String actual = selectall.getText();
		System.out.println(actual);
		String expected = "SelectAll";
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2, enabled = false)
	public void verifyButtonIsEnabled() {
		WebElement selectall = driver.findElement(By.xpath("//input[@id='button-two']"));
		boolean actual = selectall.isEnabled();
		Assert.assertTrue(actual);

	}

	@Test(priority = 3, enabled = true)
	public void verifyAllCheckBox() {
		WebElement selectall = driver.findElement(By.xpath("//input[@id='button-two']"));
		selectall.click();
		// Assert.assertTrue(selectall.isSelected());
		List<WebElement> box = driver.findElements(By.xpath("//input[@class='check-box-list']"));
		for (WebElement element : box) {
			Boolean actual = element.isSelected();
			Assert.assertTrue(actual);
			System.out.println("selected");

		}
	}

	@AfterMethod
	public void terminatingChrome() {
		driver.close();

	}

}

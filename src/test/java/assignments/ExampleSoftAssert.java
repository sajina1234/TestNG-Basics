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

public class ExampleSoftAssert {
	WebDriver driver;

	@BeforeMethod
	public void launch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/bootstrap-dual-list.php");
		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = true)
	public void verifyoptions() {
		WebElement option1 = driver.findElement(By.xpath("//option[@value='option1']"));
		String actual1 = option1.getText();
		String expected1 = "Option 1";
		System.out.println(actual1);
		System.out.println(expected1);
		WebElement option2 = driver.findElement(By.xpath("//option[@value='option2']"));
		String actual2 = option2.getText();
		String expected2 = "Option 2";
		System.out.println(actual2);
		System.out.println(expected2);
		WebElement option3 = driver.findElement(By.xpath("//option[@value='option3']"));
		String actual3 = option3.getText();
		String expected3 = "Option 3";
		System.out.println(actual3);
		System.out.println(expected3);
		WebElement option4 = driver.findElement(By.xpath("//option[@value='option4']"));
		String actual4 = option4.getText();
		String expected4 = "Option 4";
		System.out.println(actual4);
		System.out.println(expected4);
		WebElement option5 = driver.findElement(By.xpath("//option[@value='option5']"));
		String actual5 = option5.getText();
		String expected5 = "Option 5";
		System.out.println(actual5);
		System.out.println(expected5);
		WebElement option6 = driver.findElement(By.xpath("//option[@value='option6']"));
		String actual6 = option6.getText();
		String expected6 = "Option 6";
		System.out.println(actual6);
		System.out.println(expected6);
		WebElement option7 = driver.findElement(By.xpath("//option[@value='option7']"));
		String actual7 = option7.getText();
		String expected7 = "Option 7";
		System.out.println(actual7);
		System.out.println(expected7);
		WebElement option8 = driver.findElement(By.xpath("//option[@value='option8']"));
		String actual8 = option8.getText();
		String expected8 = "Option 8";
		System.out.println(actual8);
		System.out.println(expected8);
		WebElement option9 = driver.findElement(By.xpath("//option[@value='option9']"));
		String actual9 = option9.getText();
		String expected9 = "Option 9";
		System.out.println(actual9);
		System.out.println(expected9);
		WebElement option10 = driver.findElement(By.xpath("//option[@value='option0']"));
		String actual10 = option10.getText();
		String expected10 = "Option 10";
		System.out.println(actual10);
		System.out.println(expected10);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actual1, expected1);
		softassert.assertEquals(actual2, expected2);
		softassert.assertEquals(actual3, expected3);
		softassert.assertEquals(actual4, expected4);
		softassert.assertEquals(actual5, expected5);
		softassert.assertEquals(actual6, expected6);
		softassert.assertEquals(actual7, expected7);
		softassert.assertEquals(actual8, expected8);
		softassert.assertEquals(actual9, expected9);
		softassert.assertEquals(actual10, expected10);
		softassert.assertAll();
	}

	@AfterMethod
	public void terminatingChrome() {
		driver.quit();

	}
}

package TestNGPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class radiobutton {
	WebDriver driver;
	@BeforeMethod
	public void launchingAmazon() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.manage().window().maximize();
		
	}
	@Test
	public void verifyRadioButton() {
		WebElement radioMale = driver.findElement(By.xpath("//div[@class='form-group']//div[1]//input[1]"));
		radioMale.click();
		WebElement radioFemale = driver.findElement(By.xpath("//div[@class='form-group']//div[2]//input[1]"));
		Boolean isMaleOptionSelected=radioMale.isSelected();
				Assert.assertTrue(isMaleOptionSelected);

	}
	

}

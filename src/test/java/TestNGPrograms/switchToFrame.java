package TestNGPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchToFrame {
	WebDriver driver;
	@BeforeMethod
	public void launchingAmazon() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		
	}
	@Test
	public void verify() {
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		WebElement middle=driver.findElement(By.xpath("//div[text()='MIDDLE']"));
		String print=middle.getText();
		System.out.println(print);
	}

}

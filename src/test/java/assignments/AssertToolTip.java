package assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertToolTip {
	WebDriver driver;

	@BeforeMethod
	public void launch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
		driver.manage().window().maximize();

	}
@Test (priority=1,enabled =false)
public void verifyToolTipFollowAll() {
	WebElement followAll=driver.findElement(By.xpath("//a[@id='windowMulti']"));
	String actual=followAll.getAttribute("title");
	String expected="Follow @obsqurazone";
	Assert.assertEquals(actual,expected);
	
}
@Test(priority=2,enabled=true)
public void printTextFromNewWindow()  {
	WebElement facebook=driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
	facebook.click();
	String parentwindow=driver.getWindowHandle();
	System.out.println(parentwindow);
Set <String> windows =driver.getWindowHandles();
	
	for(String window:windows) {
		if(parentwindow.equals(window)) {
			System.out.println("No need to switch");
			
		}
		else {
			driver.switchTo().window(window);
		}
	}
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Connect with Obsqura Zone on Facebook')]")));
	WebElement childwindowText=driver.findElement(By.xpath("//span[contains(text(),'Connect with Obsqura Zone on Facebook')]"));
	String print=childwindowText.getText();
	System.out.println(print);
	}
@AfterMethod
public void terminatingChrome() {
	driver.close();
	
}
}

package TestNGPrograms;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitchingExample {
	WebDriver driver;

	@BeforeMethod
	public void launch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();

	}
@Test (enabled = false)
public void TestCase1() {
	WebElement clickHere =driver.findElement(By.xpath("//a[text()='Click Here']"));
	clickHere.click();
	clickHere.click();
	String parentWindow=driver.getWindowHandle();
	System.out.println(parentWindow);
	
	Set <String> windows =driver.getWindowHandles();
	int size =windows.size();
	System.out.println(size);
	
	Iterator<String> iterate=windows.iterator();
	while (iterate.hasNext()) {
		String childWindow= iterate.next();
		if (!parentWindow.equals(childWindow)) {
			driver.switchTo().window(childWindow);
			
		}
	}
	WebElement newWindowText= driver.findElement(By.xpath("//h3[text()='New Window']"));
	String windowTextString= newWindowText.getText();
	System.out.println(windowTextString);
	
}

@Test (enabled = true)
public void AnotherMethod() {
	WebElement clickHere =driver.findElement(By.xpath("//a[text()='Click Here']"));
	clickHere.click();
	clickHere.click();
	String parentWindow=driver.getWindowHandle();
	System.out.println(parentWindow);
	
	Set <String> windows =driver.getWindowHandles();
	
	for(String window:windows) {
		if(parentWindow.equals(window)) {
			System.out.println("No need to switch");
			
		}
		else {
			driver.switchTo().window(window);
		}
	}
	WebElement newWindowText= driver.findElement(By.xpath("//h3[text()='New Window']"));
	String windowTextString= newWindowText.getText();
	System.out.println(windowTextString);
//	driver.switchTo().window(parentWindow);
//	clickHere.click();
	
	
}
@AfterMethod
public void terminatingChrome() {
	driver.quit();
	
}
}

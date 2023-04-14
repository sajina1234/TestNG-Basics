package assignments;

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

public class FormSubmit1 {
	WebDriver driver;

	@BeforeMethod
	public void launch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		driver.manage().window().maximize();

	}
@Test (priority=1,enabled =false)
public void verifyWarningMessage() {
	WebElement submit=driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	submit.click();
	WebElement subjectmsg=driver.findElement(By.xpath("//div[@class='invalid-feedback']"));
	String actual=subjectmsg.getText();
	System.out.println(actual);
	String expected="Please enter Subject.";
	System.out.println(expected);
	Assert.assertEquals(actual,expected);
	
}
@Test (priority=2,enabled =true)
public void verifySuccessMessage() {
	WebElement subject=driver.findElement(By.xpath("//input[@id='subject']"));
	subject.sendKeys("TVM");
	WebElement description=driver.findElement(By.xpath("//textarea[@id='description']"));
	description.sendKeys("It is the capital of Kerala");
	WebElement submit=driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	submit.click();
	WebElement successmsg=driver.findElement(By.xpath("//div[@id='message-one']"));
	String actual=successmsg.getText();
	System.out.println(actual);
	String expected="Form has been submitted successfully!";
	System.out.println(expected);
	Assert.assertEquals(actual,expected);//hard assert
	System.out.println("testcase passed");
}
@AfterMethod
public void terminatingChrome() {
	driver.quit
	();
	
}
}

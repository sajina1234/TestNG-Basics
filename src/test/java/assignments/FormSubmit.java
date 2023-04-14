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

public class FormSubmit {
	WebDriver driver;

	@BeforeMethod
	public void launch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		driver.manage().window().maximize();

	}
@Test (priority=1,enabled =true)
public void verifyTermsAndCondition() {
	WebElement agree=driver.findElement(By.xpath("//input[@id='invalidCheck']"));
	Assert.assertTrue(agree.isDisplayed());
	
}
@Test (priority=2,enabled =true)
public void verifyHeaderText() {
	WebElement header=driver.findElement(By.xpath("//div[contains(text(),'Form with validations')]"));
	String actual=header.getText();
	System.out.println(actual);
	String expected="Form with validations";
	System.out.println(expected);
	Assert.assertEquals(actual,expected);
}
@Test (priority=3,enabled =true)
public void verifySuccessMessage() {
	WebElement firstname=driver.findElement(By.xpath("//input[@id='validationCustom01']"));
	firstname.sendKeys("Sajina");
	WebElement lastname=driver.findElement(By.xpath("//input[@id='validationCustom02']"));
	lastname.sendKeys("Shajahan");
	WebElement username=driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
	username.sendKeys("Saj");
	WebElement city=driver.findElement(By.xpath("//input[@id='validationCustom03']"));
	city.sendKeys("Tvm");
	WebElement state=driver.findElement(By.xpath("//input[@id='validationCustom04']"));
	state.sendKeys("Kerala");
	WebElement zip=driver.findElement(By.xpath("//input[@id='validationCustom05']"));
	zip.sendKeys("691574");
	WebElement agree=driver.findElement(By.xpath("//input[@id='invalidCheck']"));
	agree.click();
	WebElement submit=driver.findElement(By.xpath("//button[contains(text(),'Submit form')]"));
	submit.click();
	WebElement msg=driver.findElement(By.xpath("//div[@id='message-one']"));
	String actual=msg.getText();
	System.out.println(actual);
	String expected="Form has been submitted successfully!";
	System.out.println(expected);
	Assert.assertEquals(actual,expected);
}
@AfterMethod
public void terminatingChrome() {
	driver.close();
	
}
}

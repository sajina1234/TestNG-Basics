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

import TestNGPrograms.DataProviders;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_providerAssignment {
	WebDriver driver;

	@BeforeMethod
	public void launch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();

	}
@Test (dataProvider = "formdata",dataProviderClass = MainDataProvider.class)
public void submitform(String firstdata,String lastdata,String userdata,String citydata,String statedata,String zipdata ) {
	driver.get("https://selenium.obsqurazone.com/form-submit.php");
	WebElement firstname=driver.findElement(By.xpath("//input[@id='validationCustom01']"));
	firstname.sendKeys(firstdata);
	WebElement lastname=driver.findElement(By.xpath("//input[@id='validationCustom02']"));
	lastname.sendKeys(lastdata);
	WebElement username=driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
	username.sendKeys(userdata);
	WebElement city=driver.findElement(By.xpath("//input[@id='validationCustom03']"));
	city.sendKeys(citydata);
	WebElement state=driver.findElement(By.xpath("//input[@id='validationCustom04']"));
	state.sendKeys(statedata);
	WebElement zip=driver.findElement(By.xpath("//input[@id='validationCustom05']"));
	zip.sendKeys(zipdata);
	WebElement terms=driver.findElement(By.xpath("//input[@id='invalidCheck']"));
	terms.click();
	WebElement submit=driver.findElement(By.xpath("//button[contains(text(),'Submit form')]"));
	submit.click();
	WebElement msg=driver.findElement(By.xpath("//div[@id='message-one']"));
	String actual=msg.getText();
	System.out.println(actual);
	String expected="Form has been submitted successfully!";
	Assert.assertEquals(actual,expected);

}
@AfterMethod
public void terminatingChrome() {
	driver.quit();

}


}

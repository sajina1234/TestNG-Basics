package TestNGPrograms;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	
		@BeforeSuite
		public void beforesuite() {
			System.out.println("Executing before suite annotation");
			
		}
		@BeforeTest
		public void beforetest() {
			System.out.println("Executing beforetest annotation");
			
		}
   @BeforeClass
   public void beforeclass() {
	   System.out.println("Executing beforeclass annotation");
   }
   @BeforeMethod
   public void beforemethod() {
	   System.out.println("Executing beforemethod annotation");
   }
   @Test
   public void  testcase1() {
	   System.out.println("executing test annotation");
   }
   @AfterMethod
   public void aftermethod() {
	   System.out.println("Executing aftermethod annotation");
   }
   @AfterClass
   public void afterclass() {
	   System.out.println("Executing afterclass annotation");
   }
   @AfterTest
   public void aftertest() {
	   System.out.println("Executing aftertest annotation");
   }
   @AfterSuite
   public void aftersuite() {
	   System.out.println("Executing aftersuite annotation");
   }
   @Test
   public void testcase2() {
	   System.out.println("Executing test2 annotation");
   }
	}



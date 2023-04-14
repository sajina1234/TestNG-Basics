package assignments;

import org.testng.annotations.DataProvider;

public class MainDataProvider {
	@DataProvider(name="formdata")
	public Object[][] formsubmit()
	{
		return new Object [][] {{"Sajina","shajahan","saj","Tvm","kerala","691574"}, {"sneha","T","sneh","kollam","kerala","691260"},{"meenu","K","meens","mumbai","maharashtra","651400"}};
	}

}

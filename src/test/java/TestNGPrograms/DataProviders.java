package TestNGPrograms;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="Amazondata")
	public Object[][] amazondatas()
	{
		return new Object [][] {{"shoe"},{"watch"},{"phone"},{"laptop"}};
	}
	@DataProvider(name="logindata")
	public Object[][] logindatas()
	{
		return new Object [][] {{"Test@gmail.com","Test@123"}, {"Test1@gmail.com","Test@1234"}};
	}
	

}

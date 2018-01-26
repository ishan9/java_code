package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import automation.CommonUtilities;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class TestsLoginPage extends CommonUtilities {
	LoginPage obj_pageLogin;
	HomePage obj_pageHome;
	
	@BeforeMethod
	public void login_window()  throws MalformedURLException{
		driver = initializeDriver();
    	obj_pageLogin = new LoginPage(driver);
	}
	@AfterMethod
	public void logout_window() {
		driver.close();
	}
	
	@Test(dataProvider="loginData")
	public void doTesting(String username, String password, String ExpectedResult) throws IOException {
		System.out.println("n:"+ username+" p:"+password+ " e:"+ExpectedResult);
		obj_pageLogin.loginToOrangeHRM(username, password);
		obj_pageHome = new HomePage(driver);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	String accountName = obj_pageHome.getAccountName();
    	System.out.println("Account name:"+accountName);
    	getScreenshot();
    	Assert.assertTrue(accountName.equals(ExpectedResult));
	}
	
	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException {
		String fs = System.getProperty("file.separator");
		String csvFilePath = System.getProperty("user.dir") + fs + "testDataDir" + fs + "loginData.csv";
		DataProviderCSV(csvFilePath);
		int rows = getCSVRowCount();
		int cols = getCSVRowCount();
		Object[][] data = new Object[rows][cols];
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				data[i][j] = CommonUtilities.getCSVData(i, j);
			}
		}
//		Object[][]  data = new Object[3][3];
//		
//		data[0][0] = "admin";
//		data[0][1] = "admin";
//		data[0][2] = "Jacqueline White";
//		
//		data[1][0] = "linda.anderson";
//		data[1][1] = "linda.anderson";
//		data[1][2] = "Linda Anderson";
//		
//		data[2][0] = "kevin.mathews";
//		data[2][1] = "kevin.mathews";
//		data[2][2] = "Kevin Mathews";
		
		return data;
	}
	
}

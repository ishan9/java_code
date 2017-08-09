package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestsLoginPage {
	WebDriver driver;
	LoginPage obj_pageLogin;
	HomePage obj_pageHome;
	
	@BeforeMethod
	public void login_window() {

    	driver = new FirefoxDriver();
    	driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	obj_pageLogin = new LoginPage(driver);
	}
	@AfterMethod
	public void logout_window() {
		driver.close();
	}
	
	@Test(dataProvider="getData")
	public void doTesting(String username, String password, String ExpectedResult) {
		obj_pageLogin.loginToOrangeHRM(username, password);
		obj_pageHome = new HomePage(driver);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    	String accountName = obj_pageHome.getAccountName();
    	System.out.println("Account name:"+accountName);
    	Assert.assertTrue(accountName.equals(ExpectedResult));
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][]  data = new Object[3][3];
		
		data[0][0] = "admin";
		data[0][1] = "admin";
		data[0][2] = "Jacqueline White";
		
		data[1][0] = "linda.anderson";
		data[1][1] = "linda.anderson";
		data[1][2] = "Linda Anderson";
		
		data[2][0] = "kevin.mathews";
		data[2][1] = "kevin.mathews";
		data[2][2] = "Kevin Mathews";
		
		return data;
	}
}
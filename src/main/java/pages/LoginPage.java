package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class LoginPage {
	WebDriver driver;
	By idUserName = By.id("txtUsername");
	By idPassword = By.id("txtPassword");
	By idLogin = By.id("btnLogin");
	By xpathSubTitle = By.xpath("//*[@id='midPaneContentWrapper']/h2");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Set username in textbox
	public void setUserName (String userName) {
		driver.findElement(idUserName).clear();
		driver.findElement(idUserName).sendKeys(userName);
	}
	
	//Set password in textbox
	public void setPassword (String password) {
		driver.findElement(idPassword).clear();
		driver.findElement(idPassword).sendKeys(password);
	}
	
	//Click Login Button
	public void clickLoginBtn (){
		driver.findElement(idLogin).click();
	}
	
	public String getSubTitle() {
		return driver.findElement(xpathSubTitle).getText();
	}
	
	//Perform Login
	public void loginToOrangeHRM (String userName, String password) {
		//Fill Username
		this.setUserName(userName);
		
		//Fill Password
		this.setPassword(password);
		
		//Click Login Button
		this.clickLoginBtn();
	}
}

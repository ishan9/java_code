package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class HomePage {
	WebDriver driver;
	
	By xpathAccountName = By.xpath("//*[@id='account-name']");
	By idNonCoreFrame = By.id("noncoreIframe");
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
		//Switch to basic frame
		driver.switchTo().frame(driver.findElement(idNonCoreFrame));
	}
	
	public String getAccountName(){
		return driver.findElement(xpathAccountName).getText();
	}
	
}

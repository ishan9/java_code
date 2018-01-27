package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	
	By xpathAccountName = By.xpath("//*[@id='account-name']");
	By idNonCoreFrame = By.id("noncoreIframe");
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
		//Switch to basic frame
		driver.switchTo().frame(driver.findElement(idNonCoreFrame));
		WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(xpathAccountName));
	}
	
	public String getAccountName(){
		return driver.findElement(xpathAccountName).getText();
	}
	
}

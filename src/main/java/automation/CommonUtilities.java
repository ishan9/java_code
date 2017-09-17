package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class CommonUtilities {
    public WebDriver driver;
    public WebDriver initializeDriver() {
    	driver = new FirefoxDriver();
    	driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    public void getScreenshot() throws IOException {
    	File scrnFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String fs = System.getProperty("file.separator");
    	String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
    	String filePath = System.getProperty("uses.dir") + fs +  "screenshots" + fs + timeStamp +".png";
    	FileUtils.copyFile(scrnFile, new File(filePath));
    }
}

package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class CommonUtilities {
    public WebDriver driver;
    public static List<String []> csvDataList;
    String fs = System.getProperty("file.separator");   
    public WebDriver initializeDriver()  throws MalformedURLException {
    	//driver = new FirefoxDriver();
	driver = new RemoteWebDriver (new URL("http://sel4444:4444/wd/hub"), DesiredCapabilities.firefox());
    	driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    public void getScreenshot() throws IOException {
    	File scrnFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	
    	String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
    	String filePath = System.getProperty("user.dir") + fs +  "screenshots" + fs + timeStamp +".png";
    	FileUtils.copyFile(scrnFile, new File(filePath));
    }
    
    public  static List<String []> DataProviderCSV(String path) throws IOException{
		CSVReader csvreader = new CSVReader(new FileReader(path));
		csvDataList = csvreader.readAll();
		csvreader.close();
		return csvDataList;    	
    }
    public static int getCSVRowCount () {
    	return csvDataList.size();
    }
    public static int getCSVColCount() {
    	return csvDataList.get(0).length;
    }
    public static String getCSVData(int row, int col) {
    	String[] line = csvDataList.get(row);
    	return line[col];
    }
}

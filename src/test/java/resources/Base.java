package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public Properties prop = null;
	protected WebDriver driver;

	
	public String getTimeStamp() {
		
		Date date = new Date();
		
		return date.toString().replace(" ","_").replace(":","_");
		
	}
	
	   public String captureScreenshot() throws IOException {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
	        return Base64.getEncoder().encodeToString(screenshot);
	    }
	
}

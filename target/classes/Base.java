package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver=null;
public	Properties prop =new Properties();
	
	public WebDriver initialize() throws IOException {
		
		
		
		
		
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Options.properties"));
		prop.load(fis);
		
		if(prop.getProperty("browser").contentEquals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
			
		else if (prop.getProperty("browser").equals("Firefox")) {
				
				
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			
			
		
		
		
		
		
		
		
		
		
		return driver;
		
		
		
		
		
		
	}
	
	
	public String captureScreenshot(WebDriver driver, String testCaseName) throws IOException {
		
		
		TakesScreenshot tks= (TakesScreenshot)driver;
		File scr=tks.getScreenshotAs(OutputType.FILE);
		String Destination=System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		FileUtils.copyFile(scr, new File(Destination) );
		
		return Destination;
		
	}
	

}

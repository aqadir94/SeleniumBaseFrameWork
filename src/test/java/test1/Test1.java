package test1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Resources.Base;
import pageObjects.HomePage;

public class Test1 extends Base {
	
	WebDriver driver;
	public static Logger log= LogManager.getLogger(Test1.class.getName());
	
	@BeforeTest
	public void beforeTest() throws IOException {
		
		driver=	initialize();
		
		driver.get(prop.getProperty("URL"));
		
		
	}
	

	@Test(dataProvider="getData")
	public void test1(String fName, String lName) throws IOException, InterruptedException {
		
		HomePage hp= new HomePage(driver);
		hp.getFname().sendKeys(fName);
		hp.getlName().sendKeys(lName);
		
		log.debug("Entering information");

		
		
	}
	
	
	@DataProvider
	public String[][] getData() {
		
		String[][] names= new String[2][2];
		
		names[0][0]="Harry";
		names[0][1]="Kane";
		names[1][0]="Kumar";
		names[1][1]="Malar";
		
		return names;
	}
	
	@AfterTest
	public void terminate() {
		
		
		driver.quit();
		
	}

}

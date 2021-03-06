package test1;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;

public class Test2 extends Base {
	
	WebDriver driver;
	
	@BeforeTest
	public void initialization() throws IOException {
		
		driver=initialize();
		driver.get(prop.getProperty("URL"));
		
		
		
	}
	
	
	@Test
	public void assertTitle() {
		
		
		
		Assert.assertEquals(driver.getTitle(),"Tool");
		
	}
	
	
	@AfterTest
	public void terminate() {
		
		
		driver.quit();
	}

}

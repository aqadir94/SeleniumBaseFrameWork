package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement fName;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lName;
	
	public WebElement getFname() {
	
		
		return fName;
		
	}
	
	public WebElement getlName() {
	
		
		return lName;
		
	
	
	}

}

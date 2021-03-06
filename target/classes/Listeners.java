package Resources;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listeners extends Base implements ITestListener {
	ExtentReports er=	ExtentReporter.getReport();
	ExtentTest extent;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		
		
	extent=er.createTest("First Report");
	extentTest.set(extent);
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
	WebDriver driver=null;	
	String methodName=result.getMethod().getMethodName();
	try {
		driver= (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		
		
		extentTest.get().addScreenCaptureFromPath(captureScreenshot(driver,methodName), methodName);
		//captureScreenshot(driver,methodName); this method is called above which calls the method and returns the name
		//for the report
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	//extent.log(Status.FAIL, result.getThrowable());
	extentTest.get().log(Status.FAIL, result.getThrowable());

}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		//extent.log(Status.PASS, "Test passed");
		extentTest.get().log(Status.PASS, "Test Passing");
	}

	@Override
	public void onFinish(ITestContext context) {
		
	er.flush();
	}
}

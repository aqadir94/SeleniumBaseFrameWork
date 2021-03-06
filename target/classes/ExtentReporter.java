package Resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	
	public static ExtentReports getReport() {
		
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter esr=new ExtentSparkReporter(path);
		esr.config().setReportName("Practice");
		
		ExtentReports er=new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Tester", "Abdul");
		
		
		return er;
		
		
	}

}

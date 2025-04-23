package SeleniumStudy.TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject() {
	
		
		String path =System.getProperty("user.dir")+"//reports//index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Shivanshu Test");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.createTest(path);
		return extent;
	}

}

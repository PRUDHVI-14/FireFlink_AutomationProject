package ninjaCRM.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class implements the ITestListner Interface
 */
public class ListnerImpimentations  implements ITestListener  {
	
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" =====Test Execution started====");
		
		//intimate ExtentReports for @Test start
		test = report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" ======Test Execution PASS=====");
		
		//log the status of @Test as PASS in your ExtentReport
		test.log(Status.PASS,methodname+" ======Test Execution PASS=====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" ======Test Execution  Failed =====");
		

		//log the status of @Test as FAIL in your ExtentReport
		test.log(Status.FAIL,methodname+" ======Test Execution FAILED=====");
		
		//to capture the exception
		System.out.println(result.getThrowable());// to prints in console
		
		
		//log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());//to print in reports
		
		//to capture the screen shot of failed test
		JavaUtilities jUtil = new JavaUtilities();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//screenshot name - method name + date nd time
		String screenShotName = methodname+jUtil.getSystemDate();
		try {
			String path = wUtil.captureScreenShot(BaseClass.sDriver, screenShotName);
			
			//Attach ScreenShot to Extent report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" ======Test Excecution skipped=====");
		
		
		//log the status of @Test as SKIPPED in your ExtentReport
		test.log(Status.SKIP,methodname+" ======Test Execution SKIPPED=====");
				
				
		//to capture the exception
		System.out.println(result.getThrowable());
		
		
		//log the exception in Extent Reports
		test.log(Status.INFO, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("======Test is started=====");
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Extent-Report-"+new JavaUtilities().getSystemDate()+".html");
		esr.config().setDocumentTitle("Ninza CRM Automation report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Web Automation Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Window");
		report.setSystemInfo("Base URL", "Test Env");
		report.setSystemInfo("Report Name", "Prudhvi");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("======Test is finished=====");
		
		//responsible for report generation, without this flush() method report will not generate
		report.flush();
	}

	
}

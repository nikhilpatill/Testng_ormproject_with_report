package listeners;

import java.io.IOException;

import org.GenericMethod.GenericMethod;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.utilities.ExtentReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import resources.Base;


public class MyListeners extends Base implements ITestListener {
	
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReport.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS,"Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		GenericMethod Gn =new GenericMethod();
		extentTest.fail(result.getThrowable());
		
		WebDriver driver = null;
		String testName = result.getName();
		try {
			  

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
	}
	
}

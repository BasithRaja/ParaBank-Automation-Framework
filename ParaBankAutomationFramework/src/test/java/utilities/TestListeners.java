package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import constantClasses.ConstantData;

public class TestListeners extends BaseClass implements ITestListener {
	
	ExtentReports extent = ExtentReportManager.createExtentReport();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		System.out.println("Test Case Started");
		Reporter.log("Opening Browser for Test execution");
		
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		System.out.println("Test Case Successful");
		Reporter.log("Test Case Successful");
		
		test.pass("Test Case Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		Reporter.log("Test Case Failed --------> Taking Screenshot");
		
		test.fail(result.getThrowable());
		
		TakesScreenshot srcshot = (TakesScreenshot)driver;
		File sourceFile = srcshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(ConstantData.FAILED_SCREENSHOT_PATH);
		try {
			FileUtils.copyFile(sourceFile, destFile);
			
			test.addScreenCaptureFromPath(destFile.getAbsolutePath());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Screenshot Captured");	
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test Case Skipped");
	}

	// Extent Report
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}

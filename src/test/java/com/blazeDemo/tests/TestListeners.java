package com.blazeDemo.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.blazeDemo.utils.ScreenshotUtility;

public class TestListeners implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("-----Test Suite  " + context.getName() + " started ----");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("-----Running Test Method " + result.getMethod().getMethodName() + "...");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("-----Executed  " + result.getMethod().getMethodName() + " test successfully");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy-HH-mm-ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);
		System.out.println("Test Execution " + result.getMethod().getMethodName() + " failed..");

		WebDriver driver = ((BaseClass) result.getInstance()).getDriver();
		
		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + timeStamp + ".png";
		
		String fileSeparator = System.getProperty("file.separator");
		String filePath = System.getProperty("user.dir") + fileSeparator + "Screenshots" + fileSeparator;
		

		try {
			ScreenshotUtility.takeScreenShot(driver, filePath + screenShotName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("-----Test  " + result.getMethod().getMethodName() + " skipped...");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("-----Test Failed but within percentage  " + result.getMethod().getMethodName());

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("-----Test Suite  " + context.getName() + " ending ----");

	}

}

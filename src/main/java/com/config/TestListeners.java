package com.config;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Started : " + result.getName());
		Constants.test.log(Status.INFO, "On Test Start : " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Successed : " + result.getName());
		Constants.test.log(Status.INFO, "On Test Successed : " + result.getName());
		try {
			Constants.test.pass("Test Passed ",
					MediaEntityBuilder
							.createScreenCaptureFromPath(Utility.captureScreenshot(Constants.driver, result.getName()))
							.build());
		} catch (IOException e) {
			System.out.println("File not found" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failed : " + result.getName());
		Constants.test.log(Status.INFO, "On Test Failed : " + result.getName());
		try {
			Constants.test.pass("Test Failed ",
					MediaEntityBuilder
							.createScreenCaptureFromPath(Utility.captureScreenshot(Constants.driver, result.getName()))
							.build());
		} catch (IOException e) {
			System.out.println("File not found" + e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped : " + result.getName());
		Constants.test.log(Status.INFO, "On Test Skipped : " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		DateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		Date currentDate= new Date();
		// Start Reporters
		ExtentHtmlReporter reporter= new ExtentHtmlReporter(
				new File(System.getProperty("user.dir")+"/Report/ExtentsReport"+" "+dateTimeFormat.format(currentDate)+".html"));
		// create ExtentReports and attach reporter
		Constants.extent = new ExtentReports();
		Constants.extent.attachReporter(reporter);
		// creates a toggle for the given test, adds all log events under it
		Constants.test = Constants.extent.createTest("Urban Ladder Report");
		// log(Status, details)
		Constants.test.log(Status.INFO, "Urban Ladder");
	}                                                                      

	@Override
	public void onFinish(ITestContext context) {
		// calling flush writes everything to the log file
				Constants.extent.flush();

	}

}

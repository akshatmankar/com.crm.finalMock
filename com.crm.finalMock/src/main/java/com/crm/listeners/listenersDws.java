package com.crm.listeners;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import DWSBaseClass.DWS_BaseClass;

public class listenersDws extends DWS_BaseClass implements ITestListener {
	public static ExtentSparkReporter spark =null;
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test=report.createTest(name); 
		test.log(Status.INFO,name+"ontestStart ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String name = result.getMethod().getMethodName();
		test.log(Status.PASS,name+"is pass");
	     
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LocalDateTime data = LocalDateTime.now();
		String time = data.toString().replace(':','-');
		String name = result.getMethod().getMethodName();
		Reporter.log("ontestfailure for "+name,true);
		TakesScreenshot ts = (TakesScreenshot)driver;
	   File from= ts.getScreenshotAs(OutputType.FILE);
	   
	   File to = new File(".\\src\\test\\resources\\ScreenshotDWS"+name+time+".png");
	   try {
		FileHandler.copy(from, to);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   test.log(Status.FAIL,name+"is fail");
	}



	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP,name+"is skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onstart",true);
		File path=new File(".\\src\\test\\resources\\Report\\SingleReport.html");
		//create ExtensSparkReport
		spark=new ExtentSparkReporter(path);
		//configure  ExtentSparkReport
		spark.config().setDocumentTitle("DemoWebShop");
		spark.config().setReportName("Akshat");
		spark.config().setTheme(Theme.DARK);
		//create ExtentReport
		report=new ExtentReports(); 
		//provide system information
		report.setSystemInfo("OS", "Window_10");
		report.setSystemInfo("Browser","Chrome");
		//attach the ExtentSparkReport to ExtentReport
		report.attachReporter(spark);
		}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
      
}

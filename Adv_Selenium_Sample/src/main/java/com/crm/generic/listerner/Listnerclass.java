package com.crm.generic.listerner;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.Webdriver.UtilityClassObject;

public class Listnerclass  implements ITestListener , ISuiteListener{

	public static ExtentReports report;
	public 	ExtentTest test;
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		String time=new Date().toString().replace(" ","_").replace(":"," ");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvacedReport/report2"+time+".html");
		spark.config().setDocumentTitle("crm test suit");
		spark.config().setReportName("CRM");
		spark.config().setTheme(Theme.DARK);
		
		//add env info
		
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("window-10","os");
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName()+"  start");
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"  start");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=========+result.getMethod().getMethodName()+============================");
		test.log(Status.INFO, result.getMethod().getMethodName()+"  successc ");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname=result.getMethod().getMethodName();
		 test=report.createTest("createContactest");
		TakesScreenshot s=(TakesScreenshot)BaseClass.sdriver;
		String path=s.getScreenshotAs(OutputType.BASE64);
				
		String time=new Date().toString().replace(" ","_").replace(":"," ");
		test.addScreenCaptureFromBase64String(path, testname+"_"+time);
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"======skipped===");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		
	}
	

}

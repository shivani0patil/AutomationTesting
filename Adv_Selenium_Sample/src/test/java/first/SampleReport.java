package first;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.listerner.BaseClass;

public class SampleReport {
	public ExtentReports report;
	public ExtentTest test;
	@BeforeSuite
	public void confibs()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvacedReport/report2.html");
		spark.config().setDocumentTitle("crm test suit");
		spark.config().setReportName("CRM");
		spark.config().setTheme(Theme.DARK);
		
		//add env info
		
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("window-10","os");
		
	}
	@AfterSuite
	public void confiAF()
	{
		report.flush();
	}
	
	@Test
	public void createContactest()
	{
		WebDriver driver2 =new ChromeDriver();
		driver2.get("http://localhost:8888/");
		TakesScreenshot s=(TakesScreenshot)driver2;
		String path=s.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test=report.createTest("createContactest");		
		test.log(Status.INFO, "login appp");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDF"))
		{
			test.log(Status.PASS, "contact created");
		}
		else
		{
			test.addScreenCaptureFromBase64String(path,"ErrorFile");
		}
		
		driver2.close();
		
	}

	
}

package com.crm.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.generic.Databse.PropertFile;
import com.crm.generic.Fileutility.ExcelUtility;
import com.crm.generic.Webdriver.JavaUtility;
import com.crm.generic.Webdriver.WebDriverUtility;

public class CreateIntegrationOrg {
	public static void main(String[] args) throws Throwable
	{
		PropertFile p=new PropertFile();
		JavaUtility ja=new JavaUtility();
		ExcelUtility x=new ExcelUtility();
		WebDriverUtility web=new WebDriverUtility();
		
		String Browser=p.getDataProperty("browser");
		String URL=p.getDataProperty("url");
		String User=p.getDataProperty("username");
		String password=p.getDataProperty("password");
		
	      
	      // read data from the excel
	     int randomnum=ja.random();
	  
	     String lastname= x.getDataExcel("Sheet1", 7, 3)+randomnum;
	     String orgname=x.getDataExcel("Sheet1", 7, 2)+randomnum; 
	    
		//read data
	     String startdate=  ja.getSystemStartDate();
	     String enddate   =    ja.getRequiredDate(30);
	    	    
	    WebDriver driver=null;
	   if(Browser.equals("chrome"))
	   {
	  	 driver=new ChromeDriver();
	   }
	   else if(Browser.equals("firefox"))
	   {
	  	 driver=new FirefoxDriver();
	  	 
	   }
	   else if(Browser.equals("Edges"))
	   {
	  	 driver=new EdgeDriver();
	  	 
	   }
	   else
	   {
	  	 driver=new ChromeDriver(); 
	   }
	   
	   driver.get(URL);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   driver.findElement(By.name("user_name")).sendKeys(User);
	   driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 
		 // click organisation
		 driver.findElement(By.linkText("Organizations")).click();
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		  driver.findElement(By.name("accountname")).sendKeys(orgname);	
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//verify the header 
			String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinfo.contains(orgname))
			{
				System.out.println(orgname+" ======pass");
			}
			else
			{
				System.out.println(orgname+" ======fail");
			}

			//click on contact 
			 driver.findElement(By.linkText("Contacts")).click();
			 
	    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	    
	    driver.findElement(By.name("lastname")).sendKeys(lastname);
	    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	    //switch to chidl 
	    
	    web.SwitchToWindowUrl(driver, "module=Accounts");
	   
	    
	  	driver.findElement(By.name("search_text")).sendKeys(orgname);
	  	driver.findElement(By.name("search")).click();
	  	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	  	
	  	//parent window
	  	 web.SwitchToWindowUrl(driver, "Contacts&action");

	  	
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
	}
}

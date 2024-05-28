package com.crm.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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

public class CreateContactDate {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		PropertFile p=new PropertFile();
		JavaUtility ja=new JavaUtility();
		ExcelUtility x=new ExcelUtility();
		
		String Browser=p.getDataProperty("browser");
		String URL=p.getDataProperty("url");
		String User=p.getDataProperty("username");
		String password=p.getDataProperty("password");
		
	      
	      // read data from the excel
	     int randomnum=ja.random();
	  
	     String lastname= x.getDataExcel("Sheet1", 7, 3)+randomnum;
	      
	  
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
	      driver.findElement(By.linkText("Contacts")).click();
	      driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	      driver.findElement(By.name("lastname")).sendKeys(lastname);
	     ///
	      
	      driver.findElement(By.name("support_start_date")).clear();
	      driver.findElement(By.name("support_start_date")).sendKeys(startdate);
	      
	      driver.findElement(By.name("support_end_date")).clear();
	      driver.findElement(By.name("support_end_date")).sendKeys(enddate);
	      
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        
	        String act=driver.findElement(By.id("dtlview_Support Start Date")).getText();
        if(act.equals(startdate))
        {
      	  System.out.println("verifed ");
        }
        else
        {
      	  System.out.println("verifed not ===fail");
        }
       
	}

}

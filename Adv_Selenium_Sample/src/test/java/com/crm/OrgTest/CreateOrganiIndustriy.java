package com.crm.OrgTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.generic.Databse.PropertFile;
import com.crm.generic.Fileutility.ExcelUtility;
import com.crm.generic.Webdriver.JavaUtility;
import com.crm.generic.Webdriver.WebDriverUtility;

public class CreateOrganiIndustriy {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
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
	  
	     String dropdown= x.getDataExcel("Sheet1", 4, 3);
	     String orgname=x.getDataExcel("Sheet1", 4, 2)+randomnum; 
	     String Type=x.getDataExcel("Sheet1", 4, 4);
	      
	     
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
	     
	      
		 
		 driver.findElement(By.linkText("Organizations")).click();
			
			//click on create button
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			
			WebElement select1=driver.findElement(By.name("industry"));

			web.selectDropDown(select1, dropdown);
			
			
			
			WebElement select2=driver.findElement(By.name("accounttype"));
			web.selectDropDown(select2, Type);
			
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//verify the header result
			String actualname=driver.findElement(By.id("mouseArea_Industry")).getText();
			if(actualname.contains(dropdown))
			{
				System.out.println(orgname+"verified=====pass");
			}
			else
			{
				System.out.println(orgname+"verified=====fail");
			}
		
			
		String h=	driver.findElement(By.id("mouseArea_Type")).getText();
		if(h.equals(Type))
		{
			System.out.println(orgname+" availabel=====pass");	
		}
		else
		{
			System.out.println(orgname+"not available=====fail");
		}
	}

}

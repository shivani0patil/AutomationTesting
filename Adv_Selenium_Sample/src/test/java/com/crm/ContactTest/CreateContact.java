package com.crm.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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

import com.crm.generic.Databse.*;
import com.crm.generic.Fileutility.ExcelUtility;

public class CreateContact {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//read data from propert utility file
		PropertFile p=new PropertFile();
		String Browser=p.getDataProperty("browser");
		String URL=p.getDataProperty("url");
		String User=p.getDataProperty("username");
		String password=p.getDataProperty("password");
		
		Random r=new Random();
		int num=r.nextInt(1000);
		
		ExcelUtility ex=new ExcelUtility();
		String Lastname=ex.getDataExcel("Sheet1", 1, 3)+num;
	     
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
	      driver.findElement(By.name("lastname")).sendKeys(Lastname);
	      
	      driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	      
//	      String actual=driver.findElement(By.id("mouseArea_Office Phone")).getText();
//	      if(actual.equals(number))
//	      {
//	    	  System.out.println(number+" availabel=====pass");
//	      }
	      
	      
	      
	      
	      
	      driver.close();
	}

}

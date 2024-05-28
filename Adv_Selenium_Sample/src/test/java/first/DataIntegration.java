package first;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class DataIntegration {

	public static void main(String[] args)throws Throwable, IOException {
		// TODO Auto-generated method stub
		//read data from properties file common data
		FileInputStream fs=new FileInputStream("./src/test/resources/comm.properties");
	      Properties p=new Properties();
	      p.load(fs);
	      String Browser=p.getProperty("browser");
	      String URL=p.getProperty("url");
	      String User=p.getProperty("username");
	      String password=p.getProperty("password");
	      


	      WebDriver driver=null;
	      if(Browser.equals("chrome"))
	      {
	    	  driver=new ChromeDriver();
	      }
	      else if(Browser.equals("firefox"))
	      {
	    	  driver=new  FirefoxDriver();
	      }
	      else if(Browser.equals("edge"))
	      {
	    	  driver=new EdgeDriver();
	      }
	      else
	      {
	    	  driver=new ChromeDriver();
	      }
        
	      //create random class object
	      Random ran=new Random(1000);
	      int randnum=ran.nextInt();
	      
	      //read data from the excel sheet
	      FileInputStream fss=new FileInputStream("./src/test/resources/Book5.xlsx");
			Workbook wb=WorkbookFactory.create(fss);
			Sheet sh=wb.getSheet("Sheet1");
			Row ro=sh.getRow(1);
		String name=	ro.getCell(2).toString()+randnum;
		
		
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(User);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		//click on organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//logout
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		//driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
		
		
	}

}

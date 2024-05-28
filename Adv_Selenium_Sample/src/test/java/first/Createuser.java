package first;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Createuser {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fs=new FileInputStream("./src/test/resources/comm.properties");
	      Properties p=new Properties();
	      p.load(fs);
	      String Browser=p.getProperty("browser");
	      String URL=p.getProperty("url");
	      String User=p.getProperty("username");
	      String password=p.getProperty("password");
	      
//	      Scanner sc=new Scanner(System.in);
//	      String b=sc.next();
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
		//WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(User);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		
		
		
	}

}

package first;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RuntimeParameter {

	@Test
	public void seleniunTest()
	{
		String URL=System.getProperty("url");
		String BROWSER=System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		System.out.println("url-------"+URL);
		System.out.println("browser-------"+BROWSER);
		System.out.println("username-------"+USERNAME);
		System.out.println("password-------"+PASSWORD);
		
		 WebDriver driver=null;
	      if(BROWSER.equals("chrome"))
	      {
	    	  driver=new ChromeDriver();
	      }
	      else if(BROWSER.equals("firefox"))
	      {
	    	  driver=new  FirefoxDriver();
	      }
	      else if(BROWSER.equals("edge"))
	      {
	    	  driver=new EdgeDriver();
	      }
	      else
	      {
	    	  driver=new ChromeDriver();
	      }
		//WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
	}
	
	}



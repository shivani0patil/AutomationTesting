package practices;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
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
public class CreateIntegrationOrg {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fs=new FileInputStream("./src/test/resources/comm.properties");
	      Properties p=new Properties();
	      p.load(fs);
	      String Browser=p.getProperty("browser");
	      String URL=p.getProperty("url");
	      String User=p.getProperty("username");
	      String password=p.getProperty("password");
	      
	      // read data from the excel
	      Random num=new Random();
	      int random=num.nextInt();
	      FileInputStream fss=new FileInputStream("./src/test/resources/Book5.xlsx");
	      Workbook wh=WorkbookFactory.create(fss);
	      Sheet sh=wh.getSheet("Sheet1");
	      Row row=sh.getRow(7);
	     String orgname= row.getCell(2).toString()+random;
	     String lastname=row.getCell(3).getStringCellValue();
	     //String Type=row.getCell(4).toString();
	     wh.close();
	      
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
	      
	      Set<String> set=driver.getWindowHandles();
	      Iterator it=set.iterator();
	      while(it.hasNext())
	      {
	    	  String winid=(String) it.next();
	    	  driver.switchTo().window(winid);
	    	  String url=driver.getCurrentUrl();
	    	  System.out.println(url);
	    	  if(url.equals("module=Accounts"))
	    	  {
	    		  break;
	    	  }
	    	  
	      }
	      
	    	driver.findElement(By.name("search_text")).sendKeys(orgname);
	    	driver.findElement(By.name("search")).click();
	    	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	    	
	    	//parent window
	    	Set<String> set1=driver.getWindowHandles();
		      Iterator it1=set1.iterator();
		      while(it1.hasNext())
		      {
		    	  String winid=(String) it1.next();
		    	  driver.switchTo().window(winid);
		    	  String url=driver.getCurrentUrl();
		    			  
		    	  if(url.equals("Contacts&action"))
		    	  {
		    		  break;
		    	  }
		    	  
		      }
		      driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	}

}

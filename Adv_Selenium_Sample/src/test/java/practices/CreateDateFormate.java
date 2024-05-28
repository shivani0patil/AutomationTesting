package practices;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class CreateDateFormate {

	public static void main(String[] args) throws Throwable, IOException {
		// TODateDO Auto-generated method stub
		
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
	     //String orgname= row.getCell(2).toString()+random;
	     String lastname=row.getCell(3).getStringCellValue();
	     //String Type=row.getCell(4).toString();
	     wh.close();
	    
		//read data
         Date ob=new Date();
         SimpleDateFormat sim= new SimpleDateFormat("yyyy-mm-dd");
        String startdate= sim.format(ob);
       
        Calendar cal=sim.getCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -30);
        String enddate=sim.format(cal.getTime());
        
        
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

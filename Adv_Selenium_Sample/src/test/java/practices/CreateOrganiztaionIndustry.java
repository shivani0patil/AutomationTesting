package practices;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganiztaionIndustry {

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
	      Row row=sh.getRow(4);
	     String orgname= row.getCell(2).toString()+random;
	     String dropdown=row.getCell(3).toString();
	     String Type=row.getCell(4).toString();
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
	     
	      
		 
		 driver.findElement(By.linkText("Organizations")).click();
			
			//click on create button
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			WebElement select1=driver.findElement(By.name("industry"));
			Select s1=new Select(select1);
			s1.selectByVisibleText(dropdown);
			
			WebElement select2=driver.findElement(By.name("accounttype"));
			Select s2=new Select(select2);
			s2.selectByVisibleText(Type);

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

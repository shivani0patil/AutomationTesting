package first;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadJasonSelenium {

	@Test
	public void creat() throws FileNotFoundException, IOException, ParseException
	{
		//read common data from json file
		JSONParser per=new JSONParser();
		Object obj=per.parse(new FileReader("./src/test/resources/jscomman.json"));
		JSONObject map=(JSONObject)obj;
		 String Browser=map.get("browser").toString();
		 String Url=map.get("url").toString();
		 String Username=map.get("username").toString();
		 String Password=map.get("password").toString();
		 //String =map.get("browser").toString();
		 
		 
		 
		// read test scrip data from excel
		  Random ran=new Random(1000);
	      int randnum=ran.nextInt();
	      //read data from the excel sheet
	      FileInputStream fss=new FileInputStream("./src/test/resources/Book5.xlsx");
			Workbook wb=WorkbookFactory.create(fss);
			Sheet sh=wb.getSheet("Sheet1");
			Row ro=sh.getRow(1);
		String name=	ro.getCell(2).toString()+randnum;
		
		
		
		
		WebDriver driver=null;
		
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();
			//click on organization
			driver.findElement(By.linkText("Organizations")).click();
			
			//click on create button
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(name);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		 
		
	}
	
}

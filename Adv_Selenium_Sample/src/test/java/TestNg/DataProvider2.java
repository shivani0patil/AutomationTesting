package TestNg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.generic.Fileutility.ExcelUtility;

public class DataProvider2 {
	@Test(dataProvider="getData")
	public void craeteContacttest(String phone,String product)
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(phone,Keys.ENTER);
	
	String x="//span[text()='"+product+"'])/../../../../div[3]/div[1]/div/div[1]/div[1]/a/span/span[2]/span[2]";
	String value=driver.findElement(By.xpath(x)).getText();
	System.out.println(value);
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable, Throwable
	{
		ExcelUtility e=new ExcelUtility();
		int row=e.getRowNum("Sheet1");
		Object[][] ob=new Object[row][2];
		for(int i=0;i<=row;i++)
		{
		ob[i][0]=e.getDataExcel("Sheet1", i+1, 0);
		ob[i][1]=e.getDataExcel("Sheet1", i+1, 1);
	      
		}
		return ob;
	}


}

package TestNg;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample {
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
	public Object[][] getData()
	{
		Object[][] ob=new Object[3][2];
		ob[0][0]="iphone";
		ob[0][1]="Apple iPhone 14 (128 GB) - Blue";
		
		ob[1][0]="iphone";
		ob[1][1]="Apple iPhone 13 (128GB) - Blue";

		ob[2][0]="iphone";
		ob[2][1]="Apple iPhone 13 (128GB) - Starlight";

		return ob;
	}
	

}

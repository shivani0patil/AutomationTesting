package asser;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HomePage {

	
	@Test
	public void homePageVerify(Method mtd)
	{
		System.out.println(mtd.getName()+"test satrrt");
		String expected="Home Page";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actual=driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		Assert.assertEquals(actual, expected);
		driver.close();
		System.out.println(mtd.getName()+"test ends");
	}
	
	@Test
	public void  logo(Method mtd)
	{
		System.out.println(mtd.getName()+"test satrrt");
		boolean flag=true;
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean actual=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		Assert.assertTrue(actual);
		driver.close();
		System.out.println(mtd.getName()+"test ends");
	}

}

package asser;


import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.generic.Databse.PropertFile;
import com.crm.generic.Fileutility.ExcelUtility;
import com.crm.generic.Webdriver.JavaUtility;

import TestNg.BaseClass;

public class CreateContact  extends BaseClass
{
	@Test(groups="smokeTest")
	public void contactTest() throws IOException, Throwable {
		// read data from propert utility file

		// WebDriver driver;
		Random r = new Random();
		int num = r.nextInt(1000);

		ExcelUtility ex = new ExcelUtility();
		String Lastname = ex.getDataExcel("Sheet1", 1, 3) + num;

		com.crm.ObjectRepository.CreateContact c=new com.crm.ObjectRepository.CreateContact(driver);
		c.getContactlink().click();
		c.getCreatcontact().click();
		c.getLastname().sendKeys(Lastname);
		c.getSavebtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String act=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean sat=act.contains(Lastname);
		Assert.assertEquals(sat,true);
		
		String Lastct=driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(Lastct,Lastname);
		
		

	}

	

}

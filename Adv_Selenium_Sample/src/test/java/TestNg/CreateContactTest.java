package TestNg;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.crm.ObjectRepository.CreateContact;

import com.crm.generic.Databse.PropertFile;
import com.crm.generic.Fileutility.ExcelUtility;
import com.crm.generic.Webdriver.JavaUtility;

public class CreateContactTest extends BaseClass {

	@Test(groups="smokeTest")
	public void contactTest() throws IOException, Throwable {
		// read data from propert utility file

		// WebDriver driver;
		Random r = new Random();
		int num = r.nextInt(1000);

		ExcelUtility ex = new ExcelUtility();
		String Lastname = ex.getDataExcel("Sheet1", 1, 3) + num;

		com.crm.ObjectRepository.CreateContact c = new CreateContact(driver);
		c.getContactlink().click();
		c.getCreatcontact().click();
		c.getLastname().sendKeys(Lastname);
		c.getSavebtn().click();

	}

	@Test
	public void createDate() throws Throwable, Throwable 
	{
		JavaUtility j = new JavaUtility();

		String start = j.getSystemStartDate();
		String end = j.getRequiredDate(-30);
		Random r = new Random();
		ExcelUtility ex = new ExcelUtility();
		  int num = r.nextInt(1000);
		  String Lastname = ex.getDataExcel("Sheet1", 1, 3) + num;

		 com.crm.ObjectRepository.CreateContact c = new CreateContact(driver);
		c.getContactlink().click();
		c.getCreatcontact().click();
		c.getStartdata().clear();
		c.getStartdata().sendKeys(start);
		c.getEnddata().clear();
		c.getEnddata().sendKeys(end);
		c.getLastname().sendKeys(Lastname);
		c.getSavebtn().click();

	}
}

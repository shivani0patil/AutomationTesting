package asser;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class HomePage2 {
	@Test
	public void homePageVerify(Method mtd)
	{
		SoftAssert assertobj=new SoftAssert();
		Reporter.log(mtd.getName()+"test satrrt");
		Reporter.log("test-1 satrrt",true);
		Reporter.log("test-2 satrrt",true);
		assertobj.assertEquals("Home","Home");
		Reporter.log("test-3 satrrt",true);
		Reporter.log("test-4 satrrt",true);
		assertobj.assertEquals("title","title");
		assertobj.assertAll();
		Reporter.log(mtd.getName()+"test ends");
	}
	
	@Test
	public void  logo(Method mtd)
	{
		SoftAssert assertobj=new SoftAssert();

		Reporter.log(mtd.getName()+"test satrrt");
		Reporter.log(mtd.getName()+"test satrrt");
		Reporter.log("test-1 satrrt",true);
		Reporter.log("test-2 satrrt",true);
		assertobj.assertTrue(true);
		Reporter.log("test-3 satrrt",true);
		Reporter.log("test-4 satrrt",true);
		assertobj.assertAll();
		Reporter.log(mtd.getName()+"test ends");
	}

}

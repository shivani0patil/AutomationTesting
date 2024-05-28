package TestNg;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class Base2 {
	
	 @BeforeClass
		public void confiBC2() throws Throwable
		{
			System.out.println("before class1");
				     
		}
	 @BeforeClass
		public void confiBCc() throws Throwable
		{
			System.out.println("before class2");
				     
		}
	    @BeforeMethod
		public void confiBM() throws Throwable
		{
			System.out.println("lancu browser");
				     
		}
	
	@BeforeMethod
	public void configBm() throws Throwable
	{
		System.out.println("login ===");
		
	}
	@AfterMethod
	public void configAm()
	{
		
		System.out.println("logout===");
			}
	@AfterClass
	public void configAC()
	{
		System.out.println("close browser");

	}

    @BeforeSuite
    public void config()
    {
    	System.out.println(" open database connection");
    }
    @AfterSuite
    public void configAS()
    {
    	System.out.println(" close database connection");
    }
    
    @Test
    public void test()
    
    {
    	System.out.println("test hgxys");
    }
   @Test
   public void test2()
   {
	   System.out.println("xcution2 ");
   }
   
}

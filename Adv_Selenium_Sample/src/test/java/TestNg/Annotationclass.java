package TestNg;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class Annotationclass {
	
	@Test
	public void createcontact()
	{
		System.out.println("excuteed test");
	}
	
	@BeforeMethod
	public void configBm()
	{
		System.out.println("before method");
	}

	@AfterMethod
	public void configAm()
	{
		System.out.println("After method");
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("Afterclasss ");
	}
	@BeforeClass
	public void confiBC()
	{
		System.out.println("Before class");
	}

    @BeforeSuite
    public void config()
    {
    	System.out.println("before suit");
    }
    
}

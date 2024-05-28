import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.generic.Fileutility.ExcelUtility;
import com.crm.generic.Fileutility.PropertFile;
import com.crm.generic.Webdriver.JavaUtility;
import com.crm.generic.Webdriver.WebDriverUtility;

public class DeleteOrgname {
	public static void main(String[] args) throws Throwable
	{
		PropertFile fu=new PropertFile();
		ExcelUtility e=new ExcelUtility();
		JavaUtility ju=new  JavaUtility();
		WebDriverUtility web=new WebDriverUtility();
		
		String Browser =fu.getDataProperty("browser");
		String Url=fu.getDataProperty("url");
		String Username =fu.getDataProperty("username");
		String Password=fu.getDataProperty("password");
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
	     
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		LoginPage lp=new LoginPage(driver);
	    lp.login(Username, Password);
		
	     	int num=ju.random();
	     	String orgname=e.getDataExcel("Sheet1", 4, 2)+num;
	     	
			HomePage h=new HomePage(driver);
			h.getOrganization().click();
			
			OrganizationPage or=new OrganizationPage(driver);
			or.getButton().click();
			or.crateorgn(orgname);
			
		    String actula=or.getHeaderifo1().getText();
		    if(actula.contains(orgname))
		
		    {
		    	System.out.println(orgname+"verify pass");
		    }
		    else
		    {
		    	System.out.println(orgname+"verify pass");	
		    }
			
			//back to organization link
		    h.getOrganization().click();
		    
		    or.getSearctext().sendKeys(orgname);
		    web.selectDropDown(or.getDropdwon(), 1);
		    or.getSubmit().click();
		    
		    
		    driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		    driver.switchTo().alert().accept();
		    
			}

}

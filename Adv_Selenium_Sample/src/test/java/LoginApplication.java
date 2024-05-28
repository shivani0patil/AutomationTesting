import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.CreateNewOrganization;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.generic.Fileutility.ExcelUtility;
import com.crm.generic.Fileutility.PropertFile;
import com.crm.generic.Webdriver.JavaUtility;

public class LoginApplication {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		PropertFile fu=new PropertFile();
		ExcelUtility e=new ExcelUtility();
		JavaUtility ju=new  JavaUtility();
		
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
		String dropdown= e.getDataExcel("Sheet1", 4, 3);
		String Type=e.getDataExcel("Sheet1", 4, 4);
		  
		  
		//click on organization link
		 OrganizationPage or=new OrganizationPage(driver);
		
		 or.getOrganization().click();
		
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	     or.getButton().click();
		//driver.findElement(By.name("accountname")).sendKeys(orgname);
	
	     // create with name only
	    // or.crateorgn(orgname);	
	     
	     
	     // create the organization with industrie dropdown
	     CreateNewOrganization cr=new CreateNewOrganization(driver);
	     cr.createOrgindusrt(orgname, dropdown, Type);
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     HomePage h=new HomePage(driver);
	     h.logout();
		
	   
	     
	}

}

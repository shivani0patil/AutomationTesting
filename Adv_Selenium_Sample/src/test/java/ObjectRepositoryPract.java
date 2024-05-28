import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepositoryPract {
    
	@FindBy(name="user_name")
	WebElement usernameEdt;
	
	@FindBy(name="user_password")
	WebElement passwordEdt;
	
//	@FindBy(id="button")
//	WebElement btnEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	WebElement btnEdt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://localhost:8888/");
		
		
		ObjectRepositoryPract r=PageFactory.initElements(driver,ObjectRepositoryPract.class);
		r.usernameEdt.sendKeys("admin");
		r.passwordEdt.sendKeys("admin");
		//r.btnEdt.click();
		
		driver.navigate().refresh();
		r.usernameEdt.sendKeys("admin");
		r.passwordEdt.sendKeys("admin");
		r.btnEdt.click();

	}

}

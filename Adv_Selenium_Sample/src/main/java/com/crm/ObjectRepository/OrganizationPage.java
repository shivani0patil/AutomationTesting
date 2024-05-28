package com.crm.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	 @FindBy(linkText="Organizations")
	 private  WebElement organization;
	
	 @FindBy(xpath="//img[@alt='Create Organization...']")
	 private WebElement  button;

	 @FindBy(name="accountname")
	 private WebElement orgname;

	 @FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement  savebtn;
	 
	 @FindBy(xpath="//span[@class='dvHeaderText']")
	 private WebElement headerifo;
	 
	 @FindBy(name="search_text")
	 private WebElement searctext;
	 
	 @FindBy(name="submit")
	 private WebElement submit;
	 
	 @FindBy(name="search_field")
	 private WebElement dropdwon;
	 
	public WebElement getSearctext() {
		return searctext;
	}



	public WebElement getSubmit() {
		return submit;
	}



	public WebElement getDropdwon() {
		return dropdwon;
	}



	public WebElement getHeaderifo1() {
		return headerifo;
	}



	public WebElement getSavebtn() {
		return savebtn;
	}



	public WebElement getOrgname() {
		return orgname;
	}

   

	



	public WebElement getButton() {
		return button;
	}
	


	public WebElement getOrganization() {
		return organization;
	}
	 
	 
	public void crateorgn(String name) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		orgname.sendKeys(name);
		savebtn.click();
	}



	


	
	 
}

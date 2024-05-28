package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganization {

	WebDriver driver;
	
	public CreateNewOrganization(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	
	 @FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement  savebtn;
	 
	 @FindBy(name="accountname")
	 private WebElement orgname;
	 
	 @FindBy(name="industry")
	 private WebElement indusrty;
	 
	 @FindBy(name="accounttype")
	 private WebElement accountyp;

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getIndusrty() {
		return indusrty;
	}

	public WebElement getAccountyp() {
		return accountyp;
	}
	 
	
	public void createOrgindusrt(String name,String industryname, String nametype)
	{
		orgname.sendKeys(name);	
		
		Select s=new Select(indusrty);
		s.selectByVisibleText(industryname);
		Select s1=new Select(accountyp);
		s1.selectByVisibleText(nametype);
		savebtn.click();
	}
	 
}

package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact {

	WebDriver driver=null;
	public CreateContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement creatcontact;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name="support_start_date")
	private WebElement startdata;
	
	public WebElement getStartdata() {
		return startdata;
	}

	public WebElement getEnddata() {
		return enddata;
	}


	@FindBy(name="support_end_date")
	private WebElement enddata;
	
	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getCreatcontact() {
		return creatcontact;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
}

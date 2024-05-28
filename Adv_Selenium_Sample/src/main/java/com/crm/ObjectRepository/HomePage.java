package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Products")
	WebElement producsLinks;
	
	public WebElement getProducsLinks() {
		return producsLinks;
	}

	@FindBy(linkText="Organizations")
	WebElement organization;
	
	@FindBy(linkText="Contacts")
	WebElement ContactsEdt;
	
	@FindBy(linkText="More")
	WebElement Morelink;
	
	@FindBy(linkText="Campaigns")
	WebElement Campaignslink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement Adminimg; 
	
	
	@FindBy(linkText="Sign Out")
	WebElement SignOut;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContactsEdt() {
		return ContactsEdt;
	}

	public WebElement getMorelink() {
		return Morelink;
	}

	public WebElement getCampaignslink() {
		return Campaignslink;
	}
		
	
	public  void    moveMorelin()
	{
		Actions a=new Actions(driver);
		a.moveToElement(Morelink).perform();
		Campaignslink.click();
	}
	

	public WebElement getLogout() {
		return Adminimg;
	}

	public WebElement getSignOut() {
		return SignOut;
	}
	public  void    logout()
	{
		Actions a=new Actions(driver);
		a.moveToElement(Adminimg).perform();
		//a.moveToElement(SignOut).click();
		SignOut.click();
	}
}

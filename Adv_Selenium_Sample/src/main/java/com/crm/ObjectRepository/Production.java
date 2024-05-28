package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Production {

	
	@FindBy(linkText="Products")
	WebElement producsLinks;
	
	public WebElement getProducsLinks() {
		return producsLinks;
		
		}
	
	@FindBy(name="search_text")
	WebElement search_text;
	
	public WebElement getSearch_text() {
		return search_text;
		
		}
	
	
}

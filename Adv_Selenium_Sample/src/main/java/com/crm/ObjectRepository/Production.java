package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Production {

	
	@FindBy(linkText="Products")
	WebElement producsLinks;
	
	public WebElement getProducsLinks() {
		return producsLinks;
	}
}

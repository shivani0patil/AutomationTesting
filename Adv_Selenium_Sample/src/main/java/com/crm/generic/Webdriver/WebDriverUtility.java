package com.crm.generic.Webdriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageImplicity(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void waitImplicite(WebDriver driver,WebElement element)
	{
		WebDriverWait wit=new WebDriverWait(driver, Duration.ofSeconds(16));
		wit.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void SwitchToWindowUrl(WebDriver driver,String partialurl)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator it=set.iterator();
		while(it.hasNext())
		{
			String id=it.next().toString();
			driver.switchTo().window(id);
			String  acturl=driver.getCurrentUrl();
			if(acturl.contains(partialurl))
			{
				break;
			}
		}
	}
	
	public void SwitcToWindoTitle(WebDriver driver,String Title)
	{
		Set<String> set=driver.getWindowHandles();
	   Iterator it=set.iterator();
	while(it.hasNext())
	{
		String id=it.next().toString();
		driver.switchTo().window(id);
		String  aTitle=driver.getTitle();
		if(aTitle.contains(Title))
		{
			break;
		}
	}
	
	
	}
	
	public void swtichtoFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void swtichtoFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	public void swtichtoFrame(WebDriver driver,WebElement elemet)
	{
		driver.switchTo().frame(elemet);
	}
	
	public void selectDropDown(WebElement element ,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void selectDropDown(WebElement element ,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void selectDropDown2(WebElement element ,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
		
	}
	
	public void moveToelement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	public void Draganddropt(WebDriver driver,WebElement element1, WebElement element2)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(element1,element2).perform();
		
	}
	
	public void Alerthanlde(WebDriver driver)
	{
		
		driver.switchTo().alert().accept();
	}
}


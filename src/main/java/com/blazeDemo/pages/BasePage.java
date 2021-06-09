package com.blazeDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage {
	
	protected static WebDriver driver;

	@SuppressWarnings("static-access")
	public BasePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void assertPageTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
		
	}
	
	public static void assertText(WebElement Element,String title) {
		Assert.assertEquals(Element.getText(), title);
		
	}
	public static void clickAndselectElement(WebElement element,String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void clickElement(WebElement ele) {
		ele.click();
		
	}
}

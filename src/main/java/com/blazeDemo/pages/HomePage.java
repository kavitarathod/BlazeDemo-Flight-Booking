package com.blazeDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	@FindBy(tagName = "h1")
	protected WebElement header;
	
	@FindBy(name = "fromPort")
	protected WebElement fromSelection;
	
	@FindBy(name = "toPort")
	protected WebElement toSelection;
	
	@FindBy(xpath = "//*[@value = 'Find Flights']")
	protected WebElement submitBtn;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validateTheHeaderText() {
		
		assertText(header,"Welcome to the Simple Travel Agency!");
	}
	
	public void validateHomePageTitle() {
		assertPageTitle("BlazeDemo");
	}
	
	public void selectSouceDestination(String source, String destination) throws InterruptedException {
		
		clickAndselectElement(fromSelection,source);
		
		clickAndselectElement(toSelection,destination);

		clickElement(submitBtn);
		
		
			
	}
	

}

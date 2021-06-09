package com.blazeDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReserveFlightPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
	protected WebElement selectFlight;
	
	public ReserveFlightPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectFirstAvailableFlight() {
		selectFlight.click();
		}
	
	public void verifyReservePageDisplayed() {
		
		assertPageTitle("BlazeDemo - reserve");
		
	}

}

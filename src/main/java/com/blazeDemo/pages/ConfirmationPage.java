package com.blazeDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage {
WebDriver driver;
	
	@FindBy(tagName = "h1")
	WebElement confirmationPageTitle;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	WebElement confirmationID;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateConfirmationPageisDisplayed() {
		confirmationPageTitle.isDisplayed();
		assertText(confirmationPageTitle,"Thank you for your purchase today!");
	}
	
	public void validateConfirmationPageTitle() {
		assertPageTitle("BlazeDemo Confirmation");
	}
	
	public void getConfirmationID() {
		System.out.println("User Confirmation id is "+confirmationID.getText());
	}
}

package com.blazeDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage extends BasePage {

	WebDriver driver;
	
	@FindBy(tagName = "h2")
	WebElement purchasePageTitle;

	@FindBy(name = "inputName")
	WebElement name;

	@FindBy(name = "address")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "zipCode")
	WebElement zipCode;

	@FindBy(name = "cardType")
	WebElement cardType;

	@FindBy(name = "creditCardNumber")
	WebElement cardNumber;

	@FindBy(name = "creditCardMonth")
	WebElement month;

	@FindBy(name = "creditCardYear")
	WebElement year;

	@FindBy(name = "nameOnCard")
	WebElement cardName;

	@FindBy(name = "rememberMe")
	WebElement rememberMeCheckBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement purchaseFlightBtn;

	public PurchasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validatePurchasePageisDisplayed() {
		purchasePageTitle.isDisplayed();
		assertText(purchasePageTitle,"Your flight from TLV to SFO has been reserved.");
	}
	
	public void enterDetailsandPurchase(String Name, String Address, String City, String State,String Zipcode,String CardType,String CardNumber,String Month, String Year, String CardName) {
		name.sendKeys(Name);
		address.sendKeys(Address);
		city.sendKeys(City);
		state.sendKeys(State);
		zipCode.sendKeys(Zipcode);
		cardType.sendKeys(CardType);
		cardNumber.sendKeys(CardNumber);
		month.sendKeys(Month);
		year.sendKeys(Year);
		cardName.sendKeys(CardName);
		clickElement(rememberMeCheckBox);
		clickElement(purchaseFlightBtn);
		
		
	}
}

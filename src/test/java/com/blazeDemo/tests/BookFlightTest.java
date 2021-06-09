package com.blazeDemo.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.blazeDemo.pages.ReserveFlightPage;
import com.blazeDemo.utils.DataProviderUtility;
import com.blazeDemo.pages.ConfirmationPage;
import com.blazeDemo.pages.HomePage;
import com.blazeDemo.pages.PurchasePage;

public class BookFlightTest extends BaseClass {

	public WebDriver driver;
	HomePage homepage;
	ReserveFlightPage flightPage;
	PurchasePage purchasePage;
	ConfirmationPage confirmPage;
	DataProviderUtility utils = new DataProviderUtility();

	@BeforeClass
	public void initializeDriver() {
		driver = getDriver();
	}

	@DataProvider(name = "BookingDetailsData")
	public Object[][] getdata() throws IOException {
		return DataProviderUtility.BookingDetailsData();
	}

	@Test(description = "Search for flights", dataProvider = "BookingDetailsData")
	public void searchAndSelectFlight(String Source, String Destination, String Name, String Address, String City,
			String State, String Zipcode, String CardType, String CardNumber, String Month, String Year,
			String CardName) throws InterruptedException {
		System.out.println("Source Location is "+Source);
		System.out.println("Destination Location is "+Destination);
		homepage = new HomePage(driver);
		homepage.validateHomePageTitle();
		homepage.validateTheHeaderText();
		homepage.selectSouceDestination(Source, Destination);
	}

	@Test(description = "Select the First available Flight", dependsOnMethods = "searchAndSelectFlight")
	public void selectFlight() {
		flightPage = new ReserveFlightPage(driver);
		flightPage.verifyReservePageDisplayed();
		flightPage.selectFirstAvailableFlight();

	}

	@Test(description = "Enter details and make a Flight ticket purchase", dataProvider = "BookingDetailsData", dependsOnMethods = "selectFlight")
	public void purchaseFlightTicket(String Source, String Destination, String Name, String Address, String City,
			String State, String Zipcode, String CardType, String CardNumber, String Month, String Year,
			String CardName) {
		purchasePage = new PurchasePage(driver);
		purchasePage.validatePurchasePageisDisplayed();
		purchasePage.enterDetailsandPurchase(Name, Address, City, State, Zipcode, CardType, CardNumber, Month, Year,
				CardName);
	}

	@Test(description = "Validate the booking Confirmation", dependsOnMethods = "purchaseFlightTicket")
	public void bookingConfirm() {
		confirmPage = new ConfirmationPage(driver);
		confirmPage.validateConfirmationPageisDisplayed();
		confirmPage.validateConfirmationPageTitle();
		confirmPage.getConfirmationID();
	}

}

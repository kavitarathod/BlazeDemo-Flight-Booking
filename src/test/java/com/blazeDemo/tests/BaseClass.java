package com.blazeDemo.tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	private WebDriver driver;
	static String browser;
	static String url;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeClass
	public WebDriver setup() throws FileNotFoundException {
		
		try {
			FileReader reader = new FileReader("./src/test/resources/config.properties");
			Properties prop = new Properties();
			prop.load(reader);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			
			switch(browser.toLowerCase()) {
			
			case "chrome" : 
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Browser type "+browser+" is invalid so launching Chrome as the default browser");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
		
		
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
	

}

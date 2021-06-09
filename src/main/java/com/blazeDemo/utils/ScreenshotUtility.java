package com.blazeDemo.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static void takeScreenShot(WebDriver webdriver, String filePath) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filePath);
		System.out.println("Destination File Path " + DestFile);
		FileUtils.copyFile(SrcFile, DestFile);
	}
}

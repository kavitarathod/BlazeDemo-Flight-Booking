package com.blazeDemo.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	
	 public static WebDriver driver;
	 public static XSSFWorkbook workbook;
	 public static XSSFSheet worksheet;
	 public static DataFormatter formatter= new DataFormatter();
	 public static String file_location = System.getProperty("user.dir")+"/src/test/resources/testdata/BookingDetails.xlsx";
	 static String SheetName= "bookingData";
	 public int DataSet=-1;
	 
	@DataProvider
	public static Object[][] BookingDetailsData() throws IOException
	 {
	 FileInputStream fileInputStream= new FileInputStream(file_location);
	 workbook = new XSSFWorkbook (fileInputStream); 
	 worksheet=workbook.getSheet(SheetName);
	       XSSFRow Row=worksheet.getRow(0);   
	   
	    	int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	    	int ColNum= Row.getLastCellNum();
	    	
	    	Object Data[][]= new Object[RowNum-1][ColNum]; 
	    	
	     for(int i=0; i<RowNum-1; i++) 
	     {  
	     XSSFRow row= worksheet.getRow(i+1);
	     
	     for (int j=0; j<ColNum; j++) 
	     {
	     if(row==null)
	     Data[i][j]= "";
	     else 
	     {
	     XSSFCell cell= row.getCell(j);
	     if(cell==null)
	     Data[i][j]= "";  
	     else
	     {
	     String value=formatter.formatCellValue(cell);
	     Data[i][j]=value; 
	     }
	     }
	     }
	     }
	 
	    	return Data;
	 }

}
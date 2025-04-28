package com.easemytrip.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.easemytrip.qa.base.Testbase;

public class TestUtil extends Testbase {
	

	static ExcelUtil reader;
	
	public static ArrayList<Object[]> readExcelData()
	{
		ArrayList<Object[]> arr = new ArrayList<Object[]>(); //we should always define the type as Object as the data to be read from excel sheet could b of any type.
		reader = new ExcelUtil("src/main/java/com/easemytrip/qa/data/EaseMyTripTestData.xlsx");
		
		int rowCount = reader.getRowCount("SearchFlightData");
		
		for(int rowNum =2;rowNum<=rowCount;rowNum++)
		{
			String fromPlace = reader.getCellData("SearchFlightData", "FromPlace", rowNum);
			String toPlace = reader.getCellData("SearchFlightData", "ToPlace", rowNum);
			
			//we will first store the values in an array object
			
			Object ob[] = {fromPlace,toPlace};
			
			//then will add the entire object array in an arraylist
			
			arr.add(ob);
		}
		
		return arr;
		
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("./screenshots/Login.png")); // '.' signifies home directory //manually create screenshots folder first
		FileUtils.copyFile(scrFile, new File("./screenshots/"+ getCurrentDateTime() + ".png"));
	}
	
	//Here is a catch for every run the screenshot file will have the same name Login.png hence it will override the previous file ln 34
	//But for analysis purpose we usually store all the screenshots so how to address this ?
	//we will create one more utility to get the current date & time stamp which we will append in the filename
	
	public static String getCurrentDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); //there are multiple formats which can be provided as per your choice all the eligible formats are present in the SimpleDateFormat class declaration
		
		Date currentDate = new Date(); //To capture the current date //import the Date class from java.util.Date
		
		return dateFormat.format(currentDate); //To convert the current date into the dateformat specified
		
	}


}

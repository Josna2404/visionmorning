package com.Coverfox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Listeners;


public class Utility {

	// readData from excel
	public static String readDataFromExcel(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream myfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\Testing.xlsx");
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet(sheetName);
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("reading data from excel", true);
		return data;

	}

	// screenshot
	public static void takeScreenshot(WebDriver driver, String screenShotName) throws IOException {
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File dest = new File(System.getProperty("user.dir") + "\\Screenshot\\" + screenShotName + ".png");
//		FileHandler.copy(src, dest);
//		Reporter.log("taking screenshot, saved at" + dest, true);
		
		   String screenshotDirPath = System.getProperty("user.dir") + "\\Screenshot\\";
		    File screenshotDir = new File(screenshotDirPath);

		    // Check and create the directory if it doesn't exist
		    if (!screenshotDir.exists()) {
		        screenshotDir.mkdirs();
		    }

		    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    File dest = new File(screenshotDirPath + screenShotName + ".png");
		    FileHandler.copy(src, dest);
		    Reporter.log("Taking screenshot, saved at: " + dest, true);

	}

	// scroll into view
	public static void scroolIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("scrolling into view", true);
	}

	
	
	public static String readDataFromPropertiesFile(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream myFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\testdata.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("reading " + key + " from properties file", true);

		return value;
	}
	

}


package com.Coverfox_POM;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CoverFoxPOMtestUsingExel {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		FileInputStream myfile = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\testing2.xlsx");
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet("Sheet5");
		String age = mySheet.getRow(0).getCell(0).getStringCellValue();
		String pincode = mySheet.getRow(0).getCell(1).getStringCellValue();
		String mobilenumber = mySheet.getRow(0).getCell(2).getStringCellValue();

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		// create object of homepage
		CoverFoxHomepage home = new CoverFoxHomepage(driver);
		home.ClickonGender();

		// create an object of health plan page
		CoverFoxHealthPlanPage healthplan = new CoverFoxHealthPlanPage(driver);
		healthplan.ClickOnnextButtonHealthPlanPage();

		// create an object member details page
		CoverFoxMemberDetailsPage memberdetails = new CoverFoxMemberDetailsPage(driver);
		memberdetails.handlesAgeDropDown(age);
		memberdetails.ClickOnnextButtonOfMemberDetailsPage();

		// create an object address details page
		CoverFoxAddressDetailsPage addressdetails = new CoverFoxAddressDetailsPage(driver);
		addressdetails.pincode(pincode);
		addressdetails.MobileNumber(mobilenumber);
		addressdetails.clickOncontinueButton();
		Thread.sleep(2000);

		// create an object result page
		CoveFoxResultPage resultpage = new CoveFoxResultPage(driver);
		resultpage.validateplans();

	}

}

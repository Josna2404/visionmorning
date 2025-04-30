package com.Coverfox_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CoverFox_utility.Utility;
import com.Coverfox_Base.Base;
import com.Coverfox_POM.CoveFoxResultPage;
import com.Coverfox_POM.CoverFoxAddressDetailsPage;
import com.Coverfox_POM.CoverFoxHealthPlanPage;
import com.Coverfox_POM.CoverFoxHomepage;
import com.Coverfox_POM.CoverFoxMemberDetailsPage;

import io.opentelemetry.api.logs.Logger;


public class CoverFoxUsingTestNG extends Base{

	WebDriver driver;
	FileInputStream myfile;
	Sheet mysheet;
	CoverFoxHomepage coverFoxHomepage;
	CoverFoxAddressDetailsPage coverFoxAddressDetailsPage;
	CoverFoxHealthPlanPage coverFoxHealthPlanPage;
	CoverFoxMemberDetailsPage coverFoxMemberDetailsPage;
	CoveFoxResultPage coveFoxResultPage;

	@BeforeClass
	public void launchbrowser() throws EncryptedDocumentException, IOException {
		
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.coverfox.com/");
//		Reporter.log("Opening Browser,launching url",true);
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

//		// read test data
//		myfile = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\testing2.xlsx");
//		mysheet = WorkbookFactory.create(myfile).getSheet("Sheet5");
//		logger= Logger.getLogger("My_New_log");
//		  PropertyConfigurator.configure("log4j.properties");
//		  logger.info("Hello");

		coverFoxHomepage = new CoverFoxHomepage(driver);
		coverFoxMemberDetailsPage = new CoverFoxMemberDetailsPage(driver);
		coverFoxAddressDetailsPage = new CoverFoxAddressDetailsPage(driver);
		coveFoxResultPage = new CoveFoxResultPage(driver);
		coverFoxHealthPlanPage = new CoverFoxHealthPlanPage(driver);

	}

	@BeforeMethod
	public void coverfoxpreconditions() throws InterruptedException {
		coverFoxHomepage.ClickonGender();
		coverFoxHealthPlanPage.ClickOnnextButtonHealthPlanPage();
		coverFoxMemberDetailsPage.handlesAgeDropDown(mysheet.getRow(0).getCell(0).getStringCellValue());
		coverFoxMemberDetailsPage.ClickOnnextButtonOfMemberDetailsPage();
		coverFoxAddressDetailsPage.pincode(mysheet.getRow(0).getCell(1).getStringCellValue());
		coverFoxAddressDetailsPage.MobileNumber(mysheet.getRow(0).getCell(2).getStringCellValue());
		coverFoxAddressDetailsPage.clickOncontinueButton();
		Thread.sleep(4000);
	}

	@Test
	public void ValidateCoverfoxplan() throws IOException {
		int planNumberFromText = coveFoxResultPage.getplanNumberfromText();
		int PlanNumberFromCards = coveFoxResultPage.getplanNumberFromPlancards();

		Assert.assertEquals(planNumberFromText, PlanNumberFromCards, "Test case failed,Number are not matching");
		Reporter.log("Plan Number are Matching TC is Passed", true);
		
		Utility.takeScreenshot(driver, "CoverFoxTest");


	}

	@AfterClass
	public void closebrowser() throws InterruptedException {
		Reporter.log("Closing the Browser",true);
		Thread.sleep(2000);
		driver.quit();
	}

}

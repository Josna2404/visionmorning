package com.Coverfox_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

import com.Coverfox_Base.Base;
import com.Coverfox_POM.CoveFoxResultPage;
import com.Coverfox_POM.CoverFoxAddressDetailsPage;
import com.Coverfox_POM.CoverFoxHealthPlanPage;
import com.Coverfox_POM.CoverFoxHomepage;
import com.Coverfox_POM.CoverFoxMemberDetailsPage;
import com.Coverfox_Utility.Utility;

public class CoverFoxUsingTestNG extends Base {
	public static Logger logger;
//	WebDriver driver;
//	FileInputStream myfile;
//	Sheet mysheet;
	CoverFoxHomepage coverFoxHomepage;
	CoverFoxAddressDetailsPage coverFoxAddressDetailsPage;
	CoverFoxHealthPlanPage coverFoxHealthPlanPage;
	CoverFoxMemberDetailsPage coverFoxMemberDetailsPage;
	CoveFoxResultPage coveFoxResultPage;

	@BeforeClass
	public void launchbrowser() throws EncryptedDocumentException, IOException, InterruptedException {

		logger = Logger.getLogger("morning24_Coverfox");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Welcome to coverfox testing");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		Reporter.log("Opening Browser,launching url", true);
		logger.info("opening browser,laiunching url");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		// read test data
//     	myfile = new FileInputStream("C:\\Users\\shind\\OneDrive\\Desktop\\Testing.xlsx");
//		mysheet = WorkbookFactory.create(myfile).getSheet("Sheet1");
//		openBrowser();
		logger.warn("Launching browser");
		coverFoxHomepage = new CoverFoxHomepage(driver);
		coverFoxMemberDetailsPage = new CoverFoxMemberDetailsPage(driver);
		coverFoxAddressDetailsPage = new CoverFoxAddressDetailsPage(driver);
		coveFoxResultPage = new CoveFoxResultPage(driver);
		coverFoxHealthPlanPage = new CoverFoxHealthPlanPage(driver);

	}

	@BeforeMethod
	public void coverfoxpreconditions() throws InterruptedException, EncryptedDocumentException, IOException {
		coverFoxHomepage.clickOnGender();
		logger.info("Clicking on gender");
		coverFoxHealthPlanPage.ClickOnnextButtonHealthPlanPage();
		logger.info("Click on next button");
		coverFoxMemberDetailsPage.handlesAgeDropDown(Utility.readDataFromExcel("Sheet1", 0, 0));
		logger.info("handles age drop down");
		coverFoxMemberDetailsPage.ClickOnnextButtonOfMemberDetailsPage();
		logger.info("Click on next button in membersdetails page");
		coverFoxAddressDetailsPage.pincode(Utility.readDataFromExcel("Sheet1", 0, 1));
		logger.info("enter pincode");
		coverFoxAddressDetailsPage.MobileNumber(Utility.readDataFromExcel("Sheet1", 0, 2));
		logger.info("enter mobile no");
		coverFoxAddressDetailsPage.clickOncontinueButton();
		logger.info("click on nextbutton in address details page");
		Thread.sleep(4000);
	}

	@Test
	public void ValidateCoverfoxplan() throws IOException {
		int planNumberFromText = coveFoxResultPage.getplanNumberfromText();
		int PlanNumberFromCards = coveFoxResultPage.getplanNumberFromPlancards();

		Assert.assertEquals(planNumberFromText, PlanNumberFromCards, "Test case failed,Number are not matching");
		Reporter.log("Plan Number are Matching TC is Passed", true);
		logger.info("plan number are matching TC is passed ");

		Utility.takeScreenshot(driver, "CoverFoxTest");

	}

	@AfterClass
	public void closebrowser() throws InterruptedException {
		Reporter.log("Closing the Browser", true);
		logger.info("Closing the browser");
		Thread.sleep(2000);
		driver.quit();
	}

	
}

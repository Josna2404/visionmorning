package com.Coverfox_Base;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;


public class Base

{
	protected static WebDriver driver;

	public void openBrowser() throws EncryptedDocumentException, IOException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
//		driver.get(Utility.readDataFromPropertiesFile("url"));
		driver.get("https://www.coverfox.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Reporter.log("launching Browser", true);
	}

	public void closeBrowserWindow() {
		Reporter.log("closing Browser", true);
		driver.quit();
	}
}

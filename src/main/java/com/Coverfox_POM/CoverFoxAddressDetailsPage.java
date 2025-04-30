package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {

	// 1.Variables--->WebElement

	@FindBy(xpath = "//input[@class='mp-input-text']")
	private WebElement pincodeFailed;

	@FindBy(id = "want-expert")
	private WebElement MobileNumberFeild;

	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement continuButton;

	// 2.Constructor

	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3.Methods

	public void pincode(String pincode) {
		Reporter.log("enter pincode on address details page", true);
		pincodeFailed.sendKeys(pincode);
	}

	public void MobileNumber(String MobileNumber) {
		Reporter.log("click on mobile number on address details page ", true);
		MobileNumberFeild.sendKeys(MobileNumber);
	}

	public void clickOncontinueButton() {
		Reporter.log("clicking on nextbutton on address details page ", true);

		continuButton.click();
	}
}

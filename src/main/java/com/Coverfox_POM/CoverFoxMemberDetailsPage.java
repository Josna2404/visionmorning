package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage {

	// 1.Variables-->WebElement

	@FindBy(id = "Age-You")
	private WebElement ageDropDown;
	@FindBy(xpath = "//div[@class='next-btn']")
	private WebElement nextButton;

	// 2.Constructor

	public CoverFoxMemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3.Methods

	public void handlesAgeDropDown(String Age) {
		Reporter.log("handling age dropdown ", true);
		Select selectAge = new Select(ageDropDown);
		selectAge.selectByValue(Age + "y");

	}

	public void ClickOnnextButtonOfMemberDetailsPage() {
		Reporter.log("clicking on next button of memberdetailspage", true);
		nextButton.click();
	}

}

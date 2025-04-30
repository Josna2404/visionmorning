package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {

	// 1.Variable--->WebElement

	@FindBy(xpath = "//div[@class='next-btn']")
	private WebElement nextButton;

	// 2.Constructor

	public CoverFoxHealthPlanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3.Methods

	public void ClickOnnextButtonHealthPlanPage() {
		Reporter.log("clicking on next of health plan page ", true);
		nextButton.click();
	}

}

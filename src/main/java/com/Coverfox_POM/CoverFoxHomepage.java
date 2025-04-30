package com.Coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomepage {

	// 1.variables--->webElement
	// driver.findElement(By.xpath)
	// private a=10;

	@FindBy(xpath = "//div[text()='Female']")
	private WebElement gender;

	// 2.Constructor

	public CoverFoxHomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3.Methods
	public void ClickonGender() {
		Reporter.log("clicking on gender", true);
		gender.click();
	}

}

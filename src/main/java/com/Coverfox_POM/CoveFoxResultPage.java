package com.Coverfox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoveFoxResultPage {

	// 1.Variables--->WebElement

	@FindBy(xpath = "//div[contains(text(),'matching ')]")
	private WebElement planResult;

	@FindBy(xpath = "//div[@class='plan-card-container']")
	private List<WebElement> planCards;

	// 2.Constructor

	public CoveFoxResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3.Methods

	public void validateplans() throws InterruptedException {
		String result = planResult.getText();
		String[] Result1 = result.split(" ");
		// 48 matching health insurance plans
		int resultInNumber = Integer.parseInt(Result1[0]);
		Thread.sleep(2000);
		int TotalPlans = planCards.size();
		if (TotalPlans == resultInNumber) {
			System.out.println("TC is passed ");
		} else {
			System.out.println("TC is Falied ");
		}

	}

	public int getplanNumberfromText() {
		Reporter.log("getting planNumber from Text", true);
		String result = planResult.getText();
		String[] Result1 = result.split(" ");
		// 48 matching health insurance plans
		int planNumber = Integer.parseInt(Result1[0]);
		return planNumber;
	}

	public int getplanNumberFromPlancards() {
		int planNumberfromCards = planCards.size();
		return planNumberfromCards;
	}

}

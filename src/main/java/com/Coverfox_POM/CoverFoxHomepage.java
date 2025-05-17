package com.Coverfox_POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomepage 
{
  	
  	//1. variables-->WebElements                    	
  	@FindBy(xpath = "//div[text()='Female']") private WebElement gender;
  	
  	
  	//2. constructor
  	public CoverFoxHomepage(WebDriver driver)
  	{
                 	PageFactory.initElements(driver, this);
  	}
                 	
  	//3. methods
  	public void clickOnGender()
  	{
                 	Reporter.log("clicking on gender", true);
                 	gender.click();
                 	
                 	
  	}
}
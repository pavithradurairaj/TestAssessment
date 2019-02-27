package com.kaplan.codtest.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.kaplan.codetest.base.Baseclass;

public class FlightbookingPage extends Baseclass {

	WebElement date1, farefinalisation;
	
	@FindBy(xpath ="//input[@value='oneway']")
	WebElement selectingTrip;
	
	@FindBy(xpath ="//input[@id='LandingPageAirSearchForm_originationAirportCode']")
	WebElement Depart;


	@FindBy(xpath ="//input[@id='LandingPageAirSearchForm_destinationAirportCode']")
	WebElement Arrive;
	
	
	@FindBy(xpath ="//div[@class='input input_icon input_left input_secondary']/div")
	WebElement departdateselection;

	@FindBy(xpath ="//input[@id='LandingPageAirSearchForm_adultPassengersCount']")
	WebElement adultcount;
	
	
	@FindBy(xpath ="//button[@aria-label='Search button. In the event of an error, focus will move to the error message.']")
	WebElement search;
	
	@FindBy(xpath ="//button[@id='air-booking-product-1']")
	WebElement continueButton;
	
	@FindBy(xpath ="//div[@id='swa-content']/div/div[2]/div/div/section/div[2]/div/div[3]/div[3]/button")
	WebElement continueButton2;

	
	
	public FlightbookingPage(WebDriver driver)
	{
	 this.driver = driver; 
	 PageFactory.initElements(driver, this);
	}

	public void searching(String departuredate){
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,600)");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectingTrip.click();
        Assert.assertTrue(selectingTrip.isSelected(),"The radio button of oneway is not selected");
		Depart.sendKeys("LAX");
		Arrive.sendKeys("LGA");
		departdateselection.click();
		date1 = driver.findElement(By.xpath("//button[contains(@id, '"+departuredate+"')]"));
        date1.click();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        search.click(); 
        
	}
	
	
   public String validatePageTitle(){
		
		return driver.getTitle();
		
	}

	public void booking(){
	
		 WebDriverWait wait = new WebDriverWait(driver,60);
		 WebElement element = wait.until(
		                        ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='air-booking-fares-0-1']/div[1]/button")));
		    element.click();
		    
	  
		continueButton.click();
		continueButton2.click();
		

	}
}

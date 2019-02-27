package com.kaplan.codtest.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.kaplan.codetest.base.*;

public class EducationLoanPage extends Baseclass {

	@FindBy(xpath ="//a[@href='/personal-loan.php']/div")
	WebElement personalLoan;


	@FindBy(xpath ="//div[@class='collapse navbar-collapse js-navbar-collapse']/ul/li[6]")
	WebElement educationLoantab;

	@FindBy(xpath ="//a[text()='Education Loan']")
	WebElement educationLoanLink;

	@FindBy(xpath ="//input[@name='Name']")
	WebElement nameField;
	
	@FindBy(xpath ="//input[@name='Email']")
	WebElement emailField;

	@FindBy(xpath ="//input[@name='Course_Name']")
	WebElement courseNameField;
	
	@FindBy(xpath ="//input[@name='Coborrower_Income']")
	WebElement coborrowField;
	
	
	@FindBy(xpath ="//input[@name='Loan_Amount']")
	WebElement loanAmountField;
	
	@FindBy(xpath ="//input[@name='Phone']")
	WebElement phoneField;
	
	@FindBy(xpath ="//input[@name='accept'][@class='custom_checkbox']")
	WebElement agreeCheckbox;
	
	@FindBy(xpath ="//button[text()='Get Quote']")
	WebElement Submit;
	
	@FindBy(xpath ="//div[@id='txt']/div/b")
	WebElement confirmationMessage;

	


	JavascriptExecutor js = (JavascriptExecutor) driver; 
	
	public EducationLoanPage(WebDriver driver)
	{
	 this.driver = driver; 
	 PageFactory.initElements(driver, this);
	}


	public String validatePageTitle(){
		
		return driver.getTitle();
		
	}


	public void selectingEducationLoan() {
	
		js.executeScript("window.scrollBy(0,900)");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personalLoan.click();
		educationLoantab.click();
		educationLoanLink.click();
		
	}
	
	public void loanApplicationFilling(String name, String country, String courses, String coborrowers_income, String email, String city, String courseName,String loanAmount, String mobile){ 
		
		js.executeScript("window.scrollBy(0,300)");
		nameField.sendKeys(name);
		Select sc = new Select(driver.findElement(By.name("Country")));
		sc.selectByVisibleText(country);
		
		Select sc1 = new Select(driver.findElement(By.name("Course")));
		sc1.selectByVisibleText(courses);
		
		
		emailField.sendKeys(email);
		
		Select sc2 = new Select(driver.findElement(By.name("City")));
		sc2.selectByVisibleText(city);
		
		courseNameField.sendKeys(courseName);
		
		coborrowField.sendKeys(coborrowers_income);
		loanAmountField.sendKeys(loanAmount);
		
		phoneField.sendKeys(mobile);
		
		Select sc3 = new Select(driver.findElement(By.name("Employment_Status")));
		sc3.selectByIndex(1);
		
		agreeCheckbox.click();
		
		Submit.click();
	}

	public String confirmationText()
	{
		return confirmationMessage.getText();
	}
}

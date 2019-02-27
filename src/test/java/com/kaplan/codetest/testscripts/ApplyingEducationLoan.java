package com.kaplan.codetest.testscripts;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kaplan.codetest.base.Baseclass;
import com.kaplan.codtest.pages.EducationLoanPage;



public class ApplyingEducationLoan extends Baseclass{


		EducationLoanPage educationloan;

		
		
		@DataProvider
		public Object[][] getTestData(){
			Object data[][] = getTestData("EducationLoan");
			return data;
		}

		
		@Test(dataProvider="getTestData")
		public void ApplyingLoan(String name, String country, String courses, String coborrowers_income, 
				String email, String city, String courseName,String loanAmount, String mobile){
			
		driver.get("https://www.deal4loans.com/");
		educationloan = new EducationLoanPage(driver);
		
		String title = educationloan.validatePageTitle();
		Assert.assertEquals(title, "Apply and Compare online Loans in India");
		
		educationloan.selectingEducationLoan();
		
		educationloan.loanApplicationFilling(name, country, courses, coborrowers_income, 
				email, city, courseName, loanAmount, mobile);
		
		String ConfirmationMessage = educationloan.confirmationText();
		if(ConfirmationMessage.contains("Thanks for applying Education Loan")){
			
			System.out.println("Education Loan is successfully Applied");
			
		}
	}
	}




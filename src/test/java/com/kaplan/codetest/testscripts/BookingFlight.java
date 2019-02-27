package com.kaplan.codetest.testscripts;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kaplan.codetest.base.Baseclass;
import com.kaplan.codtest.pages.EducationLoanPage;
import com.kaplan.codtest.pages.FlightbookingPage;



public class BookingFlight extends Baseclass{


		FlightbookingPage flight;
		
		@Test
		@Parameters({"departuredate"})
		public void bookingOfFlight(String departdate) throws InterruptedException{
			
			driver.get("https://www.southwest.com");
			flight = new FlightbookingPage(driver);
			
			String homePageTitle = flight.validatePageTitle();
			Assert.assertEquals(homePageTitle, "Southwest Airlines | Book Flights & More - Wanna Get Away?");
			
			flight.searching(departdate);
			flight.booking();
			
			Thread.sleep(2000);
			String paymentsPageTitle = flight.validatePageTitle();
			Assert.assertEquals(paymentsPageTitle, "Southwest Airlines - Passenger and Payment Information");
			System.out.println("Successfully reached Payments Page!:)");
			
		}
		
		
		}
		
		





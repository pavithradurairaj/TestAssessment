package com.kaplan.codetest.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kaplan.codetest.base.Baseclass;
import com.kaplan.codtest.pages.MailLoginPage;




public class CheckingMail extends Baseclass{


MailLoginPage mailloginpage;

	

@DataProvider
public Object[][] getTestData(){
	Object data[][] = getTestData("MailChecking");
	return data;
}


@Test(dataProvider="getTestData")
public void MailChecking(String Email, String Pwd, String Sub_string ) throws InterruptedException{
	driver.get("https://mail.google.com");
	mailloginpage = new MailLoginPage(driver);
	Thread.sleep(1000);
	String title = mailloginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "Gmail");
	mailloginpage.Login(Email, Pwd);
	int noOfmails = mailloginpage.checkingSubjectandEmailbody(Sub_string);
	System.out.println("Totally"+" "+noOfmails+" "+"mails having subject and mailbody as"+" "+Sub_string);

}
}


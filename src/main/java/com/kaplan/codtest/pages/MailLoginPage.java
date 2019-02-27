package com.kaplan.codtest.pages;

import java.util.List;

import com.kaplan.codetest.base.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MailLoginPage extends Baseclass {
	
@FindBy(xpath ="//a[text()='Sign In']")
WebElement signin;


@FindBy(xpath ="//input[@type='email']")
WebElement emailField;

@FindBy(xpath ="//span[text()='Next']")
WebElement clickNext;

@FindBy(xpath ="//input[@type='password']")
WebElement passwordField;
//@FindBy(xpath )
//WebElement mailbody;


public void signIn(){
	signin.click();
}

public MailLoginPage(WebDriver driver)
{
 this.driver = driver; 
 PageFactory.initElements(driver, this);
}


public String validateLoginPageTitle(){
	
	return driver.getTitle();
	
}



public void Login(String email, String pwd) throws InterruptedException{
	emailField.sendKeys(email);
	clickNext.click();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(passwordField));
	passwordField.sendKeys(pwd);
	clickNext.click();
	Thread.sleep(3000);
}

public int checkingSubjectandEmailbody(String sub_string) throws InterruptedException
{
	List<WebElement> a = driver.findElements(By.xpath("//div[@class= 'y6']/span/span"));


	int count = 0;
	System.out.println("No of mails in the inbox"+" "+a.size());
	            for(int i=0;i<a.size();i++){
	                System.out.println("Subject of mail no:"+" "+(i+1)+" "+a.get(i).getText());
	                
	                if(a.get(i).getText().equals(sub_string)){  
	                    a.get(i).click();
	                    Thread.sleep(1000);
	                    if((driver.findElement(By.xpath("//div[@class='a3s aXjCH ']/div"))).getText().equals(sub_string)){
	                    count++;
	                    driver.navigate().back();
	                    } 
	                }
	            }	
	            return count;
}
	
	
}

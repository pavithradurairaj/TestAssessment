package com.kaplan.codetest.testscripts;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kaplan.codetest.base.Baseclass;



public class CheckingBrokenLinks extends Baseclass{
	
	List<WebElement> activelinks = new ArrayList<WebElement>();
	static int count =0;
     
	@Test
	@Parameters({"Url"})
	
	public void findingBrokenLinks(String Url){
		driver.get(Url);
		List<WebElement> list = driver.findElements(By.tagName("a"));
		int activelinkscount = findingoutActiveLinks(list);
		System.out.println("No of Active Links in this page" + activelinkscount);
		count = countofBrokenLinks();
		if(count==0)
		 System.out.println("There is no Broken Links in this Page");
	}
	
	
	public int findingoutActiveLinks(List<WebElement> list){
    
     System.out.println("No of Links in this page" + list.size());
         for(int i=0;i<list.size();i++){
          if(list.get(i).getAttribute("href")!=null && (!list.get(i).getAttribute("href").contains("javascript:void(0)"))){
				 activelinks.add(list.get(i));
				 System.out.println("Link"+" "+list.get(i).getAttribute("href"));
				 }
         }
 		
         return activelinks.size();

	}  
         
	
	
	public int countofBrokenLinks(){
		
		 for(int j=0;j<activelinks.size();j++){
			 
			 WebElement ele= activelinks.get(j);
             String url=ele.getAttribute("href");
			int responsecode = getResponseCode(url);
			
			if(responsecode==200)
				System.out.println("Link"+" "+url+" "+"Link present");
			
			else
				System.out.println("Link"+" "+url+" "+"broken Link");
			    count++;
		 
		
          }
      return count;   
     }
    
	
	 public  int getResponseCode(String link) {
		        URL url;
		        HttpURLConnection con = null;
		        Integer responsecode = 0;
		        try {
		            url = new URL(link);
		            con = (HttpURLConnection) url.openConnection();
		            responsecode = con.getResponseCode();
		        } catch (Exception e) {
		         
		        } finally {
		            if (null != con)
		                con.disconnect();
		        }
		        return responsecode;
		    }
	 
	}


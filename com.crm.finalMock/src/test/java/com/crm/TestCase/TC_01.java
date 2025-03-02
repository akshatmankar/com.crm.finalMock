package com.crm.TestCase;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DWSBaseClass.DWS_BaseClass;
@Listeners (com.crm.listeners.listenersDws.class)
public class TC_01 extends DWS_BaseClass{
   @Test
   public void newAccount() throws InterruptedException {
	   String parent_handle = driver.getWindowHandle();
	   System.out.println(parent_handle);
	   
	   driver.findElement(By.xpath("//a[@target='_blank']")).click();	
	   
	   Set<String> child = driver.getWindowHandles();
		 System.out.println(child);
		 child.remove(parent_handle);
		 for (String str : child) {
			 driver.switchTo().window(str);
		 }
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[text ()='Create new account']")).click();
		
		 Set<String> child1 = driver.getWindowHandles();
		 System.out.println(child1);
		 child1.remove(child);
		 for (String str : child1) {
			 driver.switchTo().window(str);
		 }
		 driver.findElement(By.name("firstname")).sendKeys("Akshat");
		 driver.findElement(By.name("lastname")).sendKeys("Mankar");
		 driver.findElement(By.id("day")).sendKeys("19");   
	     driver.findElement(By.id("month")).sendKeys("mar");
	       
	     driver.findElement(By.id("year")).sendKeys("2003");
	        
	     driver.findElement(By.cssSelector("input[value='2']")).click();
	     
	     driver.findElement(By.name("reg_email__")).sendKeys("9823633804");
	        
	     driver.findElement(By.name("reg_passwd__")).sendKeys("aksh@123");
	    
	      // driver.findElement(By.name("websubmit")).click();
	     
	     driver.switchTo().window(parent_handle);
	     Thread.sleep(2000);
	     //driver.close();
		 
	}
	
}

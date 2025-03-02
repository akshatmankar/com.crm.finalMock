package com.crm.TestCase;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.FileUtilityDWS.ReadFromExcelFileVtigerM;
import com.crm.Vtiger.HomePageVtiger;
import com.crm.javautility.GenerateRandomNum;
import DWSBaseClass.VtigerBaseClass;

@Listeners (com.crm.listeners.listenersVtiger.class)

public class TC_07 extends VtigerBaseClass {
	 @Test
	  public void testCase_7() throws InterruptedException, EncryptedDocumentException, IOException {
		 HomePageVtiger  home= new HomePageVtiger(driver);
		   assertTrue(home.home().isDisplayed(),"IAm not in vitger home page");
		   Reporter.log("Iam in Vtiger Home Page...!");	  
		   driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			Thread.sleep(1000);
			WebElement expected= driver.findElement(By.name("accountname"));		
			 String org_Name = ReadFromExcelFileVtigerM.readExecl("Organization", 0, 0);
			   int dynamicNumber= GenerateRandomNum.random();
			   String expected_Org = org_Name+dynamicNumber;
			 expected.sendKeys(org_Name+dynamicNumber);		
			WebElement small = driver.findElement(By.name("industry"));
			small.click();
			Select sel= new Select(small);
			sel.selectByValue("Engineering");
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			Thread.sleep(1000);		
			WebElement actual=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			   String actual_Org=actual.getText();
			   System.out.println(actual_Org);
			  //assertTrue(actual_Org.contains(expected_Org));
			   Thread.sleep(4000);		
	 }
}

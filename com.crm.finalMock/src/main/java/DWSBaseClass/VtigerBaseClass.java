package DWSBaseClass;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtilityDWS.ReadFromPropertiesVtiger;

import com.crm.Vtiger.HomePageVtiger;
import com.crm.Vtiger.LoginVtiger;


public class VtigerBaseClass {
	public static WebDriver driver = null;

	@BeforeClass
	public void preCondition() throws IOException
	{
		String browser = ReadFromPropertiesVtiger.getData("browser");
		String url =ReadFromPropertiesVtiger.getData("url");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		String actual = "http://localhost:8888/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		
		 String expected =driver.getCurrentUrl();
  	   if(actual.equals(expected))
  	   {
  		   System.out.println("i am in Vtiger page");
  		   
  	   }
  	   else 
  	   {
  		   System.out.println("i am not in Vtiger page");
  		   
  	   }
	}
	@BeforeMethod

	public void login() throws IOException{
		String username = ReadFromPropertiesVtiger.getData("username");
		String password = ReadFromPropertiesVtiger.getData("password");
		LoginVtiger log = new LoginVtiger(driver);
		log.userName(username);
		log.password(password);
		log.submmit();
	}
	@AfterMethod
	public void logOut()
	{
		HomePageVtiger hp = new HomePageVtiger(driver);
		hp.profile();
		hp.signOut();

	}
	@AfterClass
	public void postCopndition()
	{
		driver.quit();
	}
}

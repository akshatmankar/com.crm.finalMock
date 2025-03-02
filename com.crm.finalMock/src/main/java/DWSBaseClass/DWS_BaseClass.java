package DWSBaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtilityDWS.ReadFromPropertyFileDws;

import com.crm.DWS.POM.HomePage;
import com.crm.DWS.POM.Login;



public class DWS_BaseClass {
	public static WebDriver driver = null;

	@BeforeClass
	public void preCondition() throws IOException
	{
		String browser = ReadFromPropertyFileDws.getData("browser");
		String url = ReadFromPropertyFileDws.getData("url");
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
		String actual = "https://demowebshop.tricentis.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		
		 String expected =driver.getCurrentUrl();
  	   if(actual.equals(expected))
  	   {
  		   System.out.println("i am in dws page");
  		   
  	   }
  	   else 
  	   {
  		   System.out.println("i am not in dws page");
  		   
  	   }
	}
	
	@BeforeMethod
	public void login() throws IOException{
		String username = ReadFromPropertyFileDws.getData("username");
		String password = ReadFromPropertyFileDws.getData("password");

		 driver.findElement(By.className("ico-login")).click();
		 Login log = new Login(driver);
		    log.login();
			log.userName(username);
			log.password(password);
			log.submmit();
		 System.out.println("Login is successfull");
	 }
	 @AfterMethod
	 public void logOut() {
		 HomePage hp = new HomePage(driver);
		 hp.signOut();
		 System.out.println("LogOut is successfull");
	 }
	 @AfterClass
	 public void postCondition() {
		 driver.quit();
	 }
	

}

	
		
		
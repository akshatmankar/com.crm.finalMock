package com.crm.DWS.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="ico-login")
	private WebElement login;
	
	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id="Password")
	private WebElement pass;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement login_Button;
	
	public void login() {
		login.click();
	}
	public void userName(String data) {
		email.sendKeys(data);
	}
	
	public void password(String data) {
		pass.sendKeys(data);
	}
	
	public void submmit() {
		login_Button.click();
	}
}

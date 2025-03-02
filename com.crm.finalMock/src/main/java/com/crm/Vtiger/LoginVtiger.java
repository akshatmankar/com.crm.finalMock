package com.crm.Vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginVtiger {
	public LoginVtiger(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement email;
	
	@FindBy(name="user_password")
	private WebElement pass;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	
	public void userName(String data) {
		email.sendKeys(data);
	}
	
	public void password(String data) {
		pass.sendKeys(data);
	}
	
	public void submmit() {
		loginButton.click();
	}

}

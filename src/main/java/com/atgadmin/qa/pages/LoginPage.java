package com.atgadmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atgadmin.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[1]/input")
	WebElement username;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[2]/input")
	WebElement password;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/input[3]")
	WebElement loginBtn;
	//Initialising the Page Objects:
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void  login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
	}
}

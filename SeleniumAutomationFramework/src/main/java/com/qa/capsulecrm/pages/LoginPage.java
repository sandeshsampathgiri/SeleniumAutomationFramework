package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.capsulecrm.base.BaseClass;

public class LoginPage extends BaseClass {
	
	//Page Factory:
	@FindBy(name="login:usernameDecorate:username")
	WebElement usernameTxtBx;
	
	@FindBy(name="login:passwordDecorate:password")
	WebElement passwordTxtBx;
	
	@FindBy(name="login:login")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@class='logo']")
	WebElement capsuleCRMLogo;
	
	//Initialize the above elements using PageFactory inside the constructor:
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatePageTitle()
	{
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean verifyLogoDisplay()
	{
		boolean logoDisplayValue = capsuleCRMLogo.isDisplayed();
		return logoDisplayValue;
	}
	
	public HomePage doLogin()
	{
		usernameTxtBx.sendKeys(prop.getProperty("username"));
		passwordTxtBx.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		
		return new HomePage();
	}
	
}

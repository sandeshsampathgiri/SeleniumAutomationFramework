package com.qa.capsulecrm.pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.capsulecrm.base.BaseClass;

public class LogoutPage extends BaseClass{
	
	public LogoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLogoutPageTitle()
	{
		String logoutPageTitle = driver.getTitle();
		return logoutPageTitle;
	}

}

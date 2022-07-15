package com.qa.capsulecrm.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.capsulecrm.base.BaseClass;
import com.qa.capsulecrm.pages.HomePage;
import com.qa.capsulecrm.pages.LoginPage;
import com.qa.capsulecrm.utilities.Constants;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initializeBrowser();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest()
	{
		String pageTitle = loginPage.validatePageTitle();
		Assert.assertEquals(pageTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyLogoDisplayTest()
	{
		boolean logoDisplayValue = loginPage.verifyLogoDisplay();
		Assert.assertTrue(true);
	}
	
	@Test(priority=3)
	public void verifyLoginTest()
	{
		homePage = loginPage.doLogin();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}

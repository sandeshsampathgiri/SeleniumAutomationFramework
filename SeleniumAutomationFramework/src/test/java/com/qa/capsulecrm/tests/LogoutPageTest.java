package com.qa.capsulecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.capsulecrm.base.BaseClass;
import com.qa.capsulecrm.pages.HomePage;
import com.qa.capsulecrm.pages.LoginPage;
import com.qa.capsulecrm.pages.LogoutPage;
import com.qa.capsulecrm.utilities.Constants;

public class LogoutPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	LogoutPage logoutPage;

	public LogoutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin();
		logoutPage = homePage.verifyLogout();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void verifyLogoutTest() {
		String logoutPageTitle = logoutPage.verifyLogoutPageTitle();
		Assert.assertEquals(logoutPageTitle, Constants.LOGOUT_PAGE_TITLE, "Log out page title is not matching");

	}
}

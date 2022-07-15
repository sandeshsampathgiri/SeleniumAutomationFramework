package com.qa.capsulecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.capsulecrm.base.BaseClass;
import com.qa.capsulecrm.pages.HomePage;
import com.qa.capsulecrm.pages.LoginPage;

public class HomePageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initializeBrowser();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void test() {
		boolean isHeaderTxtDisplayed = homePage.verifyHeaderTextDisplay();
		Assert.assertTrue(isHeaderTxtDisplayed);
	}

}

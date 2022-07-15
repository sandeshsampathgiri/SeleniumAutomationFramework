package com.qa.capsulecrm.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.capsulecrm.base.BaseClass;
import com.qa.capsulecrm.pages.AddOrganizationPage;
import com.qa.capsulecrm.pages.HomePage;
import com.qa.capsulecrm.pages.LoginPage;
import com.qa.capsulecrm.utilities.Utilities;

public class AddOrganizationTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	AddOrganizationPage addOrganizationPage;
	
	public AddOrganizationTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		BaseClass.initializeBrowser();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin();
		addOrganizationPage = homePage.navigateToCreateOrganisationPage();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@Test(dataProvider="getTestData")
	public void createOrganizationTest(String name, String tagName)
	{
		addOrganizationPage.createOrganization(name, tagName);
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = Utilities.getTestData("Organization");
		return data;
	}

}

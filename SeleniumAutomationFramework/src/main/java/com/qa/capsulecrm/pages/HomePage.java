package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.capsulecrm.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//div[@class='dashboard-entries__empty-state']/h1")
	WebElement headerTxt;
	
	@FindBy(xpath="//span[@class='nav-bar-account-name']")
	WebElement logoutDpDwn;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logoutLnk;
	
	@FindBy(xpath="//div[@data-pendo-guide='quick-menu-toggle']")
	WebElement addBtn;
	
	@FindBy(xpath="(//div[@class='select-box__options bottom-right']/a)[2]")
	WebElement orgBtn;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHeaderTextDisplay()
	{
		boolean isHeaderDisplayed = headerTxt.isDisplayed();
		return isHeaderDisplayed;
	}
	
	public LogoutPage verifyLogout()
	{
		logoutDpDwn.click();
		logoutLnk.click();
		return new LogoutPage();
		
	}
	
	public AddOrganizationPage navigateToCreateOrganisationPage()
	{
		addBtn.click();
		orgBtn.click();
		return new AddOrganizationPage();
	}

}

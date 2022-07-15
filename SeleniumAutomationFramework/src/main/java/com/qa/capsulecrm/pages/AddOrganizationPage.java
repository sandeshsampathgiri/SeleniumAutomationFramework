package com.qa.capsulecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.capsulecrm.base.BaseClass;

public class AddOrganizationPage extends BaseClass {

	@FindBy(xpath = "(//input[@autocomplete='capsule'])[2]")
	WebElement organizationNameTxtBx;
	
	@FindBy(xpath="(//input[@autocomplete='capsule'])[3]")
	WebElement tagTxtBx;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	public AddOrganizationPage() {
		PageFactory.initElements(driver, this);
	}

	public OrganizationDetailsPage createOrganization(String orgName, String tagName)
	{
		organizationNameTxtBx.sendKeys(orgName);
		tagTxtBx.sendKeys(tagName);
		saveBtn.click();
		return new OrganizationDetailsPage();
	}
}

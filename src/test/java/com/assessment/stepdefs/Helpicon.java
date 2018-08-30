package com.assessment.stepdefs;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assessment.pageobjects.BasePage;
import com.assessment.pageobjects.HelpPageObject;
import com.assessment.pageobjects.SlzHomePg;
import com.assessment.pageobjects.SlzLoginPg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Helpicon {
	
	private static final String String = null;
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	HelpPageObject TeacherHP = PageFactory.initElements(this.driver,
			HelpPageObject.class);
	
	
	
	@Then("^I want the \"([^\"]*)\" icon for the Help Center to show up throughout the program$")
	public void i_want_the_icon_for_the_Help_Center_to_show_up_throughout_the_program(String arg1) throws Throwable {
		TeacherHP.verify_help_icon();
		//assertTrue("Help icon is not dipslayed",TeacherHP.verify_help_icon());
		//assertTrue("Need help text  is not dispalyed ",TeacherHP.Tooltiphelplink());
	}

	@When("^I click on the \"([^\"]*)\" icon in the header$")
	public void i_click_on_the_icon_in_the_header(String arg1) throws Throwable {
		System.out.println(TeacherHP.Tooltiphelplink());
	}

	@Then("^a new tab will open with the Help Center page$")
	public void a_new_tab_will_open_with_the_Help_Center_page() throws Throwable {
		TeacherHP.verify_help_link_URL();
		//assertTrue("Help link url is not displayd",TeacherHP.verify_help_link_URL());
	}
}
		
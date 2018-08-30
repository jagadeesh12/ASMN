package com.assessment.stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assessment.pageobjects.BasePage;
import com.assessment.pageobjects.HomePage;
import com.assessment.pageobjects.SlzHomePg;
import com.assessment.pageobjects.SlzLoginPg;
import com.assessment.pageobjects.StudentRosterPageObject;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StudentRoster {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	TestBase testBase = TestBaseProvider.getTestBase();
	BasePage base = new BasePage(driver);
	SlzHomePg slzHome = new SlzHomePg(driver);
	SlzLoginPg slzLogin = new SlzLoginPg(driver);
	StudentRosterPageObject TeacherHP = PageFactory.initElements(this.driver,
			StudentRosterPageObject.class);
	
			
	@When("^I clicked on Reports  tab$")
	public void i_clicked_on_Reports_tab() throws Throwable {
		Thread.sleep(3000);
	    TeacherHP.clickReportstButton();
	}

}


